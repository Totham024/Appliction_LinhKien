package main;


import connectDB.ConnectDB;

import xuly.CountDownThread;

public class Main {
	public static void main(String[] args) {
		try {
			ConnectDB.getInstance().connect();
			CountDownThread countDownThread = new CountDownThread();
			countDownThread.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
