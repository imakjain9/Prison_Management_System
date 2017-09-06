//package Prisoner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//import Validation.*;

/** public class PrisonerAdd which is adding the prisoners in Database of Prison_Manage_System implements ActionListener Interface*/
public class PrisonerAdd implements ActionListener
{
	/** variable to create the Frame. */
		private JFrame frm;
	/** variable to create the Panel. */
		private JPanel jp;
	/** JLabel to create the header.*/
		private JLabel lblPrsnrMod;
	/** JLabel to ask user for Prisoner ID.*/
		private JLabel lblPrsnrId;
	/** JLabel to ask user for prisoner first name.*/
		private JLabel lblPrsnrFName; 
	/** JLabel to ask user for prisoner last name.*/
		private JLabel lblPrsnrLName; 
	/** JLabel to ask user for prisoner crime type.*/
		private JLabel lblPrsnrCrType;
	/** JLabel to ask user for prisoner entrance date.*/
		private JLabel lblPrsnrEntDate;
	/** JLabel to ask user for prisoner release date.*/
		private JLabel lblPrsnrRelDate; 
	/** JLabel to ask user for prisoner security level.*/
		private JLabel lblPrsnrScLvl; 
	/** JLabel to ask user for prisoner cell sharing status.*/
		private JLabel lblPrsnrCellShar;
	/** JLabel to ask user for assigned warden to prisoner.*/
		private JLabel lblPrsnrWdAsgnd; 
	/** JLabel to ask user for prisoner status.*/
		private JLabel lblPrsnrStatus;

	/** JTextField to take prisoner ID as input. */
		private JTextField tfPrsnrId;
	/** JTextField to take prisoner fist name as input. */
		private JTextField tfPrsnrFName;
	/** JTextField to take prisoner last name as input. */
		private JTextField tfPrsnrLName;
	/** JTextField to take prisoner status as input. */
		private JTextField tfPrsnrStatus;



	/** comboBox to take Prisoner crime type */
		private JComboBox cmbPrsnrCrType;
	/** comboBox to take the day of prisoner entrance date. */
		private JComboBox cmbPrsnrEntDDay;
	/** comboBox to take the month of Prisoner entrance date. */
		private JComboBox cmbPrsnrEntDtMon;
	/** comboBox to take the year of prisoner Entrance date. */
		private JComboBox cmbPrsnrEntDYr;
	/** comboBox to take the day of prisoner release date. */
		private JComboBox cmbPrsnrRelDDay;
	/** comboBox to take the month of prisoner release date. */
		private JComboBox cmbPrsnrRelDMon; 
	/** comboBox to take the year of prisoner release date. */
		private JComboBox cmbPrsnrRelDYr; 
	/** comboBox to take Prisoner seurity level. */
		private JComboBox cmbPrsnrScLv; 
	/** comboBox to take ID of assigned warden to prisoner. */
		private JComboBox cmbPrsnrWdAsgnd;


	/** JButton to find the Prisoner Record.*/
		private JButton btnPrsnrAdd;
	/** JButton to clear the fields in Prisoner form.*/
		private JButton btnPrsnrClr;
	/** JButton to close the form.*/
		private JButton btnPrsnrCancel;
	/** JRadioButton to get cell sharing status as yes.*/
		private JRadioButton rbPrsnrCellSharYes;
	/** JRadioButton to get cell sharing status as No.*/
		private JRadioButton rbPrsnrCellSharNo;


	/** ButtonGroup variable to add radio buttons. */
		private ButtonGroup bgCellShar;
	/** Variable to create new Color object. */
		private Color prlblClr;


	
	/** String type variable to keep prisoner cell sharing status. */
		private String CellShar;
	/** String type variable to keep Prisoner status. */
		private String PrisonerStatus;


	/** Variable of int type for proper validations. */
		private int check=0;
	/** int type Variable to store the day of some specific date. */
		private int SelectedDay;
	/** int type Variable to store the month of some specific date. */
		private int SelectedMonth;
	/** int type Variable to store the year of some specific date. */
		private int SelectedYear;

	


	/**Constructer PrisonAdd() of zero argument to initialize or construct the new object of PrisonAdd 
	i.e. it is initializing the values in the variables including JFrame, JPanel, JLabel, JCombobox and JRadioButton etc. */
	public PrisonerAdd()
	{
		frm=new JFrame();
		jp=new JPanel();
		lblPrsnrMod=new JLabel(new ImageIcon("Images/PrisonerAddHeader.png"));
		lblPrsnrId=new JLabel("Prisoner ID :");
		lblPrsnrFName=new JLabel("First Name :");
		lblPrsnrLName=new JLabel("Last Name :");
		lblPrsnrCrType=new JLabel("Crime Type");
		lblPrsnrEntDate=new JLabel("Entrance Date :");
		lblPrsnrRelDate=new JLabel("Release Date :");
		lblPrsnrScLvl=new JLabel("Security Level :");
		lblPrsnrCellShar=new JLabel("Cell Sharing :");
		lblPrsnrWdAsgnd=new JLabel("Warden Assigned :");
		lblPrsnrStatus=new JLabel("Prisoner Status :");

		tfPrsnrFName=new JTextField();
		tfPrsnrLName=new JTextField();
		tfPrsnrId=new JTextField();
		tfPrsnrStatus=new JTextField();




		//Day
		Object date[]=new Object[32];
		date[0]="Day";
		int a=1;
		for (int i=01; i<=31 ;++i){
			date[a]=Integer.toString(i);
			a++;
		}
		cmbPrsnrEntDDay=new JComboBox(date);
		cmbPrsnrRelDDay=new JComboBox(date);



		//Month
		Object month[]=new Object[13];
		month[0]="Month";
		int b=1;
		for (int i=1; i<=12 ;++i){
			month[b]=Integer.toString(i);
			b++;
		}
		cmbPrsnrEntDtMon=new JComboBox(month);
		cmbPrsnrRelDMon=new JComboBox(month);



		//Year
		Object year[]=new Object[52];
		year[0]="Year";
		int c=1;
		for (int i=2000; i<=2050 ;i++){
			year[c]=Integer.toString(i);
			c++;
		}
		cmbPrsnrEntDYr=new JComboBox(year);
		cmbPrsnrRelDYr=new JComboBox(year);



		//Crime Type
		String CrTyp[]={"Select Crime Type","Murder", "Theft","Robbery", "Kidnapping", "Sexual Crime", "Hacking"};
		cmbPrsnrCrType=new JComboBox(CrTyp);


		//Security level
		String ScLvl []={"Prisoner Security Level","Low Security","High Security"};
		cmbPrsnrScLv=new JComboBox(ScLvl);


		//Warden type
		//String WdTyp[]={"Select Warden "};
		cmbPrsnrWdAsgnd=new JComboBox();


		//Cell Sharing
		rbPrsnrCellSharYes=new JRadioButton ("Yes",true);
		rbPrsnrCellSharNo=new JRadioButton ("No");
		bgCellShar=new ButtonGroup();

		
		btnPrsnrAdd=new JButton("Add",new ImageIcon("Images/addImage.png"));
		btnPrsnrClr=new JButton("Clear",new ImageIcon("Images/clearImage.png"));
		btnPrsnrCancel= new JButton("Cancel",new ImageIcon("Images/cancelImage.gif"));

		prlblClr =new Color(162,194,214,255);
		
	}





	/**Public Method PrisonerDetailsUpdated() having zero argument and return type is void
	It is used to add the various prisoner fields on the JFrame using setbounds method.*/
	public void PrisonerDetails()
	{
		frm.setTitle("Add Prisoner's Details");
		//frm.setLayout(null);
		frm.setSize(600,500);
		frm.setLocation(350,100);
		frm.setResizable(false);
		frm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		
		jp.setLayout(null);
		jp.setBackground(Color.black);
		frm.add(jp,BorderLayout.CENTER);

		//Header
		lblPrsnrMod.setBounds(0,0,600,70);
		jp.add(lblPrsnrMod);


		//Prisoner's ID
		lblPrsnrId.setBounds(60,70,160,25);
		lblPrsnrId.setFont(new Font("Serif", Font.BOLD, 20));
		lblPrsnrId.setForeground(prlblClr);
		jp.add(lblPrsnrId);
		
		tfPrsnrId.setBounds(240,70,170,25);
		Generate_ID();
		tfPrsnrId.setEditable(false);
		jp.add(tfPrsnrId);
		
		tfPrsnrId.addKeyListener(new PrValidateKeyPress());


		//Label first name
		lblPrsnrFName.setBounds(60,110,160,25);
		lblPrsnrFName.setFont(new Font("Serif", Font.BOLD, 20));
		lblPrsnrFName.setForeground(prlblClr);
		jp.add(lblPrsnrFName);

		tfPrsnrFName.setBounds(240,110,170,25);
		jp.add(tfPrsnrFName);
		tfPrsnrFName.addKeyListener(new PrValidateKeyPress());


		//last name
		lblPrsnrLName.setBounds(60,150,160,25);
		lblPrsnrLName.setFont(new Font("Serif", Font.BOLD, 20));
		lblPrsnrLName.setForeground(prlblClr);
		jp.add(lblPrsnrLName);
		
		tfPrsnrLName.setBounds(240,150,170,25);
		jp.add(tfPrsnrLName);
		tfPrsnrLName.addKeyListener(new PrValidateKeyPress());


		//Crime Type
		lblPrsnrCrType.setBounds(60,190,160,25);
		lblPrsnrCrType.setFont(new Font("Serif", Font.BOLD, 20));
		lblPrsnrCrType.setForeground(prlblClr);
		jp.add(lblPrsnrCrType);

		cmbPrsnrCrType.setBounds(240,190,170,25);
		jp.add(cmbPrsnrCrType);


		//Entrance date of prisoner
		lblPrsnrEntDate.setBounds(60,230,160,25);
		lblPrsnrEntDate.setFont(new Font("Serif", Font.BOLD, 20));
		lblPrsnrEntDate.setForeground(prlblClr);
		jp.add(lblPrsnrEntDate);
		
		cmbPrsnrEntDDay.setBounds(240,230,50,25);
		jp.add(cmbPrsnrEntDDay);
		cmbPrsnrEntDtMon.setBounds(290,230,65,25);
		jp.add(cmbPrsnrEntDtMon);
		cmbPrsnrEntDYr.setBounds(355,230,55,25);
		jp.add(cmbPrsnrEntDYr);


		//Release Date of prisoner
		lblPrsnrRelDate.setBounds(60,270,160,25);
		lblPrsnrRelDate.setFont(new Font("Serif", Font.BOLD, 20));
		lblPrsnrRelDate.setForeground(prlblClr);
		jp.add(lblPrsnrRelDate);
		
		cmbPrsnrRelDDay.setBounds(240,270,50,25);
		jp.add(cmbPrsnrRelDDay);
		cmbPrsnrRelDMon.setBounds(290,270,65,25);
		jp.add(cmbPrsnrRelDMon);
		cmbPrsnrRelDYr.setBounds(355,270,55,25);
		jp.add(cmbPrsnrRelDYr);


		//Security Level
		lblPrsnrScLvl.setBounds(60,310,160,25);
		lblPrsnrScLvl.setFont(new Font("Serif", Font.BOLD, 20));
		lblPrsnrScLvl.setForeground(prlblClr);
		jp.add(lblPrsnrScLvl);
		
		cmbPrsnrScLv.setBounds(240,310,170,25);
		jp.add(cmbPrsnrScLv);


		//Cell sharing
		lblPrsnrCellShar.setBounds(60,350,160,25);
		lblPrsnrCellShar.setFont(new Font("Serif", Font.BOLD, 20));
		lblPrsnrCellShar.setForeground(prlblClr);
		jp.add(lblPrsnrCellShar);

		bgCellShar.add(rbPrsnrCellSharYes);
		bgCellShar.add(rbPrsnrCellSharNo);

		rbPrsnrCellSharYes.setBounds(240,350,80,25);
		rbPrsnrCellSharYes.setForeground(prlblClr);
		rbPrsnrCellSharYes.setBackground(Color.gray);
		rbPrsnrCellSharYes.addActionListener(this);

		rbPrsnrCellSharNo.setBounds(330,350,80,25);
		rbPrsnrCellSharNo.setForeground(prlblClr);
		rbPrsnrCellSharNo.setBackground(Color.gray);
		rbPrsnrCellSharNo.addActionListener(this);

		
		jp.add(rbPrsnrCellSharYes);
		jp.add(rbPrsnrCellSharNo);


		//bgCellShar.setBounds(240,380,140,25);
		//jp.add(bgCellShar);

		//warden assigned to prisoner
		lblPrsnrWdAsgnd.setBounds(60,390,160,25);
		lblPrsnrWdAsgnd.setFont(new Font("Serif", Font.BOLD, 20));
		lblPrsnrWdAsgnd.setForeground(prlblClr);
		jp.add(lblPrsnrWdAsgnd);

		cmbPrsnrWdAsgnd.setBounds(240,390,170,25);
		cmbPrsnrWdAsgnd.addItem("Select Warden");
		SelectWarden();
		jp.add(cmbPrsnrWdAsgnd);

		//tfAsndWrdnId.setBounds(360,420,50,25);
		//jp.add(tfAsndWrdnId);
		
		//status
		lblPrsnrStatus.setBounds(60,430,160,25);
		lblPrsnrStatus.setFont(new Font("Serif", Font.BOLD, 20));
		lblPrsnrStatus.setForeground(prlblClr);
		jp.add(lblPrsnrStatus);

		tfPrsnrStatus.setBounds(240,430,170,25);
		tfPrsnrStatus.setEditable(false);
		tfPrsnrStatus.setText("Imprisoned");
		jp.add(tfPrsnrStatus);

		
		//add Button
		btnPrsnrAdd.setBounds(440,70,110,50);
		btnPrsnrAdd.setFont(new Font("Serif", Font.BOLD, 20));
		jp.add(btnPrsnrAdd);
		btnPrsnrAdd.addActionListener(this);

		//Clear Button
		btnPrsnrClr.setBounds(440,140,110,50);
		btnPrsnrClr.setFont(new Font("Serif", Font.BOLD, 20));
		jp.add(btnPrsnrClr);
		btnPrsnrClr.addActionListener(this);
		
		//Cancel button
		btnPrsnrCancel.setBounds(440,210,110,50);
		btnPrsnrCancel.setFont(new Font("Serif", Font.BOLD, 20));
		jp.add(btnPrsnrCancel);
		btnPrsnrCancel.addActionListener(this);

		frm.setVisible(true);
		
		
	}





	/**Public Method DateCompare() having zero argument with return type as integer
	It is Comparing two different using compareTo method and return the -1 or +1 or 0 according to dates compared.*/
	public int DateCompare()
	{
		SelectedDay=Integer.parseInt((String)cmbPrsnrEntDDay.getSelectedItem());
		SelectedMonth=Integer.parseInt((String)cmbPrsnrEntDtMon.getSelectedItem());
		SelectedYear=Integer.parseInt((String)cmbPrsnrEntDYr.getSelectedItem());

		Date EntranceDate = new Date(SelectedYear, SelectedMonth, SelectedDay);

		SelectedDay=Integer.parseInt((String)cmbPrsnrRelDDay.getSelectedItem());
		SelectedMonth=Integer.parseInt((String)cmbPrsnrRelDMon.getSelectedItem());
		SelectedYear=Integer.parseInt((String)cmbPrsnrRelDYr.getSelectedItem());

		Date ReleaseDate = new Date(SelectedYear, SelectedMonth, SelectedDay);

		int i=ReleaseDate.compareTo(EntranceDate);
		return i;
	}



	
	/** public (Inner) class PrValidateKeyPress extends KeyAdapter and overriding the method keyPressed.
	This class is used to apply validations on the text fields*/
	class PrValidateKeyPress extends KeyAdapter
	{
		char ch;
		public void keyReleased(KeyEvent ke)
		{
			if(ke.getSource() == tfPrsnrFName)
			{
				ch=ke.getKeyChar();
				if((ch>=97 && ch<=122)|| ch==8 || ch==32){}
				else 
				{
					JOptionPane.showMessageDialog(null,"Enter the Alphabets only");
					tfPrsnrFName.setText("");	
				}
			}
			else if(ke.getSource() == tfPrsnrLName)
			{
				ch=ke.getKeyChar();
				if((ch>=97 && ch<=122)|| ch==8 || ch==32){}
				else 
				{
					JOptionPane.showMessageDialog(null,"Enter the Alphabets only");
					tfPrsnrLName.setText("");	
				}
			}
		}
	}





	/**Public Method actionPerformed(ActionEvent e) having one argument with return type as void. 
	This method is coming from ActionListener interface.
	It is used to providing the functionality to the System i.e. on click of some specific button someoperation will be perofrmed.
	All these details given by this method.
	getSource() method is used here to identify the buttons.*/
	public void actionPerformed(ActionEvent e)
	{
		if(rbPrsnrCellSharYes.isSelected())
			CellShar="Yes";
		else if(rbPrsnrCellSharNo.isSelected())
		{
			CellShar="No";
		}
		
		if( btnPrsnrAdd == e.getSource())
		{
			
			if (tfPrsnrId.getText().equals(""))
				JOptionPane.showMessageDialog(null,"The Prisoner ID  is empty");
			else if(tfPrsnrFName.getText().equals(""))
				JOptionPane.showMessageDialog(null,"The FirstName is empty");
			else if (tfPrsnrLName.getText().equals(""))
				JOptionPane.showMessageDialog(null,"The LastName is empty");
			else if (cmbPrsnrCrType.getSelectedIndex()==0 )
				JOptionPane.showMessageDialog(null,"Please Enter a valid Crime");
			else if (cmbPrsnrEntDDay.getSelectedIndex()==0 || cmbPrsnrEntDtMon.getSelectedIndex()==0 || cmbPrsnrEntDYr.getSelectedIndex()==0)
				JOptionPane.showMessageDialog(null,"Please Enter a valid Entrance date");
			else if (cmbPrsnrRelDDay.getSelectedIndex()==0 || cmbPrsnrRelDMon.getSelectedIndex()==0 || cmbPrsnrRelDYr.getSelectedIndex()==0)
				JOptionPane.showMessageDialog(null,"Please Enter a valid Release date");
			else if (cmbPrsnrScLv.getSelectedIndex()==0 )
				JOptionPane.showMessageDialog(null,"Please enter the Security Level again");
			
			else
			{
				SelectedDay=Integer.parseInt((String)cmbPrsnrEntDDay.getSelectedItem());
				SelectedMonth=Integer.parseInt((String)cmbPrsnrEntDtMon.getSelectedItem());
				SelectedYear=Integer.parseInt((String)cmbPrsnrEntDYr.getSelectedItem());
				
				ValidatePrison p1=new ValidatePrison();
				check = p1.DateCheck(SelectedDay, SelectedMonth, SelectedYear);

				if(check==1)
				{
					SelectedDay=Integer.parseInt((String)cmbPrsnrRelDDay.getSelectedItem());
					SelectedMonth=Integer.parseInt((String)cmbPrsnrRelDMon.getSelectedItem());
					SelectedYear=Integer.parseInt((String)cmbPrsnrRelDYr.getSelectedItem());
					
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
						JOptionPane.showMessageDialog(null,"Alert..!!\nEntrance date cannot be greater than release date");
					}
				}

				if(check==1)
				{
					if(cmbPrsnrScLv.getSelectedItem().equals("High Security") && (rbPrsnrCellSharYes.isSelected()))
					{
						JOptionPane.showMessageDialog(null,"High security prisoner cannot share cell");
						check=0;
					}
					else
						check=1;
				}
				
				if(check==1)
				{
					if (cmbPrsnrWdAsgnd.getSelectedIndex()==0 )
					{
						JOptionPane.showMessageDialog(null,"Please Assign the warden carefully");
						check=0;
					}
					else
						check=1;
				}

				if(check==1)
				{
					CheckPrison c = new CheckPrison();
					if(c.TestPrison()==1)
					{
						AddPrisonerDetails();
					}
				}
				check=0;
			}	
		}


		else if(btnPrsnrClr == e.getSource())
		{
			tfPrsnrId.setText("");
			tfPrsnrFName.setText("");
			tfPrsnrLName.setText("");
			cmbPrsnrCrType.setSelectedIndex(0);

			cmbPrsnrEntDDay.setSelectedIndex(0);
			cmbPrsnrEntDtMon.setSelectedIndex(0);
			cmbPrsnrEntDYr.setSelectedIndex(0);

			cmbPrsnrRelDDay.setSelectedIndex(0);
			cmbPrsnrRelDMon.setSelectedIndex(0);
			cmbPrsnrRelDYr.setSelectedIndex(0);

			cmbPrsnrScLv.setSelectedIndex(0);
			cmbPrsnrWdAsgnd.setSelectedIndex(0);

			rbPrsnrCellSharYes.setSelected(true);
			Generate_ID();

			//tfPrsnrTmPer.setText("");
		}
		




		else if(btnPrsnrCancel == e.getSource()){
			frm.dispose();
		}
	}





	/** public method AddPrisonerDetails() with no argument type and return type as void.
	This method is used to add the prisoner details in database.*/
	public void AddPrisonerDetails()
	{
        try
		{
			int Prsnrid=Integer.parseInt(tfPrsnrId.getText());
			String PrsnrFNm=tfPrsnrFName.getText();
			String PrsnrLNm=tfPrsnrLName.getText();
			String prsnrStatus=tfPrsnrStatus.getText();
			

		   String PrsnrCrTp=(String)cmbPrsnrCrType.getSelectedItem();
		   String PrsnrScLvl=(String)cmbPrsnrScLv.getSelectedItem();
		   String WrdnAssnd=(String)cmbPrsnrWdAsgnd.getSelectedItem();

		   String EntDtDay=(String)cmbPrsnrEntDDay.getSelectedItem();
		   String EntDtMonth=(String)cmbPrsnrEntDtMon.getSelectedItem();
		   String EntDtyear=(String)cmbPrsnrEntDYr.getSelectedItem();
		   String EntDate=EntDtDay+"/"+EntDtMonth+"/"+EntDtyear;

		   String RelDtDay=(String)cmbPrsnrRelDDay.getSelectedItem();
		   String RelDtMonth=(String)cmbPrsnrRelDMon.getSelectedItem();
		   String RelDtyear=(String)cmbPrsnrRelDYr.getSelectedItem();
		   String RelDate=RelDtDay+"/"+RelDtMonth+"/"+RelDtyear;

           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   Connection connect = DriverManager.getConnection("jdbc:odbc:PrisonDetails");
           Statement state = connect.createStatement();
           String sql = "insert into PrisonerDetails (Prsnr_ID,First_Name,Last_Name,Crime_Type, Ent_Date, Rel_Date, Sec_Lvl,Cell_Sharing, Wrdn_Assnd, Prsnr_Status) values ('" +  Prsnrid + "','" +  PrsnrFNm + "','" +  PrsnrLNm + "','" +  PrsnrCrTp + "', '" +  EntDate + "', '" +  RelDate + "', '" +  PrsnrScLvl + "', '" +  CellShar + "', '" +  WrdnAssnd + "', '" +  prsnrStatus + "')";  
		   state.execute(sql);
		   JOptionPane.showMessageDialog(null, "Record added Successfully");
		   System.out.println("Statement executed successfully");
		   state.close();
           connect.close();
		}
        catch (Exception e) 
		{
           System.out.print(e);
        }
	}


	/** public method SelectWarden() with no arguement type and return type as void.
	This method is used to select and dispaly the available warden to be assigned in the combobox.*/
	public void SelectWarden()
	{
		try
		{
			int i=0;
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection connect = DriverManager.getConnection("jdbc:odbc:PrisonDetails");
			Statement state = connect.createStatement();
			String sql = "SELECT * FROM WardenDetails order by Wrdn_ID";
			ResultSet rs=state.executeQuery(sql);
			while(rs.next())
			{
				if((rs.getString("Wrdn_Status")).equals("On Service"))
					cmbPrsnrWdAsgnd.addItem(rs.getString("Wrdn_ID"));
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



	/** public method Generate_ID() with no argument type and return type as void.
	This method is used to generate and display the next ID when the form opens.*/
	public void Generate_ID()
	{
		try
		{
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection connect = DriverManager.getConnection("jdbc:odbc:PrisonDetails");
			Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT Prsnr_ID FROM PrisonerDetails";
			ResultSet rs=state.executeQuery(sql);
			rs.last();
			tfPrsnrId.setText(String.valueOf(rs.getInt("Prsnr_ID")+1));
			rs.close();
			state.close();
			connect.close();
		}
		catch (Exception e) 
		{
			tfPrsnrId.setText(String.valueOf(1));
			//System.out.print(e);
        }
	}
}



