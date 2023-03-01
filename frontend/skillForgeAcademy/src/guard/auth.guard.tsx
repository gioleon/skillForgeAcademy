import { useSelector } from "react-redux";
import { AppStore } from "../redux/store";
import { Outlet, Navigate } from "react-router-dom";
import { PrivateRoutes, PublicRoutes } from "../model/routes";

interface Props {
  privateValidation: boolean;
}

const privateValidationFragment = <Outlet />;
const publicValidationFragment = (
  <Navigate replace to={PrivateRoutes.PRIVATE} />
);

export const AuthGuard = ({ privateValidation }: Props) => {
  const user = useSelector((store: AppStore) => store.user);

  return !((user.exp * 1000) < Date.now()) ?(
    privateValidation ? (
      privateValidationFragment
    ) : (
      publicValidationFragment
    )
  ) : (
    <Navigate replace to={PublicRoutes.LOGIN} />
  );
};
