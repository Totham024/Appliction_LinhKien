package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Component;

import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import dao.lapHoaDonDAO;
import entity.CTHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.LinhKien;
import entity.NhanVien;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.Scrollbar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;


public class LapHoaDonGUI extends JFrame  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JPanel contentPane;
	private static TableModel modelLK;
	public static JTextField txtTongTien;
	private static JTextField txtTienNhan;
	public static JTextField txtThanhToan;
	private static JTextField txtTienDu;
	private static JTextField txtThue;
	private static JTable table;
	public JComboBox<String> cboLoaiLK;
	private JPanel pLapHoaDon;
	private JLabel lblNgayBan;
	private JLabel lblTT;
	private JPanel pThanhToan;
	private JLabel lblTongTien;
	private JLabel lblTienNhan;
	private JLabel lblTienDu;
	private JLabel lblThanhToan;
	private JLabel lblThue;
	private JButton btnLuu;
	private JButton btnHuyHD;
	private JButton btnThoat;
	private JPanel pTable;
	private JScrollPane scrollPane;
	private JButton btnXoaCT;
	private JButton btnTimLK;
	private JLabel lblTenLK;
	public static JTextField txtSDT;
	public static JLabel lblMKH;
	public static JLabel lblTKH;
	public static JLabel lblDC;
	public static JTextField txtSoLuong;
	public JLabel lblMNV;
	public JLabel lblTNV;
	public static JLabel lblNB; 
	public static lapHoaDonDAO lhd_dao= new lapHoaDonDAO();
	private ThemCTHDGUI themCTHD = new ThemCTHDGUI();
	private JPopupMenu popupMenu;
	private JMenuItem mntmSoLuong;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LapHoaDonGUI frame = new LapHoaDonGUI();
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
	public LapHoaDonGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1390, 744);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();

		contentPane.setForeground(Color.RED);
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Lập hóa đơn");

		contentPane.setLayout(null);

		pLapHoaDon = new JPanel();
		pLapHoaDon.setBackground(new Color(224, 255, 255));
		pLapHoaDon.setBounds(0, 0, 1361, 744);
		contentPane.add(pLapHoaDon);
		pLapHoaDon.setLayout(null);

		lblTT = new JLabel("LẬP HÓA ĐƠN");
		lblTT.setForeground(Color.RED);
		lblTT.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTT.setBounds(521, 50, 230, 31);
		pLapHoaDon.add(lblTT);

		pThanhToan = new JPanel();
		pThanhToan.setLayout(null);
		pThanhToan.setBorder(new TitledBorder(null, "Th\u00F4ng tin thanh to\u00E1n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pThanhToan.setBackground(new Color(224, 255, 255));
		pThanhToan.setBounds(0, 552, 1351, 143);
		pLapHoaDon.add(pThanhToan);

		lblTongTien = new JLabel("Tổng tiền linh kiện:");
		lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTongTien.setBounds(10, 21, 190, 28);
		pThanhToan.add(lblTongTien);

		lblTienNhan = new JLabel("Tiền nhận từ khách:");
		lblTienNhan.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTienNhan.setBounds(827, 21, 201, 28);
		pThanhToan.add(lblTienNhan);

		lblTienDu = new JLabel("Tiền dư:");
		lblTienDu.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTienDu.setBounds(833, 59, 82, 28);
		pThanhToan.add(lblTienDu);

		lblThanhToan = new JLabel("Thanh toán:");
		lblThanhToan.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThanhToan.setBounds(10, 60, 143, 28);
		pThanhToan.add(lblThanhToan);

		txtTongTien = new JTextField();
		txtTongTien.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(241, 23, 342, 28);
		pThanhToan.add(txtTongTien);

		txtTienNhan = new JTextField();
		txtTienNhan.addKeyListener(new KeyAdapter() {
			DecimalFormat tien = new DecimalFormat("#,##0.00");
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(txtTienNhan.getText()=="") {
					return;
				}
				else {
					Long tienNhan =Long.parseLong(txtTienNhan.getText());

					Long tienThoiLai = tienNhan - tongThanhToan;
					txtTienDu.setText(tien.format(tienThoiLai)+" VNĐ");
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {

				if(txtTienNhan.getText()=="") {
					return;
				}
				else {
					Long tienNhan =Long.parseLong(txtTienNhan.getText());
					System.out.println(tienNhan);
					Long tienThoiLai = tienNhan - tongThanhToan;
					System.out.println(tienThoiLai);
					txtTienDu.setText(tien.format(tienThoiLai)+" VNĐ");
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {
				if(!((e.getKeyChar() >= 48 && e.getKeyChar() <= 57) || e.getKeyChar() == 12)) {
					e.consume();
				}
			}
		});
		txtTienNhan.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtTienNhan.setColumns(10);
		txtTienNhan.setBounds(1038, 24, 269, 28);
		pThanhToan.add(txtTienNhan);

		txtThanhToan = new JTextField();
		txtThanhToan.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtThanhToan.setColumns(10);
		txtThanhToan.setBounds(241, 61, 342, 28);
		pThanhToan.add(txtThanhToan);

		txtTienDu = new JTextField();
		txtTienDu.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtTienDu.setColumns(10);
		txtTienDu.setBounds(1038, 61, 269, 28);
		pThanhToan.add(txtTienDu);

		lblThue = new JLabel("Thuế:");
		lblThue.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThue.setBounds(645, 21, 70, 28);
		pThanhToan.add(lblThue);

		txtThue = new JTextField();
		txtThue.setText("5%");
		txtThue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtThue.setEditable(false);
		txtThue.setColumns(10);
		txtThue.setBounds(725, 21, 56, 28);
		pThanhToan.add(txtThue);

		btnLuu = new JButton("Lưu hóa đơn");
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				luuHoaDon();	
			}
		});
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLuu.setBounds(374, 100, 172, 32);
		pThanhToan.add(btnLuu);

		btnHuyHD = new JButton("Hủy hóa đơn");
		btnHuyHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lamMoi();
			}


		});
		btnHuyHD.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnHuyHD.setBounds(655, 100, 190, 32);
		pThanhToan.add(btnHuyHD);

		btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManHinhChinhGUI.tabbedPane.remove(contentPane);
			}
		});
		btnThoat.setForeground(Color.BLACK);
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnThoat.setBackground(new Color(135, 206, 235));
		btnThoat.setBounds(981, 100, 114, 32);
		pThanhToan.add(btnThoat);

		JButton btnIn = new JButton("In Hoa Đơn");
		btnIn.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				XuatHoaDonGUI x= new XuatHoaDonGUI();
				x.setVisible(true);
				int stt =0;
				ArrayList<CTHoaDon> listCT_HD = new ArrayList<CTHoaDon>();
				List data = ((DefaultTableModel) modelLK).getDataVector();
				Object[] list1 = data.toArray();
				for(int k=0;k<list1.length;k++) {
					XuatHoaDonGUI.tableModel.addRow(new Object[] {
							++stt,modelLK.getValueAt(k, 2).toString(),modelLK.getValueAt(k,3),modelLK.getValueAt(k, 4),modelLK.getValueAt(k, 6),modelLK.getValueAt(k, 7)
					});
				}
				x.printingHoaDon();
			}
		});
		btnIn.setBounds(127, 99, 148, 33);
		pThanhToan.add(btnIn);

		pTable = new JPanel();
		pTable.setLayout(null);
		pTable.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Chi ti\u1EBFt linh ki\u1EC7n  m\u1EDBi", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pTable.setBackground(new Color(224, 255, 255));
		pTable.setBounds(0, 258, 1351, 291);
		pLapHoaDon.add(pTable);


		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 1331, 218);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		String[] tb = new String[] { "STT","Mã linh kiện", "Tên linh kiện","Số lượng","Bảo hành",
				"Thương hiệu","Giá bán","Thành tiền"};
		modelLK = new DefaultTableModel(tb, 0);
		table = new JTable(modelLK);
		popupMenu = new JPopupMenu();
		addPopup(table, popupMenu);

		mntmSoLuong = new JMenuItem("Sửa số lượng");
		mntmSoLuong.setFont(new Font("Tahoma", Font.BOLD, 14));
		mntmSoLuong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				int maLK =  (int) modelLK.getValueAt(row, 1);
				boolean check = true;
				while(check) {
					try {
						String soLuongLKObj = JOptionPane.showInputDialog("Nhập số lượng linh kiện mua.",JOptionPane.YES_NO_CANCEL_OPTION);
						if(soLuongLKObj == null) {
							check = false;
						}
						else if(soLuongLKObj != null) {

							if(soLuongLKObj.matches("^[0-9]+$")) {
								int soLuongLKMoi = Integer.parseInt(soLuongLKObj.toString());
								int soLuongLKCu = Integer.parseInt(table.getValueAt(row, 3).toString());
								if((lapHoaDonDAO.soLuongLKDaBan(maLK) + (soLuongLKMoi+soLuongLKCu)) <= lapHoaDonDAO.soLuongNhap(maLK)) {
									int soLuong = soLuongLKMoi;
									table.setValueAt(soLuong, row, 3);

									double sl = Double.parseDouble(table.getValueAt(row, 6).toString());
									Long tt = (long) (sl*soLuong);
									table.setValueAt(tt, row, 7);
									capNhatTongTien();
									check = false;

								}
								else
									JOptionPane.showMessageDialog(null, this, "Số lượng linh kiện cần mua vượt giới hạn linh kiện trong kho!\n Nhập Số Lượng Ít Hơn "+
											(lapHoaDonDAO.soLuongNhap(maLK)-(lapHoaDonDAO.soLuongLKDaBan(maLK)+soLuongLKCu)), soLuongLKCu);
							}
							else {
								JOptionPane.showMessageDialog(null, "Số lượng phải nhập bằng số!");
								check = true;
							}
						}
					} catch (NullPointerException e2) {

					}catch (NumberFormatException e3) {
						e3.printStackTrace();
					}

				}}
		});
		popupMenu.add(mntmSoLuong);



		table.setFont(new Font("Times New Roman", Font.BOLD, 20));
		scrollPane.setViewportView(table);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		table.getColumnModel().getColumn(5).setPreferredWidth(150);
		table.getColumnModel().getColumn(7).setPreferredWidth(120);
		pTable.add(scrollPane);

		btnXoaCT = new JButton("Xóa chi tiết ");
		btnXoaCT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int r=table.getSelectedRow();
				((DefaultTableModel) modelLK).removeRow(r);
				capNhatTongTien();
				txtTienNhan.setText("");
				txtTienDu.setText("");
			}
		});

		btnXoaCT.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnXoaCT.setBounds(893, 20, 166, 31);
		pTable.add(btnXoaCT);

		lblTenLK = new JLabel("Loại linh kiện:");
		lblTenLK.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTenLK.setBounds(10, 22, 159, 26);
		pTable.add(lblTenLK);

		cboLoaiLK = new JComboBox<String>();
		cboLoaiLK.setModel(new DefaultComboBoxModel<String>(new String[] {""}));
		cboLoaiLK.setFont(new Font("Tahoma", Font.BOLD, 18));
		cboLoaiLK.setEditable(true);
		cboLoaiLK.setBounds(151, 24, 504, 26);
		pTable.add(cboLoaiLK);
		AutoCompleteDecorator.decorate(cboLoaiLK);

		btnTimLK = new JButton("Tìm kiếm");
		btnTimLK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timLk();
			}
		});
		btnTimLK.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTimLK.setBounds(681, 20, 137, 31);
		pTable.add(btnTimLK);

		lblNgayBan = new JLabel("Ngày bán:");
		lblNgayBan.setBounds(995, 53, 101, 30);
		pLapHoaDon.add(lblNgayBan);
		lblNgayBan.setFont(new Font("Tahoma", Font.BOLD, 18));

		JPanel pThongTinChung = new JPanel();
		pThongTinChung.setLayout(null);
		pThongTinChung.setBorder(new TitledBorder(null, "Th\u00F4ng tin chung", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pThongTinChung.setBackground(new Color(224, 255, 255));
		pThongTinChung.setBounds(0, 80, 1351, 180);
		pLapHoaDon.add(pThongTinChung);

		JLabel lblMaKH = new JLabel("Mã khách hàng:");
		lblMaKH.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMaKH.setBounds(10, 26, 169, 28);
		pThongTinChung.add(lblMaKH);

		JLabel lblTenKH = new JLabel("Tên khách hàng:");
		lblTenKH.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTenKH.setBounds(10, 65, 185, 28);
		pThongTinChung.add(lblTenKH);

		JLabel lblDienThoai = new JLabel("Điện thoại:");
		lblDienThoai.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDienThoai.setBounds(10, 104, 129, 28);
		pThongTinChung.add(lblDienThoai);

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSDT.setColumns(10);
		txtSDT.setBounds(149, 104, 188, 28);
		pThongTinChung.add(txtSDT);

		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDiaChi.setBounds(10, 143, 87, 28);
		pThongTinChung.add(lblDiaChi);

		JLabel lblMaNV = new JLabel("Mã nhân viên:");
		lblMaNV.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMaNV.setBounds(712, 26, 155, 28);
		pThongTinChung.add(lblMaNV);

		JLabel lblTenNV = new JLabel("Tên nhân viên:");
		lblTenNV.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTenNV.setBounds(712, 65, 155, 28);
		pThongTinChung.add(lblTenNV);

		JButton btnTim = new JButton("Tìm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timKhachHang();
			}
		});
		btnTim.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTim.setBounds(363, 105, 87, 26);
		pThongTinChung.add(btnTim);

		txtSoLuong = new JTextField();
		txtSoLuong.setEditable(false);
		DefaultCellEditor colSoLuong = new DefaultCellEditor(txtSoLuong);
		//		table.getColumnModel().getColumn(6).setCellEditor(col6);
		table.getColumnModel().getColumn(7).setCellEditor(colSoLuong);

		lblMKH = new JLabel("");
		lblMKH.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMKH.setBounds(189, 26, 280, 28);
		pThongTinChung.add(lblMKH);

		lblTKH = new JLabel("");
		lblTKH.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTKH.setBounds(189, 65, 356, 28);
		pThongTinChung.add(lblTKH);

		lblDC = new JLabel("");
		lblDC.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDC.setBounds(107, 143, 819, 28);
		pThongTinChung.add(lblDC);

		lblMNV = new JLabel("");
		lblMNV.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMNV.setBounds(856, 26, 265, 28);
		pThongTinChung.add(lblMNV);

		lblTNV = new JLabel("");
		lblTNV.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTNV.setBounds(866, 65, 332, 28);
		pThongTinChung.add(lblTNV);

		lblNB = new JLabel("");
		lblNB.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNB.setBounds(1093, 59, 244, 22);
		pLapHoaDon.add(lblNB);
		docDuLieu();
	}
	private List<String> listLK = new ArrayList<String>() ;
	private void docDuLieu() {
		String ngay= lhd_dao.getDate();
		lblNB.setText(ngay);
		lhd_dao.getLoaiLK().forEach(x->{
			if(listLK.contains(x)== false) {
				cboLoaiLK.addItem(x);
			}
		});
		String tenTK = DangNhapGUI.taiKhoan.getTaiKhoan();
		NhanVien ma = lhd_dao.getTenNV(tenTK);
		lblMNV.setText(String.valueOf(ma.getMaNV()));
		lblTNV.setText(ma.getTenNV());
	}
	//	 tìm kiếm  linh kiện khi biết tên linh kiện

	private void timLk() {
		Object Ten =cboLoaiLK.getSelectedItem().toString();
		String tim = String.valueOf(Ten);
		if (tim.equals("")) {
			JOptionPane.showMessageDialog(null, "Yêu cầu nhập loại linh kiện cần tìm kiếm","Thông báo",JOptionPane.YES_NO_OPTION);
			cboLoaiLK.requestFocus();
		} else {
			if(updateTableChiTieT(tim)==true) {
				themCTHD.setVisible(true);
				themCTHD.setLocationRelativeTo(null);
			}
		}

	}
	private void timKhachHang() {
		String sdt = txtSDT.getText().toString();
		if (kiemTraSDT()==true) {
			try {
				lblMKH.setText("");
				lblTKH.setText("");
				lblDC.setText("");
				KhachHang kh = lhd_dao.getSDT(sdt);
				if(kh!=null) {

					String ma =String.valueOf(kh.getMaKH()); 
					lblMKH.setText(ma);
					lblTKH.setText(kh.getTenKH());
					String dc = kh.getDiaChi().getSoNha()+","+ kh.getDiaChi().getTenDuong()+","+ kh.getDiaChi().getPhuongXa()+","+ kh.getDiaChi().getQuanHuyen()+","+
							kh.getDiaChi().getTinhTP()+","+kh.getDiaChi().getNuoc();
					lblDC.setText(dc);

				}else {
					Object[] choices = {"Thêm", "Không"};
					Object defaultChoice = choices[0];
					int thongbao = JOptionPane.showOptionDialog(this,
							"Số điện thoại này chưa có thông tin khách hàng",
							"Thông báo",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							null,
							choices,
							defaultChoice);

					if(thongbao==1) {
						return;

					}else {
						if(thongbao==0) {
							ThemKH them = new ThemKH();
							them.setVisible(true);
							them.setLocationRelativeTo(null);

							them.txtSDT.setText(sdt);
						}

					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			return;
		}



	}
	private boolean kiemTraSDT() {
		String sdt = txtSDT.getText().toString();
		if(sdt.equals("")) {
			JOptionPane.showConfirmDialog(this, "Bắt buộc nhập số điện thoại","Thông báo", JOptionPane.YES_NO_OPTION);
			txtSDT.requestFocus();
			txtSDT.selectAll();
			return false;
		}
		else if(!sdt.matches("[0]+[0-9]{9}")) {
			JOptionPane.showConfirmDialog(this, "Số điện thoại phải là số bắt đầu bằng 0 và theo sau là 9 kí số","Thông báo", JOptionPane.YES_NO_OPTION);
			txtSDT.requestFocus();
			txtSDT.selectAll();
			return false;
		}
		return true;
	}
	public void xoaTable() {
		themCTHD.modelCTLK.addRow(new Object[] {});
		DefaultTableModel tbl = (DefaultTableModel) themCTHD.tableCTLK.getModel();
		tbl.getDataVector().removeAllElements();
		themCTHD.cboThuongHieu.removeAllItems();
		themCTHD.cboNSX.removeAllItems();

	}
	private boolean updateTableChiTieT(String tim) {
		ArrayList<LinhKien> list = lhd_dao.getTimTheoTen(tim);
		if(list!=null) {


			xoaTable();

			themCTHD.lblTenLk.setText("Linh kiện: "+ cboLoaiLK.getSelectedItem());
			int d=0;
			for (LinhKien linhKien : list) {

				themCTHD.modelCTLK.addRow(new Object[] {d++,linhKien.getMaLK(),linhKien.getTenLK(),linhKien.getSoLuong(),
						linhKien.getDonViTinh(),linhKien.getGiaNhap(),linhKien.getBaoHanh(),linhKien.getNgayNhap(),
						linhKien.getThuongHieu()
						,linhKien.getNuocSX(),linhKien.getThongSoKT(),linhKien.getMauSac(),
						linhKien.getTinhTrang(),linhKien.getNcc().getTenNCC(),
						linhKien.getLoaiLK().getTenLoai()});



			}
			lhd_dao.getThuongHieu(tim).forEach(x->{
				if(listTT.contains(x)== false) {
					themCTHD.cboThuongHieu.addItem(x);
				}
			});
			lhd_dao.getNuocSX(tim).forEach(x->{
				if(listTT.contains(x)== false) {
					themCTHD.cboNSX.addItem(x);
				}
			}); 
			return true;
		}else {
			JOptionPane.showConfirmDialog(null, "Tên linh kiện không tồn tại");
			cboLoaiLK.requestFocus();
			return false;
		}


	}
	public static void danhSachLKTheoMaLK(int maLK) {
		if(lapHoaDonDAO.soLuongLKDaBan(maLK) > lapHoaDonDAO.soLuongNhap(maLK)) {
			JOptionPane.showMessageDialog(null, "Linh kiện đã tạm hết trong kho ! \n Vui lòng chọn linh kiện khác");
		}
		else {
			try {
				LinhKien lk = new LinhKien();
				lk = lapHoaDonDAO.LKTheoMa(maLK);


				if(lk != null) {
					int ma = lk.getMaLK();
					String tenLK= lk.getTenLK();
					String baoHanh= lk.getBaoHanh();
					String thuongHieu = lk.getThuongHieu();
					String donGia = lk.getGiaNhap() + "";
					double dg = Double.parseDouble(donGia)*0.1+Double.parseDouble(donGia);
					double thanhTien = Integer.parseInt(txtSoLuong.getText()) * dg;
					long tien = (long) thanhTien;
					int i =0;
					((DefaultTableModel) modelLK).addRow(new Object[] {
							++i,ma,tenLK,txtSoLuong.getText(),baoHanh,thuongHieu,dg,tien
					});
					capNhatTongTien();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}
	private List<String> listTT= new ArrayList<String>();
	private List<String> listNsx= new ArrayList<String>();
	public void lamMoi() {
		lblMKH.setText("");
		lblTKH.setText("");
		lblDC.setText("");
		lblTKH.setText("");
		txtSDT.setText("");
		txtTongTien.setText("");
		txtThanhToan.setText("");
		txtTienNhan.setText("");
		txtTienDu.setText("");
		cboLoaiLK.setSelectedItem("");
		xoaTableLk();
		String ngay= lhd_dao.getDate();
		lblNB.setText(ngay);


	}
	public void xoaTableLk() {
		((DefaultTableModel) modelLK).addRow(new Object[] {});
		DefaultTableModel tbl = (DefaultTableModel) table.getModel();
		tbl.getDataVector().removeAllElements();


	}
	private static Long tongThanhToan;

	private static void capNhatTongTien() {
		DecimalFormat tien = new DecimalFormat("#,##0.00");
		int soLuong=0;
		double donGia=0;
		double thanhTien=0 ;

		Long tongTien =(long) 0;

		List<Vector> data = ((DefaultTableModel) modelLK).getDataVector();
		Object[] list1 = data.toArray();
		for(int k=0;k<list1.length;k++) {
			Long tong =Long.parseLong(modelLK.getValueAt(k, 7).toString());
			tongTien += tong;
		}
		//		txtTongTien.setText(String.valueOf(tongTien));
		txtTongTien.setText(tien.format(tongTien)+" VNĐ");
		tongThanhToan = (long) (tongTien + (tongTien*(0.05)));

		txtThanhToan.setText(tien.format(tongThanhToan)+" VNĐ");
	}
	public static int ma;
	public static String mahd = String.valueOf(ma);

	private void luuHoaDon() {
		if(kiemTraThongTinLuu()==true) {
			String ngaylap =lblNB.getText().toString();
			String maNV = lblMNV.getText().toString();
			String maKH = lblMKH.getText().toString();
			lhd_dao.addHoaDon(ngaylap,tongThanhToan,Integer.parseInt(maNV),Integer.parseInt(maKH));
			ma =lhd_dao.getMaHD(ngaylap,tongThanhToan,Integer.parseInt(maNV),Integer.parseInt(maKH));
			CTHoaDon ctHoaDon = new CTHoaDon();
			ArrayList<CTHoaDon> listCT_HD = new ArrayList<CTHoaDon>();
			List data = ((DefaultTableModel) modelLK).getDataVector();
			Object[] list1 = data.toArray();
			for(int k=0;k<list1.length;k++) {
				try {


					double donGia =Double.parseDouble(modelLK.getValueAt(k, 6).toString());

					HoaDon hoaDon= new HoaDon(ma);
					String sl = modelLK.getValueAt(k,3).toString();
					int soLuong= Integer.parseInt(sl);
					String m=modelLK.getValueAt(k,1).toString();
					int ma = Integer.parseInt(m);
					LinhKien linhKien= new LinhKien(ma) ;

					ctHoaDon = new CTHoaDon(linhKien, hoaDon, soLuong, (long) donGia);
					listCT_HD.add(ctHoaDon);


				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			for(CTHoaDon hoaDon: listCT_HD) {
				lhd_dao.addCT_HoaDon(hoaDon.getLinhKien().getMaLK(), hoaDon.getDonGia(), hoaDon.getHoaDon().getMaHD(), hoaDon.getSoLuong());
			}
			JOptionPane.showConfirmDialog(this, "Lưu hóa đơn thành công!!!");
			System.out.println(" Them hoa don thanh cong hoa don: "+ mahd);
			lamMoi();
		}

	}

	private boolean kiemTraThongTinLuu() {



		if(lblMKH.getText().equalsIgnoreCase("")) {
			JOptionPane.showConfirmDialog(this, "Yêu cầu nhập số điện thoại và tìm");
			txtSDT.requestFocus();
			return false;
		}
		else if(txtTongTien.getText().equalsIgnoreCase("")) {
			JOptionPane.showConfirmDialog(this, "Yêu cầu chọn sản phẩm cần mua");
			cboLoaiLK.requestFocus();
			return false;
		}
		return true;
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
