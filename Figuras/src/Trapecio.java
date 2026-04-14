public class Trapecio {

    private double baseA;
    private double baseB;
    private double altura;

    public Trapecio(double baseA, double baseB, double altura) {



        this.baseA = baseA;
        this.baseB = baseB;
        this.altura = altura;
    }

    public double getBaseA() {
        return baseA;
    }

    public void setBaseA(double baseA) {
        this.baseA = baseA;
    }

    public double getBaseB() {
        return baseB;
    }

    public void setBaseB(double baseB) {
        this.baseB = baseB;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double calcularArea(){

        if (this.baseA <= 0 || this.altura <= 0 || this.baseB <= 0 || this.baseA == this.baseB){
            throw new IllegalArgumentException("La baseA y/o baseB y/o la altura de Trapecio deben ser mayores a 0 y/o la baseA y la baseB no pueden ser iguales, verifique los datos dados");
        }

        return ((baseA+baseB)/2)*altura;

    }

    @Override
    public String toString() {
        return "Trapecio | BaseA: " + baseA + " | BaseB: " + baseB + " | Altura: " + altura + " | Area: " + calcularArea();
    }

}
