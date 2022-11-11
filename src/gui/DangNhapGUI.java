package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import connectDB.ConnectDB;
import entity.TaiKhoan;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
public class DangNhapGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTK;
	private String tenTaiKhoanAdmin="ADMIN" ;
	public static TaiKhoan taiKhoan = new TaiKhoan() ;
	private JLabel lblMessLoiUser;
	private String usernameToGetNhanVien;
	private JTextField txtMK;
	private boolean TrangThaiDangNhapNhanVien=false;
	private boolean TrangThaiDangNhapQuanLy=false;
	private String matKhauAdmin="ADMIN";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhapGUI frame = new DangNhapGUI();
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
	public DangNhapGUI() {
		ConnectDB.getInstance().connect();
		setTitle("Đăng nhập");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 625, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(10, 11, 593, 339);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Simplet");
		lblNewLabel.setForeground(new Color(224, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(92, 116, 81, 21);
		panel.add(lblNewLabel);

		JLabel lbltitle = new JLabel("Cửa hàng linh kiện máy tính ");
		lbltitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitle.setForeground(new Color(224, 255, 255));
		lbltitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbltitle.setBounds(10, 78, 236, 44);
		panel.add(lbltitle);

		JLabel lblTK = new JLabel("Tài khoản");
		lblTK.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTK.setBounds(291, 110, 81, 32);
		panel.add(lblTK);

		JLabel lblMK = new JLabel("Mật khẩu");
		lblMK.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMK.setBounds(291, 163, 81, 32);
		panel.add(lblMK);

		txtTK = new JTextField();
		txtTK.setBounds(393, 116, 167, 24);
		panel.add(txtTK);
		txtTK.setColumns(10);

		JLabel lblDangNhap = new JLabel("ĐĂNG NHẬP");
		lblDangNhap.setForeground(Color.RED);
		lblDangNhap.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblDangNhap.setBounds(307, 11, 192, 44);
		panel.add(lblDangNhap);

		JButton btnLogin = new JButton("Đăng nhập");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logIn();
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.setBounds(393, 247, 127, 32);
		panel.add(btnLogin);

		txtMK = new JPasswordField();
		txtMK.setBounds(393, 169, 148, 24);
		panel.add(txtMK);

		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("Picture\\khoa.PNG"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (((JPasswordField) txtMK).getEchoChar()== (char )0) {
					((JPasswordField) txtMK).setEchoChar('*');
				}
				else {
					((JPasswordField) txtMK).setEchoChar((char)0);
				}
			}
		});
		btnNewButton.setBounds(551, 169, 27, 24);
		panel.add(btnNewButton);
		txtMK.setText("ADMIN");
		txtTK.setText("ADMIN");
		JLabel lblHinhAnh = new JLabel("");
		lblHinhAnh.setForeground(new Color(224, 255, 255));
		lblHinhAnh.setIcon(new ImageIcon("Picture\\dn.jpg"));
		lblHinhAnh.setBounds(10, 0, 236, 328);
		panel.add(lblHinhAnh);
	}

	public boolean KiemTraDuLieu() {
		String tenUser = txtTK.getText();
		// ten dang nhap phai la chu hoac so va khong co ki tu dac biet co toi da tu 5-20 ki tu
		boolean match = tenUser.matches("[a-zA-z0-9 ]{3,20}");
		if(match!=true) {
			lblMessLoiUser.setText("Lỗi: Tên đăng Nhập(Không Chứa Ký Tự �?ặt Biệt,Tối Thiểu 3-20 Ký Tự)");
			return false;
		}
		else
			return true;
	}
	public TaiKhoan loadTaiKhoan(String tenDangNhap,String matKhau) {
		TaiKhoan taiKhoan = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql  = "select  [tentaiKhoan],[matKhau],[loaiTK] from dbo.TaiKhoan where tentaiKhoan like '"+tenDangNhap+"' and matKhau like '"+matKhau+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				
				String tk = rs.getString(1);
				String mk= rs.getString(2);
				String loaiTK=rs.getString(3);
				taiKhoan= new TaiKhoan(tk, mk, loaiTK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return taiKhoan;
	}
	public boolean kiemTraDangNhapAdmin(String tenDangNhap,String matKhau) {
		if(tenDangNhap.equalsIgnoreCase(tenTaiKhoanAdmin) && matKhau.equalsIgnoreCase(matKhauAdmin)) {
			TrangThaiDangNhapNhanVien = true ;
			TrangThaiDangNhapQuanLy = true;
			return true;
		}
		return false;
	}
	public void logIn() {
		try {
			if(KiemTraDuLieu()) {
				String tenDN = txtTK.getText().trim();
				String matKhau = txtMK.getText().trim();
				taiKhoan = loadTaiKhoan(tenDN, matKhau);
				if(taiKhoan.getLoaiTK().equalsIgnoreCase("ADMIN")) {
					usernameToGetNhanVien=txtTK.getText();
					System.out.println("1 " +usernameToGetNhanVien);
					ManHinhChinhGUI frmManHinhChinh = new ManHinhChinhGUI();
					frmManHinhChinh.setVisible(true);
					this.setVisible(false);
				}
				else if(taiKhoan.getLoaiTK().equalsIgnoreCase("NV")) {
					usernameToGetNhanVien=txtTK.getText();
					System.out.println("2 " +usernameToGetNhanVien);
					ManHinhChinhGUI frmManHinhChinh = new ManHinhChinhGUI();
					frmManHinhChinh.mnLinhKien.setEnabled(false);
					frmManHinhChinh.mnNhanVien.setEnabled(false);
					frmManHinhChinh.mnThongKe.setEnabled(false);
					frmManHinhChinh.setVisible(true);
					this.setVisible(false);
				}
				else if(taiKhoan.getLoaiTK().equalsIgnoreCase("QL")) {
					usernameToGetNhanVien=txtTK.getText();
					System.out.println("3 " +usernameToGetNhanVien);
					ManHinhChinhGUI frmManHinhChinh = new ManHinhChinhGUI();
//					frmManHinhChinh.mnLapHoaDon.setEnabled(false);
					frmManHinhChinh.setVisible(true);

					this.setVisible(false);
				}

				else 
					JOptionPane.showMessageDialog(this,"Tên Đăng Nhập, Hoặc Mật Khẩu Sai.");
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(this,"Tên Đăng Nhập, Hoặc Mật Khẩu Sai.");
		}
	}


}
