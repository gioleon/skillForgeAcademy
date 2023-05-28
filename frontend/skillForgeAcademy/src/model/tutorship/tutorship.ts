import { courseOA } from "../course";
import { SectionOA } from "../section";

export interface Tutorship {
  id: string;
  section: SectionOA;
  course: courseOA;
  name: string;
}
