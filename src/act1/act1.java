package act1;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class act1 extends JFrame {

	private JPanel contentPane;
	private JTextField tf_result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					act1 frame = new act1();
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
	public act1() {
		setTitle("Saludador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_text = new JLabel("Escribe un nombre para saludar");
		lbl_text.setToolTipText("-");
		lbl_text.setBounds(112, 64, 245, 14);
		contentPane.add(lbl_text);
		
		tf_result = new JTextField();
		tf_result.setBounds(71, 113, 286, 20);
		contentPane.add(tf_result);
		tf_result.setColumns(10);
		
		JButton btn_saludar = new JButton("Saludar!");
		btn_saludar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Hola "+ tf_result.getText());
			}
		});
		btn_saludar.setBounds(170, 177, 89, 23);
		contentPane.add(btn_saludar);
	}
}
