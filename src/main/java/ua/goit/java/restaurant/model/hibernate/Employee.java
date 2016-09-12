package ua.goit.java.restaurant.model.hibernate;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name= "employee")
public class Employee {
//
//    private Long id;
//
//    private String name;
//
//    private String surname;
//
//    private String phoneNumber;
//
//    private Position position;
//
//    private Float salary;

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "position_id")
    private int positionId;

    @Enumerated(EnumType.STRING)
    @Column(name = "position")
    private Position position;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "salary")
    private int salary;

}
