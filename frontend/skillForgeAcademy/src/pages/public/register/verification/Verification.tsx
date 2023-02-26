import { useParams } from "react-router-dom";
import { verifyAccount } from "../../../../service";
import { useState, useEffect } from "react";

function Verification() {
  const [message, setMessage] = useState("");

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
  return <p>{message}</p>;
}

export default Verification;
