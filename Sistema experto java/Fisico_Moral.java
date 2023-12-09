//Angeloid 20310424
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.awt.Font;
import java.awt.*;
import java.io.*;
class Fisico_Moral extends JPanel implements ActionListener{
    Font fuente=new Font("Algerian",Font.BOLD,20);
    Font fuente1=new Font("Algerian",Font.PLAIN,20);
    Font fuente2=new Font("Arial",Font.PLAIN,18);
    Fisico Ventana4;
    Moral Ventana5;
    public JButton botonF,botonM,botonA;
    public JScrollPane Paneles;
    public Fisico_Moral(){
        setLayout(null);
        setBackground(new Color(200,242,144));
        botonF = new JButton("Fisicas");
        botonF.setBounds(105,100,150,30);
        botonF.setFont(fuente2);
        botonM = new JButton("Morales");
        botonM.setBounds(105,300,150,30);
        botonM.setFont(fuente2);
        botonA = new JButton("Atras");
        botonA.setBounds(105,480,150,30);
        botonA.setFont(fuente2);
        Paneles = new JScrollPane();
        Paneles.setBounds(0,0,800,600);
        Paneles.setVisible(false);
        add(botonF);
        add(botonM);
        add(botonA);
        add(Paneles);
        botonF.addActionListener(this);
        botonM.addActionListener(this);
        botonA.addActionListener(this);

        Ventana4 = new Fisico();
        Ventana5 = new Moral();
//||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    }
    public void actionPerformed(ActionEvent accion){
        if (accion.getSource() == botonF){
            Paneles.setVisible(true);
            Ventana4 = new Fisico();
            ver4(Ventana4);
        }
        if (accion.getSource() == botonM){
            Paneles.setVisible(true);
            Ventana5 = new Moral();
            ver5(Ventana5);
        }
        if (accion.getSource() == botonA){
        }
    }

    private void ver4(Fisico coso){
            Paneles.setViewportView(coso);
            Play();
        }

    private void ver5(Moral coso){
            Paneles.setViewportView(coso);
            Play();
        }


    private void Play(){
        botonF.setVisible(false);
        botonM.setVisible(false);
        botonA.setVisible(false);
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
        Fisico_Moral base=new Fisico_Moral();
        base.setBounds(150,100,800,600);
        base.setVisible(true);
    }
}
