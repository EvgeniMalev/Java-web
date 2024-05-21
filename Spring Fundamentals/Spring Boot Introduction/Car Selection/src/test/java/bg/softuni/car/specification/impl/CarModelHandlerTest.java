import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarModelHandlerTest {

    @Test
    public void testGetCarModel() {
        CarModelHandler handler = new CarModelHandler();
        Car car = new Car("Toyota", "Corolla");
        String model = handler.getCarModel(car);
        assertEquals("Corolla", model);
    }

    @Test
    public void testGetCarModelNull() {
        CarModelHandler handler = new CarModelHandler();
        Car car = null;
        String model = handler.getCarModel(car);
        assertEquals("Unknown", model);
    }
}
