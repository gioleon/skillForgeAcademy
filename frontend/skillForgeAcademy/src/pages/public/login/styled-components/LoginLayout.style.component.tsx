import styled from "styled-components";

export const LoginLayout = styled.div<{}>`
  padding: 40px;
  display: flex;
  height: 100vh;
  align-items: center;
  background: #7474bf; /* fallback for old browsers */
  background: -webkit-linear-gradient(
    to right,
    #348ac7,
    #7474bf
  ); /* Chrome 10-25, Safari 5.1-6 */
  background: linear-gradient(
    to right,
    #348ac7,
    #7474bf
  ); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */

  .left-form {
    width: 50%;
  }

  .right-form {
    width: 50%;
    background-color: white;
    padding: 40px;
    border-radius: 10px;
    color: #2b3467;
  }

  img {
    max-width: 100%;
  }

  .login-header {
    margin-bottom: 20px;
  }

  .login-header h1 {
    font-size: 40px;
    text-align: center;
  }

  .login-header p {
    text-align: center;
  }

  .login-form-content {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    gap: 10px;
  }

  .login-form-content input {
    border: none;
    background-color: #2b3467;
    color: white;
    padding: 10px 30px;
    border-radius: 5px;
  }

  .login-form-content input[placeholder] {
    color: white;
  }

  .login-form-footer {
    display: flex;
    justify-content: space-between;
    margin-top: 10px;
  }

  .login-form-footer h2 {
    padding: 15px;
  }

  .login-form-footer a {
    background-color: #2b3467;
    color: white;
    text-decoration: none;
    padding: 15px;
    border-radius: 10px;
  }
`;
