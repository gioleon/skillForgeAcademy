import { Link, useParams } from "react-router-dom";
import { getCourseById, getTutorshipById } from "@/service";
import { TutorshipId } from "@/model/tutorship/tutorshipId";
import { Course, PrivateRoutes, Tutorship } from "@/model";
import { useEffect, useState } from "react";
import { SectionOA } from "../../../model/section/sectionOA";
import Tutorships from "@/components/tutorships/Tutorships";
import {
  getAllTutorShipsByCourseId,
  getAllTutorship,
} from "../../../service/tutorship.service";
import { number } from "yup";

interface Props {
  sections: SectionOA[];
  course: Course;
  numberIdUser: 0;
  numberIdCourse: 0;
  numberIdSection: 0;
  numberIdTutorship: 0;
}

function ViewClass() {
  const { idUser, idCourse, idSection, idTutorship } = useParams();
  const numberIdCourse = Number.parseInt(idCourse!);

  const [course, setCourse] = useState<Course>({
    id: 0,
    name: "Selecciona una clase para mirar",
    description: "",
    owner: { id: 0, name: "" },
    category: [{ id: 0, name: "" }],
    urlImage: "",
  });

  const [tutorship, setTutorship] = useState<Tutorship>({
    id: 0,
    section: { id: 0, name: "" },
    course: {
      id: 0,
      name: "Selecciona una clase para mirar",
      description: "",
      owner: { id: 0, name: "" },
      category: [{ id: 0, name: "" }],
      urlImage: "",
    },
    name: "",
    urlVideo: "",
  });

  const getCourse = async () => {
    const foundCourse = await getCourseById(numberIdCourse);
    setCourse(foundCourse);
  };

  const id: TutorshipId = {
    id: idTutorship ? Number.parseInt(idTutorship) : 0,
    course: { id: idCourse ? Number.parseInt(idCourse) : 0 },
    section: { id: idSection ? Number.parseInt(idSection) : 0 },
  };

  const getAllTutorships = async () => {
    let tutorships = await getAllTutorShipsByCourseId(numberIdCourse);
    if (tutorships.length > 0) {
      setTutorship(tutorships[0]);
    }
  };

  useEffect(() => {
    getAllTutorships();
    getCourse();
  }, []);

  return (
    <>
      <section>
        <div className="py-16">
          <div className="container m-auto px-6">
            <div>
              <h1 className="text-3xl font-bold leading-tight mb-5 capitalize">
                {tutorship.name}
              </h1>
            </div>
            {tutorship.id != 0 ? (
              <div className="aspect-video">
                <iframe
                  className="w-full h-full"
                  src={tutorship.urlVideo}
                  allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                  allowFullScreen
                ></iframe>
              </div>
            ) : null}
            <Tutorships course={course!} setTutorship={setTutorship} tutorship = {tutorship} />
            <div className="text-center">
              <Link
                to={`/${PrivateRoutes.PRIVATE}/${Number.parseInt(idUser!)}/${
                  PrivateRoutes.COURSE
                }/${course.id}`}
                className="btn bg-blue-500 w-40 mt-5  text-white normal-case border-none hover:bg-gray-800 "
              >
                Regresar al curso
              </Link>
            </div>
          </div>
        </div>
      </section>
    </>
  );
}

export default ViewClass;
