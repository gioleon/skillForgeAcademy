import { AccountCircle } from "@mui/icons-material";
import { Box, IconButton, ThemeProvider } from "@mui/material";
import { PublicRoutes } from "../../../model";
import { StyledLink } from "../../../styled-components";
import { StyledButton } from "../styled-components";
import { theme } from "./customTheme";

function ItemsNavbar() {
  return (
    <ThemeProvider theme={theme}>
      <Box sx={{ display: { xs: "none", md: "flex" }, alignItems: "center" }}>
        <StyledLink to={PublicRoutes.REGISTER}>
          <StyledButton size="small">Register</StyledButton>
        </StyledLink>

        <StyledButton size="small">Categorias</StyledButton>

        <StyledLink to={PublicRoutes.LOGIN}>
          <StyledButton size="small">Login</StyledButton>
        </StyledLink>
        <IconButton>
          <AccountCircle style={{ color: "white" }} />
        </IconButton>
      </Box>
    </ThemeProvider>
  );
}
export default ItemsNavbar;
