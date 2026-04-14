public class Main {

    public static void main(String[] args){

        System.out.println("Bienvenido a Figuras");
        System.out.println("Detectando valores para Circulo, Triangulo y Rectangulo\n");

        Circulo c0 = new Circulo(5);
        System.out.println(c0);

        Triangulo t0 = new Triangulo(7,7);
        System.out.println(t0);

        Rectangulo r0 = new Rectangulo(5,8);
        System.out.println(r0);

        Ovalo o0 = new Ovalo(9,20);
        System.out.println(o0);

        Trapecio tr0 = new Trapecio(5,8, 9);
        System.out.println(tr0);

        System.out.println("\nResultado de las areas de cada valor dado a cada figura correspondiente");

    }

}
