package entity;

public class DiaChi {
	private int maDC;
	private String nuoc ;
	private String tinhTP;
	private String quanHuyen;
	private String phuongXa;
	private String soNha;
	private String tenDuong;
	/**
	 * @return the tenDuong
	 */
	public String getTenDuong() {
		return tenDuong;
	}
	/**
	 * @param tenDuong the tenDuong to set
	 */
	public void setTenDuong(String tenDuong) {
		this.tenDuong = tenDuong;
	}
	/**
	 * 
	 */
	public DiaChi() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DiaChi [maDC=" + maDC + ", nuoc=" + nuoc + ", tinhTP=" + tinhTP + ", quanHuyen=" + quanHuyen
				+ ", phuongXa=" + phuongXa + ", soNha=" + soNha + ", tenDuong=" + tenDuong + "]";
	}


	/**
	 * @param maDC
	 * @param nuoc
	 * @param tinhTP
	 * @param quanHuyen
	 * @param phuongXa
	 * @param soNha
	 * @param tenDuong
	 */
	public DiaChi(int maDC, String nuoc, String tinhTP, String quanHuyen, String phuongXa, String soNha, String tenDuong) {
		super();
		this.maDC = maDC;
		this.nuoc = nuoc;
		this.tinhTP = tinhTP;
		this.quanHuyen = quanHuyen;
		this.phuongXa = phuongXa;
		this.soNha = soNha;
		this.tenDuong = tenDuong;
	}
	/**
	 * @param nuoc
	 * @param tinhTP
	 * @param quanHuyen
	 * @param phuongXa
	 * @param soNha
	 * @param tenDuong
	 */
	public DiaChi(String nuoc, String tinhTP, String quanHuyen, String phuongXa, String soNha, String tenDuong) {
		super();
		this.nuoc = nuoc;
		this.tinhTP = tinhTP;
		this.quanHuyen = quanHuyen;
		this.phuongXa = phuongXa;
		this.soNha = soNha;
		this.tenDuong = tenDuong;
	}
	/**
	 * @return the maDC
	 */
	public int getMaDC() {
		return maDC;
	}

	/**
	 * @param maDC
	 */
	public DiaChi(int maDC) {
		super();
		this.maDC = maDC;
	}
	/**
	 * @param maDC the maDC to set
	 */
	public void setMaDC(int maDC) {
		this.maDC = maDC;
	}
	/**
	 * @return the nuoc
	 */
	public String getNuoc() {
		return nuoc;
	}
	/**
	 * @param nuoc the nuoc to set
	 */
	public void setNuoc(String nuoc) {
		this.nuoc = nuoc;
	}
	/**
	 * @return the tinhTP
	 */
	public String getTinhTP() {
		return tinhTP;
	}
	/**
	 * @param tinhTP the tinhTP to set
	 */
	public void setTinhTP(String tinhTP) {
		this.tinhTP = tinhTP;
	}
	/**
	 * @return the quanHuyen
	 */
	public String getQuanHuyen() {
		return quanHuyen;
	}
	/**
	 * @param quanHuyen the quanHuyen to set
	 */
	public void setQuanHuyen(String quanHuyen) {
		this.quanHuyen = quanHuyen;
	}
	/**
	 * @return the phuongXa
	 */
	public String getPhuongXa() {
		return phuongXa;
	}
	/**
	 * @param phuongXa the phuongXa to set
	 */
	public void setPhuongXa(String phuongXa) {
		this.phuongXa = phuongXa;
	}
	/**
	 * @return the soNha
	 */
	public String getSoNha() {
		return soNha;
	}
	/**
	 * @param soNha the soNha to set
	 */
	public void setSoNha(String soNha) {
		this.soNha = soNha;
	}

}
