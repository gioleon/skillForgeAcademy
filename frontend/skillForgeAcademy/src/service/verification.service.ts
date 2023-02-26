import axios, { AxiosResponse, HttpStatusCode } from "axios";


export const verifyAccount = (token: string) => {
  return axios
    .get(`${import.meta.env.VITE_APP_API_BASE_URL}/register/active?token=` + token)
    .then((response: AxiosResponse<number>) => {
      // if peticion is successful, return http 200 status code, otherwise return null
      console.log("status from service: " + response.status);
    })
    .catch(() => {
      return HttpStatusCode.BadRequest;
    });
};
