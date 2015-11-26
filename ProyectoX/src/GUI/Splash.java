package GUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Rectangle;
/**
 * @author Brunner Francisco, Vercelli Franco, Volpe Leandro.
 *
 */
public class Splash extends javax.swing.JFrame implements Runnable
{
	Thread t;
	JPanel panel;
	JLabel labelSplash;
	JFrame frame;
	VentanaMenu inicio;
	
	public Splash(JFrame f) {
		setUndecorated(true);
		setSize(920,600);
		frame=f;
		inicio = new VentanaMenu(f);

		panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 920, 600);
		panel.setLayout(null);
		
		labelSplash = new JLabel("");
		labelSplash.setBounds(0, 0,920, 600);
		labelSplash.setIcon(new ImageIcon(getClass().getResource("/images/sega.jpg")));
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
			t.sleep(1000);
		} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		this.dispose();
		//frame.setVisible(true);
		inicio.setVisible(true);
		}
	}

