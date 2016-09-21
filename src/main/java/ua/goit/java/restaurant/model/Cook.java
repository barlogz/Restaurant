package ua.goit.java.restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Cook extends Employee{

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "employeeId")
    private List<PreparedDish> preparedDishes;

    public List<PreparedDish> getPreparedDishes() {
        return preparedDishes;
    }

    public void setPreparedDishes(List<PreparedDish> preparedDishes) {
        this.preparedDishes = preparedDishes;
    }

    @Override
    public String toString() {
        return "Cook{" +
                "preparedDishes=" + preparedDishes +
                "} " + super.toString();
    }
}
