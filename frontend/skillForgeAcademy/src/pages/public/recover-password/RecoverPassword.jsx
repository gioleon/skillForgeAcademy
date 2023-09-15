import { useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import { PublicRoutes } from "@/model";

function RecoverPassword() {
  const [email, setEmail] = useState("");
  const [message, setMessage] = useState("");

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const response = await axios.get(
        `${import.meta.env.VITE_APP_API_BASE_URL}/recoverPassword?email=${email}`
      );
      if (response.status === 200) {
        setMessage(
          "Se ha enviado un correo electrónico con instrucciones para recuperar tu contraseña."
        );
      } else if (response.status === 404) {
        setMessage("No se encontró ningún usuario con ese correo electrónico.");
      } else if (response.status === 500) {
        setMessage(
          "Hubo un error en el servidor. Por favor, inténtalo de nuevo más tarde."
        );
      } else {
        setMessage(
          "Hubo un error al intentar recuperar tu contraseña. Por favor, inténtalo de nuevo."
        );
      }
    } catch (error) {
      setMessage(
        "Hubo un error al intentar recuperar tu contraseña. Por favor, inténtalo de nuevo."
      );
    }
  };

  return (
      <div className="max-w-4xl mx-auto mt-24">
        <div className="flex flex-col items-center justify-center p-4 space-y-4 antialiased text-gray-900">
          <div className="w-full px-8 max-w-lg space-y-6 bg-white rounded-md py-16 bg-gray-100">
            <h1 className="mb-6 text-3xl font-bold text-center">
              Forgot password?
            </h1>
            <p className="text-center mx-12">
              Enter your registration email and we will send you instructions to
              reset your password.
            </p>
            <form onSubmit={handleSubmit} className="space-y-6 w-full">
              <input
                className="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring focus:ring-primary-100"
                type="email"
                name="email"
                placeholder="Email address"
                required=""
                value={email}
                onChange={(e) => setEmail(e.target.value)}
              />
              <div>
                <button
                  type="submit"
                  className="w-full px-4 py-2 font-medium text-center text-white bg-indigo-600 transition-colors duration-200 rounded-md bg-primary hover:bg-primary-dark focus:outline-none focus:ring-2 focus:ring-primary focus:ring-offset-1"
                >
                  Send
                </button>
              </div>
            </form>
            {message && <p className="mt-2 text-sm text-red-600">{message}</p>}
            <div className="text-sm text-gray-600 items-center flex justify-between">
              <p className="text-gray-800 cursor-pointer hover:text-blue-500 inline-flex items-center ml-4">
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
                <Link to={`/${PublicRoutes.LOGIN}`}>Back</Link>
              </p>
              <p className="hover:text-blue-500 cursor-pointer">Need help?</p>
            </div>
          </div>
        </div>
      </div>
  );
}

export default RecoverPassword;
