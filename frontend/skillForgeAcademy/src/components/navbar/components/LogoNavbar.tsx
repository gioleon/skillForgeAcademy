import { Box, Button, ThemeProvider } from "@mui/material";
import { PublicRoutes } from "../../../model";
import { StyledLink } from "../../../styled-components";
import { theme } from "./customTheme";

function LogoNavbar() {
  return (
    <ThemeProvider theme={theme}>
      <Box
        sx={{
          flexGrow: 1,
          maxWidth: { md: "180px" },
          display: { xs: "flex" },
          justifyContent: "center",
        }}
      >
        <StyledLink to={PublicRoutes.HOME}>
          <Button style={{ color: "white" }} size="small">
            Skill Forge Academy
          </Button>
        </StyledLink>
      </Box>
    </ThemeProvider>
  );
}
export default LogoNavbar;
