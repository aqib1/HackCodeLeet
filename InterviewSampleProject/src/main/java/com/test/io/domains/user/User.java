package com.test.io.domains.user;

public class User {
    private String name;
    private int age;
    private boolean isUnderAge;

    public User(String name, int age, boolean isUnderAge) {
        this.name = name;
        this.age = age;
        this.isUnderAge = isUnderAge;
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
        return isUnderAge;
    }

    public void setUnderAge(boolean underAge) {
        isUnderAge = underAge;
    }
}
