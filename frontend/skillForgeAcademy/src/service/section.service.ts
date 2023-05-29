import axios, { AxiosResponse } from "axios";
import { Section } from "../model";

export const createSection = (section: Section) => {
  return axios
    .post(`${import.meta.env.VITE_APP_API_BASE_URL}/section`, section)
    .then((response: AxiosResponse<Section>) => {
      return response;
    })
    .catch((error) => {
      return error.response.status;
    });
};

export const getAllSection = () => {
  return axios
    .get(`${import.meta.env.VITE_APP_API_BASE_URL}/section/all`)
    .then((response: AxiosResponse<Section[]>) => {
      return response.data;
    })
    .catch((error) => {
      return error.response.status;
    });
};
