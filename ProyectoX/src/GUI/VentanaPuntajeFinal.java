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
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
/**
 * @author Brunner Francisco, Vercelli Franco, Volpe Leandro.
 *
 */
public class VentanaPuntajeFinal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
//				try {
//					VentanaPuntajeFinal frame = new VentanaPuntajeFinal();
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
	public VentanaPuntajeFinal(int p) {
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
		
		JButton botonReintentar = new JButton("");
		botonReintentar.setIcon(new ImageIcon(getClass().getResource("/images/jugarAgain.jpg")));
		botonReintentar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUI oli = new GUI();
				oli.main(null);
				dispose();
			}
		});
		
		JLabel labelPuntajeFinal = new JLabel(""+p);
		labelPuntajeFinal.setHorizontalAlignment(SwingConstants.CENTER);
		labelPuntajeFinal.setForeground(Color.ORANGE);
		
		labelPuntajeFinal.setFont(new Font("Arial", Font.BOLD, 83));
		labelPuntajeFinal.setBounds(321, 271, 273, 142);
		contentPane.add(labelPuntajeFinal);
		botonReintentar.setBounds(76, 447, 326, 142);
		contentPane.add(botonReintentar);
		
		JButton botonSalir = new JButton("");
		botonSalir.setIcon(new ImageIcon(getClass().getResource("/images/salir.jpg")));
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();
				System.exit(0);
			}
		});
		botonSalir.setBounds(537, 447, 326, 142);
		contentPane.add(botonSalir);
		Font fuente=new Font("ARIAL",Font.BOLD,40);
		
		JLabel labelFondoFinal = new JLabel("");
		labelFondoFinal.setIcon(new ImageIcon(getClass().getResource("/images/imagenFinal.jpg")));
		labelFondoFinal.setBounds(new Rectangle(0, 0, 920, 600));
		labelFondoFinal.setBounds(0, -28, 930, 658);
		contentPane.add(labelFondoFinal);
	}


}
