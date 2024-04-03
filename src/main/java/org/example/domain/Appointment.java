package org.example.domain;

import java.io.Serializable;

public class Appointment implements Serializable {
    private int id;
    private String date;
    private String hour;
    private String reason;
    Patient patient;

    public Appointment(int id, String date, String hour, String reason, Patient patient) {
        this.id = id;
        this.date = date;
        this.hour = hour;
        this.reason = reason;
        this.patient = patient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", hour='" + hour + '\'' +
                ", reason='" + reason + '\'' +
                ", patient=" + patient +
                '}';
    }
}
