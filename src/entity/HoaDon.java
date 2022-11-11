package entity;

import java.sql.Date;

public class HoaDon {
	private int maHD;
	private Date ngayLap;
	private double tongTien;
	/**
	 * @return the tongTien
	 */
	public double getTongTien() {
		return tongTien;
	}
	/**
	 * @param tongTien the tongTien to set
	 */
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	private NhanVien nhanVien;
	private KhachHang khachHang;
	/**
	 * @return the maHD
	 */
	public int getMaHD() {
		return maHD;
	}
	/**
	 * @param maHD the maHD to set
	 */
	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}
	/**
	 * @return the ngayLap
	 */
	public Date getNgayLap() {
		return ngayLap;
	}
	/**
	 * @param ngayLap the ngayLap to set
	 */
	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}
	/**
	 * @return the nhanVien
	 */
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	/**
	 * @param nhanVien the nhanVien to set
	 */
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	/**
	 * @return the khachHang
	 */
	public KhachHang getKhachHang() {
		return khachHang;
	}
	/**
	 * @param khachHang the khachHang to set
	 */
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	
	/**
	 * @param maHD
	 * @param ngayLap
	 * @param tongTien
	 * @param nhanVien
	 * @param khachHang
	 */
	public HoaDon(int maHD, Date ngayLap, double tongTien, NhanVien nhanVien, KhachHang khachHang) {
		super();
		this.maHD = maHD;
		this.ngayLap = ngayLap;
		this.tongTien = tongTien;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
	}
	
	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", ngayLap=" + ngayLap + ", tongTien=" + tongTien + ", nhanVien=" + nhanVien
				+ ", khachHang=" + khachHang + "]";
	}
	/**
	 * @param maHD
	 */
	public HoaDon(int maHD) {
		super();
		this.maHD = maHD;
	}
	/**
	 * 
	 */
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
