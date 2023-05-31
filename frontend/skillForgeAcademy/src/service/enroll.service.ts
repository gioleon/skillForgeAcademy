import axios, { AxiosResponse } from "axios";
import { Inscription } from "../model";

export const enroll = (inscription: Inscription) => {
  return axios
    .post(`${import.meta.env.VITE_APP_API_BASE_URL}/inscription`, inscription)
    .then((response) => {
      return response.status;
    })
    .catch((error) => {
      return error.response.status;
    });
};

export const getUserInscriptions = (id: number) => {
  return axios
    .get(`${import.meta.env.VITE_APP_API_BASE_URL}/inscription/student/${id}`)
    .then((response: AxiosResponse<Inscription[]>) => {
      return response.data;
    })
    .catch((error) => {
      return error.response.status;
    });
};

export const studentIsEnroll = (idStudent: number, idCourse: number) => {
  return axios
    .get(
      `${
        import.meta.env.VITE_APP_API_BASE_URL
      }/inscription/student/${idStudent}/course/${idCourse}`
    )
    .then((response: AxiosResponse<Inscription[]>) => {
      return response.data;
    })
    .catch((error) => {
      return error.response.status;
    });
};


export const getCourseEnrollments = (id: number) => {
  return axios
    .get(`${import.meta.env.VITE_APP_API_BASE_URL}/inscription/course/${id}`)
    .then((response: AxiosResponse<Inscription[]>) => {
      return response.data;
    })
    .catch((error) => {
      return error.response.status;
    });
};
