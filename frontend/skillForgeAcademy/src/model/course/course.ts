import { CategoryOA } from "../category";
import { UserOA } from "../user";
export interface Course {
  id: number;
  category: CategoryOA[];
  name: string;
  owner: UserOA;
  description: string;
  urlImage: string;
}
