package entity;

public class LoaiLK {
	private int maLoai;
	private String tenLoai;
	
	
	public int getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(int maLoai) {
		this.maLoai = maLoai;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	
	/**
	 * @param tenLoai
	 */
	public LoaiLK(String tenLoai) {
		super();
		this.tenLoai = tenLoai;
	}
	public LoaiLK() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LoaiLK [maLoai=" + maLoai + ", tenLoai=" + tenLoai + "]";
	}
	/**
	 * @param maLoai
	 * @param tenLoai
	 */
	public LoaiLK(int maLoai, String tenLoai) {
		super();
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
	}

	
	
}
