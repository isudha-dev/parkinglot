package models;

import java.sql.Time;
import java.util.List;

public class Bill {
    int id;
    Ticket ticket;
    Gate gate;
    Operator operator;
    Float amount;
    Time exitTime;
    List<Payment> paymentList;

}
