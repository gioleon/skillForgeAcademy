interface Props {
  error: boolean;
  message: string;
}

function Error({ error, message }: Props) {

    const response = error ? <p>{message}</p> : null;

    return response;
}
export default Error;
