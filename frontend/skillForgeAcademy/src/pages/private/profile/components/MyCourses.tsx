import { Course, courses } from "../../../../components/course";
import { CourseProps } from "../../../../model";

function MyCourses(): JSX.Element {
  const courseList: JSX.Element[] = courses.map((c: CourseProps) => {
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
      <h2 className="mb-5 text-6xl font-bold text-center p-10">
        Mis cursos creados
      </h2>
      <div className="p-20 flex flex-wrap justify-center gap-20">
        {courseList}
      </div>
    </div>
  );
}

export default MyCourses;
