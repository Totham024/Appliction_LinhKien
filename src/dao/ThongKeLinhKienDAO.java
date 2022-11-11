package dao;

import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import entity.ThongKeDoanhThuTQ;
import entity.ThongKeTheoLinhKien;
import gui.THONGKEFULL;




public class ThongKeLinhKienDAO {
	ArrayList<ThongKeTheoLinhKien> ds;
	PreparedStatement pre;
	ResultSet rs;
	Connection con;
	public ThongKeLinhKienDAO() {
		ds = new ArrayList<ThongKeTheoLinhKien>();
	}


//	public List<ThongKeTheoLinhKien> danhSachLKConLai() {
//		List<ThongKeTheoLinhKien> ds = new ArrayList<>();
//		try {
//			ConnectDB.getInstance().connect();
//			Connection con = ConnectDB.getInstance().getConnection();
//			String sql  = "select t.MaLK,t.TenLK,CONVERT (nvarchar(20), l.tenLoai, 103),t.SoLuong,t.giaNhap,CONVERT (nvarchar(10), t.ngayNhap, 103),t.thuongHieu,t.nuocSX\r\n" + 
//					"		from  LinhKien t join loaiLK l  on t.maLoai=  l.maLoai";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//
//			while(rs.next()) {
//				ThongKeTheoLinhKien lk = new ThongKeTheoLinhKien();
//				lk.setMaLK(rs.getInt(1));
//				lk.setTenLK(rs.getString(2));
//				lk.setLoaiLK(rs.getString(3));
//				lk.setSoLuong(rs.getInt(4));
//				String tt= String.valueOf(5);	
//				
//				lk.setThuongHieu(rs.getString(7));
//				lk.setNuocSX(rs.getString(8));
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return ds;

	
		public List<ThongKeTheoLinhKien> thongKelinhkienDaBan(int ngay,int thang, int nam) throws ClassNotFoundException {
			List<ThongKeTheoLinhKien> listTH = new ArrayList<ThongKeTheoLinhKien>();
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql="select  t.MaLK,t.TenLK,l.tenLoai,ct.SoLuong,sum(t.giaNhap*1.1) as donGia,t.ngayNhap, t.thuongHieu,t.nuocSX\r\n" + 
					"												from CTHoaDon ct left join LinhKien t on t.MaLK = ct.MaLK  join HoaDon h on h.MaHD=ct.MaHD join loaiLK l on t.maLoai= l.maLoai\r\n" + 
					"												where ct.MaHD is not null and  day(h.[NgayLap])="+ngay+"  and month(h.[NgayLap]) = "+thang+" and year(h.[NgayLap]) ="+nam+"\r\n" + 
					"												group by t.MaLK,t.TenLK,l.tenLoai,ct.SoLuong, donGia,t.ngayNhap, t.thuongHieu,t.nuocSX";
			Statement statement;
			try {
				statement = con.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				while(rs.next()) {
					int maLK = rs.getInt(1);
					String tenLK = rs.getString(2);
					String loaiLK= rs.getString(3);
					int slban = rs.getInt(4);
					String don= rs.getString(5);	
					double donGia = Double.parseDouble(don);
					Date ngaynhap = rs.getDate(6);
					String thuongHieu= rs.getString(7);	
					String nuocSX= rs.getString(8);			
					ThongKeTheoLinhKien linhkien = new ThongKeTheoLinhKien(maLK, tenLK,loaiLK,slban,donGia, ngaynhap, thuongHieu, nuocSX);	
					listTH.add(linhkien);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return listTH;
		}
	
	//Thống kê Danh sách đã bán theo Ngày
//	public void danhsachLKDaBan(int ngay,int thang,int nam) {
//		try {
//			Connection con = ConnectDB.getInstance().getConnection();
//			PreparedStatement stmt = null;
//			String sql = "select  t.MaLK,t.TenLK,sum(ct.SoLuong) as SoLuong,t.giaNhap,(t.giaNhap*1.1)as donGia,t.ngayNhap, t.thuongHieu,t.nuocSX\r\n" + 
//					"		from CTHoaDon ct left join LinhKien t on t.MaLK = ct.MaLK  join HoaDon h on h.MaHD=ct.MaHD\r\n" + 
//					"		where ct.MaHD is not null and  day(h.[NgayLap])="+ngay+"  and month(h.[NgayLap]) = "+thang+" and year(h.[NgayLap]) ="+nam+"\r\n" + 
//					"		group by t.MaLK,t.TenLK,ct.SoLuong,t.giaNhap, donGia,t.ngayNhap, t.thuongHieu,t.nuocSX";
//			stmt = con.prepareStatement(sql);
//		
//			ResultSet rs = stmt.executeQuery();
//			int i=0;
//			String maHoaDonSoSanh= "";
//			Object [] ds = null;
//			int tongSLT = 0;
//			int checkNull=0;
//			while(rs.next()) {
//				//if(rs.getString(1).equalsIgnoreCase(maHoaDonSoSanh)==false) {
//					++i;
//					String stt = i +"";
//					ds = new String [] { stt ,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)}; 
//					//maHoaDonSoSanh = rs.getString(1);
//					THONGKEFULL.tablemodel1.addRow( ds);
//					tongSLT += rs.getDouble(4);
//					checkNull++;
//					
//				//}	
//			}
//			if(checkNull==0) {
//				JOptionPane.showMessageDialog(null,"Không có dữ liệu của ngày:"+ngay+"/"+thang+"/"+nam);
//			}
//			THONGKEFULL.txtTongSoLuonglk.setText(tongSLT+"");
//			
//		
//			
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
//	}

	public int tinhTongLoaLKDaBan(int ngay,int thang, int nam) throws Exception {
		int tongLoai = 0;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "\r\n" + 
					"					select COUNT(distinct ct.MaLK) as TongLKDaBan\r\n" + 
					"		from CTHoaDon ct join HoaDon h on ct.MaHD=h.maHD\r\n" + 
					"						where day(h.[NgayLap]) =?  and month(h.[NgayLap]) = ? and year(h.[NgayLap]) =?";
			pre = con.prepareStatement(sql);
			pre.setInt(1, ngay);
			pre.setInt(2, thang);
			pre.setInt(3, nam);
			rs = pre.executeQuery();
			
			while (rs.next()) {
				tongLoai = rs.getInt(1);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return tongLoai;
	}
	
	
	public void danhsachLKConLaiTrongKho() {
		DecimalFormat tien = new DecimalFormat("#,##0.00");
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = ConnectDB.getInstance().getConnection();
			PreparedStatement stmt = null;
			String sql = "	select t.MaLK,t.TenLK,l.tenLoai,t.SoLuong,CONVERT (nvarchar(10), t.ngayNhap, 103),t.thuongHieu,t.nuocSX\r\n" + 
					"		from  LinhKien t join loaiLK l  on t.maLoai=  l.maLoai\r\n" + 
					"		where t.SoLuong>0 \r\n" + 
					"		group by t.MaLK,t.TenLK,l.tenLoai,t.SoLuong,CONVERT (nvarchar(10), t.ngayNhap, 103),t.thuongHieu,t.nuocSX";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			int i=0;
			Object [] ds = null;
			int checkNull=0;
			int tongSoLuongNhap =0;
			while(rs.next()) {
					++i;
					String stt = i +"";
					ds = new String [] { stt ,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)}; 
					THONGKEFULL.tablemodel1.addRow( ds);
					tongSoLuongNhap +=rs.getInt(4);
					checkNull++;
			}
			if(checkNull==0) {
				JOptionPane.showMessageDialog(null,"Không còn linh kiện trong kho ngày này");
			}
		
			THONGKEFULL.txtTongSoLoailk.setText(i + "");
			THONGKEFULL.txtTongSoLuonglk.setText(tongSoLuongNhap+"");
		
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	
	public ArrayList<ThongKeTheoLinhKien> ThongkeLKcongtrongkho() {
		ArrayList<ThongKeTheoLinhKien> ds = null;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt=null;

			String sql ="select t.MaLK,t.TenLK,l.tenLoai,t.SoLuong,CONVERT (nvarchar(10), t.ngayNhap, 103),t.thuongHieu,t.nuocSX\r\n" + 
					"		from  LinhKien t join loaiLK l  on t.maLoai=  l.maLoai\r\n" + 
					"		where t.SoLuong>0 \r\n" + 
					"		group by t.MaLK,t.TenLK,l.tenLoai,t.SoLuong,CONVERT (nvarchar(10), t.ngayNhap, 103),t.thuongHieu,t.nuocSX";
			stmt = con.prepareStatement(sql);
			ResultSet rs;
			rs = stmt.executeQuery();
			ds = new ArrayList<>();
			while (rs.next()) {
				 int maLK = rs.getInt(1);
				 String tenLK =rs.getString(2);
				 String loaiLK =rs.getString(3);
				 int soLuong= rs.getInt(4);
				 double giaNhap = rs.getDouble(5);
				 String ngayNhap = rs.getString(6);
				 String thuongHieu = rs.getString(7);
				 String nuocSX = rs.getString(8);
				ThongKeTheoLinhKien lk = new ThongKeTheoLinhKien(maLK, tenLK, loaiLK, soLuong, giaNhap, ngayNhap, thuongHieu, nuocSX);
				ds.add(lk);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			System.out.println("Loi ");
		} finally {
		}
		return ds;

	}
	
//	public ArrayList<LinhKien> getAllLK1() {
//		ArrayList<LinhKien> ds= new ArrayList<LinhKien>();
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			String sql = "select *from  LinhKien" ;
//			Statement stmt = con.createStatement();
//			ResultSet rs = stmt.executeQuery(sql);
//			while(rs.next()) {
//				 int maLK = rs.getInt(1);
//				 String tenLK =rs.getString(2);
//				 String LoaiLK =rs.getString(3);
//				 LoaiLK linhkien = new LoaiLK();
//				 linhkien.setTenLoai(tenLK);
//				 int soLuong= rs.getInt(4);
//				 byte[] giaNhap = rs.getBytes(4);
//					BigInteger gn = new BigInteger(giaNhap);
//				 String ngayNhap = rs.getString(6);
//				 String thuongHieu = rs.getString(7);
//				 String nuocSX = rs.getString(8);
//				LinhKien lk = new LinhKien(maLK, tenLK, linhkien, soLuong, giaNhap, ngayNhap, thuongHieu, nuocSX);
//				ds.add(lk);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return ds;
//	}
	
	public static void main(String[] args) {
		ThongKeLinhKienDAO c = new ThongKeLinhKienDAO();
		LocalDate localDate = LocalDate.of(2020, 11, 11);
		Date date = Date.valueOf("2020-11-11");
		System.out.println(localDate);
		System.out.println(date);
//		dsThongKeTTLK.danhSachThuocHetHan(date).forEach(x->{
//			System.out.println(x);
//		});
		
	}
	public ArrayList<String> getLoaiLK() {
		ArrayList<String> list = new  ArrayList<String>();

		try {
			
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select distinct k.tenloai from linhkien l join loaiLK k on l.maloai= k.maloai";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String tenLK= rs.getString(1);
				list.add(tenLK);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public int tinhTonglkDaBan(int ngay,int thang, int nam) throws Exception {
		int tong = 0;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "	select SUM( ct.soLuong) as TongLKDaBan\r\n" + 
					"							from CTHoaDon ct join HoaDon h on ct.MaHD=h.maHD \r\n" + 
					"											where day(h.[NgayLap]) =?  and month(h.[NgayLap]) = ? and year(h.[NgayLap]) =?";
			pre = con.prepareStatement(sql);
			pre.setInt(1, ngay);
			pre.setInt(2, thang);
			pre.setInt(3, nam);
			rs = pre.executeQuery();
			
			while (rs.next()) {
				tong = rs.getInt(1);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return tong;
	}
}
