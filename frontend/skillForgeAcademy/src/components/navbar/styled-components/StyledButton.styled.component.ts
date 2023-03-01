import { Button, Theme } from "@mui/material";
import { FC } from "react";
import styled from "styled-components";

export const StyledButton = styled.button<{
  hoverBackground?: string;
  color?: string;
}>`
  width: 80px;
  text-decoration: none;
  font-size: 1rem;
  display: flex;
  align-items: center;
  justify-content: center;
  text-transform: none;
  background-color: transparent;
  color: white;
  shadow = none;
  border: none;
  padding: 5px 5px;
  margin: 0 3px;
  cursor: pointer;
  &:hover {
      background-color: ${props => (props.hoverBackground? props.hoverBackground : 'none')};
      color: ${props => (props.color? props.color : 'white')};
      border-radius: 4px;
  }
`;