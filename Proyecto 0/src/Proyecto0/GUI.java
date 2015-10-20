package Proyecto0;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.*;

public class GUI extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		String path = "/Proyecto0/image.jpg";  
		URL url = this.getClass().getResource(path);  
		ImageIcon icon = new ImageIcon(url);
		this.setTitle("PROYECTO 0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 400);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		FlowLayout fl_panel_1 = new FlowLayout(FlowLayout.CENTER, 0, 0);
		panel_1.setLayout(fl_panel_1);
		
		JLabel lblImagen = new JLabel("");
		panel_1.add(lblImagen);
		lblImagen.setIcon(icon);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		
		JButton btnFrase = new JButton("Frase");
		panel_3.add(btnFrase);
		
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		
		JLabel lblFrase = new JLabel("");
		panel_4.add(lblFrase);
		lblFrase.setPreferredSize(new Dimension(100,10));
		
		btnFrase.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				lblFrase.setText("AY CARAMBA!!");
				btnFrase.setEnabled(false);
			}
		});
	}

}
