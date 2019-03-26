package frames;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Font;
public class LaunchApp {

	private JFrame frmApplicationConfiguration;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LaunchApp window = new LaunchApp();
					window.frmApplicationConfiguration.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LaunchApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmApplicationConfiguration = new JFrame();
		frmApplicationConfiguration.setTitle("Application Configuration");
		frmApplicationConfiguration.getContentPane().setBackground(new Color(248, 248, 255));
		frmApplicationConfiguration.setResizable(false);
		frmApplicationConfiguration.setBounds(100, 100, 631, 245);
		frmApplicationConfiguration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmApplicationConfiguration.getContentPane().setLayout(null);
		//frame.setBackground(new Color(1.0f,1.0f,1.0f,0.5f));
		JButton startApp = new JButton("Launch Application");
		startApp.setFont(new Font("Tahoma", Font.BOLD, 10));
		startApp.setForeground(Color.WHITE);
		startApp.setBackground(Color.BLUE);
		
		startApp.setBounds(236, 168, 147, 23);
		frmApplicationConfiguration.getContentPane().add(startApp);
		
		JLabel lblSelectImageMapping = new JLabel("Select image mapping :");
		lblSelectImageMapping.setBounds(10, 34, 133, 14);
		frmApplicationConfiguration.getContentPane().add(lblSelectImageMapping);
		
		final JRadioButton rdbtnOneToOne = new JRadioButton("One to One");
		rdbtnOneToOne.setBackground(new Color(248, 248, 255));
		rdbtnOneToOne.setBounds(149, 30, 118, 23);
		frmApplicationConfiguration.getContentPane().add(rdbtnOneToOne);
		
		JLabel lblNewLabel = new JLabel("( One captured screen to only one folder at a click )");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setBounds(294, 34, 321, 14);
		frmApplicationConfiguration.getContentPane().add(lblNewLabel);
		
		JRadioButton rdbtnOneToMany = new JRadioButton("One to Many");
		rdbtnOneToMany.setBackground(new Color(248, 248, 255));
		rdbtnOneToMany.setBounds(149, 55, 118, 23);
		frmApplicationConfiguration.getContentPane().add(rdbtnOneToMany);
		ButtonGroup map=new ButtonGroup();
		map.add(rdbtnOneToOne);
		map.add(rdbtnOneToMany);
		
		JLabel lblOneImage = new JLabel("( One captured screen to many folder at a click )");
		lblOneImage.setForeground(new Color(0, 0, 255));
		lblOneImage.setBounds(294, 59, 321, 14);
		frmApplicationConfiguration.getContentPane().add(lblOneImage);
		
		JLabel lblSelectImageType = new JLabel("Select Image type :");
		lblSelectImageType.setBounds(10, 88, 133, 14);
		frmApplicationConfiguration.getContentPane().add(lblSelectImageType);
		
		final JRadioButton rdbtnPng = new JRadioButton(".png");
		rdbtnPng.setBackground(new Color(248, 248, 255));
		rdbtnPng.setBounds(149, 84, 88, 23);
		frmApplicationConfiguration.getContentPane().add(rdbtnPng);
		
		final JRadioButton rdbtnJpg = new JRadioButton(".jpg");
		rdbtnJpg.setBackground(new Color(248, 248, 255));
		rdbtnJpg.setBounds(149, 110, 88, 23);
		frmApplicationConfiguration.getContentPane().add(rdbtnJpg);
		
		JRadioButton rdbtnbmp = new JRadioButton(".bmp");
		rdbtnbmp.setBackground(new Color(248, 248, 255));
		rdbtnbmp.setBounds(149, 138, 88, 23);
		frmApplicationConfiguration.getContentPane().add(rdbtnbmp);
		
		ButtonGroup img=new ButtonGroup();
		img.add(rdbtnPng);
		img.add(rdbtnJpg);
		img.add(rdbtnbmp);
		
		rdbtnOneToOne.setSelected(true);
		rdbtnPng.setSelected(true);
		
		startApp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				OpenApp app=new OpenApp();
				if(rdbtnOneToOne.isSelected()) app.setMap(true);
				else app.setMap(false);
				
				if(rdbtnPng.isSelected()) OpenApp.setImageType("png");
				else if(rdbtnJpg.isSelected()) OpenApp.setImageType("jpg");
				else OpenApp.setImageType("bmp");
				app.runOpenApp();
				//app.ru
				
				frmApplicationConfiguration.dispose();
			}
		});
	}
}
