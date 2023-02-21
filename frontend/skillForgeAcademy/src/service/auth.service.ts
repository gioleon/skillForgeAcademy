import axios, { AxiosResponse } from "axios";
import { setLocalStorage } from "../utilities";
import { UserResponse } from '../model/user/userResponse';
import { UserLogin } from "../model";

const baseUrl = "http://localhost:8080/api";
export const authenticationKey: string = "Authentication";

export const login = async (user: UserLogin) => {

  return await axios
    .post(`${baseUrl}/login`, user)
    .then((response: AxiosResponse<UserResponse>) => {
      // if successful, save token in localstorage.
      setLocalStorage(authenticationKey, response.headers.authentication);       
    })
    .catch(() => {
      "CREDENTIALS NOT MATCH";
    });
};
