import React, { createContext, useState, useEffect, ReactNode } from 'react';
import { Course } from "@/model";
import { getAllCourse, getCourseByName } from "@/service/course.service";

interface CourseContextProps {
  courses: Course[];
  searchTerm: string;
  setSearchTerm: (term: string) => void;
}

export const CourseContext = createContext<CourseContextProps>({
  courses: [],
  searchTerm: '',
  setSearchTerm: () => {},
});

interface CourseProviderProps {
    children: ReactNode;
  }

  export const CourseProvider: React.FC<CourseProviderProps> = ({ children }) =>  {
  const [courses, setCourses] = useState<Course[]>([]);
  const [searchTerm, setSearchTerm] = useState('');

  const handleGetCourses = async () => {
    try {
      const curso = await getAllCourse();
      setCourses(curso);
    } catch (error) {
      console.error('Error fetching courses:', error);
    }
  };

  useEffect(() => {
    handleGetCourses();
  }, []);

  useEffect(() => {
    if (searchTerm) {
        getCourseByName(searchTerm).then(data => setCourses(data));
    } else {
      handleGetCourses();
    }
  }, [searchTerm]);

  return (
    <CourseContext.Provider value={{ courses, searchTerm, setSearchTerm }}>
      {children}
    </CourseContext.Provider>
  );
};
