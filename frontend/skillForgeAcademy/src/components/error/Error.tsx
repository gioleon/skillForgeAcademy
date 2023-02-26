interface Props {
  message?: string;
}

function Error({ message }: Props) {

  

    const response =  <p>{message}</p>;

    return response;
}
export default Error;
