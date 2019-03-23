package functions;

import java.awt.Desktop;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import frames.OpenApp;

public class CreateFolder {
	public boolean validateDirectory(File baseDir, String basePath) {
		File base = new File(basePath.trim());

		if (base.exists())
			OpenApp.setBasePath(base);
		return base.exists();
	}

	public File createTCFolder(String fPath, String fName) {
		System.out.println(fPath+"\\"+fName);
		String fPath1="";
		if (fName != "") {
			fPath1 = fPath + "\\" + fName;
		}
		String[] subfname=fName.split("\\\\");
		for(int i=0;i<subfname.length;i++) {
			System.out.println(subfname[i]);
		}
		System.out.println(fPath1);
		File dir = new File(fPath1);
		////// System.out.println("Directory exist: "+dir.exists());
		if (dir.exists()) {
			// dir=null;
			return dir;

		} else {
			String temp=fPath;
			for(int i=0;i<subfname.length;i++) {
				temp=temp+"\\"+subfname[i];
				System.out.println(subfname[i]);
				dir = new File(temp);
				if(!dir.exists())
				dir.mkdirs();
			}
			////// System.out.println("Directory created: "+dir.exists());
			if (dir.exists()) {
				////// System.out.println(dir.getAbsolutePath());
				return dir;
			} else {
				return dir;
			}
		}

	}

	public void captureScreen(File dir, String tcName) {
		String stcdir=OpenApp.getBasePath().getAbsolutePath()+"\\"+tcName;
		File tcdir=new File(stcdir);
		String fName="";
		if (tcdir.exists()) {
			//int ml=tcdir.getAbsolutePath().length();
			int indx=0,indx2=0;
			if(tcName.contains("/") || tcName.contains("\\")) {
				indx=tcName.lastIndexOf("/");
				indx2=tcName.lastIndexOf("\\");
				if(indx2>indx)
					indx=indx2;
				
			}
			else {
				fName=tcName;
			}
			if(indx>0) {
				fName=tcName.substring(indx);
				
			}
			if(fName.length()>150) {
				fName=fName.substring(0, 149);
			}
			System.out.println(fName);
			System.out.println(OpenApp.getImageType());
			String type=OpenApp.getImageType();
			try {
				Robot r = new Robot();
				SimpleDateFormat sdf = new SimpleDateFormat("yy_MMdd_HHmmssSSS");
				String path = "";
				/*String tmstmp=sdf.format(new Date());
				int lt=tmstmp.length();
				System.out.println(tmstmp);
				for(int i=lt;i==16;i++) {
					System.out.println("INSIDE LOOP"+tmstmp);
					tmstmp=tmstmp+"0";
					
				}*/
				if (tcName.equals("")) {
					path = OpenApp.getBasePath().getAbsolutePath() + "\\SC_" + sdf.format(new Date()) + "."+type;
				} else
					path = OpenApp.getBasePath().getAbsolutePath() + "\\" + tcName + "\\"+fName+"_" + sdf.format(new Date())+ "."+type;

				// System.out.println(path);
				// File dir=new File("E:\\SC");
				Thread.sleep(200);
				Rectangle capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
				BufferedImage Image = r.createScreenCapture(capture);
				ImageIO.write(Image, type, new File(path));
				////// System.out.println("Screenshot saved counter:"+dir.getParent());
				// desktop.open(dir);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Unable to capture Error: "+ex.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
			}
			//return true;
		} else {
			JOptionPane.showMessageDialog(null, "Directory:\" "+stcdir+"\" not exist", "Warning", JOptionPane.WARNING_MESSAGE);
			//return false;
		}
			
			
	}

	public void openFolder(String fName) {
		Desktop desktop = Desktop.getDesktop();
		File dir=new File(OpenApp.getBasePath().getAbsolutePath()+"\\"+fName);
		try {
			if (dir.exists()) {
				desktop.open(dir);
				//return true;
			}
			else//else {
				JOptionPane.showMessageDialog(null, dir.getAbsolutePath()+" \n Directory not Exist", "Warning", JOptionPane.WARNING_MESSAGE);
				//return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Unable to open ", "Warning", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
			//return false;
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
	
	public void zipFolder(String tcName) throws IOException,FileNotFoundException, InterruptedException {
		/*File dir=OpenApp.getBasePath();
		String folderName=dir.getAbsolutePath()+"\\"+tcName;
		System.out.println("zip folder path:"+folderName);
		String zipName=dir.getAbsolutePath()+"\\"+tcName+".zip";
		List<String> fileList = new ArrayList<String>();
		File tcNamedir=new File(folderName);
		File[] fList=tcNamedir.listFiles();
		int test=1;
		for(File inst: fList) {
			com.setBar(test++);
			if(inst.isFile()) fileList.add(inst.getAbsolutePath());
		}
		try {
			FileOutputStream fos= new FileOutputStream(zipName);
			ZipOutputStream  zos=new ZipOutputStream(fos);
			
			
			
			for(String imagepath:fileList) {
				System.out.println(imagepath);
				System.out.println(imagepath.substring(tcNamedir.getAbsolutePath().length()+1,imagepath.length()));
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
			System.out.println(e);
			e.printStackTrace();
		}*/
	}
}
