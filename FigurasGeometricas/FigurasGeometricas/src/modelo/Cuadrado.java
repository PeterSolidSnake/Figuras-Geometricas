/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author pedro
 */
public class Cuadrado extends Figura {
    
    //lado X se refiere a todos los lados del Cuadrado, al ser iguales, solo hay un atributo de lado
    private double ladoX;

    public Cuadrado(double ladoX, String codigo, String color, double area, double perimetro) {
        super(codigo, color, area, perimetro);
        this.ladoX = ladoX;
    }

    public double getLado() {
        return ladoX;
    }

    public void setLado(double lado) {
        this.ladoX= ladoX;
    }
    
    @Override
   public double calcularArea(){
       
       if (ladoX != 0){
           
           area = (ladoX * ladoX);
           return area;
           
       } else {
           System.out.println("El lado sea cualquiera tiene que ser diferente de 0 e igual a los otros 3 lados");
           return 0.0;
       }
       
   }
   
   @Override
   public double calcularPerimetro(){
       
       if (ladoX != 0){
           
           perimetro = (4*ladoX);
           return perimetro;
           
       } else {
           System.out.println("El lado sea cualquiera tiene que ser diferente de 0 e igual a los otros 3 lados");
           return 0.0;
       }
    
}
}
