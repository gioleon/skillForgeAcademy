import { CourseCard } from "../../../../components/course-card";
import { Course } from "../../../../model";
import { getCourseByIdOwner } from "../../../../service/course.service";
import { useEffect, useState } from "react";

interface Props {
  userId: number;
}

function MyCourses({ userId }: Props) {
  const [courses, setCourses] = useState([]);

  const handleGetCourses = async () => {
    const curso = await getCourseByIdOwner(userId);
    setCourses(curso);
  };

  useEffect(() => {
    handleGetCourses();
  });

  const courseList = courses.map((c: Course) => {
    return (
      <CourseCard
        id={c.id}
        category={c.category}
        name={c.name}
        owner={c.owner}
        description={c.description}
        urlImage={c.urlImage}
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
