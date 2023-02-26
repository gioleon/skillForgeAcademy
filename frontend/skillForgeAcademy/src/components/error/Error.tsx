interface Props {
  error: boolean;
  message?: string;
}

function Error({ message }: Props) {

    return <p>{message}</p>;
}
export default Error;
