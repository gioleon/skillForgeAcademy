import { login, authenticationKey } from "../../../service";
import { useEffect, useState } from "react";
import { User } from "../../../model/user/user";
import { useDispatch } from "react-redux";
import { setUser, clearUser } from "../../../redux/states/user";
import { clearLocalStorage } from "../../../utilities";
import { Error } from "../../../components";
import { useNavigate } from "react-router-dom";
import { PrivateRoutes, UserLogin } from "../../../model";
import { decodeJwt } from "../../../utilities/jwt.utility";
import { useFormik, yupToFormErrors } from "formik";
import * as Yup from "yup";
import { LoginLayout } from "./styled-components";
import { PublicRoutes } from "../../../model/routes";
import { StyledLink } from "../../../styled-components";

function Login() {
  // As we have some inputs, we'll use useState.
  const [error, setError] = useState(false);
  const [errorMessage, setErrorMessage] = useState("");

  // Dispatch to execute some actions of our reducer.
  const dispacth = useDispatch();
  const navigate = useNavigate();

  // At the moment to enter to login, we'll delete
  //  a token if exists and reset the user.
  useEffect(() => {
    clearLocalStorage(authenticationKey);
    dispacth(clearUser());
  }, []);

  // validations
  const loginSchema = Yup.object().shape({
    email: Yup.string().required(),
    password: Yup.string().required(),
  });

  // form attributes.
  const formik = useFormik({
    initialValues: {
      email: "",
      password: "",
    },
    onSubmit: (values) => {},

    validationSchema: loginSchema,
  });

  // Change the default behaviour
  const handleSubmit = async (e: any) => {
    e.preventDefault();

    if (
      !formik.isValid ||
      formik.values.email === "" ||
      formik.values.password === ""
    ) {
      setError(true);
      setErrorMessage("Por favor llena todos los campos");
      return;
    }

    // create user with the password information.
    const userLogin: UserLogin = {
      email: formik.values.email,
      password: formik.values.password,
    };

    // login return the jwt token if login was successful, otherwise empty string
    const statusCode: number = await login(userLogin);

    // If token is not empty string
    if (statusCode === 200) {
      // decode the token to User
      const user: User = decodeJwt(localStorage.getItem(authenticationKey)!);
      // asssing the user to the global redux state and save it to local storage.
      dispacth(setUser({ ...user }));
      // Redirect to a private page.
      navigate(
        `/${PrivateRoutes.PRIVATE}/${PrivateRoutes.PROFILE}/${user.email}`,
        {
          replace: true,
        }
      );
    } else if (statusCode === 401) {
      setError(true);
      setErrorMessage("Correo o contraseña incorrectos.");
    } else {
      setError(true);
      setErrorMessage("La cuenta proporcionada no ha sido activada.");
    }
  };

  return (
    <>
      <LoginLayout>
        <div className="left-form"></div>
        <div className="right-form">
          <form action="" onSubmit={(e) => handleSubmit(e)}>
            <h1 className="title-login">Bienvenido de vuelta</h1>
            <input
              type="text"
              name="email"
              placeholder="Ingresa tu email"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
            />
            <input
              type="password"
              name="password"
              placeholder="Ingresa tu contraseña"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
            />
            <button>Iniciar sesion</button>
            <div className="login-form-footer">
              <h2 className="title-register">¿No tienes una cuenta?</h2>
              <StyledLink
                to={"/" + PublicRoutes.REGISTER}
                replace
                className="link-register"
              >
                Registrate aqui
              </StyledLink>
            </div>
          </form>
          <Error error={error} message={errorMessage} />
        </div>
      </LoginLayout>
    </>
  );
}

export default Login;
