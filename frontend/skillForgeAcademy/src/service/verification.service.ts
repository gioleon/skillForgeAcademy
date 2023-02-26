import axios, { AxiosResponse, HttpStatusCode } from "axios";


export const verifyAccount = (token: string) => {
  return axios
    .get(`${import.meta.env.VITE_APP_API_BASE_URL}/register/active?token=` + token)
    .then((response: AxiosResponse<number>) => {
      // if peticion is successful, return http 200 status code.
      return response.status;
    })
    .catch(() => {
      // if peticion fails, return http 400 status code.
      return HttpStatusCode.BadRequest;
    });
};
