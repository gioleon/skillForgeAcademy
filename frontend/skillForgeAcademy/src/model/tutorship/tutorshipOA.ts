import { courseOA } from "../course";
import { SectionOA } from "../section";

export interface TutorshipOA {
  id: number;
  section?: SectionOA;
  course?: courseOA;
  name?: string;
  urlVideo?: string;
}
