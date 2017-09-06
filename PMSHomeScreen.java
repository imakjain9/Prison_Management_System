//package PMS;
//import Warden.*;
//import Prisoner.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** public class PMSHomeScreen implements ActionListener Interface used to provides the user Interface. 
It provides user the Menu from where he/she can select whichever function they want to perform */
public class PMSHomeScreen implements ActionListener
{
	/** variable to create the Frame. */
		private JFrame frm;
	/** JLabel to create the north panel for header.*/
		private JPanel jpNrth;
	/** JLabel to create the center panel for poster.*/
		private JPanel jpCntr;
	
	
	/** JMenuBar to create the menu strip on the form in which main menu is present.*/
		public JMenuBar mbHomeMenu;
		
		
	/** JMenu to create the menu on the menuBar in which warden's operations are provided.*/
		public JMenu mnPrsnr;
	/** JMenu to create the menu on the menuBar in which priosner's operations are provided.*/
		public JMenu mnWrdn; 
	/** JMenu to create the menu on the menuBar in which reports provided.*/
		public JMenu mnRprt;
	/** JMenu to create the menu on the menuBar in which Logout provided.*/
		public JMenu mnLogOut;
		
	/** JMenuItem for adding a prisoner.*/
		public JMenuItem miPrsnrAdd;
	/** JMenuItem for updating a prisoner.*/
		public JMenuItem miPrsnrUpdt;
	/** JMenuItem for adding a warden.*/
		public JMenuItem miWrdnAdd;
	/** JMenuItem for updatng a prisoner.*/
		public JMenuItem miWrdnUpdt;
	/** JMenuItem for prisoner report.*/
		public JMenuItem miPrsnrDispRec; 
	/** JMenuItem for warden report.*/
		public JMenuItem miWrdnDispRec;
	/** JMenuItem for Log Out.*/
		public JMenuItem miLogout;

	/** JLabel for Header Image.*/
		private JLabel lblHdrImg;
	/** JLabel for Poster Image.*/
		private JLabel lblPrsnImg;
	
	/** Variable to create new Color object. */
		private Color MenBar;



	/**public Constructor PMSHomeScreen() of zero argument to initialize or construct the new object of WardenUpdate 
	i.e. it is initializing the values in the variables including JFrame, JPanel, JLabel, JMenuBar, JMenu and JMenuItem etc.*/
	public PMSHomeScreen()
	{
		frm=new JFrame();
		jpNrth=new JPanel();
		jpCntr = new JPanel();

		MenBar =new Color(217,192,154,255);
		mbHomeMenu=new JMenuBar();

		mnPrsnr=new JMenu("Prisoner");
		mnWrdn=new JMenu("Warden");
		mnRprt=new JMenu("Report");
		mnLogOut = new JMenu("Logout");
	
		miPrsnrAdd=new JMenuItem("Add");
		miPrsnrUpdt=new JMenuItem("Update");
		miWrdnAdd=new JMenuItem("Add");
		miWrdnUpdt=new JMenuItem("Update");
		miPrsnrDispRec=new JMenuItem("Display All Prisoners");
		miWrdnDispRec=new JMenuItem("Display All Wardens");
		miLogout = new JMenuItem("Logout");

		lblHdrImg =new JLabel(new ImageIcon("Images/PrisonHeader2.png"));
		lblPrsnImg=new JLabel(new ImageIcon("Images/PrisonImage.png"));
	}



	/**Public Method DisplayScreen() having zero argument and return type is void
	It is used to add the various fields of warden on the JFrame using layouts.*/	
	public void DisplayScreen()
	{
		frm.setTitle("Home Page");
		frm.setSize(1366,768);
		frm.setLocation(0,0);
		frm.setVisible(true);
		
		frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jpNrth.setBackground(new Color(122,174,250));
		jpNrth.add(lblHdrImg,new BorderLayout().CENTER);
		frm.add(jpNrth, new BorderLayout().NORTH);

		jpCntr.setBackground(Color.black);
		jpCntr.add(lblPrsnImg, new BorderLayout().CENTER); 
		frm.add(jpCntr, new BorderLayout().CENTER);
		

		//menu bar
		mbHomeMenu.setBackground(MenBar);
		frm.setJMenuBar(mbHomeMenu);

		//menu
		mbHomeMenu.add(mnPrsnr);
		mbHomeMenu.add(mnWrdn);
		mbHomeMenu.add(mnRprt);
		mbHomeMenu.add(mnLogOut);

		//menu item
		mnPrsnr.add(miPrsnrAdd);
		miPrsnrAdd.addActionListener(this);

		mnPrsnr.add(miPrsnrUpdt);
		miPrsnrUpdt.addActionListener(this);
		
		mnWrdn.add(miWrdnAdd);
		miWrdnAdd.addActionListener(this);

		mnWrdn.add(miWrdnUpdt);
		miWrdnUpdt.addActionListener(this);

		mnRprt.add(miPrsnrDispRec);
		miPrsnrDispRec.addActionListener(this);

		mnRprt.add(miWrdnDispRec);
		miWrdnDispRec.addActionListener(this);

		mnLogOut.add(miLogout);
		miLogout.addActionListener(this);
		
	}
	
	
	
	
	/**Public Method actionPerformed(ActionEvent e) having one argument with return type as void. 
	This method is coming from ActionListener interface.
	It is used to providing the functionality to the System i.e. on click of some specific button some operation will be performed.
	All these details given by this method.
	getSource() method is used here to identify the buttons.*/
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == miPrsnrAdd)
		{
			PrisonerAdd pa=new PrisonerAdd();
			pa.PrisonerDetails();
		}
		else if(e.getSource()==miPrsnrUpdt)
		{
			PrisonerUpdate pu=new PrisonerUpdate();
			pu.PrisonerDetailsUpdated ();
		}
		else if(e.getSource()==miWrdnAdd)
		{
			WardenAdd wa=new WardenAdd();
			wa.WardenDetails ();
		}
		else if(e.getSource()==miWrdnUpdt)
		{
			WardenUpdate wu=new WardenUpdate();
			wu.WardenDetailsUpdated ();
		}
		else if(e.getSource()==miPrsnrDispRec)
		{
			PrisonerReport pr=new PrisonerReport();
			pr.PrisonerReportDetails();
		}
		else if(e.getSource()==miWrdnDispRec)
		{
			WardenReport wr=new WardenReport();
			wr.WardenReportDetails();
		}

		else if(e.getSource() == miLogout)
		{
			frm.dispose();
			new Login().DisplayLogin();
			
		}
			
	}

}
