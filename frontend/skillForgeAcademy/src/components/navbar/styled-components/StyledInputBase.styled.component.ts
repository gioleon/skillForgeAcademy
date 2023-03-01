import {styled, alpha} from '@mui/material/styles';
import InputBase from '@mui/material/InputBase';

export const StyledInputBase = styled(InputBase)(({theme}) => ({
    marginLeft: '5px',
    color: alpha(theme.palette.common.black, 0.8)
}));