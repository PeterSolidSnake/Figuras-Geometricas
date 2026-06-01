package figuras;

import Vista.JFFigura;
import Controlador.ControladorFigura;
import javax.swing.SwingUtilities;

public class FigurasGeometricas {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFFigura ventana = new JFFigura();
            new ControladorFigura(ventana);
            ventana.setVisible(true);
        });
    }
}
