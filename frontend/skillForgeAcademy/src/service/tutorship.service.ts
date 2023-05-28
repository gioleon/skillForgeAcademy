import axios, { AxiosResponse } from "axios";
import { Tutorship } from "../model";

export const createTutorShip = (tutorship: Tutorship) => {
  return axios
    .post(`${import.meta.env.VITE_APP_API_BASE_URL}/tutorship`, tutorship)
    .then((response: AxiosResponse<number>) => {
      return response.status;
    })
    .catch((error) => {
      return error.response.status;
    });
};

export const getAllTutor = () => {
  return axios
    .get(`${import.meta.env.VITE_APP_API_BASE_URL}/tutorship/all`)
    .then((response: AxiosResponse<Tutorship[]>) => {
      return response.data;
    })
    .catch((error) => {
      return error.response.status;
    });
};
