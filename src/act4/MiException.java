package act4;

import javax.swing.JOptionPane;

public class MiException extends Exception {

	private int code;

	public MiException(int code) {
		this.code = code;
	}
	@Override
	public String getMessage() {
		
		String msg = "";
		switch (code) {
		case 100:
			msg = "No se puede dividir entre 0";
			break;
		default:
			msg = "El valor introducido como operadores no es correcto";
			break;
		}
		JOptionPane.showMessageDialog(null, msg);
		return super.getMessage();
	}
	
	
}
