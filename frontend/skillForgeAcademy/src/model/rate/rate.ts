import { Course } from "../course";
import { User } from "../user";

export interface Rate {
  course: Course;
  user: User;
  rate: number;
}
