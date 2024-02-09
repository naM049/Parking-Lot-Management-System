package org.example;

public class Main {
    public static void main(String[] args) {
        int nFloors = 4;
        int nSlotsPerFloor = 6;
        ParkingLot parkingLot = new ParkingLot("PR1234", nFloors, nSlotsPerFloor);

        System.out.println(parkingLot.getAvailableSlots("car"));

        String ticket1 = parkingLot.parkVehicle("car", "MH-03", "red");
        String ticket2 = parkingLot.parkVehicle("car", "MH-04", "purple");

        for (String element : parkingLot.displayOccupiedSlots("car")) {
            System.out.println(element);
        }

        parkingLot.unParkVehicle(ticket1);
        for (String element : parkingLot.displayOccupiedSlots("car")) {
            System.out.println(element);
        }

        System.out.println("------------------");
        System.out.println(parkingLot.getAvailableSlots("truck"));
        for (String element : parkingLot.displayOccupiedSlots("truck")) {
            System.out.println(element);
        }

        String ticket3 = parkingLot.parkVehicle("truck", "MH-04", "blue");
        String ticket4 = parkingLot.parkVehicle("truck", "MH-05", "red");
        String ticket5 = parkingLot.parkVehicle("truck", "MH-06", "green");
        String ticket6 = parkingLot.parkVehicle("truck", "MH-07", "yellow");
        String ticket7 = parkingLot.parkVehicle("truck", "MH-08", "black");

        for (String element : parkingLot.displayOccupiedSlots("truck")) {
            System.out.println(element);
        }

    }
}