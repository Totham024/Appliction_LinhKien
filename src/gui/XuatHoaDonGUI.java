package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JButton;


public class XuatHoaDonGUI extends JFrame implements Printable,ActionListener {

	private static JPanel contentPane;
	public static JTable table;
	public static JLabel lblQLT;
	public static JLabel lblMSThue;
	public static JLabel lblDiaChi;
	public static JLabel lblDienThoai;
	public static JLabel lblMHDon ;
	public static JLabel lblHD;
	public static JLabel lblNgayLap;
	public static JLabel lblHoTenKH ;
	public static JLabel lblDiaChiKH;
	public static JLabel lblSDTKH;
	public static JLabel lblTenKH1;
	public static JLabel lblMaHD;
	public static JLabel lblNgayLap1;
	public static JLabel lblDCKH1 ;
	public static JLabel lblsdtkh1;
	public static JLabel lblTongTLK;
	public static JLabel lblTongT ;
	public static JLabel lblNguoiBan ;
	public static JLabel lblNguoiMuaHang1 ;
	private static JPanel panel;
	public static DefaultTableModel tableModel ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XuatHoaDonGUI frame = new XuatHoaDonGUI();
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
	public XuatHoaDonGUI() {
		setTitle("HÓA ĐƠN BÁN HÀNG");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setSize( 1199, 775);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		panel.setBounds(404, 11, 616, 724);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		lblQLT = new JLabel("HÓA ĐƠN BÁN HÀNG");
		lblQLT.setBounds(177, 32, 301, 27);
		lblQLT.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblQLT.setForeground(new Color(255, 0, 0));
		panel.add(lblQLT);
		
		lblMSThue = new JLabel("M\u00E3 s\u1ED1 thu\u1EBF:");
		lblMSThue.setBounds(18, 101, 75, 14);
		lblMSThue.setForeground(new Color(0, 0, 255));
		lblMSThue.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel.add(lblMSThue);
		
		lblDiaChi = new JLabel("\u0110\u1ECBa ch\u1EC9:");
		lblDiaChi.setBounds(18, 151, 58, 14);
		lblDiaChi.setForeground(Color.BLUE);
		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel.add(lblDiaChi);
		
		lblDienThoai = new JLabel("\u0110i\u1EC7n tho\u1EA1i:");
		lblDienThoai.setBounds(18, 126, 75, 14);
		lblDienThoai.setForeground(Color.BLUE);
		lblDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel.add(lblDienThoai);
		
		lblMHDon = new JLabel("M\u00E3 h\u00F3a \u0111\u01A1n:");
		lblMHDon.setBounds(338, 98, 75, 14);
		lblMHDon.setForeground(Color.BLUE);
		lblMHDon.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel.add(lblMHDon);
		
		lblHD = new JLabel("CỬA HÀNG LINH KIỆN SIMPLET\r\n");
		lblHD.setBounds(101, 70, 272, 20);
		lblHD.setHorizontalAlignment(SwingConstants.CENTER);
		lblHD.setForeground(new Color(0, 0, 255));
		lblHD.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblHD);
		
		lblNgayLap = new JLabel("Ng\u00E0y l\u1EADp:");
		lblNgayLap.setBounds(338, 120, 75, 20);
		lblNgayLap.setForeground(Color.BLUE);
		lblNgayLap.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel.add(lblNgayLap);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 176, 596, 86);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblHoTenKH = new JLabel("H\u1ECD t\u00EAn Kh\u00E1ch h\u00E0ng:");
		lblHoTenKH.setForeground(new Color(0, 0, 255));
		lblHoTenKH.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblHoTenKH.setBounds(10, 11, 116, 14);
		panel_1.add(lblHoTenKH);
		
		lblDiaChiKH = new JLabel("\u0110\u1ECBa ch\u1EC9:");
		lblDiaChiKH.setForeground(Color.BLUE);
		lblDiaChiKH.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDiaChiKH.setBounds(10, 61, 75, 14);
		panel_1.add(lblDiaChiKH);
		
		lblSDTKH = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i:");
		lblSDTKH.setForeground(Color.BLUE);
		lblSDTKH.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSDTKH.setBounds(10, 36, 106, 14);
		panel_1.add(lblSDTKH);
		
		lblTenKH1 = new JLabel("");
		lblTenKH1.setText(LapHoaDonGUI.lblTKH.getText().toString());
		lblTenKH1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblTenKH1.setBounds(128, 12, 147, 14);
		panel_1.add(lblTenKH1);
		
		lblsdtkh1 = new JLabel("");
		lblsdtkh1.setText(LapHoaDonGUI.txtSDT.getText().toString());
		lblsdtkh1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblsdtkh1.setBounds(92, 36, 122, 14);
		panel_1.add(lblsdtkh1);
		
		lblDCKH1 = new JLabel("");
		lblDCKH1.setText(LapHoaDonGUI.lblDC.getText().toString());
		lblDCKH1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblDCKH1.setBounds(66, 61, 390, 14);
		panel_1.add(lblDCKH1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		scrollPane_1.setBounds(10, 263, 596, 308);
		panel.add(scrollPane_1);
		
		
		String[] tb = new String[] {"STT","Tên linh kiện","Số Lượng","Bảo hành","Đơn Giá","Thành Tiền"};

		tableModel = new DefaultTableModel(tb,0);
		table = new JTable(tableModel);
		table.setBackground(Color.WHITE);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(1).setPreferredWidth(330);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setPreferredWidth(63);
		
		scrollPane_1.setViewportView(table);
		
		JLabel lblNguoiMuaHang = new JLabel("Ng\u01B0\u1EDDi mua h\u00E0ng");
		lblNguoiMuaHang.setBounds(41, 650, 134, 14);
		lblNguoiMuaHang.setForeground(Color.BLUE);
		lblNguoiMuaHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblNguoiMuaHang);
		
		JLabel lblkghiRH = new JLabel("(K\u00ED,ghi r\u00F5 h\u1ECD t\u00EAn)");
		lblkghiRH.setBounds(18, 662, 134, 14);
		lblkghiRH.setHorizontalAlignment(SwingConstants.CENTER);
		lblkghiRH.setForeground(Color.BLUE);
		lblkghiRH.setFont(new Font("Tahoma", Font.ITALIC, 10));
		panel.add(lblkghiRH);
		
		JLabel lblNguoiBanHang = new JLabel("Ng\u01B0\u1EDDi b\u00E1n h\u00E0ng");
		lblNguoiBanHang.setBounds(462, 653, 134, 14);
		lblNguoiBanHang.setForeground(Color.BLUE);
		lblNguoiBanHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblNguoiBanHang);
		
		JLabel label_1 = new JLabel("(K\u00ED,ghi r\u00F5 h\u1ECD t\u00EAn)");
		label_1.setBounds(472, 665, 134, 14);
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		panel.add(label_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 567, 596, 41);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTongTienLK = new JLabel("Tổng tiền linh kiện:");
		lblTongTienLK.setForeground(Color.BLUE);
		lblTongTienLK.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTongTienLK.setBounds(289, 11, 123, 24);
		panel_2.add(lblTongTienLK);
		
		lblTongTLK = new JLabel("");
		lblTongTLK.setText(LapHoaDonGUI.txtTongTien.getText().toString());
		lblTongTLK.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTongTLK.setBounds(445, 15, 132, 19);
		panel_2.add(lblTongTLK);
		
		JLabel lblThueXuat = new JLabel("Thu\u1EBF su\u1EA5t(VAT):");
		lblThueXuat.setBounds(104, 11, 106, 14);
		panel_2.add(lblThueXuat);
		lblThueXuat.setForeground(Color.BLUE);
		lblThueXuat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JLabel lblThue = new JLabel("5");
		lblThue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblThue.setBounds(208, 11, 31, 14);
		panel_2.add(lblThue);
		
		JLabel label_2 = new JLabel("%");
		label_2.setBounds(248, 11, 31, 14);
		panel_2.add(label_2);
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel_3.setBounds(10, 604, 596, 35);
		panel.add(panel_3);
		
		JLabel lblTongThanhToan = new JLabel("T\u1ED5ng ti\u1EC1n thanh to\u00E1n:");
		lblTongThanhToan.setBounds(285, 12, 133, 23);
		panel_3.add(lblTongThanhToan);
		lblTongThanhToan.setForeground(Color.BLUE);
		lblTongThanhToan.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		lblTongT = new JLabel("");
		lblTongT.setText(LapHoaDonGUI.txtThanhToan.getText().toString());
		lblTongT.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTongT.setBounds(417, 13, 169, 23);
		panel_3.add(lblTongT);
		
		JLabel label_4 = new JLabel("");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(130, 12, 116, 14);
		panel_3.add(label_4);
		
		JLabel lblMaSoThue = new JLabel("0312388363");
		lblMaSoThue.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblMaSoThue.setBounds(90, 101, 106, 14);
		panel.add(lblMaSoThue);
		
		JLabel lblSDT1 = new JLabel("0802.090.301  - 0975.326.451");
		lblSDT1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSDT1.setBounds(90, 126, 199, 14);
		panel.add(lblSDT1);
		
		JLabel lblDiaChi1 = new JLabel("446 Nguyễn Thái Sơn- Quận Gò Vấp - Tp.Hồ Chí Minh");
		lblDiaChi1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDiaChi1.setBounds(73, 145, 322, 27);
		panel.add(lblDiaChi1);
		
		lblMaHD = new JLabel("");
		lblMaHD.setBounds(419, 95, 162, 14);
		panel.add(lblMaHD);
		
		lblNgayLap1 = new JLabel("");
		lblNgayLap1.setBounds(417, 127, 179, 14);
		lblNgayLap1.setText(LapHoaDonGUI.lblNB.getText().toString());
		panel.add(lblNgayLap1);
		
		lblNguoiBan = new JLabel("");
		lblNguoiBan.setHorizontalAlignment(SwingConstants.CENTER);
		lblNguoiBan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNguoiBan.setBounds(422, 678, 168, 27);
		
		panel.add(lblNguoiBan);
		
		lblNguoiMuaHang1 = new JLabel("");
		lblNguoiMuaHang1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNguoiMuaHang1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNguoiMuaHang1.setBounds(18, 675, 157, 30);
		panel.add(lblNguoiMuaHang1);
		
		JLabel lblNewLabel = new JLabel("Đơn vị bán hàng:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(18, 76, 154, 14);
		panel.add(lblNewLabel);
		
	}
	
	public void printingHoaDon() {
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable(this);
		boolean ok = job.printDialog();
		if(ok) {
			try {
				job.print();
			} catch (Exception e2) {
					// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		// TODO Auto-generated method stub
			Graphics2D g2d = (Graphics2D) graphics;
			if(pageIndex>0) {
				return NO_SUCH_PAGE;
			}
			g2d.translate(pageFormat.getImageableX(),pageFormat.getImageableY());
			panel.printAll(graphics);
			return PAGE_EXISTS;
		}
}
