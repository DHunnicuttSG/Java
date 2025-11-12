package org.example.controller;

import org.example.dao.ClassRosterDao;
import org.example.dao.ClassRosterDaoFileImpl;
import org.example.dto.Student;
import org.example.ui.ClassRosterView;
import org.example.ui.UserIO;
import org.example.ui.UserIOConsoleImpl;

import java.util.List;

public class ClassRosterController {

    private ClassRosterDao dao = new ClassRosterDaoFileImpl();
    private ClassRosterView view = new ClassRosterView();
    private UserIO io = new UserIOConsoleImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
            menuSelection = view.printMenuAndGetSelection();

            switch(menuSelection) {
                case 1:
                    listStudents();
                    break;
                case 2:
                    createStudent();
                    break;
                case 3:
                    io.print("View Student");
                    break;
                case 4:
                    io.print("Remove Student");
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
                    io.print("Unknown Command");
            }
        }
        io.print("Goodbye");
    }

    private void createStudent(){
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentId(), newStudent);
        view.displayCreateSuccessBanner();
    }

    private void listStudents(){
        view.displayAllBanner();
        List<Student> studentList = dao.getAllStudents();
        view.displayStudentList(studentList);
    }
}
