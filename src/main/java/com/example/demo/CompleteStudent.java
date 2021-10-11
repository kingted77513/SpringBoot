package com.example.demo;

import java.util.LinkedList;
import java.util.List;

public class CompleteStudent {
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
        CompleteStudent completeStudent = new CompleteStudent();
        completeStudent.id = 123;
        completeStudent.name = "Judy";
        completeStudent.score = 95.5;
        completeStudent.graduate = true;
        completeStudent.age = null;
        completeStudent.courseList.add("math");
        completeStudent.courseList.add("english");

        completeStudent.pet = new Pet("black", 5);

        completeStudent.petList.add(new Pet("white", 3));
        completeStudent.petList.add(new Pet("orange", 1));
    }
}
