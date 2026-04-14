public class Circulo extends Figuras
{
    private double radio;

    public Circulo (double radio){

        this.radio = radio;

    }

    public double getRadio(){
        return this.radio;
    }

    public void setRadio(double radio){
        this.radio = radio;
    }

    public double calcularArea(){

        if (this.radio <= 0){

            throw new IllegalArgumentException("El radio de circulo debe ser mayor a 0, verifique los datos dados");

        }

        return Math.PI * (radio*radio);
    }

    @Override
    public String toString() {
        return "Circulo | Radio: " + radio + " | Area: " + calcularArea();
    }
}