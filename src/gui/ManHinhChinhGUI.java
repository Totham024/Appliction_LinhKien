package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManHinhChinhGUI extends JFrame {



	/**
	 * 
	 */
	private static final long serialVersionUID = -7331328225458425128L;

	public static JPanel contentPane;

	public LapHoaDonGUI guiLHD= new LapHoaDonGUI();
	private NhanVienGUI guiNV= new NhanVienGUI();
	private HoaDonGUI hoaDonGUI = new HoaDonGUI();
	private KhachHangGui guiKH = new KhachHangGui(); 
	private GUITKDoanhThu guiDT = new GUITKDoanhThu(); 
	private GUITKLinhKien guiLK = new GUITKLinhKien();
	private GUITKHoaDon guiHD = new GUITKHoaDon();
	private ThongTinNhanVienGUI ttGui = new ThongTinNhanVienGUI();
	private THONGKEFULL tk = new THONGKEFULL();
	public static JTabbedPane tabbedPane;


	public JMenu mnLapHoaDon;

	public JMenu mnLinhKien;

	public JMenu mnHoaDon;

	public JMenu mnKhachHang;

	public JMenu mnNhanVien;

	public JMenu mnThongKe;

	private JMenu mnTroGiup;

	private JMenu mnPhienBan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new ManHinhChinhGUI().setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public ManHinhChinhGUI() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 20, 1210, 750);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		setJMenuBar(menuBar);

		mnTroGiup = new JMenu("  Trợ giúp  ");


		mnTroGiup.setFont(new Font("Times New Roman", Font.BOLD, 20));
		menuBar.add(mnTroGiup);

		mnPhienBan = new JMenu("    Phiên bản   ");
		mnPhienBan.setFont(new Font("Times New Roman", Font.BOLD, 20));
		menuBar.add(mnPhienBan);

		JMenuBar menuBar_7 = new JMenuBar();
		menuBar.add(menuBar_7);

		JMenu mnDangxuat = new JMenu("Đăng xuất");
		mnDangxuat.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent arg0) {
			}
			public void menuDeselected(MenuEvent arg0) {
			}
			public void menuSelected(MenuEvent arg0) {
				setVisible(false);
				DangNhapGUI dangNhapGUI = new DangNhapGUI();
				dangNhapGUI.setVisible(true);
			}
		});
		mnDangxuat.setFont(new Font("Times New Roman", Font.BOLD, 18));
		menuBar_7.add(mnDangxuat);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(new Color(224, 255, 255));
		toolBar.setBounds(-13, 0, 1218, 40);
		contentPane.add(toolBar);

		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setToolTipText("");
		toolBar.add(menuBar_1);

		mnLapHoaDon = new JMenu("Lập hóa đơn    ");
		mnLapHoaDon.setIcon(new ImageIcon("Picture\\hoadon.jpg"));
		mnLapHoaDon.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent arg0) {
			}
			public void menuDeselected(MenuEvent arg0) {
			}
			public void menuSelected(MenuEvent arg0) {
				tabbedPane.remove(tabbedPane.getSelectedComponent());
				guiLHD.lamMoi();
				tabbedPane.add(guiLHD.contentPane);
				
			}
		});

		mnLapHoaDon.setFont(new Font("Tahoma", Font.BOLD, 20));
		menuBar_1.add(mnLapHoaDon);

		JMenuBar menuBar_2 = new JMenuBar();
		toolBar.add(menuBar_2);

		mnLinhKien = new JMenu("Linh kiện   ");
		mnLinhKien.setIcon(new ImageIcon("Picture\\lk1.jpg"));
		mnLinhKien.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent arg0) {
			}
			public void menuDeselected(MenuEvent arg0) {
			}
			public void menuSelected(MenuEvent arg0) {
				tabbedPane.remove(tabbedPane.getSelectedComponent());
				LinhKienGUI lk = new LinhKienGUI();
				tabbedPane.add(lk.contentPane);

			}
		});
		mnLinhKien.setFont(new Font("Tahoma", Font.BOLD, 20));
		menuBar_2.add(mnLinhKien);

		JMenuBar menuBar_3 = new JMenuBar();
		toolBar.add(menuBar_3);

		mnHoaDon = new JMenu("Hóa đơn   ");
		mnHoaDon.setIcon(new ImageIcon("Picture\\hoadon.png"));
		mnHoaDon.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent arg0) {
			}
			public void menuDeselected(MenuEvent arg0) {
			}
			public void menuSelected(MenuEvent arg0) {
				tabbedPane.remove(tabbedPane.getSelectedComponent());
				tabbedPane.add(hoaDonGUI.contentPane);
				
			}
		});
		mnHoaDon.setFont(new Font("Tahoma", Font.BOLD, 20));
		menuBar_3.add(mnHoaDon);

		JMenuBar menuBar_4 = new JMenuBar();
		toolBar.add(menuBar_4);

		mnKhachHang = new JMenu("Khách hàng   ");
		mnKhachHang.setIcon(new ImageIcon("Picture\\customer.png"));
		mnKhachHang.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent arg0) {
			}
			public void menuDeselected(MenuEvent arg0) {
			}
			public void menuSelected(MenuEvent arg0) {
				tabbedPane.remove(tabbedPane.getSelectedComponent());
				tabbedPane.add(guiKH.contentPane);
				tabbedPane.setSelectedComponent(guiKH.contentPane);
			}
		});
		mnKhachHang.setFont(new Font("Tahoma", Font.BOLD, 20));
		menuBar_4.add(mnKhachHang);

		JMenuBar menuBar_5 = new JMenuBar();
		toolBar.add(menuBar_5);

		mnNhanVien = new JMenu("Nhân viên  ");
		mnNhanVien.setIcon(new ImageIcon("Picture\\NhanVien.jpg"));
		mnNhanVien.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent arg0) {
			}
			public void menuDeselected(MenuEvent arg0) {
			}
			public void menuSelected(MenuEvent arg0) {
				tabbedPane.remove(tabbedPane.getSelectedComponent());
				tabbedPane.add(guiNV.contentPane);
				tabbedPane.setSelectedComponent(guiNV.contentPane);
			}
		});
		mnNhanVien.setFont(new Font("Tahoma", Font.BOLD, 20));
		menuBar_5.add(mnNhanVien);

		JMenuBar menuBar_6 = new JMenuBar();
		toolBar.add(menuBar_6);

		mnThongKe = new JMenu("  Thống kê  ");
		mnThongKe.setIcon(new ImageIcon("Picture\\thongke.png"));
		mnThongKe.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent arg0) {
			}
			public void menuDeselected(MenuEvent arg0) {
			}
			public void menuSelected(MenuEvent arg0) {
				tabbedPane.remove(tabbedPane.getSelectedComponent());
				tabbedPane.add(tk.contentPane);
				tabbedPane.setSelectedComponent(tk.contentPane);
			}
		});
		mnThongKe.setFont(new Font("Tahoma", Font.BOLD, 20));
		menuBar_6.add(mnThongKe);
		
		JMenuBar menuBar_8 = new JMenuBar();
		toolBar.add(menuBar_8);
		
		JMenu mnNewMenu = new JMenu("Thông tin nhân viên");
		mnNewMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		mnNewMenu.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent arg0) {
			}
			public void menuDeselected(MenuEvent arg0) {
			}
			public void menuSelected(MenuEvent arg0) {
				tabbedPane.remove(tabbedPane.getSelectedComponent());
				tabbedPane.add(ttGui.pnlTabXemThongTinCaNhan);
				
			}
		});
		
		
		menuBar_8.add(mnNewMenu);
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(224, 255, 255));
		tabbedPane.setBounds(0, -20, 1367, 724);
		contentPane.add(tabbedPane);
		setTitle("Màn hình chính");
	}
}
