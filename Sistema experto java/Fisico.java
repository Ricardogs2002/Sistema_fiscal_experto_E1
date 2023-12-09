import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.awt.Font;
import java.awt.*;
import java.io.*;
class Fisico extends JPanel implements ActionListener{
    Font fuente=new Font("Algerian",Font.BOLD,20);
    Font fuente1=new Font("Algerian",Font.PLAIN,20);
    Font fuente2=new Font("Arial",Font.PLAIN,18);
    //public JTextArea resumen;
    public JButton botonF1,botonF2,botonF3,botonA;//agregar tantos botones Fx como sea necesario
    //public JScrollPane scroll;
    public JScrollPane Paneles;
    public Fisico(){
        setLayout(null);
        setBackground(new Color(200,242,144));
        botonF1= new JButton("Fisica 1");
        botonF1.setBounds(105,100,150,30);
        botonF1.setFont(fuente2);
        botonF2 = new JButton("Fisica 2");
        botonF2.setBounds(105,150,150,30);
        botonF2.setFont(fuente2);
        botonF3 = new JButton("Fisica 3");
        botonF3.setBounds(105,200,150,30);
        botonF3.setFont(fuente2);
        botonA = new JButton("Atras");
        botonA.setBounds(105,480,150,30);
        botonA.setFont(fuente2);
        Paneles = new JScrollPane();
        Paneles.setBounds(0,0,800,600);
        Paneles.setVisible(false);
        add(botonF1);
        add(botonF2);
        add(botonF3);
        add(botonA);
        add(Paneles);
        botonF1.addActionListener(this);
        botonF2.addActionListener(this);
        botonF3.addActionListener(this);
        botonA.addActionListener(this);


//||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    }
    public void actionPerformed(ActionEvent accion){
        if (accion.getSource() == botonF1){
            Paneles.setVisible(true);
        }
        if (accion.getSource() == botonF2){
        }
        if (accion.getSource() == botonF3){
        }
        if (accion.getSource() == botonA){
        }
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
}
