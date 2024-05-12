package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.controller.BookingController;
import org.example.controller.FlightsController;
import org.example.dao.FlightsDao;
import org.example.dao.impl.FlightsFileDao;
import org.example.service.impl.FlightsServiceİmpl;

public class Main {
    public static void main(String[] args) {
        BookingManagmentApp app = new BookingManagmentApp();
        app.configure();
        app.displayMainMenu();
    }
}
