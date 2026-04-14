public class Ovalo {

    private double base;
    private double altura;

    public Ovalo(double altura, double base) {
        if (base <= 0 || altura <= 0 && base != altura){
            throw new IllegalArgumentException("La base y/o la altura deben ser mayores a 0 revise sus datos nuevamente porfavor y/o la base y la altura no deben de ser iguales");
        }

        this.altura = altura;
        this.base = base;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double calcularArea(){

        return Math.PI*(base*altura);

    }

    @Override
    public String toString() {
        return "Ovalo | Base: " + base + " | Altura: " + altura + " | Area: " + calcularArea();
    }
}
