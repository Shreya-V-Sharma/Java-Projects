import java.io.*;
import java.util.*;

/**
 * Class used to represent students in a University
 * Students have a collection of courses they are currently taking and a history of courses they have passed.
 * Students cannot have duplicates on the enrolled courses or the history of courses
 * e.g., A student cannot enroll at the same course twice
 *
 * It is your job as the programmer of this class to choose the appropriate collection from the JCF for the
 *   enrolledCourses and previousCourses variables.
 *
 *
 * The class implements the Serializable interface so we can save objects from it to a File if we want to.
 */
public class Student implements Serializable {
    private String name;
    private int idNumber;
    //TODO: Choose a type for the enrolledCourses and previousCourses variables

    //private ??? enrolledCourses;
    private Set<Course> enrolledCourses;
    //private ??? previousCourses;
    private Set<Course> previousCourses;

    /**
     * Creates a new Student object given a name and an iD Number
     *
     * @param name     The student's full name.
     * @param idNumber The student's idNumber, between 0 and 999999
     */
    public Student(String name, int idNumber) {
        //TODO: Initialize the collection variables here
        this.name = name;
        this.idNumber = idNumber;
        enrolledCourses = new HashSet<>();
        previousCourses = new HashSet<>();
    }

    /**
     * Returns the student's courses.
     * <p>
     * Question to students:
     * Instead of returning the collection(variable), we could return a copy of the collection.
     * Why is it a good idea to return a copy instead of simply returning the list itself?
     * How are we limiting access to the enrolledCourses variable?
     * <p>
     * You don't have to answer this question anywhere in the assignment BUT if you
     * can't think of why, ask me two weeks after this assignment is released
     *
     * @return the student's courses.
     */
    public Set<Course> getEnrolledCourses() {
        //TODO: fix the return type after you've chosen the variable types
        return enrolledCourses;
    }

    /**
     * Returns the previous courses. Same question as getEnrolledCourses applies
     *
     * @return the student's previous courses (PASS Mark)
     */
    public Set<Course> getPreviousCourses() {
        //TODO: fix the return type after you've chosen the variable types
        return previousCourses;
    }

    public int getIdNumber() {
        return idNumber;
    }

    /**
     * Enrolls the student in a course
     *
     * @param course the course to be added to the student's current course load.
     */
    public void enrollInCourse(Course course) {
        enrolledCourses.add(course);
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;
        return idNumber == student.idNumber;
    }

    public String getFullStudentInfo() {
        //Here is an example on how to use the StringBuilder class to avoid concatenation of Strings (+=) in loops
        //Why? Strings are immutable. Every time we += we are creating a new String.
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("Student %s (%06d) - Course Load: ", name, idNumber));
        if (enrolledCourses.size() == 0) {
            stringBuilder.append("none");
        } else {
            int i = enrolledCourses.size();
            for (Course course : enrolledCourses) {
                stringBuilder.append(course.toString());
                if (i > 1) {
                    stringBuilder.append(", ");
                    i--;
                }
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return String.format("Student %s (%06d)", name, idNumber);
    }

    /**
     * Writes a list of students to a file IN BINARY FORMAT.
     * This is an example on how to store instances of objects to a file (or send it over the network if you want)
     * What we are doing here is Serializing objects of students into bytes. For this to work, the student class
     * and all of its instances' variables MUST implement the Serializable interface.
     * The file is a binary file, therefore it is not human readable
     * <p>
     * You don't need this method for the assignment. It is here as an example on how to save objects (there are multiple ways)
     *
     * @param students A list containing the students
     * @param filename The output filename (or fully qualified path)
     * @return true if writing was successful, false otherwise
     */
    public static boolean writeStudentsToFile(List<Student> students, String filename) {
        try {
            FileOutputStream stream = new FileOutputStream(filename);
            ObjectOutputStream output = new ObjectOutputStream(stream);
            output.writeObject(students);
            output.close();
            ;
            stream.close();
            return true;
        } catch (IOException e) {
            System.out.println("Hm.... something went wrong while saving to the file. Here is the stack trace: ");
            e.printStackTrace();
        }
        return false;
    }

    /**
     * This method is the opposite of writeStudentToFile as it will load a list of students from a file
     *
     * @param filename the filename or fully qualified path to a file
     * @return A list of students or null if we could not find the file
     */
    public static List<Student> loadStudentsFromFile(String filename) {
        try {
            FileInputStream stream = new FileInputStream(filename);
            ObjectInputStream input = new ObjectInputStream(stream);
            @SuppressWarnings(value = "unchecked")
            List<Student> students = (List<Student>) input.readObject();
            input.close();
            stream.close();
            return students;

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Something went wrong while reading the students from file... here is the trace: ");
            e.printStackTrace();
        }

        return null;
    }
}
