import { login, authenticationKey } from "../../../service";
import { useEffect, useState } from "react";
import { User } from "../../../model/user/user";
import { useDispatch } from "react-redux";
import { setUser, clearUser } from "../../../redux/states/user";
import { clearLocalStorage } from "../../../utilities";
import { Error } from "../../../components";
import { Link, useNavigate } from "react-router-dom";
import { PrivateRoutes, PublicRoutes, UserLogin } from "../../../model";
import { decodeJwt } from "../../../utilities/jwt.utility";
import { useFormik } from "formik";
import * as Yup from "yup";

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
        `/${PrivateRoutes.PRIVATE}/${PrivateRoutes.PROFILE}/${user.id}`,
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
    <section className="grid h-screen place-content-center bg-login bg-no-repeat bg-cover">
      <form
        action=""
        onSubmit={(e) => handleSubmit(e)}
        className="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4 max-w-xl grid place-content-center"
      >
        <h1 className="text-4xl font-bold text-center p-10">
          Bienvenido de vuelta
        </h1>
        <div className="mb-6">
          <div className="form-control w-full max-w-full">
            <label className="label">
              <span className="label-text">Ingresa tu email</span>
            </label>
            <input
              type="text"
              name="email"
              placeholder="@ejemplo.com"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              className="input input-bordered w-full max-w-full"
            />
          </div>
        </div>
        <div className="mb-6">
          <div className="form-control w-full max-w-full">
            <label className="label">
              <span className="label-text">Ingresa tu contraseña</span>
            </label>
            <input
              type="password"
              name="password"
              placeholder="***********"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              className="input input-bordered w-full max-w-full"
            />
          </div>
        </div>

        <button className="btn btn-block  bg-gray-800 text-white normal-case border-none hover:bg-blue-500">
          Iniciar sesion
        </button>
        <Error error={error} message={errorMessage} />
        <div className="flex justify-between items-center mt-5">
          <h2 className="text-1x0">¿No tienes una cuenta?</h2>
          <Link
            to={`/${PublicRoutes.REGISTER}`}
            className="btn bg-blue-500 normal-case border-none hover:bg-gray-800 hover:text-white "
          >
            Registrate aquí 📝
          </Link>
        </div>
      </form>
    </section>
  );
}

export default Login;
