import { CategoryOA } from "../category";
import { UserOA } from "../user";
export interface courseOA {
  id: number;
  category?: CategoryOA[];
  name?: string;
  owner?: UserOA;
  description?: string;
  urlImage?: string;
}
