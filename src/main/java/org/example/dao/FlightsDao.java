package org.example.dao;

import org.example.entities.FlightsEntity;


public abstract class FlightsDao implements DAO<FlightsEntity> {
//    private String filePath;
//
//    public FlightsDao(String filePath) {
//        this.filePath = filePath;
//    }
//
//
//    @Override
//    public void save(List<FlightsEntity> entities) {
//        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
//            for (FlightsEntity flight : entities) {
//                writer.println
//                        (flight.getId() + "," + flight.getDestination() + "," +
//                                flight.getDate() + "," + flight.getFreeSpaces());
//            }
//            System.out.println("Flights saved successfully.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void delete(int id) {
//        Iterator<FlightsEntity> iterator = getAllFLights().iterator();
//        while (iterator.hasNext()) {
//            FlightsEntity flight = iterator.next();
//            if (flight.getId().equals(id)) {
//                iterator.remove();
//                System.out.println("Flight with ID " + id + " deleted successfully.");
//                return;
//            }
//        }
//        System.out.println("Flight with ID " + id + " not found.");
//    }
//
//    @Override
//    public Collection<FlightsEntity> findById() {
//        return null;
//    }
//
//    @Override
//    public Collection<FlightsEntity> getAll() {
//        return null;
//    }
//
//    @Override
//    public Optional<FlightsEntity> findOneBy(Predicate<FlightsEntity> predicate) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Collection<FlightsEntity> findAllBy(Predicate<FlightsEntity> predicate) {
//        return null;
//    }
//    @Override
//    public FlightsEntity save(FlightsEntity flightsEntity) {
//        return null;
//    }
//
//    @Override
//    public Collection<FlightsEntity> getAll() {
//        return null;
//    }
//
//    @Override
//    public Optional<FlightsEntity> findOneBy(Predicate<FlightsEntity> predicate) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Collection<FlightsEntity> findAllBy(Predicate<FlightsEntity> predicate) {
//        return null;
//    }

//    private static final String FILE_PATH = "flights_data.txt";
//
//    public List<FlightsEntity> getFlightsFromKievNext24Hours() {
//        List<FlightsEntity> flights = new ArrayList<>();
//        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                FlightsEntity flight = parseFlight(line);
//                if (flight != null && flight.getDestination().startsWith("Kiev") && isWithinNext24Hours(flights.getdateTime())) {
//                    flights.add(flight);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return flights;
//    }
//
//    public FlightsEntity getFlightById(String flightId) {
//        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                FlightsEntity flight = parseFlight(line);
//                if (flight != null && flight.getId().equals(flightId)) {
//                    return flight;
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public List<FlightsEntity> searchFlights(String destination, String date, int numPeople) {
//        List<FlightsEntity> flights = new ArrayList<>();
//        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                FlightsEntity flight = parseFlight(line);
//                if (flight != null && flight.getDestination().equals(destination) && flight.getDate().equals(date) && flight.getFreeSpaces() >= numPeople) {
//                    flights.add(flight);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return flights;
//    }
//
//    private FlightsEntity parseFlight(String line) {
//        String[] parts = line.split(",");
//        if (parts.length == 5) {
//            String id = parts[0];
//            String departure = parts[1];
//            String destination = parts[2];
//            String date = parts[3];
//            int freeSeats = Integer.parseInt(parts[4]);
//            return new FlightsEntity(id, departure, destination, date, freeSeats);
//        }
//        return null;
//    }
//
//    private boolean isWithinNext24Hours(String date) {
//        // Implement logic to check if the given date is within the next 24 hours
//        return true; // Dummy implementation
//    }
}
