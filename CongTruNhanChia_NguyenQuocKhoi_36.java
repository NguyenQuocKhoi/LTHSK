package nguyenQuocKhoi.tuan1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

public class CongTruNhanChia_NguyenQuocKhoi_36 extends JFrame implements ActionListener {

	private JTextField txta;
	private JTextField txtb;
	private JButton btnGiai;
	private JButton btnXoa;
	private JButton btnThoat;
	private JTextField txtKetQua;
	private JRadioButton radTru;
	private JRadioButton radCong;
	private JRadioButton radNhan;
	private JRadioButton radChia;

	public CongTruNhanChia_NguyenQuocKhoi_36() {
		this.setTitle("Cộng - Trừ - Nhân - Chia");
		this.setSize(450, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel p = new JPanel(new BorderLayout());
		JPanel n = new JPanel();
		JLabel lblTitle = new JLabel("Cộng trừ nhân chia");
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(new Font("Calibri", Font.BOLD, 35));
		n.add(lblTitle);
		p.add(n, BorderLayout.NORTH);

		JPanel w = new JPanel();
		w.setLayout(new BoxLayout(w, BoxLayout.Y_AXIS));
		w.setBackground(Color.GRAY);
		btnGiai = new JButton("Giải");
		btnXoa = new JButton("Xóa");
		btnThoat = new JButton("Thoát");
		Border bw = BorderFactory.createLineBorder(Color.blue);
		TitledBorder ttbd = new TitledBorder(bw, "Chọn tác vụ");
		w.setPreferredSize(new Dimension(95, 0));
		w.setBorder(ttbd);
		w.add(btnGiai);
		w.add(Box.createVerticalStrut(10));
		w.add(btnXoa);
		w.add(Box.createVerticalStrut(10));
		w.add(btnThoat);
		w.add(Box.createVerticalStrut(10));
		p.add(w, BorderLayout.WEST);

		JPanel s = new JPanel();
		s.setPreferredSize(new Dimension(40, 40));
		s.setBackground(Color.RED);
		p.add(s, BorderLayout.SOUTH);

		JPanel ct = new JPanel();
		ct.setBorder(BorderFactory.createTitledBorder("Tính toán"));
		ct.add(new JLabel("Nhập a: "));
		ct.add(txta = new JTextField(25));
		ct.add(new JLabel("Nhập b: "));
		ct.add(txtb = new JTextField(25));
		p.add(ct, BorderLayout.CENTER);

		radCong = new JRadioButton("Cộng");
		ct.add(radCong);
		radTru = new JRadioButton("Trừ");
		ct.add(radTru);
		radNhan = new JRadioButton("Nhân");
		ct.add(radNhan);
		radChia = new JRadioButton("Chia");
		ct.add(radChia);
		ButtonGroup group = new ButtonGroup();
		group.add(radCong);
		group.add(radTru);
		group.add(radNhan);
		group.add(radChia);
		p.add(ct);

		Box b = Box.createVerticalBox();
		Box bKetqua = Box.createHorizontalBox();
		ct.add(Box.createVerticalStrut(10));
		bKetqua.add(new JLabel("Kết quả: "));
		b.add(bKetqua);
		ct.add(b);

		txtKetQua = new JTextField(25);
		bKetqua.add(txtKetQua);
		txtKetQua.setEditable(false);
		this.add(p);

		btnGiai.addActionListener(this);
		btnThoat.addActionListener(this);
		btnXoa.addActionListener(this);

	}

	public static void main(String[] args) {
		new CongTruNhanChia_NguyenQuocKhoi_36().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnThoat)) {
			System.exit(0);
		} else if (obj.equals(btnXoa)) {
			txta.setText("");
			txtb.setText("");
			txtKetQua.setText("");
			txta.requestFocus();
		} else {
			if (!isInt(txta)) {
				JOptionPane.showMessageDialog(null, "Nhập số nguyên");
				txta.requestFocus();
				txta.selectAll();
			} else {
				focus(txtb);
				txta.setText("");
				txtb.setText("");
				txta.requestFocus();
			}
			double a, b;
			double kq;
			a = Integer.parseInt(txta.getText());
			b = Integer.parseInt(txtb.getText());
			if (radCong.isSelected()) {
				kq = a + b;
			} else if (radTru.isSelected()) {
				kq = a - b;
			} else if (radNhan.isSelected()) {
				kq = a * b;
			} else {
				kq = a / b;
			}
			txtKetQua.setText("" + kq);
		}
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

	private void focus(JTextField text) {
		JOptionPane.showMessageDialog(null, "lỗi nhập liệu");
		text.selectAll();
		text.requestFocus();
	}
}
