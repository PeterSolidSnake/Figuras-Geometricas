package Controlador;

import Vista.JFFigura;
import modelo.Circulo;
import modelo.Cuadrado;
import modelo.Figura;
import modelo.Triangulo;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorFigura implements ActionListener {

    private JFFigura frmFigura;
    private ArrayList<Figura> listaFiguras;

    // Figura calculada actualmente, pendiente de guardar
    private Figura figuraCalculada;

    public ControladorFigura(JFFigura frmFigura) {
        this.frmFigura    = frmFigura;
        this.listaFiguras = new ArrayList<>();

        frmFigura.btnCalcular.addActionListener(this);
        frmFigura.btnGuardar.addActionListener(this);
        frmFigura.btnMostrarFiguras.addActionListener(this);
        frmFigura.btnLimpiar.addActionListener(this);

        // Cambiar panel de campos al cambiar figura
        frmFigura.cmbBoxFigura.addActionListener(e -> cambiarPanel());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmFigura.btnCalcular) {
            calcular();
        } else if (e.getSource() == frmFigura.btnGuardar) {
            guardar();
        } else if (e.getSource() == frmFigura.btnMostrarFiguras) {
            mostrarFiguras();
        } else if (e.getSource() == frmFigura.btnLimpiar) {
            limpiar();
        }
    }

    // Muestra el panel correspondiente a la figura seleccionada
    private void cambiarPanel() {
        String figura = (String) frmFigura.cmbBoxFigura.getSelectedItem();
        CardLayout cl = (CardLayout) frmFigura.panelCamposFigura.getLayout();
        cl.show(frmFigura.panelCamposFigura, figura);
        figuraCalculada = null;
        frmFigura.AreaResultado.setText("");
    }

    private void calcular() {
        String tipo = (String) frmFigura.cmbBoxFigura.getSelectedItem();
        try {
            switch (tipo) {
                case "Circulo" -> {
                    double radio = Double.parseDouble(frmFigura.txtRadio.getText().trim());
                    Circulo c = new Circulo(radio, "", "", 0, 0);
                    double area  = Math.PI * radio * radio;   // corregido: r^2 no r^r
                    double peri  = 2 * Math.PI * radio;       // corregido: 2*PI*r
                    c.setArea(area);
                    c.setPerimetro(peri);
                    figuraCalculada = c;
                    frmFigura.AreaResultado.setText(
                        "=== Circulo ===\n" +
                        "Radio     : " + radio + "\n" +
                        String.format("Area      : %.4f%n", area) +
                        String.format("Perimetro : %.4f%n", peri) +
                        "\nIngrese codigo y color para guardar la figura."
                    );
                }
                case "Cuadrado" -> {
                    double lado = Double.parseDouble(frmFigura.txtLado.getText().trim());
                    Cuadrado cu = new Cuadrado(lado, "", "", 0, 0);
                    double area = cu.calcularArea();
                    double peri = cu.calcularPerimetro();
                    figuraCalculada = cu;
                    frmFigura.AreaResultado.setText(
                        "=== Cuadrado ===\n" +
                        "Lado      : " + lado + "\n" +
                        String.format("Area      : %.4f%n", area) +
                        String.format("Perimetro : %.4f%n", peri) +
                        "\nIngrese codigo y color para guardar la figura."
                    );
                }
                case "Triangulo" -> {
                    double base   = Double.parseDouble(frmFigura.txtBase.getText().trim());
                    double altura = Double.parseDouble(frmFigura.txtAltura.getText().trim());
                    double ladoA  = Double.parseDouble(frmFigura.txtLadoA.getText().trim());
                    double ladoB  = Double.parseDouble(frmFigura.txtLadoB.getText().trim());
                    double ladoC  = Double.parseDouble(frmFigura.txtLadoC.getText().trim());
                    Triangulo t = new Triangulo(ladoA, ladoB, ladoC, base, altura, "", "", 0, 0);
                    double area = t.calcularArea();
                    double peri = t.calcularPerimetro();
                    figuraCalculada = t;
                    frmFigura.AreaResultado.setText(
                        "=== Triangulo ===\n" +
                        "Base      : " + base + "\n" +
                        "Altura    : " + altura + "\n" +
                        "Lado A    : " + ladoA + "\n" +
                        "Lado B    : " + ladoB + "\n" +
                        "Lado C    : " + ladoC + "\n" +
                        String.format("Area      : %.4f%n", area) +
                        String.format("Perimetro : %.4f%n", peri) +
                        "\nIngrese codigo y color para guardar la figura."
                    );
                }
            }
        } catch (NumberFormatException ex) {
            frmFigura.AreaResultado.setText("Error: todos los valores deben ser numeros validos.");
        }
    }

    private void guardar() {
        if (figuraCalculada == null) {
            frmFigura.AreaResultado.setText("Primero calcule una figura antes de guardarla.");
            return;
        }
        String codigo = frmFigura.txtCodigo.getText().trim();
        String color  = frmFigura.txtColor.getText().trim();

        if (codigo.isEmpty() || color.isEmpty()) {
            frmFigura.AreaResultado.setText("Por favor ingrese el codigo y el color antes de guardar.");
            return;
        }

        // Verificar codigo duplicado
        for (Figura f : listaFiguras) {
            if (f.getCodigo().equalsIgnoreCase(codigo)) {
                frmFigura.AreaResultado.setText("Ya existe una figura con ese codigo. Use uno diferente.");
                return;
            }
        }

        figuraCalculada.setCodigo(codigo);
        figuraCalculada.setColor(color);
        listaFiguras.add(figuraCalculada);

        String tipo = figuraCalculada.getClass().getSimpleName();
        frmFigura.AreaResultado.setText(
            tipo + " guardada exitosamente.\n" +
            "Codigo    : " + codigo + "\n" +
            "Color     : " + color + "\n" +
            String.format("Area      : %.4f%n", figuraCalculada.getArea()) +
            String.format("Perimetro : %.4f%n", figuraCalculada.getPerimetro())
        );

        figuraCalculada = null;
        frmFigura.txtCodigo.setText("");
        frmFigura.txtColor.setText("");
    }

    private void mostrarFiguras() {
        if (listaFiguras.isEmpty()) {
            frmFigura.AreaResultado.setText("No hay figuras registradas.");
            return;
        }
        StringBuilder sb = new StringBuilder("=== Figuras Registradas ===\n\n");
        int i = 1;
        for (Figura f : listaFiguras) {
            sb.append(i++).append(". ").append(f.getClass().getSimpleName()).append("\n");
            sb.append("   Codigo    : ").append(f.getCodigo()).append("\n");
            sb.append("   Color     : ").append(f.getColor()).append("\n");
            sb.append(String.format("   Area      : %.4f%n", f.getArea()));
            sb.append(String.format("   Perimetro : %.4f%n", f.getPerimetro()));
            sb.append("\n");
        }
        frmFigura.AreaResultado.setText(sb.toString());
    }

    private void limpiar() {
        frmFigura.txtRadio.setText("");
        frmFigura.txtLado.setText("");
        frmFigura.txtBase.setText("");
        frmFigura.txtAltura.setText("");
        frmFigura.txtLadoA.setText("");
        frmFigura.txtLadoB.setText("");
        frmFigura.txtLadoC.setText("");
        frmFigura.txtCodigo.setText("");
        frmFigura.txtColor.setText("");
        frmFigura.AreaResultado.setText("");
        figuraCalculada = null;
    }
}
