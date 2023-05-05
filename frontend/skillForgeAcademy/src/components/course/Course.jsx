import { StyledButton } from "../navbar";
export function Course({ titleCourse, autor, imgCourse, categorie }) {
  return (
    <article className="cr-courseCard">
      <header className="cr-courseCard-header">
        <img src={imgCourse} alt="" className="cr-courseCard-image" />
      </header>
      <h2 className="cr-courseCard-title">{titleCourse}</h2>
      <div className="cr-courseCard-content">
        <p className="cr-courseCard-autor">{autor}</p>
        <a href="">{categorie}</a>
      </div>
      <button href="" className="cr-courseCard-btn-view">
        Ver curso
      </button>
    </article>
  );
}
