package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connectDB.ConnectDB;

import entity.TaiKhoan;



public class TaiKhoanDAO {
	private TaiKhoan taiKhoan;
	public TaiKhoanDAO() {
		ConnectDB.getInstance().connect();
	}
	public TaiKhoan loadTaiKhoan(String tenDangNhap,String matKhau) {
		TaiKhoan taiKhoan = null;
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			PreparedStatement stmt = null;
			String sql  = "select  tentaiKhoan, matKhau, loaiTK\r\n" + 
					"					from TaiKhoan\r\n" + 
					"					where tentaiKhoan='?' and matKhau='?'";
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1,tenDangNhap);
			stmt.setString(2, String.valueOf(matKhau));
//			ResultSet rs = stmt.executeQuery();
//			while(rs.next()) {
//				String ten = rs.getString(1).trim();
//				String mk = rs.getString(2).trim();
//				String loaiTk = rs.getString(3).trim();
//				taiKhoan  = new TaiKhoan(ten, mk, loaiTk);
//			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return taiKhoan;
	}
	

}
