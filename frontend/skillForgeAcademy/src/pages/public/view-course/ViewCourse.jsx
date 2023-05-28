const ViewCourse = ({ course}) => {
  const { titleCourse, autor, imgCourse, categorie, description, active } =
    course;

  return (
    <section>
      <div className="py-16">
        <div className="container m-auto px-6">
          <div className="lg:flex justify-between items-center">
            <div className="lg:w-6/12 lg:p-0 p-7">
              <h1 className="text-4xl font-bold leading-tight mb-5 capitalize">
                {titleCourse}
              </h1>
              <p className="text-lg">{description}</p>
              <div className="py-5 flex gap-2">
                <a
                  href="#"
                  className="btn btn-info normal-case border-none hover:bg-gray-800 hover:text-white "
                >
                  Registrarme
                </a>
                <a
                  href="#"
                  className="btn btn-info normal-case border-none hover:bg-gray-800 hover:text-white "
                >
                  Ver curso
                </a>
              </div>
            </div>
            <div className="lg:w-5/12 order-2">
              <img
                src={imgCourse}
                style={{
                  transform:
                    "scale(1) perspective(1040px) rotateY(-11deg) rotateX(2deg) rotate(2deg)",
                }}
                alt=""
                className="rounded"
              />
            </div>
          </div>
        </div>
      </div>

      <div className="shadow-lg bg-gray-800 container m-auto px-6">
        <div className="stat">
          <div className="stat-figure text-secondary">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              fill="none"
              viewBox="0 0 24 24"
              className="inline-block w-8 h-8 stroke-current text-white"
            >
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth="2"
                d="M13 16h-1v-4h-1m1-4h.01M21 12a9 9 0 11-18 0 9 9 0 0118 0z"
              ></path>
            </svg>
          </div>

          <div className="stat-title text-white">Autor</div>
          <div className="stat-value text-info text-2xl">{autor}</div>
        </div>

        <div className="stat">
          <div className="stat-figure text-secondary">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              fill="none"
              viewBox="0 0 24 24"
              className="inline-block w-8 h-8 stroke-current text-white"
            >
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth="2"
                d="M12 6V4m0 2a2 2 0 100 4m0-4a2 2 0 110 4m-6 8a2 2 0 100-4m0 4a2 2 0 110-4m0 4v2m0-6V4m6 6v10m6-2a2 2 0 100-4m0 4a2 2 0 110-4m0 4v2m0-6V4"
              ></path>
            </svg>
          </div>
          <div className="stat-title text-white">Categoría</div>
          <div className="stat-value text-info text-2xl">{categorie}</div>
        </div>

        <div className="stat">
          <div className="stat-figure text-secondary">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              fill="none"
              viewBox="0 0 24 24"
              className="inline-block w-8 h-8 stroke-current text-white"
            >
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth="2"
                d="M5 8h14M5 8a2 2 0 110-4h14a2 2 0 110 4M5 8v10a2 2 0 002 2h10a2 2 0 002-2V8m-9 4h4"
              ></path>
            </svg>
          </div>
          <div className="stat-title text-white">Activo</div>
          <div className="stat-value text-info text-2xl">
            {active ? "Si" : "No"}
          </div>
        </div>
      </div>
    </section>
  );
};

export default ViewCourse;
