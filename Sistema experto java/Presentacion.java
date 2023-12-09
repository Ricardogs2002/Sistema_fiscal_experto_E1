// RIGS 7E 20310388
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.awt.Font;
import java.awt.*;
import java.io.*;

public class Presentacion extends JPanel implements ActionListener{
    Font fuente=new Font("Algerian",Font.BOLD,20);
    Font fuente1=new Font("Algerian",Font.PLAIN,20);
    Font fuente2=new Font("Arial",Font.PLAIN,18);
    Fisico_Moral Ventana3;
    public JTextArea resumen;
    public JButton botonS,botonA;
    public JScrollPane scroll;
    public JScrollPane Paneles;
    public Presentacion(){
        setLayout(null);
        setBackground(new Color(200,242,144));
        resumen = new JTextArea(20,50);
        resumen.setFont(fuente2);
        resumen.setEditable(false);
        resumen.setForeground(Color.BLACK);              //Color de letras
        resumen.setLineWrap(true);  // Activar ajuste de línea
        resumen.setWrapStyleWord(true);  // Ajustar palabras enteras
        scroll = new JScrollPane(resumen);
        scroll.setOpaque(false);
        botonS = new JButton("Siguiente");
        botonS.setBounds(105,440,150,30);
        botonS.setFont(fuente2);
        botonA = new JButton("Atras");
        botonA.setBounds(105,480,150,30);
        botonA.setFont(fuente2);
        Paneles = new JScrollPane();
        Paneles.setBounds(0,0,800,600);
        Paneles.setVisible(false);
        add(scroll);    
        add(botonS);
        add(botonA);
        add(Paneles);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setBorder(null);
        scroll.setViewportBorder(null);
        scroll.setBounds(20,20,300,355);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        resumen.setOpaque(false);
        botonS.addActionListener(this);
        botonA.addActionListener(this);

        Ventana3 = new Fisico_Moral();
//||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    //Leer txt
        String Ins = "Definiciones.txt";
        String linea = null;
        try (BufferedReader br = new BufferedReader(new FileReader(Ins))) {
            while ((linea = br.readLine()) != null) {
                 resumen.append(linea + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo " + Ins + ": " + e.getMessage());
        }   
    }
    public void actionPerformed(ActionEvent accion){
        if (accion.getSource() == botonS){
            Paneles.setVisible(true);
            Ventana3 = new Fisico_Moral();
            ver3(Ventana3);
        }
        if (accion.getSource() == botonA){
        }
    }

private void ver3(Fisico_Moral coso){
        Paneles.setViewportView(coso);
        Play();
    }


    private void Play(){
        scroll.setVisible(false);
        botonS.setVisible(false);
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
        Presentacion base=new Presentacion();
        base.setBounds(150,100,800,600);
        base.setVisible(true);
    }
}
