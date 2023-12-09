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
    public JButton botonM1,botonM2,botonM3,botonA;//agregar tantos botones Fx como sea necesario
    public JScrollPane Paneles;
    public Moral(){
        setLayout(null);
        setBackground(new Color(200,242,144));
        botonM1= new JButton("Moral 1");
        botonM1.setBounds(105,100,150,30);
        botonM1.setFont(fuente2);
        botonM2 = new JButton("Moral 2");
        botonM2.setBounds(105,150,150,30);
        botonM2.setFont(fuente2);
        botonM3 = new JButton("Moral 3");
        botonM3.setBounds(105,200,150,30);
        botonM3.setFont(fuente2);
        botonA = new JButton("Atras");
        botonA.setBounds(105,480,150,30);
        botonA.setFont(fuente2);
        Paneles = new JScrollPane();
        Paneles.setBounds(0,0,800,600);
        Paneles.setVisible(false);
        add(botonM1);
        add(botonM2);
        add(botonM3);
        add(botonA);
        add(Paneles);
        botonM1.addActionListener(this);
        botonM2.addActionListener(this);
        botonM3.addActionListener(this);
        botonA.addActionListener(this);


//||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    }
    public void actionPerformed(ActionEvent accion){
        if (accion.getSource() == botonM1){
            Paneles.setVisible(true);
        }
        if (accion.getSource() == botonM2){
        }
        if (accion.getSource() == botonM3){
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
        Moral base=new Moral();
        base.setBounds(150,100,800,600);
        base.setVisible(true);
    }
}
