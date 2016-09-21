package ua.goit.java.restaurant.model;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "prepared_dish")
public class PreparedDish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne // not final, may be @ManyToMany
    @JoinColumn(name = "dishId")
    private Dish dish;

    @Column
    @Type(type = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cookingDate;

    @OneToOne
    @JoinColumn(name = "employeeId")
    private Employee cook;

    public PreparedDish() {
    }

    public PreparedDish(Dish dish, Date cookingDate, Employee cook) {
        this.dish = dish;
        this.cookingDate = cookingDate;
        this.cook = cook;
    }

    public boolean isNew() {
        return (this.id == null);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Date getCookingDate() {
        return cookingDate;
    }

    public void setCookingDate(Date cookingDate) {
        this.cookingDate = cookingDate;
    }

    public Employee getCook() {
        return cook;
    }

    public void setCook(Employee cook) {
        this.cook = cook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PreparedDish that = (PreparedDish) o;

        if (dish != null ? !dish.equals(that.dish) : that.dish != null) return false;
        if (cookingDate != null ? !cookingDate.equals(that.cookingDate) : that.cookingDate != null) return false;
        return cook != null ? cook.equals(that.cook) : that.cook == null;
    }

    @Override
    public int hashCode() {
        int result = dish != null ? dish.hashCode() : 0;
        result = 31 * result + (cookingDate != null ? cookingDate.hashCode() : 0);
        result = 31 * result + (cook != null ? cook.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PreparedDish{" +
                "id=" + id +
                ", dish=" + dish +
                ", cookingDate=" + cookingDate +
                ", cook=" + cook +
                '}';
    }
}
