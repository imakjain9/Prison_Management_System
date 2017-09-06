//package Prisoner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import java.text.*;
//import Validation.*;

/** public class PrisonerUpdate used to update, delete, release the prisoners in Prison_Management_System implements ActionListener Interface*/
public class PrisonerUpdate implements ActionListener
{
	/** variable to create the Frame. */
		private JFrame frm;
	/** variable to create the Panel. */
		private JPanel jp;
	/** JLabel to create the header.*/
		private JLabel lblUpdtPrsnrMod;
	/** JLabel to ask user for Prisoner ID.*/
		private JLabel lblUpdtPrsnrId;
	/** JLabel to ask user for prisoner first name.*/
		private JLabel lblUpdtPrsnrFName; 
	/** JLabel to ask user for prisoner last name.*/
		private JLabel lblUpdtPrsnrLName; 
	/** JLabel to ask user for prisoner crime type.*/
		private JLabel lblUpdtPrsnrCrType;
	/** JLabel to ask user for prisoner entrance date.*/
		private JLabel lblUpdtPrsnrEntDate;
	/** JLabel to ask user for prisoner release date.*/
		private JLabel lblUpdtPrsnrRelDate; 
	/** JLabel to ask user for prisoner security level.*/
		private JLabel lblUpdtPrsnrScLvl; 
	/** JLabel to ask user for prisoner cell sharing status.*/
		private JLabel lblUpdtPrsnrCellShar;
	/** JLabel to ask user for assigned warden to prisoner.*/
		private JLabel lblUpdtPrsnrWdAsgnd; 
	/** JLabel to ask user for prisoner status.*/
		private JLabel lblUpdtPrsnrStatus;

	

	/** JTextField to take prisoner fist name as input. */
		private JTextField tfUpdtPrsnrFName;
	/** JTextField to take prisoner last name as input. */
		private JTextField tfUpdtPrsnrLName;
	/** JTextField to take prisoner status as input. */
		private JTextField tfUpdtPrsnrStatus;


	/** comboBox to take Prisoner ID */
		private JComboBox cmbUpdtPrsnrId;
	/** comboBox to take Prisoner crime type */
		private JComboBox cmbUpdtPrsnrCrType;
	/** comboBox to take the day of prisoner entrance date. */
		private JComboBox cmbUpdtPrsnrEntDDay;
	/** comboBox to take the month of Prisoner entrance date. */
		private JComboBox cmbUpdtPrsnrEntDMon;
	/** comboBox to take the year of prisoner Entrance date. */
		private JComboBox cmbUpdtPrsnrEntDYr;
	/** comboBox to take the day of prisoner release date. */
		private JComboBox cmbUpdtPrsnrRelDDay;
	/** comboBox to take the month of prisoner release date. */
		private JComboBox cmbUpdtPrsnrRelDMon; 
	/** comboBox to take the year of prisoner release date. */
		private JComboBox cmbUpdtPrsnrRelDYr; 
	/** comboBox to take Prisoner seurity level. */
		private JComboBox cmbUpdtPrsnrScLv; 
	/** comboBox to take ID of assigned warden to prisoner. */
		private JComboBox cmbUpdtPrsnrWdAsgnd;

	
	/** JButton to find the Prisoner Record.*/
		private JButton btnPrsnrFind;
	/** JButton to update the fields in Prisoner Record.*/
		private JButton btnPrsnrUpdt;
	/** JButton to release the Prisoner by checking certains conditions.*/
		private JButton btnPrsnrRel;
	/** JButton to delete the Prisoner in case he is dead.*/
		private JButton btnPrsnrDel;
	/** JButton to close the form.*/
		private JButton btnPrsnrCancel;
	/** JButton to clear the fields of the form.*/
		private JButton btnPrsnrClr;
	/** JButton to display the first record.*/
		private JButton btnPrsnrFirst; 
	/** JButton to display the last Record.*/
		private JButton btnPrsnrLast;  

	
	/** JRadioButton to get cell sharing status as yes.*/
		private JRadioButton rbUpdtPrsnrCellSharYes;
	/** JRadioButton to get cell sharing status as No.*/
		private JRadioButton rbUpdtPrsnrCellSharNo;


	/** ButtonGroup variable to add radio buttons. */
		private ButtonGroup bgUpdtCellShar;


	/** String type variable to keep prisoner cell sharing status. */
		private String CellShar;
	/** String type variable to keep Prisoner status. */
		private String PrisonerStatus;

	/** Variable to create new Color object. */
		private Color prlblClr;


	/** Variable of int type for proper validations. */
		private int check=0;
	/** int type Variable to store the day of some specific date. */
		private int SelectedDay;
	/** int type Variable to store the month of some specific date. */
		private int SelectedMonth;
	/** int type Variable to store the year of some specific date. */
		private int SelectedYear;

	/** ResultSet type reference variable to keep the ResultSet value*/
		public ResultSet rs1;


	/**Constructor PrisonUpdate() of zero argument to initialize or construct the new object of PrisonUpdate 
	i.e. it is initializing the values in the variables including JFrame, JPanel, JLabel, JCombobox and JRadioButton etc. */
	public PrisonerUpdate()
	{
		
		frm=new JFrame();
		jp=new JPanel();
		lblUpdtPrsnrMod=new JLabel(new ImageIcon("Images/PrisonerAddHeader.png"));
		lblUpdtPrsnrId=new JLabel("Prisoner ID :");
		lblUpdtPrsnrFName=new JLabel("First Name :");
		lblUpdtPrsnrLName=new JLabel("Last Name :");
		lblUpdtPrsnrCrType=new JLabel("Crime Type");
		lblUpdtPrsnrEntDate=new JLabel("Entrance Date :");
		lblUpdtPrsnrRelDate=new JLabel("Release Date :");
		lblUpdtPrsnrScLvl=new JLabel("Security Level :");
		lblUpdtPrsnrCellShar=new JLabel("Cell Sharing :");
		lblUpdtPrsnrWdAsgnd=new JLabel("Warden Assigned :");
		lblUpdtPrsnrStatus=new JLabel("Prisoner Status :");

		cmbUpdtPrsnrId=new JComboBox();
		tfUpdtPrsnrFName=new JTextField();
		tfUpdtPrsnrLName=new JTextField();
		tfUpdtPrsnrStatus=new JTextField();


		//Day
		Object date[]=new Object[32];
		date[0]="Day";
		int a=1;

		for (int i=01; i<=31 ;++i)
		{
			date[a]=Integer.toString(i);
			a++;

		}
		cmbUpdtPrsnrEntDDay=new JComboBox(date);
		cmbUpdtPrsnrRelDDay=new JComboBox(date);


		//Month
		Object month[]=new Object[13];
		month[0]="Month";
		int b=1;

		for (int i=1; i<=12 ;++i)
		{
			month[b]=Integer.toString(i);
			b++;
		}
		cmbUpdtPrsnrEntDMon=new JComboBox(month);
		cmbUpdtPrsnrRelDMon=new JComboBox(month);



		//Year
		Object year[]=new Object[53];
		year[0]="Year";
		int c=1;

		for (int i=2000; i<=2050 ;i++)
		{
			year[c]=Integer.toString(i);
			c++;
		}
		cmbUpdtPrsnrEntDYr=new JComboBox(year);
		cmbUpdtPrsnrRelDYr=new JComboBox(year);



		//Crime Type
		String CrTyp[]={"Select Crime Type","Murder", "Theft","Robbery", "Kidnapping", "Sexual Crime", "Hacking"};
		cmbUpdtPrsnrCrType=new JComboBox(CrTyp);


		//Security level
		String ScLvl []={"Prisoner Security Level","Low Security","High Security"};
		cmbUpdtPrsnrScLv=new JComboBox(ScLvl);


		//Warden type
		cmbUpdtPrsnrWdAsgnd=new JComboBox();

		//Cell Sharing
		rbUpdtPrsnrCellSharYes=new JRadioButton ("Yes",true);
		rbUpdtPrsnrCellSharNo=new JRadioButton ("No");
		bgUpdtCellShar=new ButtonGroup();


		
		btnPrsnrFind=new JButton("Find",new ImageIcon("Images/findImage.png"));
		btnPrsnrUpdt=new JButton("Update",new ImageIcon("Images/updateImage.png"));
		btnPrsnrRel=new JButton("Release",new ImageIcon("Images/releaseImage.png"));
		btnPrsnrDel=new JButton("Delete",new ImageIcon("Images/deleteImage.gif"));
		btnPrsnrCancel= new JButton("Cancel",new ImageIcon("Images/cancelImage.gif"));
		btnPrsnrClr=new JButton("Clear",new ImageIcon("Images/clearImage.png"));
		btnPrsnrFirst=new JButton("First");
		//btnPrsnrNext=new JButton("Next");
		//btnPrsnrPrev=new JButton("Previous");
		btnPrsnrLast=new JButton("Last");

		prlblClr =new Color(162,194,214,255);


	}



	/**Public Method PrisonerDetailsUpdated() having zero argument and return type is void
	It is used to add the various components on the JFrame using setBounds method.*/
	public void PrisonerDetailsUpdated()
	{
		
		frm.setTitle("Update Prisoner's Details");
		frm.setSize(620,550);
		frm.setLocation(350,80);
		frm.setResizable(false);
		frm.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

		jp.setLayout(null);
		jp.setBackground(Color.black);
		frm.add(jp,BorderLayout.CENTER);


		//Header
		lblUpdtPrsnrMod.setBounds(20,0,600,70);
		jp.add(lblUpdtPrsnrMod);


		//Prisoner's ID
		lblUpdtPrsnrId.setBounds(60,70,160,25);
		lblUpdtPrsnrId.setFont(new Font("Serif", Font.BOLD, 20));
		lblUpdtPrsnrId.setForeground(prlblClr);
		jp.add(lblUpdtPrsnrId);
		
		cmbUpdtPrsnrId.setBounds(240,70,170,25);
		cmbUpdtPrsnrId.addItem("Select Prisoner ID");
		SelectPrisonerID();
		jp.add(cmbUpdtPrsnrId);


		//Label first name
		lblUpdtPrsnrFName.setBounds(60,110,160,25);
		lblUpdtPrsnrFName.setFont(new Font("Serif", Font.BOLD, 20));
		lblUpdtPrsnrFName.setForeground(prlblClr);
		jp.add(lblUpdtPrsnrFName);

		tfUpdtPrsnrFName.setBounds(240,110,170,25);
		jp.add(tfUpdtPrsnrFName);
		tfUpdtPrsnrFName.addKeyListener(new PrValidateKeyPress());


		//last name
		lblUpdtPrsnrLName.setBounds(60,150,160,25);
		lblUpdtPrsnrLName.setFont(new Font("Serif", Font.BOLD, 20));
		lblUpdtPrsnrLName.setForeground(prlblClr);
		jp.add(lblUpdtPrsnrLName);
		
		tfUpdtPrsnrLName.setBounds(240,150,170,25);
		jp.add(tfUpdtPrsnrLName);
		tfUpdtPrsnrLName.addKeyListener(new PrValidateKeyPress());


		//Crime Type
		lblUpdtPrsnrCrType.setBounds(60,190,160,25);
		lblUpdtPrsnrCrType.setFont(new Font("Serif", Font.BOLD, 20));
		lblUpdtPrsnrCrType.setForeground(prlblClr);
		jp.add(lblUpdtPrsnrCrType);

		cmbUpdtPrsnrCrType.setBounds(240,190,170,25);
		jp.add(cmbUpdtPrsnrCrType);


		//Entrance date of prisoner
		lblUpdtPrsnrEntDate.setBounds(60,230,160,25);
		lblUpdtPrsnrEntDate.setFont(new Font("Serif", Font.BOLD, 20));
		lblUpdtPrsnrEntDate.setForeground(prlblClr);
		jp.add(lblUpdtPrsnrEntDate);
		
		cmbUpdtPrsnrEntDDay.setBounds(240,230,50,25);
		jp.add(cmbUpdtPrsnrEntDDay);
		cmbUpdtPrsnrEntDMon.setBounds(290,230,65,25);
		jp.add(cmbUpdtPrsnrEntDMon);
		cmbUpdtPrsnrEntDYr.setBounds(355,230,55,25);
		jp.add(cmbUpdtPrsnrEntDYr);


		//Release Date of prisoner
		lblUpdtPrsnrRelDate.setBounds(60,270,160,25);
		lblUpdtPrsnrRelDate.setFont(new Font("Serif", Font.BOLD, 20));
		lblUpdtPrsnrRelDate.setForeground(prlblClr);
		jp.add(lblUpdtPrsnrRelDate);
		
		cmbUpdtPrsnrRelDDay.setBounds(240,270,50,25);
		jp.add(cmbUpdtPrsnrRelDDay);
		cmbUpdtPrsnrRelDMon.setBounds(290,270,65,25);
		jp.add(cmbUpdtPrsnrRelDMon);
		cmbUpdtPrsnrRelDYr.setBounds(355,270,55,25);
		jp.add(cmbUpdtPrsnrRelDYr);


		//Security Level
		lblUpdtPrsnrScLvl.setBounds(60,310,160,25);
		lblUpdtPrsnrScLvl.setFont(new Font("Serif", Font.BOLD, 20));
		lblUpdtPrsnrScLvl.setForeground(prlblClr);
		jp.add(lblUpdtPrsnrScLvl);
		
		cmbUpdtPrsnrScLv.setBounds(240,310,170,25);
		jp.add(cmbUpdtPrsnrScLv);


		//Cell sharing
		lblUpdtPrsnrCellShar.setBounds(60,350,160,25);
		lblUpdtPrsnrCellShar.setFont(new Font("Serif", Font.BOLD, 20));
		lblUpdtPrsnrCellShar.setForeground(prlblClr);
		jp.add(lblUpdtPrsnrCellShar);

		bgUpdtCellShar.add(rbUpdtPrsnrCellSharYes);
		bgUpdtCellShar.add(rbUpdtPrsnrCellSharNo);

		rbUpdtPrsnrCellSharYes.setBounds(240,350,80,25);
		rbUpdtPrsnrCellSharYes.setForeground(Color.black);
		rbUpdtPrsnrCellSharYes.setBackground(prlblClr);
		rbUpdtPrsnrCellSharYes.addActionListener(this);

		rbUpdtPrsnrCellSharNo.setBounds(330,350,80,25);
		rbUpdtPrsnrCellSharNo.setForeground(Color.black);
		rbUpdtPrsnrCellSharNo.setBackground(prlblClr);
		rbUpdtPrsnrCellSharNo.addActionListener(this);

		jp.add(rbUpdtPrsnrCellSharYes);
		jp.add(rbUpdtPrsnrCellSharNo);


		//warden assigned to prisoner
		lblUpdtPrsnrWdAsgnd.setBounds(60,390,160,25);
		lblUpdtPrsnrWdAsgnd.setFont(new Font("Serif", Font.BOLD, 20));
		lblUpdtPrsnrWdAsgnd.setForeground(prlblClr);
		jp.add(lblUpdtPrsnrWdAsgnd);

		cmbUpdtPrsnrWdAsgnd.setBounds(240,390,170,25);
		cmbUpdtPrsnrWdAsgnd.addItem("Select Warden");
		SelectWarden();
		jp.add(cmbUpdtPrsnrWdAsgnd);


		//status
		lblUpdtPrsnrStatus.setBounds(60,430,160,25);
		lblUpdtPrsnrStatus.setFont(new Font("Serif", Font.BOLD, 20));
		lblUpdtPrsnrStatus.setForeground(prlblClr);
		jp.add(lblUpdtPrsnrStatus);

		tfUpdtPrsnrStatus.setBounds(240,430,170,25);
		tfUpdtPrsnrStatus.setEditable(false);
		jp.add(tfUpdtPrsnrStatus);


		//Find button
		btnPrsnrFind.setBounds(440,70,120,40);
		btnPrsnrFind.setFont(new Font("Serif", Font.BOLD, 20));
		jp.add(btnPrsnrFind);
		btnPrsnrFind.addActionListener(this);

		//Update Button
		btnPrsnrUpdt.setBounds(440,130,120,40);
		btnPrsnrUpdt.setFont(new Font("Serif", Font.BOLD, 20));
		jp.add(btnPrsnrUpdt);
		btnPrsnrUpdt.addActionListener(this);

		//Release Button
		btnPrsnrRel.setBounds(440,190,120,40);
		btnPrsnrRel.setFont(new Font("Serif", Font.BOLD, 20));
		jp.add(btnPrsnrRel);
		btnPrsnrRel.addActionListener(this);

		//Delete Button
		btnPrsnrDel.setBounds(440,250,120,40);
		btnPrsnrDel.setFont(new Font("Serif", Font.BOLD, 20));
		jp.add(btnPrsnrDel);
		btnPrsnrDel.addActionListener(this);
		
		//clear Button
		btnPrsnrClr.setBounds(440,310,120,40);
		btnPrsnrClr.setFont(new Font("Serif", Font.BOLD, 20));
		jp.add(btnPrsnrClr);
		btnPrsnrClr.addActionListener(this);
		
		//Cancel button
		btnPrsnrCancel.setBounds(440,370,120,40);
		btnPrsnrCancel.setFont(new Font("Serif", Font.BOLD, 20));
		jp.add(btnPrsnrCancel);
		btnPrsnrCancel.addActionListener(this);

		//First record button
		btnPrsnrFirst.setBounds(190,470,110,40);
		btnPrsnrFirst.setFont(new Font("Serif", Font.BOLD, 20));
		jp.add(btnPrsnrFirst);
		btnPrsnrFirst.addActionListener(this);

		//last record button
		btnPrsnrLast.setBounds(310,470,110,40);
		btnPrsnrLast.setFont(new Font("Serif", Font.BOLD, 20));
		jp.add(btnPrsnrLast);
		btnPrsnrLast.addActionListener(this);

		Activation(false);
		frm.setVisible(true);



	}


	/**Public Method DateCompare() having zero argument with return type as integer
	It is Comparing two different using compareTo method and return the -1 or +1 or 0 according to dates compared.*/
	public int DateCompare()
	{ 
		SelectedDay=Integer.parseInt((String)cmbUpdtPrsnrEntDDay.getSelectedItem());
		SelectedMonth=Integer.parseInt((String)cmbUpdtPrsnrEntDMon.getSelectedItem());
		SelectedYear=Integer.parseInt((String)cmbUpdtPrsnrEntDYr.getSelectedItem());

		Date EntranceDate = new Date(SelectedYear, SelectedMonth, SelectedDay);

		SelectedDay=Integer.parseInt((String)cmbUpdtPrsnrRelDDay.getSelectedItem());
		SelectedMonth=Integer.parseInt((String)cmbUpdtPrsnrRelDMon.getSelectedItem());
		SelectedYear=Integer.parseInt((String)cmbUpdtPrsnrRelDYr.getSelectedItem());

		Date ReleaseDate = new Date(SelectedYear, SelectedMonth, SelectedDay);
		
		int i=ReleaseDate.compareTo(EntranceDate);
		return i;
	}


	/**Public Method actionPerformed(ActionEvent e) having one argument with return type as void. 
	This method is coming from ActionListener interface.
	It is used to providing the functionality to the System i.e. on click of some specific button some operation will be performed.
	All these details given by this method.
	getSource() method is used here to identify the buttons.*/
	public void actionPerformed(ActionEvent e)
	{
		if(rbUpdtPrsnrCellSharYes.isSelected())
			CellShar="Yes";
		else if(rbUpdtPrsnrCellSharNo.isSelected())
			CellShar="No";


		if( btnPrsnrFind == e.getSource())
		{
			if (cmbUpdtPrsnrId.getSelectedIndex()==0)
				JOptionPane.showMessageDialog(null,"Select prisoner ID");
			else
				FindPrisoner();	
		}	


		if( btnPrsnrUpdt == e.getSource())
		{
			
			if(tfUpdtPrsnrFName.getText().equals(""))
				JOptionPane.showMessageDialog(null,"The FirstName is empty");
			else if (tfUpdtPrsnrLName.getText().equals(""))
				JOptionPane.showMessageDialog(null,"The LastName is empty");
			else if (cmbUpdtPrsnrCrType.getSelectedIndex()==0 )
				JOptionPane.showMessageDialog(null,"Please Enter a valid Crime");
			else if (cmbUpdtPrsnrEntDDay.getSelectedIndex()==0 || cmbUpdtPrsnrEntDMon.getSelectedIndex()==0 || cmbUpdtPrsnrEntDYr.getSelectedIndex()==0)
				JOptionPane.showMessageDialog(null,"Please Enter a valid Entrance date");
			else if (cmbUpdtPrsnrRelDDay.getSelectedIndex()==0 || cmbUpdtPrsnrRelDMon.getSelectedIndex()==0 || cmbUpdtPrsnrRelDYr.getSelectedIndex()==0)
				JOptionPane.showMessageDialog(null,"Please Enter a valid Release date");
			else if (cmbUpdtPrsnrScLv.getSelectedIndex()==0 )
				JOptionPane.showMessageDialog(null,"Please enter the Security Level again");
			else
			{
				SelectedDay=Integer.parseInt((String)cmbUpdtPrsnrEntDDay.getSelectedItem());
				SelectedMonth=Integer.parseInt((String)cmbUpdtPrsnrEntDMon.getSelectedItem());
				SelectedYear=Integer.parseInt((String)cmbUpdtPrsnrEntDYr.getSelectedItem());
				
				ValidatePrison p1=new ValidatePrison();
				check = p1.DateCheck(SelectedDay, SelectedMonth, SelectedYear);

				if(check==1)
				{
					SelectedDay=Integer.parseInt((String)cmbUpdtPrsnrRelDDay.getSelectedItem());
					SelectedMonth=Integer.parseInt((String)cmbUpdtPrsnrRelDMon.getSelectedItem());
					SelectedYear=Integer.parseInt((String)cmbUpdtPrsnrRelDYr.getSelectedItem());
					
					ValidatePrison p2= new ValidatePrison();
					check= p2.DateCheck(SelectedDay, SelectedMonth, SelectedYear);
				}

				if(check==1)
				{
					if(DateCompare()>=0)
						check=1;
					else
					{
						check=0;
						JOptionPane.showMessageDialog(null,"Entrance date is greater than release date");
					}
				}

				if(check==1)
				{
					if(cmbUpdtPrsnrScLv.getSelectedItem().equals("High Security") && (rbUpdtPrsnrCellSharYes.isSelected()))
					{
						JOptionPane.showMessageDialog(null,"High security prisoner cannot share cell");
						check=0;
					}
					else
						check=1;
				}

				if(check==1)
				{
					if (cmbUpdtPrsnrWdAsgnd.getSelectedIndex()==0 )
					{
						JOptionPane.showMessageDialog(null,"Please Assign the warden carefully");
						check=0;
					}
					else
						check=1;
				}

				if(check==1)
				{
					CheckPrison p = new CheckPrison();
					if(p.TestPrison()==1)
						UpdatePrisoner();
				}
				check=0;
			}
		}


	
		else if(btnPrsnrClr == e.getSource())
		{
			cmbUpdtPrsnrId.setSelectedIndex(0);
			cmbUpdtPrsnrId.setEnabled(true);
			tfUpdtPrsnrFName.setText("");
			tfUpdtPrsnrLName.setText("");
			tfUpdtPrsnrStatus.setText("");
			cmbUpdtPrsnrCrType.setSelectedIndex(0);
			cmbUpdtPrsnrEntDDay.setSelectedIndex(0);
			cmbUpdtPrsnrEntDMon.setSelectedIndex(0);
			cmbUpdtPrsnrEntDYr.setSelectedIndex(0);
			cmbUpdtPrsnrRelDDay.setSelectedIndex(0);
			cmbUpdtPrsnrRelDMon.setSelectedIndex(0);
			cmbUpdtPrsnrRelDYr.setSelectedIndex(0);
			cmbUpdtPrsnrScLv.setSelectedIndex(0);
			cmbUpdtPrsnrWdAsgnd.setSelectedIndex(0);
			rbUpdtPrsnrCellSharYes.setSelected(true);
			Activation(false);	
		}



		else if (btnPrsnrRel == e.getSource())
		{
			try
			{
				SimpleDateFormat dateformat=new SimpleDateFormat("dd/MM/yyyy");
				String actReleaseDt= ReleasePrisoner();

				Date actualReleaseDate = dateformat.parse(actReleaseDt);
				Date currentDate=new Date();
				
				long MilliSec =actualReleaseDate.getTime()-currentDate.getTime();
				long  days=MilliSec/(24*60*60*1000);

				if(days<=7)
				{
					PrisonerStatus = "Released";
					setPrisonerStatus();
					JOptionPane.showMessageDialog(null,"Prisoner is Released");
				}
				else
					JOptionPane.showMessageDialog(null,"Prisoner cannot released, No. of days left: "+days);
			}
			catch(Exception ke)
			{
				System.out.println("Parse exception caught");
			}
		}



		else if(btnPrsnrDel == e.getSource())
		{
			PrisonerStatus = "Dead";
			setPrisonerStatus();
			JOptionPane.showMessageDialog(null,"Prisoner is Deleted");
			
		}


		else if(btnPrsnrCancel == e.getSource())
		{
			frm.dispose();
		}



		else if( btnPrsnrFirst == e.getSource())
		{
			connect();
			try
			{
				if(rs1.isFirst())
				{
					rs1.beforeFirst();
					JOptionPane.showMessageDialog(null, "First Record");
				}

				if(rs1.first())
				{
					Activation(true);
					DisplayRecord(rs1);
					
				}
			}
			catch(SQLException e1)
			{
				System.out.println(e1);
			}
		}



		else if( btnPrsnrLast == e.getSource())
		{
			connect();
			try
			{
				if(rs1.isLast())
				{
					rs1.afterLast();
					JOptionPane.showMessageDialog(null, "Last Record");
				}

				if(rs1.last())
				{
					Activation(true);
					DisplayRecord(rs1);	
				}
			}
			catch(SQLException e1)
			{
				System.out.println(e1);
			}		
		}
	}


	/** public method connect() with zero argument and return type is void.
	It is executing some database commands to load the drivers and and connecting with database.*/
	public void connect()
	{
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection connect = DriverManager.getConnection("jdbc:odbc:PrisonDetails");
		    System.out.println("Connection established successfully");
            Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "select * from PrisonerDetails";
            rs1= state.executeQuery(sql);		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
	}


	/** public method Activation(boolean b) having a boolean type arguement with return type as void.
	This method is mainly setting the different components as enabled/disabled.*/
	public void Activation(boolean b)
	{
			tfUpdtPrsnrFName.setEnabled(b);
			tfUpdtPrsnrLName.setEnabled(b);

			cmbUpdtPrsnrCrType.setEnabled(b);
			cmbUpdtPrsnrEntDDay.setEnabled(b);
			cmbUpdtPrsnrEntDMon.setEnabled(b);
			cmbUpdtPrsnrEntDYr.setEnabled(b);
			cmbUpdtPrsnrRelDDay.setEnabled(b);
			cmbUpdtPrsnrRelDMon.setEnabled(b);
			cmbUpdtPrsnrRelDYr.setEnabled(b);
			cmbUpdtPrsnrScLv.setEnabled(b);
			cmbUpdtPrsnrWdAsgnd.setEnabled(b);
			rbUpdtPrsnrCellSharYes.setEnabled(b);
			rbUpdtPrsnrCellSharNo.setEnabled(b);

			btnPrsnrUpdt.setEnabled(b);
			btnPrsnrRel.setEnabled(b);
			btnPrsnrDel.setEnabled(b);
			btnPrsnrClr.setEnabled(b);

	}
	


	/** public method DisplayRecord(ResultSet rst) having a ResultSet type argument with return type as void.
	This method is fetching the prisoner's record of required ID from database displaying it in the respective fields.*/
	public void DisplayRecord(ResultSet rst) throws SQLException
	{
		cmbUpdtPrsnrId.setSelectedItem(String.valueOf(rst.getInt("Prsnr_ID")));
		cmbUpdtPrsnrId.setEnabled(false);
        tfUpdtPrsnrFName.setText(rst.getString("First_Name"));
		tfUpdtPrsnrLName.setText(rst.getString("Last_Name"));
		cmbUpdtPrsnrCrType.setSelectedItem(rst.getString("Crime_Type"));

		tfUpdtPrsnrStatus.setText(rst.getString("Prsnr_Status"));
			
			
		String EntDate=rst.getString("Ent_Date");
		String EntDate1=EntDate+"/";
		String EntDate2[]=new String[3];
		int p=0,t=0,j=0;
		for(int i=0;i<EntDate1.length();i++){
			if(EntDate1.charAt(i)=='/'){
				EntDate2[j]=EntDate1.substring(t,i);
				p=i;
				t=p+1;
				j++;
			}
		}
		cmbUpdtPrsnrEntDDay.setSelectedItem(EntDate2[0]);
		cmbUpdtPrsnrEntDMon.setSelectedItem(EntDate2[1]);
		cmbUpdtPrsnrEntDYr.setSelectedItem(EntDate2[2]);

		String RelDate=rst.getString("Rel_Date");
		String RelDate1=RelDate+"/";
		String RelDate2[]=new String[3];
		p=0;t=0;j=0;
		for(int i=0;i<RelDate1.length();i++){
			if(RelDate1.charAt(i)=='/'){
				RelDate2[j]=RelDate1.substring(t,i);
				p=i;
				t=p+1;
				j++;
			}
		}

		cmbUpdtPrsnrRelDDay.setSelectedItem(RelDate2[0]);
		cmbUpdtPrsnrRelDMon.setSelectedItem(RelDate2[1]);
		cmbUpdtPrsnrRelDYr.setSelectedItem(RelDate2[2]);

		cmbUpdtPrsnrScLv.setSelectedItem(rst.getString("Sec_Lvl"));

		String CellShar=rst.getString("Cell_Sharing");
		if(CellShar.equals("Yes"))
			rbUpdtPrsnrCellSharYes.setSelected(true);
		else
			rbUpdtPrsnrCellSharNo.setSelected(true);

		cmbUpdtPrsnrWdAsgnd.setSelectedItem(rst.getString("Wrdn_Assnd"));
		JOptionPane.showMessageDialog(null, "Record Found Successfully");
	}




	/** public (Inner) class PrValidateKeyPress extends KeyAdapter and overriding the method keyPressed.
	This class is used to apply validations on the text fields*/
	public class PrValidateKeyPress extends KeyAdapter
	{
		char ch;
		/** public method keyPressed(KeyEvent ke) inherited from keyAdapter class having a KeyEvent type arguement with return type as void.
		This method is applying certain validations on textfields.*/
		public void keyPressed(KeyEvent ke)
		{
			if(ke.getSource() == tfUpdtPrsnrFName)
			{
				ch=ke.getKeyChar();
				if((ch>=97 && ch<=122) || ch==8 || ch==32){}
				else 
				{
					JOptionPane.showMessageDialog(null,"Enter the Alphabets only");
					tfUpdtPrsnrFName.setText("");	
				}
			}
			else if(ke.getSource() == tfUpdtPrsnrLName)
			{
				ch=ke.getKeyChar();
				if((ch>=97 && ch<=122) || ch==8 || ch==32){}
				else 
				{
					JOptionPane.showMessageDialog(null,"Enter the Alphabets only");
					tfUpdtPrsnrLName.setText("");	
				}
			}
		}
	}



	/** public method FindPrisoner() with no argument type and return type as void.
	This method is used to find the prisoner in database by its ID and then retrieve the details from database to the respective fields.*/
	public void FindPrisoner()
	{
		try{
			int Prsnrid=Integer.parseInt((String)cmbUpdtPrsnrId.getSelectedItem());

            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		    System.out.println("Divers loaded successfully");
            Connection connect = DriverManager.getConnection("jdbc:odbc:PrisonDetails");
            Statement state = connect.createStatement();
            String sql = "select * from PrisonerDetails where Prsnr_ID="+ Prsnrid +"";
            ResultSet rs=state.executeQuery(sql);

		    if(rs.next())
			{
				Activation(true);
				DisplayRecord(rs);
				
			}
			else
				JOptionPane.showMessageDialog(null,"Record Not found");

		   rs.close();
           state.close();
           connect.close();
		}
        catch (Exception e){
           System.out.print(e);
        }
	}


	/** public method UpdatePrisoner() with no argument type and return type as void.
	This method is used to update the prisoner details in database.*/
	public void UpdatePrisoner()
	{
		try{
			int Prsnrid=Integer.parseInt((String)cmbUpdtPrsnrId.getSelectedItem());
			String PrsnrFNm=tfUpdtPrsnrFName.getText();
			String PrsnrLNm=tfUpdtPrsnrLName.getText();
			String PrsnrCrTp=(String)cmbUpdtPrsnrCrType.getSelectedItem();
			String PrsnrScLvl=(String)cmbUpdtPrsnrScLv.getSelectedItem();
			String WrdnAssnd=(String)cmbUpdtPrsnrWdAsgnd.getSelectedItem();

			String EntDtDay=(String)cmbUpdtPrsnrEntDDay.getSelectedItem();
			String EntDtMonth=(String)cmbUpdtPrsnrEntDMon.getSelectedItem();
			String EntDtyear=(String)cmbUpdtPrsnrEntDYr.getSelectedItem();
			String EntDate=EntDtDay+"/"+EntDtMonth+"/"+EntDtyear;

			String RelDtDay=(String)cmbUpdtPrsnrRelDDay.getSelectedItem();
			String RelDtMonth=(String)cmbUpdtPrsnrRelDMon.getSelectedItem();
			String RelDtyear=(String)cmbUpdtPrsnrRelDYr.getSelectedItem();
			String RelDate=RelDtDay+"/"+RelDtMonth+"/"+RelDtyear;
	
				
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Divers loaded successfully");
			Connection connect = DriverManager.getConnection("jdbc:odbc:PrisonDetails");
			System.out.println("Connection established successfully");
			Statement state = connect.createStatement();
				                               
			String sql = "UPDATE PrisonerDetails set First_Name= '"+PrsnrFNm+"', Last_Name= '"+PrsnrLNm+"', Crime_Type= '"+PrsnrCrTp+"', Ent_Date= '"+EntDate+"', Rel_Date= '"+RelDate+"', Sec_Lvl= '"+PrsnrScLvl+"', Cell_Sharing= '"+CellShar+"', Wrdn_Assnd= '"+WrdnAssnd+"' WHERE Prsnr_ID= "+Prsnrid+"";    
			state.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Record Updated Successfully");
			System.out.println("Statement executed successfully");
			state.close();
			connect.close();
		}
		catch (Exception e) {
			System.out.print(e);
		}
	}


	/** public method SelectWarden() with no argument type and return type as void.
	This method is used to select and display the available warden to be assigned in the combo box.*/
	public void SelectWarden()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection connect = DriverManager.getConnection("jdbc:odbc:PrisonDetails");
			Statement state = connect.createStatement();
			String sql = "SELECT * FROM WardenDetails ";
			ResultSet rs=state.executeQuery(sql);
			while(rs.next())
				if((rs.getString("Wrdn_Status")).equals("On Service"))
					cmbUpdtPrsnrWdAsgnd.addItem(rs.getString("Wrdn_ID"));
	
			System.out.println("Statement executed successfully");
			rs.close();
			state.close();
			connect.close();
		}
		catch (Exception e) 
		{
           System.out.print(e);
        }
	}


	/** public method ReleasePrisoner() with no argument type and return type as String.
	This method is used to get the release date available in database and ultimately deciding that whether the prisoner can be released or not.*/
	String ReleasePrisoner()
	{
		String RelDate="00/00/0000";
		try{
			int Prsnrid=Integer.parseInt((String)cmbUpdtPrsnrId.getSelectedItem());
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Divers loaded successfully");
			Connection connect = DriverManager.getConnection("jdbc:odbc:PrisonDetails");
			Statement state = connect.createStatement();
			String sql = "SELECT Rel_Date FROM PrisonerDetails where Prsnr_ID="+ Prsnrid +"";
			ResultSet rs=state.executeQuery(sql);
			if(rs.next())
				RelDate = rs.getString("Rel_Date");
			
			rs.close();
			state.close();
			connect.close(); 
		}
		catch (Exception e) {
           System.out.print(e);
        }
		return RelDate;
	}
	


	/** public method setPrisonerStatus() with no argument type and return type as void.
	This method is used to update the prisoner's status in database.*/
	public void setPrisonerStatus()
	{
		try{
			int Prsnrid=Integer.parseInt((String)cmbUpdtPrsnrId.getSelectedItem());
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection connect = DriverManager.getConnection("jdbc:odbc:PrisonDetails");
			Statement state = connect.createStatement();
			String sql="UPDATE PrisonerDetails set Prsnr_Status= '"+PrisonerStatus+"' WHERE Prsnr_ID= "+Prsnrid+"";
			state.execute(sql);
			state.close();
			connect.close();
		}
		catch (Exception e1) {
			System.out.println(e1);
		}

		tfUpdtPrsnrStatus.setText(PrisonerStatus);
		
	}


	/** public method SelectPrisonerID() with no arguement type and return type as void.
	This method is used to select and dispaly the available Prisoner ID present in database from which user can select one from in the combobox and find it .*/
	void SelectPrisonerID()
	{
		try
		{
			int i=0;
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection connect = DriverManager.getConnection("jdbc:odbc:PrisonDetails");
			Statement state = connect.createStatement();
			String sql = "SELECT Prsnr_ID FROM PrisonerDetails";
			ResultSet rs=state.executeQuery(sql);
			while(rs.next())
			{
					cmbUpdtPrsnrId.addItem(rs.getString("Prsnr_ID"));
			}
		   rs.close();
           state.close();
           connect.close();
		}
		catch (Exception e) 
		{
           System.out.print(e);
        }
     }
}

