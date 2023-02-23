import { useLocation, useParams } from "react-router-dom";

function SuccessfulRegister() {
  // use useLocation to get the state sent by register page.
  const location = useLocation();

  return (
    <div>
      Bienvenido a Skill Forge Academy! a su correo <b>{location.state.email}</b> le hemos
      enviado un enlace para que active su cuenta
    </div>
  );
}
export default SuccessfulRegister;
