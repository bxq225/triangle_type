import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTypeTest {

    @Test
    void equilateral() {
        assertEquals("Equilateral", TriangleType.getTriangleType(3, 3, 3));
    }

    @Test
    void isosceles() {
        assertEquals("Isosceles", TriangleType.getTriangleType(1, 2, 2));
    }

    @Test
    void scalene() {
        assertEquals("Scalene", TriangleType.getTriangleType(3, 4, 5));
    }

    @Test
    void degenerate() {
        assertEquals("Invalid triangle", TriangleType.getTriangleType(1, 2, 3));
    }

    @Test
    void zeroSide() {
        assertEquals("Invalid triangle", TriangleType.getTriangleType(0, 1, 1));
    }

    @Test
    void negativeSide() {
        assertEquals("Invalid triangle", TriangleType.getTriangleType(-1, 1, 1));
    }
}
