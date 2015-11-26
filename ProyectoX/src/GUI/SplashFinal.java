package GUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
/**
 * @author Brunner Francisco, Vercelli Franco, Volpe Leandro.
 *
 */
public class SplashFinal extends javax.swing.JFrame implements Runnable
{
	protected Thread t;
	protected JPanel panel;
	protected JLabel labelSplash;
	protected JFrame frameFinal;
	protected VentanaMenu inicio;
	protected VentanaPuntajeFinal ventanaFinal;
	protected ImageIcon imagenGana=new ImageIcon(getClass().getResource("/images/gano.jpg"));
	protected ImageIcon imagenPerdio=new ImageIcon(getClass().getResource("/images/perdio.jpg"));
	protected int puntaje;
	
	public SplashFinal(JFrame f, boolean b,int puntos) {
		setUndecorated(true);
		setSize(920,600);
		frameFinal=f;
		puntaje = puntos;
		ventanaFinal=new VentanaPuntajeFinal(puntaje);
		
		panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 920, 600);
		panel.setLayout(null);
		
		labelSplash = new JLabel("");
		labelSplash.setBounds(0, 0, 920, 600);
		if(b) { labelSplash.setIcon(imagenGana); }
		else { labelSplash.setIcon(imagenPerdio);}
			
		panel.add(labelSplash);
		getContentPane().setVisible(true);
	}

	@Override
	public void run() 
	{
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		frameFinal.dispose();
		try 
		{
			t.sleep(2500);
		} catch (InterruptedException e) {e.printStackTrace();	}
		ventanaFinal.setVisible(true);
		dispose();
		}
	}

