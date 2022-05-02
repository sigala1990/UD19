package act4;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import java.awt.Color;

public class Act4 extends JFrame {

	private static Act4 frame;
	private JPanel contentPane;
	private JTextField tf_operant1, tf_operant2, tf_result;
	private JButton btn_sumar, btn_restar, btn_dividir, btn_multiplicar, btn_salir, btn_about;
	private JLabel lbl_typeOperation;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Act4();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Act4() {
		setTitle("miniCalculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tf_operant1 = new JTextField();
		tf_operant1.setBounds(10, 31, 86, 20);
		contentPane.add(tf_operant1);
		tf_operant1.setColumns(10);

		tf_operant2 = new JTextField();
		tf_operant2.setBounds(136, 31, 86, 20);
		contentPane.add(tf_operant2);
		tf_operant2.setColumns(10);

		tf_result = new JTextField();
		tf_result.setBounds(250, 31, 86, 20);
		contentPane.add(tf_result);
		tf_result.setColumns(10);

		lbl_typeOperation = new JLabel("?");
		lbl_typeOperation.setBounds(110, 34, 16, 14);
		contentPane.add(lbl_typeOperation);

		JLabel lbl_typeOperation_1 = new JLabel("=");
		lbl_typeOperation_1.setBounds(232, 34, 8, 14);
		contentPane.add(lbl_typeOperation_1);

		btn_sumar = new JButton("SUMAR");
		btn_sumar.setName("sumar");
		btn_sumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					realizarAccion(btn_sumar);
					}catch(MiException ex){
						System.out.println(ex.getMessage());
					}
			}
		});
		btn_sumar.setBounds(55, 89, 109, 23);
		contentPane.add(btn_sumar);

		btn_restar = new JButton("RESTAR");
		btn_restar.setName("restar");
		btn_restar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					realizarAccion(btn_restar);
					}catch(MiException ex){
						System.out.println(ex.getMessage());
					}
			}
		});
		btn_restar.setBounds(174, 89, 117, 23);
		contentPane.add(btn_restar);
		
		btn_multiplicar = new JButton("MULTIPLICAR");
		btn_multiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					realizarAccion(btn_multiplicar);
					}catch(MiException ex){
						System.out.println(ex.getMessage());
					}
			}
		});
		btn_multiplicar.setName("multiplicar");
		btn_multiplicar.setBounds(55, 123, 109, 23);
		contentPane.add(btn_multiplicar);

		btn_dividir = new JButton("DIVIDIR");
		btn_dividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					realizarAccion(btn_dividir);
					}catch(MiException ex){
						System.out.println(ex.getMessage());
					}
			}
		});
		btn_dividir.setName("dividir");
		btn_dividir.setBounds(174, 123, 117, 23);
		contentPane.add(btn_dividir);

		btn_salir = new JButton("SALIR");
		btn_salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					realizarAccion(btn_salir);
					}catch(MiException ex){
						System.out.println(ex.getMessage());
					}
			}
		});
		btn_salir.setName("salir");
		btn_salir.setBounds(55, 157, 236, 23);
		contentPane.add(btn_salir);

		btn_about = new JButton("ABOUT");
		btn_about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				realizarAccion(btn_about);
				}catch(MiException ex){
					System.out.println(ex.getMessage());
				}
		
			}
		});
		btn_about.setName("about");
		btn_about.setBounds(55, 190, 236, 23);
		contentPane.add(btn_about);

	}

	public void realizarAccion(JButton button) throws MiException { //realizar accion dependiendo del boton usado
	
		try {
			switch (button.getName().toLowerCase()) {
			case "sumar":
				tf_result.setText("" + (parsear(tf_operant1) + parsear(tf_operant2)));
				lbl_typeOperation.setText("+");
				break;
			case "restar":
				tf_result.setText("" + (parsear(tf_operant1) - parsear(tf_operant2)));
				lbl_typeOperation.setText("-");
				break;
			case "multiplicar":
				tf_result.setText("" + (parsear(tf_operant1) * parsear(tf_operant2)));
				lbl_typeOperation.setText("*");
				break;
			case "dividir":
				if(parsear(tf_operant2) == 0) {throw new  MiException(100); }
				tf_result.setText("" + ((parsear(tf_operant1) / parsear(tf_operant2)) * 100d) / 100d);
				lbl_typeOperation.setText("/");
				break;
			case "salir":
				frame.setVisible(false);
				System.out.println("close");
				break;
			case "about": //nueva ventana
				About about = new About();
				about.setVisible(true);
				break;
			}
		} catch (NumberFormatException e) { //exception que controla si no introduce numeros
			JOptionPane.showMessageDialog(null," ***ERROR***\nNo ha introducido un numero"); 
		}
	}

	public Double parsear(JTextField tf_text) {// parsear para q sea mas corto
		return Double.parseDouble(tf_text.getText());
	}


}
