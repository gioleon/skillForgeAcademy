import "./Course.css";
export function Course({ titleCourse, autor, imgCourse, categorie }) {
  return (
    <div className="card w-96 bg-base-100 shadow-xl">
      <figure>
        <img src={imgCourse} alt="Portada course" />
      </figure>
      <div className="card-body">
        <h2 className="card-title">{titleCourse}</h2>
        <p>{categorie}</p>
        <div className="card-actions justify-end">
          <button className="btn btn-primary">Ver curso</button>
        </div>
      </div>
    </div>
  );
}
