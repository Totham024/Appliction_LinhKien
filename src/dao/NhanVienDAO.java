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
import entity.NhanVien;
import entity.TaiKhoan;




public class NhanVienDAO {
	Connection con;
	PreparedStatement preStm;
	ResultSet rs;
	public NhanVienDAO() {


	}

	public NhanVien getMaDC(int ma) throws SQLException {
		NhanVien list= null;
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		String sql="select  d.soNha,d.tenDuong,d.phuongXa,d.quanHuyen,d.tinhTP,d.quocGia\r\n" + 
				"				from NhanVien k join DiaChi d on k.diaChi= d.maDiaChi where d.maDiaChi = "+ma+"";
		Statement statement = con.createStatement();
		ResultSet resultSet= statement.executeQuery(sql);
		while (resultSet.next()) {
			
			
			String nuoc = resultSet.getString(6);
			String tinhTP = resultSet.getString(5);
			String quanHuyen = resultSet.getString(4);
			String phuongXa= resultSet.getString(3);
			String soNha = resultSet.getString(1);
			String tenDuong = resultSet.getString(2);
			DiaChi diaChi= new DiaChi(nuoc, tinhTP, quanHuyen, phuongXa, soNha,tenDuong );
			NhanVien nv = new NhanVien(diaChi);
			list= nv;
		}
		return list;
	}
	public ArrayList<NhanVien> getAllNV() {
		ArrayList<NhanVien> ds= new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from NhanVien";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {


				int maNV = rs.getInt(1);
				String tenNV = rs.getString(2);
				int maDiaChi = rs.getInt(3);
				DiaChi diaChi = new DiaChi();
				diaChi.setMaDC(maDiaChi);
				//DiaChi diaChi = new DiaChi();
				int namSinh = rs.getInt(4);
				String phai = rs.getString(5);
				String CMND = rs.getString(6);			
				String chucVu = rs.getString(7);
				String taikhoan = rs.getString(8);
				TaiKhoan taiKhoan = new TaiKhoan();
				taiKhoan.setTaiKhoan(taikhoan);
				NhanVien nv = new NhanVien(maNV,tenNV, diaChi,namSinh, phai, CMND, chucVu, taiKhoan);

				ds.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}


	public boolean create(String tenNV, int maDC, int nsinh, String phai, String cMND, String chucVu,
			String taiKhoan) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt=null;


		int n=0;
		try {
			stmt =con.prepareStatement("INSERT [dbo].[NhanVien] ( [tenNV], [diaChi], [namSinh], [phai], [CMND], [chucVu], [taiKhoan]) VALUES ( ?, ?, ?, ?, ?, ?, ?)\r\n" + "");
			stmt.setString(1, tenNV);
			stmt.setInt(2, maDC);
			stmt.setInt(3, nsinh);
			stmt.setString(4, phai);
			stmt.setString(5, cMND);
			stmt.setString(6, chucVu);
			stmt.setString(7, taiKhoan);
			n= stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n>0;
	}


	public ArrayList<NhanVien> TimKiemtheoMA(String ma) {
		ArrayList<NhanVien> ds = null;

		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt=null;

			String sql = "select * from NhanVien where maNV like ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + ma + "%");
			ResultSet rs;
			rs = stmt.executeQuery();
			ds = new ArrayList<>();
			while (rs.next()) {
				int maNV = rs.getInt(1);
				String tenNV = rs.getString(2);
				DiaChi diaChi = new DiaChi(rs.getInt(3));
				int namSinh = rs.getInt(4);
				String phai =rs.getString(5);
				String CMND = rs.getString(6);
				String chucVu = rs.getString(7);
				TaiKhoan taiKhoan = new TaiKhoan(rs.getString(8), null);
				NhanVien nv = new NhanVien(maNV, tenNV, diaChi, namSinh, phai, CMND, chucVu, taiKhoan);
				ds.add(nv);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			System.out.println("Loi tim nhan vien theo id sql");
		} finally {
		}
		return ds;

	}



	public ArrayList<NhanVien> TimKiemtheoHt(String ten) {
		ArrayList<NhanVien> ds = null;

		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt=null;

			String sql = "select * from NhanVien where tenNV like ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + ten + "%");
			ResultSet rs;
			rs = stmt.executeQuery();
			ds = new ArrayList<>();
			while (rs.next()) {
				int maNV = rs.getInt(1);
				String tenNV = rs.getString(2);
				DiaChi diaChi = new DiaChi(rs.getInt(3));
				int namSinh = rs.getInt(4);
				String phai =rs.getString(5);
				String CMND = rs.getString(6);
				String chucVu = rs.getString(7);
				TaiKhoan taiKhoan = new TaiKhoan(rs.getString(8), null);
				NhanVien nv = new NhanVien(maNV, tenNV, diaChi, namSinh, phai, CMND, chucVu, taiKhoan);
				ds.add(nv);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			System.out.println("Loi tim nhan vien theo id sql");
		} finally {
		}
		return ds;

	}
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
	//	public void update(String text, String text2, Object selectedItem, int parseInt, Object selectedItem2) {
	//		
	//		
	//	}



	@SuppressWarnings("static-access")
	public boolean addDiaChi(DiaChi dc) throws SQLException {
		con = ConnectDB.getInstance().getConnection();
		boolean check = false;
		try {
			preStm = con.prepareStatement("insert into dbo.DiaChi values\r\n" + "(?,?,?,?,?,?)");
			preStm.setString(1, dc.getSoNha());
			preStm.setString(2, dc.getTenDuong());
			preStm.setString(3, dc.getPhuongXa());
			preStm.setString(4, dc.getQuanHuyen());
			preStm.setString(5, dc.getTinhTP());
			preStm.setString(6, dc.getNuoc());
			check = preStm.executeUpdate() > 0;
		} catch (Exception e3) {
			System.out.println("loi sql them dia chi");
			e3.printStackTrace();
		} finally {
		}
		return check;
	}
	@SuppressWarnings("static-access")
	public List<Integer> getAllMaDiaChi() throws Exception {
		List<Integer> result = new ArrayList<Integer>();
		con = ConnectDB.getInstance().getConnection();
		try {
			String sql = "select [maDiaChi] from DiaChi";
			preStm = con.prepareStatement(sql);
			ResultSet rs = preStm.executeQuery();
			while (rs.next()) {
				int maDC = rs.getInt(1);
				result.add(maDC);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Lỗi lấy all MaDiaChi");
		} finally {
		}
		return result;
	}

	@SuppressWarnings("static-access")
	public boolean addTaiKhoan(TaiKhoan tk) throws ClassNotFoundException, SQLException {
		con = ConnectDB.getInstance().getConnection();
		int n = 0;
		try {
			preStm = con.prepareStatement("insert into TaiKhoan values(?,?,?)");
			preStm.setString(1, tk.getTaiKhoan());
			preStm.setString(2, tk.getMatKhau());
			preStm.setString(3, tk.getLoaiTK());
			n = preStm.executeUpdate();
		} catch (Exception e3) {
			e3.printStackTrace();
		} finally {
		}
		return n > 0;
	}
	@SuppressWarnings("static-access")
	public List<String> getAllTenTaiKhoan() throws Exception {
		List<String> result = null;
		try {
			con = ConnectDB.getInstance().getConnection();
			String sql = "select [TenTaiKhoan] from [dbo].[TaiKhoan]";
			preStm = con.prepareStatement(sql);
			rs = preStm.executeQuery();
			result = new ArrayList<>();
			while (rs.next()) {
				String taiKhoan = rs.getString(1);
				result.add(taiKhoan);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return result;
	}
	@SuppressWarnings("static-access")
	public int getMaDiaChiMax() {
		int maDiaChiMax = 0;
		con = ConnectDB.getInstance().getConnection();
		try {
			String sql = "select MAX(MaDiaChi) from dbo.DiaChi";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				maDiaChiMax = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maDiaChiMax;
	}
	@SuppressWarnings("static-access")
	public NhanVien layThongTinNhanVien(int maNV) throws ClassNotFoundException, SQLException {
		NhanVien dto = null;
		try {
			con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from NhanVien where MaNV = ?";
			preStm = con.prepareStatement(sql);
			preStm.setInt(1, maNV);
			rs = preStm.executeQuery();
			if (rs.next()) {
				String ht = rs.getString("TenNV");
				int maDiaChi = rs.getInt("MaDiaChi");
				int nSinh = rs.getInt("NamSinh");
				String phai = rs.getString("phai");
				String CMND = rs.getString("CMND");
				String chucVu = rs.getString("Chuc vu");
				String tenTK = rs.getString("TenTaiKhoan");
				DiaChi diaChi = new DiaChi();
				diaChi.setMaDC(maDiaChi);
				TaiKhoan taiKhoan = new TaiKhoan();
				taiKhoan.setTaiKhoan(tenTK);
				dto = new NhanVien(maNV, ht,diaChi, nSinh, phai, CMND, chucVu,  taiKhoan);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
		}
		return dto;
	}
	@SuppressWarnings("static-access")
	public boolean xoaNhanVien(NhanVien nv) throws ClassNotFoundException, SQLException {
		con = ConnectDB.getInstance().getConnection();
		boolean check = false;
		try {
			String sql = "delete from NhanVien where MaNV=?";
			preStm = con.prepareStatement(sql);
			preStm.setInt(1, nv.getMaNV());
			check = preStm.executeUpdate() > 0;
		} catch (Exception e2) {
			e2.printStackTrace();
			System.out.println("Loi xóa sql");
		} finally {
		}
		return check;
	}


	/**
	 * delete nhanvien by MaNhanVien
	 * 
	 * @param ma
	 * @param trangThai
	 * @return true/false
	 * @throws SQLException
	 */
	@SuppressWarnings("static-access")
	public boolean deleteNhanVien(int ma) throws SQLException {
		Connection con = null;
		con = ConnectDB.getInstance().getConnection();
		int n = 0;
		try {
			String sql = "Update NhanVien  where MaNV = ?";
			preStm = con.prepareStatement(sql);
			preStm.setInt(1, ma);
			n = preStm.executeUpdate();
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
		}
		return n > 0;
	}





	public boolean update(int ma, String ten, int namsinh, String phai, String CMND, String chucvu) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt =null;
		try {
			stmt= con.prepareStatement("Update NhanVien set TenNV = ?, NamSinh = ?, Phai = ?, CMND = ?, ChucVu = ? where MaNV = ?");
			stmt.setString(1, ten);
			stmt.setString(2, String.valueOf(namsinh));		
			stmt.setString(3,phai);
			stmt.setString(4,CMND );
			stmt.setString(5,chucvu);
			stmt.setString(6, String.valueOf(ma));
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

	@SuppressWarnings("static-access")
	public List<NhanVien> timkiemNhanVienByTen(String tennv) throws ClassNotFoundException, SQLException {
		List<NhanVien> result = null;
		NhanVien nv;
		try {
			con = ConnectDB.getInstance().getConnection();
			String sql = "select * from NhanVien where TenNV like ?";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, "%" + tennv + "%");
			rs = preStm.executeQuery();
			result = new ArrayList<>();
			while (rs.next()) {
				int maNV = rs.getInt(1);
				String tenNV = rs.getString(2);
				DiaChi diaChi = new DiaChi(rs.getInt(3));
				int namSinh = rs.getInt(4);
				String phai =rs.getString(5);
				String CMND = rs.getString(6);
				String chucVu = rs.getString(7);
				TaiKhoan taiKhoan = new TaiKhoan(rs.getString(8), null);
				nv = new NhanVien(maNV, tenNV, diaChi, namSinh, phai, CMND, chucVu, taiKhoan);
				result.add(nv);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
		}
		return result;
	}
	@SuppressWarnings("static-access")
	public List<NhanVien> timkiemNhanVienByMa(int ma) throws ClassNotFoundException, SQLException {
		List<NhanVien> result = null;
		NhanVien nv;
		try {
			con = ConnectDB.getInstance().getConnection();
			String sql = "select * from NhanVien where MaNV like ?";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, "%" + ma + "%");
			rs = preStm.executeQuery();
			result = new ArrayList<>();
			while (rs.next()) {
				int maNV = rs.getInt(1);
				String tenNV = rs.getString(2);
				DiaChi diaChi = new DiaChi(rs.getInt(3));
				int namSinh = rs.getInt(4);
				String phai =rs.getString(5);
				String CMND = rs.getString(6);
				String chucVu = rs.getString(7);
				TaiKhoan taiKhoan = new TaiKhoan(rs.getString(8), null);
				nv = new NhanVien(maNV, tenNV, diaChi, namSinh, phai, CMND, chucVu, taiKhoan);
				result.add(nv);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			System.out.println("Loi tim nhan vien theo id sql");
		} finally {
		}
		return result;
	}


}

