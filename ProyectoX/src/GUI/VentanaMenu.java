package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Principal.Cronometro;

import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * @author Brunner Francisco, Vercelli Franco, Volpe Leandro.
 *
 */
public class VentanaMenu extends JFrame {

	private JPanel contentPane;
	private Frame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
//				try {
//					VentanaInicio frame = new VentanaInicio();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaMenu(Frame f) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(920, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 920, 600));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		frame=f;
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 920, 600);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton botonJugar = new JButton("");
		botonJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				//OYENTE DEL BOTON JUGAR
//				tiempo=new Cronometro(this);
//				tiempo.crono.start();
				frame.setVisible(true);
				dispose();
			}
		});
		botonJugar.setBorderPainted(false);
		botonJugar.setIcon(new ImageIcon(getClass().getResource("/images/botonJugar.png")));
		botonJugar.setBounds(48, 111, 230, 130);
		panel.add(botonJugar);
		
		JButton botonSalir = new JButton("");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();
				System.exit(0);
			}
		});
		botonSalir.setBorderPainted(false);
		botonSalir.setIcon(new ImageIcon(getClass().getResource("/images/botonSalir.png")));
		botonSalir.setBounds(48, 346, 230, 123);
		panel.add(botonSalir);
		
		JLabel labelFondo = new JLabel("");
		labelFondo.setIcon(new ImageIcon(getClass().getResource("/images/imagenFondo.jpg")));
		labelFondo.setBounds(0, 0, 920, 600);
		panel.add(labelFondo);
	}

}
