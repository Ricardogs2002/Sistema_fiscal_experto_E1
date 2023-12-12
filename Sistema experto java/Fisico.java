import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
class Fisico extends JPanel implements ActionListener, ItemListener{
    Font fuente=new Font("Algerian",Font.BOLD,20);
    Font fuente1=new Font("Algerian",Font.PLAIN,20);
    Font fuente2=new Font("Arial",Font.PLAIN,18);
    Fisico_Moral Ventana3;
    //public JTextArea resumen;
    public JButton botonF1,botonF2,botonF3,botonA;//agregar tantos botones Fx como sea necesario
    private JComboBox<String> opciones;
    public JLabel titulo;
    //public JScrollPane scroll;
    public JScrollPane Paneles;
    public Fisico(){

        setLayout(null);
        setBackground(new Color(200,242,144));
        opciones = new JComboBox<>();
        opciones.setBounds(80,150,200,30);
        opciones.addItem("Selecciona una opcion");
        opciones.addItem("Incorporación fiscal");
        opciones.addItem("Actividades empresariales");
        opciones.addItem("Arrendamiento de inmuebles");
        opciones.addItem("Servicios profesionales");
        opciones.addItem("Asalariado");


        botonA = new JButton("Atras");
        botonA.setBounds(105,480,150,30);
        botonA.setFont(fuente2);
        botonF1 = new JButton("Siguiente");
        botonF1.setBounds(105,300,150,30);
        botonF1.setFont(fuente2);
        Paneles = new JScrollPane();
        Paneles.setBounds(0,0,800,600);
        Paneles.setVisible(false);
        titulo = new JLabel("Persona Fisica");
        titulo.setBounds(125,20,450,50); //x, y, ancho, alto. Dentro del frame
        titulo.setFont(fuente2);
        titulo.setForeground(Color.WHITE);
        add(botonA);
        add(botonF1);
        add(Paneles);
        add(opciones);
        add(titulo);
        
        botonA.addActionListener(this);
        botonF1.addActionListener(this);


//||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    }
    public void actionPerformed(ActionEvent accion){
        if (accion.getSource() == botonA){
            Paneles.setVisible(false);
            Ventana3 = new Fisico_Moral();
            ver3(Ventana3);
        }
        if (accion.getSource() == botonF1){
            String OPC = (String)opciones.getSelectedItem();
            if (OPC == "Selecciona una opcion"){
                JOptionPane.showMessageDialog(null, "Seleccione alguna opcion","", JOptionPane.WARNING_MESSAGE);
            }
            if (OPC == "Incorporación fiscal"){
                JOptionPane.showMessageDialog(null, "Podrán ser contribuyentes a este tipo de régimen las personas que realizan actividades empresariales u ofrezcan servicios donde no sea obligatorio un título profesional. \nEjemplo: fruterías, talleres mecánicos, salones de belleza, papelería, tintorerías y todas aquellas que obtengan ingresos que no sobrepasen los dos millones de peso anual.");
            }
            if (OPC == "Actividades empresariales"){
                JOptionPane.showMessageDialog(null,"En este tipo, no se establece un monto mínimo de ingreso y es obligatorio que se registren en este régimen, las personas físicas que realicen actividades industriales, de transporte, comerciales, ganaderas, agrícolas o de pesca. \nEjemplo: restaurantes, ferreterías, guarderías, bares, artesanos, entre otros." );
            }
            if (OPC == "Arrendamiento de inmuebles"){
                JOptionPane.showMessageDialog(null,"Pertenecen a este régimen aquella personas que obtengan ingresos mensuales o anuales por alquilar o rentar departamentos, habitaciones, locales comerciales y cualquier bien mueble del que sea poseedor.");
            }
            if (OPC == "Servicios profesionales"){
                JOptionPane.showMessageDialog(null,"Si eres profesional de la salud y acabas de abrir un consultorio, te desempeñas como freelance u obtienes un sueldo mensual por prestar tus conocimientos profesionales de forma independiente, \nes decir, sin depender de una empresa cobrando como asalariado, perteneces a este tipo de régimen fiscal.");
            }
            if (OPC == "Asalariado"){
                JOptionPane.showMessageDialog(null, "Son los que trabajan en subordinación a una organización o empresa. Estos sólo hacen una declaración anual ante la hacienda pública." );
            }

        }
    }

private void ver3(Fisico_Moral coso){
    Paneles.setViewportView(coso);
    Play();
}

private void Play(){
    botonA.setVisible(false);
    botonF1.setVisible(false);
    Paneles.setVisible(false);
    opciones.setVisible(false);
}
//||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||    
    //Cambio de fondo
    private Image backgroundImage;

    protected void paintComponent(Graphics g) {
        try {
            backgroundImage = ImageIO.read(new File("Biblio.png"));  // Imagen a cambiar
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
    public static void main(String[] args) {
        Fisico base=new Fisico();
        base.setBounds(150,100,800,600);
        base.setVisible(true);
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'itemStateChanged'");
    }
}
