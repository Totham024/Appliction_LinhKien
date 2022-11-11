package dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import connectDB.ConnectDB;
import entity.ThongKeDoanhThuTQ;



public class TKDoanhThuTQDAO {
//	Connection con;
//	PreparedStatement pre;
//	ResultSet rs;

	ArrayList<ThongKeDoanhThuTQ> ds;
//	ThongKeDoanhThuTQ tkbc;

	public TKDoanhThuTQDAO() {
		ConnectDB.getInstance().connect();
		ds = new ArrayList<ThongKeDoanhThuTQ>();
	}
	
	
	
	public List<String> getAllNgay() throws Exception {
		List<String> result = new ArrayList<String>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			String sql = "select NgayLap from HoaDon";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			String ngay;
			while (rs.next()) {
				ngay = rs.getString(1);
				result.add(ngay);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return result;
	}
//	public double tinhTongTienDaNhapTheoThang(int thang, int nam) throws Exception {
//		double tongTien = 0;
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			String sql = "select sum(c.[soLuong]*c.[donGia]) from HoaDon h join CTHoaDon c on h.maHD = c.maHD\r\n" + 
//					"where MONTH(ngayLap)="+thang+" and year(NgayLap)="+nam+"";
//			Statement stmt = con.createStatement();
//			ResultSet rs = stmt.executeQuery(sql);
//			while (rs.next()) {
//				byte[] giaNhap = rs.getBytes(1);
//				BigInteger gn = new BigInteger(giaNhap);
//				BigDecimal I = new BigDecimal(gn);
//				 
//				
//				
//				tongTien = I.doubleValue();
//				  
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//		}
//		return tongTien;
//	}
	public double tinhTongTienBanDuocTheoThang(int thang, int nam) throws Exception {
		double tongTien = 0 ;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			Statement statement = con.createStatement();
			String sql = "select sum(c.[soLuong]*c.[donGia])as'tongTien' from HoaDon h join CTHoaDon c on h.maHD = c.maHD\r\n" + 
					"where MONTH(ngayLap)="+thang+" and year(NgayLap)="+nam+"";
			
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				
				String tt= rs.getString(1);
				tongTien= Double.parseDouble(tt);
				 
				
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} 
		return tongTien;
	}

	 

	public double tinhTongTienlinhkienDaNhapTheoThang(int thang, int nam) throws Exception {
		double tongTien1 = 0 ;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select sum(c.soLuong*lk.giaNhap)as'dt' from HoaDon h join CTHoaDon c\r\n" + 
					"					on h.maHD=c.maHD join LinhKien lk on lk.maLK=c.maLK where month(h.NgayLap) ="+thang+" and year(NgayLap)="+nam+"";
			
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				
				String tt = rs.getString(1);
				 tongTien1 =  Double.parseDouble(tt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return tongTien1;
	}



	public List<ThongKeDoanhThuTQ> thongKelinhkienDaBan_DoanhThu_TheoThang(int thang, int nam) throws ClassNotFoundException {
		List<ThongKeDoanhThuTQ> listTH = new ArrayList<ThongKeDoanhThuTQ>();
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
//		String sql = "\r\n" + 
//				"												select t.maLK,t.tenLK,CONVERT (nvarchar(300),(t.giaNhap*1.1)) as donGia,t.giaNhap, h.NgayLap,t.soLuong AS SoLuongNhap,\r\n" + 
//				"												ct.soLuong as SoLuongBan,ct.SoLuong*ct.DonGia as TienBan,\r\n" + 
//				"												ct.SoLuong*t.GiaNhap as TienNhap\r\n" + 
//				"												from CTHoaDon ct join Linhkien t on ct.maLK= t.maLK join HoaDon h on  ct.maHD=h.maHD\r\n" + 
//				"											where month(NgayLap)="+thang+" and year(NgayLap)="+nam+"\r\n" + 
//				"												group by t.maLK, t.tenLK, donGia,t.GiaNhap, h.NgayLap";
		String sql= "select t.maLK,t.tenLK,ct.donGia,t.giaNhap, h.NgayLap,t.soLuong  ,\r\n" + 
				"														ct.soLuong,ct.SoLuong*ct.DonGia,\r\n" + 
				"															ct.SoLuong*t.giaNhap\r\n" + 
				"from CTHoaDon ct join Linhkien t on ct.maLK= t.maLK join HoaDon h on  ct.maHD=h.maHD \r\n" + 
				"where month(NgayLap)=11 and year(NgayLap)=2020\r\n" + 
				"group by t.maLK, t.tenLK, ct.donGia,t.GiaNhap, h.NgayLap ,t.soLuong , ct.soLuong\r\n" + 
				"";
		Statement statement;
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				int maLK = rs.getInt(1);
				String tenLK = rs.getString(2);
				String don= rs.getString(3);	
				double donGia = Double.parseDouble(don);
				String gia= rs.getString(4);	
				double giaNhap = Double.parseDouble(gia);
				Date ngay = rs.getDate(5);
				int sl = rs.getInt(6);
				String slNhap = String.valueOf(sl);
				int slban = rs.getInt(7);
				String loi= rs.getString(8);	
				double loinhuan = Double.parseDouble(loi);
				String tien= rs.getString(9);	
				double tiennhap = Double.parseDouble(tien);
				ThongKeDoanhThuTQ linhkien = new ThongKeDoanhThuTQ(maLK, tenLK, donGia,giaNhap, ngay, slNhap, slban, loinhuan, tiennhap);	
				listTH.add(linhkien);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listTH;
	}



//	public double tinhTongTienDaNhapTheoThang(int thang, int nam) {
//		double tt = 0;
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			String sql = "select sum(c.soLuong*lk.giaNhap)as'dt' from HoaDon h join CTHoaDon c\r\n" +
//							"on h.maHD=c.maHD join LinhKien lk on lk.maLK=c.maLK where month(h.NgayLap) ="+thang+" and year(NgayLap)="+nam+"";
//			Statement stmt = con.createStatement();
//			ResultSet rs = stmt.executeQuery(sql);
//			while (rs.next()) {
//				byte[] giaNhap = rs.getBytes(1);
//				BigInteger gn = new BigInteger(giaNhap);
//				BigDecimal I = new BigDecimal(gn);
//				tt = I.doubleValue();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return tt;
//	}
	
	
	
	
	

		
	
}



