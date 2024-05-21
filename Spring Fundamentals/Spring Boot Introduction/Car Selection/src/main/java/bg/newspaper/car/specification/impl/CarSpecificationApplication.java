package bg.softuni.car.specification;

import bg.softuni.car.specification.impl.CarColorHandler;
import bg.softuni.car.specification.impl.CarModelHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarSpecificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarSpecificationApplication.class, args);

        Handler carColorHandler = new CarColorHandler();
        Handler carModelHandler = new CarModelHandler();

        carColorHandler.setSuccessor(carModelHandler);

        Car car = new Car("Toyota", "Red");
        carColorHandler.handle(car);
    }
}
