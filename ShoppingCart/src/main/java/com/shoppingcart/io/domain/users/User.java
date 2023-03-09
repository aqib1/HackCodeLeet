package com.shoppingcart.io.domain.users;

import java.util.Objects;
import java.util.UUID;

public class User {
    private final String userUUID;
    private String name;
    private int age;
    private boolean authorizedForAgeRestrictedItems;

    public User(String name, int age, boolean authorizedForAgeRestrictedItems) {
        this(name, age, authorizedForAgeRestrictedItems, UUID.randomUUID().toString());
    }

    public User(String name, int age, boolean authorizedForAgeRestrictedItems, String userUUID) {
        this.name = name;
        this.age = age;
        this.authorizedForAgeRestrictedItems = authorizedForAgeRestrictedItems;
        this.userUUID = userUUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isUnderAge() {
        return !authorizedForAgeRestrictedItems;
    }

    public void setAuthorizedForAgeRestrictedItems(boolean authorizedForAgeRestrictedItems) {
        this.authorizedForAgeRestrictedItems = authorizedForAgeRestrictedItems;
    }

    public String getUserUUID() {
        return userUUID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && authorizedForAgeRestrictedItems == user.authorizedForAgeRestrictedItems && Objects.equals(userUUID, user.userUUID) && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userUUID, name, age, authorizedForAgeRestrictedItems);
    }
}
