package Vista;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class JFFigura extends JFrame {

    public JComboBox<String> cmbBoxFigura;

    // Campos dinámicos según figura
    public JTextField txtRadio;       // Circulo
    public JTextField txtLado;        // Cuadrado
    public JTextField txtBase;        // Triangulo
    public JTextField txtAltura;      // Triangulo
    public JTextField txtLadoA;       // Triangulo
    public JTextField txtLadoB;       // Triangulo
    public JTextField txtLadoC;       // Triangulo

    // Campos para guardar
    public JTextField txtCodigo;
    public JTextField txtColor;

    // Botones
    public JButton btnCalcular;
    public JButton btnGuardar;
    public JButton btnMostrarFiguras;
    public JButton btnLimpiar;

    // Áreas de resultado
    public JTextArea AreaResultado;

    // Paneles que se muestran/ocultan
    public JPanel panelCirculo;
    public JPanel panelCuadrado;
    public JPanel panelTriangulo;
    public JPanel panelCamposFigura;

    public JFFigura() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Calculadora de Figuras Geometricas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        Font labelFont = new Font("SansSerif", Font.PLAIN, 12);
        Font fieldFont = new Font("SansSerif", Font.PLAIN, 12);
        Font btnFont   = new Font("SansSerif", Font.PLAIN, 12);
        Dimension fieldSize = new Dimension(150, 24);

        // ── Seleccion de figura ─────────────────────────────────────────────
        JPanel panelSeleccion = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 6));
        panelSeleccion.setBorder(new TitledBorder("Seleccion de Figura"));
        panelSeleccion.add(lbl("Figura:", labelFont));
        cmbBoxFigura = new JComboBox<>(new String[]{"Circulo", "Cuadrado", "Triangulo"});
        cmbBoxFigura.setFont(fieldFont);
        cmbBoxFigura.setPreferredSize(new Dimension(140, 24));
        panelSeleccion.add(cmbBoxFigura);

        // ── Panel Circulo ───────────────────────────────────────────────────
        panelCirculo = new JPanel(new GridBagLayout());
        panelCirculo.setOpaque(false);
        GridBagConstraints g = campo();
        g.gridx = 0; g.gridy = 0; panelCirculo.add(lbl("Radio:", labelFont), g);
        g.gridx = 1;               txtRadio = field(fieldFont, fieldSize); panelCirculo.add(txtRadio, g);

        // ── Panel Cuadrado ──────────────────────────────────────────────────
        panelCuadrado = new JPanel(new GridBagLayout());
        panelCuadrado.setOpaque(false);
        g = campo();
        g.gridx = 0; g.gridy = 0; panelCuadrado.add(lbl("Lado:", labelFont), g);
        g.gridx = 1;               txtLado = field(fieldFont, fieldSize); panelCuadrado.add(txtLado, g);

        // ── Panel Triangulo ─────────────────────────────────────────────────
        panelTriangulo = new JPanel(new GridBagLayout());
        panelTriangulo.setOpaque(false);
        g = campo();
        g.gridx = 0; g.gridy = 0; panelTriangulo.add(lbl("Base:", labelFont), g);
        g.gridx = 1;               txtBase = field(fieldFont, fieldSize); panelTriangulo.add(txtBase, g);
        g.gridx = 0; g.gridy = 1; panelTriangulo.add(lbl("Altura:", labelFont), g);
        g.gridx = 1;               txtAltura = field(fieldFont, fieldSize); panelTriangulo.add(txtAltura, g);
        g.gridx = 0; g.gridy = 2; panelTriangulo.add(lbl("Lado A:", labelFont), g);
        g.gridx = 1;               txtLadoA = field(fieldFont, fieldSize); panelTriangulo.add(txtLadoA, g);
        g.gridx = 0; g.gridy = 3; panelTriangulo.add(lbl("Lado B:", labelFont), g);
        g.gridx = 1;               txtLadoB = field(fieldFont, fieldSize); panelTriangulo.add(txtLadoB, g);
        g.gridx = 0; g.gridy = 4; panelTriangulo.add(lbl("Lado C:", labelFont), g);
        g.gridx = 1;               txtLadoC = field(fieldFont, fieldSize); panelTriangulo.add(txtLadoC, g);

        // ── Panel contenedor de campos (CardLayout) ─────────────────────────
        panelCamposFigura = new JPanel(new CardLayout());
        panelCamposFigura.setBorder(new TitledBorder("Datos de la Figura"));
        panelCamposFigura.add(panelCirculo,   "Circulo");
        panelCamposFigura.add(panelCuadrado,  "Cuadrado");
        panelCamposFigura.add(panelTriangulo, "Triangulo");

        // ── Panel guardar figura ────────────────────────────────────────────
        JPanel panelGuardar = new JPanel(new GridBagLayout());
        panelGuardar.setBorder(new TitledBorder("Guardar Figura"));
        g = campo();
        g.gridx = 0; g.gridy = 0; panelGuardar.add(lbl("Codigo:", labelFont), g);
        g.gridx = 1;               txtCodigo = field(fieldFont, fieldSize); panelGuardar.add(txtCodigo, g);
        g.gridx = 0; g.gridy = 1; panelGuardar.add(lbl("Color:", labelFont), g);
        g.gridx = 1;               txtColor = field(fieldFont, fieldSize); panelGuardar.add(txtColor, g);

        // ── Panel botones ───────────────────────────────────────────────────
        btnCalcular       = btn("Calcular",         btnFont);
        btnGuardar        = btn("Guardar Figura",   btnFont);
        btnMostrarFiguras = btn("Ver Figuras",       btnFont);
        btnLimpiar        = btn("Limpiar",           btnFont);

        JPanel panelBotones = new JPanel(new GridLayout(4, 1, 0, 6));
        panelBotones.setBorder(new TitledBorder("Acciones"));
        panelBotones.add(btnCalcular);
        panelBotones.add(btnGuardar);
        panelBotones.add(btnMostrarFiguras);
        panelBotones.add(btnLimpiar);

        // ── Panel izquierdo (seleccion + campos + guardar) ──────────────────
        JPanel panelIzq = new JPanel(new BorderLayout(0, 6));
        panelIzq.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 6));
        panelIzq.add(panelSeleccion,   BorderLayout.NORTH);
        panelIzq.add(panelCamposFigura, BorderLayout.CENTER);
        panelIzq.add(panelGuardar,      BorderLayout.SOUTH);

        // ── Panel derecho (botones) ─────────────────────────────────────────
        JPanel panelDer = new JPanel(new BorderLayout());
        panelDer.add(panelBotones, BorderLayout.NORTH);

        // ── Panel superior ──────────────────────────────────────────────────
        JPanel panelSuperior = new JPanel(new BorderLayout(8, 0));
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(8, 10, 6, 10));
        panelSuperior.add(panelIzq, BorderLayout.CENTER);
        panelSuperior.add(panelDer, BorderLayout.EAST);

        // ── Panel resultado ─────────────────────────────────────────────────
        AreaResultado = new JTextArea(7, 50);
        AreaResultado.setEditable(false);
        AreaResultado.setFont(new Font("Monospaced", Font.PLAIN, 12));
        AreaResultado.setLineWrap(true);
        AreaResultado.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(AreaResultado);
        scroll.setBorder(new TitledBorder("Resultado"));

        JPanel panelInf = new JPanel(new BorderLayout());
        panelInf.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        panelInf.add(scroll, BorderLayout.CENTER);

        // ── Layout principal ────────────────────────────────────────────────
        JPanel main = new JPanel(new BorderLayout(0, 4));
        main.add(panelSuperior, BorderLayout.CENTER);
        main.add(panelInf,      BorderLayout.SOUTH);

        setContentPane(main);
        pack();
        setLocationRelativeTo(null);
    }

    // ── Helpers ──────────────────────────────────────────────────────────────

    private JLabel lbl(String text, Font f) {
        JLabel l = new JLabel(text);
        l.setFont(f);
        return l;
    }

    private JTextField field(Font f, Dimension d) {
        JTextField tf = new JTextField();
        tf.setFont(f);
        tf.setPreferredSize(d);
        return tf;
    }

    private JButton btn(String text, Font f) {
        JButton b = new JButton(text);
        b.setFont(f);
        b.setFocusPainted(false);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return b;
    }

    private GridBagConstraints campo() {
        GridBagConstraints g = new GridBagConstraints();
        g.insets  = new Insets(4, 8, 4, 8);
        g.fill    = GridBagConstraints.HORIZONTAL;
        g.anchor  = GridBagConstraints.WEST;
        g.weightx = 0;
        return g;
    }
}
