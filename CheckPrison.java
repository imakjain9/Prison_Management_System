//package Validation;
import java.sql.*;
import javax.swing.*;
import java.util.*;

/** public class CheckPrison used for checking the prison according to some condition specified like prison and warden ratio etc. */
public class CheckPrison
{
	/** int type Variable to store number of high security prisoners. */
		private double highSecPrsnr;
	/** int type Variable to store number of low security prisoners. */
		private double lowSecPrsnr;
	/** int type Variable to store total number prisoners. */
		private double totalPrsnr;
	
	/** int type Variable to store number of wardens of rank 1. */
		private double wrdnRnk1;
	/** int type Variable to store number of wardens of rank 2. */
		private double wrdnRnk2;
	/** int type Variable to store number of wardens of rank 3. */
		private double wrdnRnk3;
	/** int type Variable to store number of wardens of rank 4. */
		private double wrdnRnk4;
	/** int type Variable to store number of wardens of rank 5. */
		private double wrdnRnk5;
	/** int type Variable to store total number of wardens . */
		private double totalWrdn;
	
	/**Public Method TestPrison() having zero argument with return type as Integer
	It is used to check the prison that a warden must not have more than 5 prisoners.
	Also The prison must have 2 wardens of rank 3 or above for every 4 high security prisoners.*/
	public int TestPrison()
	{
		int check=0;
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection connect = DriverManager.getConnection("jdbc:odbc:PrisonDetails");
			Statement state = connect.createStatement();
			String sql = "SELECT Prsnr_ID FROM PrisonerDetails order by Prsnr_ID";
			ResultSet rs=state.executeQuery(sql);

			while(rs.next())
			{
				totalPrsnr++;
			}
			rs.close();

			String sql1 = "SELECT Sec_Lvl FROM PrisonerDetails";
			ResultSet rs1=state.executeQuery(sql1);

			while(rs1.next())
			{
				if(rs1.getString("Sec_Lvl").equals("Low Security"))
					lowSecPrsnr++;
				else 
					highSecPrsnr++;
			}

			rs1.close();


			String sql2 = "SELECT * FROM WardenDetails order by Wrdn_ID";
			ResultSet rs2=state.executeQuery(sql2);

			while(rs2.next())
			{
				if((rs2.getString("Wrdn_Status")).equals("On Service"))
					totalWrdn++;
			}

			
			rs2.close();


			String sql3 = "SELECT * FROM WardenDetails ";
			ResultSet rs3=state.executeQuery(sql3);

			while(rs3.next())
			{
				switch (rs3.getInt("Wrdn_Rank"))
				{
				case 1:
					if((rs3.getString("Wrdn_Status")).equals("On Service"))
					wrdnRnk1++;
				break;

				case 2:
					if((rs3.getString("Wrdn_Status")).equals("On Service"))
					wrdnRnk2++;
				break;

				case 3:
					if((rs3.getString("Wrdn_Status")).equals("On Service"))
					wrdnRnk3++;
				break;

				case 4:
					if((rs3.getString("Wrdn_Status")).equals("On Service"))
					wrdnRnk4++;
				break;
				
				case 5:
					if((rs3.getString("Wrdn_Status")).equals("On Service"))
					wrdnRnk5++;
				break;
				}
			}
			rs3.close();
			state.close();
			connect.close();
		}
		catch (Exception e) 
		{
           System.out.print(e);
        }

		if(totalWrdn>=(totalPrsnr+1)/5)
		{
			//JOptionPane.showMessageDialog(null,"prison is ok");
			check=1;
		}

		if(check==1)
		{
			if(wrdnRnk3+wrdnRnk4+wrdnRnk5>=(highSecPrsnr+1)/2)
				check=1;
			else
			{
				check=0;
				JOptionPane.showMessageDialog(null,"Add a warden with rank equal to or greater than 3");
			}
		}

		else
		{
			JOptionPane.showMessageDialog(null,"Prisoner Warden Ratio is not ok \n Please Add a new Warden first");
			check=0;
		}


		return check;
	}	
	
}
