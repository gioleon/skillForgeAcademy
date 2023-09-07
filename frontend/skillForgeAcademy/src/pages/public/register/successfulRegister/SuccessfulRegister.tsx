import { Link, useLocation, useParams } from "react-router-dom";
import { PublicRoutes } from "@/model";

function SuccessfulRegister() {
  // use useLocation to get the state sent by register page.
  const location = useLocation();
  const titulo = "¡Hola!👋";

  return (
    <div className="hero min-h-screen bg-base-200">
      <div className="hero-content text-center">
        <div className="max-w-md">
          <h1 className="text-5xl font-bold">{titulo}</h1>
          <p className="py-6 text-left">
            Bienvenido a Skill Forge Academy! a su correo
            <b className="before:content-['📤']">{location.state.email}</b> le
            hemos enviado un enlace para que active su cuenta
          </p>
          <Link
            to={`/${PublicRoutes.HOME}`}
            className="btn bg-blue-500 normal-case border-none hover:bg-gray-800 hover:text-white"
          >
            Regresar al inicio
          </Link>
        </div>
      </div>
    </div>
  );
}
export default SuccessfulRegister;
