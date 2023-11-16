import { Course, PrivateRoutes, SectionOA, Tutorship } from '@/model';
import { getAllTutorShipsByCourseId } from '@/service';
import { useEffect, useState } from 'react';
import { Link, useParams } from 'react-router-dom';

interface Props {
    course: Course,
    setTutorship: React.Dispatch<React.SetStateAction<Tutorship>>,
    tutorship: Tutorship
}

function Tutorships({course, setTutorship, tutorship} : Props) {

    const [tutorships, setTutorships] = useState<Tutorship[]>([]);
    
    // Obtain course id and user id
    const {idUser = "0", idCourse = "0" } = useParams();
    const numberIdUser = Number.parseInt(idUser);
    const numberIdCourse = Number.parseInt(idCourse);
    
    // Get tutorships
    const getTutorShip = async () => {
      if (course.id != 0) {
        const foundTutorShip = await getAllTutorShipsByCourseId(numberIdCourse);
        setTutorships(foundTutorShip);
      }
        
    };

    useEffect(() => {
        getTutorShip();
    }, [tutorship])

    // Get sections
    const sections: SectionOA[] = [];
    const idSections: number[] = [];
  
    for (var i = 0; i < tutorships.length; i++) {
      let id = tutorships[i].section.id;
      if (id !== undefined && !idSections.includes(id)) {
        sections.push(tutorships[i].section);
        idSections.push(id);
      }
    }

    return <>

<section className="container m-auto px-6 py-6">
          <h2 className="text-2xl font-bold leading-tight mb-5 capitalize">
            Temario del curso
          </h2>
          {numberIdUser === course.owner.id ? (
                <div className="py-5 flex gap-2">
                  <Link
                    to={`/${PrivateRoutes.PRIVATE}/${numberIdUser}/${PrivateRoutes.COURSE}/${numberIdCourse}/${PrivateRoutes.SECTION}`}
                    className="btn bg-blue-500 normal-case border-none hover:bg-gray-800 hover:text-white "
                  >
                    Crear nueva sección
                  </Link>
                </div>
              ) : null}
          {sections.map((s: SectionOA, y: number) => {
            return (
              <div
                key={y}
                tabIndex={y}
                className="collapse collapse-open border border-base-300 bg-base-100 rounded-box mt-2"
              >
                <div className="collapse-title text-xl font-medium flex justify-between">
                  {s.name} 
                  {numberIdUser === course.owner.id ? 
                    (<Link
                    to={`/${PrivateRoutes.PRIVATE}/${numberIdUser}/${PrivateRoutes.COURSE}/${numberIdCourse}/${PrivateRoutes.SECTION}/${s.id}/${PrivateRoutes.TUTORSHIP}`}
                    className="btn w-15 flex justify-between bg-blue-500 normal-case border-none hover:bg-gray-800 hover:text-white "
                  >
                    Crear tutoria
                  </Link> ) : null
                  }
                  
                </div>
                <div className="collapse-content">
                  {tutorships.map((t: Tutorship, i: number) => {
                    return t.section.id === s.id ? (
                      <button
                        key={i}
                        onClick={() => setTutorship(t)}
                        className="btn bg-gray-800  mt-1.5 text-lef flex justify-start text-white normal-case border-none hover:btn-info "
                      >
                        {i.toString() + ". " + t.name}
                      </button>
                    ) : null;
                  })}
                  
                </div>
              </div>
            );
          })}
        </section>

    </>
}

export default Tutorships;