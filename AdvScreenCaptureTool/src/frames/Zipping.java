package frames;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Zipping extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8938380833816240757L;
	//private JPanel contentPane;
	public JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Zipping frame = new Zipping();
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
	public Zipping() {
		/*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);*/
		
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBackground(Color.WHITE);

        panel = new JPanel();
        
        panel.setBackground(Color.WHITE);
        final JCheckBox cbSelAll= new JCheckBox("Select All");
        
        cbSelAll.setForeground(Color.BLUE);
        cbSelAll.setSize(new Dimension(100,25));
        cbSelAll.setBackground(Color.WHITE);
        JCheckBox cbSelnZip= new JCheckBox("Select Non Zipped");
        cbSelnZip.setBackground(Color.WHITE);
        JProgressBar pb=new JProgressBar();
        pb.setBackground(Color.WHITE);
        pb.setForeground(Color.GREEN);
        //pb.setPreferredSize(new Dimension(600, 30));
        JButton start=new JButton("Start Zipping");
        start.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        	}
        });
        
        cbSelAll.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		boolean act=cbSelAll.isSelected();
    			//int flag=0;
    			Component[] components=panel.getComponents();
    			for(Component comp:components) {
    				if(comp instanceof JCheckBox && ((JCheckBox) comp).isEnabled()) {
    					//if(flag>0) ((JCheckBox) comp).setEnabled(!act);
    					((JCheckBox) comp).setSelected(act);
    					//flag++;
    					
    				}
    			}
        	}
        });
        
        
        start.setBackground(Color.BLUE);
        start.setForeground(Color.WHITE);
        //pb.setVisible(false);
        JLabel st=new JLabel("");
        panel.add(st);
        panel.add(pb);
        panel.add(cbSelAll);
        panel.add(start);

        /*for(int i=0; i<x*y;i++){
            JCheckBox button = new JCheckBox("CheckBox :"+String.valueOf(i));
            //button.setPreferredSize(new Dimension(350,25));
           // JLabel stat=new JLabel("Zipped");
            //JProgressBar temp.app=new JProgressBar();
            panel.add(button);
            //panel.add(temp);
        }*/
        
        //panel.add(cbSelnZip);
        
        
	}
	public void populatList(List<String> ziplist) {
		panel.setLayout(new GridLayout(ziplist.size(), 2));
		String bpath=OpenApp.getBasePath().getAbsolutePath();
		panel.add(new JLabel("List of non zipped folder under directory:"));
		panel.add(new JLabel(bpath));
		System.out.println(bpath);
		for(String str:ziplist) {
			str=str.substring(bpath.length()+1);
			//if(!new File(str+".zip").exists()) {
				JCheckBox temp = new JCheckBox(str);
				panel.add(temp);
			//}
			
		}
		JPanel container = new JPanel(new FlowLayout(FlowLayout.CENTER, 0,0));
        container.add(panel);
        JScrollPane scrollPane = new JScrollPane(container);
        getContentPane().add(scrollPane);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
	}
	
	

}
