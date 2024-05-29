package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        
        FootballTeam footballTeam1 = (FootballTeam) context.getBean("footballTeam1");
        System.out.println(footballTeam1);
        
        FootballTeam footballTeam2 = (FootballTeam) context.getBean("footballTeam2");
        System.out.println(footballTeam2);
        
        FootballTeam footballTeam3 = (FootballTeam) context.getBean("footballTeam3");
        System.out.println(footballTeam3);
    }
}
