package org.example.ui;

import org.example.dto.Student;

import java.util.List;

public class ClassRosterView {

    private UserIO io;

    public ClassRosterView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection(){
        io.print("Main Menu");
        io.print("1. List Student IDs");
        io.print("2. Create New Student");
        io.print("3. View a Student");
        io.print("4. Remove a Student");
        io.print("5. Exit");

        return io.readInt("Please select from the above choices", 1, 5);
    }

    // ***** Add New Student *****

    public Student getNewStudentInfo() {
        String studentId = io.readString("Enter Student Id:");
        String firstName = io.readString("Enter First Name:");
        String lastName = io.readString("Enter Last Name:");
        String cohort = io.readString("Cohort:");
        Student currentStudent = new Student(studentId);
        currentStudent.setFirstName(firstName);
        currentStudent.setLastName(lastName);
        currentStudent.setCohort(cohort);
        return currentStudent;
    }

    public void displayCreateStudentBanner() {
        io.print("=== Create Student ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString("Student successfully created.  Please hit enter to continue");
    }

    // ***** Display All Students *****

    public void displayStudentList(List<Student> studentList){
        for (Student cs : studentList){
            String studentInfo = String.format("#%s : %s %s",
                    cs.getStudentId(), cs.getFirstName(), cs.getLastName());
            io.print(studentInfo);
        }
        io.readString("Hit enter to continue.");
    }

    public void displayAllBanner() {
        io.print("=== Display All Students ===");
    }

    // ***** Display Student *****

    public void displayStudentBanner () {
        io.print("=== Display Student ===");
    }

    public String getStudentIdChoice() {
        return io.readString("Please enter the Student ID.");
    }

    public void displayStudent(Student student) {
        if (student != null) {
            io.print(student.getStudentId());
            io.print(student.getFirstName() + " " + student.getLastName());
            io.print(student.getCohort());
            io.print("");
        } else {
            io.print("No such student.");
        }
        io.readString("Please hit enter to continue.");
    }

    // ***** Remove Student *****

    public void displayRemoveStudentBanner () {
        io.print("=== Remove Student ===");
    }

    public void displayRemoveResult(Student studentRecord) {
        if(studentRecord != null){
            io.print("Student successfully removed.");
        }else{
            io.print("No such student.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
