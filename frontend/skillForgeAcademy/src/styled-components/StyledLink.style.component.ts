import { styled } from "@mui/material/styles";
import { Link } from "react-router-dom";


export const StyledLink = styled(Link)(({theme}) => ({
  textDecoration: "none",
  ":visited": false,
  color: theme.palette.text.secondary,
  "&:hover": {
    color: theme.palette.primary.main,
  },
}));