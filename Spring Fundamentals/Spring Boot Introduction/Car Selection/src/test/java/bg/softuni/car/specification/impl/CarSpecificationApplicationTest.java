import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarSpecificationApplicationTest {

    @Test
    public void testGetCarDetails() {
        CarSpecificationApplication application = new CarSpecificationApplication();
        Car car = new Car("Toyota", "Corolla");
        String details = application.getCarDetails(car);
        assertEquals("Toyota Corolla, Red", details);
    }

    @Test
    public void testGetCarDetailsNull() {
        CarSpecificationApplication application = new CarSpecificationApplication();
        Car car = null;
        String details = application.getCarDetails(car);
        assertEquals("Unknown", details);
    }
}
