import React, { useContext } from "react";
import { CourseCard } from "@/components/course-card/CourseCard";
import { HeroLogin } from "@/components/hero";
import { CourseContext } from "@/components/course-card/CourseContext";


function Home() {
  const { courses } = useContext(CourseContext);

  const courseList = courses.map((c) => (
    <CourseCard
      key={c.id}
      id={c.id}
      category={c.category}
      name={c.name}
      owner={c.owner}
      description={c.description}
      urlImage={c.urlImage}
    />
  ));

  return (
    <div>
       <HeroLogin />
      <h2 className="mb-5 text-6xl font-bold text-center p-10">
        Cursos disponibles
      </h2>
      <div className="p-20 flex flex-wrap justify-center gap-20">
        {courseList.length <= 0 ? <p>No hay cursos disponibles</p> : courseList}
      </div>
    </div>
  );
}

export default Home;
