import { courseOA } from "../course";

export interface SectionOA {
  id: string;
  course?: courseOA;
  name?: string;
}
