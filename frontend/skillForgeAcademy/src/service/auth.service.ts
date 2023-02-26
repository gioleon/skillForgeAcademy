import axios, { AxiosResponse } from "axios";
import { setLocalStorage } from "../utilities";
import { UserResponse } from '../model/user/userResponse';
import { UserLogin } from "../model";

export const authenticationKey: string = "Authentication";

export const login =  (user: UserLogin) => {
  
  return  axios
    .post(`${import.meta.env.VITE_APP_API_BASE_URL}/login`, user)
    .then((response: AxiosResponse<number>) => {
      // if successful, save token in localstorage.
      setLocalStorage(authenticationKey, response.headers.authentication); 
      // return the token.
      return response.status;
    })
    .catch((error) => {
      // if wrong return the status code of the error.
      return error.response.status;
    });
};
