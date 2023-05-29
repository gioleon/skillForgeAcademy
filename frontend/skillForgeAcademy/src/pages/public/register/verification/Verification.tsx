import { useParams } from "react-router-dom";
import { verifyAccount } from "../../../../service";
import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import { PublicRoutes } from "../../../../model";

function Verification() {
  const [message, setMessage] = useState("");
  const titulo = "¡Hola!👋";

  // token is the optional parameter in our url.
  let { token } = useParams();

  // verify is token is null to show something related to that.
  if (token === null)
    setMessage(
      "El enlace de activacion es incorrecto. \
      Por favor verifique que el enlace \
      es exactamente igual al enviado a su correo electronico"
    );

  //if token is not null, excecute the use effect.
  useEffect(() => {
    // call de function define in verification.service.ts
    const verify = async () => {
      const response = await verifyAccount(token!);

      // the other alternative is 400 bad request error.
      if (response === 200) {
        // successful result. 200 code
        setMessage("Bienvenido a Skill Forge Academy!");
      } else {
        // failed result.
        setMessage(
          " El enlace de activacion no es valido, ya expiro o su cuenta ya ha sido activada."
        );
      }
    };

    verify();
  }, []);

  // responses.
  return (
    <div className="hero min-h-screen bg-base-200">
      <div className="hero-content text-center">
        <div className="max-w-md">
          <h1 className="text-5xl font-bold">{titulo}</h1>
          <p className="py-6 text-left">{message}</p>
          {message ===
            "El enlace de activacion es incorrecto. \
             Por favor verifique que el enlace \
             es exactamente igual al enviado a su correo electronico" ||
          message ===
            " El enlace de activacion no es valido, ya expiro o su cuenta ya ha sido activada." ? (
            <Link
              to={`/${PublicRoutes.HOME}`}
              className="btn bg-blue-500 normal-case border-none hover:bg-gray-800 hover:text-white"
            >
              Regresar al inicio
            </Link>
          ) : (
            <Link
              to={`/${PublicRoutes.LOGIN}`}
              className="btn bg-blue-500 normal-case border-none hover:bg-gray-800 hover:text-white"
            >
              Inicia sesión
            </Link>
          )}
        </div>
      </div>
    </div>
  );
}

export default Verification;
