import { Comment} from "../model";
import axios, { AxiosResponse } from "axios";

export const createComment = (comment: Comment) => {
  return axios
    .post(`${import.meta.env.VITE_APP_API_BASE_URL}/comment`, comment)
    .then((response: AxiosResponse<number>) => {
      return response.status;
    })
    .catch((error) => {
      return error.response.status;
    });
};

export const getCommentByIdCourse = (id: number) => {
  return axios
    .get(`${import.meta.env.VITE_APP_API_BASE_URL}/comment/course/${id}`)
    .then((response: AxiosResponse<Comment[]>) => {
      return response.data;
    })
    .catch((error) => {
      return error.response.status;
    });
};


