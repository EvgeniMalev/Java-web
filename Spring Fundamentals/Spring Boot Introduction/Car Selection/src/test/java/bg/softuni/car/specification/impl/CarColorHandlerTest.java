import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarColorHandlerTest {

    @Test
    public void testGetCarColor() {
        CarColorHandler handler = new CarColorHandler();
        Car car = new Car("Toyota", "Red");
        String color = handler.getCarColor(car);
        assertEquals("Red", color);
    }

    @Test
    public void testGetCarColorNull() {
        CarColorHandler handler = new CarColorHandler();
        Car car = null;
        String color = handler.getCarColor(car);
        assertEquals("Unknown", color);
    }
}
