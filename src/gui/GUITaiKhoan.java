package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import entity.TaiKhoan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import dao.NhanVienDAO;

public class GUITaiKhoan extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4988454772471512347L;
	private JPanel contentPane;
	public static JTextField txtTenTaiKhoan;
	private JPasswordField txtMatKhau;
	private JComboBox cbbLoaiLK;
	private JButton btnOk;
	GuiDiaChi GuiDiaChi = new GuiDiaChi();
	NhanVienDAO nvDao = new NhanVienDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUITaiKhoan frame = new GUITaiKhoan();
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
	public GUITaiKhoan() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 432, 293);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("menu"));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblUserName = new JLabel("Tên tài khoản:");
		lblUserName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblUserName.setBounds(60, 82, 109, 23);
		contentPane.add(lblUserName);

		txtTenTaiKhoan = new JTextField();
		txtTenTaiKhoan.setBounds(179, 83, 167, 23);
		contentPane.add(txtTenTaiKhoan);
		txtTenTaiKhoan.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Mật khẩu:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(60, 131, 109, 23);
		contentPane.add(lblNewLabel_1);

		txtMatKhau = new JPasswordField();
		txtMatKhau.setBounds(179, 132, 167, 23);
		contentPane.add(txtMatKhau);
		txtMatKhau.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panel.setBounds(10, 11, 396, 60);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblngKTi = new JLabel("Đăng Ký Tài Khoản Nhân Viên");
		lblngKTi.setForeground(Color.RED);
		lblngKTi.setHorizontalAlignment(SwingConstants.CENTER);
		lblngKTi.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblngKTi.setBounds(10, 11, 375, 38);
		panel.add(lblngKTi);
		btnOk = new JButton("Thêm");
		btnOk.setBackground(new Color(127, 255, 212));
		btnOk.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnOk.setBounds(179, 214, 79, 29);
		contentPane.add(btnOk);
		
		cbbLoaiLK = new JComboBox();
		cbbLoaiLK.setBounds(179, 170, 101, 22);
		contentPane.add(cbbLoaiLK);
		cbbLoaiLK.addItem("NV");
		cbbLoaiLK.addItem("QL");
		
		JLabel lblLoaiTK = new JLabel("Loại TK");
		lblLoaiTK.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblLoaiTK.setBounds(60, 165, 109, 23);
		contentPane.add(lblLoaiTK);
		btnOk.addActionListener(this);
		String myPass = String.valueOf(txtMatKhau.getPassword());
		System.out.println(myPass);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnOk)) {
			try {
				if (kiemTraDuLieu()) {
					if (kiemTraUserNameTonTai()) {
						String password = String.valueOf(txtMatKhau.getPassword());
						String loai = (String) cbbLoaiLK.getSelectedItem();

						TaiKhoan tk = new TaiKhoan(txtTenTaiKhoan.getText(), password, loai);
						nvDao.addTaiKhoan(tk);
						JOptionPane.showMessageDialog(this, "Thêm tài khoản thành công !", "Thông báo",
								JOptionPane.CLOSED_OPTION);
						NhanVienGUI.txtTaiKhoan.setText(txtTenTaiKhoan.getText().trim());
						
						this.setVisible(false);
//						GuiDiaChi.setVisible(true);
				//		new GuiDiaChi().setVisible(true);
//						if (GuiDiaChi.isVisible()) {
//							NhanVienGUI.btnThemTK.setEnabled(false);
//						} else {
//							NhanVienGUI.btnThemTK.setEnabled(true);
//						}
					}
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Thêm tài khoản bị lỗi !");
				e2.printStackTrace();
			}
		}
	}

	public boolean kiemTraDuLieu() {
//		Pattern tenTaiKhoanPatern = Pattern.compile("[A-Za-z0-9]{2,}", Pattern.UNICODE_CHARACTER_CLASS);
//		Matcher tenTaiKhoanMatcher = tenTaiKhoanPatern.matcher(txtTenTaiKhoan.getText());
		try {
			if (txtTenTaiKhoan.getText().trim().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập tên tài khoản !");
				txtTenTaiKhoan.selectAll();
				txtTenTaiKhoan.requestFocus();
				return false;
			} else if (!txtTenTaiKhoan.getText().trim().matches("[A-Za-z0-9]{2,}")) {
				JOptionPane.showMessageDialog(this, "Tên tài khoản có 2 ký tự trở lên, bao gồm số và chữ !");
				txtTenTaiKhoan.selectAll();
				txtTenTaiKhoan.requestFocus();
				return false;
			}
		} catch (Exception e) {
//			JOptionPane.showMessageDialog(this, "Tên tài khoản không hợp lệ !");
			txtTenTaiKhoan.selectAll();
			txtTenTaiKhoan.requestFocus();
			return false;
		}
//		usename = txtTenTaiKhoan.getText();
		NhanVienGUI.txtTaiKhoan.setText(txtTenTaiKhoan.getText());
		try {
			String myPass = String.valueOf(txtMatKhau.getPassword());
			if (txtMatKhau.getPassword().toString().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập mật khẩu !");
				txtMatKhau.selectAll();
				txtMatKhau.requestFocus();
				return false;
			} else if (myPass.length() < 8) {
				JOptionPane.showMessageDialog(this, "Mật khẩu gồm 8 ký tự trở lên !");
				txtMatKhau.selectAll();
				txtMatKhau.requestFocus();
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Mật khẩu không hợp lệ !");
			System.out.println("sai sai sai !");
//			txtMatKhau.selectAll();
//			txtMatKhau.requestFocus();
//			return false;
		}
		return true;
	}

	public boolean kiemTraUserNameTonTai() {
		try {
			List<String> listTenTaiKhoan = new ArrayList<String>();
			nvDao.getAllTenTaiKhoan().forEach(x -> {
				listTenTaiKhoan.add(x);
			});

			for (String tenTk : listTenTaiKhoan) {
				if (tenTk.equals(txtTenTaiKhoan.getText().trim())) {
					JOptionPane.showMessageDialog(this, "Tên tài khoản đã tồn tại !");
					txtTenTaiKhoan.selectAll();
					txtTenTaiKhoan.requestFocus();
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
