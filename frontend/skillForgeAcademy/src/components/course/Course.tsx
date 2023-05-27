import { Link } from "react-router-dom";
import { CourseProps } from "../../model";


export function Course({
  titleCourse,
  autor,
  imgCourse,
  categorie,
}: CourseProps) {
  return (
    <div className="card w-96 bg-base-100 shadow-xl">
      <figure>
        <img src={imgCourse} alt="Portada course" />
      </figure>
      <div className="card-body">
        <h2 className="card-title">{titleCourse}</h2>
        <p>{categorie}</p>
        <div className="card-actions justify-end">
          <Link
            to={`/${titleCourse}`}
            className="btn bg-gray-800 text-white normal-case border-none hover:btn-info"
          >
            Ver curso
          </Link>
        </div>
      </div>
    </div>
  );
}
