package ua.kiev.hitek.start.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.kiev.hitek.start.arduino.Arduino;

import java.util.Scanner;

@SpringBootApplication
public class HiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HiApplication.class, args);
    }
}
