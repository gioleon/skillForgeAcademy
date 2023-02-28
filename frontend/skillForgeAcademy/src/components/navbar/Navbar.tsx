import InputBase from "@mui/material/InputBase";
import AppBar from "@mui/material/AppBar";
import IconButton from "@mui/material/IconButton";
import Toolbar from "@mui/material/Toolbar";
import MenuIcon from "@mui/icons-material/Menu";
import { AccountCircle, Public } from "@mui/icons-material";
import { Box, Button, Menu, MenuItem, Typography } from "@mui/material";
import { StyledButton } from "../../styled-components/navbar";
import { StyledInputBase, SearchInputWrapper } from "../../styled-components";
import { Link } from "react-router-dom";
import { PublicRoutes } from "../../model/routes";
import { MouseEvent, useState } from "react";
import { StyledLink } from "../../styled-components/StyledLink.style.component";

function Navbar() {
  // if a user clicks on the button, set the element
  const [anchorEl, setAnchorEl] = useState<null | HTMLElement>(null);
  const open = Boolean(anchorEl);

  const handleClickMenu = (event: MouseEvent<HTMLElement>) => {
    setAnchorEl(event.currentTarget);
    console.log(event.currentTarget);
  };

  const handleCloseMenu = () => {
    setAnchorEl(null);
  };

  return (
    <AppBar position="static">
      <Toolbar>
        <Box sx={{ flexGrow: 1, maxWidth: "100px" }}>
          <StyledLink to={PublicRoutes.HOME}>
            <Button style={{ color: "white" }} size="small">
              Skill Forge Academy
            </Button>
          </StyledLink>
        </Box>
        <Box sx={{ flexGrow: 0.2 }}></Box>
        <Box sx={{ flexGrow: 1 }}>
          <SearchInputWrapper>
            <StyledInputBase placeholder="Buscar..." />
          </SearchInputWrapper>
        </Box>
        <Box sx={{ flexGrow: 0.2 }}></Box>
        <Box sx={{ display: { xs: "none", md: "flex" }, alignItems: "center" }}>
          <StyledLink to={PublicRoutes.REGISTER}>
            <StyledButton size="small">register</StyledButton>
          </StyledLink>

          <StyledButton size="small">categorias</StyledButton>

          <StyledLink to={PublicRoutes.LOGIN}>
            <StyledButton size="small">Login</StyledButton>
          </StyledLink>
          <IconButton>
            <AccountCircle style={{ color: "white" }} />
          </IconButton>
        </Box>
        <Box sx={{ display: { xs: "flex", md: "none" } }}>
          <StyledButton
            id="menu-button"
            aria-controls={open ? "menu" : undefined}
            onClick={handleClickMenu}
            aria-haspopup="true"
          >
            <MenuIcon />
          </StyledButton>

          <Menu
            id="menu"
            anchorEl={anchorEl}
            open={open}
            onClose={handleCloseMenu}
            MenuListProps={{
              "aria-labelledby": "menu-button",
            }}
            anchorOrigin={{ vertical: "bottom", horizontal: "center" }}
            transformOrigin={{ vertical: "top", horizontal: "center" }}
          >
            <MenuItem onClick={handleCloseMenu}>
              <StyledLink to={PublicRoutes.HOME}>Home</StyledLink>
            </MenuItem>
            <MenuItem onClick={handleCloseMenu}>
              <StyledLink to={PublicRoutes.REGISTER}>Register</StyledLink>
            </MenuItem>
            <MenuItem onClick={handleCloseMenu}>
              <StyledLink to={PublicRoutes.LOGIN}>Login</StyledLink>
            </MenuItem>
          </Menu>
        </Box>
      </Toolbar>
    </AppBar>
  );
}
export default Navbar;
