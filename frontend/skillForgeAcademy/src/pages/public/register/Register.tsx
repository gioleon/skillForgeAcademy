import { useFormik } from "formik";
import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { PublicRoutes, UserRegister } from "@/model";
import * as Yup from "yup";
import { register } from "@/service";
import Alert from "@/components/alert-generic/Alert";

function Register() {
  const [inputErrors, setInputErrors] = useState(false);
  const [userExists, setUserExists] = useState(false);
  const [submitAttempted, setSubmitAttempted] = useState(false);
  const completeAllFieldsMessage = "Por favor, complete todos los campos";
  const accountExistsMessage = "Este correo electrónico ya está registrado";


  // getting an instance of useNavigate
  const navigate = useNavigate();

  // validation for form
  const registerSchema = Yup.object().shape({
    name: Yup.string()
      .min(2, "El nombre es muy corto")
      .max(50, "El nombre es muy largo")
      .required("El nombre es un campo requerido"),
    lastName: Yup.string()
      .min(2, "El apellido es muy corto")
      .max(50, "El apellido es muy largo")
      .required("El apellido es un campo requerido"),
    email: Yup.string()
      .matches(
        /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/,
        "Por favor, proporcione un email válido"
      )
      .required("El email es un campo requerido"),
    password: Yup.string()
      .required("La contraseña es un campo requerido")
      .matches(/[A-Z]+/, "La contraseña debe tener al menos una letra mayúscula")
      .matches(/[a-z]+/, "La contraseña debe tener al menos una letra minúscula")
      .matches(/[0-9]+/, "La contraseña debe tener al menos un número")
      .min(8, "La contraseña debe tener al menos 8 caracteres"),
    confirmPassword: Yup.string().oneOf(
      [Yup.ref("password")],
      "Las contraseñas no coinciden"
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

    onSubmit: (values) => { },

    validationSchema: registerSchema,
  });

  useEffect(() => {
    let timeout: number | undefined;
    if (inputErrors || userExists) {
      timeout = setTimeout(() => {
        setInputErrors(false);
        setUserExists(false);
      }, 3500);
    }
    return () => clearTimeout(timeout);
  }, [inputErrors, userExists]);


  const handleSubmit = async (e: any) => {
    e.preventDefault();
    setSubmitAttempted(true);

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
              placeholder="Nombre"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              className="input input-bordered w-full max-w-full"
            />
            {formik.errors.name ? (
              <Alert message={formik.errors.name} />
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
              placeholder="Apellido"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              className="input input-bordered w-full max-w-full"
            />
            {formik.errors.lastName && formik.touched.lastName ? (
              <Alert message={formik.errors.lastName} />
            ) : null}
          </div>
        </div>
        <label className="label">
          <span className="label-text">Ingrese su email</span>
        </label>
        <input
          type="text"
          name="email"
          placeholder="Correo electrónico"
          onChange={formik.handleChange}
          onBlur={formik.handleBlur}
          className="input input-bordered w-full max-w-full"
        />
        {formik.errors.email && formik.touched.email ? (
          <Alert message={formik.errors.email} />
        ) : null}
        <div className="flex-col sm:flex justify-between">
          <div>
            <label className="label">
              <span className="label-text">Contraseña</span>
            </label>
            <input
              type="password"
              placeholder="Contraseña"
              name="password"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              className="input input-bordered w-full max-w-full"
            />
            {formik.errors.password && formik.touched.password ? (
              <Alert message={formik.errors.password} />
            ) : null}
          </div>
          <div>
            <label className="label">
              <span className="label-text">Confirmar contraseña</span>
            </label>
            <input
              type="password"
              placeholder="Confirmar contraseña"
              name="confirmPassword"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              className="input input-bordered w-full max-w-full"
            />
            {formik.errors.confirmPassword && formik.touched.confirmPassword ? (
              <Alert message={formik.errors.confirmPassword} />
            ) : null}
          </div>
        </div>

        <button
          type="submit"
          className="btn btn-block  bg-gray-800 text-white normal-case border-none hover:bg-blue-500 mt-5"
        >
          Regístrate
        </button>
        {inputErrors && submitAttempted ? (
          <Alert message={completeAllFieldsMessage} showIcon={true} />
        ) : null}

        {userExists ? (
          <Alert message={accountExistsMessage} showIcon={true} />
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
