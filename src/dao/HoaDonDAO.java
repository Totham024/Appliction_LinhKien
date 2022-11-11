package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.CTHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.LinhKien;
import entity.NhanVien;

public class HoaDonDAO {

	public ArrayList<HoaDon> getAllHD() {
		ArrayList<HoaDon> dsHD= new ArrayList<HoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select [maHD],[ngayLap],[tongTien],nv.tenNV,k.tenKH\r\n" + 
					"from [dbo].[HoaDon] h join [dbo].[KhachHang] k on h.[maKH]= k.maKH join [dbo].[NhanVien] nv on h.maNV= nv.maNV ";

				
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				int maHD = rs.getInt(1);
				Date ngayLap= rs.getDate(2);
				double tongtien = rs.getDouble(3);
				String nv = rs.getString(4);
				NhanVien nhanVien = new NhanVien(nv);
				String kh = rs.getString(5);
				KhachHang khachHang = new KhachHang(kh);
				HoaDon hd = new HoaDon(maHD, ngayLap,tongtien, nhanVien, khachHang);
				dsHD.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHD;
	}

	public List<CTHoaDon> getCTByMaHD(int ma) {
		ArrayList<CTHoaDon> dsCT= new ArrayList<CTHoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select ct.maHD,ct.maLK,l.tenLK, ct.soLuong,l.donViTinh,l.baoHanh,donGia  from CTHoaDon ct join LinhKien l on ct.maLK= l.maLK where maHD ="+ma+"";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int hd = rs.getInt(1);
				HoaDon hoaDon = new HoaDon(hd);
				int malk = rs.getInt(2);
				String lk = rs.getString(3);
				int soLuong =rs.getInt(4);
				String dvt = rs.getString(5);
				String bh = rs.getString(6);
				LinhKien linhKien= new LinhKien(malk,lk,dvt,bh);
				
				long donGia = rs.getLong(7);
				CTHoaDon ct = new CTHoaDon(linhKien, hoaDon, soLuong, donGia);
				dsCT.add(ct);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsCT;
	}

	public List<HoaDon> getHDByMa(String tim) {
		ArrayList<HoaDon> dsHD= new ArrayList<HoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select [maHD],[ngayLap],[tongTien],nv.tenNV,k.tenKH\r\n" + 
					"from [dbo].[HoaDon] h join [dbo].[KhachHang] k \r\n" + 
					"on h.[maKH]= k.maKH join [dbo].[NhanVien] nv on h.maNV= nv.maNV\r\n" + 
					"where h.maHD="+ tim +" ";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				int maHD = rs.getInt(1);
				Date ngayLap= rs.getDate(2);
				double tongtien = rs.getDouble(3);
				String nv = rs.getString(4);
				NhanVien nhanVien = new NhanVien(nv);
				String kh = rs.getString(5);
				KhachHang khachHang = new KhachHang(kh);
				HoaDon hd = new HoaDon(maHD, ngayLap,tongtien, nhanVien, khachHang);
				dsHD.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHD;
	}

	

	public List<HoaDon> getHDByTenNV(String tim) {
		ArrayList<HoaDon> dsHD= new ArrayList<HoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select [maHD],[ngayLap],[tongTien],nv.tenNV,k.tenKH\r\n" + 
					"from [dbo].[HoaDon] h join [dbo].[KhachHang] k \r\n" + 
					"on h.[maKH]= k.maKH join [dbo].[NhanVien] nv on h.maNV= nv.maNV\r\n" + 
					"where nv.tenNV =N'"+tim+"' ";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				int maHD = rs.getInt(1);
				Date ngayLap= rs.getDate(2);
				double tongtien = rs.getDouble(3);
				String nv = rs.getString(4);
				NhanVien nhanVien = new NhanVien(nv);
				String kh = rs.getString(5);
				KhachHang khachHang = new KhachHang(kh);
				HoaDon hd = new HoaDon(maHD, ngayLap,tongtien, nhanVien, khachHang);
				dsHD.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHD;
	}

	public List<HoaDon> getHDByTenKH(String tim) {
		ArrayList<HoaDon> dsHD= new ArrayList<HoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select [maHD],[ngayLap],[tongTien],nv.tenNV,k.tenKH\r\n" + 
					"from [dbo].[HoaDon] h join [dbo].[KhachHang] k \r\n" + 
					"on h.[maKH]= k.maKH join [dbo].[NhanVien] nv on h.maNV= nv.maNV\r\n" + 
					"where  k.tenKH =N'"+tim+"' ";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				int maHD = rs.getInt(1);
				Date ngayLap= rs.getDate(2);
				double tongtien = rs.getDouble(3);
				String nv = rs.getString(4);
				NhanVien nhanVien = new NhanVien(nv);
				String kh = rs.getString(5);
				KhachHang khachHang = new KhachHang(kh);
				HoaDon hd = new HoaDon(maHD, ngayLap,tongtien, nhanVien, khachHang);
				dsHD.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHD;
	}

	public List<HoaDon> getHDByNgayNhap(int ngay, int thang, int nam) {
		ArrayList<HoaDon> dsHD= new ArrayList<HoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select [maHD],[ngayLap],[tongTien],nv.tenNV,k.tenKH\r\n" + 
					"from [dbo].[HoaDon] h join [dbo].[KhachHang] k \r\n" + 
					"on h.[maKH]= k.maKH join [dbo].[NhanVien] nv on h.maNV= nv.maNV\r\n" + 
					"where DAY([ngayLap]) ="+ngay+" and MONTH([ngayLap])="+thang+" and YEAR([ngayLap])="+nam+" ";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				int maHD = rs.getInt(1);
				Date ngayLap= rs.getDate(2);
				double tongtien = rs.getDouble(3);
				String nv = rs.getString(4);
				NhanVien nhanVien = new NhanVien(nv);
				String kh = rs.getString(5);
				KhachHang khachHang = new KhachHang(kh);
				HoaDon hd = new HoaDon(maHD, ngayLap,tongtien, nhanVien, khachHang);
				dsHD.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHD;
	}

	

}
