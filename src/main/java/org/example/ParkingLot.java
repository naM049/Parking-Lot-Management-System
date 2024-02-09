package org.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class ParkingLot {
    private String id;
    private List<List<Slot>> slots;

    public ParkingLot(String id, int noFloors, int noSlotsPerFloor) {
        this.id = id;
        this.slots = new ArrayList<>();
        for (int i = 0; i < noFloors; i++) {
            List<Slot> floor = new ArrayList<>();
            floor.add(new Slot("truck"));
            floor.add(new Slot("bike"));
            floor.add(new Slot("bike"));
            for (int j = 3; j < noSlotsPerFloor; j++) {
                floor.add(new Slot("car"));
            }
            this.slots.add(floor);
        }
    }

    public String parkVehicle(String type, String registration, String color) {
        Vehicle vehicle = new Vehicle(type, registration, color);
        for (List<Slot> floor : slots) {
            for (Slot slot : floor) {
                if (slot.getType().equals(vehicle.type()) && slot.getVehicle() == null) {
                    slot.setVehicle(vehicle);
                    slot.setTicketId(this.id + "-" + slots.indexOf(floor) + "-" + floor.indexOf(slot));
                    return slot.getTicketId();
                }
            }
        }
        System.out.println("No slots available for " + vehicle.type() + " type vehicle");
        return null;
    }

    public void unParkVehicle(String ticketId) {
        String[] ticket = ticketId.split("-");
        int floor = Integer.parseInt(ticket[1]);
        int slot = Integer.parseInt(ticket[2]);
        slots.get(floor).get(slot).setVehicle(null);
        slots.get(floor).get(slot).setTicketId(null);
    }

    public int getAvailableSlots(String type) {
        int count = 0;
        for (List<Slot> floor : slots) {
            for (Slot slot : floor) {
                if (slot.getType().equals(type) && slot.getVehicle() == null) {
                    count++;
                }
            }
        }
        return count;
    }

    public List<String> displayAvailableSlots(String type) {
        List<String> availableSlots = new ArrayList<>();
        for (List<Slot> floor : slots) {
            for (Slot slot : floor) {
                if (slot.getVehicle() == null && slot.getType().equals(type)) {
                    String result = "Slot available at floor number " +  slots.indexOf(floor) + " in slot " + floor.indexOf(slot);
                    availableSlots.add(result);
                }
            }
        }
        return availableSlots;
    }

    public List<String> displayOccupiedSlots(String type) {
        List<String> occupiedSlots = new ArrayList<>();
        for (List<Slot> floor : slots) {
            for (Slot slot : floor) {
                if (slot.getVehicle() != null && slot.getType().equals(type)) {
                    String result = "Slot number " + floor.indexOf(slot) + " occupied at floor number " + slots.indexOf(floor) + " by " + slot.getVehicle();
                    occupiedSlots.add(result);
                }
            }
        }
        return occupiedSlots;
    }
}
