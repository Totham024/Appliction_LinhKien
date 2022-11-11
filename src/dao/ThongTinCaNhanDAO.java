package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connectDB.ConnectDB;
import entity.DiaChi;
import entity.NhanVien;
import entity.TaiKhoan;

public class ThongTinCaNhanDAO {

	public NhanVien loadNhanVien(String taiKhoan) {
		NhanVien nhanVien = new  NhanVien();
		try {
			ConnectDB.getInstance();
			Connection con =ConnectDB.getConnection();
			PreparedStatement stmt = null;
			String sql = "select maNV,tenNV,namSinh,phai,CMND,SoNha,TenDuong,phuongXa,quanHuyen,tinhTP,QuocGia,n.TaiKhoan,MatKhau\r\n" + 
					"					from dbo.NhanVien n join dbo.DiaChi d on n.diaChi = d.maDiaChi join dbo.TaiKhoan t on n.TaiKhoan = t.tentaiKhoan\r\n" + 
					"					where t.tentaiKhoan ='"+taiKhoan+"'";
			stmt = con.prepareStatement(sql);
//			stmt.setString(1,taiKhoan);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				nhanVien.setMaNV(rs.getInt(1));
				nhanVien.setTenNV(rs.getString(2));
				nhanVien.setNamSinh(rs.getInt(3));
				nhanVien.setPhai(rs.getString(4));
				nhanVien.setCMND(rs.getString(5));
				DiaChi diaChi = new DiaChi();
				diaChi.setSoNha(rs.getString(6));
				diaChi.setTenDuong(rs.getString(7));
				diaChi.setPhuongXa(rs.getString(8));
				diaChi.setQuanHuyen(rs.getString(9));
				diaChi.setTinhTP(rs.getString(10));
				diaChi.setNuoc(rs.getString(11));
				nhanVien.setDiaChi(diaChi);
				TaiKhoan tk = new TaiKhoan();
				tk.setTaiKhoan(rs.getString(12));
				tk.setMatKhau(rs.getString(13));
				nhanVien.setTaiKhoan(tk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nhanVien;
	}

	public void updateThongTinCaNhan(NhanVien nhanVien) {
		// TODO Auto-generated method stub
		
	}

	public void updateTaiKhoan(NhanVien nhanVien) {
		// TODO Auto-generated method stub
		
	}

}
