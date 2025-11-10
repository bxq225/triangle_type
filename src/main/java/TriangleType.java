import java.util.Arrays;
import java.util.Scanner;

public class TriangleType {

    /**
     * Determines the type of a triangle based on its three side lengths.
     *
     * @param side1 length of the first side
     * @param side2 length of the second side
     * @param side3 length of the third side
     * @return a string representing the type of triangle:
     *         <ul>
     *             <li>"Equilateral" if all three sides are equal</li>
     *             <li>"Isosceles" if exactly two sides are equal</li>
     *             <li>"Scalene" if all three sides are different</li>
     *             <li>"Invalid triangle" if the sides cannot form a triangle</li>
     *         </ul>
     */
    public static String getTriangleType(double side1, double side2, double side3) {
        double[] sides = new double[]{side1, side2, side3};
        Arrays.sort(sides);

        if (sides[2] >= (sides[0] + sides[1] + sides[2]) / 2.0) {
            return "Invalid triangle";
        }

        if (side1 == side2 && side2 == side3) {
            return "Equilateral";
        } else if (side1 == side2 || side1 == side3 || side2 == side3) {
            return "Isosceles";
        } else  {
            return "Scalene";
        }
    }


    /**
     * Reads a single side length from user input.
     * Ensures that the entered value is positive.
     * If an invalid input (non-positive number) is provided,
     * the user is prompted again until a valid input is given.
     *
     * @param scanner the object used for reading user input
     * @param prompt the message displayed to the user before input
     * @return a positive double representing a side length
     */
    private static double readSide(Scanner scanner, String prompt) {
        System.out.print(prompt);

        double side = scanner.nextDouble();

        if (side <= 0.0) {
            System.out.println("Invalid input. Side lengths must be positive.");
            return readSide(scanner, prompt);
        } else {
            return side;
        }
    }

    /**
     * The main entry point of the program.
     * Prompts the user to enter the lengths of three triangle sides,
     * validates input, and prints out the resulting triangle type.
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            double side1;
            double side2;
            double side3;

            try {
                side1 = readSide(scanner, "Enter the length of the first side: ");
                side2 = readSide(scanner, "Enter the length of the second side: ");
                side3 = readSide(scanner, "Enter the length of the third side: ");
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                return;
            }

            String result = getTriangleType(side1, side2, side3);
            System.out.println("The triangle is: " + result);
        }
    }
}
