import { Course } from "../course";
import { User } from "../user";

export interface Inscription {
  course: Course;
  student: User;
}
