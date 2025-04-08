package org.deo.dev.LibrarySystem.models;

import org.deo.dev.LibrarySystem.enums.Role;

public class JuniorStudent extends Member{
    public JuniorStudent(String name) {
        super(name, Role.JUNIOR_STUDENT);
    }
}
