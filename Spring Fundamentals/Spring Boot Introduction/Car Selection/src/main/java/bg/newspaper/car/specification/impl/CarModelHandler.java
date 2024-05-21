package bg.softuni.car.specification.impl;

import bg.softuni.car.specification.Handler;
import bg.softuni.car.specification.Specification;
import org.springframework.beans.factory.annotation.Autowired;

public class CarModelHandler extends BaseHandler {
    @Override
    protected boolean canHandle(Car car) {
        return car.getModel() != null;
    }

    @Override
    protected void handleStep(Car car) {
        System.out.println("Car model: " + car.getModel());
    }
}
