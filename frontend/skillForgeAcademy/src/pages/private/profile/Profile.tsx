import { useSelector } from "react-redux";
import { useParams } from "react-router-dom";
import { AppStore } from "../../../redux/store";

function Profile() {
  const { email } = useParams();
  const user = useSelector((store: AppStore) => store.user);

  return <div>Profile {email}</div>;
}
export default Profile;
