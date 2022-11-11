package xuly;

import java.awt.Color;

import connectDB.ConnectDB;
import gui.DangNhapGUI;
import gui.GioiThieuGUI;

public class CountDownThread extends Thread {
	public void run() {
		int count = 5;
		ConnectDB.getInstance().connect();
		GioiThieuGUI GioiThieu = new GioiThieuGUI();
		GioiThieu.setVisible(true);
		GioiThieu.setLocationRelativeTo(null);
		for(int i=0;i<count;i++) {
			try {
				Thread.sleep(1500);
				GioiThieu.progressBar.setValue(10);
				if(i==1)
					GioiThieu.progressBar.setValue(30);
				if(i==2)
					GioiThieu.progressBar.setValue(70);
				if(i==3)
					GioiThieu.progressBar.setValue(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		GioiThieu.setVisible(false);
		DangNhapGUI DangNhap = new DangNhapGUI();
		DangNhap.setVisible(true);
		DangNhap.setLocationRelativeTo(null);
	}
}
