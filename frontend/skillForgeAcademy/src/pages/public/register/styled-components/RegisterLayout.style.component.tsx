import styled from "styled-components";

export const LayoutRegister = styled.div<{}>`
  background-color: #2b3467;
  color: #fff;
  display: flex;
  min-height: 93vh;

  form {
    color: white;
    margin: auto;
    max-width: 600px;
    text-align: center;
  }
  label {
    display: block;
    font-size: 1rem;
    margin: 0.5rem;
    text-align: left;
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

  p {
    color: #eb455f;
  }

  h1 {
    margin-bottom: 2rem;
  }
`;
