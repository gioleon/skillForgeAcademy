import React, { useState } from "react";
import axios from "axios";
import { useFormik } from "formik";
import * as Yup from "yup";
import { Link, useLocation } from "react-router-dom";
import { PublicRoutes } from "@/model";
import Alert from "@/components/alert-generic/Alert";

const validationSchema = Yup.object({
  oldPassword: Yup.string()
    .required("La contraseña antigua es obligatoria"),
    
  newPassword: Yup.string()
    .required("La nueva contraseña es obligatoria")
    .matches(/[A-Z]+/, "La contraseña debe tener al menos una letra mayúscula")
    .matches(/[a-z]+/, "La contraseña debe tener al menos una letra minúscula")
    .matches(/[0-9]+/, "La contraseña debe tener al menos un número")
    .min(8, "La contraseña debe tener al menos 8 caracteres"),
});

const ChangePassword = () => {
  const [message, setMessage] = useState("");

  const searchParams = new URLSearchParams(useLocation().search);
  const token = searchParams.get("token");

  const handleSubmit = async (values) => {
    const messages = {
      200: "Tu contraseña ha sido cambiada con éxito.",
      401: "La contraseña antigua no coincide.",
      403: "Token no válido.",
      404: "Usuario no encontrado.",
      default: "Hubo un error al intentar cambiar tu contraseña. Por favor, inténtalo de nuevo."
    };

    try {
      const response = await axios
        .post(`${import.meta.env.VITE_APP_API_RECOVER_PASSWORD_URL}/changePassword`, {
          token,
          oldPassword: values.oldPassword,
          newPassword: values.newPassword
        });
      setMessage(messages[response.status]);
    } catch (err) {
      if (err.response !== undefined) {
        setMessage(messages[err.response.status] || messages.default);
      } else {
        setMessage(messages.default);
      }
    }
  };

  const formik = useFormik({
    initialValues: {
      oldPassword: "",
      newPassword: ""
    },
    validationSchema,
    onSubmit: handleSubmit,
  });

  return (
    <div className="max-w-4xl mx-auto mt-24">
      <div className="flex flex-col items-center justify-center p-4 space-y-4 antialiased text-gray-900">
        <div className="w-full px-8 max-w-lg space-y-6 bg-white rounded-md py-16 bg-gray-100">
          <div className="text-center font-bold my-4">
            <Link
              to={`/${PublicRoutes.HOME}`}
              className="text-gray-800 cursor-pointer hover:text-blue-500 inline-flex items-center"
            ><svg
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
          <h1 className="mb-6 text-3xl font-bold text-center">
            Cambiar Contraseña
          </h1>
          <form onSubmit={formik.handleSubmit} className="space-y-6 w-full">
            <div>
              <label
                htmlFor="old-password"
                className="block text-sm font-medium text-gray-700"
              >
                Contraseña Antigua
              </label>
              <input
                id="old-password"
                type="password"
                {...formik.getFieldProps("oldPassword")}
                className="mt-1 block w-full p-2 border border-gray-300 rounded-md"
              />
              {formik.touched.oldPassword && formik.errors.oldPassword ? (
                <Alert message={formik.errors.oldPassword} showIcon={true} type="error" />
              ) : null}
            </div>
            <div>
              <label
                htmlFor="new-password"
                className="block text-sm font-medium text-gray-700"
              >
                Nueva Contraseña
              </label>
              <input
                id="new-password"
                type="password"
                {...formik.getFieldProps("newPassword")}
                className="mt-1 block w-full p-2 border border-gray-300 rounded-md"
              />
              {formik.touched.newPassword && formik.errors.newPassword ? (
                <Alert message={formik.errors.newPassword} showIcon={true} type="error" />
              ) : null}
            </div>
            <button
              type="submit"
              className="w-full px-4 py-2 font-medium text-center text-white bg-indigo-600 transition-colors duration-200 rounded-md bg-primary hover:bg-primary-dark focus:outline-none focus:ring-2 focus:ring-primary focus:ring-offset-1"
            >
              Cambiar Contraseña
            </button>
          </form>
          {message && (
            <Alert message={message} showIcon={true} type="error" />
          )}
        </div>
      </div>
    </div>
  );
};

export default ChangePassword;
