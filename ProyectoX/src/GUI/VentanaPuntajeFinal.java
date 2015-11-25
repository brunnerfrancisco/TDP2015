package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;

public class VentanaPuntajeFinal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPuntajeFinal frame = new VentanaPuntajeFinal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPuntajeFinal() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(920, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 920, 600));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelFondoFinal = new JLabel("");
		labelFondoFinal.setBounds(new Rectangle(0, 0, 920, 600));
		labelFondoFinal.setBounds(10, 11, 862, 612);
		contentPane.add(labelFondoFinal);
		
		JButton botonReintentar = new JButton("");
		botonReintentar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();
				//REINICIAR JUEGO!!!!!
			}
		});
		botonReintentar.setBounds(69, 358, 326, 142);
		contentPane.add(botonReintentar);
		
		JButton botonSalir = new JButton("");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();
				System.exit(0);
			}
		});
		botonSalir.setBounds(548, 358, 301, 142);
		contentPane.add(botonSalir);
		
		JLabel labelPuntajeFinal = new JLabel("Puntaje final:");
		Font fuente=new Font("ARIAL",Font.BOLD,40);
		
		labelPuntajeFinal.setFont(fuente);
		labelPuntajeFinal.setBounds(210, 101, 518, 177);
		contentPane.add(labelPuntajeFinal);
	}

}
