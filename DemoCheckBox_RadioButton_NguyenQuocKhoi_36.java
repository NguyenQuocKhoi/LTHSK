package nguyenQuocKhoi.nguyenQuocKhoi_20036191;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class DemoCheckBox_RadioButton_NguyenQuocKhoi_36 extends JFrame implements ActionListener, ItemListener {
	private JCheckBox ckitalic;
	private JRadioButton rbtnleft;
	private JRadioButton rbtnringht;
	private JLabel lbltxt;

	public DemoCheckBox_RadioButton_NguyenQuocKhoi_36() {
		this.setTitle("derived 	button");
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);

		JPanel p = new JPanel();
		p.add(ckitalic = new JCheckBox("Italic"));
		p.add(rbtnleft = new JRadioButton("Left",true));
		p.add(rbtnringht = new JRadioButton("right"));
		this.add(p, BorderLayout.NORTH);
		this.add(lbltxt = new JLabel("Hello World!"));

		ButtonGroup btng = new ButtonGroup();
		btng.add(rbtnleft);
		btng.add(rbtnringht);
		ckitalic.addItemListener(this);
		rbtnleft.addActionListener(this);
		rbtnringht.addActionListener(this);

	}

	public static void main(String[] args) {
		new DemoCheckBox_RadioButton_NguyenQuocKhoi_36().setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Font f = lbltxt.getFont();
		if (e.getStateChange() == ItemEvent.SELECTED) {
			lbltxt.setFont(new Font(f.getName(), Font.ITALIC, f.getSize()));
			;
		} else
			lbltxt.setFont(new Font(f.getName(), Font.PLAIN, f.getSize()));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(rbtnleft)) {
			lbltxt.setHorizontalAlignment(SwingConstants.LEFT);
		} else if (obj.equals(rbtnringht)) {
			lbltxt.setHorizontalAlignment(SwingConstants.RIGHT);
		}

	}

}
