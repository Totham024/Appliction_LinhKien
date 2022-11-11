package entity;

import java.util.Vector;

public class KhachHang {
	
	private int maKH;
	private String tenKH;
	private String sdt;
	private DiaChi diaChi;
	private String phai;
	private String email;
	private int namSinh;
	
	
	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", sdt=" + sdt + ", diaChi=" + diaChi + ", phai=" + phai
				+ ", email=" + email + ", namSinh=" + namSinh + "]";
	}
	/**
	 * @param maKH
	 * @param tenKH
	 * @param sdt
	 * @param diaChi
	 * @param phai
	 * @param email
	 * @param namSinh
	 */
	public KhachHang(int maKH, String tenKH, String sdt, DiaChi diaChi, String phai, String email, int namSinh) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.phai = phai;
		this.email = email;
		this.namSinh = namSinh;
	}
	/**
	 * @param tenKH
	 * @param sdt
	 * @param diaChi
	 * @param phai
	 * @param email
	 * @param namSinh
	 */
	public KhachHang(String tenKH, String sdt, DiaChi diaChi, String phai, String email, int namSinh) {
		super();
		this.tenKH = tenKH;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.phai = phai;
		this.email = email;
		this.namSinh = namSinh;
	}
	/**
	 * @param maKH
	 * @param tenKH
	 * @param diaChi
	 */
	public KhachHang(int maKH, String tenKH, DiaChi diaChi) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChi = diaChi;
	}
	/**
	 * @return the maKH
	 */
	public int getMaKH() {
		return maKH;
	}
	/**
	 * @param maKH the maKH to set
	 */
	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}
	/**
	 * @return the tenKH
	 */
	public String getTenKH() {
		return tenKH;
	}
	/**
	 * @param tenKH the tenKH to set
	 */
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	/**
	 * @return the sdt
	 */
	public String getSdt() {
		return sdt;
	}
	/**
	 * @param sdt the sdt to set
	 */
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	/**
	 * @return the diaChi
	 */
	public DiaChi getDiaChi() {
		return diaChi;
	}
	/**
	 * @param diaChi the diaChi to set
	 */
	public void setDiaChi(DiaChi diaChi) {
		this.diaChi = diaChi;
	}
	/**
	 * @return the phai
	 */
	public String getPhai() {
		return phai;
	}
	/**
	 * @param phai the phai to set
	 */
	public void setPhai(String phai) {
		this.phai = phai;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the namSinh
	 */
	public int getNamSinh() {
		return namSinh;
	}
	/**
	 * @param namSinh the namSinh to set
	 */
	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}
	/**
	 * @param tenKH
	 */
	public KhachHang(String tenKH) {
		super();
		this.tenKH = tenKH;
	}
	public KhachHang() {
		// TODO Auto-generated constructor stub
	}
	public Vector<Object> toVector() {
		Vector<Object> v = new Vector<>();
		v.add("");
		v.add(maKH);
		v.add(tenKH);
		v.add(sdt);
		v.add(diaChi.getMaDC());
		v.add(phai);
		v.add(email);
		v.add(namSinh);
		

		return v;
	}
}
