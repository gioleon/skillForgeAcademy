import styled from "styled-components";

export const FormLayout = styled.div<{}>`
  background-color: #2b3467;
  color: #fff;
  form {
    color: white;
    margin: auto;
    max-width: 600px;
    text-align: center;
  }
  input {
    padding: 1rem 15rem 1rem 1rem;
    border: 1px solid #ccc;
    border-radius: 5px;
    background-color: #fcffe7;
    text-align: left;
    margin-bottom: 1rem;
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
  h1 {
    padding: 1rem 0;
    text-align: center;
    font-size: 1.2rem;
  }
  h2 {
    display: inline;
    font-size: 1rem;
    padding: 1rem 1.5rem;
  }
  a {
    color: white;
    text-decoration: none;
  }
`;
