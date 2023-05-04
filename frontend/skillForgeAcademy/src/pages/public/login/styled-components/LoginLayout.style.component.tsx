import styled from "styled-components";

export const LoginLayout = styled.section<{}>`
  width: 100%;
  height: 100vh;

  .left-form {
    width: 50%;
    height: 100%;
    overflow: hidden;
    float: left;
    background: white url("src/img/hero-login.jpg") no-repeat;
    background-size: cover;
  }

  .right-form {
    width: 50%;
    height: 100%;
    margin: 0;
    float: left;
    background-color: #2b3467;
    display: flex;
    justify-content: center;
  }

  .right-form form{
    height: 100%;
    width: 55%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
  }

  .right-form .title-login{
    font-size: 2rem;
    color: white;
    margin: 10px 0;
    text-align: left;
  }

  .right-form form > input{
    background-color: #FCFFE7;
    color: #2B3467; 
    border: none;
    padding: 10px 10px;
    font-size: 15px;
    border-radius: 5px;
    margin: 10px 0;
    width: 100%
  }

  .right-form form > input::placeholder{
    color: #2B3467; 
    font-size: 12px;
  }

  .right-form form > input:focus{
    border: none;
    outline: none;
  }

  button{
    width 100%;
    padding: 10px;
    border-radius: 5px;
    background-color: #EB455F;
    color: white; 
    border: none;
  }

  .right-form label{
    width: 100%;
    font-size: 18px;
    font-weight: 700;
    margin: 20px 0;
  }

  .login-form-footer{
    margin-top: 10px;
    display: flex;
    align-items: center;
    gap: 10px;
  }

  .title-register{
    color: white;
    font-size: 0.9rem;
    font-weight: 500;
  }

  .link-register{
    text-decoration: none;
    background-color: #EB455F;
    color: white;
    font-size: 0.8rem;
    padding: 8px;
    border-radius: 5px;
  }

  .link-register:hover, button:hover{
    background-color: #BAD7E9;
    color: #2B3467;
    cursor: pointer;
  }
  
  p{
    color: white;
    font-size: 0.7rem;
  }

  p:after{
    content: "🚨"
  }

  @media (max-width: 768px) {
    .left-form{
      display: none;
    }

    .right-form{
      width: 100%;
    }

    .right-form form{
      width: 95%;
      padding: 1em;
    }

  }


`;
