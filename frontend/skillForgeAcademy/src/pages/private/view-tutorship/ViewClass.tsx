import { Link, useParams } from "react-router-dom";
import { getTutorshipById } from "../../../service";
import { TutorshipId } from "../../../model/tutorship/tutorshipId";
import { PrivateRoutes, Tutorship } from "../../../model";
import { useEffect } from "react";

function ViewClass() {
  const { idCourse, idSection, idTutorship } = useParams();
  let tutorship: Tutorship = {
    id: 0,
    section: { id: 0, name: "" },
    course: {
      id: 0,
      name: "",
      description: "",
      owner: { id: 0, name: "" },
      category: [{ id: 0, name: "" }],
      urlImage: "",
    },
    name: "CRUD con React JS, Spring Boot y MongoDB",
    urlVideo:
      "https://assets.mixkit.co/videos/preview/mixkit-going-down-a-curved-highway-through-a-mountain-range-41576-large.mp4",
  };

  const id: TutorshipId = {
    id: idTutorship ? Number.parseInt(idTutorship) : 0,
    course: { id: idCourse ? Number.parseInt(idCourse) : 0 },
    section: { id: idSection ? Number.parseInt(idSection) : 0 },
  };

  const getTutorship = async () => {
    let foundTutorship = await getTutorshipById(id);
    tutorship = foundTutorship;
  };

  useEffect(() => {
    getTutorship();
  }, []);

  return (
    <section>
      <div className="py-16">
        <div className="container m-auto px-6">
          <div>
            <h1 className="text-3xl font-bold leading-tight mb-5 capitalize">
              {tutorship.name}
            </h1>
          </div>
          <div className="aspect-video">
            <iframe
              className="w-full h-full"
              src={tutorship.urlVideo}
              allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
              allowFullScreen
            ></iframe>
          </div>
          <div className="text-center">
            <Link
              to={`/${PrivateRoutes.PRIVATE}/${tutorship.course.owner?.id}/${PrivateRoutes.COURSE}/${tutorship.course.id}`}
              className="btn bg-blue-500 w-40 mt-5  text-white normal-case border-none hover:bg-gray-800 "
            >
              Regresar al curso
            </Link>
          </div>
        </div>
      </div>
    </section>
  );
}

export default ViewClass;
