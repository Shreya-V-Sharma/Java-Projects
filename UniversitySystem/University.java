import java.util.*;


/**
 * Represents a University with students and courses.
 * The university class will maintain an index of students and courses using Maps.
 *   - The keys for the students' map is the Student's ID
 *   - The keys for the courses' map is the Course's Code
 *
 * Your task in this class is to finish the constructor and implement the methods flagged with TODO.
 * I've [Juliano] moved all methods already implemented under the ones you have to implement.
 * You can re-organize the code if you want.
 */
public class University {
    private Map<Integer, Student> studentBody;
    private Map<String, Course> availableCourses;
    private String universityName;
    private String universityMotto;


    public University(String universityName, String universityMotto) {
        this.universityName = universityName;
        this.universityMotto = universityMotto;
        studentBody = new HashMap<>();
        availableCourses = new HashMap<>();
    }

    /**
     * Adds a student to the university roster. Student's cannot be added twice.
     * @param student the student to be added
     * @return true if the student was added, false if the student was already on the map
     */
    public boolean addStudent(Student student) {
        //TODO: Implement the method according to the javadoc
        //if the map contains the student already then just return false
        if (studentBody.containsValue(student)) {
            return false;
        }
        //else, add the student with key from student id
        studentBody.put(student.getIdNumber(), student);
        return true;
    }

    /**
     * Gets a student from the university
     * @param idNumber the student's ID.
     * @return the student object or null if not found
     */
    public Student getStudent(int idNumber){
        //TODO: Implement this getter
        //if has the key
        if(studentBody.containsKey(idNumber))
        {
            return studentBody.get(idNumber);
        }
        //else return null
        return null;
    }

    /**
     * Returns a list containing all students from the university
     * You will have to work with maps and lists on this method.
     * Referer to the document on how to ITERATE over maps. You CANNOT use foreach directly with maps
     * What is the best List type to use? ArrayList or LinkedList? Why?
     *
     * @return A list of all students (the list will be empty if the university is empty)
     */
    public List<Student> getStudents(){
        //TODO: Implement this method
        List<Student> students = new LinkedList<>();
        //for each value in the map
        for(Student sd: studentBody.values())
        {
            students.add(sd);
        }
        return students;
    }

    /**
     * Add a course to the courses offered by the university
     * @param course the course object to be added
     * @return true if the course was added, false if the course was already on the university
     */
    public boolean addCourse(Course course){
        //TODO: Implement this method according to the javadocs
        //if the map contains the course already then just return false
        if (availableCourses.containsValue(course)) {
            return false;
        }
        //else, add the course with key of course code
        availableCourses.put(course.getCourseCode(), course);
        return true;
    }


    /**
     * Adds a course as a pre-requisite to another course. Both courses must already exist
     * in the university's list of offered courses.
     * @param courseID the id of the course you want to add the pre-requisite to
     * @param preReqCourseID the id of the pre-requisite course
     * @return false if either the courseID or preReqCourseID are invalid, true after adding the pre-requisite
     */
    public boolean addRequisiteToCourse(String courseID, String preReqCourseID){
        //TODO: Implement this method
        //if the keys of the courses are not available in the map return false
        if(!availableCourses.containsKey(courseID) || !availableCourses.containsKey(preReqCourseID))
        {
            return false;
        }
        //add to the pre-req
        availableCourses.get(courseID).getPreRequisites().add(availableCourses.get(preReqCourseID));
        return true;
    }

    /**
     * Gets a course from the university
     * @param courseCode the course code.
     * @return the course object associated with the code or null if not found
     */
    public Course getCourse(String courseCode){
        //TODO: implement this method
        return availableCourses.get(courseCode);
    }

    /**
     * Get a list containing all courses offered by the university.
     * You will have to work with maps and lists on this method.
     * Referer to the document on how to ITERATE over maps. You CANNOT use foreach directly with maps
     * What is the best List type to use? ArrayList or LinkedList? Why?
     *
     * @return the list of courses offered by the university
     */
    public List<Course> getCourses(){
        //TODO: Implement this method
        List<Course> courses = new LinkedList<>();
        //for each value in the map
        for(Course c: availableCourses.values())
        {
            courses.add(c);
        }
        return courses;
    }

    /**
     * Enroll a student in a course IF the student has already passed the pre-requisites of the course.
     * Note to 1110 students: remember that students keep two lists of courses.
     *
     * The method should add the student to the course's list of students and add the course to to the student's
     * list of current courses.
     *
     * @param studentID the id of the student
     * @param courseCode the course code for enrollment.
     * @return false if studentID, courseCode are incorrect, false if the student does not have the pre-requisites
     *         true if the student was enrolled in the course.
     *
     * NOTE2: See how false is representing three different issues? Here the "modern" approach would be to use
     *        exceptions (throw an exception) for the wrong id and code problems.
     */
    public boolean enrollStudentInCourse(int studentID, String courseCode){
        //TODO: Implement this method
        //if student id or course code not valid, just return false
        if(!studentBody.containsKey(studentID) || !availableCourses.containsKey(courseCode)) {
            return false;
        }
        Student student = studentBody.get(studentID);
        Course course = availableCourses.get(courseCode);
        //for each required pre-req
        for(Course c: course.getPreRequisites())
        {
            //if the student's previous courses don't have it that required course, return false
            if(!student.getPreviousCourses().contains(c))
            {
                return false;
            }
        }
        //add student to the class and course to the students current courses
        course.getEnrolledStudents().add(student);
        student.enrollInCourse(course);
        return true;
    }

    /**
     * Removes a student from a course IF the student is already enrolled in it.
     * @param studentID the student ID
     * @param courseCode the course code
     * @return false if studentID, courseCode are incorrect, false if the student is not enrolled in the course
     *        true if the student was removed from the course.
     */
    public boolean removeStudentFromCourse(int studentID, String courseCode){
        //TODO: Implement this method
        //if student id or course code not valid, just return false
        if(!studentBody.containsKey(studentID) || !availableCourses.containsKey(courseCode)) {
            return false;
        }
        Student student = studentBody.get(studentID);
        Course course = availableCourses.get(courseCode);
        //if the student is not enrolled in this class(or the course student list don't include student)
        if(!course.getEnrolledStudents().contains(student))
        {
            return false;
        }
        //remove the student(unenroll)
        course.getEnrolledStudents().remove(student);
        student.getEnrolledCourses().remove(course);
        return true;
    }


    /**
     * Removes a student from the university.
     * The student will be removed from the university index AND from the list of students of every course that the
     * student was already enrolled.
     *
     * There are a couple of ways to solve this method. If you iterate over the student's own courses,
     *  you have to be careful not to change the collection while you are iterating (unless you remove with the iterator)
     *
     * @param studentID the id of the student to remove
     * @return false if the studentID is not in the index. True if the student was removed from the index and courses
     */
    public boolean removeStudentFromUniversity(int studentID){
        //TODO: Implement this method
        //if student key not valid
        if(!studentBody.containsKey(studentID))
        {
            return false;
        }

        Student s = studentBody.get(studentID);

        //Iterator for enrolledStudents to remove the student form the class list
        for(Course c: s.getEnrolledCourses())
        {
            Iterator<Student> enrolledStudent = c.getEnrolledStudents().iterator();
            //of all the students in the class, remove the student
            while(enrolledStudent.hasNext())
            {
                Student next = enrolledStudent.next();
                if(next.equals(s))
                {
                    enrolledStudent.remove();
                }
            }
        }


        //iterator for enrolledCourses to remove all the enrolled courses of the student

        Iterator<Course> enrolledCourse = s.getEnrolledCourses().iterator();
        //for all the course that student was enrolled in, remove them
        while(enrolledCourse.hasNext())
        {
            enrolledCourse.next();
            enrolledCourse.remove();
        }


        //remove from the university
        studentBody.remove(studentID);
        return true;
    }

    /**
     * Removes a course from the university.
     * This method should remove the course from the university offered courses
     *     AND from each student's current courses.
     *
     * The method must remove the course from any other courses that have it as a pre-requisite
     *
     * @param courseCode the course code
     * @return false if the course code does not match any offered course. True after the course was removed
     */
    public boolean removeCourseFromUniversity(String courseCode){
        //TODO: Implement this method
        //if course code not valid, just return false
        if(!availableCourses.containsKey(courseCode)) {
            return false;
        }
        Course c = availableCourses.get(courseCode);

        ///iterate over the students that took that course and remove it.
        Iterator<Student> enrolledStudents = c.getEnrolledStudents().iterator();
        while(enrolledStudents.hasNext())
        {
            //remove the course from student
            enrolledStudents.next().getEnrolledCourses().remove(c);
        }

        //iterate over course's prereq and remove this course
        List<Course> preReq;
        for(Course course:availableCourses.values())
        {
            preReq = course.getPreRequisites();
            preReq.remove(c);
        }

        //remove course from the university
        availableCourses.remove(courseCode);
        return true;
    }


    public String getUniversityMotto() {
        return universityMotto;
    }

    public String getUniversityName() {
        return universityName;
    }

    /**
     * Add a new student using name and ID
     * @param name the student's name
     * @param studentID the student's ID between 0 and 999999
     * @return true if the student was added, false if the student was already on the university
     */
    public boolean addStudent(String name, int studentID){
        return addStudent(new Student(name,studentID));
    }

    public boolean addCourse(String name, String courseID){
        return addCourse(new Course(name,courseID));
    }



    @Override
    public String toString() {
        return String.format("%s (%s)\nNumber of Students: %d\nNumber of Courses %d",
                universityName,universityMotto,studentBody.size(),availableCourses.size());
    }

}

