import { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import {
  createSection,
  getAllTutorShipsByCourseId,
  getCourseById,
} from "../../../service";
import {
  Course,
  PrivateRoutes,
  Section,
  SectionOA,
  Tutorship,
  TutorshipOA,
} from "../../../model";
import { enroll, studentIsEnroll } from "../../../service/enroll.service";
import { timeout } from "rxjs";
import { useSelector } from "react-redux";
import { AppStore } from "../../../redux/store";

const ViewCourse = () => {
  const [enrolled, setEnrolled] = useState();
  const [course, setCourse] = useState<Course>({
    id: 0,
    name: "",
    description: "",
    owner: { id: 1, name: "" },
    category: [{ id: 0, name: "" }],
    urlImage: "",
  });

  const [tutorships, setTutorships] = useState<Tutorship[]>([
    // {
    //   id: 0,
    //   section: { id: 1, name: "POO" },
    //   course: {
    //     id: 0,
    //     name: "Natgeo",
    //     description: "Geografia",
    //     owner: { id: 0, name: "epa" },
    //     category: [{ id: 0, name: "hola" }],
    //     urlImage:
    //       "https://images.pexels.com/photos/16450166/pexels-photo-16450166/free-photo-of-animal-mascota-mono-pelo.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
    //   },
    //   name: "Conexion a PostgreSQL database",
    //   urlVideo: "youtube.com/watch?v",
    // },
  ]);

  const { idUser = "0", idCourse = "0" } = useParams();

  const user = useSelector((store: AppStore) => store.user);

  const numberIdUser = Number.parseInt(idUser);
  const numberIdCourse = Number.parseInt(idCourse);

  const getCourse = async () => {
    const foundCourse = await getCourseById(numberIdCourse);
    setCourse(foundCourse);
  };

  const getTutorShip = async () => {
    const foundTutorShip = await getAllTutorShipsByCourseId(numberIdCourse);
    setTutorships(foundTutorShip);
  };

  const studentIsEnrolled = async () => {
    const studentIsEnrolled = await studentIsEnroll(
      numberIdUser,
      numberIdCourse
    );

    setEnrolled(studentIsEnrolled);
  };

  useEffect(() => {
    getTutorShip();
    getCourse();
    studentIsEnrolled();
  }, []);

  const sections: SectionOA[] = [];
  const idSections: number[] = [];

  for (var i = 0; i < tutorships.length; i++) {
    let id = tutorships[i].section.id;
    if (id !== undefined && !idSections.includes(id)) {
      sections.push(tutorships[i].section);
      idSections.push(id);
    }
  }

  const handleEnroll = () => {
    enroll({
      course: { id: numberIdCourse },
      student: { id: numberIdUser },
    });
    timeout(2000);
  };

  return (
    <main>
      <div className="py-16">
        <div className="container m-auto px-6">
          <div className="lg:flex justify-between items-center">
            <div className="lg:w-6/12 lg:p-0 p-7">
              <h1 className="text-6xl font-bold leading-tight mb-5 capitalize">
                {course.name}
              </h1>
              <section className="flex-col ">
                <h2 className="text-2xl font-bold leading-tight mb-5 capitalize py-2">
                  Acerca del curso
                </h2>
                <p className="text-lg">{course.description}</p>
              </section>
              {!enrolled && numberIdCourse !== course.owner.id ? (
                <div className="py-5 flex gap-2">
                  <Link
                    to={`/${PrivateRoutes.PRIVATE}/${numberIdUser}/${PrivateRoutes.COURSE}/${numberIdCourse}}`}
                    className="btn bg-blue-500 normal-case border-none hover:bg-gray-800 hover:text-white "
                  >
                    <button onClick={() => handleEnroll()}>Inscribirme</button>
                  </Link>
                </div>
              ) : null}
              {numberIdCourse === course.owner.id ? (
                <div className="py-5 flex gap-2">
                  <Link
                    to={`/${PrivateRoutes.PRIVATE}/${numberIdUser}/${PrivateRoutes.COURSE}/${numberIdCourse}/${PrivateRoutes.SECTION}`}
                    className="btn bg-blue-500 normal-case border-none hover:bg-gray-800 hover:text-white "
                  >
                    Crear nueva sección
                  </Link>
                </div>
              ) : null}
            </div>
            <section className="lg:w-5/12 order-2">
              <img
                src={course.urlImage}
                style={{
                  transform:
                    "scale(1) perspective(1040px) rotateY(-11deg) rotateX(2deg) rotate(2deg)",
                }}
                alt=""
                className="rounded"
              />
            </section>
          </div>
        </div>
      </div>
      {enrolled || numberIdUser === course.owner.id ? (
        <section className="container m-auto px-6 py-6">
          <h2 className="text-2xl font-bold leading-tight mb-5 capitalize">
            Temario del curso
          </h2>
          {sections.map((s: SectionOA, y: number) => {
            return (
              <div
                key={y}
                tabIndex={y}
                className="collapse collapse-plus border border-base-300 bg-base-100 rounded-box mt-2"
              >
                <input type="checkbox" />
                <div className="collapse-title text-xl font-medium">
                  {s.name}
                </div>
                <div className="collapse-content">
                  {tutorships.map((t: Tutorship, i: number) => {
                    return t.section.id === s.id ? (
                      <Link
                        key={i}
                        to={`/${PrivateRoutes.PRIVATE}/${idUser}/${PrivateRoutes.COURSE}/${idCourse}/${PrivateRoutes.SECTION}/${s.id}/${PrivateRoutes.TUTORSHIP}/${t.id}`}
                        className="btn bg-gray-800  mt-1.5 text-lef flex justify-start text-white normal-case border-none hover:btn-info "
                      >
                        {i.toString() + ". " + t.name}
                      </Link>
                    ) : null;
                  })}
                </div>
              </div>
            );
          })}
        </section>
      ) : null}

      <section className="shadow-lg bg-gray-800 container m-auto px-6">
        <div className="stat">
          <div className="stat-figure text-secondary">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              fill="none"
              viewBox="0 0 24 24"
              className="inline-block w-8 h-8 stroke-current text-white"
            >
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth="2"
                d="M13 16h-1v-4h-1m1-4h.01M21 12a9 9 0 11-18 0 9 9 0 0118 0z"
              ></path>
            </svg>
          </div>

          <div className="stat-title text-white">Autor</div>
          <div className="stat-value text-info text-2xl">
            {course.owner.name}
          </div>
        </div>

        <div className="stat">
          <div className="stat-figure text-secondary">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              fill="none"
              viewBox="0 0 24 24"
              className="inline-block w-8 h-8 stroke-current text-white"
            >
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth="2"
                d="M12 6V4m0 2a2 2 0 100 4m0-4a2 2 0 110 4m-6 8a2 2 0 100-4m0 4a2 2 0 110-4m0 4v2m0-6V4m6 6v10m6-2a2 2 0 100-4m0 4a2 2 0 110-4m0 4v2m0-6V4"
              ></path>
            </svg>
          </div>
          <div className="stat-title text-white">Categoría</div>
          <div className="stat-value text-info text-2xl">
            {course.category[0].name ? course.category[0].name : ""}
          </div>
        </div>

        {/* <div className="stat">
          <div className="stat-figure text-secondary">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              fill="none"
              viewBox="0 0 24 24"
              className="inline-block w-8 h-8 stroke-current text-white"
            >
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth="2"
                d="M5 8h14M5 8a2 2 0 110-4h14a2 2 0 110 4M5 8v10a2 2 0 002 2h10a2 2 0 002-2V8m-9 4h4"
              ></path>
            </svg>
          </div>
          <div className="stat-title text-white">Activo</div>
          <div className="stat-value text-info text-2xl">
            {active ? "Si" : "No"}
          </div>
        </div> */}
      </section>
    </main>
  );
};

export default ViewCourse;
