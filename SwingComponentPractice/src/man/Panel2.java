package man;

import javax.swing.JTextField;

public class Panel2 {
	public static void main(String[] args) {
		JTextField field = new JTextField(20);
		System.out.println(field.getText());
		field.setText("whatever");
		
	}
}
