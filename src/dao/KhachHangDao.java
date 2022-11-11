package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.DiaChi;
import entity.KhachHang;


public class KhachHangDao {
	Connection con;
	PreparedStatement preStm;
	ResultSet rs;

	public KhachHangDao() {
	}

	/**
	 * add Khachhang
	 * 
	 * @param kh
	 * @return true/false
	 */


	/**
	 * ad DiaChi
	 * 
	 * @param dc
	 * @return true/false
	 */
	@SuppressWarnings("static-access")
	public boolean addDiaChi(DiaChi dc) {
		int n = 0;
		try {
			con = ConnectDB.getInstance().getConnection();
			String sql = "insert into dbo.DiaChi values\r\n" + "(?,?,?,?,?,?)";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, dc.getSoNha());
			preStm.setString(2, dc.getTenDuong());
			preStm.setString(3, dc.getPhuongXa());
			preStm.setString(4, dc.getQuanHuyen());
			preStm.setString(5, dc.getTinhTP());
			preStm.setString(6, dc.getNuoc());
			n = preStm.executeUpdate();
		} catch (Exception e3) {
			System.out.println("loi sql them dia chi frm KhachHang");
			e3.printStackTrace();
		}
		return n > 0;
	}

	/**
	 * get all KhachHang
	 * 
	 * @return List<KhachHang>
	 * @throws Exception
	 */
	public ArrayList<KhachHang> getAllKH() {
		ArrayList<KhachHang> dskh= new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from dbo.[KhachHang]";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int maKH = rs.getInt(1);
				String hoTen = rs.getString(2);
				String sdt = rs.getString(3);
				int maDiaChi = rs.getInt(4);
				DiaChi diaChi = new DiaChi();
				diaChi.setMaDC(maDiaChi);
			
				String phai  = rs.getString(5);
				String email = rs.getString(6);
				int namsinh = rs.getInt(7);
				
				KhachHang kh = new KhachHang(maKH, hoTen, sdt, diaChi, phai, email,namsinh);
				//KhachHang kh = new KhachHang(maKH);

				dskh.add(kh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dskh;
	}


	@SuppressWarnings("static-access")
	public KhachHang layThongTinKhachHang(int maKH) throws ClassNotFoundException, SQLException {
		KhachHang dto = null;
		try {
			con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from [dbo].[KhachHang] where MaKH = ?";
			preStm = con.prepareStatement(sql);
			preStm.setInt(1, maKH);
			rs = preStm.executeQuery();
			if (rs.next()) {
				int maKhachHang = rs.getInt(1);
				String hoTen = rs.getString(2);
				String sdt = rs.getString(3);
				int maDiaChi = rs.getInt(4);
				DiaChi diaChi = new DiaChi();
				diaChi.setMaDC(maDiaChi);
				String phai  = rs.getString(5);
				String email = rs.getString(6);
				int namsinh = rs.getInt(7);
				
				dto = new KhachHang(maKhachHang, hoTen, sdt, diaChi, phai, email,namsinh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	public KhachHang getMaDC(int ma) throws SQLException {
		KhachHang list= null;
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		String sql="select maKH, tenKH, d.soNha,d.tenDuong,d.phuongXa,d.quanHuyen,d.tinhTP,d.quocGia\r\n" + 
				"				from KhachHang k join DiaChi d on k.diaChi= d.maDiaChi where d.maDiaChi = "+ma+"";
		Statement statement = con.createStatement();
		ResultSet resultSet= statement.executeQuery(sql);
		while (resultSet.next()) {
			
			int maKH = resultSet.getInt(1);
			String tenKH = resultSet.getString(2);
			String nuoc = resultSet.getString(8);
			String tinhTP = resultSet.getString(7);
			String quanHuyen = resultSet.getString(6);
			String phuongXa= resultSet.getString(5);
			String soNha = resultSet.getString(3);
			String tenDuong = resultSet.getString(4);
			DiaChi diaChi= new DiaChi(nuoc, tinhTP, quanHuyen, phuongXa, soNha,tenDuong );
			KhachHang kh = new KhachHang(maKH, tenKH, diaChi);
			list= kh;
		}
		return list;
	}
	/**
	 * search KhachHang by MaKhachHang
	 * 
	 * @param ma
	 * @return List<KhachHang>
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@SuppressWarnings("static-access")
	public List<KhachHang> timkiemKhachHangByMa(int ma) throws ClassNotFoundException, SQLException {
		List<KhachHang> result = null;
		KhachHang dto;
		try {
			con = ConnectDB.getInstance().getConnection();
			String sql = "select * from KhachHang where maKH like ?";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, "%" + ma + "%");
			rs = preStm.executeQuery();
			result = new ArrayList<>();
			while (rs.next()) {
				int maKhachHang = rs.getInt(1);
				String hoTen = rs.getString(2);
				String sdt = rs.getString(3);
				int maDiaChi = rs.getInt(4);
				DiaChi diaChi = new DiaChi();
				diaChi.setMaDC(maDiaChi);
				String phai  = rs.getString(5);
				String email = rs.getString(6);
				int namsinh = rs.getInt(7);
				
				dto = new KhachHang(maKhachHang, hoTen, sdt, diaChi, phai, email,namsinh);
				result.add(dto);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
		}
		return result;
	}

	/**
	 * search KhachHang by TenKhachHang
	 * 
	 * @param tenn
	 * @return List<KhachHang>
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@SuppressWarnings("static-access")
	public List<KhachHang> timkiemKhachHangByTen(String tenn) throws ClassNotFoundException, SQLException {
		List<KhachHang> result = null;
		KhachHang dto;
		try {
			con = ConnectDB.getInstance().getConnection();
			String sql = "select * from KhachHang where tenKH like ?";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, "%" + tenn + "%");
			rs = preStm.executeQuery();
			result = new ArrayList<>();
			while (rs.next()) {
				int maKhachHang = rs.getInt(1);
				String hoTen = rs.getString(2);
				String sdt = rs.getString(3);
				int maDiaChi = rs.getInt(4);
				DiaChi diaChi = new DiaChi();
				diaChi.setMaDC(maDiaChi);
				String phai  = rs.getString(5);
				String email = rs.getString(6);
				int namsinh = rs.getInt(7);
				
				dto = new KhachHang(maKhachHang, hoTen, sdt, diaChi, phai, email,namsinh);
				result.add(dto);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
		}
		return result;
	}

	/**
	 * search KhachHang by SoDienThoai
	 * 
	 * @param sdt
	 * @return List<KhachHang>
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@SuppressWarnings("static-access")
	public List<KhachHang> timkiemKhachHangBySDT(String dt) throws ClassNotFoundException, SQLException {
		List<KhachHang> result = null;
		KhachHang dto;
		try {
			con = ConnectDB.getInstance().getConnection();
			String sql = "select * from KhachHang where sdt like ?";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, "%" + dt + "%");
			rs = preStm.executeQuery();
			result = new ArrayList<>();
			while (rs.next()) {
				int maKhachHang = rs.getInt(1);
				String hoTen = rs.getString(2);
				String sdt = rs.getString(3);
				int maDiaChi = rs.getInt(4);
				DiaChi diaChi = new DiaChi();
				diaChi.setMaDC(maDiaChi);
				String phai  = rs.getString(5);
				String email = rs.getString(6);
				int namsinh = rs.getInt(7);
				
				dto = new KhachHang(maKhachHang, hoTen, sdt, diaChi, phai, email,namsinh);
				result.add(dto);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			System.out.println("Loi tim khachhang theo sdt sql");
		} finally {
		}
		return result;
	}

	/**
	 * search KhachHang by SoCMND
	 * 
	 * @param cmnd
	 * @return List<KhachHang>
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	

	/**
	 * update KhachHang
	 * 
	 * @param ma
	 * @param ten
	 * @param ho
	 * @param ngaySinh
	 * @param gioiTinh
	 * @param cmnd
	 * @param sdt
	 * @return true/false
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public boolean capnhatKH(int maKhachHang, String hoTen, String
			sdt, String phai, String email,int namsinh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt =null;
		try {
			stmt= con.prepareStatement("Update KhachHang set tenKH = ?, sdt = ?, phai = ?, email = ?, namsinh= ? where maKH = ?");
			stmt.setString(1, hoTen);
			stmt.setString(2, sdt);		
			stmt.setString(3,phai );
			stmt.setString(4,email);
			stmt.setString(5, String.valueOf(namsinh));
			stmt.setString(6, String.valueOf(maKhachHang));
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;

	}
	/**
	 * get information DiaChi
	 * 
	 * @param maDC
	 * @return DiaChi
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@SuppressWarnings("static-access")
	public DiaChi layThongTinDiaChi(int maDC) throws ClassNotFoundException, SQLException {
		DiaChi dto = null;
		try {
			con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from DiaChi where maDiaChi =?";
			preStm = con.prepareStatement(sql);
			preStm.setInt(1, maDC);
			rs = preStm.executeQuery();
			if (rs.next()) {
				String soNha = rs.getString(1);
				String tenDuong = rs.getString(2);
				String phuongXa = rs.getString(3);
				String quanHuyen = rs.getString(4);
				String tinhTP = rs.getString(5);
				String quocGia = rs.getString(6);
				int maDiaChi = rs.getInt(7);
				dto = new DiaChi(maDiaChi, soNha, tenDuong, phuongXa, quanHuyen, tinhTP, quocGia);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	
}
