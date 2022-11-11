package entity;

public class CTHoaDon {
	private LinhKien linhKien;
	private HoaDon hoaDon;
	private int soLuong;
	private Long donGia;
	/**
	 * 
	 */
	public CTHoaDon() {
		
	}
	/**
	 * @param linhKien
	 * @param hoaDon
	 * @param soLuong
	 * @param donGia
	 */
	public CTHoaDon(LinhKien linhKien, HoaDon hoaDon, int soLuong, Long donGia) {
		super();
		this.linhKien = linhKien;
		this.hoaDon = hoaDon;
		this.soLuong = soLuong;
		this.donGia = donGia;
	} 
	
	@Override
	public String toString() {
		return "CTHoaDon [linhKien=" + linhKien + ", hoaDon=" + hoaDon + ", soLuong=" + soLuong + ", donGia=" + donGia
				+ "]";
	}
	/**
	 * @return the linhKien
	 */
	public LinhKien getLinhKien() {
		return linhKien;
	}
	/**
	 * @param linhKien the linhKien to set
	 */
	public void setLinhKien(LinhKien linhKien) {
		this.linhKien = linhKien;
	}
	/**
	 * @return the hoaDon
	 */
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	/**
	 * @param hoaDon the hoaDon to set
	 */
	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
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
	 * @return the donGia
	 */
	public Long getDonGia() {
		return donGia;
	}
	/**
	 * @param donGia the donGia to set
	 */
	public void setDonGia(Long donGia) {
		this.donGia = donGia;
	}
	
	
}
