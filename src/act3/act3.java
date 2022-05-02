package act3;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;

import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class act3 extends JFrame {

	private JPanel contentPane;
	private Checkbox cbcode,cbadmin, cbdesign;
	private ButtonGroup groupRadio;
	private JRadioButton rb_windows, rb_linux, rb_mac;
	private JSlider slider;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					act3 frame = new act3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public act3() {
		setTitle("Encuesta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rb_windows = new JRadioButton("Windows");
		rb_windows.setActionCommand("Windows");
		rb_windows.setBounds(51, 83, 86, 23);
		contentPane.add(rb_windows);
		
		rb_linux = new JRadioButton("Linux");
		rb_linux.setActionCommand("Linux");
		rb_linux.setBounds(51, 110, 109, 23);
		contentPane.add(rb_linux);
		
		rb_mac = new JRadioButton("Mac");
		rb_mac.setActionCommand("Mac");
		rb_mac.setBounds(51, 136, 109, 23);
		contentPane.add(rb_mac);
		
		groupRadio = new ButtonGroup();
		groupRadio.add(rb_windows);
		groupRadio.add(rb_linux);
		groupRadio.add(rb_mac);
	
		
		JLabel lblNewLabel = new JLabel("Selecciona un sistema operativo y tu especialidad si la tienes.");
		lblNewLabel.setBounds(51, 23, 447, 14);
		contentPane.add(lblNewLabel);
		
		cbdesign = new Checkbox("Diseño");
		cbdesign.setBounds(190, 110, 97, 23);
		contentPane.add(cbdesign);
		
		cbcode= new Checkbox("Programacion");
		cbcode.setBounds(190, 83, 97, 23);
		contentPane.add(cbcode);
		
		cbadmin = new Checkbox("Administracion");
		cbadmin.setBounds(190, 136, 97, 23);
		contentPane.add(cbadmin);
		
		slider = new JSlider();
		slider.setMaximum(10);
		slider.setMajorTickSpacing(1);
		slider.setPaintLabels(true);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(1);
		slider.setBounds(47, 201, 472, 82);
		contentPane.add(slider);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, mostrarMsgFinal());
			}
		});
		btnNewButton.setBounds(397, 110, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Selecciona horas dedicadas");
		lblNewLabel_1.setBounds(51, 169, 290, 38);
		contentPane.add(lblNewLabel_1);
		
		}
	
	public String mostrarMsgFinal() {// suma de todos los strings
		String msg= "";
		msg += getValueRadioGroup();
		msg += getValuesCb();
		msg += getValueSlider();
		return msg;
	}
	public String getValueSlider() { //frase para el valor del slider
		return "Horas dedicadas "+slider.getValue();
	}
	
	public String getValuesCb() { //frase para el valor de los checkboxs
		String value = "Especialidad seleccionada: \n";
		boolean nothing = false;
		if(cbcode.getState()) {
			value += "- Programacion \n";
			nothing = true;
		}
		if(cbdesign.getState()) {
			value += "- Diseño \n";
			nothing = true;
		}
		if(cbadmin.getState()) {
			value += "- Administración \n";
			nothing = true;
		}
		if(nothing) {
			return value;
		}else {
			return "No seleccionaste ninguna especialidad\n";
		}
		
	}
	
	public String getValueRadioGroup() { // controla que no tenga un radiobutton vacio y muestra msg
		boolean isSelected = false;
		for(Enumeration<AbstractButton> buttons = groupRadio.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			if(button.isSelected()) {
				isSelected = true;
			}
		}
		isSelected = false;
		if(isSelected) {
			return "Seleccionaste "+groupRadio.getSelection().getActionCommand()+ " como SO.\n";
		}else {
			return "No seleccionaste ningun SO.\n";
		}
	}
}
