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
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class GUITKDoanhThu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	private JTable modeltable;
	private JTextField txtTienBan;
	private JTextField txtLoiNhuan;
	private JTextField txtTienNhap;
	private JTextField txtNam;
	private JComboBox cbbNgay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUITKDoanhThu frame = new GUITKDoanhThu();
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
	public GUITKDoanhThu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(30, 100, 1390, 744); // 2 chu dau là margin top , left
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1370, 694);
		panel.setBackground(new Color(224, 255, 255));
		contentPane.add(panel);

		JPanel paneltop = new JPanel();
		paneltop.setBackground(new Color(224, 255, 255));

		modeltable = new JTable();
		modeltable.setFont(new Font("Tahoma", Font.BOLD, 14));
		modeltable.setBorder(new TitledBorder(null, "Danh s\u00E1ch linh ki\u1EC7n", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(new Color(224, 255, 255));
		
		JLabel lblTTieuDe = new JLabel("THỐNG KÊ DOANH THU THEO THÁNG");
		lblTTieuDe.setForeground(Color.RED);
		lblTTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 26));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(modeltable, GroupLayout.DEFAULT_SIZE, 1340, Short.MAX_VALUE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(paneltop, GroupLayout.PREFERRED_SIZE, 644, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 647, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(403)
							.addComponent(lblTTieuDe, GroupLayout.PREFERRED_SIZE, 539, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(58, Short.MAX_VALUE)
					.addComponent(lblTTieuDe, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
						.addComponent(paneltop, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(modeltable, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_2.setLayout(null);

		JLabel lblTienBan = new JLabel("Tổng tiền bán được");
		lblTienBan.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTienBan.setBounds(67, 42, 157, 26);
		panel_2.add(lblTienBan);

		JLabel lblLoiNhuan = new JLabel("Lợi nhuận thu được");
		lblLoiNhuan.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLoiNhuan.setBounds(67, 144, 174, 26);
		panel_2.add(lblLoiNhuan);

		txtTienBan = new JTextField();
		txtTienBan.setEditable(false);
		txtTienBan.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtTienBan.setBounds(301, 43, 174, 26);
		panel_2.add(txtTienBan);
		txtTienBan.setColumns(10);

		txtLoiNhuan = new JTextField();
		txtLoiNhuan.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtLoiNhuan.setEditable(false);
		txtLoiNhuan.setColumns(10);
		txtLoiNhuan.setBounds(301, 145, 174, 26);
		panel_2.add(txtLoiNhuan);

		JLabel lblTienNhap = new JLabel("Tổng tiền nhập LK");
		lblTienNhap.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTienNhap.setBounds(67, 89, 157, 26);
		panel_2.add(lblTienNhap);

		txtTienNhap = new JTextField();
		txtTienNhap.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtTienNhap.setEditable(false);
		txtTienNhap.setColumns(10);
		txtTienNhap.setBounds(301, 90, 174, 26);
		panel_2.add(txtTienNhap);
		paneltop.setLayout(null);

		cbbNgay = new JComboBox();
		cbbNgay.setEditable(true);
		cbbNgay.setBounds(92, 38, 157, 26);
		paneltop.add(cbbNgay);

		JLabel lblThang = new JLabel("Tháng");
		lblThang.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThang.setBounds(30, 36, 52, 26);
		paneltop.add(lblThang);

		JLabel lblNam = new JLabel("Năm");
		lblNam.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNam.setBounds(377, 36, 126, 26);
		paneltop.add(lblNam);

		txtNam = new JTextField();
		txtNam.setColumns(10);
		txtNam.setBounds(437, 39, 96, 26);
		paneltop.add(txtNam);

		JButton btnNewButton = new JButton("Xem báo cáo");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(199, 120, 213, 45);
		paneltop.add(btnNewButton);
		panel.setLayout(gl_panel);
		//
		//        JXDatePicker picker = new JXDatePicker();
		//        picker.setDate(Calendar.getInstance().getTime());
		//        picker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));

		//  paneltop.add(picker);
	}
}
