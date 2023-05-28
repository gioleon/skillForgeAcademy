import { AccountCircle } from "@mui/icons-material";
import { Box, IconButton, ThemeProvider } from "@mui/material";
import { PrivateRoutes, PublicRoutes } from "../../../model";
import { StyledLink } from "../../../styled-components";
import { StyledButton } from "../styled-components";
import { theme } from "./customTheme";

function ItemsNavbar() {
  return (
    <ThemeProvider theme={theme}>
      <Box sx={{ display: { xs: "none", md: "flex" }, alignItems: "center" }}>
        <StyledLink to={`/${PublicRoutes.REGISTER}`}>
          <StyledButton hoverBackground="white" color="#1976d2">
            Register
          </StyledButton>
        </StyledLink>
        <StyledLink to={`/${PublicRoutes.CATEGORIES}`}>
          <StyledButton hoverBackground="white" color="#1976d2">
            Categorias
          </StyledButton>
        </StyledLink>
        <StyledLink to={`/${PublicRoutes.LOGIN}`}>
          <StyledButton hoverBackground="white" color="#1976d2">
            Login
          </StyledButton>
        </StyledLink>
        <StyledLink to={`/${PrivateRoutes.PROFILE}`}>
          <IconButton>
            <AccountCircle style={{ color: "white" }} />
          </IconButton>
        </StyledLink>
      </Box>
    </ThemeProvider>
  );
}
export default ItemsNavbar;
