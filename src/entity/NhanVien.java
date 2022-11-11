package entity;

import java.util.Vector;

public class NhanVien {
	private int maNV;
	private String tenNV;
	private  DiaChi diaChi;
	private int namSinh;
	private String phai;
	private String CMND;
	private String chucVu;
	private TaiKhoan taiKhoan;
	
	/**
	 * @param maNV
	 * @param tenNV
	 * @param namSinh
	 * @param phai
	 * @param cMND
	 * @param chucVu
	 * @param taiKhoan
	 * @param tenTK
	 * @param trangThai
	 */
	public NhanVien(int maNV, String tenNV, int namSinh, String phai, String cMND, String chucVu, TaiKhoan taiKhoan,
			TaiKhoan tenTK, String trangThai) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.namSinh = namSinh;
		this.phai = phai;
		CMND = cMND;
		this.chucVu = chucVu;
		this.taiKhoan = taiKhoan;
		this.tenTK = tenTK;
		this.trangThai = trangThai;
	}




	public NhanVien(int maNV, String tenNV, int namSinh, String phai, String cMND, String chucVu, TaiKhoan tenTK,
			String trangThai) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.namSinh = namSinh;
		this.phai = phai;
		CMND = cMND;
		this.chucVu = chucVu;
		this.tenTK = tenTK;
		this.trangThai = trangThai;
	}




	public String getTrangThai() {
		return trangThai;
	}




	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}





	private TaiKhoan tenTK;
	private String trangThai;

	public NhanVien(int maNV, String tenNV, DiaChi diaChi, int namSinh, String phai, String cMND, String chucVu,
			TaiKhoan tenTK) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.diaChi = diaChi;
		this.namSinh = namSinh;
		this.phai = phai;
		CMND = cMND;
		this.chucVu = chucVu;
		this.tenTK = tenTK;
	}








	public NhanVien(int maNV, String tenNV, int namSinh, String phai, String cMND, String chucVu, TaiKhoan tenTK) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.namSinh = namSinh;
		this.phai = phai;
		CMND = cMND;
		this.chucVu = chucVu;
		this.tenTK = tenTK;
	}





	/**
	 * @param maNV
	 * @param tenNV
	 */
	public NhanVien(int maNV, String tenNV) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
	}




	/**
	 * @param tenNV
	 */
	public NhanVien(String tenNV) {
		super();
		this.tenNV = tenNV;
	}




	public NhanVien() {
	}











	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", namSinh=" + namSinh + ", phai=" + phai + ", CMND="
				+ CMND + ", chucVu=" + chucVu + ", taiKhoan=" + taiKhoan + ", tenTK=" + tenTK + ", trangThai="
				+ trangThai + "]";
	}




	public int getMaNV() {
		return maNV;
	}




	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}




	public String getTenNV() {
		return tenNV;
	}




	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}




	public  DiaChi getDiaChi() {
		return diaChi;
	}




	/**
	 * @param diaChi
	 */
	public NhanVien(DiaChi diaChi) {
		super();
		this.diaChi = diaChi;
	}




	public void setDiaChi(DiaChi diaChi) {
		this.diaChi = diaChi;
	}




	public int getNamSinh() {
		return namSinh;
	}




	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}




	public String getPhai() {
		return phai;
	}




	public void setPhai(String phai) {
		this.phai = phai;
	}




	public String getCMND() {
		return CMND;
	}




	public void setCMND(String cMND) {
		CMND = cMND;
	}




	public String getChucVu() {
		return chucVu;
	}




	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}




	public TaiKhoan getTenTK() {
		return tenTK;
	}




	public void setTenTK(TaiKhoan tenTK) {
		this.tenTK = tenTK;
	}





	public Vector<Object> toVector() {
		Vector<Object> v = new Vector<>();
		v.add("");
		v.add(maNV);
		v.add(tenNV);
		v.add(diaChi.getMaDC());
		v.add(namSinh);
		v.add(phai);
		v.add(CMND);
		v.add(chucVu);
		v.add(tenTK.getTaiKhoan());
		return v;
	}




	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}




	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}





	

}
