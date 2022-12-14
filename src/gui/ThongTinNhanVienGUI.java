package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import dao.ThongTinCaNhanDAO;
import entity.NhanVien;
import entity.TaiKhoan;

import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ThongTinNhanVienGUI extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  JTextField txtMaNhanVien;
	private JTextField txtDiaChi;
	private JTextField txtCMND;
	private JTextField txtKQTK;
	private JTable table_1;
	private JTabbedPane tabbedPane ;
	public static JPanel pnlTabXemThongTinCaNhan ;
	private JTextField txtNgaySinh;
	private JTextField txtTenDangNhap;
	private JPasswordField txtMatKhau;
	private JPasswordField txtMatKhauMoi;
	private JButton btnCapNhat;
	private JComboBox cboGioiTinh;
	private JTextField txtHo;
	private JButton btnThoat;
	public ThongTinNhanVienGUI() {
		setSize(1349,685);
		setLocationRelativeTo(null);
		pnlTabXemThongTinCaNhan = new JPanel();
		pnlTabXemThongTinCaNhan.setBackground(new Color(224, 255, 255));
		getContentPane().add(pnlTabXemThongTinCaNhan);
		

		pnlTabXemThongTinCaNhan.setLayout(null);

		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setLayout(null);
		pnlChucNang.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"C\u00E1c ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlChucNang.setBackground(new Color(224, 255, 255));
		pnlChucNang.setBounds(10, 440, 1313, 195);
		pnlTabXemThongTinCaNhan.add(pnlChucNang);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		panel.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 34, 1293, 150);
		pnlChucNang.add(panel);
		panel.setLayout(null);

		/**
		 * Thoat tab quan ly nhan vien
		 */
		btnThoat = new JButton("Tho??t");
		
		btnThoat.setBackground(new Color(255, 0, 51));
		btnThoat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnThoat.setBounds(1137, 85, 146, 40);
		btnThoat.setIcon(new ImageIcon("images\\exit.png"));
		panel.add(btnThoat);

		btnCapNhat = new JButton("C???p nh???t");
		btnCapNhat.setBackground(Color.GREEN);
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCapNhat.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCapNhat.setBounds(569, 23, 159, 40);
		btnCapNhat.setIcon(new ImageIcon("E:\\JPA_WorkSpace\\LTPTJAVA_DHKTPM13B_BAITAPLON_NHOM17\\Hinh\\iconSave.png"));
		panel.add(btnCapNhat);

		JPanel pnlThongTinNhanVien = new JPanel();
		pnlThongTinNhanVien.setLayout(null);
		pnlThongTinNhanVien.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Th\u00F4ng tin nh\u00E2n vi\u00EAn", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlThongTinNhanVien.setBackground(new Color(224, 255, 255));
		pnlThongTinNhanVien.setBounds(10, 111, 1313, 318);
		pnlTabXemThongTinCaNhan.add(pnlThongTinNhanVien);

		JPanel pnlThongTinCoBan = new JPanel();
		pnlThongTinCoBan.setLayout(null);
		pnlThongTinCoBan.setForeground(Color.BLACK);
		pnlThongTinCoBan.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Th\u00F4ng tin c\u01A1 b\u1EA3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlThongTinCoBan.setBackground(new Color(224, 255, 255));
		pnlThongTinCoBan.setBounds(10, 27, 1293, 309);
		pnlThongTinNhanVien.add(pnlThongTinCoBan);

		JLabel lblMaNhanVien = new JLabel("M?? nh??n vi??n:");
		lblMaNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMaNhanVien.setBounds(62, 25, 143, 20);
		pnlThongTinCoBan.add(lblMaNhanVien);

		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		txtMaNhanVien.setEditable(false);
		txtMaNhanVien.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMaNhanVien.setToolTipText("");
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(251, 25, 290, 20);
		pnlThongTinCoBan.add(txtMaNhanVien);

		JLabel lblDiaChi = new JLabel("?????a ch??? :");
		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDiaChi.setBounds(596, 119, 149, 20);
		pnlThongTinCoBan.add(lblDiaChi);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		txtDiaChi.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDiaChi.setToolTipText("Nh???p t??n");
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(685, 119, 579, 20);
		pnlThongTinCoBan.add(txtDiaChi);

		JLabel lblGioiTinh = new JLabel("Gi???i t??nh:");
		lblGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGioiTinh.setBounds(596, 75, 150, 17);
		pnlThongTinCoBan.add(lblGioiTinh);

		cboGioiTinh = new JComboBox();
		cboGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		cboGioiTinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "N???", "Kh??c"}));
		cboGioiTinh.setToolTipText("Ch???n gi???i t??nh");
		cboGioiTinh.setBounds(685, 72, 149, 23);
		pnlThongTinCoBan.add(cboGioiTinh);

		JLabel lblCMND = new JLabel("CMND:");
		lblCMND.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCMND.setBounds(596, 167, 149, 23);
		pnlThongTinCoBan.add(lblCMND);

		txtCMND = new JTextField();
		txtCMND.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!((e.getKeyChar() >= 48 && e.getKeyChar() <= 57) || e.getKeyChar() == 8)) {
					e.consume();
				}
			}
		});
		txtCMND.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		txtCMND.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCMND.setToolTipText("Nh???p ch???ng minh nh??n d??n");
		txtCMND.setColumns(10);
		txtCMND.setBounds(685, 168, 231, 20);
		pnlThongTinCoBan.add(txtCMND);
		
		JLabel lblNgaySinh = new JLabel("Ng??y Sinh :");
		lblNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNgaySinh.setBounds(62, 70, 143, 19);
		pnlThongTinCoBan.add(lblNgaySinh);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		txtNgaySinh.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNgaySinh.setToolTipText("");
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(251, 68, 290, 20);
		pnlThongTinCoBan.add(txtNgaySinh);
		
		JLabel lblTenDangNhap = new JLabel("T??n ????ng nh???p:");
		lblTenDangNhap.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTenDangNhap.setBounds(62, 119, 143, 23);
		pnlThongTinCoBan.add(lblTenDangNhap);
		
		txtTenDangNhap = new JTextField();
		txtTenDangNhap.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		txtTenDangNhap.setEditable(false);
		txtTenDangNhap.setToolTipText("");
		txtTenDangNhap.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTenDangNhap.setColumns(10);
		txtTenDangNhap.setBounds(251, 118, 290, 20);
		pnlThongTinCoBan.add(txtTenDangNhap);
		
		JLabel lblMatKhau = new JLabel("M???t kh???u:");
		lblMatKhau.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMatKhau.setBounds(62, 172, 143, 26);
		pnlThongTinCoBan.add(lblMatKhau);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		txtMatKhau.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMatKhau.setBounds(251, 167, 290, 20);
		pnlThongTinCoBan.add(txtMatKhau);
		
		JLabel lblMatKhauMoi = new JLabel("M???t kh???u m???i:");
		lblMatKhauMoi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMatKhauMoi.setBounds(62, 222, 143, 19);
		pnlThongTinCoBan.add(lblMatKhauMoi);
		
		txtMatKhauMoi = new JPasswordField();
		txtMatKhauMoi.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		txtMatKhauMoi.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMatKhauMoi.setBounds(251, 221, 290, 20);
		pnlThongTinCoBan.add(txtMatKhauMoi);
		
		JRadioButton radHienMatKhau = new JRadioButton("Hi???n m???t kh???u");
		radHienMatKhau.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		radHienMatKhau.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(radHienMatKhau.isSelected()) {
					txtMatKhau.setEchoChar((char)0);
					txtMatKhauMoi.setEchoChar((char)0);
				}
				else if(radHienMatKhau.isSelected()==false) {
					txtMatKhau.setEchoChar('*');
					txtMatKhauMoi.setEchoChar('*');
				}
				
			}
		});
		radHienMatKhau.setBounds(251, 259, 162, 23);
		pnlThongTinCoBan.add(radHienMatKhau);

		JPanel pnlTitle = new JPanel();
		pnlTitle.setBackground(new Color(224, 255, 255));
		pnlTitle.setBounds(10, 51, 1313, 60);
		pnlTabXemThongTinCaNhan.add(pnlTitle);
		pnlTitle.setLayout(null);

		JLabel lblTitle = new JLabel("TH??NG TIN C?? NH??N");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblTitle.setForeground(Color.RED);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(149, 11, 985, 38);
		pnlTitle.add(lblTitle);
		
		JLabel lblH = new JLabel("H??? t??n:");
		lblH.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblH.setBounds(595, 24, 97, 23);
		pnlThongTinCoBan.add(lblH);
		
		txtHo = new JTextField();
		txtHo.setToolTipText("Nh???p h???");
		txtHo.setHorizontalAlignment(SwingConstants.RIGHT);
		txtHo.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		txtHo.setColumns(10);
		txtHo.setBounds(685, 25, 579, 20);
		pnlThongTinCoBan.add(txtHo);
		
		
		
		btnCapNhat.addActionListener(this);
		btnThoat.addActionListener(this);
		loadThongTinCaNhan();
	}
//	public static void main(String[] args) {
//		FrmXemThongTinCaNhan frmQuanLyNhanVien = new FrmXemThongTinCaNhan();
//		frmQuanLyNhanVien.setVisible(true);
//	}
	public void loadThongTinCaNhan() {
		ThongTinCaNhanDAO thongTinCaNhanDAO = new ThongTinCaNhanDAO();
		//FrmDangNhap frmDangNhap = new FrmDangNhap();
			try {
				NhanVien nhanVien = thongTinCaNhanDAO.loadNhanVien(DangNhapGUI.taiKhoan.getTaiKhoan());
				System.out.println(nhanVien);
				txtMaNhanVien.setText(nhanVien.getMaNV()+"");
				String ngaySinh = String.valueOf(nhanVien.getNamSinh());
				txtNgaySinh.setText(ngaySinh);
				txtTenDangNhap.setText(nhanVien.getTaiKhoan().getTaiKhoan());
				txtMatKhau.setText(nhanVien.getTaiKhoan().getMatKhau());
				txtHo.setText(nhanVien.getTenNV());
				
				cboGioiTinh.setSelectedItem(nhanVien.getPhai());
				String diaChi = nhanVien.getDiaChi().getSoNha() + "," + nhanVien.getDiaChi().getTenDuong() + ","+nhanVien.getDiaChi().getPhuongXa()+","+nhanVien.getDiaChi().getQuanHuyen()+","+nhanVien.getDiaChi().getTinhTP()+","+nhanVien.getDiaChi().getNuoc();
				
				txtDiaChi.setText(diaChi);
				txtCMND.setText(nhanVien.getCMND());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj.equals(btnCapNhat)) {
			NhanVien nhanVien = new NhanVien();
			nhanVien.setMaNV(Integer.parseInt(txtMaNhanVien.getText()));
			
			
			
			TaiKhoan taiKhoan = new TaiKhoan();
			taiKhoan.setTaiKhoan(txtTenDangNhap.getText());
			taiKhoan.setMatKhau(txtMatKhauMoi.getText());
			
			nhanVien.setTaiKhoan(taiKhoan);
			
			String ngaySinh = String.valueOf(nhanVien.getNamSinh());
			txtNgaySinh.setText(ngaySinh);
			txtTenDangNhap.setText(nhanVien.getTaiKhoan().getTaiKhoan());
			txtMatKhau.setText(nhanVien.getTaiKhoan().getMatKhau());
			txtHo.setText(nhanVien.getTenNV());
			
			cboGioiTinh.setSelectedItem(nhanVien.getPhai());
			String diaChi = nhanVien.getDiaChi().getSoNha() + "," + nhanVien.getDiaChi().getTenDuong() + ","+nhanVien.getDiaChi().getPhuongXa()+","+nhanVien.getDiaChi().getQuanHuyen()+","+nhanVien.getDiaChi().getTinhTP()+","+nhanVien.getDiaChi().getNuoc();
			
			txtDiaChi.setText(diaChi);
			txtCMND.setText(nhanVien.getCMND());
			ThongTinCaNhanDAO thongTinCaNhanDAO = new ThongTinCaNhanDAO();
			Object check = JOptionPane.showConfirmDialog(this, "Ch???c ch???c s???a th??ng tin?");
			if(check.equals(0)) {
				if(txtTenDangNhap.getText().equalsIgnoreCase("ADMIN")==false) {
					thongTinCaNhanDAO.updateThongTinCaNhan(nhanVien);
					thongTinCaNhanDAO.updateTaiKhoan(nhanVien);
					JOptionPane.showMessageDialog(this, "C???p nh???t th??ng tin th??nh c??ng!");
				}
				else {
					JOptionPane.showMessageDialog(this,"Kh??ng ???????c s???a th??ng tin c???a ADMIN");
				}
			}
		}
		else if(obj.equals(btnThoat)) {
			ManHinhChinhGUI.tabbedPane.remove(pnlTabXemThongTinCaNhan);
		}
	}
}
