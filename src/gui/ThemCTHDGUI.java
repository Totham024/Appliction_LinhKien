package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import connectDB.ConnectDB;
import dao.lapHoaDonDAO;
import entity.LinhKien;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ThemCTHDGUI extends JFrame {

	private JPanel contentPane;
	public JLabel lblTenLk;
	public DefaultTableModel modelCTLK;
	private JScrollPane scrollPane;
	public  JTable tableCTLK;
	private lapHoaDonDAO lhd_dao = new lapHoaDonDAO();
	public JComboBox cboNSX;
	public JComboBox cboThuongHieu;
	private JLabel lblThongSo;
	private JTextField txtThongSo;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemCTHDGUI frame = new ThemCTHDGUI();
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
	public ThemCTHDGUI() {
		ConnectDB.getInstance().connect();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1227, 519);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		

		lblTenLk = new JLabel("Linh kiện: ");
		lblTenLk.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTenLk.setBounds(250, 11, 786, 36);

		contentPane.add(lblTenLk);
		
		String tim = lblTenLk.getText().toString();
		String[] parts = tim.split(":");
		String part1 = parts[0]; // 004
		String part2 = parts[1];
		System.out.println(part2);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 115, 1201, 309);
		String[] tb = new String[] { "STT","Mã linh kiện", "Tên linh kiện","Số lượng", "Đơn vị tính", "Giá nhập","Bảo hành",
				"Ngày nhập","Thương hiệu","Nước sản xuất","Thông số kỹ thuật"," Màu sắc ","Tình trạng"};
		modelCTLK = new DefaultTableModel(tb, 0);
		tableCTLK = new JTable(modelCTLK);
		tableCTLK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				them();
			}
		});
		tableCTLK.setBackground(new Color(224, 255, 255));
		scrollPane.setViewportView(tableCTLK);
		tableCTLK.getColumnModel().getColumn(0).setPreferredWidth(70);
		tableCTLK.getColumnModel().getColumn(1).setPreferredWidth(120);
		tableCTLK.getColumnModel().getColumn(2).setPreferredWidth(250);
		tableCTLK.getColumnModel().getColumn(3).setPreferredWidth(90);
		tableCTLK.getColumnModel().getColumn(4).setPreferredWidth(120);
		tableCTLK.getColumnModel().getColumn(5).setPreferredWidth(120);
		tableCTLK.getColumnModel().getColumn(6).setPreferredWidth(120);
		tableCTLK.getColumnModel().getColumn(7).setPreferredWidth(120);
		tableCTLK.getColumnModel().getColumn(8).setPreferredWidth(120);
		tableCTLK.getColumnModel().getColumn(9).setPreferredWidth(150);
		tableCTLK.getColumnModel().getColumn(10).setPreferredWidth(120);
		tableCTLK.getColumnModel().getColumn(11).setPreferredWidth(120);
		tableCTLK.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		contentPane.add(scrollPane);

		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				them();
			}


		});
		btnThem.setForeground(new Color(0, 0, 0));
		btnThem.setBackground(new Color(255, 0, 0));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnThem.setBounds(413, 435, 131, 34);
		contentPane.add(btnThem);

		JLabel lblThuongHieu = new JLabel("Thương hiệu");
		lblThuongHieu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThuongHieu.setBounds(10, 64, 101, 28);
		contentPane.add(lblThuongHieu);

		cboThuongHieu = new JComboBox();
		
		String th = (String) cboThuongHieu.getSelectedItem();
		cboThuongHieu.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				if(event.getStateChange() == ItemEvent.SELECTED) {
		            Object source = event.getSource();
		            if (source instanceof JComboBox) {
		                JComboBox cb = (JComboBox)source;
		                Object selectedItem = cb.getSelectedItem();
		                if ("".equals(selectedItem)) {
		                    return;
		                } else  {
		                	xoaTable();
		            		String th = cboThuongHieu.getSelectedItem().toString().trim();
		            		List<LinhKien> ls= lhd_dao.getTT(th, part2);
		            		for (LinhKien linhKien : ls) {
		            			int d=0;
		            			modelCTLK.addRow(new Object[] {d++,linhKien.getMaLK(),linhKien.getTenLK(),linhKien.getSoLuong(),
		            					linhKien.getDonViTinh(),linhKien.getGiaNhap(),linhKien.getBaoHanh(),linhKien.getNgayNhap(),
		            					linhKien.getThuongHieu()
		            					,linhKien.getNuocSX(),linhKien.getThongSoKT(),linhKien.getMauSac(),
		            					linhKien.getTinhTrang(),linhKien.getNcc().getTenNCC(),
		            					linhKien.getLoaiLK().getTenLoai()
		            			});
		            		}
		                }
		            }
		        }  
			}
		});
		
		cboThuongHieu.setModel(new DefaultComboBoxModel(new String[] {""}));
		cboThuongHieu.setEditable(true);
		cboThuongHieu.setFont(new Font("Tahoma", Font.BOLD, 14));
		cboThuongHieu.setBounds(121, 66, 146, 28);
		contentPane.add(cboThuongHieu);

		JLabel lblNsx = new JLabel("Nước sản xuất");
		lblNsx.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNsx.setBounds(277, 66, 126, 28);
		contentPane.add(lblNsx);

		cboNSX = new JComboBox();
		cboNSX.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				if(event.getStateChange() == ItemEvent.SELECTED) {
		            Object source = event.getSource();
		            if (source instanceof JComboBox) {
		                JComboBox cb = (JComboBox)source;
		                Object selectedItem = cb.getSelectedItem();
		                if ("".equals(selectedItem)) {
		                    return;
		                } else  {
		                	xoaTable();
		    				String nsx = String.valueOf(cboNSX.getSelectedItem());
		    				List<LinhKien> ls= lhd_dao.getNsx(nsx,part2);
		    				for (LinhKien linhKien : ls) {
		    					int d=0;
		    					modelCTLK.addRow(new Object[] {d++,linhKien.getMaLK(),linhKien.getTenLK(),linhKien.getSoLuong(),
		    							linhKien.getDonViTinh(),linhKien.getGiaNhap(),linhKien.getBaoHanh(),linhKien.getNgayNhap(),
		    							linhKien.getThuongHieu()
		    							,linhKien.getNuocSX(),linhKien.getThongSoKT(),linhKien.getMauSac(),
		    							linhKien.getTinhTrang(),linhKien.getNcc().getTenNCC(),
		    							linhKien.getLoaiLK().getTenLoai()
		    					});
		    				}
		                }
		            }
		        }  
			}
		});
		cboNSX.setEditable(true);
		cboNSX.setBounds(392, 66, 146, 28);
		contentPane.add(cboNSX);
		AutoCompleteDecorator.decorate(cboThuongHieu);
		AutoCompleteDecorator.decorate(cboNSX);

		lblThongSo = new JLabel("Thông số kỹ thuật");
		lblThongSo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThongSo.setBounds(667, 64, 146, 28);
		contentPane.add(lblThongSo);

		txtThongSo = new JTextField();
		txtThongSo.setBounds(819, 66, 371, 28);
		contentPane.add(txtThongSo);
		txtThongSo.setColumns(10);
		
		
	}
	private List<String> listTT= new ArrayList<String>();
	private List<String> listNsx= new ArrayList<String>();
		
	
	public void xoaTable() {
		modelCTLK.addRow(new Object[] {});
		DefaultTableModel tbl = (DefaultTableModel) tableCTLK.getModel();
		tbl.getDataVector().removeAllElements();
	}
	/**
	 * Create the frame.
	 */
	private void them() {
		int row = tableCTLK.getSelectedRow();
		int maLK = Integer.parseInt(tableCTLK.getValueAt(row, 1).toString());

		boolean check = true;
		while(check) {
			try {
				String soLuongLKObj = JOptionPane.showInputDialog("Nhập số lượng linh kiện mua.",JOptionPane.YES_NO_CANCEL_OPTION);
				if(soLuongLKObj == null) {
					check = false;
				}
				else if(soLuongLKObj != null) {
					if(soLuongLKObj.matches("^[0-9]+{10}$")) {
						int soLuongLKInt = Integer.parseInt(soLuongLKObj.toString());
						System.out.println(lhd_dao.soLuongLKDaBan(maLK));
						System.out.println(lhd_dao.soLuongNhap(maLK));
						if((lhd_dao.soLuongLKDaBan(maLK) + soLuongLKInt) <= lhd_dao.soLuongNhap(maLK)) {

							LapHoaDonGUI.txtSoLuong.setText(soLuongLKObj);
							LapHoaDonGUI.danhSachLKTheoMaLK(maLK);
							this.setVisible(false);
							check = false;
						}
						else
							JOptionPane.showMessageDialog(this, "Số lượng linh kiện cần mua vượt giới hạn linh kiện trong kho!\n Nhập Số Lượng Ít Hơn "+
									(lhd_dao.soLuongNhap(maLK)-lhd_dao.soLuongLKDaBan(maLK)));
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
		}
	}
}
