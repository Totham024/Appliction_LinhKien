package entity;

public class TaiKhoan {
	private String tenTaiKhoan;
	private String matKhau;
	private String loaiTK;
	public TaiKhoan(String taiKhoan, String matKhau, String loaiTK) {
		super();
		this.tenTaiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.loaiTK = loaiTK;
	}
	public String getLoaiTK() {
		return loaiTK;
	}
	public void setLoaiTK(String loaiTK) {
		this.loaiTK = loaiTK;
	}
	@Override
	public String toString() {
		return "TaiKhoan [taiKhoan=" + tenTaiKhoan + ", matKhau=" + matKhau + ", loaiTK=" + loaiTK + "]";
	}
	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaiKhoan(String tenTaiKhoan, String matKhau) {
		super();
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
	}
	public String getTaiKhoan() {
		return tenTaiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		this.tenTaiKhoan = taiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	/**
	 * @param tenTaiKhoan
	 */
	public TaiKhoan(String tenTaiKhoan) {
		super();
		this.tenTaiKhoan = tenTaiKhoan;
	}
	
}
