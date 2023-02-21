import { login, authenticationKey } from "../../../service";
import { useEffect, useState } from "react";
import { User } from "../../../model/user/user";
import { useDispatch } from "react-redux";
import { setUser, clearUser } from "../../../redux/states/user";
import { clearLocalStorage } from "../../../utilities";
import { LoginError } from "../../../components";
import { useNavigate } from "react-router-dom";
import { PrivateRoutes, PublicRoutes, UserLogin } from "../../../model";
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
  }, []);

  // Change the default behaviour
  const handleSubmit = (e: any) => {
    e.preventDefault();
  };

  // Login
  const handleClickLogin = async (email: string, password: string) => {
    const userLogin: UserLogin = {
      email: email,
      password: password,
    };

    // login return the jwt token if login was successful, otherwise empty string
    const token: string = await login(userLogin);

    // If token is not empty string
    if (token) {
      // decode the token to User
      const user: User = decodeJwt(token);
      // asssing the user to the global redux state and save it to local storage.
      dispacth(setUser({ ...user }));
      // Redirect to a private page.
      navigate(`/${PrivateRoutes.PRIVATE}/${PrivateRoutes.PROFILE}`, {
        replace: true,
      });
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
