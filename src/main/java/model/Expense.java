package model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int type;
    private String time;
    private String name;
    private double paid;
    private String description;

    public Expense(int type, String name, double paid, String description) {
        this.type = type;
        this.time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        this.name = name;
        this.paid = paid;
        this.description = description;
    }

    public Expense() { }

    public int getId() {
        return (int) id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPaid() {
        return paid;
    }

    public void setPaid(double paid) {
        this.paid = paid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", type=" + type +
                ", time='" + time + '\'' +
                ", name='" + name + '\'' +
                ", paid=" + paid +
                ", description='" + description + '\'' +
                '}';
    }
}
