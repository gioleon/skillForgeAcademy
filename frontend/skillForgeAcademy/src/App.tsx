import React from "react";
import { lazy, Suspense } from "react";
import { Provider } from "react-redux";
import { BrowserRouter, Navigate, Route, RouteMatch } from "react-router-dom";

import store from "./redux/store";
import { RoutesWithNotFound } from "./utilities";
import { PrivateRoutes, PublicRoutes } from "./model/routes";
import { AuthGuard } from "./guard/auth.guard";
import { ChangePassword, Home, RecoverPassword } from "./pages/public";
import { CircularProgress } from "@mui/material";
import { Navbar } from "./components";
import { PublicGuard } from "./guard/public.guard";
import ViewCourse from "./pages/private/view-course/ViewCourse";
import { Categories } from "./pages/public/categories";
import { AddCourse, AddSection, Profile } from "./pages/private";
import AddTutorship from "./pages/private/profile/components/AddTutorship";
import ViewClass from "./pages/private/view-tutorship/ViewClass";

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
  
  // //Rutas de cursos
  // const courseRoutes = courses.map((course) => (
  //   <Route
  //     key={course.titleCourse}
  //     path={course.titleCourse}
  //     element={<ViewCourse course={course} />}
  //   />
  // ));

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
            {0 ? undefined : <Navbar />}
            <RoutesWithNotFound>
              {/* public routes */}
              <Route path={PublicRoutes.LOGIN} element={<Login />} />
              <Route path={PublicRoutes.CATEGORIES} element={<Categories />} />
              <Route path={PublicRoutes.RECOVER_PASSWORD} element={<RecoverPassword />} />
              <Route path={PublicRoutes.CHANGE_PASSWORD} element={<ChangePassword />} />

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
                  path={`${PublicRoutes.REGISTER}/${PublicRoutes.VERIFICATION}/:token`}
                  element={<Verification />}
                ></Route>

                {/* private routes */}
                <Route element={<AuthGuard privateValidation={true} />}>
                  <Route
                    path={`/${PrivateRoutes.PRIVATE}/:idUser/${PrivateRoutes.COURSE}/:idCourse/${PrivateRoutes.SECTION}`}
                    element={<AddSection />}
                  />
                  <Route
                    path={`/${PrivateRoutes.PRIVATE}/:idUser/${PrivateRoutes.COURSE}/:idCourse/${PrivateRoutes.SECTION}/:idSection/${PrivateRoutes.TUTORSHIP}`}
                    element={<AddTutorship />}
                  />
                  <Route
                    path={`/${PrivateRoutes.PRIVATE}/:idUser/${PrivateRoutes.ADDCOURSE}`}
                    element={<AddCourse />}
                  />
                  <Route
                    path={`/${PrivateRoutes.PRIVATE}/:idUser/${PrivateRoutes.COURSE}/:idCourse`}
                    element={<ViewCourse />}
                  />
                  <Route
                    path={`/${PrivateRoutes.PRIVATE}/:idUser/${PrivateRoutes.COURSE}/:idCourse/${PrivateRoutes.SECTION}/:idSection/${PrivateRoutes.TUTORSHIP}/:idTutorship`}
                    element={<ViewClass />}
                  />
                  <Route
                    path={`/${PrivateRoutes.PRIVATE}/${PrivateRoutes.PROFILE}/:idUser`}
                    element={<Profile />}
                  ></Route>
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
