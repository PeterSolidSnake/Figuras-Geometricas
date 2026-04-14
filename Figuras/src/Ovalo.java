public class Ovalo {

    private double base;
    private double altura;

    public Ovalo(double altura, double base) {


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

        if (this.base <= 0 || this.altura <= 0 || this.base == this.altura){
            throw new IllegalArgumentException("La base y/o la altura de Ovalo deben de ser mayores a 0 y/o la base y altura no pueden ser iguales, verifique los datos dados");
        }

        return Math.PI*(base*altura);
    }

    @Override
    public String toString() {
        return "Ovalo | Base: " + base + " | Altura: " + altura + " | Area: " + calcularArea();
    }
}
