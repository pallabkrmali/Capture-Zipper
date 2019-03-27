package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;

public class About extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private static About frame;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
					frame.setVisible(true);
					//Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					//int w = dim.getSize().width;
					//int h = dim.getSize().height;
					//frame.setLocation(w-(frame.getHeight()/2), h-(frame.getWidth()/2));
					//frame.setLocation(10,10);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public About() {
		setResizable(false);
		setTitle("Help");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 830, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblUserGuide = new JLabel("User Guide");
		lblUserGuide.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblUserGuide.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserGuide.setBounds(10, 11, 794, 33);
		contentPane.add(lblUserGuide);
		
		table = new JTable();
		table.setForeground(Color.BLUE);
		table.setRowSelectionAllowed(false);
		table.setShowHorizontalLines(false);
		table.setFillsViewportHeight(true);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", ""},
				{" Storage Path", " Provide Local or remote system storage path Like \"C:\\Users\\User1\\Results\" or \"network address\""},
				{null, " * Storage path is required and path must be valid"},
				{" Start button", " Validate storage path, If the storage path is valid Start button will disappear and (+) and (-) button will be enabled"},
				{" + button", " Green color (+) button allows user to add TC name"},
				{null, " * Create folder of given TC name if not exist, TC name radio button will appear in the application window"},
				{null, " * Application allows storages of existing TC folder"},
				{null, " * Sub TC Folder can be added in the below format-"},
				{null, "   TC Folder Name\\Sub TC Folder Name "},
				{" - button", " Red color (-) button removes selected TC name from the list not the contents inside it"},
				{" Open button", " Directly open to the selected TC folder"},
				{" Capture button", " Capture desktop screen and store captured screen to selected TC (Storage folder)"},
				{" Wait (Sec) checkbox", " If checked - Wait (1-9) seconds after clicking on Capture button for actual screen capture"},
				{"", " * User can select wait value (1 to 9) from Spinner"},
				{" Zip", "Button zip provide the list of folders and subfolders inside the Storage path directory to compress"},
				{null, " * List contains only non zipped and non empty folders and subfolders"},
				{null, " * Parent folder name not populated if it don't have any file except folder"},
				{"............................................","..........................................................................................................................................................................................................................."},
				{"", " For any query and suggestions -"},
				{"", " Email # pallab.kumar.mali@accenture.com"}
			},
			new String[] {
				"Buttons", "Actions / Description"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setPreferredWidth(647);
		table.setBackground(Color.WHITE);
		table.setBounds(20, 55, 773, 321);
		contentPane.add(table);
		
	}
}
