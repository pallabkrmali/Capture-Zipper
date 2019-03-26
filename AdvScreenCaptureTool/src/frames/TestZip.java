package frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.JLabel;

public class TestZip extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestZip frame = new TestZip();
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
	public TestZip() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Start Zip");
		button.setForeground(Color.WHITE);
		button.setBackground(Color.BLUE);
		button.setBounds(10, 11, 89, 23);
		contentPane.add(button);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.GREEN);
		progressBar.setBackground(Color.WHITE);
		progressBar.setBounds(109, 12, 456, 23);
		contentPane.add(progressBar);
		
		JCheckBox checkBox = new JCheckBox("Select All");
		checkBox.setBackground(Color.WHITE);
		checkBox.setBounds(6, 42, 97, 23);
		contentPane.add(checkBox);
		
		JLabel label = new JLabel("");
		label.setForeground(Color.BLUE);
		label.setBounds(109, 42, 456, 23);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 72, 555, 178);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 0, 549, 178);
		panel.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new GridLayout(13, 2));
		scrollPane.setViewportView(panel_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		panel_1.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("New check box");
		panel_1.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("New check box");
		panel_1.add(chckbxNewCheckBox_2);
		int l=60;
		for(int i=0;i<10;i++) {
			JCheckBox temp = new JCheckBox("New check box"+i);
			temp.setBounds(6, l+=26, 300, 23);
			panel_1.add(temp);
		}
		
        /*JScrollPane scrollPane = new JScrollPane(panel);
        contentPane.add(scrollPane);

        pack();
        setLocationRelativeTo(null);*/
		
	}
}
