import AppBar from "@mui/material/AppBar";
import IconButton from "@mui/material/IconButton";
import Toolbar from "@mui/material/Toolbar";
import { AccountCircle, Public } from "@mui/icons-material";
import { Box, Button, Menu, MenuItem, Typography } from "@mui/material";
import { PublicRoutes } from "../../model/routes";
import { StyledLink } from "../../styled-components/StyledLink.style.component";
import { SearchInputWrapper, StyledButton, StyledInputBase } from "./styled-components";
import { LogoNavbar, MenuNavbar } from "./components";
import ItemsNavbar from "./components/ItemsNavbar";
import SearchInputNavbar from './components/SearchInputNavbar';
import SearchModal from './components/SearchModal';


function Navbar() {


  return (
    <AppBar position="static">
      <Toolbar sx={{justifyContent: {xs: "space-between", sm: "space-between"}}}>
        {/* Menu button */}
        <MenuNavbar/>
        {/* Logo */}
        <LogoNavbar/>
        {/* Search bar */}
        <SearchInputNavbar />
        {/* Items */}
        <ItemsNavbar/>
        {/* Search modal */}
        <SearchModal />
      </Toolbar>
    </AppBar>
  );
}
export default Navbar;
