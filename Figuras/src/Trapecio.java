public class Trapecio {

    private double baseA;
    private double baseB;
    private double altura;

    public Trapecio(double baseA, double baseB, double altura) {

        if (baseA <= 0 || altura <= 0 || baseB <= 0){
            throw new IllegalArgumentException("La baseA y/o baseB y/o la altura deben ser mayores a 0 revise sus datos nuevamente porfavor");
        }

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

        return ((baseA+baseB)/2)*altura;

    }

    @Override
    public String toString() {
        return "Trapecio | BaseA: " + baseA + " | BaseB: " + baseB + " | Altura: " + altura + " | Area: " + calcularArea();
    }

}
