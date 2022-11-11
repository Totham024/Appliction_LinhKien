package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.MutableComboBoxModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import connectDB.ConnectDB;
import dao.LinhKienDAO;
import entity.LinhKien;

import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LinhKienGUI extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JComboBox cboNCC;
	public static  JPanel contentPane;
	private JTextField txtMaLK;
	private JTextField txtTenLK;
	private JTextField txtNgayNhap;
	private JTextField txtGiaNhap;
	private JTextField txtSoLuong;
	private JTextField txtBaoHanh;
	private JTextField txtNuocSX;
	private JTextField txtMauSac;
	private JTextField txtTinhTrang;
	private DefaultTableModel modelLK;
	private JTable tableLK;
	private String filename = null;
	private byte[] imageLK;
	private LinhKienDAO lk_dao;
	private JComboBox cboDVT;
	private JLabel lblMaLK;
	private JLabel lblTenLK;
	private JLabel lblNgayNhap;
	private JLabel lblGiaNhap;
	private JLabel lblSoLuong;
	private JLabel lblDonViTinh;
	private JLabel lblBaoHanh;
	private JLabel lblThuongHieu;
	private JLabel lblNuocSX;
	private JLabel lblMauSac;
	private JLabel lblTinhTrang;
	private JLabel lblThongSoKT;
	private JTextArea txtAreaThongSo;
	private JLabel lblHinh;
	private JLabel lblHinhAnh;
	private JButton btnChonHinh;
	private JLabel lblNhaCungCap;
	private JButton btnThemNCC;
	private JComboBox cboThuongHieu;
	private JLabel lblThongTin;
	private JRadioButton rdbtnLoaiLK;
	private JRadioButton rdbtnTenLK;
	private JRadioButton rdbtnNCC;
	private JRadioButton rdbtnThuongHieu;
	private JButton btnTimKiem;
	private JButton btnThoat;
	private JButton btnLamMoi;
	private JButton btnThem;
	private JButton btnCapNhat;
	private JButton btnXoa;
	private JComboBox cboTim;
	public static JComboBox cboLoaiLK;
	private DefaultComboBoxModel cboModeTenLK= new DefaultComboBoxModel();
	private DefaultComboBoxModel cboModeThuongHieu= new DefaultComboBoxModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LinhKienGUI frame = new LinhKienGUI();
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
	public LinhKienGUI() {
		ConnectDB.getInstance().connect();
		lk_dao = new LinhKienDAO();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400,800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		setContentPane(contentPane);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("QUẢN LÝ LINH KIỆN");
		lblTitle.setForeground(new Color(255, 0, 0));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTitle.setBounds(495, 34, 357, 42);
		contentPane.add(lblTitle);

		JPanel pThongTinLK = new JPanel();
		pThongTinLK.setBackground(new Color(224, 255, 255));
		pThongTinLK.setBorder(new TitledBorder(null, "Th\u00F4ng tin linh ki\u1EC7n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pThongTinLK.setBounds(10, 73, 1350, 487);
		contentPane.add(pThongTinLK);
		pThongTinLK.setLayout(null);

		lblMaLK = new JLabel("Mã linh kiện");
		lblMaLK.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaLK.setBounds(10, 25, 106, 26);
		pThongTinLK.add(lblMaLK);

		txtMaLK = new JTextField();
		txtMaLK.setEditable(false);
		txtMaLK.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtMaLK.setBounds(126, 25, 218, 26);
		pThongTinLK.add(txtMaLK);
		txtMaLK.setColumns(10);

		lblTenLK = new JLabel("Tên linh kiện");
		lblTenLK.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTenLK.setBounds(10, 62, 106, 26);
		pThongTinLK.add(lblTenLK);

		txtTenLK = new JTextField();
		txtTenLK.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtTenLK.setBounds(126, 62, 218, 26);
		pThongTinLK.add(txtTenLK);
		txtTenLK.setColumns(10);

		lblNgayNhap = new JLabel("Ngày nhập");
		lblNgayNhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNgayNhap.setBounds(10, 99, 106, 26);
		pThongTinLK.add(lblNgayNhap);

		txtNgayNhap = new JTextField();
		txtNgayNhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtNgayNhap.setEditable(false);
		txtNgayNhap.setBounds(126, 99, 218, 26);
		pThongTinLK.add(txtNgayNhap);
		txtNgayNhap.setColumns(10);

		lblGiaNhap = new JLabel("Giá nhập");
		lblGiaNhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGiaNhap.setBounds(392, 25, 83, 26);
		pThongTinLK.add(lblGiaNhap);

		txtGiaNhap = new JTextField();
		txtGiaNhap.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!((e.getKeyChar() >= 48 && e.getKeyChar() <= 57) || e.getKeyChar() == 8)) {
					e.consume();
				}
			}
		});
		txtGiaNhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtGiaNhap.setBounds(526, 27, 258, 26);
		pThongTinLK.add(txtGiaNhap);
		txtGiaNhap.setColumns(10);

		lblSoLuong = new JLabel("Số lượng");
		lblSoLuong.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSoLuong.setBounds(10, 137, 106, 26);
		pThongTinLK.add(lblSoLuong);

		txtSoLuong = new JTextField();
		txtSoLuong.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!((e.getKeyChar() >= 48 && e.getKeyChar() <= 57) || e.getKeyChar() == 8)) {
					e.consume();
				}
			}
		});
		txtSoLuong.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtSoLuong.setBounds(126, 136, 111, 26);
		pThongTinLK.add(txtSoLuong);
		txtSoLuong.setColumns(10);

		lblDonViTinh = new JLabel("Đơn vị tính");
		lblDonViTinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDonViTinh.setBounds(10, 174, 106, 26);
		pThongTinLK.add(lblDonViTinh);

		lblBaoHanh = new JLabel("Bảo hành");
		lblBaoHanh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBaoHanh.setBounds(394, 137, 81, 26);
		pThongTinLK.add(lblBaoHanh);

		txtBaoHanh = new JTextField();
		txtBaoHanh.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBaoHanh.setBounds(526, 138, 258, 26);
		pThongTinLK.add(txtBaoHanh);
		txtBaoHanh.setColumns(10);

		lblThuongHieu = new JLabel("Thương hiệu");
		lblThuongHieu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThuongHieu.setBounds(392, 99, 107, 26);
		pThongTinLK.add(lblThuongHieu);

		lblNuocSX = new JLabel("Nước sản xuất");
		lblNuocSX.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNuocSX.setBounds(10, 211, 118, 26);
		pThongTinLK.add(lblNuocSX);

		txtNuocSX = new JTextField();
		txtNuocSX.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtNuocSX.setBounds(126, 211, 218, 26);
		pThongTinLK.add(txtNuocSX);
		txtNuocSX.setColumns(10);

		lblMauSac = new JLabel("Màu sắc");
		lblMauSac.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMauSac.setBounds(394, 174, 108, 26);
		pThongTinLK.add(lblMauSac);

		txtMauSac = new JTextField();
		txtMauSac.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtMauSac.setBounds(526, 176, 258, 26);
		pThongTinLK.add(txtMauSac);
		txtMauSac.setColumns(10);

		lblTinhTrang = new JLabel("Tình trạng");
		lblTinhTrang.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTinhTrang.setBounds(394, 211, 106, 26);
		pThongTinLK.add(lblTinhTrang);

		txtTinhTrang = new JTextField();
		txtTinhTrang.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtTinhTrang.setBounds(526, 213, 258, 26);
		pThongTinLK.add(txtTinhTrang);
		txtTinhTrang.setColumns(10);

		lblThongSoKT = new JLabel("Thông số kỹ thuật");
		lblThongSoKT.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThongSoKT.setBounds(863, 27, 151, 26);
		pThongTinLK.add(lblThongSoKT);

		txtAreaThongSo = new JTextArea();
		txtAreaThongSo.setLineWrap(true);
		txtAreaThongSo.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtAreaThongSo.setBounds(1024, 25, 301, 42);
		pThongTinLK.add(txtAreaThongSo);

		lblHinh = new JLabel("Hình ảnh");
		lblHinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHinh.setBounds(863, 115, 118, 27);
		pThongTinLK.add(lblHinh);

		lblHinhAnh = new JLabel("");
		lblHinhAnh.setHorizontalAlignment(SwingConstants.CENTER);
		lblHinhAnh.setBounds(907, 153, 402, 128);
		pThongTinLK.add(lblHinhAnh);

		btnChonHinh = new JButton("Chọn hình");
		btnChonHinh.addActionListener(new ActionListener() {
			private FileInputStream fis;

			public void actionPerformed(ActionEvent arg0) {
				JFileChooser ch = new JFileChooser();
				ch.showOpenDialog(null);
				File f= ch.getSelectedFile();
				filename =f.getAbsolutePath();
				ImageIcon imageIcon= new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(lblHinhAnh.getWidth(), lblHinhAnh.getHeight(), Image.SCALE_SMOOTH));
				lblHinhAnh.setIcon(imageIcon);
				try {
					File image=new File(filename);
					FileInputStream fis = new FileInputStream(image);
					ByteArrayOutputStream bos = new ByteArrayOutputStream();
					byte[] b = new byte[2014];
					for(int readNum; (readNum = fis.read(b)) != -1;) {
						bos.write(b, 0, readNum);
					}
					imageLK= bos.toByteArray();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnChonHinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnChonHinh.setBounds(991, 115, 118, 26);
		pThongTinLK.add(btnChonHinh);

		lblNhaCungCap = new JLabel("Nhà cung cấp");
		lblNhaCungCap.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNhaCungCap.setBounds(392, 62, 129, 26);
		pThongTinLK.add(lblNhaCungCap);

		btnThemNCC = new JButton("");
		btnThemNCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemNCCGUI ncc = new ThemNCCGUI();
				ncc.setVisible(true);
			}
		});
		btnThemNCC.setIcon(new ImageIcon("D:\\HK1-2020\\LinhKienProject\\Picture\\add.png"));
		btnThemNCC.setBounds(774, 61, 30, 27);
		pThongTinLK.add(btnThemNCC);

		cboNCC = new JComboBox();
		cboNCC.setFont(new Font("Tahoma", Font.BOLD, 15));
		cboNCC.setModel(new DefaultComboBoxModel(new String[] {""}));
		cboNCC.setBounds(526, 62, 218, 26);
		pThongTinLK.add(cboNCC);

		cboDVT = new JComboBox();
		cboDVT.setFont(new Font("Tahoma", Font.BOLD, 15));
		cboDVT.setModel(new DefaultComboBoxModel(new String[] {""}));
		cboDVT.setBounds(126, 173, 191, 27);
		AutoCompleteDecorator.decorate(cboDVT);
		pThongTinLK.add(cboDVT);

		cboThuongHieu = new JComboBox();
		cboThuongHieu.setFont(new Font("Tahoma", Font.BOLD, 15));
		cboThuongHieu.setModel(new DefaultComboBoxModel(new String[] {""}));
		cboThuongHieu.setBounds(526, 104, 218, 23);
		pThongTinLK.add(cboThuongHieu);

		JLabel lblLoaiLK = new JLabel("Loại linh kiện");
		lblLoaiLK.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLoaiLK.setBounds(863, 78, 118, 26);
		pThongTinLK.add(lblLoaiLK);

		cboLoaiLK = new JComboBox();
		cboLoaiLK.setModel(new DefaultComboBoxModel(new String[] {""}));
		cboLoaiLK.setFont(new Font("Tahoma", Font.BOLD, 15));
		cboLoaiLK.setBounds(1024, 77, 230, 28);
		pThongTinLK.add(cboLoaiLK);

		JButton btnThemDVT = new JButton("");
		btnThemDVT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String moi = JOptionPane.showInputDialog("Thêm đơn vị tính",null );
				cboDVT.setSelectedItem(moi);
			}
		});
		btnThemDVT.setIcon(new ImageIcon("D:\\HK1-2020\\LinhKienProject\\Picture\\add.png"));
		btnThemDVT.setBounds(327, 174, 30, 27);
		pThongTinLK.add(btnThemDVT);

		JButton btnThemLoai = new JButton("");
		btnThemLoai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ThemLoaiLKGUI loaiLK = new ThemLoaiLKGUI();
				loaiLK.pack();
				Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
				loaiLK.setSize(300, 200);
				loaiLK.setLocationRelativeTo(null);
				loaiLK.setVisible(true);

			}
		});
		btnThemLoai.setIcon(new ImageIcon("D:\\HK1-2020\\LinhKienProject\\Picture\\add.png"));
		btnThemLoai.setBounds(1266, 77, 30, 27);
		pThongTinLK.add(btnThemLoai);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 292, 1330, 189);
		pThongTinLK.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		String[] tb = new String[] {"STT", "Mã linh kiện", "Tên linh kiện","Số lượng", "Đơn vị tính", "Giá nhập","Bảo hành",
				"Ngày nhập","Thương hiệu","Nước sản xuất","Thông số kỹ thuật"," Màu sắc ","Tình trạng","Nhà cung cấp","Loại linh kiện"};
		modelLK = new DefaultTableModel(tb, 0);
		tableLK  = new JTable(modelLK);
		tableLK.getColumnModel().getColumn(0).setPreferredWidth(120);
		tableLK.getColumnModel().getColumn(1).setPreferredWidth(120);
		tableLK.getColumnModel().getColumn(2).setPreferredWidth(490);
		tableLK.getColumnModel().getColumn(3).setPreferredWidth(120);
		tableLK.getColumnModel().getColumn(4).setPreferredWidth(120);
		tableLK.getColumnModel().getColumn(5).setPreferredWidth(120);
		tableLK.getColumnModel().getColumn(6).setPreferredWidth(120);
		tableLK.getColumnModel().getColumn(7).setPreferredWidth(120);
		tableLK.getColumnModel().getColumn(8).setPreferredWidth(120);
		tableLK.getColumnModel().getColumn(9).setPreferredWidth(120);
		tableLK.getColumnModel().getColumn(10).setPreferredWidth(400);
		tableLK.getColumnModel().getColumn(11).setPreferredWidth(120);
		tableLK.getColumnModel().getColumn(12).setPreferredWidth(120);
		tableLK.getColumnModel().getColumn(13).setPreferredWidth(200);
		tableLK.getColumnModel().getColumn(14).setPreferredWidth(180);
		tableLK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				int row;
				row = tableLK.getSelectedRow();
				txtMaLK.setText(modelLK.getValueAt(row, 1).toString());
				txtTenLK.setText(modelLK.getValueAt(row, 2).toString());
				txtSoLuong.setText(modelLK.getValueAt(row, 3).toString());
				cboDVT.setSelectedItem(modelLK.getValueAt(row, 4).toString());
				txtGiaNhap.setText(modelLK.getValueAt(row, 5).toString());
				txtBaoHanh.setText(modelLK.getValueAt(row, 6).toString());
				txtNgayNhap.setText(modelLK.getValueAt(row, 7).toString());
				cboThuongHieu.setSelectedItem(modelLK.getValueAt(row, 8).toString());
				txtNuocSX.setText(modelLK.getValueAt(row, 9).toString());
				txtAreaThongSo.setText(modelLK.getValueAt(row, 10).toString());
				txtMauSac.setText(modelLK.getValueAt(row, 11).toString());
				txtTinhTrang.setText(modelLK.getValueAt(row, 12).toString());
				cboNCC.setSelectedItem(modelLK.getValueAt(row, 13).toString());
				cboLoaiLK.setSelectedItem(modelLK.getValueAt(row, 14).toString());
				try {
					byte[] img=lk_dao.getAllLK().get(row).getHinhAnh();
					if(img!=null) {
						ImageIcon ima=new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblHinhAnh.getWidth(), lblHinhAnh.getHeight(), Image.SCALE_SMOOTH));
						lblHinhAnh.setIcon(ima);
						imageLK=img;
					}
					else {
						lblHinhAnh.setIcon(null);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		tableLK.setFont(new Font("Times New Roman", Font.BOLD, 20));
		scrollPane.setViewportView(tableLK);
		tableLK.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		DocDuLieuVaoJtable();
		btnThemThuongHieu = new JButton("");
		btnThemThuongHieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String moi = JOptionPane.showInputDialog("Thêm thương hiệu",null);
				cboThuongHieu.setSelectedItem(moi);
			}
		});
		btnThemThuongHieu.setIcon(new ImageIcon("D:\\HK1-2020\\LinhKienProject\\Picture\\add.png"));
		btnThemThuongHieu.setBounds(774, 103, 30, 27);
		pThongTinLK.add(btnThemThuongHieu);

		txtMessage = new JTextField();
		txtMessage.setHorizontalAlignment(SwingConstants.CENTER);
		txtMessage.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtMessage.setForeground(Color.RED);
		txtMessage.setEditable(false);
		txtMessage.setBounds(10, 248, 885, 27);
		pThongTinLK.add(txtMessage);
		txtMessage.setColumns(10);



		JPanel pChucNang = new JPanel();
		pChucNang.setBackground(new Color(224, 255, 255));
		pChucNang.setBounds(10, 560, 1350, 129);
		contentPane.add(pChucNang);
		pChucNang.setLayout(null);

		lblThongTin = new JLabel("Nhập thông tin tìm kiếm");
		lblThongTin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThongTin.setBounds(10, 44, 262, 31);
		pChucNang.add(lblThongTin);

		rdbtnLoaiLK = new JRadioButton("Tên loại linh kiện");
		rdbtnLoaiLK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				cboTim.setModel(cboModeLoaiLK);
			}
		});
		rdbtnLoaiLK.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnLoaiLK.setBounds(127, 16, 213, 23);
		pChucNang.add(rdbtnLoaiLK);

		rdbtnTenLK = new JRadioButton("Tên linh kiện");
		rdbtnTenLK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cboTim.setModel(cboModeTenLK);
			}
		});
		rdbtnTenLK.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnTenLK.setBounds(365, 16, 166, 23);
		pChucNang.add(rdbtnTenLK);

		rdbtnNCC = new JRadioButton("Nhà cung cấp");
		rdbtnNCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cboTim.setModel(cboModeNCC);
			}
		});
		rdbtnNCC.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnNCC.setBounds(575, 16, 160, 23);
		pChucNang.add(rdbtnNCC);

		rdbtnThuongHieu = new JRadioButton("Thương hiệu");
		rdbtnThuongHieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cboTim.setModel(cboModeThuongHieu);
			}
		});
		rdbtnThuongHieu.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnThuongHieu.setBounds(765, 16, 166, 23);
		pChucNang.add(rdbtnThuongHieu);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				timKiem();
			}
		});
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTimKiem.setBounds(947, 45, 148, 31);
		pChucNang.add(btnTimKiem);

		btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManHinhChinhGUI.tabbedPane.remove(contentPane);

			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnThoat.setBounds(1163, 87, 113, 34);
		pChucNang.add(btnThoat);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lamMoi();

			}
		});
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLamMoi.setBounds(661, 85, 121, 36);
		pChucNang.add(btnLamMoi);

		btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				String tenLK =txtTenLK.getText().toString();
				String sl =txtSoLuong.getText().toString();
				String dvt =(String) cboDVT.getSelectedItem().toString();
				String nuocSX =txtNuocSX.getText().toString();
				String giaNhap =txtGiaNhap.getText().toString();

				String thuongHieu =(String) cboThuongHieu.getSelectedItem().toString();
				String baoHanh =txtBaoHanh.getText().toString();
				String mauSac =txtMauSac.getText().toString();
				String tinhTrang =txtTinhTrang.getText().toString();
				String thongSo =txtAreaThongSo.getText().toString();
				String ncc =(String) cboNCC.getSelectedItem().toString();
				String loaiLK =(String) cboLoaiLK.getSelectedItem().toString();
				String ngayNhap = txtNgayNhap.getText().toString();
				try {
					if(kiemTraRangBuoc()==true) {
						//					lk_dao.themLK(tenLK, Integer.parseInt(sl),Long.parseLong(giaNhap), dvt,  baoHanh, ngayNhap, thuongHieu, nuocSX, thongSo, mauSac, imageLK, tinhTrang, lk_dao.getmaNCC(ncc),(lk_dao.getmaLoai(loaiLK)));
						System.out.println("Thêm linh kiện thành công!!!");

						JOptionPane.showConfirmDialog(null, "Thêm linh kiện thành công");
						lamMoi();
					}
				}catch(Exception e) {
					JOptionPane.showConfirmDialog(null, "Linh kiện chưa được thêm");
					e.printStackTrace();
				}
				
			}

			private void showMessage(String string, JLabel txt) {
				txt.requestFocus();
				txtMessage.setText(string);

			}
		});
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnThem.setBounds(151, 86, 101, 36);
		pChucNang.add(btnThem);

		JLabel lblNewLabel = new JLabel("Tìm theo:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(20, 11, 101, 32);
		pChucNang.add(lblNewLabel);

		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ma = txtMaLK.getText().toString();
				String tenLK =txtTenLK.getText().toString();
				String sl =txtSoLuong.getText().toString();
				String dvt =(String) cboDVT.getSelectedItem().toString();
				String nuocSX =txtNuocSX.getText().toString();
				String giaNhap =txtGiaNhap.getText().toString();

				String thuongHieu =(String) cboThuongHieu.getSelectedItem().toString();
				String baoHanh =txtBaoHanh.getText().toString();
				String mauSac =txtMauSac.getText().toString();
				String tinhTrang =txtTinhTrang.getText().toString();
				String thongSo =txtAreaThongSo.getText().toString();
				String ncc =(String) cboNCC.getSelectedItem().toString();
				String loaiLK =(String) cboLoaiLK.getSelectedItem().toString();
				String ngayNhap = txtNgayNhap.getText().toString();
				if(kiemTraRangBuoc()==true) {
					lk_dao.capNhat(Integer.parseInt(ma),tenLK, Integer.parseInt(sl),Long.parseLong(giaNhap), dvt,  baoHanh, ngayNhap, thuongHieu, nuocSX, thongSo, mauSac, imageLK, tinhTrang, lk_dao.getmaNCC(ncc),lk_dao.getmaLoai(loaiLK));
					System.out.println("Cập nhật thành công!!!");
					JOptionPane.showConfirmDialog(null, "Cập nhật thành công");
					lamMoi();
				}else {
					return;
				}
				
			}
		});
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCapNhat.setBounds(306, 87, 130, 34);
		pChucNang.add(btnCapNhat);

		btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String maLK = txtMaLK.getText().toString();
				lk_dao.xoa(maLK);
				System.out.println("Xóa thành công:"+ maLK);
				JOptionPane.showConfirmDialog(null, "Xóa thành công");
				lamMoi();
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnXoa.setBounds(484, 87, 113, 34);
		pChucNang.add(btnXoa);
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnLoaiLK);
		group.add(rdbtnNCC);
		group.add(rdbtnTenLK);
		group.add(rdbtnThuongHieu);
		cboTim = new JComboBox();
		cboTim.setEditable(true);
		cboTim.setFont(new Font("Tahoma", Font.BOLD, 15));
		cboTim.setBounds(282, 46, 629, 31);
		pChucNang.add(cboTim);
		AutoCompleteDecorator.decorate(cboThuongHieu);
		AutoCompleteDecorator.decorate(cboLoaiLK);
		AutoCompleteDecorator.decorate(cboNCC);
		AutoCompleteDecorator.decorate(cboTim);

	}
	public void lamMoi() {
		txtMaLK.setText("");
		txtTenLK.setText("");
		txtSoLuong.setText("");

		txtNuocSX.setText("");
		txtGiaNhap.setText("");

		txtBaoHanh.setText("");
		txtMauSac.setText("");
		txtTinhTrang.setText("");
		txtAreaThongSo.setText("");

		lblHinhAnh.setText("");
		xoaTable();
		cboLoaiLK.setSelectedItem("");
		cboNCC.setSelectedItem("");
		cboThuongHieu.setSelectedItem("");
		cboDVT.setSelectedItem(" ");
		lblHinhAnh.setIcon(null);
		DocDuLieuVaoJtable();
	}
	private DefaultComboBoxModel cboModeNCC= new DefaultComboBoxModel();
	private DefaultComboBoxModel cboModeLoaiLK= new DefaultComboBoxModel();
	private List<String> listDVT = new ArrayList<String>();
	private List<String> listThuongHieu = new ArrayList<String>();
	private List<String> listTimThuongHieu = new ArrayList<String>();
	private List<String> listTenLK = new ArrayList<String>();
	private ArrayList<String> listTimNCC = new ArrayList<String>() ;
	private ArrayList<String> listLoaiLK = new ArrayList<String>() ;
	private JButton btnThemThuongHieu;
	private JTextField txtMessage;
	private void DocDuLieuVaoJtable() {
		ArrayList<LinhKien> listLK = lk_dao.getAllLK();
		int d=0;
		for (LinhKien linhKien : listLK) {
			modelLK.addRow(new Object[] {d++,linhKien.getMaLK(),linhKien.getTenLK(),linhKien.getSoLuong(),
					linhKien.getDonViTinh(),linhKien.getGiaNhap(),linhKien.getBaoHanh(),linhKien.getNgayNhap(),
					linhKien.getThuongHieu()
					,linhKien.getNuocSX(),linhKien.getThongSoKT(),linhKien.getMauSac(),
					linhKien.getTinhTrang(),linhKien.getNcc().getTenNCC(),
					linhKien.getLoaiLK().getTenLoai()});

//			if(listDVT.contains(linhKien.getDonViTinh())==false) {
//				cboDVT.addItem(linhKien.getDonViTinh());
//			}
//			if(listThuongHieu.contains(String.valueOf(linhKien.getThuongHieu()))==false) {
//				cboThuongHieu.addItem(linhKien.getThuongHieu());
//			}
//			if(listThuongHieu.contains(String.valueOf(linhKien.getThuongHieu()))==false) {
//				cboModeThuongHieu.addElement(linhKien.getThuongHieu());
//				listThuongHieu.add(linhKien.getThuongHieu());
//			}
			if(listTenLK.contains(String.valueOf(linhKien.getTenLK()))==false) {
				cboModeTenLK.addElement(linhKien.getTenLK());
				listTenLK.add(String.valueOf(linhKien.getTenLK()));
			}
			

		}
		lk_dao.getDVT().forEach(x->{
			if(listDVT.contains(x)==false) {
				cboDVT.addItem(x);
			}
		});;
		lk_dao.getTH().forEach(x->{
			if(listThuongHieu.contains(x)==false) {
				cboThuongHieu.addItem(x);
				cboModeThuongHieu.addElement(x);
			}
		});;
		lk_dao.getNCC().forEach(s->{
			if(listTimNCC.contains(s)==false) {
				cboNCC.addItem(s);
			}
			if(listTimNCC.contains(s)==false) {
				cboModeNCC.addElement(s);
				listTimNCC.add(s);
			}
			
		});
		
		lk_dao.getLoaiLK().forEach(s->{
			if(listLoaiLK.contains(s)==false) {
				cboLoaiLK.addItem(s);
			}
			if(listLoaiLK.contains(s)==false) {
				cboModeLoaiLK.addElement(s);
				listLoaiLK.add(s);
			}
		});
		String t= lk_dao.getDate();
		txtNgayNhap.setText(t);

	}
	public void xoaTable() {
		modelLK.addRow(new Object[] {});
		DefaultTableModel tbl = (DefaultTableModel) tableLK.getModel();
		tbl.getDataVector().removeAllElements();
		cboDVT.removeAllItems();
		cboLoaiLK.removeAllItems();
		cboThuongHieu.removeAllItems();
		cboNCC.removeAllItems();
	}
	public boolean kiemTraRangBuoc() {

		String tenLK =txtTenLK.getText().toString().trim();
		String sl =txtSoLuong.getText().toString().trim();
		String dvt =((String) cboDVT.getSelectedItem()).trim();
		String nuocSX =txtNuocSX.getText().toString().trim();
		String giaNhap =txtGiaNhap.getText().toString();

		String thuongHieu =((String) cboThuongHieu.getSelectedItem()).trim();
		String baoHanh =txtBaoHanh.getText().toString().trim();
		String mauSac =txtMauSac.getText().toString().trim();
		String tinhTrang =txtTinhTrang.getText().toString().trim();
		String thongSo =txtAreaThongSo.getText().toString().trim();
		String ncc =((String) cboNCC.getSelectedItem()).trim();
		String loaiLK =((String) cboLoaiLK.getSelectedItem()).trim();
		String ngayNhap = txtNgayNhap.getText().toString().trim();
		if(!(tenLK.length()>0)) {
			showMessage("Bắt buộc nhập tên linh kiện ", txtTenLK);
			return false;
		}
		else if(sl.equals("") && !sl.matches("[0-9]{1,7}")) {
			showMessage("Bắt buộc nhập số lượng ", txtSoLuong);
			return false;
		}
		else if(nuocSX.equals("")) {
			showMessage("Bắt buộc nhập nước sản xuất ", txtNuocSX);
			return false;
		}
		else if(giaNhap.equals("")) {
			showMessage("Bắt buộc nhập giá ", txtGiaNhap);
			return false;
		}
		else if(!giaNhap.matches("^\\d{1,15}")) {
			showMessage(" Giá nhập không vượt quá 15 ký số và không có các kí tự đặc biệt (.,?/!~`)", txtGiaNhap);
			return false;
		}
		else if(thuongHieu.equals("")) {
			showMessage("Bắt buộc thương hiệu ", cboThuongHieu);
			return false;
		}
		showMessage("", txtMessage);
		return true;

	}
	private void showMessage(String message, JComboBox cbo) {
		cbo.getSelectedItem();
		txtMessage.setText(message);
		
	}

	private void showMessage(String message, JTextField txt) {
		txt.requestFocus();
		txtMessage.setText(message);

	}
	public void timKiem() {
		lamMoi();
		String tim=cboTim.getSelectedItem().toString();
		if(tim.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Không được rỗng");
			return; 
		}
		//		if (rdbtnLoaiLK.isSelected() == false && rdbtnThuongHieu.isSelected() == false && rdbtnNCC.isSelected() == false && rdbtnTenLK.isSelected() == false && cboTim.getSelectedItem().toString().trim().equals("")) {
		//			JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin và chọn loại tìm kiếm !");
		//		} else if (cboTim.getSelectedItem().toString().trim().equals("")) {
		//			JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin tìm kiếm !");
		//		} else if (rdbtnLoaiLK.isSelected() == false && rdbtnThuongHieu.isSelected() == false && rdbtnNCC.isSelected() == false && rdbtnTenLK.isSelected() == false ) {
		//			JOptionPane.showMessageDialog(null, "Vui lòng chọn loại tìm kiếm !");
		//		} else {
		int d=1;

		if (rdbtnLoaiLK.isSelected()) {
			xoaTable();
			List<LinhKien> lk;
			try {
				lk = lk_dao.getLinhKienByLoai(tim);
				for (LinhKien  linhKien: lk) {
					modelLK.addRow(new Object[] {d++,linhKien.getMaLK(),linhKien.getTenLK(),linhKien.getSoLuong(),
							linhKien.getDonViTinh(),linhKien.getGiaNhap(),linhKien.getBaoHanh(),linhKien.getNgayNhap(),
							linhKien.getThuongHieu()
							,linhKien.getNuocSX(),linhKien.getThongSoKT(),linhKien.getMauSac(),
							linhKien.getTinhTrang(),linhKien.getNcc().getTenNCC(),
							linhKien.getLoaiLK().getTenLoai()});
				}
				System.out.println(lk);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else if (rdbtnThuongHieu.isSelected()) {
			xoaTable();
			List<LinhKien> lk;
			try {
				lk = lk_dao.getLinhKienByThuongHieu(tim);
				for (LinhKien  linhKien: lk) {
					modelLK.addRow(new Object[] {d++,linhKien.getMaLK(),linhKien.getTenLK(),linhKien.getSoLuong(),
							linhKien.getDonViTinh(),linhKien.getGiaNhap(),linhKien.getBaoHanh(),linhKien.getNgayNhap(),
							linhKien.getThuongHieu()
							,linhKien.getNuocSX(),linhKien.getThongSoKT(),linhKien.getMauSac(),
							linhKien.getTinhTrang(),linhKien.getNcc().getTenNCC(),
							linhKien.getLoaiLK().getTenLoai()});
				}
				System.out.println(lk);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if (rdbtnNCC.isSelected()) {
			xoaTable();
			List<LinhKien> lk;
			try {
				lk = lk_dao.getLinhKienByNCC(tim);
				for (LinhKien  linhKien: lk) {
					modelLK.addRow(new Object[] {d++,linhKien.getMaLK(),linhKien.getTenLK(),linhKien.getSoLuong(),
							linhKien.getDonViTinh(),linhKien.getGiaNhap(),linhKien.getBaoHanh(),linhKien.getNgayNhap(),
							linhKien.getThuongHieu()
							,linhKien.getNuocSX(),linhKien.getThongSoKT(),linhKien.getMauSac(),
							linhKien.getTinhTrang(),linhKien.getNcc().getTenNCC(),
							linhKien.getLoaiLK().getTenLoai()});
				}
				System.out.println(lk);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if (rdbtnTenLK.isSelected()) {
			xoaTable();
			List<LinhKien> lk;
			try {
				lk = lk_dao.getLinhKienByTenLK(tim);
				for (LinhKien  linhKien: lk) {
					modelLK.addRow(new Object[] {d++,linhKien.getMaLK(),linhKien.getTenLK(),linhKien.getSoLuong(),
							linhKien.getDonViTinh(),linhKien.getGiaNhap(),linhKien.getBaoHanh(),linhKien.getNgayNhap(),
							linhKien.getThuongHieu()
							,linhKien.getNuocSX(),linhKien.getThongSoKT(),linhKien.getMauSac(),
							linhKien.getTinhTrang(),linhKien.getNcc().getTenNCC(),
							linhKien.getLoaiLK().getTenLoai()});
				}
				System.out.println(lk);
			} catch (SQLException e) {
				e.printStackTrace();
			}


		}
	}
}
