import { courseOA } from "../course";
import { SectionOA } from "../section";

export interface TutorshipOA {
  id: string;
  section?: SectionOA;
  course?: courseOA;
  name?: string;
}
