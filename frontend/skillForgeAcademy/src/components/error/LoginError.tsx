interface Props {
  error: boolean;
}

function LoginError({ error }: Props) {
    if (error) return (<p>Correo o contraseña incorrectos</p>);

  return <></>;
}
export default LoginError;
