import { PrivateRoutes, User } from "@/model";
import { useSelector } from "react-redux";
import { AppStore } from "@/redux/store";
import { useDispatch } from "react-redux";
import { clearUser } from "@/redux/states/user";
import { Navigate, Outlet } from "react-router-dom";
import { ReactElement } from "react";
import { PublicRoutes } from "@/model/routes";

export const PublicGuard = () => {
  const user = useSelector((state: AppStore) => state.user);

  /**
   *   checks if there is a user logged, if there's check if it's token is still valid.
   * if the token is already expired, then push to login and close session.
   *
   * if the user is not logged, the user can navigate in public pages with any issues.
   * / */

  return user.email ? (
    user.exp * 1000 < Date.now() ? (
      <Navigate replace to={PublicRoutes.LOGIN} />
    ) : (
      <Outlet />
    )
  ) : (
    <Outlet />
  );
};
