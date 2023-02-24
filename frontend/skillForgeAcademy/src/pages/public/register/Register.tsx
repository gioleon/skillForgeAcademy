import { ErrorSharp } from "@mui/icons-material";
import { useFormik } from "formik";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { PublicRoutes, UserRegister } from "../../../model";
import * as Yup from "yup";
import { register } from "../../../service";

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
      .matches(
        /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})/,
        "Contraseña no valida"
      ),
    confirmPassword: Yup.string().oneOf(
      [Yup.ref("password")],
      "Las contraseñas no coinciden"
    ),
  });

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

  const handleOnClick = async () => {
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
      <form
        action=""
        method="POST"
        onSubmit={(e) => {
          e.preventDefault();
          formik.handleSubmit;
        }}
      >
        <div>
          <label htmlFor="name">
            {formik.errors.name && formik.touched.name ? (
              <div>{formik.errors.name}</div>
            ) : (
              "Nombre"
            )}
          </label>

          <input
            type="text"
            name="name"
            id="name"
            placeholder="Nombres"
            onChange={formik.handleChange}
            onBlur={formik.handleBlur}
          />
        </div>

        <div>
          <label htmlFor="lastName">
            {formik.errors.lastName && formik.touched.lastName
              ? formik.errors.lastName
              : "Apellido"}
          </label>

          <input
            type="text"
            name="lastName"
            id="lastName"
            placeholder="Apellidos"
            onChange={formik.handleChange}
            onBlur={formik.handleBlur}
          />
        </div>

        <div>
          <label htmlFor="email">
            {formik.errors.email && formik.touched.email
              ? formik.errors.email
              : "Email"}
          </label>

          <input
            type="text"
            name="email"
            placeholder="Ingrese su email"
            onChange={formik.handleChange}
            onBlur={formik.handleBlur}
          />
        </div>
        <div>
          <label htmlFor="password">
            {formik.errors.password && formik.touched.password
              ? formik.errors.password
              : "Contraseña"}
          </label>
          <input
            type="password"
            placeholder="Password"
            name="password"
            onChange={formik.handleChange}
            onBlur={formik.handleBlur}
          />
          <p>
            La contraseña debe ser mayor a 8 caracteres y tener al menos una
            letra mayuscula,una minuscula, un caracter especial y un numero
          </p>
        </div>
        <div>
          <label htmlFor="confirmPassword">
            {formik.errors.confirmPassword && formik.touched.confirmPassword
              ? formik.errors.confirmPassword
              : "Confirmar contraseña"}
          </label>
          <input
            type="password"
            placeholder="Password"
            name="confirmPassword"
            onChange={formik.handleChange}
            onBlur={formik.handleBlur}
          />
        </div>
        <button type="submit" onClick={() => handleOnClick()}>
          Register
        </button>
        {inputErrors ? <p>Diligencie todos lo campos correctamente</p> : null}
        {userExists ? <p>Ya existe una cuenta con el correo</p> : null}
      </form>
    </>
  );
}
export default Register;
