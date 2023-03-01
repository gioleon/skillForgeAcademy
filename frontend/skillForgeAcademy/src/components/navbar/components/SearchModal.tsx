import { Box, Dialog, ThemeProvider } from "@mui/material";
import SearchIcon from "@mui/icons-material/Search";
import CloseIcon from "@mui/icons-material/Close";
import { StyledButton } from "../styled-components/StyledButton.styled.component";
import { theme } from "./customTheme";
import AppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import { useState } from "react";
import SearchInputNavbar from './SearchInputNavbar';

function SearchModal() {
  const [open, setOpen] = useState(false);

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  return (
    <ThemeProvider theme={theme}>
      <Box sx={{ display: { xs: "flex", md: "none" } }}>
        <StyledButton onClick={handleClickOpen}>
          <SearchIcon />
        </StyledButton>
      </Box>
      
      <Dialog open={open} fullScreen>
        <AppBar>
          <Toolbar>
            <StyledButton onClick={handleClose}>
              <CloseIcon />
            </StyledButton>
            <Box sx={{ flexGrow: 1 }}>
              <SearchInputNavbar displaySettings={{xs: 'flex', md: 'flex'}}/>
            </Box>
          </Toolbar>
        </AppBar>
      </Dialog>
    </ThemeProvider>
  );
}
export default SearchModal;
