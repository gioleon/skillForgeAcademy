import { Link } from "react-router-dom";
import { Course } from "../../model";


export function CourseCard({id,
  category,
  name,
  owner,
  description,
  urlImage}: Course) {
  return (
    <div className="card w-96 bg-base-100 shadow-xl">
      <figure>
        <img src={urlImage} alt="Portada course" />
      </figure>
      <div className="card-body">
        <h2 className="card-title">{name}</h2>
        <p>{category[1].name}</p>
        <div className="card-actions justify-end">
          <Link
            to={`/${name}`}
            className="btn bg-gray-800 text-white normal-case border-none hover:btn-info"
          >
            Ver curso
          </Link>
        </div>
      </div>
    </div>
  );
}
