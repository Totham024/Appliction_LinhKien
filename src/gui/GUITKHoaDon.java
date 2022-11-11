package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;


import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;


public class GUITKHoaDon extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	private JTable modeltable;
	private JTextField txtSoLK;
	private JTextField txtSoHD;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField textField;
	private JComboBox cbbNgay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUITKHoaDon frame = new GUITKHoaDon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUITKHoaDon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(30, 100, 1390, 744); // 2 chu dau là margin top , left
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1360, 694);
		panel.setBackground(new Color(224, 255, 255));
		contentPane.add(panel);

		JPanel paneltop = new JPanel();
		paneltop.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "H\u00ECnh th\u1EE9c th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP,null, null));
		paneltop.setBackground(new Color(224, 255, 255));

		modeltable = new JTable();
		modeltable.setFont(new Font("Tahoma", Font.BOLD, 14));
		modeltable.setBorder(new TitledBorder(null, "Danh s\u00E1ch linh ki\u1EC7n", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "B\u00E1o c\u00E1o th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(new Color(224, 255, 255));
		
		JLabel lblThngKHa = new JLabel("THỐNG KÊ HÓA ĐƠN ");
		lblThngKHa.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngKHa.setForeground(Color.RED);
		lblThngKHa.setFont(new Font("Times New Roman", Font.BOLD, 26));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(modeltable, GroupLayout.PREFERRED_SIZE, 1334, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(paneltop, GroupLayout.PREFERRED_SIZE, 644, GroupLayout.PREFERRED_SIZE)
									.addGap(34)
									.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 647, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(439)
							.addComponent(lblThngKHa, GroupLayout.PREFERRED_SIZE, 461, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(41, Short.MAX_VALUE)
					.addComponent(lblThngKHa, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(paneltop, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(modeltable, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
					.addGap(42))
		);
		panel_2.setLayout(null);

		JLabel lblSoLuong = new JLabel("Tổng số LK đã bán");
		lblSoLuong.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSoLuong.setBounds(67, 42, 157, 26);
		panel_2.add(lblSoLuong);

		JLabel lblSoHD = new JLabel("Tổng số hóa đơn");
		lblSoHD.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSoHD.setBounds(67, 144, 126, 26);
		panel_2.add(lblSoHD);

		txtSoLK = new JTextField();
		txtSoLK.setEditable(false);
		txtSoLK.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSoLK.setBounds(224, 43, 174, 26);
		panel_2.add(txtSoLK);
		txtSoLK.setColumns(10);

		txtSoHD = new JTextField();
		txtSoHD.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSoHD.setEditable(false);
		txtSoHD.setColumns(10);
		txtSoHD.setBounds(224, 145, 174, 26);
		panel_2.add(txtSoHD);

		JLabel lblSoTien = new JLabel("Tổng số tiền đã bán");
		lblSoTien.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSoTien.setBounds(67, 89, 157, 26);
		panel_2.add(lblSoTien);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(224, 90, 174, 26);
		panel_2.add(textField);
		paneltop.setLayout(null);

		cbbNgay = new JComboBox();
		cbbNgay.setBounds(114, 34, 174, 26);
		paneltop.add(cbbNgay);

		JLabel lblNgay = new JLabel("Ngày");
		lblNgay.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNgay.setBounds(30, 32, 52, 26);
		paneltop.add(lblNgay);

		JLabel lblMaNV = new JLabel("Mã NV");
		lblMaNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMaNV.setBounds(30, 80, 126, 26);
		paneltop.add(lblMaNV);

		JLabel lblTenNV = new JLabel("Tên NV");
		lblTenNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTenNV.setBounds(30, 124, 126, 26);
		paneltop.add(lblTenNV);

		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtMaNV.setEditable(false);
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(114, 71, 174, 26);
		paneltop.add(txtMaNV);

		txtTenNV = new JTextField();
		txtTenNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtTenNV.setEditable(false);
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(114, 125, 174, 26);
		paneltop.add(txtTenNV);
		panel.setLayout(gl_panel);
		//
		//        JXDatePicker picker = new JXDatePicker();
		//        picker.setDate(Calendar.getInstance().getTime());
		//        picker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));

		//  paneltop.add(picker);
	}
}
