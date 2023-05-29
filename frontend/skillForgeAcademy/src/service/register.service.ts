import axios, { HttpStatusCode } from "axios";
import { UserRegister } from "../model";

export const register = (user: UserRegister) => {
  return axios
    .post(`${import.meta.env.VITE_APP_API_BASE_URL}/register`, user)
    .then((response) => {
      return response.status;
    })
    .catch((response) => {
      return HttpStatusCode.Conflict;
    });
};
