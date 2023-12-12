import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.awt.Font;
import java.awt.*;
import java.io.*;
class Moral extends JPanel implements ActionListener{
    Font fuente=new Font("Algerian",Font.BOLD,20);
    Font fuente1=new Font("Algerian",Font.PLAIN,20);
    Font fuente2=new Font("Arial",Font.PLAIN,18);
    public JButton botonF1, botonA;//agregar tantos botones Fx como sea necesario
    public JScrollPane Paneles;
    private JComboBox<String> opciones;
    public JLabel titulo;
    public Moral(){
         setLayout(null);
        setBackground(new Color(200,242,144));
        opciones = new JComboBox<>();
        opciones.setBounds(80,150,200,30);
        opciones.addItem("Selecciona una opcion");
        opciones.addItem("Regimen General");
        opciones.addItem("Fines no lucrativos");
        
        botonF1 = new JButton("Siguiente");
        botonF1.setBounds(105,300,150,30);
        botonF1.setFont(fuente2);

                
        titulo = new JLabel("Persona Moral");
        titulo.setBounds(125,20,450,50); //x, y, ancho, alto. Dentro del frame
        titulo.setFont(fuente2);
        titulo.setForeground(Color.WHITE);

        botonA = new JButton("Atras");
        botonA.setBounds(105,480,150,30);
        botonA.setFont(fuente2);
        Paneles = new JScrollPane();
        Paneles.setBounds(0,0,800,600);
        Paneles.setVisible(false);
        
        add(botonA);
        add(botonF1);
        add(Paneles);
        add(opciones);
        add(titulo);
        botonA.addActionListener(this);


//||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    }
    public void actionPerformed(ActionEvent accion){
        
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
        Moral base=new Moral();
        base.setBounds(150,100,800,600);
        base.setVisible(true);
    }
}
