import { lazy } from "react";
import { Route, Navigate } from "react-router-dom";

import { RoutesWithNotFound } from "../../utilities";

// Lazy imports.
const Profile = lazy(() => import("./profile/Profile"));

function Private() {
  return (
    <RoutesWithNotFound>
      <Route path="/profile" element={<Profile />}></Route>
    </RoutesWithNotFound>
  );
}
export default Private;
