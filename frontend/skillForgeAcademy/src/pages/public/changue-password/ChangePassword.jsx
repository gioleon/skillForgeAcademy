import { useState } from "react";
import { Link, useLocation } from "react-router-dom";
import axios from "axios";
import { PublicRoutes } from "@/model";

function ChangePassword() {
  const [oldPassword, setOldPassword] = useState("");
  const [newPassword, setNewPassword] = useState("");
  const [message, setMessage] = useState("");

  // Extrae el token de la URL
  const searchParams = new URLSearchParams(useLocation().search);
  const token = searchParams.get("token");

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const response = await axios.post(
        `${import.meta.env.VITE_APP_API_BASE_URL}/changePassword`,
        { token, oldPassword, newPassword }
      );

      if (response.status === 200) {
        setMessage("Tu contraseña ha sido cambiada con éxito.");
      } else if (response.status === 401) {
        setMessage("La contraseña antigua no coincide.");
      } else if (response.status === 403) {
        setMessage("Token no válido.");
      } else if (response.status === 404) {
        setMessage("Usuario no encontrado.");
      } else {
        setMessage(
          "Hubo un error al intentar cambiar tu contraseña. Por favor, inténtalo de nuevo."
        );
      }
    } catch (error) {
      setMessage(
        "Hubo un error al intentar cambiar tu contraseña. Por favor, inténtalo de nuevo."
      );
    }
  };

  return (
      <div className="max-w-4xl mx-auto mt-24">
        <div className="flex flex-col items-center justify-center p-4 space-y-4 antialiased text-gray-900">
          <div className="w-full px-8 max-w-lg space-y-6 bg-white rounded-md py-16 bg-gray-100">
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
            <h1 className="mb-6 text-3xl font-bold text-center">
              Cambiar Contraseña
            </h1>
            <form onSubmit={handleSubmit} className="space-y-6 w-full">
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
                  value={oldPassword}
                  onChange={(e) => setOldPassword(e.target.value)}
                  className="mt-1 block w-full p-2 border border-gray-300 rounded-md"
                />
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
                  value={newPassword}
                  onChange={(e) => setNewPassword(e.target.value)}
                  className="mt-1 block w-full p-2 border border-gray-300 rounded-md"
                />
              </div>
              <button
                type="submit"
                className="w-full px-4 py-2 font-medium text-center text-white bg-indigo-600 transition-colors duration-200 rounded-md bg-primary hover:bg-primary-dark focus:outline-none focus:ring-2 focus:ring-primary focus:ring-offset-1"
              >
                Cambiar Contraseña
              </button>
            </form>
            {message && <p className="mt-2 text-sm text-red-600" style={{ minHeight: '1em' }}>{message}</p>}
          </div>
        </div>
      </div>
  );
}

export default ChangePassword;
