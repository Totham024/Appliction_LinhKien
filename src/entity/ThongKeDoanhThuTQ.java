package entity;

import java.sql.Date;

public class ThongKeDoanhThuTQ {
	private int maLK;
	private String tenLK;
	private String soLuongNhap;
	private int soLuongBan;
	private double donGia;
	private double giaNhap;
	private java.util.Date ngay;
	private double tienNhap;
	private double loiNhuan;
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
	public String getSoLuongNhap() {
		return soLuongNhap;
	}
	public void setSoLuongNhap(String soLuongNhap) {
		this.soLuongNhap = soLuongNhap;
	}
	public int getSoLuongBan() {
		return soLuongBan;
	}
	public void setSoLuongBan(int soLuongBan) {
		this.soLuongBan = soLuongBan;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public double getGiaNhap() {
		return giaNhap;
	}
	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}
	public Date getNgay() {
		return (Date) ngay;
	}
	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}
	public double getTienNhap() {
		return tienNhap;
	}
	public void setTienNhap(double tienNhap) {
		this.tienNhap = tienNhap;
	}
	public double getLoiNhuan() {
		return loiNhuan;
	}
	public void setLoiNhuan(double loiNhuan) {
		this.loiNhuan = loiNhuan;
	}
	@Override
	public String toString() {
		return "ThongKeDoanhThuTQ [maLK=" + maLK + ", tenLK=" + tenLK + ", soLuongNhap=" + soLuongNhap + ", soLuongBan="
				+ soLuongBan + ", donGia=" + donGia + ", giaNhap=" + giaNhap + ", ngay=" + ngay + ", tienNhap="
				+ tienNhap + ", loiNhuan=" + loiNhuan + "]";
	}
	
	public ThongKeDoanhThuTQ() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ThongKeDoanhThuTQ(int maLK, String tenLK, double donGia, double giaNhap, java.util.Date ngay,
			String slnhap, int slban, double loinhuan, double tiennhap) {
		this.maLK = maLK;
		this.tenLK = tenLK;
		this.soLuongNhap = soLuongNhap;
		this.soLuongBan = soLuongBan;
		this.donGia = donGia;
		this.giaNhap = giaNhap;
		this.ngay = ngay;
		this.tienNhap = tienNhap;
		this.loiNhuan = loiNhuan;
	}
	
	


}
