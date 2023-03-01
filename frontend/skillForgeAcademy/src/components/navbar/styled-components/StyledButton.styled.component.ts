import { Button, Theme } from "@mui/material";
import { styled, alpha } from "@mui/material/styles";


export const StyledButton = styled(Button) (({theme}) => ({
    
    color: theme.palette.common.white,
    "&:hover": {
        backgroundColor: theme.palette.primary.contrastText,
        color: alpha(theme.palette.primary.dark, 0.9),
    },
    marginLeft: '3px',
    marginRight: '3px',
    width: '90px'
})); 