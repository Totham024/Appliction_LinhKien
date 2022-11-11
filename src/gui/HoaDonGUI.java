package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.HoaDonDAO;
import entity.CTHoaDon;
import entity.HoaDon;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HoaDonGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	private DefaultTableModel modelHD;
	private JTable tableHD;
	private DefaultTableModel modelCTHD;
	private JTable tableCTHD;
	private JTextField txtMaHD;
	private JTextField txtNgayLap;
	private JTextField txtNV;
	private JTextField txtKH;
	private JRadioButton rdbtnMaHD;
	private JRadioButton rdbtnNgayNhap;
	private JRadioButton rdbtnTenNV;
	private JRadioButton rdbtnTenKH;
	private JComboBox cboNhap;
	private JButton btnLamMoi;
	private JButton btnNewButton;
	private JButton btnTimKiem;
	private JLabel lblTimTheo;
	private JLabel lblTim;
	private JPanel pTimKiem;
	private JLabel lblKhachHang;
	private JLabel lblNV;
	private JLabel lblNgayLap;
	private JLabel lblMaHD;
	private JLabel lblTitle;
	private JPanel pTable;
	private JScrollPane scrollPane;
	private JPanel pChiTiet;
	private JScrollPane scrollPaneCT;
	private HoaDonDAO hd_dao = new HoaDonDAO();
	private DefaultComboBoxModel cboModeMaHD= new DefaultComboBoxModel();
	private DefaultComboBoxModel<Date> cboModeNgayLap= new DefaultComboBoxModel();
	private DefaultComboBoxModel cboModeTenKH= new DefaultComboBoxModel();
	private DefaultComboBoxModel cboModeTenNV= new DefaultComboBoxModel();
	private ArrayList<String> listMaHD = new ArrayList<String>() ;
	private ArrayList<String> listNgayLap = new ArrayList<String>() ;
	private ArrayList<String> listTenKH = new ArrayList<String>() ;
	private ArrayList<String> listTenNV = new ArrayList<String>() ;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoaDonGUI frame = new HoaDonGUI();
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
	public HoaDonGUI() {
		ConnectDB.getInstance().connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400,700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane.setLayout(null);

		lblTitle = new JLabel("QUẢN LÝ HÓA ĐƠN");
		lblTitle.setForeground(Color.RED);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTitle.setBounds(481, 36, 318, 37);
		contentPane.add(lblTitle);

		pTable = new JPanel();
		pTable.setBackground(new Color(224, 255, 255));
		pTable.setBorder(new TitledBorder(null, "Th\u00F4ng tin h\u00F3a \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pTable.setBounds(0, 290, 1370, 243);
		contentPane.add(pTable);
		pTable.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 1350, 204);

		String[] tb = new String[] { "STT","Mã hóa đơn", "Ngày lập"," Tổng tiền ", "Tên khách hàng ", "Tên nhân viên" };
		modelHD = new DefaultTableModel(tb, 0);
		tableHD = new JTable(modelHD);
		tableHD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row;
				row = tableHD.getSelectedRow();
				txtMaHD.setText(modelHD.getValueAt(row, 1).toString());
				txtNgayLap.setText(modelHD.getValueAt(row, 2).toString());
				
				txtNV.setText(modelHD.getValueAt(row, 5).toString());
				txtKH.setText(modelHD.getValueAt(row, 4).toString());
				int d=0;
				
				List<CTHoaDon> listCT= hd_dao.getCTByMaHD(Integer.parseInt(modelHD.getValueAt(row, 1).toString()));
				xoaTableCT();
				for (CTHoaDon ct : listCT) {
					double tongTien = ct.getDonGia()*ct.getSoLuong();
					modelCTHD.addRow(new Object[] {
						
						d++,ct.getLinhKien().getMaLK(),ct.getLinhKien().getTenLK(),ct.getSoLuong(),
						ct.getLinhKien().getDonViTinh(),ct.getLinhKien().getBaoHanh(),ct.getDonGia(),tongTien	
					});
				}
			}

			

			
		});
		tableHD.setFont(new Font("Times New Roman", Font.BOLD, 20));
		scrollPane.setViewportView(tableHD);


		pTable.add(scrollPane);

		pChiTiet = new JPanel();
		pChiTiet.setBackground(new Color(224, 255, 255));
		pChiTiet.setBorder(new TitledBorder(null, "Chi ti\u1EBFt h\u00F3a \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pChiTiet.setBounds(437, 84, 923, 204);
		contentPane.add(pChiTiet);
		pChiTiet.setLayout(null);

		scrollPaneCT = new JScrollPane();
		scrollPaneCT.setBounds(10, 21, 903, 197);
		String[] tb1 = new String[] { "Stt","Mã linh kiện","Tên linh kiện","Số lượng", "Đơn vị tính","Bảo hành", "Giá bán ","Thành tiền" };
		modelCTHD = new DefaultTableModel(tb1, 0);
		tableCTHD = new JTable(modelCTHD);
		tableCTHD.setFont(new Font("Times New Roman", Font.BOLD, 20));
		scrollPaneCT.setViewportView(tableCTHD);
		pChiTiet.add(scrollPaneCT);

		lblMaHD = new JLabel("Mã hóa đơn");
		lblMaHD.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaHD.setBounds(25, 99, 101, 28);
		contentPane.add(lblMaHD);

		lblNgayLap = new JLabel("Ngày lập");
		lblNgayLap.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNgayLap.setBounds(25, 138, 101, 28);
		contentPane.add(lblNgayLap);

		lblNV = new JLabel("Nhân viên");
		lblNV.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNV.setBounds(25, 179, 101, 28);
		contentPane.add(lblNV);

		lblKhachHang = new JLabel("Khách hàng");
		lblKhachHang.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblKhachHang.setBounds(25, 218, 101, 28);
		contentPane.add(lblKhachHang);

		txtMaHD = new JTextField();
		txtMaHD.setEditable(false);
		txtMaHD.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtMaHD.setBounds(136, 100, 291, 31);
		contentPane.add(txtMaHD);
		txtMaHD.setColumns(10);

		txtNgayLap = new JTextField();
		txtNgayLap.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtNgayLap.setBounds(136, 138, 170, 28);
		contentPane.add(txtNgayLap);
		txtNgayLap.setColumns(10);

		txtNV = new JTextField();
		txtNV.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtNV.setBounds(136, 181, 291, 28);
		contentPane.add(txtNV);
		txtNV.setColumns(10);

		txtKH = new JTextField();
		txtKH.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtKH.setBounds(136, 220, 291, 28);
		contentPane.add(txtKH);
		txtKH.setColumns(10);

		pTimKiem = new JPanel();
		pTimKiem.setBackground(new Color(224, 255, 255));
		pTimKiem.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng t\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pTimKiem.setBounds(10, 537, 1350, 113);
		contentPane.add(pTimKiem);
		pTimKiem.setLayout(null);

		lblTim = new JLabel("Nhập thông tin tìm kiếm");
		lblTim.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTim.setBounds(10, 77, 211, 25);
		pTimKiem.add(lblTim);

		rdbtnMaHD = new JRadioButton("Mã hóa đơn");
		rdbtnMaHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cboNhap.setModel(cboModeMaHD);
			}
		});
		rdbtnMaHD.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnMaHD.setBounds(153, 29, 138, 28);
		pTimKiem.add(rdbtnMaHD);

		lblTimTheo = new JLabel("Tìm theo");
		lblTimTheo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTimTheo.setBounds(10, 29, 115, 26);
		pTimKiem.add(lblTimTheo);

		rdbtnNgayNhap = new JRadioButton("Ngày lập ");
		rdbtnNgayNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cboNhap.setModel(cboModeNgayLap);
			}
		});
		rdbtnNgayNhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnNgayNhap.setBounds(352, 30, 155, 27);
		pTimKiem.add(rdbtnNgayNhap);

		rdbtnTenNV = new JRadioButton("Tên nhân viên");
		rdbtnTenNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cboNhap.setModel(cboModeTenNV);
			}
		});
		rdbtnTenNV.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnTenNV.setBounds(573, 29, 146, 29);
		pTimKiem.add(rdbtnTenNV);

		rdbtnTenKH = new JRadioButton("Tên khách hàng ");
		rdbtnTenKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cboNhap.setModel(cboModeTenKH);
			}
		});
		rdbtnTenKH.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnTenKH.setBounds(800, 29, 155, 29);
		pTimKiem.add(rdbtnTenKH);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiem();
			}

			
		});
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTimKiem.setBounds(925, 77, 109, 25);
		pTimKiem.add(btnTimKiem);

		cboNhap = new JComboBox();
		cboNhap.setEditable(true);
		cboNhap.setBounds(216, 77, 675, 24);
		pTimKiem.add(cboNhap);
		
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lamMoi();
			}
		});
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLamMoi.setBounds(1131, 30, 115, 27);
		pTimKiem.add(btnLamMoi);

		btnNewButton = new JButton("Thoát");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManHinhChinhGUI.tabbedPane.remove(contentPane);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(1131, 75, 115, 28);
		pTimKiem.add(btnNewButton);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnTenNV);
		group.add(rdbtnMaHD);
		group.add(rdbtnTenKH);
		group.add(rdbtnNgayNhap);
		
		DocDuLieuVaoTable();
	}
	
	private void DocDuLieuVaoTable() {
		
		ArrayList<HoaDon> listHD = hd_dao.getAllHD();
		int d= 0;
		for (HoaDon hoaDon : listHD) {
			modelHD.addRow(new Object[] {d++,hoaDon.getMaHD(),hoaDon.getNgayLap(),hoaDon.getTongTien(), hoaDon.getKhachHang().getTenKH(),hoaDon.getNhanVien().getTenNV()});
			if(listNgayLap.contains(String.valueOf(hoaDon.getNgayLap()))== false) {
				cboModeNgayLap.addElement(hoaDon.getNgayLap());
				listNgayLap.add(String.valueOf(hoaDon.getNgayLap()));
			}
			if(listTenNV.contains(hoaDon.getNhanVien().getTenNV())== false) {
				cboModeTenNV.addElement(hoaDon.getNhanVien().getTenNV());
				listTenNV.add(hoaDon.getNhanVien().getTenNV());
			}
			if(listTenKH.contains(hoaDon.getKhachHang().getTenKH())== false) {
				cboModeTenKH.addElement(hoaDon.getKhachHang().getTenKH());
				listTenKH.add(hoaDon.getKhachHang().getTenKH());
			}
			if(listMaHD.contains(String.valueOf(hoaDon.getMaHD()))== false) {
				cboModeMaHD.addElement(hoaDon.getMaHD());
				listMaHD.add(String.valueOf(hoaDon.getMaHD()));
			}
		}
		
		
	}
	private void xoaTableCT() {
		modelCTHD.addRow(new Object[] {});
		DefaultTableModel tbl = (DefaultTableModel) tableCTHD.getModel();
		tbl.getDataVector().removeAllElements();
		
	}

	private void xoaTableHD() {
		modelHD.addRow(new Object[] {});
		DefaultTableModel tbl = (DefaultTableModel) tableHD.getModel();
		tbl.getDataVector().removeAllElements();
		xoaTableCT();
		
	}
	private void timKiem() {
		lamMoi();
		String tim=cboNhap.getSelectedItem().toString();
		if(tim.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Không được rỗng");
			return; 
		}
		int d=0;
		
		if (rdbtnMaHD.isSelected()) {
			xoaTableHD();
			
			List<HoaDon> listHD = hd_dao.getHDByMa(tim);
			for (HoaDon hd : listHD) {
				modelHD.addRow(new Object[] {d++,hd.getMaHD(),hd.getNgayLap(),hd.getTongTien(),
						hd.getKhachHang().getTenKH(),hd.getNhanVien().getTenNV()});
				System.out.println(hd);	
			}
			
			
		}
		if (rdbtnNgayNhap.isSelected()) {
			
			String nl= cboNhap.getSelectedItem().toString();
			String[] ngaylap = nl.split("-");
			int  nam = Integer.parseInt(ngaylap[0]);
			int thang = Integer.parseInt(ngaylap[1]);
			int ngay = Integer.parseInt(ngaylap[2]);
			System.out.println(ngay);
			System.out.println(thang);
			System.out.println(nam);
			xoaTableHD();
			
			List<HoaDon> listHD = hd_dao.getHDByNgayNhap(ngay,thang,nam);
			for (HoaDon hd : listHD) {
				modelHD.addRow(new Object[] {d++,hd.getMaHD(),hd.getNgayLap(),hd.getTongTien(),
						hd.getKhachHang().getTenKH(),hd.getNhanVien().getTenNV()});
				System.out.println(hd);	
			}
			
			
		}
		if (rdbtnTenKH.isSelected()) {
			xoaTableHD();
			List<HoaDon> listHD = hd_dao.getHDByTenKH(tim);
			for (HoaDon hd : listHD) {
				modelHD.addRow(new Object[] {d++,hd.getMaHD(),hd.getNgayLap(),hd.getTongTien(),
						hd.getKhachHang().getTenKH(),hd.getNhanVien().getTenNV()});
				System.out.println(hd);	
			}
			
			
		}
		if (rdbtnTenNV.isSelected()) {
			xoaTableHD();
			List<HoaDon> listHD = hd_dao.getHDByTenNV(tim);
			for (HoaDon hd : listHD) {
				modelHD.addRow(new Object[] {d++,hd.getMaHD(),hd.getNgayLap(),hd.getTongTien(),
						hd.getKhachHang().getTenKH(),hd.getNhanVien().getTenNV()});
				System.out.println(hd);	
			}
			
			
		}
		
			
			
		
	}

	private void lamMoi() {
		xoaTableHD();
		txtKH.setText("");
		txtMaHD.setText("");
		txtNgayLap.setText("");
		txtNV.setText("");
		DocDuLieuVaoTable();
		
	}
}
