package com.sealed.test;

//sealed classes introduced in java 17
// to control visibility of parent class more
// they will allow only those classes to extends which
// are mentioned in permits

public sealed class Fruit permits Apple, Banana {
}
