package bd.edu.seu;

import java.time.LocalDate;
import java.time.LocalTime;

public class HealthService {
    private LocalDate date;
    private LocalTime time;
    private double weight;
    private int systolic;
    private int diastolic;

    public HealthService(LocalDate date,LocalTime time, double weight, int systolic, int diastolic) {
        this.date = date;
        this.time = time;
        this.weight = weight;
        this.systolic = systolic;
        this.diastolic = diastolic;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getSystolic() {
        return systolic;
    }

    public void setSystolic(int systolic) {
        this.systolic = systolic;
    }

    public int getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(int diastolic) {
        this.diastolic = diastolic;
    }

    @Override
    public String toString() {
        return "HealthService{" +
                "date=" + date +
                ", weight=" + weight +
                ", systolic=" + systolic +
                ", diastolic=" + diastolic +
                '}';
    }
}

