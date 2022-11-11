package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import java.awt.Color;

public class GioiThieuGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JProgressBar progressBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GioiThieuGUI frame = new GioiThieuGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GioiThieuGUI() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 467);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 progressBar = new JProgressBar();
		progressBar.setForeground(Color.RED);
		progressBar.setBounds(128, 445, 225, 17);
		contentPane.add(progressBar);
		
		JLabel lblAnhNen = new JLabel("");
		lblAnhNen.setIcon(new ImageIcon("Picture\\ans.png.jpg"));
		lblAnhNen.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnhNen.setBounds(0, 0, 492, 466);
		contentPane.add(lblAnhNen);
		
	}
}
