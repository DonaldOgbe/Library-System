package org.deo.dev.LibrarySystem.models;

import org.deo.dev.LibrarySystem.enums.Role;

public class Teacher extends Member{
    public Teacher(String name) {
        super(name, Role.TEACHER);
    }
}
