package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import connectDB.ConnectDB;
import entity.DiaChi;
import entity.HoaDon;
import entity.NhanVien;




public class DiaChiDAO {
	

	public DiaChiDAO() {
	}

	

	public ArrayList<DiaChi> gettalltbDC(){

	
			ArrayList<DiaChi> dsdc = new ArrayList<DiaChi>();
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				String sql = "select * from DiaChi";
				java.sql.Statement statement =  con.createStatement();
				ResultSet rs = ((java.sql.Statement) statement).executeQuery(sql);
				while( rs.next()) {
					int maDC = rs.getInt(1);
					String soNha =rs.getString(2);
					String tenDuong = rs.getString(3);
					String phuongXa = rs.getString(4);
					String quanHuyen = rs.getString(5);
					String tinhTP = rs.getString(6);
					String quocGia = rs.getString(7);
					DiaChi dc = new DiaChi(maDC, soNha, tenDuong, phuongXa,  quanHuyen, tinhTP, quocGia);
					dsdc.add(dc);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			return dsdc;
		}
//		
	}



