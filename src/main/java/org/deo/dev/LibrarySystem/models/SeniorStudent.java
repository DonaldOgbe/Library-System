package org.deo.dev.LibrarySystem.models;

import org.deo.dev.LibrarySystem.enums.Role;

public class SeniorStudent extends Member{
    public SeniorStudent(String name) {
        super(name, Role.SENIOR_STUDENT);
    }
}
