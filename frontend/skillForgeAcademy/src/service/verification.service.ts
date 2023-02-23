import axios, { AxiosResponse, HttpStatusCode } from "axios";

const baseUrl = "http://localhost:8080/api/register/active?token=";

export const verifyAccount = (token: string) => {
  return axios
    .get(baseUrl + token)
    .then((response: AxiosResponse<number>) => {
      // if peticion is successful, return http 200 status code, otherwise return null
      return response.status
    })
    .catch(() => {
      return HttpStatusCode.BadRequest;
    });
};
