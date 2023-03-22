import styled from "styled-components";

export const FormLayout = styled.div<{}>`
  background-color: #2b3467;
  padding: 15rem;
  color: #fff;
  h1 {
    padding: 2rem 0;
  }
  label {
    display: block;
    font-size: 1.1rem;
    margin: 0.5rem;
  }
  input {
    padding: 1rem 15rem 1rem 1rem;
    border: 1px solid #ccc;
    border-radius: 5px;
    background-color: #fcffe7;
    text-align: left;
  }
  button {
    margin: 1.2rem;
    background-color: #eb455f;
    border: none;
    border-radius: 5px;
    padding: 1rem 9rem;
    text-align: center;
    color: #fff;
    font-size: 0.9rem;
    font-weight: 600;
  }
  h2 {
    display: inline;
    font-size: 1rem;
    padding: 1rem 1rem 0 1rem;
    text-align: center;
  }
  a {
    color: white;
    text-decoration: none;
  }
`;
