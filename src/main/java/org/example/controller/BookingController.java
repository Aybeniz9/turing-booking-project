package org.example.controller;

import org.example.service.BookingService;

public class BookingController {
        private final BookingService bookingService;
         public BookingController(BookingService bookingService){
             this.bookingService=bookingService;
         }

}
