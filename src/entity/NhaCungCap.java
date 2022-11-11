package entity;

public class NhaCungCap {
	private int maNCC;
	private String tenNCC;
	private DiaChi diaChi;
	private String soDT;
	private String email;
	/**
	 * @return the maNCC
	 */
	public int getMaNCC() {
		return maNCC;
	}
	/**
	 * @param maNCC the maNCC to set
	 */
	public void setMaNCC(int maNCC) {
		this.maNCC = maNCC;
	}
	/**
	 * @return the tenNCC
	 */
	public String getTenNCC() {
		return tenNCC;
	}
	/**
	 * @param tenNCC the tenNCC to set
	 */
	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
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
	 * @return the soDT
	 */
	public String getSoDT() {
		return soDT;
	}
	/**
	 * @param soDT the soDT to set
	 */
	public void setSoDT(String soDT) {
		this.soDT = soDT;
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
	@Override
	public String toString() {
		return "NhaCungCap [maNCC=" + maNCC + ", tenNCC=" + tenNCC + ", diaChi=" + diaChi + ", soDT=" + soDT
				+ ", email=" + email + "]";
	}
	
	/**
	 * @param maNCC
	 * @param tenNCC
	 * @param diaChi
	 * @param soDT
	 * @param email
	 */
	public NhaCungCap(int maNCC, String tenNCC, DiaChi diaChi, String soDT, String email) {
		super();
		this.maNCC = maNCC;
		this.tenNCC = tenNCC;
		this.diaChi = diaChi;
		this.soDT = soDT;
		this.email = email;
	}
	/**
	 * @param tenNCC
	 */
	public NhaCungCap(String tenNCC) {
		super();
		this.tenNCC = tenNCC;
	}
	/**
	 * 
	 */
	public NhaCungCap() {
	}
	/**
	 * @param maNCC
	 */
	

	

}
