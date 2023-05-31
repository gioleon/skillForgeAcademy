import { AccountCircle } from "@mui/icons-material";
import { Box, IconButton, ThemeProvider } from "@mui/material";
import { PrivateRoutes, PublicRoutes } from "../../../model";
import { StyledLink } from "../../../styled-components";
import { StyledButton } from "../styled-components";
import { theme } from "./customTheme";
import { useSelector } from "react-redux";
import { AppStore } from "../../../redux/store";

function ItemsNavbar() {
  const user = useSelector((store: AppStore) => store.user);

  return (
    <ThemeProvider theme={theme}>
      <Box sx={{ display: { xs: "none", md: "flex" }, alignItems: "center" }}>
        {!user.id ? (
          <>
            <StyledLink to={`/${PublicRoutes.REGISTER}`}>
              <StyledButton hoverBackground="white" color="#1976d2">
                Register
              </StyledButton>
            </StyledLink>
            <StyledLink to={`/${PublicRoutes.LOGIN}`}>
              <StyledButton hoverBackground="white" color="#1976d2">
                Login
              </StyledButton>
            </StyledLink>
          </>
        ) : (
          <StyledLink to={`/${PublicRoutes.LOGIN}`}>
            <StyledButton hoverBackground="white" color="#1976d2">
              Logout
            </StyledButton>
          </StyledLink>
        )}
        <StyledLink to={`/${PublicRoutes.HOME}`} replace={true} >
          <StyledButton hoverBackground="white" color="#1976d2">
            Home
          </StyledButton>
        </StyledLink>
        <StyledLink to={`/${PublicRoutes.CATEGORIES}`}>
          <StyledButton hoverBackground="white" color="#1976d2">
            Categorias
          </StyledButton>
        </StyledLink>

        <StyledLink
          to={`/${PrivateRoutes.PRIVATE}/${PrivateRoutes.PROFILE}/${user.id}`}
        >
          <IconButton>
            <AccountCircle style={{ color: "white" }} />
          </IconButton>
        </StyledLink>
      </Box>
    </ThemeProvider>
  );
}
export default ItemsNavbar;
