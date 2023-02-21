import { ReactNode } from "react";
import { Route, Routes } from "react-router-dom";

interface Props {
  children: ReactNode;
}

function RoutesWithNotFound({ children }: Props) {
  return (
    <Routes>
      {children}
      <Route path="*" element={<div>Not found</div>}></Route>
    </Routes>
  );
}
export default RoutesWithNotFound;
