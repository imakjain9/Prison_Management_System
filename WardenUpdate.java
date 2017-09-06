//package Warden;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
//import Validation.*;

/** public class WardenUpdate used to update, delete, release the prisoners in Prison_Management_System implements ActionListener Interface*/
public class WardenUpdate implements ActionListener
{
	
	/** variable to create the Frame. */
		private JFrame frm;
	/** variable to create the Panel to add the components. */
		private JPanel jp;
	/** JLabel to create the header.*/
		private JLabel lblUpdtWrdnMod;
	/** JLabel to ask user for warden ID.*/
		private JLabel lblUpdtWrdnId;
	/** JLabel to ask user for warden first name.*/
		private JLabel lblUpdtWrdnFName;
	/** JLabel to ask user for warden last name.*/
		private JLabel lblUpdtWrdnLName;
	/** JLabel to ask user for warden contact.*/
		private JLabel lblUpdtWrdnCntct;
	/** JLabel to ask user for prisoner gender.*/
		private JLabel lblUpdtWrdnGndr;
	/** JLabel to ask user for prisoner date of birth.*/
		private JLabel lblUpdtWrdnDob;
	/** JLabel to ask user for prisoner rank.*/
		private JLabel lblUpdtWrdnRank;
	/** JLabel to ask user for prisoner joining date.*/
		private JLabel lblUpdtWrdnJnDt;
	/** JLabel to ask user for prisoner status.*/
		private JLabel lblUpdtWrdnStatus;
		
	

	/** JTextField to take warden first name as input. */
		private JTextField tfUpdtWrdnFName;
	/** JTextField to take warden last name as input. */
		private JTextField tfUpdtWrdnLName;
	/** JTextField to take warden last name as input. */
		private JTextField tfUpdtWrdnContact;
	/** JTextField to take warden contact as input. */
		private JTextField tfUpdtWrdnStatus;
		
		
	/** comboBox to take warden ID */
		private JComboBox cmbUpdtWrdnId;
	/** comboBox to take the day of Prisoner date of birth */
		private JComboBox cmbUpdtWrdnDobDay;
	/** comboBox to take the month of Prisoner date of birth */
		private JComboBox cmbUpdtWrdnDobMon;
	/** comboBox to take the year of Prisoner date of birth */
		private JComboBox cmbUpdtWrdnDobYr;
	/** comboBox to take warden rank as input */
		private JComboBox cmbUpdtWrdnRank;
	/** comboBox to take the day of Prisoner joining date */
		private JComboBox cmbUpdtWrdnJnDtDay;
	/** comboBox to take the month of Prisoner joining date */
		private JComboBox cmbUpdtWrdnJnDtMon;
	/** comboBox to take the year of Prisoner joining date */
		private JComboBox cmbUpdtWrdnJnDtYr;
		
		
	
	/** JRadioButton to set warden gender as male.*/
		private JRadioButton rbUpdtWrdnGndrMale;
	/** JRadioButton to set warden gender as female.*/
		private JRadioButton rbUpdtWrdnGndrFemale;
		
		
	/** JButton to find the warden Record.*/
		private JButton btnWrdnFind;
	/** JButton to update the fields in warden Record.*/
		private JButton btnWrdnUpdt;
	/** JButton to delete the warden in case he is dead/left.*/
		private JButton btnWrdnDel;
	/** JButton to close the form.*/
		private JButton btnWrdnCancel;
	/** JButton to clear the fields of the form.*/
		private JButton btnWrdnClr;
	/** JButton to display the first record.*/
		private JButton btnWrdnFirst; 
	/** JButton to display the last Record.*/
		private JButton btnWrdnLast;  
		
		
	/** ButtonGroup variable to add radio buttons to select gender. */
		private ButtonGroup bgUpdtGndr; 
	/** Variable to create new Color object. */
		private Color wdClr;
		
	
	/** String type variable to keep warden gender. */
		private String Gender;
	/** String type variable to keep warden status. */
		private String WardenStatus;
	/** Variable of int type for proper validations. */
		private int check=0;
	/** int type Variable to store the day of some specific date. */
		private int SelectedDay; 
	/** int type Variable to store the month of some specific date. */
		private int SelectedMonth;
	/** int type Variable to store the year of some specific date. */
		private int SelectedYear;

	/** ResultSet type reference variable to keep the ResultSet value*/
		public ResultSet rs1;;

	
	
	/**Constructor WardenUpdate() of zero argument to initialize or construct the new object of WardenUpdate 
	i.e. it is initializing the values in the variables including JFrame, JPanel, JLabel, JCombobox and JRadioButton etc. */
	public WardenUpdate()
	{
		frm=new JFrame();
		jp=new JPanel();
		lblUpdtWrdnMod=new JLabel(new ImageIcon("Images/WardenAddHeader.png"));
		lblUpdtWrdnFName=new JLabel("First Name :");
		lblUpdtWrdnLName=new JLabel("Last Name :");
		lblUpdtWrdnId=new JLabel("Warden's ID :");
		lblUpdtWrdnDob=new JLabel("Date Of Birth :");
		lblUpdtWrdnGndr=new JLabel("Gender :");
		lblUpdtWrdnCntct=new JLabel("Contact No. :");
		lblUpdtWrdnRank=new JLabel("Warden's Rank :");
		lblUpdtWrdnJnDt=new JLabel("Joining Date :");
		lblUpdtWrdnStatus=new JLabel("Status :");

		tfUpdtWrdnFName=new JTextField();
		tfUpdtWrdnLName=new JTextField();
		tfUpdtWrdnContact=new JTextField();
		tfUpdtWrdnStatus=new JTextField();

		cmbUpdtWrdnId=new JComboBox();

		//Day
		Object date[]=new Object[32];
		date[0]="Day";
		int a=1;
		for (int i=01; i<=31 ;++i)
		{
			date[a]=Integer.toString(i);
			a++;
		}
		cmbUpdtWrdnDobDay=new JComboBox(date);
		cmbUpdtWrdnJnDtDay=new JComboBox(date);


		//Month
		Object month[]=new Object[13];
		month[0]="Month";
		int b=1;
		for (int i=1; i<=12 ;++i)
		{
			month[b]=Integer.toString(i);
			b++;
		}
		cmbUpdtWrdnDobMon=new JComboBox(month);
		cmbUpdtWrdnJnDtMon=new JComboBox(month);


		//Year
		Object year[]=new Object[72];
		year[0]="Year";
		int c=1;
		for (int i=2000; i<=2050 ;i++)
		{
			year[c]=Integer.toString(i);
			c++;
		}

		cmbUpdtWrdnDobYr=new JComboBox(year);
		cmbUpdtWrdnJnDtYr=new JComboBox(year);

		String WdRnk[]={"Select Warden Rank","1","2","3","4","5"};
		cmbUpdtWrdnRank=new JComboBox(WdRnk);


		rbUpdtWrdnGndrMale=new JRadioButton("Male",true);
		rbUpdtWrdnGndrFemale=new JRadioButton("Female");
		bgUpdtGndr=new ButtonGroup();


		btnWrdnFind=new JButton("Find",new ImageIcon("Images/findImage.png"));
		btnWrdnUpdt=new JButton("Update",new ImageIcon("Images/updateImage.png"));
		btnWrdnDel=new JButton("Delete",new ImageIcon("Images/deleteImage.gif"));
		btnWrdnClr=new JButton("Clear",new ImageIcon("Images/clearImage.png"));
		btnWrdnCancel= new JButton("Cancel",new ImageIcon("Images/cancelImage.gif"));
		

		btnWrdnFirst=new JButton("First");
		//btnWrdnNext=new JButton("Next");
		//btnWrdnPrev=new JButton("Previous");
		btnWrdnLast=new JButton("Last");


		wdClr=new Color(162,194,214,255);
	}


	
	/**Public Method WardenDetailsUpdated() having zero argument and return type is void
	It is used to add the various fields of warden on the JFrame using layouts and setBounds method.*/
	public void WardenDetailsUpdated()
	{
		frm.setTitle("Warden's Module");
		//frm.setLayout(null);
		frm.setSize(620,530);
		frm.setLocation(350,100);
		frm.setResizable(false);
		frm.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		
		jp.setLayout(null);
		jp.setBackground(Color.black);
		frm.add(jp,BorderLayout.CENTER);

		//Header
		lblUpdtWrdnMod.setBounds(20,10,600,80);
		jp.add(lblUpdtWrdnMod);
		
	
		//Warden's ID
		lblUpdtWrdnId.setBounds(60,90,160,25);
		lblUpdtWrdnId.setFont(new Font("Serif", Font.BOLD, 20));
		lblUpdtWrdnId.setForeground(wdClr);
		jp.add(lblUpdtWrdnId);

		cmbUpdtWrdnId.setBounds(240,90,170,25);
		cmbUpdtWrdnId.addItem("Select Warden ID");
		SelectWardenID();
		jp.add(cmbUpdtWrdnId);
		
		
		
		//first name
		lblUpdtWrdnFName.setBounds(60,130,160,25);
		lblUpdtWrdnFName.setFont(new Font("Serif", Font.BOLD, 20));
		lblUpdtWrdnFName.setForeground(wdClr);
		jp.add(lblUpdtWrdnFName);

		tfUpdtWrdnFName.setBounds(240,130,170,25);
		jp.add(tfUpdtWrdnFName);
		tfUpdtWrdnFName.addKeyListener(new WdValidateKeyPress());


		//last name
		lblUpdtWrdnLName.setBounds(60,170,160,25);
		lblUpdtWrdnLName.setFont(new Font("Serif", Font.BOLD, 20));
		lblUpdtWrdnLName.setForeground(wdClr);
		jp.add(lblUpdtWrdnLName);

		tfUpdtWrdnLName.setBounds(240,170,170,25);
		jp.add(tfUpdtWrdnLName);
		tfUpdtWrdnLName.addKeyListener(new WdValidateKeyPress());


		//warden contact
		lblUpdtWrdnCntct.setBounds(60,210,160,25);
		lblUpdtWrdnCntct.setFont(new Font("Serif", Font.BOLD, 20));
		lblUpdtWrdnCntct.setForeground(wdClr);
		jp.add(lblUpdtWrdnCntct);

		tfUpdtWrdnContact.setBounds(240,210,170,25);
		jp.add(tfUpdtWrdnContact);


		//warden gender
		lblUpdtWrdnGndr.setBounds(60,250,160,25);
		lblUpdtWrdnGndr.setFont(new Font("Serif", Font.BOLD, 20));
		lblUpdtWrdnGndr.setForeground(wdClr);
		jp.add(lblUpdtWrdnGndr);

		bgUpdtGndr.add(rbUpdtWrdnGndrMale);    
		bgUpdtGndr.add(rbUpdtWrdnGndrFemale);

		rbUpdtWrdnGndrMale.setBounds(240,250,80,25);
		rbUpdtWrdnGndrMale.setForeground(Color.black);
		rbUpdtWrdnGndrMale.setBackground(wdClr);

		rbUpdtWrdnGndrFemale.setBounds(330,250,80,25);
		rbUpdtWrdnGndrFemale.setForeground(Color.black);
		rbUpdtWrdnGndrFemale.setBackground(wdClr);
		
		jp.add(rbUpdtWrdnGndrMale);
		jp.add(rbUpdtWrdnGndrFemale);


		
		//Date of birth
		lblUpdtWrdnDob.setBounds(60,290,160,25);
		lblUpdtWrdnDob.setFont(new Font("Serif", Font.BOLD, 20));
		lblUpdtWrdnDob.setForeground(wdClr);
		jp.add(lblUpdtWrdnDob);

		cmbUpdtWrdnDobDay.setBounds(240,290,50,25);
		jp.add(cmbUpdtWrdnDobDay);
		cmbUpdtWrdnDobMon.setBounds(290,290,65,25);
		jp.add(cmbUpdtWrdnDobMon);
		cmbUpdtWrdnDobYr.setBounds(355,290,55,25);
		jp.add(cmbUpdtWrdnDobYr);


		
		//warden rank
		lblUpdtWrdnRank.setBounds(60,330,160,25);
		lblUpdtWrdnRank.setFont(new Font("Serif", Font.BOLD, 20));
		lblUpdtWrdnRank.setForeground(wdClr);
		jp.add(lblUpdtWrdnRank);

		cmbUpdtWrdnRank.setBounds(240,330,170,25);
		jp.add(cmbUpdtWrdnRank);


		//Warden Joining Date
		lblUpdtWrdnJnDt.setBounds(60,370,140,25);
		lblUpdtWrdnJnDt.setFont(new Font("Serif", Font.BOLD, 20));
		lblUpdtWrdnJnDt.setForeground(wdClr);
		jp.add(lblUpdtWrdnJnDt);

		cmbUpdtWrdnJnDtDay.setBounds(240,370,50,25);
		jp.add(cmbUpdtWrdnJnDtDay);
		cmbUpdtWrdnJnDtMon.setBounds(290,370,65,25);
		jp.add(cmbUpdtWrdnJnDtMon);
		cmbUpdtWrdnJnDtYr.setBounds(355,370,55,25);
		jp.add(cmbUpdtWrdnJnDtYr);


		//status
		lblUpdtWrdnStatus.setBounds(60,410,160,25);
		lblUpdtWrdnStatus.setFont(new Font("Serif", Font.BOLD, 20));
		lblUpdtWrdnStatus.setForeground(wdClr);
		jp.add(lblUpdtWrdnStatus);

		tfUpdtWrdnStatus.setBounds(240,410,170,25);
		tfUpdtWrdnStatus.setEditable(false);
		jp.add(tfUpdtWrdnStatus);


		//Find button
		btnWrdnFind.setBounds(440,90,120,40);
		btnWrdnFind.setFont(new Font("Serif", Font.BOLD, 20));
		jp.add(btnWrdnFind);
		btnWrdnFind.addActionListener(this);


		//Update Button
		btnWrdnUpdt.setBounds(440,150,120,40);
		btnWrdnUpdt.setFont(new Font("Serif", Font.BOLD, 20));
		jp.add(btnWrdnUpdt);
		btnWrdnUpdt.addActionListener(this);

		

		//Delete Button
		btnWrdnDel.setBounds(440,210,120,40);
		btnWrdnDel.setFont(new Font("Serif", Font.BOLD, 20));
		jp.add(btnWrdnDel);
		btnWrdnDel.addActionListener(this);

		//clear Button
		btnWrdnClr.setBounds(440,270,120,40);
		btnWrdnClr.setFont(new Font("Serif", Font.BOLD, 20));
		jp.add(btnWrdnClr);
		btnWrdnClr.addActionListener(this);
		
		//Cancel button
		btnWrdnCancel.setBounds(440,330,120,40);
		btnWrdnCancel.setFont(new Font("Serif", Font.BOLD, 20));
		jp.add(btnWrdnCancel);
		btnWrdnCancel.addActionListener(this);

		
		//First record button
		btnWrdnFirst.setBounds(190,450,110,40);
		btnWrdnFirst.setFont(new Font("Serif", Font.BOLD, 20));
		jp.add(btnWrdnFirst);
		btnWrdnFirst.addActionListener(this);


		//last record button
		btnWrdnLast.setBounds(310,450,110,40);
		btnWrdnLast.setFont(new Font("Serif", Font.BOLD, 20));
		jp.add(btnWrdnLast);
		btnWrdnLast.addActionListener(this);

		Activation(false);
		frm.setVisible(true);

	}



	/**Public Method DateCompare() having zero argument with return type as integer
	It is Comparing two different using compareTo method and return the -1 or +1 or 0 according to dates compared.*/
	public int DateCompare()
	{
		SelectedDay=Integer.parseInt((String)cmbUpdtWrdnDobDay.getSelectedItem());
		SelectedMonth=Integer.parseInt((String)cmbUpdtWrdnDobMon.getSelectedItem());
		SelectedYear=Integer.parseInt((String)cmbUpdtWrdnDobYr.getSelectedItem());

		Date Dt_Of_Birth = new Date(SelectedYear, SelectedMonth, SelectedDay);

		SelectedDay=Integer.parseInt((String)cmbUpdtWrdnJnDtDay.getSelectedItem());
		SelectedMonth=Integer.parseInt((String)cmbUpdtWrdnJnDtMon.getSelectedItem());
		SelectedYear=Integer.parseInt((String)cmbUpdtWrdnJnDtYr.getSelectedItem());

		Date JoinDate = new Date(SelectedYear, SelectedMonth, SelectedDay);

		int i=JoinDate.compareTo(Dt_Of_Birth);
		return i;
	}



	
	/**Public Method actionPerformed(ActionEvent e) having one argument with return type as void. 
	This method is coming from ActionListener interface.
	It is used to providing the functionality to the System i.e. on click of some specific button some operation will be performed.
	All these details given by this method.
	getSource() method is used here to identify the buttons.*/
	
	public void actionPerformed(ActionEvent e)
	{
		if(rbUpdtWrdnGndrMale.isSelected())
			Gender="Male";
		else if(rbUpdtWrdnGndrFemale.isSelected())
			Gender="Female";


		if( btnWrdnFind == e.getSource())
		{
			if (cmbUpdtWrdnId.getSelectedIndex()==0)
				JOptionPane.showMessageDialog(null,"Select warden ID");
			else
			{ 
				Activation(true);
				FindWarden();	
			}
		 }	



		if( btnWrdnUpdt == e.getSource())
		{
			if(tfUpdtWrdnFName.getText().equals(""))
				JOptionPane.showMessageDialog(null,"The FirstName is empty");
			else if (tfUpdtWrdnLName.getText().equals(""))
				JOptionPane.showMessageDialog(null,"The LastName is empty");
			else if (tfUpdtWrdnContact.getText().equals(""))
				JOptionPane.showMessageDialog(null,"The Contact No. is empty");
			else if(tfUpdtWrdnContact.getText().length()!=10)
				JOptionPane.showMessageDialog(null,"Please Enter a valid Contact number of 10 digits");
			else if (cmbUpdtWrdnDobDay.getSelectedIndex()==0 || cmbUpdtWrdnDobMon.getSelectedIndex()==0 || cmbUpdtWrdnDobYr.getSelectedIndex()==0)
				JOptionPane.showMessageDialog(null,"Please Enter a valid Date of birth");
			else if (cmbUpdtWrdnJnDtDay.getSelectedIndex()==0 || cmbUpdtWrdnJnDtMon.getSelectedIndex()==0 || cmbUpdtWrdnJnDtYr.getSelectedIndex()==0)
				JOptionPane.showMessageDialog(null,"Please Enter a valid Joining date");
			else
			{
				SelectedDay=Integer.parseInt((String)cmbUpdtWrdnDobDay.getSelectedItem());
				SelectedMonth=Integer.parseInt((String)cmbUpdtWrdnDobMon.getSelectedItem());
				SelectedYear=Integer.parseInt((String)cmbUpdtWrdnDobYr.getSelectedItem());
				
				ValidatePrison w1=new ValidatePrison();
				check=w1.DateCheck(SelectedDay, SelectedMonth, SelectedYear);

				if(check==1)
				{
					if(cmbUpdtWrdnRank.getSelectedIndex()==0 )
					{
						check=0;
						JOptionPane.showMessageDialog(null,"Please enter Warden's Rank");
					}
					else
						check=1;
				}

				if(check==1)
				{
					SelectedDay=Integer.parseInt((String)cmbUpdtWrdnJnDtDay.getSelectedItem());
					SelectedMonth=Integer.parseInt((String)cmbUpdtWrdnJnDtMon.getSelectedItem());
					SelectedYear=Integer.parseInt((String)cmbUpdtWrdnJnDtYr.getSelectedItem());

					ValidatePrison w2=new ValidatePrison();
					w2.DateCheck(SelectedDay, SelectedMonth, SelectedYear);
				}

				if(check==1)
				{
					
					if(DateCompare()>=0)
						check=1;
					else
					{
						check=0;
						JOptionPane.showMessageDialog(null,"Alert..!!\nBirth date cannot be greater than Joining date");
					}
				}

				if(check==1)
					UpdateWardenDetails();
				check=0;
			}
		}



		else if(btnWrdnClr == e.getSource())
		{
			cmbUpdtWrdnId.setSelectedIndex(0);
			cmbUpdtWrdnId.setEnabled(true);
			tfUpdtWrdnFName.setText("");
			tfUpdtWrdnLName.setText("");
			tfUpdtWrdnContact.setText("");
			tfUpdtWrdnStatus.setText("");
			
			rbUpdtWrdnGndrMale.setSelected(true);
			cmbUpdtWrdnDobDay.setSelectedIndex(0);
			cmbUpdtWrdnDobMon.setSelectedIndex(0);
			cmbUpdtWrdnDobYr.setSelectedIndex(0);
			cmbUpdtWrdnRank.setSelectedIndex(0);
			cmbUpdtWrdnJnDtDay.setSelectedIndex(0);
			cmbUpdtWrdnJnDtMon.setSelectedIndex(0);
			cmbUpdtWrdnJnDtYr.setSelectedIndex(0);

			Activation(false);

		}
	

		else if(btnWrdnDel == e.getSource())
		{
			WardenStatus = "Warden Left";
			setWardenStatus();
			JOptionPane.showMessageDialog(null,"Prisoner is Deleted");
		}
	

		else if(btnWrdnCancel == e.getSource())
		{
			frm.dispose();
		}

		
		
		else if( btnWrdnFirst == e.getSource())
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
					DisplayWrdnRecord(rs1);
					Activation(true);
				}
			}
			catch(SQLException e1)
			{
				System.out.println(e1);
			}
		}



		
		else if( btnWrdnLast == e.getSource())
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
					DisplayWrdnRecord(rs1);	
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
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		    System.out.println("Divers loaded successfully");
            Connection connect = DriverManager.getConnection("jdbc:odbc:PrisonDetails");
		    System.out.println("Connection established successfully");
            Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "select * from WardenDetails";
            rs1= state.executeQuery(sql);		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
	}





	public void Activation(boolean b)
	{
			tfUpdtWrdnFName.setEnabled(b);
			tfUpdtWrdnLName.setEnabled(b);
			tfUpdtWrdnContact.setEnabled(b);
			
			cmbUpdtWrdnDobDay.setEnabled(b);
			cmbUpdtWrdnDobMon.setEnabled(b);
			cmbUpdtWrdnDobYr.setEnabled(b);

			cmbUpdtWrdnRank.setEnabled(b);

			cmbUpdtWrdnJnDtDay.setEnabled(b);
			cmbUpdtWrdnJnDtMon.setEnabled(b);
			cmbUpdtWrdnJnDtYr.setEnabled(b);

			rbUpdtWrdnGndrMale.setEnabled(b);
			rbUpdtWrdnGndrFemale.setEnabled(b);

			btnWrdnUpdt.setEnabled(b);
			btnWrdnDel.setEnabled(b);
			btnWrdnClr.setEnabled(b);

	}




	/** public method DisplayWrdnRecord(ResultSet rst) having a ResultSet type argument with return type as void.
	This method is fetching the prisoner's record of required ID from database displaying it in the respective fields.*/
	public void DisplayWrdnRecord(ResultSet rst) throws SQLException
	{
		
		cmbUpdtWrdnId.setSelectedItem(rst.getString("Wrdn_ID"));
		cmbUpdtWrdnId.setEnabled(false);
        tfUpdtWrdnFName.setText(rst.getString("First_Name"));
		tfUpdtWrdnLName.setText(rst.getString("Last_Name"));
		tfUpdtWrdnContact.setText(rst.getString("Contact"));
		tfUpdtWrdnStatus.setText(rst.getString("Wrdn_Status"));


		String Gender=rst.getString("Wrdn_Gender");
		if(Gender.equals("Male"))
			rbUpdtWrdnGndrMale.setSelected(true);
		else
			rbUpdtWrdnGndrFemale.setSelected(true);

	
		String Date_Of_Birth = rst.getString("Date_Of_Birth");
		String Date_Of_Birth1 = Date_Of_Birth+"/";
		String Date_Of_Birth2[] = new String [3]; 

		int p=0,t=0,j=0;
		for(int i=0;i<Date_Of_Birth1.length();i++)
		{
			if(Date_Of_Birth1.charAt(i)=='/')
			{
				Date_Of_Birth2[j]=Date_Of_Birth1.substring(t,i);
				p=i;
				t=p+1;
				j++;
			}
		}
		cmbUpdtWrdnDobDay.setSelectedItem(Date_Of_Birth2[0]);
		cmbUpdtWrdnDobMon.setSelectedItem(Date_Of_Birth2[1]);
		cmbUpdtWrdnDobYr.setSelectedItem(Date_Of_Birth2[2]);


		cmbUpdtWrdnRank.setSelectedItem(rst.getString("Wrdn_Rank"));
		
		String Joining_Date = rst.getString("Join_Date");
		String Joining_Date1 = Joining_Date+"/";
		String Joining_Date2[] = new String[3];
		p=0;t=0;j=0;
		for(int i=0;i<Joining_Date1.length();i++)
		{
			if(Joining_Date1.charAt(i)=='/')
			{
				Joining_Date2[j]=Joining_Date1.substring(t,i);
				p=i;
				t=p+1;
				j++;
			}
		}
		cmbUpdtWrdnJnDtDay.setSelectedItem(Joining_Date2[0]);
		cmbUpdtWrdnJnDtMon.setSelectedItem(Joining_Date2[1]);
		cmbUpdtWrdnJnDtYr.setSelectedItem(Joining_Date2[2]);

		Activation(true);
		
	}



	/** public (Inner) class WdValidateKeyPress extends KeyAdapter and overriding the method keyPressed.
	This class is used to apply validations on the text fields*/
	class WdValidateKeyPress extends KeyAdapter
	{
		char ch;
		public void keyPressed(KeyEvent ke)
		{
			if(ke.getSource() == tfUpdtWrdnFName)
			{
				ch=ke.getKeyChar();
				if((ch>=97 && ch<=122)||(ch>=97 && ch<=122) || ch==8 || ch==32){}
				else 
				{
					JOptionPane.showMessageDialog(null,"Enter the Alphabets only");
					tfUpdtWrdnFName.setText("");	
				}
			}
			else if(ke.getSource() == tfUpdtWrdnLName)
			{
				ch=ke.getKeyChar();
				if((ch>=97 && ch<=122)||(ch>=97 && ch<=122) || ch==8 || ch==32){}
				else 
				{
					JOptionPane.showMessageDialog(null,"Enter the Alphabets only");
					tfUpdtWrdnLName.setText("");	
				}
			}
		}
	}



	/** public method FindWarden() with no argument type and return type as void.
	This method is used to find the warden in database by its ID and then retrieve the details from database to the respective fields.*/
	public void FindWarden()
	{
		try
		{
			int WrdnId=Integer.parseInt((String)cmbUpdtWrdnId.getSelectedItem());
			//int WrdnId = getSelectedItem();

            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		    System.out.println("Divers loaded successfully");
            Connection connect = DriverManager.getConnection("jdbc:odbc:PrisonDetails");
		    System.out.println("Connection established successfully");
            Statement state = connect.createStatement();
            String sql = "select * from WardenDetails where Wrdn_ID="+ WrdnId +"";
            ResultSet rs=state.executeQuery(sql);

		    if(rs.next())
			{
                DisplayWrdnRecord(rs);
				
				JOptionPane.showMessageDialog(null, "Record Found Successfully");
            }
			else
				JOptionPane.showMessageDialog(null, "Record Not Found");


		  
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




	/** public method UpdateWardenPrisoner() with no argument type and return type as void.
	This method is used to update the warden details in database.*/
	public void UpdateWardenDetails()
	{
		try
		{
			int Wrdnid=Integer.parseInt((String)cmbUpdtWrdnId.getSelectedItem());
			String WrdnFNm=tfUpdtWrdnFName.getText();
			String WrdnLNm=tfUpdtWrdnLName.getText();
			String WrdnCntct=tfUpdtWrdnContact.getText();
		
			String DobDay=(String)cmbUpdtWrdnDobDay.getSelectedItem();
			String DobMonth=(String)cmbUpdtWrdnDobMon.getSelectedItem();
			String Dobyear=(String)cmbUpdtWrdnDobYr.getSelectedItem();
			String Dob=DobDay+"/"+DobMonth+"/"+Dobyear;

			String WrdnRank=(String)cmbUpdtWrdnRank.getSelectedItem();

			String JnDtDay=(String)cmbUpdtWrdnJnDtDay.getSelectedItem();
			String JnDtMonth=(String)cmbUpdtWrdnJnDtMon.getSelectedItem();
			String JnDtyear=(String)cmbUpdtWrdnJnDtYr.getSelectedItem();
			String JoinDate=JnDtDay+"/"+JnDtMonth+"/"+JnDtyear;

			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Divers loaded successfully");
		  
			Connection connect = DriverManager.getConnection("jdbc:odbc:PrisonDetails");
			System.out.println("Connection established successfully");
			Statement state = connect.createStatement();
			String sql = "UPDATE WardenDetails set Wrdn_ID = '" +  Wrdnid + "', First_Name = '" +  WrdnFNm + "', Last_Name = '" +  WrdnLNm + "', Contact = '" +  WrdnCntct + "', Wrdn_Gender = '" +  Gender + "', Date_Of_Birth = '" +  Dob + "', Wrdn_Rank = '" +  WrdnRank + "', Join_Date = '" +  JoinDate + "' WHERE Wrdn_ID= "+Wrdnid+"";  
			state.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Record Updated Successfully");
			System.out.println("Statement executed successfully");
			state.close();
			connect.close();
		}
        catch (Exception e) 
		{
           System.out.print(e);
        }
	}


	
	/** public method setWardenStatus() with no argument type and return type as void.
	This method is used to update the warden's status in database.*/
	public void setWardenStatus()
	{
		try
		{
			int Wrdnid=Integer.parseInt((String)cmbUpdtWrdnId.getSelectedItem());
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection connect = DriverManager.getConnection("jdbc:odbc:PrisonDetails");
			Statement state = connect.createStatement();
			String sql="UPDATE WardenDetails set Wrdn_Status= '"+WardenStatus+"' WHERE Wrdn_ID= "+Wrdnid+"";
			state.execute(sql);
			state.close();
			connect.close();
		}
		catch (Exception e1) 
		{
			System.out.println(e1);
		}
		tfUpdtWrdnStatus.setText(WardenStatus);
	}

	
	/** public method SelectWardenID() with no arguement type and return type as void.
	This method is used to select and dispaly the available warden ID present in database from which user can select one from in the combobox and find it .*/
	public void SelectWardenID()
	{
		try
		{
			int i=0;
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection connect = DriverManager.getConnection("jdbc:odbc:PrisonDetails");
			Statement state = connect.createStatement();
			String sql = "SELECT Wrdn_ID FROM WardenDetails";
			ResultSet rs=state.executeQuery(sql);
			while(rs.next())
			{
				cmbUpdtWrdnId.addItem(rs.getString("Wrdn_ID"));
				//i++;
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
