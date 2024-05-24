package org.sssit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.javatpoint.Hydrogen;

public class TestHydrogen {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Hydrogen hydrogen = (Hydrogen) context.getBean("hydrogen");
        hydrogen.msg();
    }
}
