import axios, { AxiosResponse } from "axios";
import { Rate } from "../model";



export const getCourseRates = (id: number) => {
    return axios
      .get(`${import.meta.env.VITE_APP_API_BASE_URL}/rate/course/${id}`)
      .then((response: AxiosResponse<Rate[]>) => {
        return response.data;
      })
      .catch((error) => {
        return error.response.status;
      });
  };