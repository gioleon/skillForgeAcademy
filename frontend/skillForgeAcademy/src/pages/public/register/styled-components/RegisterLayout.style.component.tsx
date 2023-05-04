import styled from "styled-components";

export const LayoutRegister = styled.div<{}>`
  width: 100%;
  height: 100vh;

  .right-form {
    width: 50%;
    height: 100%;
    overflow: hidden;
    float: left;
    background: white url("src/img/hero-register.jpg") no-repeat;
    background-size: cover;
  }

  .left-form {
    width: 50%;
    height: 100%;
    margin: 0;
    float: left;
    background-color: #2b3467;
    display: flex;
    justify-content: center;
  }

  .left-form form{
    height: 100%;
    width: 55%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
  }

  .left-form .title-register{
    font-size: 2rem;
    color: white;
    margin: 10px 0;
  }

  .left-form form > input{
    background-color: #FCFFE7;
    color: #2B3467; 
    border: none;
    padding: 10px 10px;
    font-size: 15px;
    border-radius: 5px;
    margin: 10px 0;
    width: 100%
  }

  .left-form form > input::placeholder{
    color: #2B3467; 
    font-size: 12px;
  }

  .left-form form > input:focus{
    border: none;
    outline: none;
  }

  
  .left-form label{
    width: 100%;
    font-size: 18px;
    font-weight: 700;
    margin: 20px 0;
  }

  button{
    width 100%;
    padding: 10px;
    border-radius: 5px;
    background-color: #EB455F;
    color: white; 
    border: none;
  }

    button:hover{
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
    .right-form{
      display: none;
    }

    .left-form{
      width: 100%;
    }

    .left-form form{
      width: 95%;
      padding: 1em;
    }


  }


`;
