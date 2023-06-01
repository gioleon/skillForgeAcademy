import { Link } from "react-router-dom";
import { Course, courseOA } from "../../model";
import { PrivateRoutes } from "../../model";
import { useSelector } from "react-redux";
import { AppStore } from "../../redux/store";

export function CourseCard({
  id,
  category,
  name,
  owner,
  description,
  urlImage,
}: Course | courseOA) {

  const user = useSelector((store: AppStore) => store.user);

  return (
    <article className="card w-96 bg-base-100 shadow-xl">
      <figure>
        <img src={urlImage} alt="Portada course" />
      </figure>
      <div className="card-body">
        <h2 className="card-title">{name}</h2>
        <p>{category ? category[0].name : "Sin categoria"}</p>
        <div className="card-actions justify-end">
          <Link
            to={`/${PrivateRoutes.PRIVATE}/${user.id}/${PrivateRoutes.COURSE}/${id}`}
            className="btn bg-gray-800 text-white normal-case border-none hover:btn-info"
          >
            Ver curso
          </Link>
        </div>
      </div>
    </article>
  );
}
