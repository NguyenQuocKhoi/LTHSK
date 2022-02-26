package nguyenQuocKhoi.nguyenQuocKhoi_20036191;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.DefaultButtonModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class DemoJList_Edittable_NguyenQuocKhoi_36 extends JFrame implements ActionListener {

	private JButton btnAdd;
	private JButton btnRemove;
	private JButton btnEdit;
	private JTextField txtName;
	DefaultListModel listmodleName;
	private JList listName;

	public DemoJList_Edittable_NguyenQuocKhoi_36() {
		super("List Edit Demo");
		this.setSize(500, 250);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);

		listmodleName = new DefaultListModel();
		listName = new JList(listmodleName);
		add(new JScrollPane(listName), BorderLayout.CENTER);

		JPanel ptop = new JPanel();
		ptop.add(new JLabel("Input Name"));
		ptop.add(txtName = new JTextField(10));

		JPanel pBottom = new JPanel();
		pBottom.add(btnAdd = new JButton("Add Item"));
		pBottom.add(btnRemove = new JButton("Remove Item"));
		pBottom.add(btnEdit = new JButton("Edit Item"));

		JPanel pRight = new JPanel(new BorderLayout());
		pRight.add(ptop, BorderLayout.NORTH);
		pRight.add(pBottom, BorderLayout.CENTER);
		add(pRight, BorderLayout.EAST);

		txtName.addActionListener(this);
		btnAdd.addActionListener(this);
		btnRemove.addActionListener(this);
		btnEdit.addActionListener(this);

	}

	public static void main(String[] args) {
		new DemoJList_Edittable_NguyenQuocKhoi_36().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnAdd) {
			String name = txtName.getText().trim();
			if (name == "")
				JOptionPane.showMessageDialog(this, "Please Input Name!");
			else {
				listmodleName.addElement(name);
				txtName.setText("");
			}
		} else if (obj.equals(btnRemove))
			listmodleName.removeElement(listName.getSelectedValue());

		else if (obj.equals(btnEdit))
			listmodleName.setElementAt(txtName.getText(), listName.getSelectedIndex());

	}

}
