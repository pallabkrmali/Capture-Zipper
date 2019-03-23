package frames;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Enumeration;
import java.util.NoSuchElementException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Component;

import functions.CreateFolder;
import java.awt.Window.Type;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class OpenApp {

	private static JFrame frmMultilineScreenCapture;
	private JTextField txtPath;
	private JLabel devinfo;
	public int yaxix = 70;
	public int frmHight = 120;
	public int capH = 23;
	public String path;
	ButtonGroup btnGroup = new ButtonGroup();
	private JButton btnStart;
	private JButton btnCapture;
	private JButton btnReset;
	public static File basePath;
	CreateFolder fn = new CreateFolder();
	private JCheckBox chckbxWait;
	
	private static boolean map;
	private static String imageType;
	
	public static void setOpenAppVisible(boolean b) {
		frmMultilineScreenCapture.setVisible(b);
	}
	
	public static boolean isMap() {
		return map;
	}

	public void setMap(boolean maps) {
		map = maps;
	}

	public static String getImageType() {
		return imageType;
	}

	public static void setImageType(String imageTypes) {
		imageType = imageTypes;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws NoSuchElementException{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//OpenApp window = new OpenApp();
					new OpenApp();
					frmMultilineScreenCapture.setVisible(true);
					frmMultilineScreenCapture.setAlwaysOnTop(true);
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					int w = dim.getSize().width;
					int h = dim.getSize().height;
					////// System.out.println(w+":"+h);

					frmMultilineScreenCapture.setLocation(w - frmMultilineScreenCapture.getWidth(),
							h - frmMultilineScreenCapture.getHeight() - 40);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void runOpenApp() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//OpenApp window = new OpenApp();
					new OpenApp();
					frmMultilineScreenCapture.setVisible(true);
					frmMultilineScreenCapture.setAlwaysOnTop(true);
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					int w = dim.getSize().width;
					int h = dim.getSize().height;
					////// System.out.println(w+":"+h);

					frmMultilineScreenCapture.setLocation(w - frmMultilineScreenCapture.getWidth(),
							h - frmMultilineScreenCapture.getHeight() - 40);
					System.out.println("IMAGE TYPE: "+getImageType()+ " and mapping: "+isMap());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public OpenApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frmMultilineScreenCapture = new JFrame();
		frmMultilineScreenCapture.setType(Type.UTILITY);
		frmMultilineScreenCapture.setResizable(false);
		frmMultilineScreenCapture.setTitle("Screen Capture Tool (V2.0)");
		frmMultilineScreenCapture.getContentPane().setBackground(new Color(255, 255, 255));
		frmMultilineScreenCapture.setBounds(100, 100, 450, frmHight);
		frmMultilineScreenCapture.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMultilineScreenCapture.getContentPane().setLayout(null);
		//frmMultilineScreenCapture.setUndecorated(true);
		//frmMultilineScreenCapture.setOpacity((float) .5);

		JLabel label = new JLabel("Storage Path :");
		label.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label.setBounds(9, 12, 74, 14);
		frmMultilineScreenCapture.getContentPane().add(label);

		txtPath = new JTextField();
		txtPath.setToolTipText("Like \"C:\\Users\\Username\\Documents\\R4000\"");
		txtPath.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPath.setColumns(10);
		txtPath.setBounds(85, 8, 288, 20);
		frmMultilineScreenCapture.getContentPane().add(txtPath);

		final JButton btnAdd = new JButton("+");
		btnAdd.setForeground(new Color(0, 0, 0));
		btnAdd.setToolTipText("Hot Key Alt+A");
		btnAdd.setSelectedIcon(null);
		btnAdd.setBackground(new Color(173, 255, 47));
		btnAdd.setMnemonic('a');
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnAdd.setBounds(223, 39, 43, 23);
		btnAdd.setEnabled(false);
		frmMultilineScreenCapture.getContentPane().add(btnAdd);
		final JButton btnRemove = new JButton("-");
		btnRemove.setToolTipText("Hot Key Alt+D");
		btnRemove.setMnemonic('d');
		btnRemove.setForeground(new Color(0, 0, 0));
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnRemove.setBackground(new Color(255, 69, 0));
		btnRemove.setEnabled(false);
		btnRemove.setBounds(269, 40, 37, 23);
		frmMultilineScreenCapture.getContentPane().add(btnRemove);

		devinfo = new JLabel("Designed and Developed by - Pallab Kumar Mali");
		devinfo.setToolTipText("Email @ pallab.kumar.mali@accenture.com");
		devinfo.setForeground(SystemColor.windowBorder);
		devinfo.setFont(new Font("Tahoma", Font.ITALIC, 9));
		devinfo.setBounds(223, 67, 211, 14);
		frmMultilineScreenCapture.getContentPane().add(devinfo);

		btnStart = new JButton("Start");
		btnStart.setToolTipText("Hot Key Alt+S");
		btnStart.setMnemonic('s');
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				path = txtPath.getText();
				path = path.trim();
				//// System.out.println(fn.validateDirectory(getBasePath(),path));
				if (!path.equals(null) && !path.equals("") && fn.validateDirectory(getBasePath(), path)) {
					txtPath.setEnabled(false);
					txtPath.setToolTipText(path);
					btnAdd.setEnabled(true);
					btnRemove.setEnabled(true);
					btnStart.setEnabled(false);
					btnStart.setVisible(false);
					btnCapture.setVisible(true);
					btnReset.setEnabled(true);
					frmMultilineScreenCapture.repaint();
				} else {
					JOptionPane.showMessageDialog(null, "Invalid storage Path \n Please enter a valid storage location");
				}

			}
		});
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnStart.setBackground(new Color(255, 250, 205));
		btnStart.setForeground(new Color(0, 0, 0));
		btnStart.setBounds(9, 41, 88, 23);
		frmMultilineScreenCapture.getContentPane().add(btnStart);

		btnCapture = new JButton("Capture");
		btnCapture.setToolTipText("Hot Key Alt+C");
		btnCapture.setMnemonic('c');
		btnCapture.setBounds(10, 41, 89, capH);
		btnCapture.setBackground(Color.BLUE);
		btnCapture.setForeground(Color.WHITE);
		btnCapture.setVisible(false);
		frmMultilineScreenCapture.getContentPane().add(btnCapture);
		
		JButton btnOpenTcFolder = new JButton("Open");
		btnOpenTcFolder.setToolTipText("Hot Key - Alt+X");
		btnOpenTcFolder.setMnemonic('x');
		
		btnOpenTcFolder.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnOpenTcFolder.setBackground(new Color(255, 165, 0));
		btnOpenTcFolder.setBounds(310, 39, 63, 23);
		frmMultilineScreenCapture.getContentPane().add(btnOpenTcFolder);
		
		chckbxWait = new JCheckBox("Wait (Sec)");
		chckbxWait.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chckbxWait.setBackground(new Color(255, 255, 255));
		chckbxWait.setBounds(103, 41, 74, 23);
		frmMultilineScreenCapture.getContentPane().add(chckbxWait);
		
		final JSpinner spinner = new JSpinner();
		spinner.setToolTipText("Time in Seconds");
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 10));
		spinner.setModel(new SpinnerNumberModel(1, 1, 9, 1));
		spinner.setBounds(184, 42, 29, 20);
		frmMultilineScreenCapture.getContentPane().add(spinner);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setBackground(new Color(153, 255, 255));
		btnHelp.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				About ab=new About();
				ab.setVisible(true);
			}
		});
		btnHelp.setBounds(383, 0, 63, 18);
		frmMultilineScreenCapture.getContentPane().add(btnHelp);
		
		JButton btnZip = new JButton("Zip");
		
		btnZip.setForeground(Color.WHITE);
		btnZip.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnZip.setBackground(Color.BLUE);
		btnZip.setBounds(383, 40, 63, 22);
		frmMultilineScreenCapture.getContentPane().add(btnZip);
		
		btnReset = new JButton("Reset");
		
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnReset.setBackground(Color.RED);
		btnReset.setBounds(383, 21, 63, 18);
		btnReset.setEnabled(false);
		frmMultilineScreenCapture.getContentPane().add(btnReset);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					JFrame inputframe = new JFrame("Input Dialog Example 3");
					String tcName = JOptionPane.showInputDialog(inputframe, "Enter TC name OR Sub TC (TC\\SUB TC)", "Add new Test Case",
							JOptionPane.INFORMATION_MESSAGE);
					tcName = tcName.trim();
					System.out.println(tcName);
					if (!tcName.equals(null) && !tcName.equals("")) {
						if(!tcName.contains("\\\\") && !tcName.contains("/")) {
							File newDir = fn.createTCFolder(getBasePath().getAbsolutePath(), tcName);
							if (newDir.exists()) {
								addRadioButton(tcName);
								frmMultilineScreenCapture.repaint();
							} else {
								JOptionPane.showMessageDialog(null, "Unable to create folder :\"" + tcName + "\"");
							}
						}else {
							JOptionPane.showMessageDialog(null, "Invalid TC / Sub TC name");
						}
						

					} else {
						JOptionPane.showMessageDialog(null, "Required TC Name");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Required TC Name"+e);
				}

			}

		});

		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// System.out.println(btnGroup.getButtonCount());
				Component[] components=(Component[])frmMultilineScreenCapture.getContentPane().getComponents();
				int rbcount=returnRBExistCount(components);
				int selectrbcount=returnRBSelectCount(components);
				if(rbcount==0) {
					int act1=JOptionPane.showConfirmDialog(null, "Do you want to reset your application", "Confirmation", JOptionPane.YES_NO_OPTION);
					System.out.println("Action value:"+act1);
					if(act1==0)
					btnReset.doClick();
				}
				else if(selectrbcount==0) {
					JOptionPane.showMessageDialog(null, "Select one or more radio button to mark as complete");
					
				}
				else {
					int act=JOptionPane.showConfirmDialog(null, "Do you want to zip selected Result folder", "Confirmation", JOptionPane.YES_NO_OPTION);
					System.out.println("Action value:"+act);
					if(act==0) {
						frmMultilineScreenCapture.setVisible(false);
						ZipList zls=new ZipList(components);
						zls.setVisible(true);
					}
					for(Component comp:components) {
						if(comp instanceof JRadioButton && ((JRadioButton) comp).isSelected()) {
							if(map) btnGroup.remove(((JRadioButton) comp));
							frmMultilineScreenCapture.remove(((JRadioButton) comp));
							reArrangeRB();
							frmMultilineScreenCapture.repaint();
						}
					}	
				}
			}
		});
		btnCapture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean ckbx=chckbxWait.isSelected();
				if(map) {
					if (btnGroup.getButtonCount() > 0) {
						try {
							AbstractButton selectedButton = getbtnGroupSelect();
							String selectFname = selectedButton.getText();
							// System.out.println("Captured folder name"+selectFname);
							
							System.out.println(spinner.getValue().toString()+" sPINNERCheckbox checked"+ ckbx);
							if(chckbxWait.isSelected()) Thread.sleep(Integer.parseInt(spinner.getValue().toString())*1000);
							
							frmMultilineScreenCapture.setVisible(false);
							
							fn.captureScreen(getBasePath(), selectFname);
							//if (!fn.captureScreen(getBasePath(), selectFname)) {
								//JOptionPane.showMessageDialog(null, "Something went wrong!\n Report Developer");
							//}
							frmMultilineScreenCapture.setVisible(true);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Select TC name radio button");
							frmMultilineScreenCapture.setVisible(true);
						}

					} else {
						JOptionPane.showMessageDialog(null, "Action Denied \n Add TC name first");
					}
				}
				
				else {
					Component[] components=(Component[])frmMultilineScreenCapture.getContentPane().getComponents();
					System.out.println("Radio button fund: "+components.length);
					boolean captured=false;
					if(chckbxWait.isSelected())
						try {
							Thread.sleep(Integer.parseInt(spinner.getValue().toString())*1000);
							
							
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					for(Component comp:components) {
						frmMultilineScreenCapture.setVisible(false);
						if(comp instanceof JRadioButton && ((JRadioButton) comp).isSelected()) {
							captured=true;
							//if(flag>0) ((JCheckBox) comp).setEnabled(!act);
							
							String selectFname = ((JRadioButton) comp).getText();
							
							fn.captureScreen(getBasePath(), selectFname);
							
							//flag++;
							
						}
					}
					if(!captured) JOptionPane.showMessageDialog(null, "Select one or more radio button");
					frmMultilineScreenCapture.setVisible(true);
					//JOptionPane.showMessageDialog(null, "Multiple Capture");
				}
			}
		});
		btnOpenTcFolder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Component[] components=(Component[])frmMultilineScreenCapture.getContentPane().getComponents();
				boolean select=false;
				for(Component comp:components) {
					if(comp instanceof JRadioButton && ((JRadioButton) comp).isSelected()) {
						select=true;
						//if(flag>0) ((JCheckBox) comp).setEnabled(!act);
						String selectFname = ((JRadioButton) comp).getText();
						fn.openFolder(selectFname);
						//flag++;
						
					}
				}
				if(!select) JOptionPane.showMessageDialog(null, "Select radio button");
				/*if (btnGroup.getButtonCount() > 0) {
					if(btnGroup.getButtonCount()==1) {
						Enumeration<AbstractButton> buttons=btnGroup.getElements();
						AbstractButton button = buttons.nextElement();
						String bName=button.getText();
						//System.out.println(bName);
						fn.openFolder(bName);
					}
					else
					try {
						AbstractButton selection = getbtnGroupSelect();
						String selectFname = selection.getText();
						fn.openFolder(selectFname);
					}
						
					 catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Action Denied \n Select TC");
					}

					// btnGroup.remove(b);
				} else {
					JOptionPane.showMessageDialog(null,"Action Denied \n Add TC before open result folder");
				}*/
			}
		});
		
		btnZip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Under Construction\n Now you can zip from [-] button");
				//ZipList fzip=new ZipList();
				//fzip.setVisible(true);
			}
		});
		
		
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPath.setEnabled(true);
				//txtPath.setText(null);
				txtPath.setToolTipText(null);
				btnAdd.setEnabled(false);
				btnRemove.setEnabled(false);
				btnStart.setEnabled(true);
				btnStart.setVisible(true);
				btnCapture.setVisible(false);
				//remove all buttons
				System.out.println("Number of buttons : "+btnGroup.getButtonCount());
				try {
					Component[] components=(Component[])frmMultilineScreenCapture.getContentPane().getComponents();
					for(Component comp:components) {
						if(comp instanceof JRadioButton) {
								//if(flag>0) ((JCheckBox) comp).setEnabled(!act);
								if(map) btnGroup.remove(((JRadioButton) comp));
								frmMultilineScreenCapture.remove(((JRadioButton) comp));
								reArrangeRB();
								frmMultilineScreenCapture.repaint();
						}
					}
					
					
					devinfo.setBounds(223, 70, 211, 14);
					yaxix=70;
					frmHight=120;
					frmMultilineScreenCapture.setBounds(100, 100, 450, frmHight);
					frmMultilineScreenCapture.repaint();
					setBasePath(null);
					btnReset.setEnabled(false);
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					int w = dim.getSize().width;
					int h = dim.getSize().height;
					////// System.out.println(w+":"+h);

					frmMultilineScreenCapture.setLocation(w - frmMultilineScreenCapture.getWidth(),
							h -frmMultilineScreenCapture.getHeight() - 40);
					capH=23;
					btnCapture.setBounds(10, 41, 89, capH);
					
				}
				catch(NoSuchElementException ex) {
					JOptionPane.showMessageDialog(null, "Application error");
					frmMultilineScreenCapture.dispose();
					//System.out.println(ex);
					/*devinfo.setBounds(223, 70, 211, 14);
					yaxix=70;
					frmHight=120;
					frmMultilineScreenCapture.setBounds(100, 100, 450, frmHight);
					frmMultilineScreenCapture.repaint();
					setBasePath(null);
					btnReset.setEnabled(false);
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					int w = dim.getSize().width;
					int h = dim.getSize().height;
					////// System.out.println(w+":"+h);

					frmMultilineScreenCapture.setLocation(w - frmMultilineScreenCapture.getWidth(),
							h -frmMultilineScreenCapture.getHeight() - 40);
					capH=23;
					btnCapture.setBounds(10, 41, 89, capH);*/
				}
				
			}
		});
		// Action Lisitener
			
		
	}
	public int returnRBSelectCount(Component[] components) {
		int count=0;
		for(Component comp:components) {
			if(comp instanceof JRadioButton && ((JRadioButton) comp).isSelected()) {
					count++;
			}
		}
		return count;
	}
	public int returnRBExistCount(Component[] components) {
		int count=0;
		for(Component comp:components) {
			if(comp instanceof JRadioButton) {
					count++;
			}
		}
		return count;
	}

	public void addRadioButton(String tcName) {
		// System.out.println("Before add new button:"+btnGroup.getButtonCount());
		JRadioButton temp = new JRadioButton(tcName);
		temp.setBounds(118, yaxix, 300, 20);
		btnCapture.setBounds(10, 41, 89, capH += 20);
		temp.setBackground(Color.WHITE);
		temp.setFont(new Font("Tahoma", Font.BOLD, 9));
		temp.setToolTipText(tcName);
		frmMultilineScreenCapture.setBounds(100, 100, 450, frmHight += 20);
		devinfo.setBounds(223, frmHight - 54, 211, 14);
		frmMultilineScreenCapture.getContentPane().add(temp);
		if(map)btnGroup.add(temp);
		temp.setSelected(true);
		// System.out.println("After:"+btnGroup.getButtonCount());
		yaxix = yaxix + 20;
		rePosition();
		temp = null;
	}

	public AbstractButton getbtnGroupSelect() {
		Enumeration<AbstractButton> buttons = btnGroup.getElements();
		do {
			AbstractButton button = buttons.nextElement();
			if (button.isSelected()) {
				/*
				 * btnGroup.remove(button); button.setSelected(false); frame.remove(button);
				 * frame.repaint();
				 */
				return button;

			}
		} while (buttons.hasMoreElements());
		return null;
	}

	public void reArrangeRB() {
		
		Component[] components=(Component[])frmMultilineScreenCapture.getContentPane().getComponents();
		yaxix = 70;
		for(Component comp:components) {
			if(comp instanceof JRadioButton) {
				((JRadioButton)comp).setBounds(118, yaxix, 300, 20);
				yaxix += 20;
			}
		}
		btnCapture.setBounds(10, 41, 89, capH -= 20);
		frmMultilineScreenCapture.setBounds(100, 100, 450, frmHight -= 20);

		devinfo.setBounds(223, yaxix - 3, 211, 14);
		frmMultilineScreenCapture.repaint();
		rePosition();
		
		/*Enumeration<AbstractButton> buttons = btnGroup.getElements();
		yaxix = 70;
		do {
			AbstractButton button = buttons.nextElement();
			button.setBounds(118, yaxix, 300, 20);
			yaxix += 20;
		} while (buttons.hasMoreElements());
		btnCapture.setBounds(10, 41, 89, capH -= 20);
		frmMultilineScreenCapture.setBounds(100, 100, 450, frmHight -= 20);

		devinfo.setBounds(223, yaxix - 3, 211, 14);
		frmMultilineScreenCapture.repaint();
		rePosition();*/
	}

	public void rePosition() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int w = dim.getSize().width;
		int h = dim.getSize().height;
		////// System.out.println(w+":"+h);

		frmMultilineScreenCapture.setLocation(w - frmMultilineScreenCapture.getWidth(),
				h - frmMultilineScreenCapture.getHeight() - 40);
	}

	public static File getBasePath() {
		return basePath;
	}

	public static void setBasePath(File basePath) {
		OpenApp.basePath = basePath;
	}
}
