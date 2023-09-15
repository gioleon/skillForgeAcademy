import { Course } from "../model";
import axios, { AxiosResponse } from "axios";

export const createCourse = (course: Course) => {
  return axios
    .post(`${import.meta.env.VITE_APP_API_BASE_URL}/course`, course)
    .then((response: AxiosResponse<number>) => {
      return response.status;
    })
    .catch((error) => {
      return error.response.status;
    });
};

export const getAllCourse = async (): Promise<Course[]> => {
  try {
    const response = await axios.get<Course[]>(`${import.meta.env.VITE_APP_API_BASE_URL}/course/all`);
    return response.data;
  } catch (error) {
    console.error(error);
    throw error;
  }
};


export const getCourseByIdOwner = (id: number) => {
  return axios
    .get(`${import.meta.env.VITE_APP_API_BASE_URL}/course/owner/${id}`)
    .then((response: AxiosResponse<Course[]>) => {
      return response.data;
    })
    .catch((error) => {
      return error.response.status;
    });
};

export const getCourseById = (id: number) => {
  return axios
    .get(`${import.meta.env.VITE_APP_API_BASE_URL}/course/${id}`)
    .then((response: AxiosResponse<Course[]>) => {
      return response.data;
    })
    .catch((error) => {
      return error.response.status;
    });
};
