//package Validation;
import javax.swing.*;

/** public class ValidatePrison used for validating the dates for entrance and release must be exist in the calender */
public class ValidatePrison
{
	/**Public Method DateCheck(int dd,int mm,int yy) having three argument with return type as Integer
	It is used to check whether the date entered by user is actually exists in calender or not.
	for example if user enters 30/23/2001 he will get a message that enter the suitable date.*/
	public int DateCheck(int dd,int mm,int yy)
	{
		int check=0;
		
		if(mm==1 || mm==3 || mm==5 || mm==7 || mm==8 || mm==10 || mm==12)
		{
			if(dd>=1 && dd<=31)
					check=1;
		}
		
		else if( mm==4 || mm==6 || mm==5 || mm==9 || mm==11 )
		{
			if(dd>=1 && dd<=30)
				check=1;
			else
			{
				JOptionPane.showMessageDialog(null,"Alert...!!\nPlease enter the date under 30 only");
				check=0;
			}
		}
		
		else if(mm==2 && yy%4 == 0)
		{
			if(dd>=1 && dd<=29)
				check=1;	
			else
			{
				JOptionPane.showMessageDialog(null,"Alert...!!\nFeb can contain 29 days only!!");
				check=0;
			}
		}
		
		else if(mm==2 && yy%4!=0)
		{
			if(dd>=1 && dd<=28)
				check=1;	
			else
			{
				JOptionPane.showMessageDialog(null,"Alert...!!\nFeb can contain 28 days only!!");
				check=0;
			}
		}
			
		return check;
	}
}
