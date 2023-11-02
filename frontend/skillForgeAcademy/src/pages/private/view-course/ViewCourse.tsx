import { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import { getAllTutorShipsByCourseId, getCourseById } from "@/service";
import {
  Course,
  PrivateRoutes,
  Rate,
  Section,
  SectionOA
} from "@/model";
import {
  enroll,
  getCourseEnrollments,
  studentIsEnroll,
} from "@/service/enroll.service";
import { timeout } from "rxjs";
import { useSelector } from "react-redux";
import { AppStore } from "@/redux/store";
import { getCourseRates } from "@/service/rate.service";
import { Tutorship } from '@/model/tutorship/tutorship';

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

  const [rates, setRates] = useState<Rate[]>([]);

  const [tutorships, setTutorships] = useState<Tutorship[]>([]);

  const { idUser = "0", idCourse = "0" } = useParams();

  const user = useSelector((store: AppStore) => store.user);
  const [numberOfEnrollment, setNumberOfEnrollment] = useState([]);

  const numberIdUser = Number.parseInt(idUser);
  const numberIdCourse = Number.parseInt(idCourse);

  const getCourse = async () => {
    const foundCourse = await getCourseById(numberIdCourse);
    setCourse(foundCourse);
  };

  const getRates = async () => {
    const rates = await getCourseRates(numberIdCourse);
    setRates(rates);
  };

  const getEnrollments = async () => {
    const foundEnrollments = await getCourseEnrollments(numberIdCourse);
    setNumberOfEnrollment(foundEnrollments);
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
    localStorage.setItem("idCourse", idCourse);
    getTutorShip();
    getCourse();
    getEnrollments();
    studentIsEnrolled();
    getRates();
  }, [enrolled]);

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
    window.location.reload();
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
                {/* <p className="text-lg">{course.description}</p> */}
                <p className="text-lg">{course.description}</p>
              </section>
              {!enrolled && numberIdUser !== course.owner.id ? (
                <div className="py-5 flex gap-2">
                  <Link
                    to={`/${PrivateRoutes.PRIVATE}/${numberIdUser}/${PrivateRoutes.COURSE}/${numberIdCourse}`}
                    className="btn bg-blue-500 normal-case border-none hover:bg-gray-800 hover:text-white "
                  >
                    <button onClick={() => handleEnroll()}>Inscribirme</button>
                  </Link>
                </div>
              ) : null}
              {numberIdUser === course.owner.id ? (
                <div className="py-5 flex gap-2">
                  <Link
                    to={`/${PrivateRoutes.PRIVATE}/${numberIdUser}/${PrivateRoutes.COURSE}/${numberIdCourse}/${PrivateRoutes.SECTION}`}
                    className="btn bg-blue-500 normal-case border-none hover:bg-gray-800 hover:text-white "
                  >
                    Crear nueva sección
                  </Link>
                </div>
              ) : null}
              <div className="py-5 flex gap-2">
                  <Link
                    to={`/${PrivateRoutes.PRIVATE}/${idUser}/${PrivateRoutes.COURSE}/${idCourse}/${PrivateRoutes.SECTION}/1/${PrivateRoutes.TUTORSHIP}/1`}
                    className="btn bg-blue-500 normal-case border-none hover:bg-gray-800 hover:text-white "
                  >
                    Ver clases
                  </Link>
                </div>
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
      <section className="shadow-lg bg-gray-800 container m-auto px-6 mb-5">
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
                d="M5 8h14M5 8a2 2 0 110-4h14a2 2 0 110 4M5 8v10a2 2 0 002 2h10a2 2 0 002-2V8m-9 4h4"
              ></path>
            </svg>
          </div>
          <div className="stat-title text-white">Estudiantes</div>
          <div className="stat-value text-info text-2xl">
            {numberOfEnrollment.length}
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
                d="M5 8h14M5 8a2 2 0 110-4h14a2 2 0 110 4M5 8v10a2 2 0 002 2h10a2 2 0 002-2V8m-9 4h4"
              ></path>
            </svg>
          </div>
          <div className="stat-title text-white">Calificación</div>
          <div className="stat-value text-info text-2xl">
            {rates.length > 0
              ? rates.reduce((total: number, actual: Rate) => {
                  return total + actual.rate;
                }, 0) / rates.length
              : 0}
          </div>
        </div>
      </section>
    </main>
  );
};

export default ViewCourse;
