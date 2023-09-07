import { Category } from "@/model";
import { CategoryCard } from "@/components";
import { getAllCategory } from "@/service";
import { useState, useEffect } from "react";

function Categories() {
  const [categories, setCategories] = useState([]);

  const handleGetCategories = async () => {
    const categoria = await getAllCategory();
    setCategories(categoria);
  };

  useEffect(() => {
    handleGetCategories();
  });
  const categorieList = categories.map((c: Category) => {
    return <CategoryCard id={c.id} name={c.name} />;
  });

  return (
    <div>
      <h2 className="mb-5 text-6xl font-bold text-center p-10">
        Categorias disponibles
      </h2>
      <div className="p-20 flex flex-wrap justify-center gap-20">
        {categorieList.length <= 0 ? (
          <p>No hay ninguna categoria</p>
        ) : (
          categorieList
        )}
      </div>
    </div>
  );
}

export default Categories;
