public class Circulo extends Figuras
{
    private double radio;

    public Circulo (double radio){
        if (radio > 0){
            this.radio = radio;
        }
        else throw new IllegalArgumentException("El radio debe ser mayor a 0"); // IllegalArgumentException sirve para indicar que hay un error en los datos
    }

    public double getRadio(){
        return this.radio;
    }

    public void setRadio(double radio){
        this.radio = radio;
    }

    public double calcularArea(){
        return Math.PI * radio*radio;
    }

    @Override
    public String toString() {
        return "Circulo | Radio: " + radio + " | Área: " + calcularArea();
    }
}