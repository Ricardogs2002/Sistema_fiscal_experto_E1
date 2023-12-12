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
    //public JScrollPane scroll;
    public JScrollPane Paneles;
    public Fisico(){

        setLayout(null);
        setBackground(new Color(200,242,144));
        opciones = new JComboBox();
        opciones.setBounds(105,150,150,30);
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
        add(botonA);
        add(botonF1);
        add(Paneles);
        add(opciones);
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
            if (OPC == "Incorporación fiscal"){
                System.out.println("1");
            }
            if (OPC == "Actividades empresariales"){
                System.out.println("2");
            }
            if (OPC == "Arrendamiento de inmuebles"){
                System.out.println("3");
            }
            if (OPC == "Servicios profesionales"){
                System.out.println("4");
            }
            if (OPC == "Asalariado"){
                System.out.println("5");
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

