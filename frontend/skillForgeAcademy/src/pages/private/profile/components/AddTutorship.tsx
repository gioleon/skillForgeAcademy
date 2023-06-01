import React, { useState } from "react";
import { createTutorShip } from "../../../../service";
import { PrivateRoutes, Tutorship } from "../../../../model";
import { useFormik } from "formik";
import * as Yup from "yup";
import { useNavigate, useParams } from "react-router-dom";
import { Error } from "../../../../components";

function AddTutorship() {
  const [inputErrors, setInputErrors] = useState(false);

  // get parameters from url
  const { idUser, idCourse, idSection } = useParams();

  // getting an instance of useNavigate
  const navigate = useNavigate();

  // validation for form
  const tutorshipSchema = Yup.object().shape({
    name: Yup.string()
      .min(2, "Nombre muy corto")
      .max(50, "Nombre muy largo")
      .required("Nombre es requerido"),
    urlVideo: Yup.string()
      .matches(
        /^https?:\/\/[\w\-]+(\.[\w\-]+)+[/#?]?.*$/,
        "Proporcione una url válida"
      )
      .required("Url video es requerido"),
  });

  // form attributes
  const formik = useFormik({
    initialValues: {
      name: "",
      urlVideo: "",
    },

    onSubmit: (values) => {},

    validationSchema: tutorshipSchema,
  });

  const handleSubmit = async (e: any) => {
    e.preventDefault();

    // check if all fields fullfill the validations.
    // also avoiding clicking the button before interact with the input fields.
    if (!formik.isValid || formik.values.name.length === 0) {
      setInputErrors(true);

      return;
    }

    // if pass that validation, all fields are valid.
    setInputErrors(false);

    // If all fields are validated then let's proceed to try to save user in the database.

    // course
    const tutorship: Tutorship = {
      name: formik.values.name,
      section: {
        id: idSection ? Number.parseInt(idSection) : 0,
        course: { id: idCourse ? Number.parseInt(idCourse) : 0 },
      },
      course: { id: idCourse ? Number.parseInt(idCourse) : 0 },
      urlVideo: formik.values.urlVideo,
    };

    // give the user to the method.
    const response = await createTutorShip(tutorship);

    if (response === 403) {
    } else if (response === 201) {
      // if everything is excelent, go the the register/sucessful page.
      navigate(
        `/${PrivateRoutes.PRIVATE}/${idUser}/${PrivateRoutes.COURSE}/${idCourse}`,
        {
          replace: true,
        }
      );
    }
  };

  return (
    <section className="grid h-screen place-content-center bg-blue-500">
      <form
        className="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4 max-w-lg"
        onSubmit={(e) => {
          handleSubmit(e);
        }}
      >
        <h2 className=" text-4xl font-bold text-center p-10">Crear Tutoría</h2>
        <div className="mb-6">
          <div className="form-control w-full max-w-xs">
            <label className="label">
              <span className="label-text">Nombre de la tutoría</span>
            </label>
            <input
              id="name"
              name="name"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              type="text"
              placeholder="Ejemplo: Conexión a base de datos"
              className="input input-bordered w-full max-w-xs"
            />
            {formik.errors.name ? (
              <Error error={true} message={formik.errors.name} />
            ) : null}
          </div>
        </div>

        <div className="mb-6">
          <div className="form-control w-full max-w-xs">
            <label className="label">
              <span className="label-text">Url video de la tutoría</span>
            </label>
            <input
              id="urlVideo"
              name="urlVideo"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              type="text"
              placeholder="https://video.com"
              className="input input-bordered w-full max-w-xs"
            />
            {formik.errors.urlVideo ? (
              <Error error={true} message={formik.errors.urlVideo} />
            ) : null}
          </div>
        </div>

        {/* <div className="mb-6">
          <div className="form-control w-full max-w-xs">
            <label className="label">
              <span className="label-text">Imagen del curso</span>
            </label>
            <input
              type="file"
              className="file-input file-input-bordered w-full max-w-xs bg-gray-800 text-white normal-case border-none hover:btn-info"
              name="urlImage"
            />
          </div>
        </div> */}
        <button
          type="submit"
          className="btn btn-block  bg-gray-800 text-white normal-case border-none hover:btn-info"
        >
          Crear tutoria
        </button>
        {inputErrors ? <p>Diligencie todos lo campos correctamente</p> : null}
      </form>
    </section>
  );
}
export default AddTutorship;
