import { createSlice } from "@reduxjs/toolkit";
import { User } from "../../model/user/user";
import { clearLocalStorage, decodeJwt, setLocalStorage } from "../../utilities";

export const EmptyUser: User = {
  id: 0,
  name: "",
  lastName: "",
  email: "",
  roles: [],
  exp: 0,
};

export const UserKey: string = "user";

export const UserSlice = createSlice({
  name: "user",
  initialState: localStorage.getItem("Authentication")
    ? decodeJwt(localStorage.getItem("Authentication")!)
    : EmptyUser,
  reducers: {
    setUser: (state, action) => {
      setLocalStorage<string>("user", action.payload);
      return action.payload;
    },
    clearUser: () => {
      clearLocalStorage("user");
      return EmptyUser;
    },
  },
});

export const { setUser, clearUser } = UserSlice.actions;
export default UserSlice.reducer;
