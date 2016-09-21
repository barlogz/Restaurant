package ua.goit.java.restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dish")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private DishCategory dishCategory;

    @Column(name = "price")
    private Integer price;

    @Column(name = "weight")
    private Integer weight;

    //for mapping
    @JsonIgnore
    @ManyToMany(mappedBy = "dishes", cascade = CascadeType.ALL)
    private List<Order> order;

    @JsonIgnore
    @ManyToMany(mappedBy = "dishes", cascade = CascadeType.ALL)
    private List<Menu> menu;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "dish_to_ingredients",
            joinColumns = {@JoinColumn(name = "dishId")},
            inverseJoinColumns = {@JoinColumn(name = "ingredientId")}
    )
    private List<Ingredient> ingredients;


    public Dish() {
    }

    public Dish(String name, DishCategory dishCategory, Integer price, Integer weight) {
        this.name = name;
        this.dishCategory = dishCategory;
        this.price = price;
        this.weight = weight;
    }

    @JsonIgnore
    public boolean isNew() {
        return (this.id == null);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DishCategory getDishCategory() {
        return dishCategory;
    }

    public void setDishCategory(DishCategory dishCategory) {
        this.dishCategory = dishCategory;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dish dish = (Dish) o;

        if (name != null ? !name.equals(dish.name) : dish.name != null) return false;
        if (dishCategory != dish.dishCategory) return false;
        if (price != null ? !price.equals(dish.price) : dish.price != null) return false;
        return weight != null ? weight.equals(dish.weight) : dish.weight == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (dishCategory != null ? dishCategory.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "weight=" + weight +
                ", price=" + price +
                ", dishCategory=" + dishCategory +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
