package org.deodev.LibrarySystem.models;

import org.deodev.LibrarySystem.enums.Role;

public class JuniorStudent extends Member{
    public JuniorStudent(String name) {
        super(name, Role.JUNIOR_STUDENT);
    }
}
