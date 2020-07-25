package com.oocl.cultivation;

public class TicketGenerator {
    public String generate(){
        return String.valueOf((int)((Math.random()*9+1)*1000));
    }
}
