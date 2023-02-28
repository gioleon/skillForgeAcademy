import { alpha, styled } from "@mui/material/styles";

export const SearchInputWrapper = styled("div")(({ theme }) => ({
  borderRadius: 10,
  backgroundColor: alpha(theme.palette.common.white, 0.15),
  '&:hover': {
    backgroundColor: alpha(theme.palette.common.white, 0.25),
  },
  padding: '3px',
  marginLeft: '5px',
  marginRight: '5px',  
}));
