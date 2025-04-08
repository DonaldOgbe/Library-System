package org.deodev.LibrarySystem.models;

import org.deodev.LibrarySystem.enums.Role;

public class SeniorStudent extends Member{
    public SeniorStudent(String name) {
        super(name, Role.SENIOR_STUDENT);
    }
}
