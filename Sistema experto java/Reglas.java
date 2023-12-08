// RIGS 7F 20310388
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.awt.Font;
import java.awt.*;
import java.io.*;
class Reglas extends JPanel{
	Font fuente=new Font("Algerian",Font.BOLD,20);
	Font fuente1=new Font("Algerian",Font.PLAIN,20);
	Font fuente2=new Font("Arial",Font.PLAIN,18);
	public JTextArea reglamento;
	public JScrollPane scroll;
	public Reglas(){
        setLayout(null);
		setBackground(new Color(200,242,144));
		reglamento = new JTextArea(20,50);
		reglamento.setFont(fuente2);
		reglamento.setEditable(false);
		reglamento.setForeground(Color.BLACK);				//Color de letras
		scroll = new JScrollPane(reglamento);
		scroll.setOpaque(false);
		add(scroll);
		scroll.setOpaque(false);
		scroll.getViewport().setOpaque(false);
		scroll.setBorder(null);
		scroll.setViewportBorder(null);
		scroll.setBounds(20,20,760,560);
		reglamento.setOpaque(false);
//||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
	//Leer txt
		String Ins = "Instrucciones.txt";
		String linea = null;
		try (BufferedReader br = new BufferedReader(new FileReader(Ins))) {
            while ((linea = br.readLine()) != null) {
                 reglamento.append(linea + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo " + Ins + ": " + e.getMessage());
        }	
    }
//||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||    
    //Cambio de fondo
    private Image backgroundImage;

    protected void paintComponent(Graphics g) {
    	try {
            backgroundImage = ImageIO.read(new File("Bovedae.jpg"));  // Imagen a cambiar
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
//||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
	public static void main(String[] args) {
		Reglas base=new Reglas();
		base.setBounds(150,100,800,600);
		base.setVisible(true);
		
	}
}
