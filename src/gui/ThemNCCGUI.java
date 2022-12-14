package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.NhaCungCapDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

public class ThemNCCGUI extends JFrame  {

	private JPanel contentPane;
	public static JTextField txtTen;
	public static JTextField txtSDT;
	public static JTextField txtEmail;
	private JButton btnThem;
	private NhaCungCapDAO dao = new NhaCungCapDAO();
	private List<String> listDiaChi= new ArrayList<String>();
	private DefaultComboBoxModel cboModleDiaChi= new DefaultComboBoxModel();
	private JTextField txtSoNha;
	private JTextField txtTenDuong;
	private JTextField txtPhuong;
	private JTextField txtQuan;
	private JTextField txtThanhPho;
	private JTextField txtQuocGia;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemNCCGUI frame = new ThemNCCGUI();
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
	public ThemNCCGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 439, 622);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(0, 0, 434, 67);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("NH?? CUNG C???P");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 32));
		panel.add(lblNewLabel);
		
		JLabel lblTen = new JLabel("T??n nh?? cung c???p :");
		lblTen.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTen.setBounds(10, 93, 138, 28);
		contentPane.add(lblTen);
		
		JLabel lblSDT = new JLabel("S??? ??i???n tho???i:");
		lblSDT.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSDT.setBounds(10, 142, 138, 28);
		contentPane.add(lblSDT);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblEmail.setBounds(10, 194, 91, 28);
		contentPane.add(lblEmail);
		
		JLabel lblDiaChi = new JLabel("??ia ch???:");
		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblDiaChi.setBounds(10, 245, 91, 28);
		contentPane.add(lblDiaChi);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTen.setBounds(159, 96, 227, 22);
		contentPane.add(txtTen);
		txtTen.setColumns(10);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtSDT.setColumns(10);
		txtSDT.setBounds(159, 148, 227, 22);
		contentPane.add(txtSDT);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(159, 200, 227, 22);
		contentPane.add(txtEmail);
		
		btnThem = new JButton("Th??m");
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		btnThem.setBackground(Color.WHITE);
		btnThem.setForeground(Color.BLACK);
		btnThem.setIcon(new ImageIcon("Hinh\\iconSave.png"));
		btnThem.setBounds(114, 531, 89, 35);
		contentPane.add(btnThem);
		
		JLabel lblSoNha = new JLabel("S??? Nh?? :");
		lblSoNha.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSoNha.setBounds(75, 290, 91, 28);
		contentPane.add(lblSoNha);
		
		txtSoNha = new JTextField();
		txtSoNha.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtSoNha.setColumns(10);
		txtSoNha.setBounds(180, 290, 206, 22);
		contentPane.add(txtSoNha);
		
		JLabel lblTenDuong = new JLabel("T??n ???????ng :");
		lblTenDuong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTenDuong.setBounds(75, 330, 91, 28);
		contentPane.add(lblTenDuong);
		
		txtTenDuong = new JTextField();
		txtTenDuong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTenDuong.setColumns(10);
		txtTenDuong.setBounds(180, 330, 209, 22);
		contentPane.add(txtTenDuong);
		
		JLabel lblPhuong = new JLabel("Ph?????ng :");
		lblPhuong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPhuong.setBounds(75, 370, 91, 28);
		contentPane.add(lblPhuong);
		
		txtPhuong = new JTextField();
		txtPhuong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtPhuong.setColumns(10);
		txtPhuong.setBounds(180, 370, 209, 22);
		contentPane.add(txtPhuong);
		
		JLabel lblQuan = new JLabel("Qu???n :");
		lblQuan.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblQuan.setBounds(75, 410, 91, 28);
		contentPane.add(lblQuan);
		
		txtQuan = new JTextField();
		txtQuan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtQuan.setColumns(10);
		txtQuan.setBounds(180, 410, 209, 22);
		contentPane.add(txtQuan);
		
		JLabel lblThanhPho = new JLabel("Th??nh ph??? :");
		lblThanhPho.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblThanhPho.setBounds(75, 450, 91, 28);
		contentPane.add(lblThanhPho);
		
		txtThanhPho = new JTextField();
		txtThanhPho.setText("H??? Ch?? Minh");
		txtThanhPho.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtThanhPho.setColumns(10);
		txtThanhPho.setBounds(180, 450, 209, 22);
		contentPane.add(txtThanhPho);
		
		JLabel lblQuocGia = new JLabel("Qu???c gia :");
		lblQuocGia.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblQuocGia.setBounds(75, 490, 91, 28);
		contentPane.add(lblQuocGia);
		
		txtQuocGia = new JTextField();
		txtQuocGia.setText("Vi???t Nam");
		txtQuocGia.setHorizontalAlignment(SwingConstants.LEFT);
		txtQuocGia.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtQuocGia.setColumns(10);
		txtQuocGia.setBounds(180, 490, 209, 22);
		contentPane.add(txtQuocGia);
		
		JButton btnThoat = new JButton("Tho??t");
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThoat.setForeground(Color.BLACK);
		btnThoat.setBackground(Color.WHITE);
		btnThoat.setBounds(215, 531, 89, 35);
		contentPane.add(btnThoat);
		btnThem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				them();
			}
		});
		btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
	}
	/**
	 * D??ng ????? l???y d??? li???u v??o th??m v??o c?? s??? d??? li???u
	 */
	public void them() {
		if(kiemTra()==true) {
			String soNha =txtSoNha.getText();
			System.out.println(soNha);
			String tenDuong = txtTenDuong.getText();
			System.out.println(tenDuong);
			String phuong =txtPhuong.getText();
			String quan =txtQuan.getText();
			String thanhPho =txtQuan.getText();
			String quocGia =txtQuocGia.getText();
			dao.themDiaChi(soNha, tenDuong, phuong, quan, thanhPho, quocGia);
			List<Integer> maDC= dao.getMaDiaChi(soNha, tenDuong, phuong, quan, thanhPho, quocGia);
			String ten=txtTen.getText();
			String soDienThoai = txtSDT.getText();
			String email= txtEmail.getText();
			System.out.println(maDC);
			System.out.println(maDC.get(0));
			dao.them(ten, soDienThoai, email, maDC.get(0));
			JOptionPane.showMessageDialog(this , "Th??m nh?? cung c???p th??nh c??ng");
			setVisible(false);
			 LinhKienGUI.cboNCC.setSelectedItem(ten);
		}
		else 
			return;
	}
	/**
	 * Ki???m tra c??c d??? li???u
	 * @return true n???u d??? li???u nh???p ????ng
	 * @return false n???u d??? li???u sai
	 */
	public boolean kiemTra() {
		if (txtTen.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui l??ng nh???p t??n nh?? cung c???p !", "Th??ng b??o !", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("Hinh\\warning.png"));
			txtTen.requestFocus();
			txtTen.selectAll();
			return false;
		}
		else if (txtSDT.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui l??ng nh???p s??? ??i???n tho???i nh?? cung c???p !", "Th??ng b??o !", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("Hinh\\warning.png"));
			txtSDT.requestFocus();
			txtSDT.selectAll();
			return false;
		}
		else if (txtSDT.getText().matches("^[0]\\d{9}$") == false) {
			JOptionPane.showMessageDialog(this, "Vui l??ng nh???p s??? ??i???n tho???i nh?? cung c???p b???ng s??? v?? g???m 10 ch??? s??? b???t ?????u b???ng s??? 0 !", "Th??ng b??o !", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("Hinh\\warning.png"));
			txtSDT.requestFocus();
			txtSDT.selectAll();
			return false;
		}
		else if (txtEmail.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui l??ng nh???p email nh?? cung c???p ! ", "Th??ng b??o !", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("Hinh\\warning.png"));
			txtEmail.requestFocus();
			txtEmail.selectAll();
			return false;
		}
        else if (txtEmail.getText().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$") == false) {
			JOptionPane.showMessageDialog(this, "Vui l??ng nh???p ????ng email nh?? cung c???p !\\n v?? d???:quoc@gmail.com ", "Th??ng b??o !", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("Hinh\\warning.png"));
			txtEmail.requestFocus();
			txtEmail.selectAll();
			return false;
		}
		else if (txtSoNha.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui l??ng nh???p ?????a ch??? nh?? cung c???p !", "Th??ng b??o !", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("Hinh\\warning.png"));
			txtSoNha.requestFocus();
			txtSoNha.selectAll();
			return false;
		}
		else if (txtTenDuong.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui l??ng nh???p ?????a ch??? nh?? cung c???p !", "Th??ng b??o !", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("Hinh\\warning.png"));
			txtTenDuong.requestFocus();
			txtTenDuong.selectAll();
			return false;
		}
		else if (txtPhuong.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui l??ng nh???p ?????a ch??? nh?? cung c???p !", "Th??ng b??o !", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("Hinh\\warning.png"));
			txtPhuong.requestFocus();
			txtPhuong.selectAll();
			return false;
		}
		
		else if (txtQuan.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui l??ng nh???p ?????a ch??? nh?? cung c???p !", "Th??ng b??o !", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("Hinh\\warning.png"));
			txtQuan.requestFocus();
			txtQuan.selectAll();
			return false;
		}
		else if (txtThanhPho.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui l??ng nh???p ?????a ch??? nh?? cung c???p !", "Th??ng b??o !", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("Hinh\\warning.png"));
			txtQuan.requestFocus();
			txtQuan.selectAll();
			return false;
		}
		else if (txtQuocGia.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui l??ng nh???p ?????a ch??? nh?? cung c???p !", "Th??ng b??o !", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("Hinh\\warning.png"));
			txtQuan.requestFocus();
			txtQuan.selectAll();
			return false;
		}
		return true;
	}
}
