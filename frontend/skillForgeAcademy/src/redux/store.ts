import { configureStore } from "@reduxjs/toolkit";

import UserReducer from "./states/user";
import { User } from "../model";

export interface AppStore {
  user: User;
}

export default configureStore<AppStore>({
  reducer: {
    user: UserReducer,
  },
});
