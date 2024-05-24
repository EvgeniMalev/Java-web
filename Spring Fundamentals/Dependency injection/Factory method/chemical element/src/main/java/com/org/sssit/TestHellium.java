package org.sssit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.javatpoint.Helium;

public class TestHelium {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-helium.xml");
        Helium helium = (Helium) context.getBean("helium");
        helium.msg();
    }
}
