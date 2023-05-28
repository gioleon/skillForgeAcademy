import React, { useState, useEffect, ChangeEvent, FormEvent } from "react";
import axios from "axios";
import { createCourse } from "../../../../service";
import { Course } from "../../../../model";
import { UserOA } from "../../../../model";
import { CategoryOA } from "../../../../model";

function AddCourse() {
  // Array de categorías
  const categories: CategoryOA[] = [
    { id: 1, name: "Programacion" },
    { id: 2, name: "Matematicas" },
    { id: 3, name: "Ingles" },
    { id: 4, name: "Desarrollo Web" },
    { id: 5, name: "Desarrollo Móvil" },
  ];
  
  const [courseData, setCourseData] = useState<Course>({
    id: 0,
    category: [{id: 0, name: ""}],
    name: "",
    owner: { id: 0, name: "" },
    description: "",
    urlImage: "",
  });

  const handleSubmit = (e: FormEvent) => {
    e.preventDefault();
    createCourse(courseData)
      .then((status) => {
        console.log("Curso creado exitosamente.");
      })
      .catch((status) => {
        console.error("Error al crear el curso.");
      });
  };

  const handleChange = (
    e: ChangeEvent<HTMLInputElement | HTMLTextAreaElement | HTMLSelectElement>
  ) => {
    const { name, value } = e.target;
    setCourseData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  return (
    <>
      <form
        className="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4 max-w-lg"
        onSubmit={handleSubmit}
      >
        <h2 className=" text-4xl font-bold text-center p-10">Crear curso</h2>
        <div className="mb-6">
          <div className="form-control w-full max-w-xs">
            <label className="label">
              <span className="label-text">Titulo del curso</span>
            </label>
            <input
              name="name"
              value={courseData.name}
              onChange={handleChange}
              type="text"
              placeholder="Ejemplo: Backend con java"
              className="input input-bordered w-full max-w-xs"
            />
          </div>
        </div>

        {/* <div className="mb-6">
          <div className="form-control w-full max-w-xs">
            <label className="label">
              <span className="label-text">Categoría del curso</span>
            </label>
            <select
              className="select select-bordered"
              name="category"
              value={courseData.category}
              onChange={handleChange}
            >
              <option disabled value={0}>
                Elige una categoría
              </option>
              {categories.map((category) => (
                <option key={category.id} value={category.id}>
                  {category.name}
                </option>
              ))}
            </select>
          </div>
        </div> */}

        <div className="mb-6">
          <div className="form-control">
            <label className="label">
              <span className="label-text">Descripción del curso</span>
            </label>
            <textarea
              name="description"
              value={courseData.description}
              onChange={handleChange}
              className="textarea textarea-bordered h-24 textarea-md"
              placeholder=""
            ></textarea>
          </div>
        </div>

        <div className="mb-6">
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
        </div>
        <button
          type="submit"
          className="btn btn-block  bg-gray-800 text-white normal-case border-none hover:btn-info"
        >
          Crear curso
        </button>
      </form>
    </>
  );
}
export default AddCourse;
