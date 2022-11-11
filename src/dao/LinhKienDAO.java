package dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import connectDB.ConnectDB;
import entity.LinhKien;
import entity.LoaiLK;
import entity.NhaCungCap;

public class LinhKienDAO {

	public LinhKienDAO() {
		ConnectDB.getInstance().connect();
	}
	/**
	 * Lấy mã nhà cung cấp khi biết tên
	 * @param ten
	 * @return ten nhà cung cấp
	 */
	public int getmaNCC(String ten){
		int ma=0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql="select maNCC\r\n" + 
					"					from [dbo].[NhaCungCap]\r\n" + 
					"					where tenNCC =N'"+ten+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				int t= rs.getInt(1);
				ma=t;
			}
		} catch (Exception e) {
		}
		return ma;
	}
	/**
	 * Lấy mã Loai linh kien khi biết tên loai
	 * @param ten
	 * @return ten loai linh kien
	 */
	public int getmaLoai(String ten){
		int ma=0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql="select maLoai\r\n" + 
					"					from loaiLK\r\n" + 
					"					where tenLoai =N'"+ten+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				int t= rs.getInt(1);
				ma=t;
			}
		} catch (Exception e) {
		}
		return ma;
	}
	public boolean themLK(String tenLK, int sl,Long giaNhap, String dvt,  String baoHanh,
			String ngayNhap, String thuongHieu, String nuocSX, String thongSo, String mauSac, byte[] imageLK,
			String tinhTrang, int getmaNCC, int loaiLK) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt =null;
		try {
			stmt= con.prepareStatement("insert into LinhKien values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, tenLK);
			stmt.setString(2, String.valueOf(sl));
			stmt.setString(3, String.valueOf(giaNhap));
			stmt.setString(4, dvt);
		
			stmt.setString(5, baoHanh);
			stmt.setString(6,ngayNhap);
			stmt.setString(7,thuongHieu );
			stmt.setString(8,nuocSX);
			stmt.setString(9,thongSo);
			stmt.setString(10,mauSac);
			stmt.setBytes(11, imageLK);
			stmt.setString(12,tinhTrang);
			stmt.setString(13,String.valueOf(getmaNCC));
			stmt.setString (14,String.valueOf(loaiLK));
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
// get linh kien lên table
	public ArrayList<LinhKien> getAllLK() {
		ArrayList<LinhKien> dsLK= new ArrayList<LinhKien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT [maLK],[tenLK],[soLuong],[giaNhap],[donViTinh] ,[baoHanh] ,[ngayNhap] ,[thuongHieu],[nuocSX],[thongsoKT],[mauSac]\r\n" + 
					"      ,[hinhAnh],[tinhTrang],ncc.tenNCC ,l.[tenLoai]\r\n" + 
					"  FROM [dbo].[LinhKien] lk join NhaCungCap ncc on lk.maNCC=ncc.maNCC join loaiLK l on lk.maLoai=l.maLoai";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int ma = rs.getInt(1);
				String tenLK = rs.getString(2);
				int soLuong = rs.getInt(3);
				byte[] giaNhap = rs.getBytes(4);
				BigInteger gn = new BigInteger(giaNhap);
				
				String donViTinh = rs.getString(5);
				String baoHanh = rs.getString(6);
				Date ngayNhap = rs.getDate(7);
				String thuongHieu = rs.getString(8);
				String nuocSX = rs.getString(9);
				String thongSoKT = rs.getString(10);
				String mauSac = rs.getString(11);
				byte[] hinhAnh = rs.getBytes(12);
				String tinhTrang = rs.getString(13);
				String tenNCC =rs.getString(14);
				NhaCungCap ncc = new NhaCungCap(tenNCC);
				String tenLoai = rs.getString(15);
				LoaiLK loaiLK = new LoaiLK(tenLoai);
				LinhKien lk = new LinhKien(ma, tenLK, soLuong, gn, donViTinh, baoHanh, ngayNhap, thuongHieu, nuocSX, thongSoKT, mauSac, hinhAnh, tinhTrang, ncc, loaiLK);
				dsLK.add(lk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsLK;
	}
	public ArrayList<String> getNCC() {
		ArrayList<String> listNCC = new  ArrayList<String>();

		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select distinct TenNCC from NhaCungCap";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String tenNCC= rs.getString(1);
				listNCC.add(tenNCC);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listNCC;
	}
	public String getDate() {
		String date = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select getDate()";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				date = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return date;
	}

	public ArrayList<String> getLoaiLK() {
		ArrayList<String> listLoaiLK = new  ArrayList<String>();

		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select distinct [tenLoai] from [dbo].[loaiLK]";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String tenLoai= rs.getString(1);
				listLoaiLK.add(tenLoai);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listLoaiLK;
	}
	public boolean getThemLoaiLK(String tenLoaiLK) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt =null;
		try {
			stmt= con.prepareStatement("insert into loaiLK values(?)");
			stmt.setString(1, tenLoaiLK);
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
	public boolean capNhat(int ma, String tenLK, int sl, long giaNhap, String dvt, String baoHanh,
			String ngayNhap, String thuongHieu, String nuocSX, String thongSo, String mauSac, byte[] imageLK,
			String tinhTrang, int getmaNCC, int loaiLK) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt =null;
		try {
			stmt= con.prepareStatement("update LinhKien set tenLK=?, soLuong=?,  giaNhap=?,  donViTinh=?, baoHanh=?,\r\n" + 
					"			 ngayNhap=?,  thuongHieu=?, nuocSX=?,  thongsoKT=?,  mauSac=?,  hinhAnh=?,\r\n" + 
					"			 tinhTrang=?,  maNCC=?,  maLoai=? where maLK=?");
			stmt.setString(1, tenLK);
			stmt.setString(2, String.valueOf(sl));
			stmt.setString(3, String.valueOf(giaNhap));
			stmt.setString(4, dvt);
		
			stmt.setString(5, baoHanh);
			stmt.setString(6,ngayNhap);
			stmt.setString(7,thuongHieu );
			stmt.setString(8,nuocSX);
			stmt.setString(9,thongSo);
			stmt.setString(10,mauSac);
			stmt.setBytes(11, imageLK);
			stmt.setString(12,tinhTrang);
			stmt.setString(13,String.valueOf(getmaNCC));
			stmt.setString (14,String.valueOf(loaiLK));
			stmt.setString(15, String.valueOf(ma));
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
	public boolean xoa(String maLK) {
		
		 ConnectDB.getInstance();
		  Connection con = ConnectDB.getConnection();
		  PreparedStatement stmt = null;
		  int n = 0;
		  try {
			stmt = con.prepareStatement("delete LinhKien where maLK=? ");
				stmt.setString(1,maLK);
				
				n=stmt.executeUpdate();
			}
		  catch (SQLException e) {
					e.printStackTrace();
				}  
		  finally {
			try {
				stmt.close();
			}
			catch (SQLException e) {
			}
		}
		  return true;
		
	}
	public List<LinhKien> getLinhKienByLoai(String tim) throws SQLException {

		
		List<LinhKien> listLoai = new ArrayList<LinhKien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql="SELECT [maLK],[tenLK],[soLuong],[giaNhap],[donViTinh] ,[baoHanh] ,[ngayNhap] ,[thuongHieu],[nuocSX],[thongsoKT],[mauSac]\r\n" + 
				"					      ,[hinhAnh],[tinhTrang],ncc.tenNCC ,l.[tenLoai] \r\n" + 
				"					 FROM [dbo].[LinhKien] lk join NhaCungCap ncc on lk.maNCC=ncc.maNCC join loaiLK l on lk.maLoai=l.maLoai \r\n" + 
				"					 where l.[tenLoai] like N'%"+tim+"%'";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			int ma = rs.getInt(1);
			String tenLK = rs.getString(2);
			int soLuong = rs.getInt(3);
			byte[] giaNhap = rs.getBytes(4);
			BigInteger gn = new BigInteger(giaNhap);
			String donViTinh = rs.getString(5);
			String baoHanh = rs.getString(6);
			Date ngayNhap = rs.getDate(7);
			String thuongHieu = rs.getString(8);
			String nuocSX = rs.getString(9);
			String thongSoKT = rs.getString(10);
			String mauSac = rs.getString(11);
			byte[] hinhAnh = rs.getBytes(12);
			String tinhTrang = rs.getString(13);
			String tenNCC =rs.getString(14);
			NhaCungCap ncc = new NhaCungCap(tenNCC);
			String tenLoai = rs.getString(15);
			LoaiLK loaiLK = new LoaiLK(tenLoai);
			LinhKien lk = new LinhKien(ma, tenLK, soLuong, gn, donViTinh, baoHanh, ngayNhap, thuongHieu, nuocSX, thongSoKT, mauSac, hinhAnh, tinhTrang, ncc, loaiLK);
			listLoai.add(lk);
		}
		
		return listLoai;
	}
	public List<LinhKien> getLinhKienByTenLK(String ten) throws SQLException {
		List<LinhKien> listLK = new ArrayList<LinhKien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql="SELECT [maLK],[tenLK],[soLuong],[giaNhap],[donViTinh] ,[baoHanh] ,[ngayNhap] ,[thuongHieu],[nuocSX],[thongsoKT],[mauSac]\r\n" + 
				"					      ,[hinhAnh],[tinhTrang],ncc.tenNCC ,l.[tenLoai] \r\n" + 
				"					 FROM [dbo].[LinhKien] lk join NhaCungCap ncc on lk.maNCC=ncc.maNCC join loaiLK l on lk.maLoai=l.maLoai \r\n" + 
				"					 where tenLK like N'%"+ten+"%'";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			int ma = rs.getInt(1);
			String tenLK = rs.getString(2);
			int soLuong = rs.getInt(3);
			byte[] giaNhap = rs.getBytes(4);
			BigInteger gn = new BigInteger(giaNhap);
			String donViTinh = rs.getString(5);
			String baoHanh = rs.getString(6);
			Date ngayNhap = rs.getDate(7);
			String thuongHieu = rs.getString(8);
			String nuocSX = rs.getString(9);
			String thongSoKT = rs.getString(10);
			String mauSac = rs.getString(11);
			byte[] hinhAnh = rs.getBytes(12);
			String tinhTrang = rs.getString(13);
			String tenNCC =rs.getString(14);
			NhaCungCap ncc = new NhaCungCap(tenNCC);
			String tenLoai = rs.getString(15);
			LoaiLK loaiLK = new LoaiLK(tenLoai);
			LinhKien lk = new LinhKien(ma, tenLK, soLuong, gn, donViTinh, baoHanh, ngayNhap, thuongHieu, nuocSX, thongSoKT, mauSac, hinhAnh, tinhTrang, ncc, loaiLK);
			listLK.add(lk);
		}
		
		return listLK;
	}
	public List<LinhKien> getLinhKienByNCC(String tim) throws SQLException {
		List<LinhKien> listNCC = new ArrayList<LinhKien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql="SELECT [maLK],[tenLK],[soLuong],[giaNhap],[donViTinh] ,[baoHanh] ,[ngayNhap] ,[thuongHieu],[nuocSX],[thongsoKT],[mauSac]\r\n" + 
				"					      ,[hinhAnh],[tinhTrang],ncc.tenNCC ,l.[tenLoai] \r\n" + 
				"					 FROM [dbo].[LinhKien] lk join NhaCungCap ncc on lk.maNCC=ncc.maNCC join loaiLK l on lk.maLoai=l.maLoai \r\n" + 
				"					 where ncc.tenNCC like N'%"+tim+"%'";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			int ma = rs.getInt(1);
			String tenLK = rs.getString(2);
			int soLuong = rs.getInt(3);
			byte[] giaNhap = rs.getBytes(4);
			BigInteger gn = new BigInteger(giaNhap);
			String donViTinh = rs.getString(5);
			String baoHanh = rs.getString(6);
			Date ngayNhap = rs.getDate(7);
			String thuongHieu = rs.getString(8);
			String nuocSX = rs.getString(9);
			String thongSoKT = rs.getString(10);
			String mauSac = rs.getString(11);
			byte[] hinhAnh = rs.getBytes(12);
			String tinhTrang = rs.getString(13);
			String tenNCC =rs.getString(14);
			NhaCungCap ncc = new NhaCungCap(tenNCC);
			String tenLoai = rs.getString(15);
			LoaiLK loaiLK = new LoaiLK(tenLoai);
			LinhKien lk = new LinhKien(ma, tenLK, soLuong, gn, donViTinh, baoHanh, ngayNhap, thuongHieu, nuocSX, thongSoKT, mauSac, hinhAnh, tinhTrang, ncc, loaiLK);
			listNCC.add(lk);
		}
		
		return listNCC;
	}
	public List<LinhKien> getLinhKienByThuongHieu(String tim) throws SQLException {
		List<LinhKien> listTH = new ArrayList<LinhKien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql="SELECT [maLK],[tenLK],[soLuong],[giaNhap],[donViTinh] ,[baoHanh] ,[ngayNhap] ,[thuongHieu],[nuocSX],[thongsoKT],[mauSac]\r\n" + 
				"					      ,[hinhAnh],[tinhTrang],ncc.tenNCC ,l.[tenLoai] \r\n" + 
				"					 FROM [dbo].[LinhKien] lk join NhaCungCap ncc on lk.maNCC=ncc.maNCC join loaiLK l on lk.maLoai=l.maLoai \r\n" + 
				"					 where [thuongHieu] like N'%"+tim+"%'";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			int ma = rs.getInt(1);
			String tenLK = rs.getString(2);
			int soLuong = rs.getInt(3);
			byte[] giaNhap = rs.getBytes(4);
			BigInteger gn = new BigInteger(giaNhap);
			String donViTinh = rs.getString(5);
			String baoHanh = rs.getString(6);
			Date ngayNhap = rs.getDate(7);
			String thuongHieu = rs.getString(8);
			String nuocSX = rs.getString(9);
			String thongSoKT = rs.getString(10);
			String mauSac = rs.getString(11);
			byte[] hinhAnh = rs.getBytes(12);
			String tinhTrang = rs.getString(13);
			String tenNCC =rs.getString(14);
			NhaCungCap ncc = new NhaCungCap(tenNCC);
			String tenLoai = rs.getString(15);
			LoaiLK loaiLK = new LoaiLK(tenLoai);
			LinhKien lk = new LinhKien(ma, tenLK, soLuong, gn, donViTinh, baoHanh, ngayNhap, thuongHieu, nuocSX, thongSoKT, mauSac, hinhAnh, tinhTrang, ncc, loaiLK);
			listTH.add(lk);
		}
		
		return listTH;
	}
	public ArrayList<String> getDVT() {
		ArrayList<String> ls = new  ArrayList<String>();

		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select distinct donvitinh from LinhKien";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String donvitinh= rs.getString(1);
				ls.add(donvitinh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ls;
		
	}
	public ArrayList<String> getTH() {
		ArrayList<String> ls = new  ArrayList<String>();

		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select distinct thuongHieu from LinhKien";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String thuongHieu= rs.getString(1);
				ls.add(thuongHieu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ls;
		
	}





}
