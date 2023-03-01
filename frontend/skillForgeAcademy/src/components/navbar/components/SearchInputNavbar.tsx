import { Box, createTheme, ThemeProvider  } from "@mui/material";
import { SearchInputWrapper, StyledInputBase } from "../styled-components";
import { theme } from './customTheme';


interface DisplayBreakpoints {
  xs: string;
  md: string;
}

interface Props {
  displaySettings: DisplayBreakpoints;
  backgroundColor?: string;
  hoverBackgroundColor?: string;
}

function SearchInputNavbar(props: Props) {
  return (
    <ThemeProvider theme={theme}>
      <Box
        sx={{
          flexGrow: 1,
          mx:  {sm: "0px", md: "15px"},
          display: {xs: props.displaySettings.xs, md: props.displaySettings.md},
        }}
      >
        <SearchInputWrapper>
          <StyledInputBase placeholder="Buscar..." fullWidth/>
        </SearchInputWrapper>
      </Box>
    </ThemeProvider>
  );
}
export default SearchInputNavbar;
