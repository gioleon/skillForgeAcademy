import "./StyledHome.css";
import { Course } from "../../../components/course/Course";
import coursesList from "../../../components/course/data/coursesList";
function Home() {
  return (
    <div className="containerCourses">
      <Course
        titleCourse="Ecuaciones diferenciales"
        autor="Royner Guardo"
        imgCourse="https://images.pexels.com/photos/5212320/pexels-photo-5212320.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        categorie="Matematicas"
      />
      <Course
        titleCourse="Programacion"
        autor="Giovanni Leon"
        imgCourse="https://images.pexels.com/photos/1181474/pexels-photo-1181474.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        categorie="Programacion"
      />
      <Course
        titleCourse="Presente continuo"
        autor="Gabriel Sabatini"
        imgCourse="https://images.pexels.com/photos/968299/pexels-photo-968299.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        categorie="Inglés"
      />
      <Course
        titleCourse="Calculo vectorial"
        autor="Javier Mendoza"
        imgCourse="https://images.pexels.com/photos/3769714/pexels-photo-3769714.jpeg?auto=compress&cs=tinysrgb&w=600"
        categorie="Matematicas"
      />
      <Course
        titleCourse="Fisica mecanica"
        autor="Lucas Rodriguez"
        imgCourse="https://images.pexels.com/photos/714699/pexels-photo-714699.jpeg?auto=compress&cs=tinysrgb&w=600"
        categorie="Fisica"
      />
      <Course
        titleCourse="Artes plasticas"
        autor="Mou Hernandez"
        imgCourse="https://images.pexels.com/photos/1266808/pexels-photo-1266808.jpeg?auto=compress&cs=tinysrgb&w=600"
        categorie="Arte"
      />
    </div>
  );
}
export default Home;
