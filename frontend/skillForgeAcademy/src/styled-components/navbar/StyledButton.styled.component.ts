import { Button, Theme } from "@mui/material";
import { styled, alpha } from "@mui/material/styles";


export const StyledButton = styled(Button) (({theme}) => ({
    
    color: theme.palette.common.white,
    "&:hover": {
        backgroundColor: null,
        color: alpha(theme.palette.common.black, 0.6),
    },
    marginLeft: '3px',
    marginRight: '3px',
    width: '90px'
})); 