import * as React from "react";
import Tabs from "@mui/material/Tabs";
import Tab from "@mui/material/Tab";
import Box from "@mui/material/Box";
import { Course, courseOA } from "@/model";
import { CourseCard } from "@/components";

interface TabPanelProps {
  children?: React.ReactNode;
  index: number;
  value: number;
}

interface coursesInfo {
  createdCourses: Course[];
  enrolledCourses: courseOA[];
}

function TabPanel(props: TabPanelProps) {
  const { children, value, index, ...other } = props;

  return (
    <div
      role="tabpanel"
      hidden={value !== index}
      id={`simple-tabpanel-${index}`}
      aria-labelledby={`simple-tab-${index}`}
      {...other}
    >
      {value === index && <Box sx={{ p: 3 }}>{children}</Box>}
    </div>
  );
}

function a11yProps(index: number) {
  return {
    id: `simple-tab-${index}`,
    "aria-controls": `simple-tabpanel-${index}`,
  };
}

export default function BasicTabs({
  createdCourses,
  enrolledCourses,
}: coursesInfo) {
  const [value, setValue] = React.useState(0);

  const handleChange = (event: React.SyntheticEvent, newValue: number) => {
    setValue(newValue);
  };

  return (
    <Box sx={{ width: "100%" }}>
      <Box
        sx={{
          borderBottom: 1,
          borderColor: "divider",
          display: "flex",
          flexDirection: "column",
          alignItems: "center",
        }}
      >
        <Tabs
          value={value}
          onChange={handleChange}
          aria-label="basic tabs example"
        >
          <Tab
            label="Cursos creados"
            {...a11yProps(0)}
            sx={{
              fontWeight: "bold",
            }}
          />
          <Tab
            label="Cursos inscritos"
            {...a11yProps(1)}
            sx={{
              fontWeight: "bold",
            }}
          />
        </Tabs>
      </Box>
      <TabPanel value={value} index={0}>
        <div className="p-20 flex flex-wrap justify-center gap-20">
          {createdCourses.length > 0
            ? createdCourses.map((c: Course, index) => {
                return (
                  <CourseCard
                    key={c.id} // Aquí estás usando 'id' como clave
                    id={c.id}
                    category={c.category}
                    name={c.name}
                    owner={c.owner}
                    description={c.description}
                    urlImage={c.urlImage}
                  />
                );
              })
            : "No hay cursos para mostrar"}
        </div>
      </TabPanel>
      <TabPanel value={value} index={1}>
        <div className="p-20 flex flex-wrap justify-center gap-20">
        {enrolledCourses.length > 0
            ? enrolledCourses.map((c: courseOA, index) => {
                return (
                  <CourseCard
                    key={c.id} // Aquí estás usando 'id' como clave
                    id={c.id}
                    category={c.category}
                    name={c.name!}
                    owner={c.owner!}
                    description={c.description!}
                    urlImage={c.urlImage!}
                  />
                );
              })
            : "No hay cursos para mostrar"}
        </div>
      </TabPanel>
    </Box>
  );
}
