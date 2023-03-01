import { Box, ThemeProvider } from "@mui/material";
import SearchIcon from "@mui/icons-material/Search";
import { StyledButton } from "../styled-components/StyledButton.styled.component";
import { theme } from "./customTheme";

function SearchModal() {
  return (
    <ThemeProvider theme={theme}>
      <Box sx={{ display: { xs: "flex", md: "none" } }}>
        <StyledButton>
          <SearchIcon />
        </StyledButton>
      </Box>
    </ThemeProvider>
  );
}
export default SearchModal;
