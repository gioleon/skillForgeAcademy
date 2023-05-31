import React, { useState, useEffect } from "react";
import { createSection } from "../../../../service";
import { Section, PrivateRoutes } from "../../../../model";
import { useFormik } from "formik";
import * as Yup from "yup";
import { useNavigate, useParams } from "react-router-dom";
import { Error } from "../../../../components";
import { useSelector } from "react-redux";
import { AppStore } from "../../../../redux/store";


function AddSection() {
  const [inputErrors, setInputErrors] = useState(false);
  // getting an instance of useNavigate
  const navigate = useNavigate();
  const { idUser, idCourse } = useParams();

  const numberIdUser = Number.parseInt(idUser!);
  const numberIdCourse = Number.parseInt(idCourse!);

  const user = useSelector((store: AppStore) => store.user);

  useEffect(() => {
    if (
      Number.parseInt(idUser!) !== user.id ||
      idCourse! !== localStorage.getItem("idCourse")!
    ) {
      navigate(
        `/${PrivateRoutes.PRIVATE}/${PrivateRoutes.PROFILE}/${user.id}`,
        {
          replace: true,
        }
      );
    }
  }, []);

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
      course: { id: numberIdCourse },
    };

    // give the user to the method.
    const response = await createSection(section);

    if (response.status === 403) {
    } else if (response.status === 201) {
      // if everything is excelent, go the the register/sucessful page.
      navigate(
        `/${PrivateRoutes.PRIVATE}/${numberIdUser}/${PrivateRoutes.COURSE}/${numberIdCourse}/section/${response.data.id}/tutorship`,
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
    </section>
  );
}
export default AddSection;
