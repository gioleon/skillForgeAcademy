import { useParams } from "react-router-dom";

function SuccessfulRegister() {
  const { email } = useParams();

  return (
    <div>
      Bienvenido a Skill Forge Academy! a su correo <b>{email}</b> le hemos
      enviado un enlace para que active su cuenta
    </div>
  );
}
export default SuccessfulRegister;
