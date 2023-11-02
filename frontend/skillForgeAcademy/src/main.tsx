import ReactDOM from "react-dom/client";
import App from "./App";
import "./index.css";
import { CourseProvider } from "./components/course-card/CourseContext";


ReactDOM.createRoot(document.getElementById("root") as HTMLElement).render(
  <CourseProvider>
    <App />
  </CourseProvider>
);
