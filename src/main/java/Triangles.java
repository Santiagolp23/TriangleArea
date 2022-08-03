
import java.util.Scanner;

public class Triangles {

    public static void main(String[] args) {
        String Triangle = "";

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the BASE of the triangle in cm:");
        double c = scan.nextDouble();
        System.out.println("Enter the A SIDE of the triangle in cm:");
        double a = scan.nextDouble();
        System.out.println("Enter the B SIDE of the triangle in cm:");
        double b = scan.nextDouble();

        //Check if the triangle is valid and assigns its type
        if ((a + b <= c) || (a + c <= b) || (b + c <= a)) {
            Triangle = "Error";
            System.out.println("The entered triangle is not valid according to the Triangle Inequality Theorem.");
            System.out.println("Please enter a valid triangle.");
            System.out.println("");

            /*In case of error, calls the main method again to avoid having to write run the program again*/
            Triangles.main(args);

        } else if (a == b & b == c) {
            Triangle = "Equilateral";
            System.out.println("The triangle is: EQUILATERAL");

        } else if ((a == b & b != c) || (b == c & a != b) || (a == c & b != a)) {
            Triangle = "Isosceles";
            System.out.println("The triangle is: ISOSCELES");

        } else if (a != b & b != c) {
            Triangle = "Scalene";
            System.out.println("The triangle is: SCALENE");

        } else {
        }

        switch (Triangle) {
            case "Equilateral":
                System.out.println("All angles measure 60º.");
                break;
            case "Isosceles":
                double angleA = Math.acos((Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * c * b));
                angleA = Math.toDegrees(angleA);
                double angleB = Math.acos((Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) / (2 * a * c));
                angleB = Math.toDegrees(angleB);
                double angleC = Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b));
                angleC = Math.toDegrees(angleC);
                System.out.println("The angles of the triangle measure: Alfa: " + angleA + "º, Beta: " + angleB + "º, Gamma: " + angleC + "º.");
                break;
            case "Scalene":
                angleA = Math.acos((Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * c * b));
                angleA = Math.toDegrees(angleA);
                angleB = Math.acos((Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) / (2 * a * c));
                angleB = Math.toDegrees(angleB);
                angleC = Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b));
                angleC = Math.toDegrees(angleC);
                System.out.println("The angles of the triangle measure: Alfa: " + angleA + "º, Beta: " + angleB + "º, Gamma: " + angleC + "º.");
                break;

            default:
        }
        //Use Heron's formula to calculate the area without asking for the height.
        switch (Triangle) {
            case "Isosceles":
                double perímetro = a + b + c;
                double semiP = perímetro / 2;
                double area = Math.sqrt(semiP * (semiP - a) * (semiP - b) * (semiP - c));
                System.out.println("The area of the triangle is: " + area + " cm²");
                break;
            case "Scalene":
                perímetro = a + b + c;
                semiP = perímetro / 2;
                area = Math.sqrt(semiP * (semiP - a) * (semiP - b) * (semiP - c));
                System.out.println("The area of the triangle is: " + area + " cm²");
                break;
            case "Equilateral":
                //For an equilateral triangle I only need one side, so I simplify the formula
                area = b * b * (Math.sqrt(3) / 4);
                System.out.println("The area of the triangle is: " + area + " cm²");
                break;

        }

    }
}
