import React, { useState } from "react";
import { createSection } from "../../../../service";
import { Section, PrivateRoutes } from "../../../../model";
import { useFormik } from "formik";
import * as Yup from "yup";
import { useNavigate, useParams } from "react-router-dom";
import { Error } from "../../../../components";

function AddSection() {
  const [inputErrors, setInputErrors] = useState(false);
  // getting an instance of useNavigate
  const navigate = useNavigate();
  const { idCourse } = useParams();

  // validation for form
  const courseSchema = Yup.object().shape({
    name: Yup.string()
      .min(2, "Nombre muy corto")
      .max(50, "Nombre muy largo")
      .required("Nombre es requerido"),
  });

  // form attributes
  const formik = useFormik({
    initialValues: {
      name: "",
    },

    onSubmit: (values) => {},

    validationSchema: courseSchema,
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
    const section: Section = {
      name: formik.values.name,
      course: { id: idCourse ? Number.parseInt(idCourse) : 0 },
    };

    // give the user to the method.
    const response = await createSection(section);

    if (response === 403) {
    } else if (response === 201) {
      // if everything is excelent, go the the register/sucessful page.
      navigate(
        `/${PrivateRoutes.PRIVATE}/${PrivateRoutes.COURSE}/${idCourse}`,
        {
          replace: true,
        }
      );
    }
  };

  return (
    <>
      <form
        className="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4 max-w-lg"
        onSubmit={(e) => {
          handleSubmit(e);
        }}
      >
        <h2 className=" text-4xl font-bold text-center p-10">
          Agregar sección
        </h2>
        <div className="mb-6">
          <div className="form-control w-full max-w-xs">
            <label className="label">
              <span className="label-text">Nombre de la sección</span>
            </label>
            <input
              id="name"
              name="name"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              type="text"
              placeholder="Ejemplo: Seguridad"
              className="input input-bordered w-full max-w-xs"
            />
            {formik.errors.name ? (
              <Error error={true} message={formik.errors.name} />
            ) : null}
          </div>
        </div>
        <button
          type="submit"
          className="btn btn-block  bg-gray-800 text-white normal-case border-none hover:btn-info"
        >
          Crear Seccion
        </button>
        {inputErrors ? <p>Diligencie todos lo campos correctamente</p> : null}
      </form>
    </>
  );
}
export default AddSection;
