//package Warden;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.*;

/** public class WardenReport is used to create and display the report of all wardens present in the Prison by fetching the records of warden from database*/
public class WardenReport
{
	/** variable to create the Frame. */
		private JFrame frm;
	/** variable pnlHeader to create the panel for header. */
		private JPanel pnlHeader;
	/** variable pnlHeader to create the panel for table`. */
		private JPanel pnlTable;
	/**variable of DefaultModelType class*/
		private DefaultTableModel table_Model;
	/** JTable to draw the table to show the reports.*/
		private JTable table;
	/** JLabel to create the header.*/
		private JLabel lblHeader;
	/**JCrollPane to add the table on the panel or frame*/
		private JScrollPane sclTable;
	
	
	/**Constructor WardenReport() of zero argument to initialize or construct the new object of WardenUpdate 
	i.e. it is initializing the values in the variables including JFrame, JPanel, JLabel, JTable, DefaultTableModel and  JScrollPane. */
	public WardenReport()
	{
	  	frm = new JFrame("Report");
		pnlHeader=new JPanel();
		pnlTable=new JPanel();
	    
		lblHeader=new JLabel(new ImageIcon("Images/WardenReport.png"));
		
		table_Model = new DefaultTableModel();
		table = new JTable(table_Model);

		sclTable=new JScrollPane(table);
	}


	/**public Method WardenReportDetails() having zero argument and return type is void
	It is used to add the various fields of warden on the JFrame using layouts and setBounds method.
	This method includes the database connection and SQL queries to fetch the data from database.*/
    public void WardenReportDetails() 
	{
		frm.setSize(1366,768);
		frm.setLocation(0,0);
		frm.setLayout(new BorderLayout());

		//panel header
		pnlHeader.setBackground(Color.black);
		pnlHeader.add(lblHeader, new BorderLayout().CENTER);
		frm.add(pnlHeader,BorderLayout.NORTH);

		
		//panel table
		table.setRowHeight(30);
		table.setFont(new Font("Arial",0,15));
		table.setAlignmentY(30);
		table.setEnabled(false);
		//table.setBackground(Color.black);
		//table.setForeground(Color.white);
		//table.setSize(1366,500);

		pnlTable.setLayout(new BorderLayout());
		frm.add(pnlTable, BorderLayout.CENTER);
		//table.setAlignmentY(0.5f);

		sclTable.setSize(1200,500);
		pnlTable.add(sclTable, BorderLayout.CENTER);


		frm.setVisible(true);

		/*table_Model.addColumn("Serial NO.");
		table_Model.addColumn("Warden ID");
		table_Model.addColumn("NAME");
		table_Model.addColumn("SECURITY LEVEL");
		table_Model.addColumn("BOOK DATE");
		table_Model.addColumn("RELEASE DATE");*/

		Object content[]=new Object[9];
		int count=1;

		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection connect = DriverManager.getConnection("jdbc:odbc:PrisonDetails");
			Statement  stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from WardenDetails");
			ResultSetMetaData md = rs.getMetaData();

			int columns = md.getColumnCount();
			
			for (int i = 1; i <= columns; i++) 
			{
				table_Model.addColumn( md.getColumnName(i) );
			}

			while(rs.next())
			{
				//content[0]=count;
				content[0]=rs.getInt("Wrdn_ID");
				content[1]=rs.getString("First_Name");
				content[2]=rs.getString("Last_Name");
				content[3]=rs.getString("Contact");
				content[4]=rs.getString("Wrdn_Gender");
				content[5]=rs.getString("Date_Of_Birth");
				content[6]=rs.getString("Wrdn_Rank");
				content[7]=rs.getString("Join_Date");
				content[8]=rs.getString("Wrdn_Status");
				table_Model.addRow(content); 
				//count++;
			}
	  		stmt.close();
			connect.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}



}