import React, { useState } from "react";
import axios from "axios";
import { courses } from "../../../../components/course";

function CreateCourse() {
  return (
    <>
      <form className="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4 max-w-lg">
        <h2 className=" text-4xl font-bold text-center p-10">Crear curso</h2>
        <div className="mb-6">
          <div className="form-control w-full max-w-xs">
            <label className="label">
              <span className="label-text">Titulo del curso</span>
            </label>
            <input
              type="text"
              placeholder="Ejemplo: Backend con java"
              className="input input-bordered w-full max-w-xs"
            />
          </div>
        </div>

        <div className="mb-6">
          <div className="form-control w-full max-w-xs">
            <label className="label">
              <span className="label-text">Categoría del curso</span>
            </label>
            <select className="select select-bordered">
              <option disabled selected>
                Elige una categoría
              </option>
              <option>Programacion</option>
              <option>Matematicas</option>
              <option>Ingles</option>
              <option>Desarrollo Web</option>
              <option>Desarrollo Móvil</option>
            </select>
          </div>
        </div>

        <div className="mb-6">
          <div className="form-control">
            <label className="label">
              <span className="label-text">Descripción del curso</span>
            </label>
            <textarea
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
export default CreateCourse;
