package com.dependencyinversion;

public class Project  {
    private final Dev dev;
    public Project(Dev dev) {
        this.dev = dev;
    }

    public void work() {
        this.dev.develop();
    }
}
