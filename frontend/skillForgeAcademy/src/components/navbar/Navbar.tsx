import AppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import { PublicRoutes } from "../../model/routes";
import { LogoNavbar, MenuNavbar } from "./components";
import ItemsNavbar from "./components/ItemsNavbar";
import SearchInputNavbar from "./components/SearchInputNavbar";
import SearchModal from "./components/SearchModal";
import { useState, useEffect } from "react";
import { useLocation } from "react-router-dom";

function Navbar() {
  const [hideNavbar, setHideNavbar] = useState(false);
  const [isLocation, setIsLocation] = useState(false);

  const location = useLocation();

  useEffect(() => {
    let isInRegisterOrLogin =
      location.pathname === `/${PublicRoutes.LOGIN}` ||
      location.pathname === `/${PublicRoutes.REGISTER}`
        ? true
        : false;
    setIsLocation(isInRegisterOrLogin);
  });

  return (
    <>
      {!isLocation ? (
        <AppBar position="static">
          <Toolbar
            sx={{
              justifyContent: { xs: "space-between", sm: "space-between" },
            }}
          >
            {/* Menu button */}
            <MenuNavbar />
            {/* Logo */}
            <LogoNavbar />
            {/* Search bar */}
            <SearchInputNavbar displaySettings={{ xs: "none", md: "flex" }} />
            {/* Items */}
            <ItemsNavbar />
            {/* Search modal */}
            <SearchModal />
          </Toolbar>
        </AppBar>
      ) : null}
    </>
  );
}
export default Navbar;
