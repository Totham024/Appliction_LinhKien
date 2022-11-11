package gui;

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

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;

import javax.swing.ButtonGroup;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;

public class KhachHangGui extends JFrame implements ActionListener, MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	private JTextField txtMa;
	private JTextField txtTenKH;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JTextField txtTim;
	private JButton btnSua;
	private JButton btnXoaRong;
	private JButton btnTim;
	public static JComboBox cbbPhai;
	private JRadioButton radMa;
	private JRadioButton radSDT;
	private JRadioButton radTen;
	private static DefaultTableModel model;
	private static JTable table;
	private JTextField  txtMess;
	private static NhanVienDAO nv_dao = new NhanVienDAO();
	private static DiaChiDAO dc_dao = new DiaChiDAO();
	private static KhachHangDao khDao;
	public static JButton btnThemDC;
	private JButton btnThoat;
	private ButtonGroup buttonGroupGioiTinh;
	private JTextField txtMaDiaChi;
	private JLabel lblMaDiaChi;
	private JButton btnLamMoi;
	private ButtonGroup buttonGroupTim;
	private JTextField txtNamSinh;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhachHangGui frame = new KhachHangGui();
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
	public KhachHangGui() {
		ConnectDB.getInstance().connect();
		khDao = new KhachHangDao();
		dc_dao = new DiaChiDAO();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(10, 50, 1354, 744); // 2 chu dau là margin top , left
		//	setBounds(100, 100, 1354, 675);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1338, 700);
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
					.addGap(19)
					.addComponent(panel_top, GroupLayout.PREFERRED_SIZE, 1306, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(13, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_bot, GroupLayout.DEFAULT_SIZE, 1284, Short.MAX_VALUE)
					.addGap(44))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_center, GroupLayout.PREFERRED_SIZE, 1302, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(26)
					.addComponent(panel_top, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_center, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_bot, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(39))
		);


		panel_bot.setLayout(null);

		btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManHinhChinhGUI.tabbedPane.remove(contentPane);
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThoat.setBounds(1139, 39, 135, 38);
		panel_bot.add(btnThoat);
		panel_top.setLayout(null);

		JLabel lblTTieuDe = new JLabel("THÔNG TIN KHÁCH HÀNG");
		lblTTieuDe.setForeground(new Color(255, 0, 0));
		lblTTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblTTieuDe.setBounds(493, 21, 351, 29);
		panel_top.add(lblTTieuDe);
		panel.setLayout(gl_panel);
		panel_center.setLayout(null);
		JLabel lblKH_Ho = new JLabel("Tên KH");
		lblKH_Ho.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblKH_Ho.setBounds(439, 77, 75, 21);
		panel_top.add(lblKH_Ho);

		txtTenKH = new JTextField();
		txtTenKH.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(536, 77, 296, 25);
		panel_top.add(txtTenKH);

		JLabel lblKH_NgaySinh = new JLabel("Năm sinh");
		lblKH_NgaySinh.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblKH_NgaySinh.setBounds(10, 113, 99, 26);
		panel_top.add(lblKH_NgaySinh);

		JLabel lblKH_SDT = new JLabel("Số điện thoại \r\n:");
		lblKH_SDT.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblKH_SDT.setBounds(10, 150, 146, 26);
		panel_top.add(lblKH_SDT);
		JLabel lblKH_Ma = new JLabel("Mã:");
		lblKH_Ma.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblKH_Ma.setBounds(10, 73, 54, 26);
		panel_top.add(lblKH_Ma);

		txtMa = new JTextField();
		txtMa.setEditable(false);
		txtMa.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtMa.setBounds(119, 76, 296, 25);
		panel_top.add(txtMa);
		txtMa.setColumns(10);
		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		txtDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(633, 164, 663, 25);
		panel_top.add(txtDiaChi);

		JLabel lblKH_DiaChi = new JLabel("Địa chỉ:");
		lblKH_DiaChi.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblKH_DiaChi.setBounds(536, 165, 87, 21);
		panel_top.add(lblKH_DiaChi);

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtSDT.setColumns(10);
		txtSDT.setBounds(166, 152, 249, 25);
		panel_top.add(txtSDT);
		cbbPhai = new JComboBox<String>();
		cbbPhai.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cbbPhai.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbbPhai.setBounds(536, 114, 141, 23);
		panel_top.add(cbbPhai);
		cbbPhai.addItem("Nam");
		cbbPhai.addItem("Nữ");
		txtNamSinh = new JTextField();
		txtNamSinh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtNamSinh.setColumns(10);
		txtNamSinh.setBounds(119, 112, 296, 25);
		panel_top.add(txtNamSinh);
		txtMaDiaChi = new JTextField();
		txtMaDiaChi.setEditable(false);
		txtMaDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtMaDiaChi.setColumns(10);
		txtMaDiaChi.setBounds(1003, 114, 150, 25);
		panel_top.add(txtMaDiaChi);

		lblMaDiaChi = new JLabel("Mã đia chỉ:");
		lblMaDiaChi.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMaDiaChi.setBounds(873, 114, 120, 25);
		panel_top.add(lblMaDiaChi);
		btnSua = new JButton("Cập nhật");
		//btnSua.setIcon(new ImageIcon("Hinh\\edit.png"));
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSua.setBounds(161, 200, 120, 30);
		panel_top.add(btnSua);
		JLabel lblKH_GioiTinh = new JLabel("Giới Tính:");
		lblKH_GioiTinh.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblKH_GioiTinh.setBounds(439, 113, 92, 26);
		panel_top.add(lblKH_GioiTinh);

		radMa = new JRadioButton("Mã");
		radMa.setFont(new Font("Times New Roman", Font.BOLD, 18));
		radMa.setBounds(23, 7, 64, 23);
		panel_bot.add(radMa);

		radSDT = new JRadioButton("Số ĐT");
		radSDT.setFont(new Font("Times New Roman", Font.BOLD, 18));
		radSDT.setBounds(114, 7, 98, 23);
		panel_bot.add(radSDT);

		radTen = new JRadioButton("Tên");
		radTen.setFont(new Font("Times New Roman", Font.BOLD, 18));
		radTen.setBounds(244, 6, 104, 23);
		panel_bot.add(radTen);
		buttonGroupTim = new ButtonGroup();
		buttonGroupTim.add(radMa);
		buttonGroupTim.add(radSDT);
		buttonGroupTim.add(radTen);
		//	panel_bot.add(buttonGroupGioiTinh);
		btnXoaRong = new JButton("Xóa rỗng");
		//setIcon(new ImageIcon("Hinh\\empty.png"));
		btnXoaRong.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnXoaRong.setBounds(295, 200, 120, 30);
		panel_top.add(btnXoaRong);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 21, 1264, 258);
		panel_center.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		String[] tb = new String[] { "STT", "Mã KH", "Tên KH","Số điện thoại", "Mã ĐC", "Giới tính", "Email", "Năm sinh"};


		model = new DefaultTableModel(tb, 0);
		table = new JTable(model);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
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
		txtMess.setBounds(439, 186, 384, 20);
		txtMess.setEditable(false);
		txtMess.setBorder(null);
		txtMess.setForeground(Color.red);
		panel_top.add(txtMess);



		JButton btnThemDC = new JButton("Thêm ĐC");
		btnThemDC.setForeground(new Color(0, 0, 0));
		btnThemDC.setBackground(new Color(64, 224, 208));
		btnThemDC.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThemDC.setBounds(1161, 112, 103, 27);
		panel_top.add(btnThemDC);

		JLabel lblemail = new JLabel("Email");
		lblemail.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblemail.setBounds(894, 77, 75, 21);
		panel_top.add(lblemail);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtEmail.setColumns(10);
		txtEmail.setBounds(1000, 77, 296, 25);
		panel_top.add(txtEmail);
		JLabel lblNhpThngTin = new JLabel("Nhập thông tin tìm kiếm:");
		lblNhpThngTin.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNhpThngTin.setBounds(68, 46, 229, 25);
		panel_bot.add(lblNhpThngTin);

		txtTim = new JTextField();
		txtTim.setBounds(307, 47, 305, 25);
		panel_bot.add(txtTim);
		txtTim.setColumns(10);

		btnTim = new JButton("Tìm");
		btnTim.setIcon(new ImageIcon("Hinh\\search.png"));
		btnTim.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnTim.setBounds(689, 43, 99, 30);
		panel_bot.add(btnTim);

		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setIcon(new ImageIcon("Hinh\\refresh.png"));
		btnLamMoi.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnLamMoi.setBounds(835, 43, 141, 30);
		panel_bot.add(btnLamMoi);

		btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon("Hinh\\close.png"));
		btnThoat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnThoat.setBounds(1091, 546, 120, 30);

		btnThemDC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuiDiaChi dc = new GuiDiaChi();
				dc.setVisible(true);
				dc.setLocationRelativeTo(null);
			}
		});
		ButtonGroup group = new ButtonGroup();
		group.add(radMa);
		group.add(radSDT);
		group.add(radTen);
		table.addMouseListener(this);
		btnThemDC.addActionListener(this);
		btnThoat.addActionListener(this);
		// docDuLieu();
		docDuLieu();;
		btnSua.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnTim.addActionListener(this);
		btnThoat.addActionListener(this);
		btnLamMoi.addActionListener(this);
		table.addMouseListener(this);


	}

	public static void docDuLieu() {
		try {
			List<KhachHang> list = khDao.getAllKH();
			int i = 0;
			for (KhachHang khachHang : list) {
				i++;
				model.addRow(new Object[] { i + "", khachHang.getMaKH()+ "",
						khachHang.getTenKH().trim()+"",khachHang.getSdt() + "",khachHang.getDiaChi().getMaDC() + "", khachHang.getPhai()+"",khachHang.getEmail() + "",khachHang.getNamSinh() + ""});

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



	//private boolean validData() {
	//	String DC = txtmaDC.getText().trim();
	//	String Tk = txtTaiKhoan.getText().trim();
	//
	//	String cMND = txtCMND.getText().trim();
	//	String ht = txtTenNV.getText().trim();
	//	String Nsinh = txtNamSinh.getText().trim();
	//	String ChucVu = txtChucVu.getText().trim();
	//	if(!(ht.length()>8 )) {
	//		showMessage("Họ tên phải lớn hơn 8 kí tự",txtTenNV);
	//		return false;
	//	}
	//	
	//	if((Tk.length()<=0  )) {
	//		showMessage("Vui lòng thêm thông tin tài khoản",txtTaiKhoan);
	//		return false;
	//	}
	//	if((DC.length()<=0 )) {
	//		showMessage("Vui lòng thêm thông tin địa chỉ",txtDC);
	//		return false;
	//	}
	//
	//	if(Nsinh.length()>0 ) {
	//		try {
	//			int x= Integer.parseInt(Nsinh);
	//			
	//			if((x<=1960 || x>= 2002)) {
	//				showMessage("Năm sinh >=1960 && <= 2002",txtNamSinh);
	//				return false;
	//			}
	//			
	//		} catch (Exception e) {
	//			showMessage("Năm sinh bao gồm 4 chữ số ", txtNamSinh);
	//			return false;
	//		}
	//		
	//	}
	//	try {
	//		if (cMND.equals("")) {
	//			JOptionPane.showMessageDialog(this, "Vui lòng nhập chứng minh nhân dân !", "Thông báo !",
	//					JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
	//			txtCMND.requestFocus();
	//			txtCMND.selectAll();
	//			return false;
	//		} else if (cMND.matches("^[0-9]{9}$") == false) {
	//			JOptionPane.showMessageDialog(this, "Chứng minh nhân dân gồm 9 chữ số !", "Thông báo !",
	//					JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
	//			txtCMND.requestFocus();
	//			txtCMND.selectAll();
	//			return false;
	//		}
	//	} catch (Exception e) {
	//		JOptionPane.showMessageDialog(this, "Chứng minh nhân dân không hợp lệ !", "Thông báo !",
	//				JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
	//		txtCMND.requestFocus();
	//		txtCMND.selectAll();
	//		return false;
	//	}
	//
	//		//showMessage("Correct",txtMess);
	//	
	//	
	//	return true;
	//}

	private void showMessage(String message, JTextField txt) {
		txt.requestFocus();
		txtMess.setText(message);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		int maKH = Integer.parseInt(model.getValueAt(row, 1).toString());

		try {
//			KhachHang kh = khDao.layThongTinKhachHang(maKH);
			txtMa.setText(maKH + "");
			//	txtMa.setText(table.getValueAt(row, 1).toString() + "");
			txtTenKH.setText(table.getValueAt(row, 2).toString());
			txtSDT.setText(table.getValueAt(row, 3).toString() + "");
			txtMaDiaChi.setText(table.getValueAt(row, 4).toString()+"");
			cbbPhai.getModel().setSelectedItem(table.getValueAt(row, 5).toString());
			txtEmail.setText(table.getValueAt(row, 6).toString());
			txtNamSinh.setText(table.getValueAt(row, 7).toString());
			


			int maDC = Integer.parseInt(model.getValueAt(row, 4).toString());
//			DiaChi dc = khDao.layThongTinDiaChi(maDC);
//			String soNha = dc.getSoNha();
//			String tenDuong = dc.getTenDuong().trim();
//			String phuong = dc.getPhuongXa().trim();
//			String quan = dc.getQuanHuyen().trim();
//			String thanhPho = dc.getTinhTP().trim();
//			String quocGia = dc.getNuoc().trim();
			KhachHang kh1= khDao.getMaDC(maDC);
			String diaChi = 
			
				 kh1.getDiaChi().getSoNha()+","+ kh1.getDiaChi().getTenDuong()+","+ kh1.getDiaChi().getPhuongXa()+","+ kh1.getDiaChi().getQuanHuyen()+","+
						kh1.getDiaChi().getTinhTP()+","+kh1.getDiaChi().getNuoc();
			txtDiaChi.setText(diaChi);
		} catch (Exception e2) {
			System.out.println("error mouse clicked");
			e2.printStackTrace();
		}
	}


	public void xoaRong() {
		txtMa.setText("");
		txtTenKH.setText("");
		txtDiaChi.setText("");
		txtSDT.setText("");
		txtTim.setText("");
		buttonGroupGioiTinh.clearSelection();
		txtMaDiaChi.setText("");
		txtNamSinh.setText("");
		txtEmail.setText("");
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



	private boolean validData() {
		int ma = Integer.parseInt(txtMa.getText());
		String namsinh = txtNamSinh.getText();
		String ten = txtTenKH.getText().trim();
		String sdt = txtSDT.getText().trim();
		String gioiTinh = 
				(String)	cbbPhai.getSelectedItem();
		String email = txtEmail.getText().trim();
		String dc = txtMaDiaChi.getText();
		if(!(ten.length()>8 )) {
			showMessage("Họ tên phải lớn hơn 8 kí tự",txtTenKH);
			return false;
		}


		//		if(!(diachi.length()>10)) {
		//			showMessage(" Ä�á»‹a chá»‰ lá»›n hÆ¡n 10 kÃ­ tá»±",txtDC);
		//			return false;
		//		}
		if(namsinh.length()>0 ) {
			try {
				int x= Integer.parseInt(namsinh);

				if((x<=1900 || x>= 2021)) {
					showMessage("Năm sinh không hợp lệ",txtNamSinh);
					return false;
				}

			} catch (Exception e) {
				showMessage("Năm sinh bao gồm 4 chữ số ", txtNamSinh);
				return false;
			}

		}if (ten.length()<=0) {
			showMessage("Họ tên phải lớn hơn 8 kí tự",txtTenKH);
		} else if (ten.length() > 50) {
			showMessage("Không hợp lệ",txtTenKH);


		}
		if (sdt.length()<=0) {
			showMessage("Vui lòng nhập số điện thoại",txtSDT);

		} else if (!sdt.matches("^0[0-9]{9}$")) {
			showMessage("Số điện phải bắt đầu từ 0 và có 10 chữ số)",txtSDT);
		}
		if (!email.matches("^[a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4}$")) {
			showMessage("Vui lòng nhập đúng cú pháp",txtEmail);


			//showMessage("Correct",txtMess);
		}

		return true;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnThoat)) {
				ManHinhChinhGUI.tabbedPane.remove(contentPane);
		} else if (obj.equals(btnXoaRong)) {
			xoaRong();
		}
		else if (obj.equals(btnSua)) {
			try {
				int row = table.getSelectedRow();
				if (row >= 0) {

					if (khDao.capnhatKH(Integer.parseInt(txtMa.getText()), 
							txtTenKH.getText(),
							txtSDT.getText(),					
							cbbPhai.getSelectedItem().toString(),
							txtEmail.getText(), 	
							Integer.parseInt(txtNamSinh.getText())

				)) {
						JOptionPane.showMessageDialog(this, "Cập nhật thành công.", "Thông báo",
								JOptionPane.CLOSED_OPTION, null);
						table.setValueAt(txtTenKH.getText(), row, 2);
						table.setValueAt(txtSDT.getText(), row, 4);
						table.setValueAt(cbbPhai.getSelectedItem().toString(), row, 5);
						table.setValueAt(txtEmail.getText(), row, 6);
						table.setValueAt(txtNamSinh.getText(), row, 7);
						lamMoi();
						



					}
				} else {
					JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng để cập nhật !", "Thông báo",
							JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
//			int row = table.getSelectedRow();
//
//			if (row != -1) {
//
//				if(validData()==true) {
//					int ma = Integer.parseInt(txtMa.getText());
//					int namsinh = Integer.parseInt(txtNamSinh.getText());
//					String ten = txtTenKH.getText().trim();
//					String sdt = txtSDT.getText().trim();
//					String gioiTinh = 
//							(String)	cbbPhai.getSelectedItem();
//					String email = txtEmail.getText().trim();
//					int dc = Integer.parseInt(txtMaDiaChi.getText());
//					try {
//						if (khDao.capnhatKH(ma, ten, sdt, dc, gioiTinh, email, namsinh) ) {
//							JOptionPane.showMessageDialog(this, "Cập nhật thành công.", "Thông báo",
//									JOptionPane.CLOSED_OPTION, null);
//							table.setValueAt(ten, row, 2);
//							table.setValueAt(sdt, row, 3);
//							table.setValueAt(dc, row, 4);
//							table.setValueAt(gioiTinh, row, 5);
//							table.setValueAt(dc, row, 6);
//							table.setValueAt(email, row, 7);
//							table.setValueAt(namsinh, row, 8);
//							deleteAllDataTable();
//							docDuLieu();
//
//
//
//						}
//					} catch (HeadlessException e1) {
//						e1.printStackTrace();
//					}
//				} else {
//					JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng để cập nhật !", "Thông báo",
//							JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
//				}


	//		}




		} else if (obj.equals(btnTim)) {
			if (radMa.isSelected() == false && radTen.isSelected() == false && radSDT.isSelected() == false
					&& txtTim.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin và chọn loại tìm kiếm !", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
			} else if (txtTim.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm !", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
			} else if (radMa.isSelected() == false && radTen.isSelected() == false && radSDT.isSelected() == false) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn loại tìm kiếm !", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
			} else {
				if (radMa.isSelected()) {
					try {
						int ma = Integer.parseInt(txtTim.getText().trim());
						getTimKiemKhachHangById(ma);
					} catch (Exception e2) {
						if (!txtMa.getText().equalsIgnoreCase("")) {
							JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi !", "Thông báo",
									JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
							txtTim.requestFocus();
							txtTim.selectAll();
						} 
					}
				} else if (radTen.isSelected()) {
					String ten = txtTim.getText().trim();
					getTimKiemKhachHangByTen(ten);
				} else if (radSDT.isSelected()) {
					String sdt = txtTim.getText().trim();
					getTimKiemKhachHangBySoDT(sdt);

				}
			}
		}

		else if (obj.equals(btnLamMoi)) {
			lamMoi();
		}
	}
	public void lamMoi() {
		txtTim.selectAll();
		txtTim.requestFocus();
		deleteAllDataTable();
		docDuLieu();
	}
	public void deleteAllDataTable() {
		model = (DefaultTableModel) table.getModel();
		model.getDataVector().removeAllElements();
	}

	public void getTimKiemKhachHangById(int ma) {
		ArrayList<KhachHang> list = null;
		try {
			list = (ArrayList<KhachHang>) khDao.timkiemKhachHangByMa(ma);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (KhachHang khachhang : list) {
			model.addRow(khachhang.toVector());
		}
		for (int i = 0; i < model.getRowCount(); i++) {
			model.setValueAt(i + 1, i, 0);
		}
	}

	public void getTimKiemKhachHangByTen(String ten) {
		ArrayList<KhachHang> list = null;
		try {
			list = (ArrayList<KhachHang>) khDao.timkiemKhachHangByTen(ten);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (KhachHang khachhang : list) {
			model.addRow(khachhang.toVector());
		}
		for (int i = 0; i < model.getRowCount(); i++) {
			model.setValueAt(i + 1, i, 0);
		}
	}


	public void getTimKiemKhachHangBySoDT(String sdt) {
		ArrayList<KhachHang> list = null;
		try {
			list = (ArrayList<KhachHang>) khDao.timkiemKhachHangBySDT(sdt);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (KhachHang khachhang : list) {
			model.addRow(khachhang.toVector());
		}
		for (int i = 0; i < model.getRowCount(); i++) {
			model.setValueAt(i + 1, i, 0);
		}
	}
}
