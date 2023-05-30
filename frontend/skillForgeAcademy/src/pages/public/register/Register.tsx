import { useFormik } from "formik";
import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { PublicRoutes, UserRegister } from "../../../model";
import * as Yup from "yup";
import { register } from "../../../service";
import { Error } from "../../../components";

function Register() {
  const [inputErrors, setInputErrors] = useState(false);
  const [userExists, setUserExists] = useState(false);

  // getting an instance of useNavigate
  const navigate = useNavigate();

  // validation for form
  const registerSchema = Yup.object().shape({
    name: Yup.string()
      .min(2, "Nombre muy corto")
      .max(50, "Nombre muy largo")
      .required("Nombre es requerido ⬆️"),
    lastName: Yup.string()
      .min(2, "Apellido muy corto")
      .max(50, "Apellido muy largo")
      .required("Apellido es requerido ⬆️"),
    email: Yup.string()
      .matches(
        /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/,
        "Proporcione un email valido ✖️"
      )
      .required("Email es requerido ⬆️"),
    password: Yup.string()
      .required("Contraseña es requerida ⬆️")
      // .matches(
      //   /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})/,
      //   "Contraseña no valida"
      // ),
      .matches(/[A-Z]+/, "debe tener una mayuscula")
      .matches(/[a-z]+/, "debe tener una minuscula")
      .matches(/[0-9]+/, "debe tener al menos un numero")
      .min(8, "contraseña debe tener mas de 8 caracteres"),
    confirmPassword: Yup.string().oneOf(
      [Yup.ref("password")],
      "Las contraseñas no coinciden 🚩"
    ),
  });

  // form attributes
  const formik = useFormik({
    initialValues: {
      name: "",
      lastName: "",
      email: "",
      password: "",
      confirmPassword: "",
    },

    onSubmit: (values) => {},

    validationSchema: registerSchema,
  });

  const handleSubmit = async (e: any) => {
    e.preventDefault();

    // check if all fields fullfill the validations.
    // also avoiding clicking the button before interact with the input fields.
    if (!formik.isValid || formik.values.email.length === 0) {
      setInputErrors(true);

      return;
    }

    // if pass that validation, all fields are valid.
    setInputErrors(false);

    // If all fields are validated then let's proceed to try to save user in the database.

    // user
    const user: UserRegister = {
      name: formik.values.name,
      lastName: formik.values.lastName,
      email: formik.values.email,
      password: formik.values.password,
    };

    // give the user to the method.
    const response = await register(user);

    if (response === 409) {
      setUserExists(true);
    } else if (response === 201) {
      // if everything is excelent, go the the register/sucessful page.
      navigate(`${PublicRoutes.SUCCESSFUL}`, {
        state: { email: formik.values.email },
      });
    }
  };

  return (
    <section className="grid h-screen place-content-center bg-register bg-no-repeat bg-cover">
      <form
        action=""
        method="POST"
        onSubmit={(e) => {
          handleSubmit(e);
        }}
        className="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4 max-w-xl grid place-content-center"
      >
        <h1 className="text-2xl font-bold p-9 ">
          Rellena tus datos para registrarte
        </h1>
        <div className="flex-col sm: justify-between">
          <div>
            <label className="label">
              <span className="label-text">Ingresa tu nombre</span>
            </label>
            <input
              type="text"
              name="name"
              id="name"
              placeholder="Ej: Roy"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              className="input input-bordered w-full max-w-full"
            />
            {formik.errors.name ? (
              <Error error={true} message={formik.errors.name} />
            ) : null}
          </div>
          <div>
            <label className="label">
              <span className="label-text">Ingresa tu apellido</span>
            </label>
            <input
              type="text"
              name="lastName"
              id="lastName"
              placeholder="Apellidos"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              className="input input-bordered w-full max-w-full"
            />
            {formik.errors.lastName && formik.touched.lastName ? (
              <Error error={true} message={formik.errors.lastName} />
            ) : null}
          </div>
        </div>
        <label className="label">
          <span className="label-text">Ingrese su email</span>
        </label>
        <input
          type="text"
          name="email"
          placeholder="Ej: @hola.com"
          onChange={formik.handleChange}
          onBlur={formik.handleBlur}
          className="input input-bordered w-full max-w-full"
        />
        {formik.errors.email && formik.touched.email ? (
          <Error error={true} message={formik.errors.email} />
        ) : null}
        <div className="flex-col sm:flex justify-between">
          <div>
            <label className="label">
              <span className="label-text">Contraseña</span>
            </label>
            <input
              type="password"
              placeholder="******"
              name="password"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              className="input input-bordered w-full max-w-full"
            />
            {formik.errors.password && formik.touched.password ? (
              <Error error={true} message={formik.errors.password} />
            ) : null}
          </div>
          <div>
            <label className="label">
              <span className="label-text">Confirmar contraseña</span>
            </label>
            <input
              type="password"
              placeholder="******"
              name="confirmPassword"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              className="input input-bordered w-full max-w-full"
            />
            {formik.errors.confirmPassword && formik.touched.confirmPassword ? (
              <Error error={true} message={formik.errors.confirmPassword} />
            ) : null}
          </div>
        </div>

        <button
          type="submit"
          className="btn btn-block  bg-gray-800 text-white normal-case border-none hover:bg-blue-500 mt-5"
        >
          Regístrate
        </button>
        {inputErrors ? (
          <p className="text-xs">Diligencie todos lo campos correctamente</p>
        ) : null}
        {userExists ? (
          <p className="text-xs">Ya existe una cuenta con el correo</p>
        ) : null}
        <div className="flex justify-between items-center mt-5">
          <h2 className="text-1x0">¿Ya tienes una cuenta?</h2>
          <Link
            to={`/${PublicRoutes.LOGIN}`}
            className="btn bg-blue-500 normal-case border-none hover:bg-gray-800 hover:text-white "
          >
            Ingresa aquí 📝
          </Link>
        </div>
      </form>
    </section>
  );
}
export default Register;
