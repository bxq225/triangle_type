import java.util.Arrays;
import java.util.Scanner;

public class TriangleType {
    public static String getTriangleType(double side1, double side2, double side3) {
        double[] sides = new double[]{side1, side2, side3};
        Arrays.sort(sides);
        if (sides[2] >= (sides[0] + sides[1] + sides[2]) / 2.0) {
            return "Invalid triangle";
        } else if (side1 == side2 && side2 == side3) {
            return "Equilateral";
        } else {
            return side1 != side2 && side2 != side3 && side1 != side3 ? "Scalene" : "Isosceles";
        }
    }

    private static double readSide(Scanner scanner, String prompt) {
        System.out.print(prompt);
        double side = scanner.nextDouble();
        if (side <= (double)0.0F) {
            System.out.println("Invalid input. Side lengths must be positive.");
            return readSide(scanner, prompt);
        } else {
            return side;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            double side1;
            double side2;
            double side3;
            try {
                side1 = readSide(scanner, "Enter the length of the first side: ");
                side2 = readSide(scanner, "Enter the length of the second side: ");
                side3 = readSide(scanner, "Enter the length of the third side: ");
            } catch (Exception var10) {
                System.out.println("Invalid input. Please enter a numeric value.");
                return;
            }

            String result = getTriangleType(side1, side2, side3);
            System.out.println("The triangle is: " + result);
        }
    }
}
