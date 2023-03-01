import { Box, createTheme, ThemeProvider  } from "@mui/material";
import { SearchInputWrapper, StyledInputBase } from "../styled-components";
import { theme } from './customTheme';



function SearchInputNavbar() {
  return (
    <ThemeProvider theme={theme}>
      <Box
        sx={{
          flexGrow: 1,
          mx:  {sm: "0px", md: "15px"},
          display: { xs : "none", md: "flex" },
        }}
      >
        <SearchInputWrapper>
          <StyledInputBase placeholder="Buscar..." />
        </SearchInputWrapper>
      </Box>
    </ThemeProvider>
  );
}
export default SearchInputNavbar;
