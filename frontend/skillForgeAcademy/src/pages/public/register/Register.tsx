import { useFormik } from "formik";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { PublicRoutes, UserRegister } from "../../../model";
import * as Yup from "yup";
import { register } from "../../../service";
import { Error } from "../../../components";
import { LayoutRegister } from "./styled-components";

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
      .required("Nombre es requerido"),
    lastName: Yup.string()
      .min(2, "Apellido muy corto")
      .max(50, "Apellido muy largo")
      .required("Apellido es requerido"),
    email: Yup.string()
      .matches(
        /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/,
        "Proporcione un email valido"
      )
      .required("Email es requerido"),
    password: Yup.string()
      .required("Contraseña es requerida")
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
    <>
      <LayoutRegister>
        <div className="left-form">
          <form
            action=""
            method="POST"
            onSubmit={(e) => {
              handleSubmit(e);
            }}
          >
            <h1 className="title-register">Regístrate</h1>
            <input
              type="text"
              name="name"
              id="name"
              placeholder="Nombres"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
            />
            {formik.errors.name ? (
              <Error error={true} message={formik.errors.name} />
            ) : null}

            <input
              type="text"
              name="lastName"
              id="lastName"
              placeholder="Apellidos"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
            />
            {formik.errors.lastName && formik.touched.lastName ? (
              <Error error={true} message={formik.errors.lastName} />
            ) : null}
            <input
              type="text"
              name="email"
              placeholder="Ingrese su email"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
            />
            {formik.errors.email && formik.touched.email ? (
              <Error error={true} message={formik.errors.email} />
            ) : null}
            <input
              type="password"
              placeholder="Contraseña"
              name="password"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
            />
            {formik.errors.password && formik.touched.password ? (
              <Error error={true} message={formik.errors.password} />
            ) : null}
            <input
              type="password"
              placeholder="Confirmar contraseña"
              name="confirmPassword"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
            />
            {formik.errors.confirmPassword && formik.touched.confirmPassword ? (
              <Error error={true} message={formik.errors.confirmPassword} />
            ) : null}
            <button type="submit">Regístrate</button>
            {inputErrors ? (
              <p>Diligencie todos lo campos correctamente</p>
            ) : null}
            {userExists ? <p>Ya existe una cuenta con el correo</p> : null}
          </form>
        </div>
        <div className="right-form"></div>
      </LayoutRegister>
    </>
  );
}
export default Register;
