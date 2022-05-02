package act4;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;

public class About extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new About();
					About frame = new About();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public About() {
		setTitle("About us");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		JLabel background = new JLabel(new ImageIcon(About.class.getResource("/img/esplai.jpg"))); //ruta imagen
		//JLabel background = new JLabel(new ImageIcon("C:\\Users\\adria\\Desktop\\esplai.jpg"));
		background.setBounds(0, -73, 374, 351);
		getContentPane().add(background);
		background.setLayout(new FlowLayout());
		
		lblNewLabel = new JLabel("\u00BFQuienes somos?");
		lblNewLabel.setFont(new Font("DejaVu Serif", Font.BOLD, 20));
		lblNewLabel.setBounds(20, 201, 351, 35);
		contentPane.add(lblNewLabel);
		
		JTextArea txtrLoremIpsumDolor = new JTextArea();
		txtrLoremIpsumDolor.setEditable(false);
		txtrLoremIpsumDolor.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit.\r\n Nam aliquet vitae augue \npellentesque sodales. Aenean rhoncus purus elit, vitae volutpat \nvelit ornare vitae. Nulla hendrerit,\n massa sed fermentum aliquet.");
		txtrLoremIpsumDolor.setBounds(10, 229, 364, 121);
		contentPane.add(txtrLoremIpsumDolor);
	        setSize(399,399);
	        setSize(400,400);
	        
	}
}
