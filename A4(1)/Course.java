import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Class used to represents Courses in a University
 * Courses have a List of Students who are currently enrolled and a List of pre-requisites courses.
 *
 * The class implements the Serializable interface so we can save objects from it to a File.
 */
public class Course implements Serializable {
    private String name;
    private List<Course> preRequisites;
    private List<Student> enrolledStudents;
    private String courseCode;

    /**
     * Creates a new Course object.
     * Considering that students are frequently registering and registering from courses,
     *    what is the ideal List implementation?
     *
     * @param name the name of the course (e.g: Intro to CS)
     * @param courseCode the course's  code (e.g: CSCI 1105)
     */
    public Course(String name, String courseCode) {
        this.name = name;
        this.courseCode = courseCode;
        preRequisites = new ArrayList<>();
        enrolledStudents = new LinkedList<>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public List<Course> getPreRequisites() {
        return preRequisites;
    }


    public List<Student> getEnrolledStudents() { return enrolledStudents;}

    public void addStudentToCourse(Student student){
        enrolledStudents.add(student);
    }

    public String getFullCourseInfo(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s - %s Pre-Requisites: ", courseCode, name));
        for (Course c : preRequisites){
            builder.append(c);
        }
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(courseCode);
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Course)){
            return false;
        }
        Course course = (Course) o;
        return courseCode.equals(course.courseCode);
    }

    @Override
    public String toString() {
        return String.format("%s - %s", courseCode, name);
    }
}
