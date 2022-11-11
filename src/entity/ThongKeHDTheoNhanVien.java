package entity;

import java.sql.Date;
import java.text.DecimalFormat;

public class ThongKeHDTheoNhanVien {
	
	private int maLK;
	private  String tenLK;
	private int soLuong;
	private double donGia;
	private String maNV;
	private String tenNV;
	private int maHD;
	private Date ngayLap;
	public Date g;
	public int getMaLK() {
		return maLK;
	}
	public void setMaLK(int maLK) {
		this.maLK = maLK;
	}
	public String getTenLK() {
		return tenLK;
	}
	public void setTenLK(String tenLK) {
		this.tenLK = tenLK;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public int getMaHD() {
		return maHD;
	}
	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}
	public Date getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}
	@Override
	public String toString() {
		return "ThongKeHDTheoNhanVien [maLK=" + maLK + ", tenLK=" + tenLK + ", soLuong=" + soLuong + ", donGia="
				+ donGia + ", maNV=" + maNV + ", tenNV=" + tenNV + ", maHD=" + maHD + ", ngayLap=" + ngayLap + "]";
	}
	public ThongKeHDTheoNhanVien(int maLK, String tenLK, int soLuong, double donGia, String maNV, String tenNV, int maHD,
			Date ngayLap) {
		super();
		this.maLK = maLK;
		this.tenLK = tenLK;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.maHD = maHD;
		this.ngayLap = ngayLap;
	}
	public ThongKeHDTheoNhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ThongKeHDTheoNhanVien(String ngay, String maNhanVien, String tenNhanVien, int maHD2, String maLK2,
			String tenLK2, int parseInt, double parseDouble, double parseDouble2) {
		// TODO Auto-generated constructor stub
	}
	public ThongKeHDTheoNhanVien(Date ngayLap2, String maNhanvVien, String tenNhanVien, int maHD2, int maLK2,
			String tenLK2, int soLuong2, double donGia2, double loiNhuan) {
		// TODO Auto-generated constructor stub
	}
	public double getLoiNhuan() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
