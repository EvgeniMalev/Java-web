package bg.softuni.car.specification.impl;

import bg.softuni.car.specification.Handler;
import bg.softuni.car.specification.Specification;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseHandler implements Handler {
    private Handler successor;

    @Override
    public void handle(Car car) {
        if (this.canHandle(car))
        {
            this.handleStep(car);
        }

        if (this.successor != null)
        {
            this.successor.handle(car);
        }
    }

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    protected abstract boolean canHandle(Car car);

    protected abstract void handleStep(Car car);
}
