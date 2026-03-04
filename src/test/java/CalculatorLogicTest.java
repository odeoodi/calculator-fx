import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorLogicTest {


    @Test
    void calculatesCorrectMessage() {
        String msg = CalculatorLogic.calculateMessage("2", "3");
        assertTrue(msg.contains("Sum: 5.0"));
        assertTrue(msg.contains("Product: 6.0"));
        assertTrue(msg.contains("Divisor: 0.666"));
        assertTrue(msg.contains("subtract: -1.0"));
    }

    @Test
    void throwsOnInvalidNumber() {
        assertThrows(NumberFormatException.class,
                () -> CalculatorLogic.calculateMessage("abc", "3"));
    }
}