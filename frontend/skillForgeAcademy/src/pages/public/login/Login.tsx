import { login, authenticationKey } from "@/service";
import { useEffect, useState } from "react";
import { User } from "@/model/user/user";
import { useDispatch } from "react-redux";
import { setUser, clearUser } from "@/redux/states/user";
import { clearLocalStorage } from "@/utilities";
import { Link, useNavigate } from "react-router-dom";
import { PrivateRoutes, PublicRoutes, UserLogin } from "@/model";
import { decodeJwt } from "@/utilities/jwt.utility";
import { useFormik } from "formik";
import * as Yup from "yup";
import Alert from "@/components/alert-generic/Alert";

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

  useEffect(() => {
    if (error) {
      const timeout = setTimeout(() => {
        setError(false);
      }, 5000);
      return () => clearTimeout(timeout);
    }
  }, [error]);

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
    onSubmit: (values) => { },

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
        <div className="text-center font-bold my-4">
          <Link to={`/${PublicRoutes.HOME}`} className="text-gray-800 cursor-pointer hover:text-blue-500 inline-flex items-center">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              className="h-5 w-5 mr-2"
              viewBox="0 0 20 20"
              fill="currentColor"
            >
              <path
                fillRule="evenodd"
                d="M7.707 14.707a1 1 0 01-1.414 0l-4-4a1 1 0 010-1.414l4-4a1 1 0 011.414 1.414L5.414 9H17a1 1 0 110 2H5.414l2.293 2.293a1 1 0 010 1.414z"
                clipRule="evenodd"
              />
            </svg>
            Home Back
          </Link>
        </div>

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
              placeholder="Correo electrónico"
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
              placeholder="Contraseña"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              className="input input-bordered w-full max-w-full"
            />
          </div>
        </div>

        <button className="btn btn-block  bg-gray-800 text-white normal-case border-none hover:bg-blue-500">
          Iniciar sesion
        </button>
        {error ? (
          <Alert message={errorMessage} showIcon={true} />
        ) : null}

        <Link className="mt-3 text-red-400" to={`/${PublicRoutes.RECOVER_PASSWORD}`}>Forgot password?</Link>

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
