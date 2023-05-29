import { courseOA } from "../course";

export interface Section {
  id?: number;
  course: courseOA;
  name: string;
}
