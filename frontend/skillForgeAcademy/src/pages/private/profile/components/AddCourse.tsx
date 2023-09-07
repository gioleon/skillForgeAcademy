import React, { useState, useEffect } from "react";
import { createCourse, getAllCategory } from "@/service";
import { Category, Course, PrivateRoutes } from "@/model";
import { useFormik } from "formik";
import * as Yup from "yup";
import { useNavigate, useParams } from "react-router-dom";
import { useSelector } from "react-redux";
import { AppStore } from "@/redux/store";
import { Error } from "@/components";



function AddCourse() {
  const [inputErrors, setInputErrors] = useState(false);
  const [categories, setCategories] = useState<Category[]>([
    { id: 0, name: "" },
  ]);

  // Getting params
  const { idUser } = useParams();

  // getting an instance of useNavigate
  const navigate = useNavigate();

  // obtener el usuario global
  const user = useSelector((store: AppStore) => store.user);

  const getCategories = async () => {
    const allCategory = await getAllCategory();
    setCategories(allCategory);
  };

  useEffect(() => {
    if (Number.parseInt(idUser!) !== user.id) {
      navigate(
        `/${PrivateRoutes.PRIVATE}/${PrivateRoutes.PROFILE}/${user.id}`,
        {
          replace: true,
        }
      );
    }
    getCategories();
  }, []);

  // validation for form
  const courseSchema = Yup.object().shape({
    name: Yup.string()
      .min(2, "Nombre muy corto")
      .max(50, "Nombre muy largo")
      .required("Nombre es requerido"),
    description: Yup.string()
      .min(2, "Descripción muy corta")
      .max(500, "Descripción muy largo")
      .required("Descripción es requerida"),
    urlImage: Yup.string()
      .matches(
        /^https?:\/\/[\w\-]+(\.[\w\-]+)+[/#?]?.*$/,
        "Proporcione una url válida"
      )
      .required("Url imagen es requerida"),
  });

  // form attributes
  const formik = useFormik({
    initialValues: {
      name: "",
      description: "",
      category: "",
      owner: {},
      urlImage: "",
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
    const course: Course = {
      name: formik.values.name,
      description: formik.values.description,
      urlImage: formik.values.urlImage,
      owner: { id: user.id },
      category: [{ id: Number.parseInt(formik.values.category) }],
    };

    // give the user to the method.
    const response = await createCourse(course);

    if (response === 403) {
    } else if (response === 201) {
      // if everything is excelent, go the the register/sucessful page.
      navigate(
        `/${PrivateRoutes.PRIVATE}/${PrivateRoutes.PROFILE}/${user.id}`,
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
        <h2 className=" text-4xl font-bold text-center p-10">Crear curso</h2>
        <div className="mb-6">
          <div className="form-control w-full max-w-xs">
            <label className="label">
              <span className="label-text">Titulo del curso</span>
            </label>
            <input
              id="name"
              name="name"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              type="text"
              placeholder="Ejemplo: Backend con java"
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
              <span className="label-text">Categoría del curso</span>
            </label>
            <select
              name="category"
              id="category"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              className="select select-bordered"
            >
              <option value={0}>Elige una categoría</option>
              {categories.map((category) => (
                <option key={category.id} value={category.id}>
                  {category.name}
                </option>
              ))}
            </select>
          </div>
        </div>
        <div className="mb-6">
          <div className="form-control">
            <label className="label">
              <span className="label-text">Descripción del curso</span>
            </label>
            <textarea
              id="description"
              name="description"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              className="textarea textarea-bordered h-24 textarea-md"
              placeholder=""
            ></textarea>
            {formik.errors.description ? (
              <Error error={true} message={formik.errors.description} />
            ) : null}
          </div>
        </div>
        <div className="mb-6">
          <div className="form-control w-full max-w-xs">
            <label className="label">
              <span className="label-text">Titulo del curso</span>
            </label>
            <input
              id="urlImage"
              name="urlImage"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              type="text"
              placeholder="https://image.com"
              className="input input-bordered w-full max-w-xs"
            />
            {formik.errors.urlImage ? (
              <Error error={true} message={formik.errors.urlImage} />
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
          Crear curso
        </button>
        {inputErrors ? <p>Diligencie todos lo campos correctamente</p> : null}
      </form>
    </section>
  );
}
export default AddCourse;
