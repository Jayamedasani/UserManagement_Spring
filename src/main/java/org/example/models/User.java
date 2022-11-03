package org.example.models;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Objects;

public class User {
    private String name,city;
    private BigInteger phnno;
    private LocalDate dob;
    public User() {
    }
    public User(String name, String city, BigInteger phnno, LocalDate dob) {
        this.name = name;
        this.city = city;
        this.phnno = phnno;
        this.dob = dob;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public BigInteger getPhnno() {
        return phnno;
    }

    public void setPhnno(BigInteger phnno) {
        this.phnno = phnno;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(city, user.city) && Objects.equals(phnno, user.phnno) && Objects.equals(dob, user.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city, phnno, dob);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", phnno=" + phnno +
                ", dob=" + dob +
                '}';
    }
}
