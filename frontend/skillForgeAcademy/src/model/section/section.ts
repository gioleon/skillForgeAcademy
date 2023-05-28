import { courseOA } from "../course";

export interface Section {
  id: string;
  course: courseOA;
  name: string;
}
