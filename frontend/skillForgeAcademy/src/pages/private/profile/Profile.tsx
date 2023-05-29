import { useSelector } from "react-redux";
import { useParams } from "react-router-dom";
import { AppStore } from "../../../redux/store";
import BasicTabs from "./components/Tabs";
import { Avatar, Box } from "@mui/material";
import { deepOrange } from "@mui/material/colors";
import { Course } from "../../../model";
import { getCourseByIdOwner } from "../../../service";
import { getUserInscriptions } from "../../../service/enroll.service";

function Profile() {
  const user = useSelector((store: AppStore) => store.user);

  let createdCourses: Course[] = [];
  let enrolledCourses: Course[] = [];

  const handlerGetCourse = async () => {
    const cCourses: Course[] = await getCourseByIdOwner(user.id);
    const eCourses: Course[] = await getUserInscriptions(user.id);

    createdCourses = cCourses;
    enrolledCourses = eCourses;
  };

  return (
    <>
      <Box
        sx={{
          display: "flex",
          flexDirection: "column",
          alignItems: "center",
          paddingTop: "10px",
        }}
      >
        <Avatar
          sx={{
            bgcolor: deepOrange[500],
            marginBottom: "10px",
          }}
        >
          {user.name[0]}
        </Avatar>
        <p>{user.name + " " + user.lastName}</p>
        <p>{user.email}</p>
      </Box>
      <BasicTabs
        createdCourses={createdCourses}
        enrolledCourses={enrolledCourses}
      />
      ;
    </>
  );
}
export default Profile;
