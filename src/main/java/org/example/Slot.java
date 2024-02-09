package org.example;

import lombok.Data;

@Data
public class Slot {
    private String type;
    private Vehicle vehicle;
    private String ticketId;

    public Slot(String type) {
        this.type = type;
    }
}
