package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import entity.ThongKeHDTheoNhanVien;
import gui.THONGKEFULL;





public class TKHDTheoNVDAO {
	ArrayList<ThongKeHDTheoNhanVien> ds;
	ThongKeHDTheoNhanVien tknv;
	public TKHDTheoNVDAO()
	{
		ds= new ArrayList<ThongKeHDTheoNhanVien>();
	}

	public ArrayList<ThongKeHDTheoNhanVien> docBang(String ngayBan){
		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
			Connection con = ConnectDB.getInstance().getConnection();
			
			CallableStatement command = con.prepareCall("{call ThongKeNhanVien(?)}");
			command.setString(1, ngayBan);

			// ResultSet rs = command.executeQuery();
			ResultSet rs = command.executeQuery();
			// duyet ket qua
			while (rs.next()) {
				
//				select t.maLK,t.[TenLK],sum(ct.soLuong)as SoLuong,t.giaNhap,(t.giaNhap*1.1)as donGia,nv.[MaNV],
//				nv.tenNV,h.[NgayLap],sum(ct.[SoLuong]*[donGia])
				String maLK = rs.getString(1);
				String tenLK = rs.getString(2);
				String soLuong= rs.getString(3);
				String  dongGia = rs.getString(4);
				String  giaNhap = rs.getString(5);
				String maNhanVien =rs.getString(6);
				String tenNhanVien = rs.getString(7);
				String ngay = rs.getString(8);
				String thanhTien = rs.getString(9);
				ThongKeHDTheoNhanVien tk = new ThongKeHDTheoNhanVien();
				DecimalFormat df=new DecimalFormat("#,###.0(VND)");
				ThongKeHDTheoNhanVien s = new ThongKeHDTheoNhanVien(ngay,maNhanVien, tenNhanVien,tk.getMaHD(),maLK,tenLK, Integer.parseInt(soLuong), Double.parseDouble(dongGia),Double.parseDouble(thanhTien));
				ds.add(s);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ds;

	}


	public ArrayList<ThongKeHDTheoNhanVien> chonTenNhanVien(String ngayBan){
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = ConnectDB.getInstance().getConnection();
			CallableStatement command = con.prepareCall("{call LocTenNhanVien(?)}");
			command.setString(1, ngayBan);

			ResultSet rs = command.executeQuery();
			while(rs.next())
			{
				String maNhanvVien = rs.getString(1);
				String tenNhanVien = rs.getString(2);
				ThongKeHDTheoNhanVien tk = new ThongKeHDTheoNhanVien();
				ThongKeHDTheoNhanVien s = new ThongKeHDTheoNhanVien(tk.getNgayLap(),maNhanvVien, tenNhanVien, tk.getMaHD(),tk.getMaLK(),tk.getTenLK(), tk.getSoLuong(),tk.getDonGia(),tk.getLoiNhuan());
				ds.add(s);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ds;

	}

	public ArrayList<ThongKeHDTheoNhanVien> chonMaNhanVien(){
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql ="select  MaNV,TenNV\r\n" + 
					"from NhanVien ";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next())
			{
				String maNhanvVien = rs.getString(1);
				String tenNhanVien = rs.getString(2);
				ThongKeHDTheoNhanVien tk = new ThongKeHDTheoNhanVien();
				ThongKeHDTheoNhanVien s = new ThongKeHDTheoNhanVien(tk.g,maNhanvVien, tenNhanVien, tk.getMaHD(),tk.getMaLK(),tk.getTenLK(), tk.getSoLuong(),tk.getDonGia(),tk.getLoiNhuan());
				ds.add(s);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ds;
	}



	
	public void thongKeNhanVienLapHoaDonTheoNgay(int ngay,int thang,int nam) {
		DecimalFormat tien = new DecimalFormat("###,###,### VND");
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			PreparedStatement stmt = null;
			String sql = "select t.MaLK,t.TenLK,sum(ct.SoLuong) as SoLuong,t.giaNhap,(t.giaNhap*1.1)as donGia,nv.[MaNV],\r\n" + 
					"		nv.tenNV,h.NgayLap,sum(ct.SoLuong*donGia) \r\n" + 
					"		from CTHoaDon ct left join LinhKien t on ct.maLK = t.maLK left join HoaDon h on h.MaHD = ct.MaHD left join NhanVien nv on h.MaNV = nv.MaNV\r\n" + 
					"	where day(h.[NgayLap]) =?  and month(h.[NgayLap]) = ? and year(h.[NgayLap]) =?\r\n" + 
					"		group by t.MaLK,t.TenLK, ct.SoLuong,t.giaNhap,donGia,nv.[MaNV],nv.tenNV,h.NgayLap";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1,ngay);
			stmt.setInt(2, thang);
			stmt.setInt(3, nam);
			ResultSet rs = stmt.executeQuery();
			int i=0;
			String maHoaDonSoSanh= "";
			Object [] ds = null;
			int checkNull=0;
			double tongTienDaBan = 0;
			int tongSoLuongThuocDaBan =0;
			while(rs.next()) {
				if(rs.getString(1).equalsIgnoreCase(maHoaDonSoSanh)==false) {
					++i;
					String stt = i +"";
					ds = new String [] { stt ,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),tien.format(rs.getDouble(5)),rs.getString(6),rs.getString(7)}; 
					maHoaDonSoSanh = rs.getString(1);
				//	THONGKEFULL.tablemodel.addRow( ds);
					tongTienDaBan += rs.getDouble(5);
					tongSoLuongThuocDaBan +=rs.getInt(7);
					 checkNull++;
				}	
			}
		if(checkNull==0) {
				JOptionPane.showMessageDialog(null, "Không có dữ liệu của ngày:"+ngay+"/"+thang+"/"+nam);
			}
			
			THONGKEFULL.txtTongTienDaBan.setText(tien.format(tongTienDaBan));
			THONGKEFULL.txtTongSoHD.setText(i+"");
			THONGKEFULL.txtTongSLTDB.setText(tongSoLuongThuocDaBan +"");
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	public void thongKeNhanVienLapHoaDon_TheoNgay_TheoMaTatCa1(int ngay,int thang,int nam,int maNhanVien) {
		DecimalFormat tien = new DecimalFormat("###,###,### VND");
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			PreparedStatement stmt = null;
			String sql = "	select t.maLK,t.[TenLK],sum(ct.soLuong)as SoLuong,ct.donGia,nv.[MaNV],\r\n" + 
					"		nv.tenNV,h.maHD,h.[NgayLap],sum(ct.[SoLuong]*ct.donGia)\r\n" + 
					"		from [dbo].[CTHoaDon] ct left join [dbo].[LinhKien] t on ct.[MaLK]= t.[MaLK] \r\n" + 
					"		left join [dbo].[HoaDon] h on h.[MaHD]= ct.[MaHD] left join [dbo].[NhanVien] nv on h.[MaNV] = nv.[MaNV]\r\n" + 
					"		where day(h.[NgayLap]) =?  and month(h.[NgayLap]) = ? and year(h.[NgayLap]) =? group by t.maLK,t.tenLK,ct.SoLuong,ct.donGia,nv.maNV, nv.tenNV,h.maHD,h.[NgayLap]";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1,ngay);
			stmt.setInt(2, thang);
			stmt.setInt(3, nam);
			ResultSet rs = stmt.executeQuery();
			int i=0;
			String maHoaDonSoSanh= "";
			Object [] ds = null;
			double tongTienDaBan = 0;
			int tongSoLuongDaBan = 0;
			int checkNull=0;
			while(rs.next()) {
				if(rs.getInt(5) == maNhanVien) {
					if(rs.getString(7).equalsIgnoreCase(maHoaDonSoSanh)==false) {
						++i;
						String stt = i +"";
						String tt = rs.getString(4);
						double donGia =  Double.parseDouble(tt);
						ds = new String [] { stt ,rs.getInt(1)+"",rs.getString(2),rs.getInt(3)+"",tien.format(donGia+""),rs.getInt(5)+"",rs.getString(6),rs.getDate(7)+""}; 
						maHoaDonSoSanh = rs.getString(7);
						THONGKEFULL.tablemodel.addRow( ds);
						
						tongTienDaBan += donGia*rs.getInt(3);
						tongSoLuongDaBan +=rs.getInt(3);
						checkNull ++;
					}	
				}
			}
			if(checkNull==0) {
				JOptionPane.showMessageDialog(null,"Không có dữ liệu của ngày:"+ngay+"/"+thang+"/"+nam);
			}
			THONGKEFULL.txtTongTienDaBan.setText(tien.format(tongTienDaBan));
			THONGKEFULL.txtTongSoHD.setText(i+"");
			THONGKEFULL.txtTongSLTDB.setText(tongSoLuongDaBan +"");
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void thongKeNhanVienLapHoaDonKeDon_TheoNgay_TheoMaKeDonKKeDon(int ngay,int thang,int nam,int maNhanVien) {
		DecimalFormat tien = new DecimalFormat("###,###,### VND");
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			PreparedStatement stmt = null;
			String sql = "	select ct.[MaHoaDon],nv.[MaNhanVien],nv.[CaLamViec],CONVERT (nvarchar(10), h.[NgayLap], 103) as NgayLap ,h.[TongTien],t.[PhanLoai],sum(ct.[SoLuong])\r\n" + 
					"									from [dbo].[CT_HoaDon] ct left join [dbo].[Thuoc] t on ct.[MaThuoc]= t.[MaThuoc] left join [dbo].[HoaDon] h on h.[MaHoaDon]= ct.[MaHoaDon] left join [dbo].[NhanVien] nv on h.[MaNhanVien] = nv.[MaNhanVien]\r\n" + 
					"									where day(h.[NgayLap]) =?  and month(h.[NgayLap]) = ? and year(h.[NgayLap]) =? and h.MaKhachHang is null \r\n" + 
					"									group by ct.[MaHoaDon],nv.[MaNhanVien],nv.[CaLamViec],h.[NgayLap] ,h.[TongTien],t.[PhanLoai]";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1,ngay);
			stmt.setInt(2, thang);
			stmt.setInt(3, nam);
			ResultSet rs = stmt.executeQuery();
			int i=0;
			String maHoaDonSoSanh= "";
			Object [] ds = null;
			double tongTienDaBan = 0;
			int tongSoLuongThuocDaBan =0;
			int checkNull=0;
			while(rs.next()) {
				if(rs.getInt(2) == maNhanVien) {
					if(rs.getString(1).equalsIgnoreCase(maHoaDonSoSanh)==false) {
						++i;
						String stt = i +"";
						ds = new String [] { stt ,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),tien.format(rs.getDouble(5)),rs.getString(6),rs.getString(7)}; 
						maHoaDonSoSanh = rs.getString(1);
						THONGKEFULL.tablemodel.addRow( ds);
						tongTienDaBan += rs.getDouble(5);
						tongSoLuongThuocDaBan +=rs.getInt(7);
						checkNull ++;
					}	
				}
			}
			if(checkNull==0) {
				JOptionPane.showMessageDialog(null, "Không có dữ liệu của ngày:"+ngay+"/"+thang+"/"+nam);
			}
			THONGKEFULL.txtTongTienDaBan.setText(tien.format(tongTienDaBan));
			THONGKEFULL.txtTongSoHD.setText(i+"");
			THONGKEFULL.txtTongSLTDB.setText(tongSoLuongThuocDaBan +"");
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	

	public void thongKeNhanVienLapHoaDon_TheoNgay_TheoMaTatCa(int ngay,int thang,int nam,int maNhanVien) {
		DecimalFormat tien = new DecimalFormat("###,###,### VND");
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			PreparedStatement stmt = null;
			String sql = "	select ct.[MaHoaDon],nv.[MaNhanVien],nv.[CaLamViec],CONVERT (nvarchar(10), h.[NgayLap], 103) as NgayLap ,h.[TongTien],t.[PhanLoai],sum(ct.[SoLuong])\r\n" + 
					"									from [dbo].[CT_HoaDon] ct left join [dbo].[Thuoc] t on ct.[MaThuoc]= t.[MaThuoc] left join [dbo].[HoaDon] h on h.[MaHoaDon]= ct.[MaHoaDon] left join [dbo].[NhanVien] nv on h.[MaNhanVien] = nv.[MaNhanVien]\r\n" + 
					"									where day(h.[NgayLap]) =?  and month(h.[NgayLap]) = ? and year(h.[NgayLap]) =?  \r\n" + 
					"									group by ct.[MaHoaDon],nv.[MaNhanVien],nv.[CaLamViec],h.[NgayLap] ,h.[TongTien],t.[PhanLoai]";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1,ngay);
			stmt.setInt(2, thang);
			stmt.setInt(3, nam);
			ResultSet rs = stmt.executeQuery();
			int i=0;
			String maHoaDonSoSanh= "";
			Object [] ds = null;
			double tongTienDaBan = 0;
			int tongSoLuongThuocDaBan =0;
			int checkNull=0;
			while(rs.next()) {
				if(rs.getInt(2) == maNhanVien) {
					if(rs.getString(1).equalsIgnoreCase(maHoaDonSoSanh)==false) {
						++i;
						String stt = i +"";
						ds = new String [] { stt ,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),tien.format(rs.getDouble(5)),rs.getString(6),rs.getString(7)}; 
						maHoaDonSoSanh = rs.getString(1);
						THONGKEFULL.tablemodel.addRow( ds);
						tongTienDaBan += rs.getDouble(5);
						tongSoLuongThuocDaBan +=rs.getInt(7);
						checkNull ++;
					}	
				}
			}
			if(checkNull==0) {
				JOptionPane.showMessageDialog(null,"Không có dữ liệu của ngày:"+ngay+"/"+thang+"/"+nam);
			}
			THONGKEFULL.txtTongTienDaBan.setText(tien.format(tongTienDaBan));
			THONGKEFULL.txtTongSoHD.setText(i+"");
			THONGKEFULL.txtTongSLTDB.setText(tongSoLuongThuocDaBan +"");
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	


//	public void XemThongtinCTHoaDon(String maHD) {
//		/*THONGKEFULL.frmXuatHD.tableModel.addRow(new Object[] {
//
//		});
//		THONGKEFULL.frmXuatHD.tableModel = (DefaultTableModel) THONGKEFULL.frmXuatHD.table.getModel();
//		THONGKEFULL.frmXuatHD.tableModel.getDataVector().removeAllElements();*/
//		try {
//			Connection con = ConnectDB.getInstance().getConnection();
//			PreparedStatement stmt = null;
//			String sql = "select t.[TenThuoc],t.[DonViTinh],ct.[DonGia],ct.[SoLuong],ct.[GiamGia],ct.[DonGia]*ct.[SoLuong]\r\n" + 
//					"from [dbo].[CT_HoaDon] ct join [dbo].[HoaDon] h\r\n" + 
//					"on ct.[MaHoaDon]=h.MaHoaDon join Thuoc t \r\n" + 
//					"on t.MaThuoc=ct.MaThuoc\r\n" + 
//					"where ct.MaHoaDon=?\r\n" + 
//					"";
//			stmt = con.prepareStatement(sql);
//			stmt.setString(1,maHD);
//			ResultSet rs = stmt.executeQuery();
//			int i=0;
//			Object [] ds = null;
//			while(rs.next()) {
//				++i;
//				ds = new String [] { i+"" ,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)}; 
//
//				THONGKEFULL.frmXuatHD.tableModel.addRow(ds);
//			}	
//			THONGKEFULL.frmXuatHD.lblSL.setText(i+"");
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
//	}






//	public void XemThongtinCTHoaDonn(String maHD) {
//		DecimalFormat tien = new DecimalFormat("###,###,### VND");
//		try {
//			Connection con = ConnectDB.getInstance().getConnection();
//			PreparedStatement stmt = null;
//			String sql = "select ct.[MaHoaDon],t.[PhanLoai],CONVERT (nvarchar(10), h.[NgayLap], 103) as NgayLap,h.TongTien\r\n" + 
//					"					from [dbo].[CT_HoaDon] ct join [dbo].[HoaDon] h\r\n" + 
//					"					on ct.[MaHoaDon]=h.MaHoaDon join Thuoc t \r\n" + 
//					"					on t.MaThuoc=ct.MaThuoc\r\n" + 
//					"					where ct.MaHoaDon=?";
//			stmt = con.prepareStatement(sql);
//			stmt.setString(1,maHD);
//			ResultSet rs = stmt.executeQuery();
//			int i=0;
//			Object [] ds = null;
//			boolean checkKeDon = false;
//			double tienThuoc = 0;
//			while(rs.next()) {
//				//Frmrs.getString(1),rs.getString(2),rs.getString(3)}; 
//				THONGKEFULL.frmXuatHD.lblMaHD.setText(rs.getString(1));
//				if(rs.getString(2).equalsIgnoreCase("Thuốc kê đơn")) {
//					checkKeDon = true;
//				}
//				tienThuoc= rs.getDouble(4);
//				THONGKEFULL.frmXuatHD.lblNgayLap1.setText(rs.getString(3));
//			}	
//			if(checkKeDon==true) {
//				THONGKEFULL.frmXuatHD.lblLoaiHD1.setText("Thuốc kê đơn");
//			}
//			else 
//				THONGKEFULL.frmXuatHD.lblLoaiHD1.setText("Không kê đơn");
//			THONGKEFULL.frmXuatHD.lblTongTThuoc.setText(tien.format(tienThuoc));
//			THONGKEFULL.frmXuatHD.lblTongT.setText(tien.format(tienThuoc));
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
//	}


//	public void XemThongtinCTHoaDonnn(String maHD) {
//		
//		DecimalFormat tien = new DecimalFormat("###,###,### VND");
//		try {
//			Connection con = ConnectDB.getInstance().getConnection();
//			PreparedStatement stmt = null;
//			String sql = "\r\n" + 
//					"select HoTen=kh.[Ho]+''+kh.[Ten],CONVERT (nvarchar(10), kh.[NgaySinh], 103) as NgaySinh,kh.[GioiTinh],kh.[SoDienThoai],kh.[MaDiaChi],HoTen=nv.[Ho]+''+nv.[Ten]\r\n" + 
//					"from [dbo].[CT_HoaDon] ct join [dbo].[HoaDon] h\r\n" + 
//					"on ct.[MaHoaDon]=h.MaHoaDon join KhachHang kh on kh.MaKhachHang=h.MaKhachHang join Thuoc t \r\n" + 
//					"on t.MaThuoc=ct.MaThuoc join [dbo].[NhanVien] nv on nv.[MaNhanVien]=h.MaNhanVien\r\n" + 
//					"where h.MaHoaDon=?";
//			stmt = con.prepareStatement(sql);
//			stmt.setString(1,maHD);
//			ResultSet rs = stmt.executeQuery();
//			int i=0;
//			Object [] ds = null;
//			boolean checkKeDon = false;
//			double tienThuoc = 0;
//			while(rs.next()) {
//				//Frmrs.getString(1),rs.getString(2),rs.getString(3)}; 
//				THONGKEFULL.frmXuatHD.lblTenKH1.setText(rs.getString(1));
//				THONGKEFULL.frmXuatHD.lblNamSinh1.setText(rs.getString(2));
//				THONGKEFULL.frmXuatHD.lblGTinh1.setText(rs.getString(3));
//				THONGKEFULL.frmXuatHD.lblsdtkh1.setText(rs.getString(4));
//				THONGKEFULL.frmXuatHD.lblDCKH1.setText(rs.getString(5));
//				THONGKEFULL.frmXuatHD.lblNguoiBan.setText(rs.getString(6));
//				THONGKEFULL.frmXuatHD.lblNguoiMuaHang1.setText(rs.getString(1));
//				
//				
//				
//				if(rs.getString(2).equalsIgnoreCase("Thuốc kê đơn")) {
//					checkKeDon = true;
//				}
//			}	
//			
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
//	}

















}
