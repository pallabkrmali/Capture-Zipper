package frames;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.swing.JCheckBox;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class ZipList extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	List<String> fileList;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZipList frame = new ZipList(null);
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
	public ZipList(Component[] components) {
		setBackground(Color.WHITE);
		setResizable(false);
		int ckh=43;
		int fy=80;
		setTitle("Compress Tool");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, fy, 520, 103);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JCheckBox chckbxSelectAll = new JCheckBox("Select All");
		chckbxSelectAll.setBackground(Color.WHITE);
		chckbxSelectAll.setBounds(6, 42, 97, 23);
		contentPane.add(chckbxSelectAll);
		JScrollPane scrPane = new JScrollPane();
		contentPane.add(scrPane);
		final JButton btnZip = new JButton("Start Zip");
		btnZip.setForeground(Color.WHITE);
		btnZip.setBackground(Color.BLUE);
		
		btnZip.setBounds(10, 11, 89, 23);
		contentPane.add(btnZip);
		
		final JProgressBar progressBar = new JProgressBar();
		progressBar.setBackground(Color.WHITE);
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.GREEN);
		progressBar.setBounds(109, 12, 363, 23);
		contentPane.add(progressBar);
		
		final JLabel lblTC = new JLabel("");
		lblTC.setForeground(Color.BLUE);
		lblTC.setBounds(109, 42, 401, 14);
		contentPane.add(lblTC);
		
		final JLabel lblPercent = new JLabel("");
		lblPercent.setForeground(Color.BLUE);
		lblPercent.setBounds(0, 80, 46, 23);
		contentPane.add(lblPercent);
		
		final JButton btnClose = new JButton("X");
		btnClose.setBackground(Color.RED);
		btnClose.setForeground(Color.WHITE);
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				OpenApp.setOpenAppVisible(true);
			}
		});
		btnClose.setBounds(482, 0, 42, 23);
		contentPane.add(btnClose);
		
		for(Component comp:components) {
			if(comp instanceof JRadioButton) {
				if(((JRadioButton) comp).isSelected()) {
					JCheckBox temp=new JCheckBox(((JRadioButton) comp).getText());
					ckh+=23;
					temp.setBounds(6, ckh, 350, 23);
					temp.setBackground(Color.WHITE);
					contentPane.add(temp);
					
					setBounds(100, 100, 520, fy+=23);
					contentPane.repaint();
				}
			}
			
		}
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int w = dim.getSize().width;
		int h = dim.getSize().height;
		
		setLocation(w-getWidth(), h-getHeight()-45);
		chckbxSelectAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//JOptionPane.showMessageDialog(null, "All selected");
				boolean act=chckbxSelectAll.isSelected();
				//int flag=0;
				Component[] components=(Component[])getContentPane().getComponents();
				for(Component comp:components) {
					if(comp instanceof JCheckBox && ((JCheckBox) comp).isEnabled()) {
						//if(flag>0) ((JCheckBox) comp).setEnabled(!act);
						((JCheckBox) comp).setSelected(act);
						//flag++;
						
					}
				}
			}});
		
		btnZip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chckbxSelectAll.setEnabled(false);
				new Thread(){
					public void run(){
						btnZip.setEnabled(false);
						btnClose.setEnabled(false);
						Component[] components=(Component[])getContentPane().getComponents();
						for(Component comp:components) {
							if(comp instanceof JCheckBox && ((JCheckBox) comp).isSelected() && ((JCheckBox) comp).isEnabled() && !((JCheckBox) comp).getText().equalsIgnoreCase("Select All")) {
								String tcName=((JCheckBox) comp).getText();
								//System.out.println("Now compressing"+tcName);
								lblTC.setText("Now compressing : "+tcName);
								progressBar.setValue(0);
								//lblPercent.setText("0");
								((JCheckBox) comp).setEnabled(false);
								File dir=OpenApp.getBasePath();
								String folderName=dir.getAbsolutePath()+"\\"+tcName;
								//System.out.println("zip folder path:"+folderName);
								String zipName=dir.getAbsolutePath()+"\\"+tcName+".zip";
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
						}
						lblTC.setText("Task Completed");
						btnClose.setEnabled(true);
						chckbxSelectAll.setEnabled(true);
						btnZip.setEnabled(true);
					}
				}.start();
				
				
			}
		});
	}
	
	private void populateFilesList(File dir) throws IOException {
        File[] files = dir.listFiles();
        for(File file : files){
            if(file.isFile()) fileList.add(file.getAbsolutePath());
            else populateFilesList(file);
        }
    }
	
	public ArrayList<String> getFolderList() {
		File dir=OpenApp.getBasePath();
		File[] folders=dir.listFiles();
		ArrayList<String> allfolderName = new ArrayList<String>();
		for(int i=0;i<folders.length;i++) {
			if(folders[i].isDirectory()) {
				//System.out.println("File :"+folders[i].getName());
				//allfolderName.add(folders[i].getName());
				allfolderName.add(folders[i].getName().toString());
			}
			
		}
		//for(int j=0;j<allfolderName.size();j++) {
			//System.out.println(allfolderName.get(j));
		//}
		return allfolderName;
	}
}
