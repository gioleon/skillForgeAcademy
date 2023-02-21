import { lazy, Suspense, useState } from "react";
import { Provider } from "react-redux";
import { BrowserRouter, Navigate, Route } from "react-router-dom";

import store from "./redux/store";
import { RoutesWithNotFound } from "./utilities";
import { PrivateRoutes, PublicRoutes } from './model/routes';
import { AuthGuard } from "./guard/auth.guard";
import { Home } from "./pages/public";

// lazy imports
const Private = lazy(() => import('./pages/private/Private'))
const Signup = lazy(() => import('./pages/public/signup/Signup'));
const Login = lazy(() => import('./pages/public/login/Login'));


function App() {
  return (
    <div className="App">
      <Suspense fallback={<>Cargando</>}>
        <Provider store={store}>
        <BrowserRouter>
            <RoutesWithNotFound>
              <Route path = "/" element={<Navigate to={`/${PublicRoutes.HOME}`} />}></Route>
              <Route path = {PublicRoutes.HOME}  element={<Home />}></Route>
              <Route path = {PublicRoutes.LOGIN}  element={<Login />}></Route>
              <Route path = {PublicRoutes.SIGNUP} element={<Signup />}></Route>

              <Route element={<AuthGuard privateValidation={true}/>}>
                <Route path={`/${PrivateRoutes.PRIVATE}/*` } element={ <Private/> }> </Route>
              </Route>

            </RoutesWithNotFound>
        </BrowserRouter>
        </Provider>
      </Suspense>
    </div>
  );
}

export default App;
