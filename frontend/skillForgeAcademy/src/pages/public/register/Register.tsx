import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { PublicRoutes } from "../../../model";


function Register() {
  const [name, setName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");

  const navigate = useNavigate();

  const handleClickSubmit = () => {
    // sending email to successVerification page.

    // other logic....

    // go to successfulRegister page and send email
    navigate(`${PublicRoutes.SUCCESSFUL}`, {state: {"email": email}});
  };

  const handleSubmit = (e: any) => {
    e.preventDefault();
  };

  return (
    <>
      <form action="" method="POST" onSubmit={handleSubmit}>
        <input
          type="text"
          name="name"
          id="name"
          placeholder="Nombres"
          onChange={(e) => setName(e.target.value)}
        />
        <input
          type="text"
          name="lastName"
          id="lastName"
          placeholder="Apellidos"
          onChange={(e) => setLastName(e.target.value)}
        />
        <input
          type="text"
          name="email"
          placeholder="Ingrese su email"
          onChange={(e) => setEmail(e.target.value)}
        />
        <input
          type="password"
          placeholder="Password"
          name="password"
          onChange={(e) => setPassword(e.target.value)}
        />
        <input
          type="password"
          placeholder="Password"
          name="confirmPassword"
          onChange={(e) => setConfirmPassword(e.target.value)}
        />
        <button
          type="submit"
          onClick={() => {
            handleClickSubmit();
          }}
        >
          Register
        </button>
      </form>
    </>
  );
}
export default Register;
