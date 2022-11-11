
package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.NhanVienDAO;
import entity.DiaChi;

import java.awt.Button;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

public class GuiDiaChi extends JFrame implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaDC;
	private JTextField txtNuoc;
	private JTextField textTinhTP;
	private JTextField txtQuanHuyen;
	private JTextField txtPhuongXa;
	private JTextField txtThmaCh;
	private JTextField txtSoNha;
	private JTextField txtTenDuong;
	private JButton btnXacNhan;
	NhanVienDAO nvDao = new NhanVienDAO();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiDiaChi frame = new GuiDiaChi();
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
	public GuiDiaChi() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 100, 500, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(5, 5, 476, 608);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMaDC = new JLabel("Mã DC");
		lblMaDC.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMaDC.setBounds(31, 86, 91, 26);
		panel.add(lblMaDC);
		
		JLabel lblNuoc = new JLabel("Quốc Gia");
		lblNuoc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNuoc.setBounds(31, 135, 91, 26);
		panel.add(lblNuoc);
		
		JLabel lblTinhTP = new JLabel("Tỉnh/TP");
		lblTinhTP.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTinhTP.setBounds(31, 183, 91, 26);
		panel.add(lblTinhTP);
		
		JLabel lblQuanHuyen = new JLabel("Quận/ Huyện");
		lblQuanHuyen.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuanHuyen.setBounds(31, 240, 113, 26);
		panel.add(lblQuanHuyen);
		
		JLabel lblPhuongXa = new JLabel("Phường/Xã");
		lblPhuongXa.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhuongXa.setBounds(31, 298, 91, 26);
		panel.add(lblPhuongXa);
		
		txtMaDC = new JTextField();
		txtMaDC.setEditable(false);
		txtMaDC.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtMaDC.setBounds(177, 87, 209, 26);
		panel.add(txtMaDC);
		txtMaDC.setColumns(10);
		
		txtNuoc = new JTextField();
		txtNuoc.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtNuoc.setColumns(10);
		txtNuoc.setBounds(177, 136, 209, 26);
		panel.add(txtNuoc);
		
		textTinhTP = new JTextField();
		textTinhTP.setFont(new Font("Tahoma", Font.BOLD, 14));
		textTinhTP.setColumns(10);
		textTinhTP.setBounds(176, 184, 209, 26);
		panel.add(textTinhTP);
		
		txtQuanHuyen = new JTextField();
		txtQuanHuyen.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtQuanHuyen.setColumns(10);
		txtQuanHuyen.setBounds(177, 241, 209, 26);
		panel.add(txtQuanHuyen);
		
		txtPhuongXa = new JTextField();
		txtPhuongXa.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPhuongXa.setColumns(10);
		txtPhuongXa.setBounds(177, 299, 209, 26);
		panel.add(txtPhuongXa);
		
		txtThmaCh = new JTextField();
		txtThmaCh.setHorizontalAlignment(SwingConstants.CENTER);
		txtThmaCh.setForeground(new Color(255, 0, 0));
		txtThmaCh.setBackground(new Color(250, 250, 210));
		txtThmaCh.setFont(new Font("Times New Roman", Font.BOLD, 24));
		txtThmaCh.setText("THÊM ĐỊA CHỈ");
		txtThmaCh.setBounds(132, 20, 190, 40);
		panel.add(txtThmaCh);
		txtThmaCh.setColumns(10);
		
		btnXacNhan = new JButton("Thêm");
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXacNhan.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXacNhan.setBounds(176, 494, 113, 32);
		panel.add(btnXacNhan);
		
		JLabel lblSoNha = new JLabel("Số Nhà");
		lblSoNha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSoNha.setBounds(31, 408, 91, 26);
		panel.add(lblSoNha);
		
		txtSoNha = new JTextField();
		txtSoNha.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSoNha.setColumns(10);
		txtSoNha.setBounds(177, 409, 209, 26);
		panel.add(txtSoNha);
		
		txtTenDuong = new JTextField();
		txtTenDuong.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtTenDuong.setColumns(10);
		txtTenDuong.setBounds(177, 357, 209, 26);
		panel.add(txtTenDuong);
		
		JLabel lblTenDuong = new JLabel("Tên đường");
		lblTenDuong.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTenDuong.setBounds(31, 356, 91, 26);
		panel.add(lblTenDuong);
		btnXacNhan.addActionListener(this);
		contentPane.addKeyListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnXacNhan)) {
			String soNha = txtSoNha.getText().trim();
			String duong = txtTenDuong.getText().trim();
			String phuong = txtPhuongXa.getText().trim();
			String quan = txtQuanHuyen.getText().trim();
			String thanhPho = textTinhTP.getText().trim();
			String quocGia = txtNuoc.getText().trim();
			String invalid = "";
			if (!soNha.equalsIgnoreCase("")) {
				if (soNha.length() > 15) {
					invalid += "Số nhà không hơp lệ !\n";
				}
			}
			if (!duong.equalsIgnoreCase("")) {
				if (duong.length() > 30) {
					invalid += "Tên đường không hơp lệ !\n";
				}
			}
			if (phuong.equalsIgnoreCase("")) {
				invalid += "Vui lòng nhập phường/xã !\n";
			} else if (phuong.length() > 30) {
				invalid += "Phường/Xã không hợp lệ !\n";
			}
			if (quan.equalsIgnoreCase("")) {
				invalid += "Vui lòng nhập quận/huyện !\n";
			} else if (quan.length() > 30) {
				invalid += "Quận/Huyện không hợp lệ !\n";
			}
			if (thanhPho.equalsIgnoreCase("")) {
				invalid += "Vui lòng nhập Tỉnh/Thành phố !\n";
			} else if (thanhPho.length() > 30) {
				invalid += "Tỉnh/Thành phố không hợp lệ !\n";
			}
			if (quocGia.equalsIgnoreCase("")) {
				invalid += "Vui lòng nhập quốc gia !\n";
			} else if (quocGia.length() > 30) {
				invalid += "Quốc gia không hợp lệ !\n";
			}
			String diaChi = "";
			if (!txtSoNha.getText().trim().equalsIgnoreCase("") && !txtTenDuong.getText().trim().equalsIgnoreCase("")) {
				diaChi = txtSoNha.getText() + ", " + txtTenDuong.getText() + ", " + txtPhuongXa.getText() + ", "
						+ txtQuanHuyen.getText() + ", " + textTinhTP.getText() + ", " + txtNuoc.getText();
			} else {
				diaChi = txtPhuongXa.getText() + ", " + txtQuanHuyen.getText() + ", " + textTinhTP.getText() + ", "
						+ txtNuoc.getText();
			}
			if (invalid.equalsIgnoreCase("")) {
				try {
					DiaChi dc = new DiaChi(txtSoNha.getText(), txtTenDuong.getText(), txtPhuongXa.getText(),
							txtQuanHuyen.getText(), textTinhTP.getText(), txtNuoc.getText());
					if (nvDao.addDiaChi(dc)) {
				//		NhanVienGUI.check = true;
						NhanVienGUI.txtmaDC.setText(nvDao.getMaDiaChiMax() + "");
						NhanVienGUI.txtDC.setText(diaChi);
						JOptionPane.showMessageDialog(this, "Thêm địa chỉ thành công !", "Thông báo !",
								JOptionPane.CLOSED_OPTION);
						this.setVisible(false);

						//	GuiDiaChi.HIDE_ON_CLOSE
						try {
							
						//	NhanVienGUI.themNhanVien();
//							JOptionPane.showMessageDialog(this, "Đã thêm nhân viên !", "Thông báo !",
//									JOptionPane.CLOSED_OPTION);
//							NhanVienGUI.xoaAllDataTable();
//							NhanVienGUI.DocDuLieuVaoModel();;
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(this, "Thêm nhân viên thất bại !", "Thông báo !",
									JOptionPane.ERROR_MESSAGE);
						}
						NhanVienGUI.btnThemDC.setEnabled(true);
						this.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(this, "Thêm địa chỉ thất bại !", "Thông báo !",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(this, invalid, "Thông báo", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

