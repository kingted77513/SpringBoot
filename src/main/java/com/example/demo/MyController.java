package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/detail")
public class MyController {

    @Autowired
    @Qualifier("hpPrinter")
    private Printer printer1;

    @Autowired
    @Qualifier("canonPrinter")
    private Printer printer2;

    @Autowired
    @Qualifier("myPrinter")
    private Printer printer3;

    @Autowired
    @Qualifier("yourPrinter")
    private Printer printer4;

    @Autowired
    @Qualifier("judyPrinter")
    private Printer printer5;

    @Autowired
    @Qualifier("aopPrinter")
    private Printer printer6;

    @RequestMapping("/test")
    public String test() {
//        printer1.print("Hello world");
//        printer2.print("Hello world");
//        printer3.print("Hello world");
//        printer4.print("Hello world");
//        printer5.print("Hello world");
        printer6.print("Hello world");

        return "Hello World";
    }

    @RequestMapping("/product")
    public Store product() {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("orange");
        Store store = new Store();
        store.setProductList(list);
        return store;
    }

    @RequestMapping("/user")
    public CompleteStudent user() {
        CompleteStudent completeStudent = new CompleteStudent();
        completeStudent.name = "Judy";
        return completeStudent;
    }

    @RequestMapping("/get-method")
    public String getMethod(@RequestParam Integer id, @RequestParam(defaultValue = "Teddy") String name) {
        StringBuilder b = new StringBuilder();
        b.append("id = " + id);
        b.append(System.lineSeparator());
        b.append("name = " + name);
        System.out.println("id = " + id);
        System.out.println("name = " + name);
        return b.toString();
    }

    @RequestMapping("/post-method")
    public Student postMethod(@RequestBody Student student){
        return student;
    }

    @RequestMapping("/get-header")
    public String getHeader(@RequestHeader String info) {
        return "info = " + info;
    }

    @RequestMapping("/get-path/{id}/{name}")
    public String getPath(@PathVariable Integer id, @PathVariable String name) {
        return "id = " + id + ", name = " + name;
    }

    @RequestMapping("/responseEntity")
    public ResponseEntity<String> responseEntity() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("response entity");
    }

    @RequestMapping("/errorTest")
    public ResponseEntity<String> errorTest() {
        throw new RuntimeException("RuntimeException test");
    }

    @RequestMapping("/errorTest2")
    public ResponseEntity<String> errorTest2() {
        throw new IllegalArgumentException("IllegalArgumentException test");
    }
}
