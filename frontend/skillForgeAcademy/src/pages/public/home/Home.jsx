import { Course } from "../../../components/course/Course";
import { HeroLogin } from "../../../components/hero";
import { courses } from "../../../components/course";
function Home() {
  const courseList = courses.map((c) => {
    return (
      <Course
        titleCourse={c.titleCourse}
        autor={c.autor}
        imgCourse={c.imgCourse}
        categorie={c.categorie}
      />
    );
  });
  return (
    <div>
      <HeroLogin />
      <h2 className="mb-5 text-6xl font-bold text-center p-10">
        Cursos disponibles
      </h2>
      <div className="p-20 flex flex-wrap justify-center gap-20">
        {courseList}
      </div>
    </div>
  );
}
export default Home;
