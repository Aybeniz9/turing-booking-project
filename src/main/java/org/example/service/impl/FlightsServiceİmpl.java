package org.example.service.impl;

import org.example.dao.FlightsDao;
import org.example.service.FlightsService;

public class FlightsServiceİmpl implements FlightsService {
    private final FlightsDao flightsDao;

    public FlightsServiceİmpl(FlightsDao flightsDao) {
        this.flightsDao = flightsDao;
    }
}
