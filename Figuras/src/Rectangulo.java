public class Rectangulo extends Figuras
{
    //Atributos
    private double base;
    private double altura;

    //constructor
    public Rectangulo (double base, double altura){
        if (base <= 0 || altura <= 0){
            throw new IllegalArgumentException("La base y/o la altura deben ser mayores a 0 revise sus datos nuevamente porfavor :D");
        }
        this.base = base;
        this.altura = altura;
    }

    public double getBase(){
        return this.base;
    }
    public double getAltura(){
        return this.altura;
    }

    public void setAltura(double altura){
        this.altura = altura;
    }
    public void setBase(double base){
        this.base = base;
    }

    public double calcularArea(){
        return base*altura;
    }

    @Override
    public String toString() {
        return "Rectangulo | Base: " + base + " | Altura: " + altura + " | Área: " + calcularArea();
    }

}