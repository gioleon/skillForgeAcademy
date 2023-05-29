import { courseOA } from "../course";

export interface SectionOA {
  id: number;
  course?: courseOA;
  name?: string;
}
