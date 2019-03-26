package frames;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Font;

public class TestZip extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 981122332845365103L;
	private JPanel contentPane;
	JPanel panel_1;
	JCheckBox checkBox;
	List<String> fileList;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 591, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JButton btnZip = new JButton("Start Zip");
		
		btnZip.setForeground(Color.WHITE);
		btnZip.setBackground(Color.BLUE);
		btnZip.setBounds(10, 11, 89, 23);
		contentPane.add(btnZip);
		
		final JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.GREEN);
		progressBar.setBackground(Color.WHITE);
		progressBar.setBounds(109, 12, 456, 22);
		contentPane.add(progressBar);
		
		checkBox = new JCheckBox("Select All");
		checkBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBox.setForeground(Color.WHITE);
		checkBox.setBackground(Color.BLUE);
		checkBox.setBounds(10, 41, 89, 23);
		contentPane.add(checkBox);
		
		final JLabel lblTC = new JLabel("");
		lblTC.setForeground(Color.BLUE);
		lblTC.setBounds(109, 42, 456, 23);
		contentPane.add(lblTC);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 100, 555, 470);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(2, 0, 549, 468);
		panel.add(scrollPane);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(new GridLayout(33, 2));
		scrollPane.setViewportView(panel_1);
		
		/*JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		panel_1.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("New check box");
		panel_1.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("New check box");
		panel_1.add(chckbxNewCheckBox_2);*/
		
		final JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setForeground(Color.GREEN);
		progressBar_1.setStringPainted(true);
		progressBar_1.setBounds(109, 72, 456, 22);
		contentPane.add(progressBar_1);
		
		JLabel lblOverAllProgress = new JLabel("Over All progress");
		lblOverAllProgress.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblOverAllProgress.setBounds(16, 72, 89, 17);
		contentPane.add(lblOverAllProgress);
		//int l=60;
		/*for(int i=0;i<30;i++) {
			JCheckBox temp = new JCheckBox("New check box"+i);
			temp.setBounds(6, l+=26, 300, 23);
			panel_1.add(temp);
		}*/
		
        /*JScrollPane scrollPane = new JScrollPane(panel);
        contentPane.add(scrollPane);

        pack();
        setLocationRelativeTo(null);*/
		
		btnZip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new Thread(){
					public void run(){
						btnZip.setEnabled(false);
						//btnClose.setEnabled(false);
						int totSelected=countDisable();
						int tpb=1;
						Component[] components=panel_1.getComponents();
						for(Component comp:components) {
							if(comp instanceof JCheckBox && ((JCheckBox) comp).isSelected() /*&& ((JCheckBox) comp).isEnabled() &&*/) {
								String tcName=((JCheckBox) comp).getText();
								System.out.println("Now compressing"+tcName);
								lblTC.setText("Now compressing : "+tcName);
								progressBar.setValue(0);
								//lblPercent.setText("0");
								((JCheckBox) comp).setEnabled(false);
								File dir=OpenApp.getBasePath();
								String folderName=dir.getAbsolutePath()+"\\"+tcName;
								//System.out.println("zip folder path:"+folderName);
								String zipName=folderName+".zip";//dir.getAbsolutePath()+"\\"+tcName+".zip";
								fileList = new ArrayList<String>();
								File tcNamedir=new File(folderName);
								//File[] fList=tcNamedir.listFiles();
								int test=1;
								try {
									populateFilesList(tcNamedir);
									
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								/*for(File inst: fList) {
									if(inst.isFile())fileList.add(inst.getAbsolutePath());
								}*/
								try {
									FileOutputStream fos= new FileOutputStream(zipName);
									ZipOutputStream  zos=new ZipOutputStream(fos);
									
									test=fileList.size();
									int i=1;
									for(String imagepath:fileList) {
						    			progressBar.setValue((int) Math.round((i*100)/test));
						    			//lblPercent.setText((int)Math.round((i*100)/test)+" %");
						    			i++;
						    			
										//System.out.println(imagepath);
										//System.out.println(imagepath.substring(tcNamedir.getAbsolutePath().length()+1,imagepath.length()));
										ZipEntry ze=new ZipEntry(imagepath.substring(tcNamedir.getAbsolutePath().length()+1,imagepath.length()));
										zos.putNextEntry(ze);
										FileInputStream fis=new FileInputStream(imagepath);
										byte[] buffer = new byte[1024];
							            int len;
							            while ((len = fis.read(buffer)) > 0) {
							                zos.write(buffer, 0, len);
							            }
							            zos.closeEntry();
							            fis.close();
									}
									
									zos.close();
									
									
									
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									//System.out.println(e);
									e.printStackTrace();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							progressBar_1.setValue((int) Math.round((tpb*100)/totSelected));
							tpb++;
						}
						lblTC.setText("Task Completed");
						//btnClose.setEnabled(true);
						checkBox.setEnabled(true);
						btnZip.setEnabled(true);
					}
				}.start();
			}
		});
		
		checkBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//JOptionPane.showMessageDialog(null, "All selected");
				boolean act=checkBox.isSelected();
				//int flag=0;
				Component[] components=panel_1.getComponents();
				for(Component comp:components) {
					if(comp instanceof JCheckBox && ((JCheckBox) comp).isEnabled()) {
						//if(flag>0) ((JCheckBox) comp).setEnabled(!act);
						((JCheckBox) comp).setSelected(act);
						//flag++;
						
					}
				}
			}});
		
	}
	public void populatFolder(List<String> ziplist) {
		String bpath=OpenApp.getBasePath().getAbsolutePath();
		panel_1.setLayout(new GridLayout(ziplist.size(), 2));
		
		for(String str:ziplist) {
			String tooltxt=str;
			str=str.substring(bpath.length()+1);
			//if(!new File(str+".zip").exists()) {
				JCheckBox temp = new JCheckBox(str);
				temp.setToolTipText(tooltxt);
				temp.setBackground(Color.WHITE);
				panel_1.add(temp);
			//}
			
		}
	}
	
	private void populateFilesList(File dir) throws IOException {
        File[] files = dir.listFiles();
        for(File file : files){
            if(file.isFile()) fileList.add(file.getAbsolutePath());
            else populateFilesList(file);
        }
    }
	private int countDisable() {
		int counter=0;
		Component[] components=panel_1.getComponents();
		for(Component comp:components) {
			if(comp instanceof JCheckBox && ((JCheckBox) comp).isSelected()) {
				counter++;
				((JCheckBox) comp).setEnabled(false);
			}
		}
		return counter;
	}
}
