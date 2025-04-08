package org.deodev.LibrarySystem.models;

import org.deodev.LibrarySystem.enums.Role;

public class Teacher extends Member{
    public Teacher(String name) {
        super(name, Role.TEACHER);
    }
}
