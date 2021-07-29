package com.example.demo;

import java.util.LinkedList;
import java.util.List;

public class Student {
    public Integer getId() {
        return id;
    }

    Integer id;

    public String getName() {
        return name;
    }

    String name;
    Double score;
    Boolean graduate;
    Integer age;
    List<String> courseList = new LinkedList<>();
    Pet pet;
    List<Pet> petList = new LinkedList<>();

    public static void main(String[] args) {
        Student student = new Student();
        student.id = 123;
        student.name = "Judy";
        student.score = 95.5;
        student.graduate = true;
        student.age = null;
        student.courseList.add("math");
        student.courseList.add("english");

        student.pet = new Pet("black", 5);

        student.petList.add(new Pet("white", 3));
        student.petList.add(new Pet("orange", 1));
    }
}
