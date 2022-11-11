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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class GUITKLinhKien extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	private JTable modeltable;
	private JTextField txtSoLuong;
	private JTextField txtSoLoai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUITKLinhKien frame = new GUITKLinhKien();
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
	public GUITKLinhKien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(30, 100, 1390, 744); // 2 chu dau là margin top , left
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1360, 705);
		panel.setBackground(new Color(224, 255, 255));
		contentPane.add(panel);
		
		JPanel panel_top = new JPanel();
		panel_top.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "H\u00ECnh th\u1EE9c th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP,null, null));
		panel_top.setBackground(new Color(224, 255, 255));
		
		modeltable = new JTable();
		modeltable.setFont(new Font("Tahoma", Font.BOLD, 14));
		modeltable.setBorder(new TitledBorder(null, "Danh s\u00E1ch linh ki\u1EC7n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(250, 250, 210));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "B\u00E1o c\u00E1o th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(new Color(224, 255, 255));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(526)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(modeltable, GroupLayout.PREFERRED_SIZE, 1335, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(panel_top, GroupLayout.PREFERRED_SIZE, 644, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 647, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(16, Short.MAX_VALUE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(panel_top, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(modeltable, GroupLayout.PREFERRED_SIZE, 373, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		panel_2.setLayout(null);
		
		JLabel lblSoLuong = new JLabel("Tổng số lượng");
		lblSoLuong.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSoLuong.setBounds(67, 54, 126, 26);
		panel_2.add(lblSoLuong);
		
		JLabel lblSoLoai = new JLabel("Tổng số loại");
		lblSoLoai.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSoLoai.setBounds(67, 114, 126, 26);
		panel_2.add(lblSoLoai);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setEditable(false);
		txtSoLuong.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSoLuong.setBounds(224, 55, 174, 26);
		panel_2.add(txtSoLuong);
		txtSoLuong.setColumns(10);
		
		txtSoLoai = new JTextField();
		txtSoLoai.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSoLoai.setEditable(false);
		txtSoLoai.setColumns(10);
		txtSoLoai.setBounds(224, 120, 174, 26);
		panel_2.add(txtSoLoai);
		panel_1.setLayout(null);
		
		JLabel lblTTieuDe = new JLabel("THỐNG KÊ LINH KIỆN");
		lblTTieuDe.setForeground(Color.RED);
		lblTTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblTTieuDe.setBounds(10, 10, 298, 29);
		panel_1.add(lblTTieuDe);
		panel_top.setLayout(null);
		
		JButton btnLKDaBan = new JButton("Xem linh kiện đã bán");
		btnLKDaBan.setBackground(new Color(102, 205, 170));
		btnLKDaBan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLKDaBan.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLKDaBan.setBounds(59, 104, 192, 44);
		panel_top.add(btnLKDaBan);
		
		JButton btnKhoLK = new JButton("Xem kho linh kiện");
		btnKhoLK.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnKhoLK.setBackground(new Color(102, 205, 170));
		btnKhoLK.setBounds(347, 104, 192, 44);
		panel_top.add(btnKhoLK);
		panel.setLayout(gl_panel);
	}
}
