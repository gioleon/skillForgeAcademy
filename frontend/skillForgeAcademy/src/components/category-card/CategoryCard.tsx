import { Category } from "../../model";

export function CategoryCard({ id, name }: Category) {
  return (
    <div className="card w-96 bg-base-100 shadow-xl">
      {/* <figure>
        <img src={urlImage} alt="Portada course" />
      </figure> */}
      <div className="card-body">
        <h2 className="card-title">{name}</h2>
      </div>
    </div>
  );
}
