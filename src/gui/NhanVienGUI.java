package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DiaChiDAO;
import dao.KhachHangDao;
import dao.NhanVienDAO;
import entity.DiaChi;
import entity.KhachHang;
import entity.NhaCungCap;
import entity.NhanVien;
import entity.TaiKhoan;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxEditor;

import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class NhanVienGUI extends JFrame implements ActionListener, MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	private JTextField txtMaNV;
	private JTextField txtNamSinh;

	public static JTextField txtCMND;
	public static JTextField txtChucVu;
	public static JTextField txtTenNV;
	private JTextField txtTimKiem;

	public static JTextField txtTaiKhoan;
	private static DefaultTableModel model;
	private static JTable table;
	private JTextField  txtMess;
	private static NhanVienDAO nv_dao;
	private static DiaChiDAO dc_dao;
	//private static KhachHangDao khDao;

	public static JTextField txtDC;
	public static JButton btnThemTK;
	public static JButton btnThemDC;
	private JRadioButton radTen;
	private JRadioButton radMa;

	public static JComboBox cbbPhai;
	private JButton btnThoat;
	private  JButton btnThemNV;
	private JButton btnXoaNV;
	private JButton btnXoaTrang;
	private JButton btnCapNhat;
	private JButton btnLamMoi;
	private JButton btnTimKiemNV;
	public static JTextField txtmaDC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVienGUI frame = new NhanVienGUI();
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
	public NhanVienGUI() {
		ConnectDB.getInstance().connect();
		//khDao = new KhachHangDao();

		nv_dao = new NhanVienDAO();
		dc_dao = new DiaChiDAO();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(10, 50, 1354, 744); // 2 chu dau là margin top , left
		//	setBounds(100, 100, 1354, 675);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1338, 705);
		panel.setBackground(new Color(224, 255, 255));
		contentPane.add(panel);

		JPanel panel_top = new JPanel();
		panel_top.setBackground(new Color(224, 255, 255));

		JPanel panel_bot = new JPanel();
		panel_bot.setBackground(new Color(224, 255, 255));

		JPanel panel_center = new JPanel();
		panel_center.setBackground(new Color(224, 255, 255));

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(19)
							.addComponent(panel_top, GroupLayout.PREFERRED_SIZE, 1306, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_center, GroupLayout.PREFERRED_SIZE, 1325, GroupLayout.PREFERRED_SIZE)))
					.addGap(18))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(19, Short.MAX_VALUE)
					.addComponent(panel_bot, GroupLayout.PREFERRED_SIZE, 1334, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(26)
					.addComponent(panel_top, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_center, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_bot, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);


		panel_bot.setLayout(null);

		JLabel lblTimKiem = new JLabel("Nhập vào ");
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTimKiem.setBounds(26, 14, 147, 16);
		panel_bot.add(lblTimKiem);

		radMa = new JRadioButton("Mã");
		radMa.setSelected(true);
		radMa.setFont(new Font("Tahoma", Font.BOLD, 14));
		radMa.setBounds(124, 47, 59, 21);
		panel_bot.add(radMa);


		radTen = new JRadioButton("Tên");
		radTen.setSelected(true);
		radTen.setFont(new Font("Tahoma", Font.BOLD, 14));
		radTen.setBounds(229, 47, 59, 21);
		panel_bot.add(radTen);

		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(183, 11, 175, 23);
		panel_bot.add(txtTimKiem);

		JLabel lblTimTheo = new JLabel("Tìm theo");
		lblTimTheo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTimTheo.setBounds(26, 49, 69, 16);
		panel_bot.add(lblTimTheo);

		btnTimKiemNV = new JButton("Tìm kiếm");
		btnTimKiemNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimKiemNV.setBounds(437, 47, 135, 21);
		panel_bot.add(btnTimKiemNV);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLamMoi.setBounds(599, 47, 135, 21);
		panel_bot.add(btnLamMoi);

		btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThoat.setBounds(1057, 38, 135, 38);
		panel_bot.add(btnThoat);
		panel_top.setLayout(null);

		JLabel lblMaNV = new JLabel("Mã NV");
		lblMaNV.setBounds(10, 58, 47, 22);
		panel_top.add(lblMaNV);
		lblMaNV.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblTTieuDe = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblTTieuDe.setForeground(new Color(255, 0, 0));
		lblTTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblTTieuDe.setBounds(493, 21, 351, 29);
		panel_top.add(lblTTieuDe);

		txtMaNV = new JTextField();
		txtMaNV.setEditable(false);
		txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaNV.setBounds(93, 58, 240, 23);
		panel_top.add(txtMaNV);
		txtMaNV.setColumns(10);

		JLabel lblNamSinh = new JLabel("Năm Sinh");
		lblNamSinh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNamSinh.setBounds(10, 100, 85, 22);
		panel_top.add(lblNamSinh);

		txtNamSinh = new JTextField();
		txtNamSinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNamSinh.setColumns(10);
		txtNamSinh.setBounds(93, 100, 240, 23);
		panel_top.add(txtNamSinh);

		txtCMND = new JTextField();
		txtCMND.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCMND.setColumns(10);
		txtCMND.setBounds(93, 138, 240, 23);
		panel_top.add(txtCMND);

		JLabel lblCMND = new JLabel("CMND");
		lblCMND.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCMND.setBounds(10, 141, 45, 16);
		panel_top.add(lblCMND);

		btnCapNhat = new JButton("Cập Nhật");
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCapNhat.setBounds(65, 172, 107, 21);
		panel_top.add(btnCapNhat);

		btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoaTrang.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoaTrang.setBounds(215, 172, 107, 21);
		panel_top.add(btnXoaTrang);

		txtChucVu = new JTextField();
		txtChucVu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtChucVu.setColumns(10);
		txtChucVu.setBounds(490, 124, 141, 23);
		panel_top.add(txtChucVu);

		JLabel lblChucVu = new JLabel("Chức Vụ");
		lblChucVu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChucVu.setBounds(406, 127, 74, 16);
		panel_top.add(lblChucVu);

		JLabel lblPhai = new JLabel("Phái");
		lblPhai.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhai.setBounds(406, 91, 85, 22);
		panel_top.add(lblPhai);

		txtTenNV = new JTextField();
		txtTenNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(489, 58, 240, 23);
		panel_top.add(txtTenNV);

		JLabel lblTenNV = new JLabel("Tên NV");
		lblTenNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTenNV.setBounds(405, 58, 74, 22);
		panel_top.add(lblTenNV);

		JLabel lblaMaDC = new JLabel("Mã Địa Chỉ");
		lblaMaDC.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblaMaDC.setBounds(808, 103, 87, 16);
		panel_top.add(lblaMaDC);

		btnThemNV = new JButton("Thêm NV");
		btnThemNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThemNV.setBounds(406, 172, 99, 21);
		panel_top.add(btnThemNV);

		JLabel lblTaiKhoan = new JLabel("Tài Khoản");
		lblTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTaiKhoan.setBounds(808, 58, 74, 22);
		panel_top.add(lblTaiKhoan);

		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setEditable(false);
		txtTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTaiKhoan.setColumns(10);
		txtTaiKhoan.setBounds(930, 58, 153, 23);
		panel_top.add(txtTaiKhoan);

		btnXoaNV = new JButton("Xóa NV");
		btnXoaNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoaNV.setBounds(593, 172, 91, 21);
		panel_top.add(btnXoaNV);
		panel.setLayout(gl_panel);
		panel_center.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 21, 1264, 279);
		panel_center.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		String[] tb = new String[] { "STT", "Mã NV", "Họ Tên","Mã địa chỉ", "Năm sinh", "Giới tính", "CMND", "Chức vụ","Tên tài khoản"};


		model = new DefaultTableModel(tb, 0);
		table = new JTable(model);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		table.setPreferredSize(new Dimension(1250, 270));
		//	table1.setEditingRow(false);

		//table.setRowMargin(30);
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		panel_center.setLayout(null);
		panel_center.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Danh sách nhân viên", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_center.add(scrollPane);
		panel.add(panel_center);
		txtMess = new JTextField();
		txtMess.setBackground(new Color(224, 255, 255));
		txtMess.setBounds(340, 204, 384, 20);
		txtMess.setEditable(false);
		txtMess.setBorder(null);
		txtMess.setForeground(Color.red);
		panel_top.add(txtMess);

		txtDC = new JTextField();
		
		txtDC.setEditable(false);
		txtDC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDC.setColumns(10);
		txtDC.setBounds(727, 138, 569, 23);
		panel_top.add(txtDC);

		JLabel lblDC = new JLabel("Địa Chỉ");
		lblDC.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDC.setBounds(729, 141, 62, 16);
		panel_top.add(lblDC);
		cbbPhai = new JComboBox<String>();
		cbbPhai.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbbPhai.setBounds(490, 90, 141, 23);
		panel_top.add(cbbPhai);
		cbbPhai.addItem("Nam");
		cbbPhai.addItem("Nữ");



		JButton btnThemDC = new JButton("Thêm ĐC");
		btnThemDC.setForeground(new Color(0, 0, 0));
		btnThemDC.setBackground(new Color(64, 224, 208));
		btnThemDC.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThemDC.setBounds(1093, 98, 103, 27);
		panel_top.add(btnThemDC);

		txtmaDC = new JTextField();
		txtmaDC.setEditable(false);
		txtmaDC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtmaDC.setColumns(10);
		txtmaDC.setBounds(930, 100, 153, 23);
		panel_top.add(txtmaDC);

		btnThemTK = new JButton("Thêm TK");
		btnThemTK.setForeground(Color.BLACK);
		btnThemTK.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThemTK.setBackground(new Color(64, 224, 208));
		btnThemTK.setBounds(1091, 56, 103, 27);
		panel_top.add(btnThemTK);



		btnThemTK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUITaiKhoan tk = new GUITaiKhoan();
				tk.setVisible(true);
				tk.setLocationRelativeTo(null);
			}
		});

		btnThemDC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuiDiaChi dc = new GuiDiaChi();
				dc.setVisible(true);
				dc.setLocationRelativeTo(null);
			}
		});
		ButtonGroup group = new ButtonGroup();
		group.add(radMa);
		group.add(radTen);
		
		table.addMouseListener(this);
		btnLamMoi.addActionListener(this);
		btnThemDC.addActionListener(this);
		btnThemNV.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnXoaNV.addActionListener(this);
		btnThoat.addActionListener(this);
		btnCapNhat.addActionListener(this);
		btnTimKiemNV.addActionListener(this);
		// docDuLieu();
		DocDuLieuVaoModel();


	}
	//nv.getDiaChi().getNuoc(),nv.getDiaChi().getPhuongXa(),nv.getDiaChi().getQuanHuyen(),nv.getDiaChi().getSoNha(),nv.getDiaChi().getTenDuong()
	//	public static void docDuLieu() {
	//		try {
	//			List<KhachHang> list = khDao.getAllKH();
	//			int i = 0;
	//			for (KhachHang khachHang : list) {
	//				i++;
	//				model.addRow(new Object[] { i + "", khachHang.getMaKH()+ "",
	//						khachHang.getTenKH().trim()+"",khachHang.getSdt() + "",khachHang.getDiaChi().getMaDC() + "", khachHang.getPhai()+"",khachHang.getEmail() + "",khachHang.getNamSinh() + ""});
	//				
	//			}
	//			table.setModel(model);
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//
	//		}
	//	}
	public static void DocDuLieuVaoModel() {
		try {
			List<NhanVien> list = nv_dao.getAllNV();
			int i = 0;
			for (NhanVien nhanVien : list) {
				i++;
				model.addRow(new Object[] { i + "", nhanVien.getMaNV() + "",
						nhanVien.getTenNV().trim(),nhanVien.getDiaChi().getMaDC() + "",nhanVien.getNamSinh() + "", nhanVien.getPhai(),
						nhanVien.getCMND(), nhanVien.getChucVu(), nhanVien.getTenTK().getTaiKhoan()});
			}


			table.setModel(model);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	public static void xoaAllDataTable() {
		model = (DefaultTableModel) table.getModel();
		model.getDataVector().removeAllElements();

	}
	private void deleteAllDataTable() {

		model.addRow(new Object[] {

		});
		DefaultTableModel tblModel2 = (DefaultTableModel) table.getModel();
		tblModel2.getDataVector().removeAllElements();		
	}
	//private Xe revertSachFromTextfields() {
	//	String ma = txtmaXe.getText().toString().trim();
	//	String ten = txttenXe.getText().toString().trim();
	//	String loai = txtloaiXe.getText().toString().trim();
	//	String nuoc = txtnuocSX.getText().toString().trim();
	//	String khung = txtsoKhung.getText().toString().trim();
	//	String suon = txtsoSuon.getText().toString().trim();
	//	int slton = Integer.parseInt(txtslTon.getText().trim());
	//	double gia = Double.parseDouble(txtgiaGoc.getText().trim());
	//	String ncc = cbomaNCC.getSelectedItem().toString().trim();
	//	return new Xe(ma, ten, loai, nuoc, khung, suon, slton, gia, new NhaCungCap(ncc));	
	//
	//}
	private NhanVien revertSachFromTextfields() {

		int maNV = Integer.parseInt(txtMaNV.getText().trim());
		String tenNV = txtTenNV.getText().trim();
		int maDC = Integer.parseInt(txtmaDC.getText().trim());
		String nam = txtNamSinh.getText().trim();
		int Nsinh = nam.length() == 0 ? 0 : Integer.parseInt(nam);
		String phai = 
				(String)	cbbPhai.getSelectedItem();
		String CMND = txtCMND.getText().trim();
		String chucVu = txtChucVu.getText().trim();
		String taiKhoan = txtTaiKhoan.getText().trim();
		return new NhanVien(maNV, tenNV, new DiaChi(maDC), Nsinh, phai, CMND, chucVu, new TaiKhoan(taiKhoan));
	}
	private boolean validData() {
		String DC = txtmaDC.getText().trim();
		String Tk = txtTaiKhoan.getText().trim();

		String cMND = txtCMND.getText().trim();
		String ht = txtTenNV.getText().trim();
		String Nsinh = txtNamSinh.getText().trim();
		String ChucVu = txtChucVu.getText().trim();
		if(!(ht.length()>8 )) {
			showMessage("Họ tên phải lớn hơn 8 kí tự",txtTenNV);
			return false;
		}

		if((Tk.length()<=0  )) {
			showMessage("Vui lòng thêm thông tin tài khoản",txtTaiKhoan);
			return false;
		}
		if((DC.length()<=0 )) {
			showMessage("Vui lòng thêm thông tin địa chỉ",txtDC);
			return false;
		}
		//	if(!(diachi.length()>10)) {
		//		showMessage(" Ä�á»‹a chá»‰ lá»›n hÆ¡n 10 kÃ­ tá»±",txtDC);
		//		return false;
		//	}
		if(Nsinh.length()>0 ) {
			try {
				int x= Integer.parseInt(Nsinh);

				if((x<=1960 || x>= 2002)) {
					showMessage("Năm sinh >=1960 && <= 2002",txtNamSinh);
					return false;
				}

			} catch (Exception e) {
				showMessage("Năm sinh bao gồm 4 chữ số ", txtNamSinh);
				return false;
			}

		}
		try {
			if (cMND.equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập chứng minh nhân dân !", "Thông báo !",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
				txtCMND.requestFocus();
				txtCMND.selectAll();
				return false;
			} else if (cMND.matches("^[0-9]{9}$") == false) {
				JOptionPane.showMessageDialog(this, "Chứng minh nhân dân gồm 9 chữ số !", "Thông báo !",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
				txtCMND.requestFocus();
				txtCMND.selectAll();
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Chứng minh nhân dân không hợp lệ !", "Thông báo !",
					JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
			txtCMND.requestFocus();
			txtCMND.selectAll();
			return false;
		}

		//showMessage("Correct",txtMess);


		return true;
	}

	private void showMessage(String message, JTextField txt) {
		txt.requestFocus();
		txtMess.setText(message);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMaNV.setText(table.getValueAt(row, 1).toString() + "");
		txtTenNV.setText(table.getValueAt(row, 2).toString());
		txtmaDC.setText(table.getValueAt(row, 3).toString() + "");
		txtNamSinh.setText(table.getValueAt(row, 4).toString()+"");
		cbbPhai.getModel().setSelectedItem(table.getValueAt(row, 5).toString());
		txtCMND.setText(table.getValueAt(row, 6).toString());
		txtChucVu.setText(table.getValueAt(row, 7).toString());
		txtTaiKhoan.setText(table.getValueAt(row, 8).toString());


		
		int maDC = Integer.parseInt(table.getValueAt(row, 3).toString());
		NhanVien dc;
			try {
				dc = nv_dao.getMaDC(maDC);
				String diaChi= dc.getDiaChi().getSoNha()+","+ dc.getDiaChi().getTenDuong()+","+ dc.getDiaChi().getPhuongXa()+","+ dc.getDiaChi().getQuanHuyen()+","+
						dc.getDiaChi().getTinhTP()+","+dc.getDiaChi().getNuoc();
				txtDC.setText(diaChi);
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
//			String soNha = dc.getSoNha();
//			String tenDuong = dc.getTenDuong().trim();
//			String phuong = dc.getPhuongXa().trim();
//			String quan = dc.getQuanHuyen().trim();
//			String thanhPho = dc.getTinhTP().trim();
//			String quocGia = dc.getNuoc().trim();
			



	}



	public void xoaTrang() {
		txtMaNV.setText("");
		txtDC.setText("");
		txtChucVu.setText("");
		txtTenNV.setText("");
		txtTaiKhoan.setText("");
		txtCMND.setText("");
		txtTimKiem.setText("");
		txtNamSinh.setText("");
		txtmaDC.setText("");

	}
	public void getTimKiemNhanVienById(int id) {
		NhanVienDAO dao = new NhanVienDAO();
		ArrayList<NhanVien> list = null;
		try {
			list = (ArrayList<NhanVien>) dao.timkiemNhanVienByMa(id);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (NhanVien nhanVien : list) {
			model.addRow(nhanVien.toVector()); /// ??????
		}
		for (int i = 0; i < model.getRowCount(); i++) {
			model.setValueAt(i + 1, i, 0);
		}
	}
	public void getTimKiemNhanVienByTen(String ten) {
		NhanVienDAO dao = new NhanVienDAO();
		ArrayList<NhanVien> list = null;
		try {
			list = (ArrayList<NhanVien>) dao.timkiemNhanVienByTen(ten);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (NhanVien nhanVien : list) {
			model.addRow(nhanVien.toVector());
		}
		for (int i = 0; i < model.getRowCount(); i++) {
			model.setValueAt(i + 1, i, 0);
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}


	public static void themNhanVien() {
		NhanVienDAO nhanVienDAO = new NhanVienDAO();
		NhanVien nhanVien = new NhanVien();

		//		
		nhanVien.setTenNV(txtTenNV.getText().trim() );
		nhanVien.setPhai(cbbPhai.getSelectedItem().toString());
		nhanVien.setCMND(txtCMND.getText().trim());
		nhanVien.setChucVu(txtChucVu.getText().trim());

		DiaChi diaChi = new DiaChi();
		diaChi.setMaDC(Integer.parseInt(txtmaDC.getText()));

		nhanVien.setDiaChi(diaChi);
		TaiKhoan taiKhoan = new TaiKhoan();
		taiKhoan.setTaiKhoan(txtTaiKhoan.getText());
		nhanVien.setTenTK(taiKhoan);
		//nv_dao.create(nhanVien.getTenNV(), nhanVien.getDiaChi().getMaDC(),nhanVien.getNamSinh(), nhanVien.getPhai(), nhanVien.getCMND(), nhanVien.getChucVu(),nhanVien.getTenTK().getTaiKhoan());

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnThoat)) {

			ManHinhChinhGUI.tabbedPane.remove(contentPane);

		}	
		else if (obj.equals(btnTimKiemNV)) {
			if (radMa.isSelected() == false && radTen.isSelected() == false 
					&& txtTimKiem.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin và chọn loại tìm kiếm !", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
			} else if (txtTimKiem.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm !", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
			} 
			else if (radMa.isSelected() == false && radTen.isSelected() == false ) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn loại tìm kiếm !", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
			}
			else if (radMa.isSelected()  && radTen.isSelected() ) {
				JOptionPane.showMessageDialog(this, "Vui lòng chỉ chọn 1 loại tìm kiếm !", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
			}else {
				if (radMa.isSelected()) {
					try {
						int ma = Integer.parseInt(txtTimKiem.getText().trim());
						getTimKiemNhanVienById(ma);;
					} catch (Exception e2) {
						if (!txtTimKiem.getText().equalsIgnoreCase("")) {
							JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi !", "Thông báo",
									JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
							txtTimKiem.requestFocus();
							txtTimKiem.selectAll();
						} 
					}
				} else if (radTen.isSelected()) {
					String ten = txtTimKiem.getText().trim();
					getTimKiemNhanVienByTen(ten);
				}


			}
		}
		else  if (obj.equals(btnThemNV)) {

			if(validData()==true) {
				//
				//	int maNV = Integer.parseInt(txtMaNV.getText().trim());
				String tenNV = txtTenNV.getText().trim();
				int maDC = Integer.parseInt(txtmaDC.getText().trim());
				int Nsinh = Integer.parseInt(txtNamSinh.getText().trim());
				String phai = 
						(String)	cbbPhai.getSelectedItem();
				String CMND = txtCMND.getText().trim();
				String chucVu = txtChucVu.getText().trim();
				String taiKhoan = txtTaiKhoan.getText().trim();
				nv_dao.create(tenNV, maDC, Nsinh, phai, CMND, chucVu,taiKhoan);
				//themNhanVien();
				JOptionPane.showConfirmDialog(null, "Thêm  thành công");
				deleteAllDataTable();
				DocDuLieuVaoModel();
				txtTimKiem.requestFocus();
				txtTimKiem.selectAll();
			}
			else
				return;

			//				lamMoi();


		}

		else if (obj.equals(btnXoaTrang)) {
			xoaTrang();
			try {
				nv_dao.getAllNV().forEach(n -> {
					System.out.println(n);
				});
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
		else if (obj.equals(btnXoaNV)) {
			// =================================
			// delete 1 row selected old
			int row = table.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên cần xóa !", "Thông báo !",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
			} 
			else {

				String tenNhanVienXoa = (String) table.getValueAt(row, 2) + " " + table.getValueAt(row, 3);

				try {
					int maNhanVien = Integer.parseInt(txtMaNV.getText());
					NhanVien nv = nv_dao.layThongTinNhanVien(maNhanVien);
					int yes = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa !", "Thông báo !",
							JOptionPane.YES_NO_CANCEL_OPTION);
					if (yes == JOptionPane.YES_OPTION) {
						if (nv_dao.xoaNhanVien(nv)) {
							JOptionPane.showMessageDialog(this,
									"Đã xóa !\\\".",
									"Thông báo !", JOptionPane.CLOSED_OPTION, new ImageIcon("Hinh\\yes.png"));
							xoaAllDataTable();
							DocDuLieuVaoModel();;
						}
					}
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(this, "Xóa thất bại !", "Thông báo !",
							JOptionPane.CLOSED_OPTION, new ImageIcon("Hinh\\warning.png"));
				}

			}
		}
		else if (obj.equals(btnCapNhat)) {
			try {
				int row = table.getSelectedRow();
				if (row >= 0) {

					if (nv_dao.update(Integer.parseInt(txtMaNV.getText()), txtTenNV.getText(),
							Integer.parseInt(txtNamSinh.getText()),
							cbbPhai.getSelectedItem().toString(), txtCMND.getText(), txtChucVu.getText().trim()

							)) {
						JOptionPane.showMessageDialog(this, "Cập nhật thành công.", "Thông báo",
								JOptionPane.CLOSED_OPTION, null);
						table.setValueAt(txtTenNV.getText(), row, 2);
						table.setValueAt(txtNamSinh.getText(), row, 4);
						table.setValueAt(cbbPhai.getSelectedItem().toString(), row, 5);
						table.setValueAt(txtCMND.getText(), row, 6);
						table.setValueAt(txtChucVu.getText(), row, 7);



					}
				} else {
					JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng để cập nhật !", "Thông báo",
							JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
		else if (obj.equals(btnLamMoi)) {
			xoaAllDataTable();
			DocDuLieuVaoModel();;
			txtTimKiem.requestFocus();
			txtTimKiem.selectAll();
		}
	}
}
