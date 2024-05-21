package bg.softuni.car.specification.impl;

import bg.softuni.car.specification.Handler;
import bg.softuni.car.specification.Specification;
import org.springframework.beans.factory.annotation.Autowired;

public class CarColorHandler extends BaseHandler {
    @Override
    protected boolean canHandle(Car car) {
        return car.getColor() != null;
    }

    @Override
    protected void handleStep(Car car) {
        System.out.println("Car color: " + car.getColor());
    }
}
