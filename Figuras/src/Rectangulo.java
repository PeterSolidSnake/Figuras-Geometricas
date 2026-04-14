public class Rectangulo extends Figuras
{
    //Atributos
    private double base;
    private double altura;

    //constructor
    public Rectangulo (double base, double altura){

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

        if (this.base <= 0 || this.altura <= 0 || this.base == this.altura){
            throw new IllegalArgumentException("La base y/o la altura de Rectangulo deben ser mayores a 0 y/o la base y altura no pueden ser iguales, verifique los datos dados");
        }

        return base*altura;
    }

    @Override
    public String toString() {
        return "Rectangulo | Base: " + base + " | Altura: " + altura + " | Area: " + calcularArea();
    }

}