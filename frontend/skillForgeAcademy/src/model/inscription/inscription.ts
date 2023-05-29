import { courseOA } from "../course";
import { UserOA } from "../user";

export interface Inscription {
  course: courseOA;
  student: UserOA;
}
