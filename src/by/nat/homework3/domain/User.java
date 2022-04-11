package by.nat.homework3.domain;

import java.util.List;
import java.util.Objects;

public class User {
    private Integer id;
    private String name;
    private String surname;
    private List<User> friends;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, List<User> friends) {
        this.name = name;
        this.friends = friends;
    }

    public User(Integer id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;

    }
    public User(Integer id, String name, String surname, List<User> friends) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.friends = friends;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public List<User> getFriends() {
        return friends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(friends, user.friends);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, friends);
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", friends=" + friends;
    }

}
