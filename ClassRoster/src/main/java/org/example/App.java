package org.example;

import org.example.controller.ClassRosterController;
import org.example.dao.ClassRosterDao;
import org.example.dao.ClassRosterDaoFileImpl;
import org.example.ui.ClassRosterView;
import org.example.ui.UserIO;
import org.example.ui.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        ClassRosterView myView = new ClassRosterView(myIo);
        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        ClassRosterController controller = new ClassRosterController(myDao, myView);
        controller.run();
    }
}