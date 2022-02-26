package nguyenQuocKhoi.nguyenQuocKhoi_20036191;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DemoJList_NguyenQuocKhoi_36 extends JFrame {

	private JTextField txtSelected;
	private JList istEnty;

	public DemoJList_NguyenQuocKhoi_36() {
		this.setTitle("Creating a Sipmle JList");
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);

		String[] entries = { "Entry 1", "Entry 2", "Entry 3", "Entry 4", "Entry 5", "Entry 6" };

		istEnty = new JList(entries);
		istEnty.setVisibleRowCount(4);

		JScrollPane listPane = new JScrollPane(istEnty);
		JPanel pCen = new JPanel();
		pCen.setBorder(BorderFactory.createTitledBorder("Simple Jlist"));
		pCen.add(listPane);
		add(pCen, BorderLayout.CENTER);

		JPanel pSou = new JPanel();
		pSou.add(new JLabel("Last Selection"));
		txtSelected = new JTextField(10);
		pSou.add(txtSelected);
		pSou.setBorder(BorderFactory.createTitledBorder("List Selection"));
		add(pSou, BorderLayout.SOUTH);
		istEnty.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				txtSelected.setText(istEnty.getSelectedValue().toString());

			}
		});

	}

	public static void main(String[] args) {
		new DemoJList_NguyenQuocKhoi_36().setVisible(true);
	}

}
