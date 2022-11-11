package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connectDB.ConnectDB;
import dao.LinhKienDAO;

import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ThemLoaiLKGUI extends JFrame {

	
	private JTextField txtTenLK;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemLoaiLKGUI frame = new ThemLoaiLKGUI();
					
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private LinhKienDAO lk_dao = new LinhKienDAO();
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public ThemLoaiLKGUI() {
		ConnectDB.getInstance().connect();
		setResizable(false);
		setSize(300, 200);
		ConnectDB.getInstance().connect();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("THÊM LOẠI LINH KIỆN");
		lblTitle.setForeground(Color.RED);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitle.setBounds(29, 11, 229, 34);
		contentPane.add(lblTitle);
		
		txtTenLK = new JTextField();
		txtTenLK.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtTenLK.setBounds(104, 74, 180, 27);
		contentPane.add(txtTenLK);
		txtTenLK.setColumns(10);
		
		JLabel lblTenLK = new JLabel("Tên loại");
		lblTenLK.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTenLK.setBounds(10, 74, 84, 27);
		contentPane.add(lblTenLK);
		
		JButton btnThem = new JButton("Thêm ");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				them();
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThem.setBounds(87, 125, 108, 35);
		contentPane.add(btnThem);
	}
	public void them() {
		if(txtTenLK.getText().toString()!=null) {
		
			String tenLoaiLK = txtTenLK.getText().toString();
			lk_dao.getThemLoaiLK(tenLoaiLK);
			JOptionPane.showMessageDialog(this , "Thêm loại linh kiện thành công!!!");
			setVisible(false);
			LinhKienGUI.cboLoaiLK.setSelectedItem(tenLoaiLK);
		}
		else 
			return;
	}
}
