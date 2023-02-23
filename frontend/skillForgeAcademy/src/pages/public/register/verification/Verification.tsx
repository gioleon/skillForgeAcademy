import { useParams } from "react-router-dom";
import { verifyAccount } from "../../../../service";
import { useState, useEffect } from "react";

function Verification() {
  // isVerified will manage the return in our page.
  const [isVerified, setIsVerified] = useState(true);

  // token is the optional parameter in our url.
  let { token } = useParams();

  // verify is token is null to show something related to that.
  if (token == null) {
    return (
      <>
        <p>
          El enlace de activacion es incorrecto. Por favor verifique que el
          enlace es exactamente igual al enviado a su correo electronico
        </p>
      </>
    );
  }

  //if token is not null, excecute the use effect.
  useEffect(() => {
    // call de function define in verification.service.ts
    const verify = async () => {
      const response = await verifyAccount(token!);

      // the other alternative is 400 bad request error.
      if (response === 200) {
        setIsVerified(true); // successful result. 200 code
      } else {
        setIsVerified(false); // failed result.
      }
    };

    verify();
  }, []);


  // responses.
  const successfulResponse = <p>Bienvenido a Skill Forge Academy!</p>;
  const failedResponse = (
    <p>
      El enlace de activacion no es valido, el enlace ya expiro o su cuenta ya
      ha sido activada.
    </p>
  );

  return isVerified ? successfulResponse : failedResponse;
}

export default Verification;
