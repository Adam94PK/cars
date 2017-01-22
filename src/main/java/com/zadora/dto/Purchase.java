package com.zadora.dto;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by adam on 20.01.2017.
 */

@Entity
public class Purchase {

    private Long id;
    private User user;
    private Car car;
    private Date createDate;

    public Purchase(User user, Car car) {
        this.user = user;
        this.car = car;
        this.createDate = new Date();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @ManyToOne
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @OneToOne
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
