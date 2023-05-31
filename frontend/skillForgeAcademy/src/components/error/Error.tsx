interface Props {
  error: boolean;
  message?: string;
}

function Error({ message }: Props) {

    return <p className="my-2 text-center">{message}</p>;
}
export default Error;
