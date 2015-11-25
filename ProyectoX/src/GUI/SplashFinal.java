package GUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;

public class SplashFinal extends javax.swing.JFrame implements Runnable
{
	Thread t;
	JPanel panel;
	JLabel labelSplash;
	JFrame frameFinal;
	VentanaMenu inicio;
	VentanaPuntajeFinal ventanaFinal;
	ImageIcon imagenGana=new ImageIcon("C:/Users/Lea/Desktop/Foto0153.jpg");
	ImageIcon imagenPerdio=new ImageIcon("C:/Users/Lea/Desktop/Foto0153.jpg");
	
	public SplashFinal(JFrame f, boolean b) {
		setUndecorated(true);
		setSize(600,600);
		frameFinal=f;
		
		ventanaFinal=new VentanaPuntajeFinal();
		
		panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 600, 600);
		panel.setLayout(null);
		
		labelSplash = new JLabel("");
		labelSplash.setBounds(0, 0, 600, 600);
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
		try 
		{
			t.sleep(2000);
		} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		this.dispose();
		frameFinal.dispose();
		ventanaFinal.setVisible(true);
		}
	}

