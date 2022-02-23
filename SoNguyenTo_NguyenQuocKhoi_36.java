package nguyenQuocKhoi.tuan1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SoNguyenTo_NguyenQuocKhoi_36 extends JFrame implements ActionListener {

	private JTextField txtNhap;
	private JButton btnGenerate;
	private JTextArea txtKetqua;

	public SoNguyenTo_NguyenQuocKhoi_36() {
		this.setTitle("Primes");
		this.setSize(450, 280);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel p = new JPanel(new BorderLayout());
		JPanel ptren = new JPanel();
		txtNhap = new JTextField(30);
		btnGenerate = new JButton("Generate");
		ptren.add(txtNhap);
		ptren.add(btnGenerate);
		p.add(ptren, BorderLayout.NORTH);
		this.add(p);

		JPanel pgiua = new JPanel();
		txtKetqua = new JTextArea(20, 40);
		// txtKetqua.setPreferredSize(new Dimension(0, 150));
		pgiua.add(txtKetqua);
		p.add(pgiua, BorderLayout.CENTER);
		btnGenerate.addActionListener(this);
	}

	public static void main(String[] args) {
		new SoNguyenTo_NguyenQuocKhoi_36().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!isInt(txtNhap)) {
			JOptionPane.showInternalMessageDialog(null, "Nhập số nguyên");
			txtNhap.selectAll();
			txtNhap.requestFocus();
			txtNhap.setText("");
		}
		int n, a = 2;
		int count = 0;
		n = Integer.parseInt(txtNhap.getText());
		while (true) {
			if (kiemTraSoNguyenTo(a)) {
				txtKetqua.setText(txtKetqua.getLineCount() + "" + a);
				count++;
			}
			if (count == n) {
				break;
			}
			if (a == 2)
				a++;
			else
				a += 2;
		}

	}

	public static boolean kiemTraSoNguyenTo(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	private boolean isInt(JTextField text) {
		boolean ketqua = true;
		try {
			Integer.parseInt(text.getText());
		} catch (NumberFormatException e) {
			ketqua = false;
		}
		return ketqua;
	}

}
