import java.util.List;

abstract class CourseType {}
class ExamCourse extends CourseType {}
class AssignmentCourse extends CourseType {}
class ResearchCourse extends CourseType {}

class Course<T extends CourseType> {
    T type;
    Course(T t){ type=t; }
}

class CourseUtil {
    static void printCourses(List<? extends CourseType> list){
        for(CourseType c:list) System.out.println(c);
    }
}
