package entity;

import java.math.BigInteger;
import java.sql.Date;
import java.util.Arrays;

public class LinhKien {
	private int maLK;
	private String tenLK;
	private int soLuong;
	private BigInteger giaNhap;
	private String donViTinh;
	private String baoHanh;
	private Date ngayNhap;
	private String thuongHieu;
	private String nuocSX;
	private String thongSoKT;
	private String mauSac;
	private byte[] hinhAnh;
	/**
	 * @return the hinhAnh
	 */
	public byte[] getHinhAnh() {
		return hinhAnh;
	}

	/**
	 * @param hinhAnh the hinhAnh to set
	 */
	public void setHinhAnh(byte[] hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	private String tinhTrang;
	private NhaCungCap ncc;
	private LoaiLK loaiLK;
	
	public LinhKien() {
	}

	
	/**
	 * @param maLK
	 */
	public LinhKien(int maLK) {
		super();
		this.maLK = maLK;
	}

	/**
	 * @param maLK
	 * @param tenLK
	 * @param soLuong
	 * @param giaNhap
	 * @param donViTinh
	 * @param baoHanh
	 * @param ngayNhap
	 * @param thuongHieu
	 * @param nuocSX
	 * @param thongSoKT
	 * @param mauSac
	 * @param hinhAnh
	 * @param tinhTrang
	 * @param ncc
	 * @param loaiLK
	 */
	public LinhKien(int maLK, String tenLK, int soLuong, BigInteger giaNhap, String donViTinh, String baoHanh,
			Date ngayNhap, String thuongHieu, String nuocSX, String thongSoKT, String mauSac, byte[] hinhAnh,
			String tinhTrang, NhaCungCap ncc, LoaiLK loaiLK) {
		super();
		this.maLK = maLK;
		this.tenLK = tenLK;
		this.soLuong = soLuong;
		this.giaNhap = giaNhap;
		this.donViTinh = donViTinh;
		this.baoHanh = baoHanh;
		this.ngayNhap = ngayNhap;
		this.thuongHieu = thuongHieu;
		this.nuocSX = nuocSX;
		this.thongSoKT = thongSoKT;
		this.mauSac = mauSac;
		this.hinhAnh = hinhAnh;
		this.tinhTrang = tinhTrang;
		this.ncc = ncc;
		this.loaiLK = loaiLK;
	}

	/**
	 * @param maLK
	 * @param tenLK
	 * @param soLuong
	 * @param giaNhap
	 * @param donViTinh
	 * @param baoHanh
	 * @param ngayNhap
	 * @param thuongHieu
	 * @param nuocSX
	 * @param thongSoKT
	 * @param mauSac
	 * @param tinhTrang
	 */
	public LinhKien(int maLK, String tenLK, int soLuong, BigInteger giaNhap, String donViTinh, String baoHanh,
			Date ngayNhap, String thuongHieu, String nuocSX, String thongSoKT, String mauSac, String tinhTrang) {
		super();
		this.maLK = maLK;
		this.tenLK = tenLK;
		this.soLuong = soLuong;
		this.giaNhap = giaNhap;
		this.donViTinh = donViTinh;
		this.baoHanh = baoHanh;
		this.ngayNhap = ngayNhap;
		this.thuongHieu = thuongHieu;
		this.nuocSX = nuocSX;
		this.thongSoKT = thongSoKT;
		this.mauSac = mauSac;
		this.tinhTrang = tinhTrang;
	}

	/**
	 * @param tenLK
	 */
	public LinhKien(String tenLK) {
		super();
		this.tenLK = tenLK;
	}

	/**
	 * @param tenLK
	 * @param donViTinh
	 * @param baoHanh
	 */
	public LinhKien(int maLK,String tenLK, String donViTinh, String baoHanh) {
		super();
		this.maLK = maLK;
		this.tenLK = tenLK;
		this.donViTinh = donViTinh;
		this.baoHanh = baoHanh;
	}

	

	/**
	 * @param maLK
	 * @param tenLK
	 * @param giaNhap
	 * @param baoHanh
	 * @param thuongHieu
	 */
	public LinhKien(int maLK, String tenLK, BigInteger giaNhap, String baoHanh, String thuongHieu) {
		super();
		this.maLK = maLK;
		this.tenLK = tenLK;
		this.giaNhap = giaNhap;
		this.baoHanh = baoHanh;
		this.thuongHieu = thuongHieu;
	}



	/**
	 * @return the maLK
	 */
	public int getMaLK() {
		return maLK;
	}

	/**
	 * @param maLK the maLK to set
	 */
	public void setMaLK(int maLK) {
		this.maLK = maLK;
	}

	/**
	 * @return the tenLK
	 */
	public String getTenLK() {
		return tenLK;
	}

	/**
	 * @param tenLK the tenLK to set
	 */
	public void setTenLK(String tenLK) {
		this.tenLK = tenLK;
	}

	/**
	 * @return the soLuong
	 */
	public int getSoLuong() {
		return soLuong;
	}

	/**
	 * @param soLuong the soLuong to set
	 */
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	/**
	 * @return the giaNhap
	 */
	public BigInteger getGiaNhap() {
		return giaNhap;
	}

	/**
	 * @param d the giaNhap to set
	 */
	public void setGiaNhap(BigInteger d) {
		this.giaNhap = d;
	}

	/**
	 * @return the donViTinh
	 */
	public String getDonViTinh() {
		return donViTinh;
	}

	/**
	 * @param donViTinh the donViTinh to set
	 */
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	/**
	 * @return the baoHanh
	 */
	public String getBaoHanh() {
		return baoHanh;
	}

	/**
	 * @param baoHanh the baoHanh to set
	 */
	public void setBaoHanh(String baoHanh) {
		this.baoHanh = baoHanh;
	}

	/**
	 * @return the ngayNhap
	 */
	public Date getNgayNhap() {
		return ngayNhap;
	}

	/**
	 * @param date the ngayNhap to set
	 */
	public void setNgayNhap(Date date) {
		this.ngayNhap = date;
	}

	/**
	 * @return the thuongHieu
	 */
	public String getThuongHieu() {
		return thuongHieu;
	}

	/**
	 * @param thuongHieu the thuongHieu to set
	 */
	public void setThuongHieu(String thuongHieu) {
		this.thuongHieu = thuongHieu;
	}

	/**
	 * @return the nuocSX
	 */
	public String getNuocSX() {
		return nuocSX;
	}

	/**
	 * @param nuocSX the nuocSX to set
	 */
	public void setNuocSX(String nuocSX) {
		this.nuocSX = nuocSX;
	}

	/**
	 * @return the thongSoKT
	 */
	public String getThongSoKT() {
		return thongSoKT;
	}

	/**
	 * @param thongSoKT the thongSoKT to set
	 */
	public void setThongSoKT(String thongSoKT) {
		this.thongSoKT = thongSoKT;
	}

	/**
	 * @return the mauSac
	 */
	public String getMauSac() {
		return mauSac;
	}

	/**
	 * @param mauSac the mauSac to set
	 */
	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}

	/**
	 * @return the tinhTrang
	 */
	public String getTinhTrang() {
		return tinhTrang;
	}

	/**
	 * @param tinhTrang the tinhTrang to set
	 */
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	/**
	 * @return the ncc
	 */
	public NhaCungCap getNcc() {
		return ncc;
	}

	/**
	 * @param ncc the ncc to set
	 */
	public void setNcc(NhaCungCap ncc) {
		this.ncc = ncc;
	}

	/**
	 * @return the loaiLK
	 */
	public LoaiLK getLoaiLK() {
		return loaiLK;
	}

	/**
	 * @param loaiLK the loaiLK to set
	 */
	public void setLoaiLK(LoaiLK loaiLK) {
		this.loaiLK = loaiLK;
	}

	@Override
	public String toString() {
		return "LinhKien [maLK=" + maLK + ", tenLK=" + tenLK + ", soLuong=" + soLuong + ", giaNhap=" + giaNhap
				+ ", donViTinh=" + donViTinh + ", baoHanh=" + baoHanh + ", ngayNhap=" + ngayNhap + ", thuongHieu="
				+ thuongHieu + ", nuocSX=" + nuocSX + ", thongSoKT=" + thongSoKT + ", mauSac=" + mauSac + ", hinhAnh="
				+ Arrays.toString(hinhAnh) + ", tinhTrang=" + tinhTrang + ", ncc=" + ncc + ", loaiLK=" + loaiLK + "]";
	}

	
	
	
	
	
}
