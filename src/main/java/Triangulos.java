
import java.util.Scanner;

public class Triangulos {

    public static void main(String[] args) {
        String Triángulo = "";

        Scanner scan = new Scanner(System.in);

        System.out.println("Ingresa la BASE del triángulo en cm:");
        double c = scan.nextDouble();
        System.out.println("Ingresa el LADO A del triángulo en cm:");
        double a = scan.nextDouble();
        System.out.println("Ingresa el LADO B del triángulo en cm:");
        double b = scan.nextDouble();

        //Prueba si el triángulo es válido y asigna el tipo de triángulo
        if ((a + b <= c) || (a + c <= b) || (b + c <= a)) {
            Triángulo = "Error";
            System.out.println("El triángulo ingresado no es válido según el Teorema de la desigualdad del triángulo.");
            System.out.println("Por favor ingrese un triángulo válido.");
            System.out.println("");

            /*En caso de no existir el triángulo, vuelve a llamar al método main para no 
            tener que iniciar el código manualmente de nuevo */
            Triangulos.main(args);

        } else if (a == b & b == c) {
            Triángulo = "Equilátero";
            System.out.println("El triángulo es: EQUILÁTERO");

        } else if ((a == b & b != c) || (b == c & a != b) || (a == c & b != a)) {
            Triángulo = "Isósceles";
            System.out.println("El triángulo es: ISÓSCELES");

        } else if (a != b & b != c) {
            Triángulo = "Escaleno";
            System.out.println("El triángulo es: ESCALENO");

        } else {
        }

        switch (Triángulo) {
            case "Equilátero":
                System.out.println("Todos los ángulos miden 60º.");
                break;
            case "Isósceles":
                double anguloa = Math.acos((Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * c * b));
                anguloa = Math.toDegrees(anguloa);
                double angulob = Math.acos((Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) / (2 * a * c));
                angulob = Math.toDegrees(angulob);
                double anguloc = Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b));
                anguloc = Math.toDegrees(anguloc);
                System.out.println("Los ángulos del triángulo miden: Alfa: " + anguloa + "º, Beta: " + angulob + "º, Gamma: " + anguloc + "º.");
                break;
            case "Escaleno":
                anguloa = Math.acos((Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * c * b));
                anguloa = Math.toDegrees(anguloa);
                angulob = Math.acos((Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) / (2 * a * c));
                angulob = Math.toDegrees(angulob);
                anguloc = Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b));
                anguloc = Math.toDegrees(anguloc);
                System.out.println("Los ángulos del triángulo miden: Alfa: " + anguloa + "º, Beta: " + angulob + "º, Gamma: " + anguloc + "º.");
                break;

            default:
        }
        //Uso la fórmula de Herón para calcular el área sin pedir la altura
        switch (Triángulo) {
            case "Isósceles":
                double perímetro = a + b + c;
                double semiP = perímetro / 2;
                double área = Math.sqrt(semiP * (semiP - a) * (semiP - b) * (semiP - c));
                System.out.println("El área del triángulo es: " + área + " cm²");
                break;
            case "Escaleno":
                perímetro = a + b + c;
                semiP = perímetro / 2;
                área = Math.sqrt(semiP * (semiP - a) * (semiP - b) * (semiP - c));
                System.out.println("El área del triángulo es: " + área + " cm²");
                break;
            case "Equilátero":
                //Para un equilátero solo necesito un lado, por lo cual simplifico la fórmula
                área = b * b * (Math.sqrt(3) / 4);
                System.out.println("El área del triángulo es: " + área + " cm²");
                break;

        }

    }
}
