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
import { CourseCard, courses } from "./components/course-card";
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
  const actualUrl: string = window.location.href;
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
            {actualUrl.includes(PublicRoutes.REGISTER) ||
            actualUrl.includes(PublicRoutes.LOGIN) ? undefined : (
              <Navbar />
            )}
            <RoutesWithNotFound>
              {/* public routes */}
              <Route path={PublicRoutes.LOGIN} element={<Login />} />
              <Route path={PublicRoutes.CATEGORIES} element={<Categories />} />

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
                </Route>
                <Route
                  path={`/${PrivateRoutes.PRIVATE}/${PrivateRoutes.PROFILE}/:idUser`}
                  element={<Profile />}
                ></Route>
              </Route>
            </RoutesWithNotFound>
          </BrowserRouter>
        </Provider>
      </Suspense>
    </div>
  );
}

export default App;
