import { Box, Menu, MenuItem, ThemeProvider } from "@mui/material";
import { MouseEvent, useState } from "react";
import { PublicRoutes } from "../../../model";
import { StyledLink } from "../../../styled-components";
import MenuIcon from "@mui/icons-material/Menu";
import { StyledButton } from "../styled-components";
import { theme } from "./customTheme";

function MenuNavbar() {
  // if a user clicks on the button, set the element
  const [anchorEl, setAnchorEl] = useState<null | HTMLElement>(null);
  const open = Boolean(anchorEl);

  const handleClickMenu = (event: MouseEvent<HTMLElement>) => {
    setAnchorEl(event.currentTarget);
  };

  const handleCloseMenu = () => {
    setAnchorEl(null);
  };

  return (
    <ThemeProvider theme={theme}>
      <Box sx={{ display: { xxs: "flex", md: "none" } }}>
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
    </ThemeProvider>
  );
}
export default MenuNavbar;
