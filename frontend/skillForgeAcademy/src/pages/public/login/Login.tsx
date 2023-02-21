import { login, authenticationKey } from "../../../service";
import { useEffect, useState } from "react";
import { User } from "../../../model/user/user";
import { useDispatch } from "react-redux";
import { setUser, clearUser } from "../../../redux/states/user";
import { clearLocalStorage } from "../../../utilities";
import { LoginError } from "../../../components";
import { useNavigate } from "react-router-dom";
import { PrivateRoutes, UserLogin } from "../../../model";
import { decodeJwt } from "../../../utilities/jwt.utility";

function Login() {

  // As we have some inputs, we'll use useState.
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState(false);

  // Dispatch to execute some actions of our reducer.
  const dispacth = useDispatch();
  const navigate = useNavigate();


  // At the moment to enter to login, we'll delete
  //  a token if exists and reset the user.
  useEffect(() => {
    clearLocalStorage(authenticationKey);
    dispacth(clearUser());
  });


  // Change the default behaviour
  const handleSubmit = (e: any) => {
    e.preventDefault();
  };



  // Login
  const handleClickLogin = (email: string, password: string) => {
    const user: UserLogin = {
      email: email,
      password: password,
    };

    // making login
    login(user);

    // if no exists the token in the local storage it's because user didn't provide the correct credentials.
    if (localStorage.getItem(authenticationKey)) {
      // Redirect to a private page.
      navigate(`/${PrivateRoutes.PRIVATE}/${PrivateRoutes.PROFILE}`, {
        replace: true,
      });

      // decode user and set it to the global state. also, set it in localStorage.
      dispacth(setUser(decodeJwt(localStorage.getItem(authenticationKey)!)));

    } else {
      setError(true);
    }
  };


  return (
    <div>
      <form action="" onSubmit={handleSubmit}>
        <input
          type="text"
          name="email"
          placeholder="username@yourcompany.com"
          onChange={(e) => setEmail(e.target.value)}
        />
        <input
          type="password"
          name="password"
          placeholder="********"
          onChange={(e) => setPassword(e.target.value)}
        />
        <button
          onClick={() => {
            handleClickLogin(email, password);
          }}
        >
          Login
        </button>
      </form>
      <LoginError error={error} />
    </div>
  );
}

export default Login;
