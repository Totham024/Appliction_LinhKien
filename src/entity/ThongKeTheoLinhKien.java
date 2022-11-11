package entity;

import java.sql.Date;
import java.util.Vector;

public class ThongKeTheoLinhKien {
	private int maLK;
	private String tenLK;
	private String loaiLK;
	private int soLuong;
	public ThongKeTheoLinhKien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ThongKeTheoLinhKien(int maLK, String tenLK, String loaiLK, int slban, double donGia, Date ngaynhap,
			String thuongHieu, String nuocSX) {
		this.maLK = maLK;
		this.tenLK = tenLK;
		this.loaiLK = loaiLK;
		this.soLuong = slban;
		this.donGia = donGia;
		this.ngayNhap = ngaynhap;
		this.thuongHieu = thuongHieu;
		this.nuocSX = nuocSX;
	}
	public ThongKeTheoLinhKien(int maLK2, String tenLK2, String loaiLK2, int soLuong2, double giaNhap, String ngayNhap2,
			String thuongHieu2, String nuocSX2) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ThongKeTheoLinhKien [maLK=" + maLK + ", tenLK=" + tenLK + ", loaiLK=" + loaiLK + ", soLuong=" + soLuong
				+ ", donGia=" + donGia + ", ngayNhap=" + ngayNhap + ", thuongHieu=" + thuongHieu + ", nuocSX=" + nuocSX
				+ "]";
	}
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
	public String getLoaiLK() {
		return loaiLK;
	}
	public void setLoaiLK(String loaiLK) {
		this.loaiLK = loaiLK;
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
	public Date getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	public String getThuongHieu() {
		return thuongHieu;
	}
	public void setThuongHieu(String thuongHieu) {
		this.thuongHieu = thuongHieu;
	}
	public String getNuocSX() {
		return nuocSX;
	}
	public void setNuocSX(String nuocSX) {
		this.nuocSX = nuocSX;
	}
	private double donGia;
	private Date ngayNhap;
	private String thuongHieu;
	private String nuocSX;
	

}
