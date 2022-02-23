package nguyenQuocKhoi.tuan1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class GiaiPTBac2_NguyenQuocKhoi_36 extends JFrame implements ActionListener {

	private JButton btngiai;
	private JButton btnxoa;
	private JButton btnthoat;
	private JTextField txtketqua;
	private JTextField txta;
	private JTextField txtb;
	private JTextField txtc;

	public GiaiPTBac2_NguyenQuocKhoi_36() {
		this.setTitle("^-^");
		this.setSize(650, 290);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel p = new JPanel(new BorderLayout());
		JPanel ptren = new JPanel();
		JLabel lbltxt = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC 2");
		lbltxt.setForeground(Color.BLACK);
		lbltxt.setFont(new Font("arial", Font.BOLD, 20));
		ptren.setBackground(Color.BLUE);
		ptren.add(lbltxt);
		p.add(ptren, BorderLayout.NORTH);
		this.add(p);

		JPanel pduoi = new JPanel();
		pduoi.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		pduoi.setPreferredSize(new Dimension(0, 70));
		btngiai = new JButton("Giải");
		pduoi.add(btngiai);
		btnxoa = new JButton("Xóa rỗng");
		pduoi.add(btnxoa);
		btnthoat = new JButton("Thoát");
		pduoi.add(btnthoat);
		p.add(pduoi, BorderLayout.SOUTH);

		Box bgiua = Box.createVerticalBox();
		Box p1 = Box.createHorizontalBox();
		Box p2 = Box.createHorizontalBox();
		Box p3 = Box.createHorizontalBox();
		Box p4 = Box.createHorizontalBox();
		p1.add(new JLabel("Nhập a: "));
		txta = new JTextField(10);
		p1.add(txta);
		p2.add(new JLabel("Nhập b: "));
		txtb = new JTextField(10);
		p2.add(txtb);
		p3.add(new JLabel("Nhập c: "));
		txtc = new JTextField(10);
		p3.add(txtc);
		p4.add(new JLabel("Kết quả: "));
		txtketqua = new JTextField(20);
		txtketqua.setEditable(false);
		p4.add(txtketqua);
		bgiua.add(Box.createRigidArea(new Dimension(10, 10)));
		bgiua.add(p1);
		bgiua.add(Box.createRigidArea(new Dimension(10, 10)));
		bgiua.add(p2);
		bgiua.add(Box.createRigidArea(new Dimension(10, 10)));
		bgiua.add(p3);
		bgiua.add(Box.createRigidArea(new Dimension(10, 10)));
		bgiua.add(p4);
		bgiua.add(Box.createRigidArea(new Dimension(10, 10)));
		p.add(bgiua);
		btngiai.addActionListener(this);
		btnxoa.addActionListener(this);
		btnthoat.addActionListener(this);
	}

	public static void main(String[] args) {
		new GiaiPTBac2_NguyenQuocKhoi_36().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnthoat)) {
			System.exit(0);
		} else if (obj.equals(btnxoa)) {
			txta.setText("");
			txtb.setText("");
			txtc.setText("");
			txtketqua.setText("");
			txta.requestFocus();
			;
		} else {
			if (!isInt(txta)) {
				{
					JOptionPane.showMessageDialog(null, "Nhập số nguyên");
					txta.selectAll();
					txta.requestFocus();
				}
			} else if (!isInt(txtb)) {
				focus(txtb);
			} else if (!isInt(txtc)) {
				focus(txtc);
			} else {

				int a, b, c;
				a = Integer.parseInt(txta.getText());
				b = Integer.parseInt(txtb.getText());
				c = Integer.parseInt(txtc.getText());
				if (a != 0) {
					float delta = b * b - 4 * a * c;
					if (delta < 0) {
						txtketqua.setText("Phương trình vô nghiệm");
					} else if (delta == 0) {
						txtketqua.setText("Phương trình có nghiệp kép: " + -b / (2 * a));
					} else
						txtketqua.setText("Có 2 nghiệm x1:" + (-b - Math.sqrt(delta) / 2 * a) + "  x2: "
								+ (-b + Math.sqrt(delta) / 2 * a));

				} else {
					txtketqua.setText("" + -c / b);
				}
			}
		}
	}

	private boolean isInt(JTextField text) {
		boolean result = true;
		try {
			Integer.parseInt(text.getText());
		} catch (NumberFormatException ex) {
			result = false;
		}
		return result;
	}

	private void focus(JTextField text) {
		JOptionPane.showMessageDialog(null, "Lỗi nhập liệu.");
		text.selectAll();
		text.requestFocus();
	}
}
