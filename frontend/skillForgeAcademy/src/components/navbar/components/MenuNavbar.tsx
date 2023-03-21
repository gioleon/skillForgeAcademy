import {
  Box,
  Divider,
  Drawer,
  List,
  ListItem,
  ThemeProvider,
} from "@mui/material";
import { useState } from "react";
import { PublicRoutes } from "../../../model";
import { StyledLink } from "../../../styled-components";
import MenuIcon from "@mui/icons-material/Menu";
import { StyledButton } from "../styled-components";
import { theme } from "./customTheme";

function MenuNavbar() {
  // if a user clicks on the button, set the element
  const [open, setOpen] = useState(false);

  const PAGES: string[][] = [
    [PublicRoutes.HOME, "Home"],
    [PublicRoutes.LOGIN, "Login"],
    [PublicRoutes.REGISTER, "Register"],
  ];

  const handleOpenMenu = () => {
    setOpen(true);
  };

  const handleCloseMenu = () => {
    setOpen(false);
  };

  return (
    <ThemeProvider theme={theme}>
      <Box
        sx={{
          display: { xxs: "flex", md: "none" },
          visibility: open ? "hiden" : "visible",
        }}
      >
        <StyledButton
          id="menu-button"
          onClick={handleOpenMenu}
          aria-haspopup="true"
        >
          <MenuIcon />
        </StyledButton>

        <Drawer id="menu" open={open} keepMounted onClose={handleCloseMenu}>
          <List>
            {PAGES.map((page, index) => (
              <ListItem key={index}>
                <StyledButton>
                  <StyledLink to={page[0]}>{page[1]}</StyledLink>
                </StyledButton>
              </ListItem>
            ))}
          </List>
          <Divider />
        </Drawer>
      </Box>
    </ThemeProvider>
  );
}
export default MenuNavbar;