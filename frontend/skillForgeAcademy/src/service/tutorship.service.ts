import axios, { AxiosResponse } from "axios";
import { Tutorship } from "../model";
import { TutorshipId } from "../model/tutorship/tutorshipId";
import { setLocalStorage } from "@/utilities";

export const tutorshipKey = "tutorship"

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

export const getAllTutorship = () => {
  return axios
    .get(`${import.meta.env.VITE_APP_API_BASE_URL}/tutorship/all`)
    .then((response: AxiosResponse<Tutorship[]>) => {
      return response.data;
    })
    .catch((error) => {
      return error.response.status;
    });
};

export const getTutorshipById = (id: TutorshipId) => {
  return axios
    .get(
      `${import.meta.env.VITE_APP_API_BASE_URL}/tutorship/${id.course.id}/${
        id.section.id
      }/${id.id}`
    )
    .then((response: AxiosResponse<Tutorship>) => {
      setLocalStorage(tutorshipKey, response.data)
      return 200;
    })
    .catch((error) => {
      return error.response.status;
    });
};

export const getAllTutorShipsByCourseId = (id: number) => {
  return axios
    .get(`${import.meta.env.VITE_APP_API_BASE_URL}/tutorship/course/${id}`)
    .then((response: AxiosResponse<Tutorship[]>) => {
      return response.data;
    })
    .catch((error) => {
      return error.response.status;
    });
};
