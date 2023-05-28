import { Course } from "../course";
import { User } from "../user";

export interface Comment {
  id: string;
  course: Course;
  user: User;
  content: string;
}
