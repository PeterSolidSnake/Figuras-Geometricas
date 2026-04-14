public class Triangulo extends Figuras
{
    //atributos
    private int base;
    private int altura;

    //Constructor
    public Triangulo (int base, int altura){

        this.base = base;
        this.altura = altura;
    }

    //metodo getter
    public int getBase(){

        return this.base;
    }
    public int getAltura(){

        return this.altura;
    }

    //metodo setter
    public void setAltura(int altura){

        this.altura = altura;
    }
    public void setBase(int base){

        this.base = base;
    }

    public double calcularArea(){

        if (this.base <= 0 || this.altura <= 0){
            throw new IllegalArgumentException("La base y/o la altura de Triangulo deben ser mayores a 0, verifique sus datos porfavor");
        }

        return (base*altura)/2;
    }

    @Override
    public String toString() {
        return "Triangulo | Base: " + base + " | Altura: " + altura + " | Area: " + calcularArea();
    }
}