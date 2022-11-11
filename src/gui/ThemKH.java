package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.lapHoaDonDAO;
import entity.DiaChi;
import entity.KhachHang;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ThemKH extends JFrame {

	
	private JTextField txtNgaySinh;
	public JTextField txtSDT;
	private JTextField txtTenKH;
	private JTextField txtEmail;
	private JTextField txtSoNha;
	private JTextField txtTenDuong;
	private JTextField txtPhuong;
	private JTextField txtQuan;
	private JTextField txtTP;
	private JTextField txtQuocGia;
	private JComboBox cboPhai;
	Container contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemKH frame = new ThemKH();
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
	public ThemKH() {
		setType(Type.POPUP);
		setTitle("Thêm khách hàng");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 469, 618);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		((JComponent) contentPane).setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_top = new JPanel();
		panel_top.setLayout(null);
		panel_top.setBackground(new Color(224, 255, 255));
		panel_top.setBounds(10, 63, 438, 471);
		contentPane.add(panel_top);
		
		JLabel lblNgaySinh = new JLabel("Năm Sinh");
		lblNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNgaySinh.setBounds(10, 56, 85, 22);
		panel_top.add(lblNgaySinh);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String nam = txtNgaySinh.getText().toString();
				
				if(!nam.matches("[0-9]{1,4}")) {
					JOptionPane.showConfirmDialog(null, "Năm sinh phải là số", "Thông báo", JOptionPane.YES_NO_OPTION);
					txtNgaySinh.requestFocus();
					txtNgaySinh.selectAll();
					if(Integer.parseInt(nam)>=1960 && Integer.parseInt(nam)<=2010) {
						JOptionPane.showConfirmDialog(null,"Năm sinh phải > 1960 và <2010",  "Thông báo", JOptionPane.YES_NO_OPTION);
						txtNgaySinh.requestFocus();
						txtNgaySinh.selectAll();
					}
				}
				
			}
		});
		txtNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(148, 56, 240, 23);
		panel_top.add(txtNgaySinh);
		
		txtSDT = new JTextField();
		txtSDT.setEditable(false);
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSDT.setColumns(10);
		txtSDT.setBounds(148, 92, 240, 23);
		panel_top.add(txtSDT);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSinThoi.setBounds(10, 93, 128, 20);
		panel_top.add(lblSinThoi);
		
		JLabel lblPhai = new JLabel("Phái");
		lblPhai.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhai.setBounds(10, 138, 74, 22);
		panel_top.add(lblPhai);
		
		txtTenKH = new JTextField();
		txtTenKH.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String tenKh = txtTenKH.getText().toString();
				if(tenKh.matches("\\d")) {
					JOptionPane.showConfirmDialog(txtTenKH, "Tên khách hàng không được rỗng và phải là chữ","Thông báo",JOptionPane.OK_OPTION);
							txtTenKH.requestFocus();
							txtTenKH.selectAll();
				}
				else if(tenKh.matches("[a-zA-Z ]+ \\d")) {
					JOptionPane.showConfirmDialog(txtTenKH, "Tên khách hàng không được rỗng và phải là chữ","Thông báo",JOptionPane.OK_OPTION);
					txtTenKH.requestFocus();
					txtTenKH.selectAll();
		}
			}
		});
		txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(148, 22, 240, 23);
		panel_top.add(txtTenKH);
		
		JLabel lblTnKhchHng = new JLabel("Tên khách hàng ");
		lblTnKhchHng.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTnKhchHng.setBounds(10, 23, 147, 22);
		panel_top.add(lblTnKhchHng);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(10, 171, 47, 22);
		panel_top.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(148, 171, 240, 23);
		panel_top.add(txtEmail);
		
		 cboPhai = new JComboBox();
		cboPhai.setFont(new Font("Times New Roman", Font.BOLD, 18));
		cboPhai.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cboPhai.setBounds(148, 138, 113, 23);
		panel_top.add(cboPhai);
		
		JLabel lblDiaCHi = new JLabel("Địa chỉ");
		lblDiaCHi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDiaCHi.setBounds(10, 204, 85, 22);
		panel_top.add(lblDiaCHi);
		
		JLabel lblSoNha = new JLabel("Số nhà");
		lblSoNha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSoNha.setBounds(45, 237, 79, 22);
		panel_top.add(lblSoNha);
		
		txtSoNha = new JTextField();
		txtSoNha.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSoNha.setBounds(183, 237, 205, 24);
		panel_top.add(txtSoNha);
		txtSoNha.setColumns(10);
		
		JLabel lblTenDuong = new JLabel("Tên đường");
		lblTenDuong.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTenDuong.setBounds(45, 272, 85, 22);
		panel_top.add(lblTenDuong);
		
		txtTenDuong = new JTextField();
		txtTenDuong.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtTenDuong.setBounds(183, 272, 205, 22);
		panel_top.add(txtTenDuong);
		txtTenDuong.setColumns(10);
		
		JLabel lblPhuong = new JLabel("Phường( Xã)");
		lblPhuong.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhuong.setBounds(45, 305, 99, 23);
		panel_top.add(lblPhuong);
		
		txtPhuong = new JTextField();
		txtPhuong.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPhuong.setBounds(183, 305, 205, 23);
		panel_top.add(txtPhuong);
		txtPhuong.setColumns(10);
		
		JLabel lblQuan = new JLabel("Quận(Huyện)");
		lblQuan.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuan.setBounds(45, 339, 112, 23);
		panel_top.add(lblQuan);
		
		txtQuan = new JTextField();
		txtQuan.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtQuan.setBounds(183, 339, 205, 24);
		panel_top.add(txtQuan);
		txtQuan.setColumns(10);
		
		JLabel lblThanhPho = new JLabel("Thành phố( Tỉnh)");
		lblThanhPho.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThanhPho.setBounds(45, 373, 140, 24);
		panel_top.add(lblThanhPho);
		
		txtTP = new JTextField();
		txtTP.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtTP.setBounds(183, 374, 205, 24);
		panel_top.add(txtTP);
		txtTP.setColumns(10);
		
		JLabel lblQuocGia = new JLabel("Quốc gia");
		lblQuocGia.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuocGia.setBounds(45, 409, 121, 22);
		panel_top.add(lblQuocGia);
		
		txtQuocGia = new JTextField();
		txtQuocGia.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtQuocGia.setBounds(183, 409, 205, 22);
		panel_top.add(txtQuocGia);
		txtQuocGia.setColumns(10);
		
		JButton bntThem = new JButton("Thêm");
		bntThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				them();
				
			}

			
		});
		bntThem.setFont(new Font("Tahoma", Font.BOLD, 18));
		bntThem.setBounds(153, 545, 114, 34);
		contentPane.add(bntThem);
		
		JLabel lblTitle = new JLabel("THÊM KHÁCH HÀNG");
		lblTitle.setBounds(79, 25, 289, 41);
		contentPane.add(lblTitle);
		lblTitle.setForeground(Color.RED);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
	}

	private lapHoaDonDAO lhd_dao = new lapHoaDonDAO();
	private void them() {
	
		if(kiemTra()) {
			String soNha =txtSoNha.getText();
			String tenDuong = txtTenDuong.getText();
			String phuong =txtPhuong.getText();
			String quan =txtQuan.getText();
			String thanhPho =txtTP.getText();
			String quocGia =txtQuocGia.getText();
			String dc = soNha + ", " + tenDuong + ", " + phuong + ", " + quan + ", " + thanhPho + ", " + quocGia;
			lhd_dao.themDiaChi(soNha, tenDuong, phuong, quan, thanhPho, quocGia);
			int maDC= lhd_dao.getMaDiaChi(soNha, tenDuong, phuong, quan, thanhPho, quocGia);
			
			String tenKh = txtTenKH.getText().toString();
			String namSinh = txtNgaySinh.getText().toString();
			String sdt= txtSDT.getText().toString();
			String email = txtEmail.getText().toString();
			String phai = cboPhai.getSelectedItem().toString();
			lhd_dao.themKH( tenKh, sdt, maDC, phai, email,namSinh);
			int maKH = lhd_dao.getMaKH(tenKh, sdt, maDC, phai, email,namSinh);
			setVisible(false);
			ManHinhChinhGUI.tabbedPane.remove(contentPane);
			LapHoaDonGUI.lblTKH.setText(tenKh);
			LapHoaDonGUI.txtSDT.setText(sdt);
			LapHoaDonGUI.lblDC.setText(dc);
			LapHoaDonGUI.lblMKH.setText(String.valueOf(maKH));
			ManHinhChinhGUI.tabbedPane.add(LapHoaDonGUI.contentPane);
			
			
		
		} else {
			return;
		}
	}

	private boolean kiemTra() {
		String soNha =txtSoNha.getText();
		String tenDuong = txtTenDuong.getText();
		String phuong =txtPhuong.getText();
		String quan =txtQuan.getText();
		String thanhPho =txtTP.getText();
		String quocGia =txtQuocGia.getText();
		
		String tenKh = txtTenKH.getText().toString().trim();
		String namSinh = txtNgaySinh.getText().toString().trim();
		String sdt= txtSDT.getText().toString().trim();
		String email = txtEmail.getText().toString().trim();
		if(((soNha.equals(""))&& (tenKh.equals(""))&& (soNha.equals("")))) {
			JOptionPane.showConfirmDialog(null, "Yêu cầu nhập thông tin khách hàng","Thông báo", JOptionPane.OK_CANCEL_OPTION);
			txtTenKH.requestFocus();
			return false;
		}
		else {
			if(!(sdt.length()>0)) {
				JOptionPane.showConfirmDialog(null, "Số điện thoại không được rỗng","Thông báo", JOptionPane.OK_CANCEL_OPTION);
				txtSDT.requestFocus();
				return false;
			}
			else if(!(sdt.matches("[0]+[0-9]+{9}"))) {
				JOptionPane.showConfirmDialog(null, "Số điện thoại phải là số và bắt đầu là 0 theo sau là 9 số. ","Thông báo", JOptionPane.OK_CANCEL_OPTION);
				txtSDT.requestFocus();
				txtSDT.selectAll();
				return false;
			}
			else if(!(soNha.length()>0)) {
				JOptionPane.showConfirmDialog(null, "Số nhà không được rỗng","Thông báo", JOptionPane.OK_CANCEL_OPTION);
				txtSoNha.requestFocus();
				return false;
			}
			else if(!(soNha.matches("[0-9]+"))) {
				JOptionPane.showConfirmDialog(null, "Số nhà phải là số. ","Thông báo", JOptionPane.OK_CANCEL_OPTION);
				txtSDT.requestFocus();
				txtSoNha.selectAll();
				return false;
			}
			else if(!(tenDuong.length()>0 )) {
				JOptionPane.showConfirmDialog(null, "Tên đường không được rỗng ","Thông báo", JOptionPane.OK_CANCEL_OPTION);
				txtTenDuong.requestFocus();
				txtTenDuong.selectAll();
				return false;
			}
			
			else if(!(phuong.length()>0)) {
				JOptionPane.showConfirmDialog(null, "Phường( xã) không được rỗng","Thông báo", JOptionPane.OK_CANCEL_OPTION);
				txtPhuong.requestFocus();
				return false;
			}
			else if(!(quan.length()>0)) {
				JOptionPane.showConfirmDialog(null, "Quận( huyện)  không được rỗng","Thông báo", JOptionPane.OK_CANCEL_OPTION);
				txtQuan.requestFocus();
				return false;
			}
			else if(!(quocGia .length()>0)) {
				JOptionPane.showConfirmDialog(null, "Quốc gia không được rỗng","Thông báo", JOptionPane.OK_CANCEL_OPTION);
				txtQuocGia.requestFocus();
				return false;
			}
		}
		return true;
		
	}
}
