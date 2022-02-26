package nguyenQuocKhoi.nguyenQuocKhoi_20036191;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DemoComboBox_NguyenQuocKhoi_36 extends JFrame implements ActionListener {

	private JLabel lbllabel;
	private JComboBox facecombo;

	public DemoComboBox_NguyenQuocKhoi_36() {
		this.setTitle("JComboBox Demo");
		this.setSize(400, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);

		lbllabel = new JLabel("The quick brown foxx jumps over the lazy dog.");
		lbllabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lbllabel, BorderLayout.CENTER);

		facecombo = new JComboBox();
		facecombo.addItem("Serif");
		facecombo.addItem("SanSerif");
		facecombo.addItem("Monospaced");
		add(facecombo, BorderLayout.SOUTH);
		facecombo.addActionListener(this);

	}

	public static void main(String[] args) {
		new DemoComboBox_NguyenQuocKhoi_36().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String fontName = (String) facecombo.getSelectedItem();
		lbllabel.setFont(new Font(fontName, lbllabel.getFont().getStyle(), lbllabel.getFont().getSize()));

	}
}
