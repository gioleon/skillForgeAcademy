import { courseOA } from "../course";
import { SectionOA } from "../section";

export interface TutorshipId {
  id: number;
  section: SectionOA;
  course: courseOA;
}
