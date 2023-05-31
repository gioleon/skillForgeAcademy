import { useSelector } from "react-redux";
import { Link, useParams } from "react-router-dom";
import { AppStore } from "../../../redux/store";
import BasicTabs from "./components/Tabs";
import { Avatar, Box } from "@mui/material";
import { deepOrange } from "@mui/material/colors";
import { Course, PrivateRoutes } from "../../../model";
import { getCourseByIdOwner } from "../../../service";
import { getUserInscriptions } from "../../../service/enroll.service";
import { useState, useEffect } from "react";

function Profile() {
  const [createdCourses, setCreatedCourses] = useState<Course[]>([]);
  const [enrolledCourses, setEnrolledCourses] = useState<Course[]>([]);
  
  const user = useSelector((store: AppStore) => store.user);


  const handlerGetCourse = async () => {
    const cCourses: Course[] = await getCourseByIdOwner(user.id);
    const eCourses: Course[] = await getUserInscriptions(user.id);

    setCreatedCourses(cCourses);
    setEnrolledCourses(eCourses);
  };

  useEffect(() => {
    handlerGetCourse();
  });

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
        <p className="font-bold mt-1">Nombre</p>
        <p>{user.name + " " + user.lastName}</p>
        <p className="font-bold mt-1">Email</p>
        <p>{user.email}</p>
        <div className="py-5 flex gap-2">
          <Link
            to={`/${PrivateRoutes.PRIVATE}/${user.id}/${PrivateRoutes.ADDCOURSE}`}
            className="btn bg-blue-500 normal-case border-none hover:bg-gray-800 hover:text-white "
          >
            Crear un curso
          </Link>
        </div>
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
