// RIGS 7E 20310388
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.*;
import java.sql.*;
import java.util.Random;

public class Main_SE extends JFrame implements ActionListener {
    Font fuente=new Font("Algerian",Font.BOLD,20);
    Font fuente1=new Font("Algerian",Font.PLAIN,40);
    Font fuente2=new Font("Arial",Font.PLAIN,18);
    public JLabel Titulo;
    public JButton botonJ,botonI,botonC,botonB;
    Presentacion Ventana1;
    Reglas Ventana2;
    public JScrollPane Paneles;
    public static int r;
    public Random random = new Random();
    public Main_SE(){
        getContentPane().setBackground(new Color(250,242,144));
        setLayout(null);
        setTitle("Sistema fiscal experto");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Titulo = new JLabel("Guia fiscal");
        Titulo.setBounds(50,20,450,50); //x, y, ancho, alto. Dentro del frame
        Titulo.setFont(fuente1);
        Titulo.setForeground(Color.BLACK);
        botonJ = new JButton("Iniciar");
        botonJ.setBounds(105,250,150,30);
        botonJ.setFont(fuente2);
        botonI = new JButton("Instrucciones");
        botonI.setBounds(105,280,150,30);
        botonI.setFont(fuente2);
        botonC = new JButton("Salir");
        botonC.setBounds(105,310,150,30);
        botonC.setFont(fuente2);
        botonB = new JButton("Atrás");
        botonB.setBounds(105,530,150,30);
        botonB.setFont(fuente2);
        botonB.setVisible(false);
        Paneles = new JScrollPane();
        Paneles.setBounds(0,0,800,600);
        Paneles.setVisible(false);
        Ventana1 = new Presentacion();
        Ventana2 = new Reglas();

        //Add
        add(Titulo);
        add(botonC);
        add(botonI);
        add(botonJ);
        add(botonB);
        add(Paneles);

        //ActionListener
        botonI.addActionListener(this);
        botonJ.addActionListener(this);
        botonC.addActionListener(this);
        botonB.addActionListener(this);
//|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        ImageIcon Fondo = new ImageIcon("Biblio.png");                                  //Imagen a cambiar
        Image Escalada = Fondo.getImage().getScaledInstance(360, 640, Image.SCALE_SMOOTH);
        ImageIcon imagenNueva = new ImageIcon(Escalada);
        JLabel etiquetaDeFondo = new JLabel(imagenNueva);
        etiquetaDeFondo.setBounds(0, 0, imagenNueva.getIconWidth(), imagenNueva.getIconHeight());
        getContentPane().add(etiquetaDeFondo);
    }
    public void itemStateChanged(ItemEvent accion){}
    public void actionPerformed(ActionEvent accion){
        if (accion.getSource() == botonC){
            int exit = JOptionPane.showConfirmDialog(null,"\u00BF Est\u00e1s seguro?");
            if (exit == 0) {
                System.exit(0);
            }
        }
        if (accion.getSource() == botonI){
            Paneles.setVisible(true);
            Ventana2 = new Reglas();
            ver2(Ventana2);
            Sombra();
        }
        if (accion.getSource() == botonJ){
            Paneles.setVisible(true);
            r = random.nextInt(5) + 1;
            Ventana1 = new Presentacion();
            ver1(Ventana1);
        }
        if (accion.getSource() == botonB){
            Paneles.setVisible(false);
            Luz();
        }
    }
    private void ver1(Presentacion coso){
        Paneles.setViewportView(coso);
        Play();
    }
    private void ver2(Reglas coso){
        Paneles.setViewportView(coso);
        Luz();
    }
    private void Sombra(){
        botonI.setVisible(false);
        botonJ.setVisible(false);
        botonC.setVisible(false);
        botonB.setVisible(true);
        Titulo.setVisible(false);
    }
    private void Luz(){
        botonI.setVisible(true);
        botonJ.setVisible(true);
        botonC.setVisible(true);
        botonB.setVisible(false);
        Titulo.setVisible(true);
    }
    private void Play(){
        botonI.setVisible(false);
        botonJ.setVisible(false);
        botonC.setVisible(false);
        botonB.setVisible(false);
        Titulo.setVisible(false);
    }

    public static void main(String[] args) {
        Main_SE base=new Main_SE();
        base.setBounds(150,100,360,640);
        base.setVisible(true);
        base.setResizable(false);
    }   
}