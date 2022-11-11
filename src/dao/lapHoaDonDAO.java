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
import entity.DiaChi;
import entity.KhachHang;
import entity.LinhKien;
import entity.LoaiLK;
import entity.NhaCungCap;
import entity.NhanVien;




public class lapHoaDonDAO {
	public lapHoaDonDAO() {
		ConnectDB.getInstance().connect();
	}

	/**
	 * Lấy mã địa chỉ
	 * @param soNha
	 * @param tenDuong
	 * @param phuong
	 * @param quan
	 * @param thanhPho
	 * @param quocGia
	 * @return mã địa chỉ
	 */
	public int getMaDiaChi(String soNha,String tenDuong,String phuong,String quan,String thanhPho,String quocGia){
		int ma = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql="select[MaDiaChi]  \r\n" + 
					"from [dbo].[DiaChi]\r\n" + 
					"where [SoNha] like N'"+soNha+"' and [TenDuong] like N'"+tenDuong+"' and \r\n" + 
					"[phuongXa] like N'"+phuong+"' and [quanHuyen] like N'"+quan+"' \r\n" + 
					"and [tinhTP]like N'"+thanhPho+"'  and [QuocGia]like N'"+quocGia+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				int t= rs.getInt(1);
				ma=t;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ma;
	}

	public boolean themDiaChi(String soNha, String tenDuong, String phuong, String quan, String thanhPho, String quocGia) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("insert into dbo.DiaChi values\r\n" + 
					"(?,?,?,?,?,?)");
			stmt.setString(1, soNha);
			stmt.setString(2, tenDuong);
			stmt.setString(3, phuong);
			stmt.setString(4, quan);
			stmt.setString(5, thanhPho);
			stmt.setString(6, quocGia);
			 stmt.executeUpdate();
		} catch (Exception e3) {
			e3.printStackTrace();
		}
		return true;
		
	}

	public boolean themKH(String tenKh, String sdt, int maDC, String phai, String email,String namSinh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("insert into [dbo].[KhachHang] values\r\n" + 
					"(?,?,?,?,?,?)");
			stmt.setString(1, tenKh);
			stmt.setString(2, sdt);
			stmt.setString(3, String.valueOf(maDC));
			stmt.setString(4, phai);
			stmt.setString(5, email);
			stmt.setString(6,namSinh);
			stmt.executeUpdate();
		} catch (Exception e3) {
			e3.printStackTrace();
		}
		return true;
		
	}

	public int getMaKH(String tenKh, String sdt, int maDC, String phai, String email,String namSinh) {
		
		int ma = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql="select maKH\r\n" + 
					"from [dbo].[KhachHang] where [tenKH] like N'%"+tenKh+"'\r\n" + 
					"\r\n" + 
					"and [sdt] like '"+sdt+"' and [diaChi]="+maDC+"\r\n" + 
					"and [phai] like N'%"+phai+"%' and [email]='"+email+"' and [namSinh]='"+namSinh+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				int t= rs.getInt(1);
				ma = t;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ma;
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
	public ArrayList<String> getThuongHieu(String loai) {
		ArrayList<String> list = new  ArrayList<String>();

		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select distinct [thuongHieu] from linhkien l join loaiLK k on l.maloai= k.maloai"
					+ " where k.tenLoai like '%"+loai+"%'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String thuongHieu= rs.getString(1);
				list.add(thuongHieu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<String> getNuocSX(String loai) {
		ArrayList<String> list = new  ArrayList<String>();

		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select distinct [nuocSX] from linhkien l join loaiLK k on l.maloai= k.maloai"
					+ " where k.tenLoai like '%"+loai+"%'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String nuocSX= rs.getString(1);
				list.add(nuocSX);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public KhachHang getSDT(String sdt) throws SQLException {
		KhachHang list= null;
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		String sql="select maKH, tenKH, d.soNha,d.tenDuong,d.phuongXa,d.quanHuyen,d.tinhTP,d.quocGia\r\n" + 
				"from KhachHang k join DiaChi d on k.diaChi= d.maDiaChi where sdt like '"+sdt+"'";
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

	public ArrayList<LinhKien> getTimTheoTen(String tim) {
		ArrayList<LinhKien> dsLK= new ArrayList<LinhKien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT [maLK],tenLK,[soLuong],[giaNhap],[donViTinh] ,[baoHanh] ,\r\n" + 
					"[ngayNhap] ,[thuongHieu],[nuocSX],[thongsoKT],[mauSac]\r\n" + 
					"		,[hinhAnh],[tinhTrang],ncc.tenNCC ,l.[tenLoai]\r\n" + 
					"		FROM [dbo].[LinhKien] lk join NhaCungCap ncc \r\n" + 
					"		on lk.maNCC=ncc.maNCC join loaiLK l on lk.maLoai=l.maLoai\r\n" + 
					"		where l.[tenLoai] like N'%"+tim+"%'";
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

	public static int soLuongLKDaBan(int maLK) {
		int ma=0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql="select soLuongLKDaBan = SUM([soLuong])\r\n" + 
					"					from [dbo].[CTHoaDon]\r\n" + 
					"					where [maLK] like "+maLK+"\r\n" + 
					"					group by [maLK]";
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

	public static int soLuongNhap(int maLK) {
		
		int soLuong = 0;
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		String sql="select soLuong from [dbo].[LinhKien] where maLK like "+maLK+"";
		Statement statement;
		try {
			statement = con.createStatement();
			
			ResultSet rs= statement.executeQuery(sql);
			while (rs.next()) {
				 soLuong = rs.getInt(1);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return soLuong;
	}

	public static LinhKien LKTheoMa(int maLK) {
		LinhKien lk = new LinhKien();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT  [maLK],tenLK,[baoHanh] ,\r\n" + 
					"					[thuongHieu],[giaNhap]\r\n" + 
					"							\r\n" + 
					"							FROM [dbo].[LinhKien] \r\n" + 
					"							where [maLK]= "+maLK+"";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int ma = rs.getInt(1);
				String tenLK = rs.getString(2);
				String baoHanh = rs.getString(3);
				String thuongHieu = rs.getString(4);
				byte[] giaNhap = rs.getBytes(5);
				BigInteger gn = new BigInteger(giaNhap);
				lk= new LinhKien(maLK, tenLK, gn, baoHanh, thuongHieu);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lk;
	}

	public List<LinhKien> getTT(String thuongHieu, String part2) {
		
		ArrayList<LinhKien> dsLK= new ArrayList<LinhKien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT [maLK],tenLK,[soLuong],[giaNhap],[donViTinh] ,[baoHanh] ,\r\n" + 
					"					[ngayNhap] ,[thuongHieu],[nuocSX],[thongsoKT],[mauSac]\r\n" + 
					"							,[hinhAnh],[tinhTrang],ncc.tenNCC ,l.[tenLoai]\r\n" + 
					"							FROM [dbo].[LinhKien] lk join NhaCungCap ncc\r\n" + 
					"							on lk.maNCC=ncc.maNCC join loaiLK l on lk.maLoai=l.maLoai\r\n" + 
					"							where l.[tenLoai] like N'%"+part2+"%'and thuongHieu like N'%"+thuongHieu+"%'";
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
				String thuonghieu = rs.getString(8);
				String nuocSX = rs.getString(9);
				String thongSoKT = rs.getString(10);
				String mauSac = rs.getString(11);
				byte[] hinhAnh = rs.getBytes(12);
				String tinhTrang = rs.getString(13);
				String tenNCC =rs.getString(14);
				NhaCungCap ncc = new NhaCungCap(tenNCC);
				String tenLoai = rs.getString(15);
				LoaiLK loaiLK = new LoaiLK(tenLoai);
				LinhKien lk = new LinhKien(ma, tenLK, soLuong, gn, donViTinh, baoHanh, ngayNhap, thuonghieu, nuocSX, thongSoKT, mauSac, hinhAnh, tinhTrang, ncc, loaiLK);
				dsLK.add(lk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsLK;
	}

	public List<LinhKien> getMAU(String m, String part2) {
		ArrayList<LinhKien> dsLK= new ArrayList<LinhKien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT [maLK],tenLK,[soLuong],[giaNhap],[donViTinh] ,[baoHanh] ,\r\n" + 
					"					[ngayNhap] ,[thuongHieu],[nuocSX],[thongsoKT],[mauSac]\r\n" + 
					"							,[hinhAnh],[tinhTrang],ncc.tenNCC ,l.[tenLoai]\r\n" + 
					"							FROM [dbo].[LinhKien] lk join NhaCungCap ncc\r\n" + 
					"							on lk.maNCC=ncc.maNCC join loaiLK l on lk.maLoai=l.maLoai\r\n" + 
					"							where [tenLK]like N'%"+part2+"%'and mauSac like N'%"+m+"%'";
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
				String thuonghieu = rs.getString(8);
				String nuocSX = rs.getString(9);
				String thongSoKT = rs.getString(10);
				String mauSac = rs.getString(11);
//				byte[] hinhAnh = rs.getBytes(12);
				String tinhTrang = rs.getString(13);
//				String tenNCC =rs.getString(14);
//				NhaCungCap ncc = new NhaCungCap(tenNCC);
//				String tenLoai = rs.getString(15);
//				LoaiLK loaiLK = new LoaiLK(tenLoai);
				LinhKien lk = new LinhKien(ma, tenLK, soLuong, gn, donViTinh, baoHanh, ngayNhap, thuonghieu, nuocSX, thongSoKT, mauSac,  tinhTrang);
				dsLK.add(lk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsLK;
	}

	public List<LinhKien> getNsx(String nsx, String part2) {
		ArrayList<LinhKien> dsLK= new ArrayList<LinhKien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT [maLK],tenLK,[soLuong],[giaNhap],[donViTinh] ,[baoHanh] ,\r\n" + 
					"					[ngayNhap] ,[thuongHieu],[nuocSX],[thongsoKT],[mauSac]\r\n" + 
					"							,[hinhAnh],[tinhTrang],ncc.tenNCC ,l.[tenLoai]\r\n" + 
					"							FROM [dbo].[LinhKien] lk join NhaCungCap ncc\r\n" + 
					"							on lk.maNCC=ncc.maNCC join loaiLK l on lk.maLoai=l.maLoai\r\n" + 
					"							where l.[tenLoai] like N'%"+part2+"%'and nuocSX like N'%"+nsx+"%'";
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
				String thuonghieu = rs.getString(8);
				String nuocSX = rs.getString(9);
				String thongSoKT = rs.getString(10);
				String mauSac = rs.getString(11);
				byte[] hinhAnh = rs.getBytes(12);
				String tinhTrang = rs.getString(13);
				String tenNCC =rs.getString(14);
				NhaCungCap ncc = new NhaCungCap(tenNCC);
				String tenLoai = rs.getString(15);
				LoaiLK loaiLK = new LoaiLK(tenLoai);
				LinhKien lk = new LinhKien(ma, tenLK, soLuong, gn, donViTinh, baoHanh, ngayNhap, thuonghieu, nuocSX, thongSoKT, mauSac, hinhAnh, tinhTrang, ncc, loaiLK);
				dsLK.add(lk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsLK;
	}

	public List<LinhKien> getthongSo(String thongSo, String part2) {
		ArrayList<LinhKien> dsLK= new ArrayList<LinhKien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT [maLK],tenLK,[soLuong],[giaNhap],[donViTinh] ,[baoHanh] ,\r\n" + 
					"					[ngayNhap] ,[thuongHieu],[nuocSX],[thongsoKT],[mauSac]\r\n" + 
					"							,[hinhAnh],[tinhTrang],ncc.tenNCC ,l.[tenLoai]\r\n" + 
					"							FROM [dbo].[LinhKien] lk join NhaCungCap ncc\r\n" + 
					"							on lk.maNCC=ncc.maNCC join loaiLK l on lk.maLoai=l.maLoai\r\n" + 
					"							where [tenLK]like N'%"+part2+"%'and thongsoKT like N'%"+thongSo+"%'";
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
				String thuonghieu = rs.getString(8);
				String nuocSX = rs.getString(9);
				String thongSoKT = rs.getString(10);
				String mauSac = rs.getString(11);
				byte[] hinhAnh = rs.getBytes(12);
				String tinhTrang = rs.getString(13);
				String tenNCC =rs.getString(14);
				NhaCungCap ncc = new NhaCungCap(tenNCC);
				String tenLoai = rs.getString(15);
				LoaiLK loaiLK = new LoaiLK(tenLoai);
				LinhKien lk = new LinhKien(ma, tenLK, soLuong, gn, donViTinh, baoHanh, ngayNhap, thuonghieu, nuocSX, thongSoKT, mauSac, hinhAnh, tinhTrang, ncc, loaiLK);
				dsLK.add(lk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsLK;
	}

	public List<LinhKien> getNsxAndTH(String thuonghieu,String nsx,String part2) {
		ArrayList<LinhKien> dsLK= new ArrayList<LinhKien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT [maLK],tenLK,[soLuong],[giaNhap],[donViTinh] ,[baoHanh] ,\r\n" + 
					"					[ngayNhap] ,[thuongHieu],[nuocSX],[thongsoKT],[mauSac]\r\n" + 
					"							,[hinhAnh],[tinhTrang],ncc.tenNCC ,l.[tenLoai]\r\n" + 
					"							FROM [dbo].[LinhKien] lk join NhaCungCap ncc\r\n" + 
					"							on lk.maNCC=ncc.maNCC join loaiLK l on lk.maLoai=l.maLoai\r\n" + 
					"							where [tenLK]like N'%"+part2+"%'and thuongHieu like N'%"+thuonghieu+"%'and nuocSX like N'%"+nsx+"%'";
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
				String th = rs.getString(8);
				String nuocSX = rs.getString(9);
				String thongSoKT = rs.getString(10);
				String mauSac = rs.getString(11);
				String tinhTrang = rs.getString(13);
				LinhKien lk = new LinhKien(ma, tenLK, soLuong, gn, donViTinh, baoHanh, ngayNhap, th, nuocSX, thongSoKT, mauSac,  tinhTrang);
				dsLK.add(lk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsLK;
	}

	public List<LinhKien> getTHAndThongSo(String thuongHieu, String thongSo, String part2) {
		ArrayList<LinhKien> dsLK= new ArrayList<LinhKien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT [maLK],tenLK,[soLuong],[giaNhap],[donViTinh] ,[baoHanh] ,\r\n" + 
					"					[ngayNhap] ,[thuongHieu],[nuocSX],[thongsoKT],[mauSac]\r\n" + 
					"							,[hinhAnh],[tinhTrang],ncc.tenNCC ,l.[tenLoai]\r\n" + 
					"							FROM [dbo].[LinhKien] lk join NhaCungCap ncc\r\n" + 
					"							on lk.maNCC=ncc.maNCC join loaiLK l on lk.maLoai=l.maLoai\r\n" + 
					"							where [tenLK]like N'%"+part2+"%'and thuongHieu like N'%"+thuongHieu+"%'and thongsoKT like N'%"+thongSo+"%'";
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
				String th = rs.getString(8);
				String nuocSX = rs.getString(9);
				String thongSoKT = rs.getString(10);
				String mauSac = rs.getString(11);
				String tinhTrang = rs.getString(13);
				LinhKien lk = new LinhKien(ma, tenLK, soLuong, gn, donViTinh, baoHanh, ngayNhap, th, nuocSX, thongSoKT, mauSac,  tinhTrang);
				dsLK.add(lk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsLK;
	}

	public List<LinhKien> getNsxAndThongSo(String nsx, String thongSo, String part2) {
		ArrayList<LinhKien> dsLK= new ArrayList<LinhKien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT [maLK],tenLK,[soLuong],[giaNhap],[donViTinh] ,[baoHanh] ,\r\n" + 
					"					[ngayNhap] ,[thuongHieu],[nuocSX],[thongsoKT],[mauSac]\r\n" + 
					"							,[hinhAnh],[tinhTrang],ncc.tenNCC ,l.[tenLoai]\r\n" + 
					"							FROM [dbo].[LinhKien] lk join NhaCungCap ncc\r\n" + 
					"							on lk.maNCC=ncc.maNCC join loaiLK l on lk.maLoai=l.maLoai\r\n" + 
					"							where [tenLK]like N'%"+part2+"%'and nuocSX like N'%"+nsx+"%'and thongsoKT like N'%"+thongSo+"%'";
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
				String th = rs.getString(8);
				String nuocSX = rs.getString(9);
				String thongSoKT = rs.getString(10);
				String mauSac = rs.getString(11);
				String tinhTrang = rs.getString(13);
				LinhKien lk = new LinhKien(ma, tenLK, soLuong, gn, donViTinh, baoHanh, ngayNhap, th, nuocSX, thongSoKT, mauSac,  tinhTrang);
				dsLK.add(lk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsLK;
	}

	public List<LinhKien> getNsxAndTH(String thuongHieu, String nsx, String thongSo, String part2) {
		ArrayList<LinhKien> dsLK= new ArrayList<LinhKien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT [maLK],tenLK,[soLuong],[giaNhap],[donViTinh] ,[baoHanh] ,\r\n" + 
					"					[ngayNhap] ,[thuongHieu],[nuocSX],[thongsoKT],[mauSac]\r\n" + 
					"							,[hinhAnh],[tinhTrang],ncc.tenNCC ,l.[tenLoai]\r\n" + 
					"							FROM [dbo].[LinhKien] lk join NhaCungCap ncc\r\n" + 
					"							on lk.maNCC=ncc.maNCC join loaiLK l on lk.maLoai=l.maLoai\r\n" + 
					"							where [tenLK]like N'%"+part2+"%'and thuongHieu like N'%"+thuongHieu+"%' and nuocSX like N'%"+nsx+"%'and thongsoKT like N'%"+thongSo+"%'";
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
				String th = rs.getString(8);
				String nuocSX = rs.getString(9);
				String thongSoKT = rs.getString(10);
				String mauSac = rs.getString(11);
				String tinhTrang = rs.getString(13);
				LinhKien lk = new LinhKien(ma, tenLK, soLuong, gn, donViTinh, baoHanh, ngayNhap, th, nuocSX, thongSoKT, mauSac,  tinhTrang);
				dsLK.add(lk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsLK;
	}

	public NhanVien getTenNV(String tenTK) {
		NhanVien nv = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql  = "select maNV,tenNV from nhanVien where taiKhoan ='"+tenTK+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				int maNV= rs.getInt(1);
				String tenNV=rs.getString(2);
				
				nv= new NhanVien(maNV, tenNV);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nv;
	}

	public boolean addHoaDon(String ngaylap, Long tongTien, int maNV, int maKH) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt =null;
		try {
			stmt= con.prepareStatement("insert into HoaDon values(?,?,?,?)");
			stmt.setString(1,ngaylap);
			stmt.setLong(2,tongTien);
			stmt.setInt(3, maNV);
			stmt.setInt(4,maKH);
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

	public int getMaHD(String ngaylap, Long tongTien, int maNV, int maKH){
		int ma = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql="SELECT [maHD]\r\n" + 
					"  FROM [dbo].[HoaDon]\r\n" + 
					"  where [ngayLap]= '"+ngaylap+"' and [tongTien]="+tongTien+" and [maNV]="+maNV+" and [maKH]="+maKH+"";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				int t= rs.getInt(1);
				ma=t;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ma;
	}

	public boolean addCT_HoaDon(int maLK, Long donGia, int maHD, int soLuong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt =null;
		try {
			stmt= con.prepareStatement("insert into CTHoaDon values(?,?,?,?)");
			stmt.setInt(1,soLuong);
			stmt.setLong(2, donGia);
			stmt.setInt(3, maLK);
			stmt.setInt(4,maHD);
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

}
