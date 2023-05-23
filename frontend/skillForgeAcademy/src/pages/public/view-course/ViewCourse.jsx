const ViewCourse = ({ course }) => {
  const { titleCourse, autor, imgCourse, categorie, description } = course;

  return (
    <section>
      <figure className="relative transition-all duration-300 cursor-pointer filter grayscale hover:grayscale-0">
        <a href="#">
          <img className="rounded-lg" src={imgCourse} alt="image course" />
        </a>
        <figcaption className="absolute px-4 text-lg text-white bottom-6">
          <p>{titleCourse}</p>
        </figcaption>
      </figure>
      <div className="card w-96 bg-base-100 shadow-xl">
        <div className="card-body">
          <h2 className="card-title">Registrate</h2>
          <p>{description}</p>
          <div className="card-actions justify-end">
            <button className="btn btn-primary">Registrarse</button>
          </div>
        </div>
      </div>
    </section>
  );
};

export default ViewCourse;
