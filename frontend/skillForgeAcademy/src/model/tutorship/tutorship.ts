import { courseOA } from "../course";
import { SectionOA } from "../section";

export interface Tutorship {
  id?: number;
  section: SectionOA;
  course: courseOA;
  name: string;
  urlVideo: string;
}
