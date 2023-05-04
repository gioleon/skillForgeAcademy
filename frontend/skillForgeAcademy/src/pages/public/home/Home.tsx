import { Course } from "../../../components/course/Course";
function Home() {
  return (
    <div className="containerCourses">
      <h1 className="containerCourses-title">Últimos cursos disponibles</h1>
      <Course
        titleCourse="Ecuaciones diferenciales"
        autor="Royner Guardo"
        imgCourse="https://images.pexels.com/photos/5212320/pexels-photo-5212320.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        categorie="Matematicas"
      />
      <Course
        titleCourse="Programacion orientada a objetos"
        autor="Giovanni Leon"
        imgCourse="https://images.pexels.com/photos/1181474/pexels-photo-1181474.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        categorie="Programacion"
      />
      <Course
        titleCourse="Presente continuo"
        autor="Gabriel Sabatini"
        imgCourse="https://images.pexels.com/photos/256417/pexels-photo-256417.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        categorie="Inglés"
      />
    </div>
  );
}
export default Home;
