import { lazy, Suspense } from "react";
import { Provider } from "react-redux";
import { BrowserRouter, Navigate, Route } from "react-router-dom";

import store from "./redux/store";
import { RoutesWithNotFound } from "./utilities";
import { PrivateRoutes, PublicRoutes } from "./model/routes";
import { AuthGuard } from "./guard/auth.guard";
import { Home } from "./pages/public";
import { CircularProgress } from "@mui/material";
import { Navbar } from "./components";
import { PublicGuard } from "./guard/public.guard";

// lazy imports
const Private = lazy(() => import("./pages/private/Private"));
const Register = lazy(() => import("./pages/public/register/Register"));
const Login = lazy(() => import("./pages/public/login/Login"));
const SuccessfulRegister = lazy(
  () => import("./pages/public/register/successfulRegister/SuccessfulRegister")
);
const Verification = lazy(
  () => import("./pages/public/register/verification/Verification")
);

function App() {
  return (
    <div className="App">
      <Suspense
        fallback={
          <>
            <CircularProgress />{" "}
          </>
        }
      >
        <Provider store={store}>
          <BrowserRouter>
            <Navbar />
            <RoutesWithNotFound>
              {/* public routes */}
              <Route path={PublicRoutes.LOGIN} element={<Login />}/>
              <Route element={<PublicGuard />}>
                <Route
                  path="/"
                  element={<Navigate to={`/${PublicRoutes.HOME}`} />}
                ></Route>
                <Route path={PublicRoutes.HOME} element={<Home />}></Route>
                <Route
                  path={PublicRoutes.REGISTER}
                  element={<Register />}
                ></Route>
                <Route
                  path={`${PublicRoutes.REGISTER}/${PublicRoutes.SUCCESSFUL}`}
                  element={<SuccessfulRegister />}
                ></Route>
                <Route
                  path={`${PublicRoutes.REGISTER}/${PublicRoutes.VERIFICATION}/:token?`}
                  element={<Verification />}
                ></Route>
              </Route>
              {/* private routes */}
              <Route element={<AuthGuard privateValidation={true} />}>
                <Route
                  path={`/${PrivateRoutes.PRIVATE}/*`}
                  element={<Private />}
                >
                  {" "}
                </Route>
              </Route>
            </RoutesWithNotFound>
          </BrowserRouter>
        </Provider>
      </Suspense>
    </div>
  );
}

export default App;
