interface Props {
  error: boolean;
  message?: string;
}

function Error({ message }: Props) {

    return <p className="my-2 text-center after:content-['🚨']">{message}</p>;
}
export default Error;
