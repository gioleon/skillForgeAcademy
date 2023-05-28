import axios, { AxiosResponse } from "axios";
import { Category } from "../model";

export const createCategory = (category: Category) => {
  return axios
    .post(`${import.meta.env.VITE_APP_API_BASE_URL}/category`, category)
    .then((response: AxiosResponse<number>) => {
      return response.status;
    })
    .catch((error) => {
      return error.response.status;
    });
};

export const getAllCategory = () => {
  return axios
    .get(`${import.meta.env.VITE_APP_API_BASE_URL}/category/all`)
    .then((response: AxiosResponse<Category[]>) => {
      return response.data;
    })
    .catch((error) => {
      return error.response.status;
    });
};
