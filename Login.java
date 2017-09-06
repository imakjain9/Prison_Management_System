//package PMS;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import java.sql.*;

/** public class Login used for the purpose of login the Prison_Management_System implements ActionListener Interface*/
public class Login implements ActionListener
{
	/** variable to create the Frame. */
		private JFrame frm;
	/** variable to create the Panel to add the components. */
		private JPanel jp;
	/** JLabel to provide the title.*/
		private JLabel lblTitle;
	/** JLabel to ask user for UserName.*/
		private JLabel lblUsername;
	/** JLabel to ask user for password.*/
		private JLabel lblPassword;
	/** JLabel to ask user for user type.*/
		private JLabel lblLoginAs; 
	
	/** JTextField to take UserName as input. */
		private JTextField tfUsername;
	/** JTextField to take Password as input. */
		private JPasswordField pfPassword;
	/** JTextField to take user type as input. */
		private JComboBox cmbUserType;
	
	/** JButton to Login using some UserName and password.*/
		private JButton btnLogin;
	/** JButton to close the form and exit from the program.*/
		private JButton btnCancel;
	
	/** Variable to create new Color object. */
	private Color txtColor;
	
	
	/**Constructor Login() of zero argument to initialize or construct the new object of Login() 
	i.e. it is initializing the values in the variables including JFrame, JPanel, JLabel, JCombobox and JButton.*/
	public Login()
	{
		frm=new JFrame();

		lblTitle=new JLabel(new ImageIcon("Images/LoginHeader.png"));
		lblUsername=new JLabel("Username");
		lblPassword=new JLabel("Password");
		lblLoginAs=new JLabel("Login As");

		tfUsername=new JTextField();
		pfPassword=new JPasswordField();

		btnLogin= new JButton("Login");
		btnCancel= new JButton("Cancel");
		jp=new JPanel();
		
		txtColor=new Color(213,239,111,255);

		String s[]={"Administrator","Warden"};
		cmbUserType=new JComboBox(s);
	}
	
	
	
	/**Public Method DisplayLogin() having zero argument and return type is void
	It is used to add the various fields of warden on the JFrame using layouts and setBounds method.*/
	public void DisplayLogin()
	{
		frm.add(jp,BorderLayout.CENTER);
		
		frm.setTitle("Login here");
		frm.setLocation(450,200);
		frm.setSize(500,400);
		frm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		jp.setLayout(null);
		jp.setBounds(0,0,400,300);
		frm.setVisible(true);

		jp.setBackground(Color.black);
		//frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		lblTitle.setBounds(0,0,500,150);
		//lblTitle.setForeground(Color.white);
		//lblTitle.setFont(new Font("Serif", Font.BOLD, 30));
		jp.add(lblTitle);
		
		//UserName
		lblUsername.setBounds(80,100,100,30);
		lblUsername.setFont(new Font("Serif", Font.BOLD, 20));
		lblUsername.setForeground(txtColor);
		jp.add(lblUsername);


		tfUsername.setBounds(220,100,150,30);
		jp.add(tfUsername);
		
		//Password
		lblPassword.setBounds(80,160,100,30);
		lblPassword.setFont(new Font("Serif", Font.BOLD, 20));
		lblPassword.setForeground(txtColor);
		jp.add(lblPassword);

		pfPassword.setBounds(220,160,150,30);
		jp.add(pfPassword);
		

		//login as
		lblLoginAs.setBounds(80,210,100,30);
		lblLoginAs.setFont(new Font("Serif", Font.BOLD, 20));
		lblLoginAs.setForeground(txtColor);
		jp.add(lblLoginAs);

		cmbUserType.setBounds(220,210,150,30);
		jp.add(cmbUserType);

		//login button
		btnLogin.setBounds(110,270,100,40);
		btnLogin.setBackground(Color.black);
		btnLogin.setForeground(txtColor);
		btnLogin.setFont(new Font("Serif", Font.BOLD, 20));
		jp.add(btnLogin);
		btnLogin.addActionListener(this);

		//cancel button
		btnCancel.setBounds(240,270,100,40);
		btnCancel.setBackground(txtColor);
		btnCancel.setForeground(Color.black);
		btnLogin.setFont(new Font("Serif", Font.BOLD, 20));
		jp.add(btnCancel);
		btnCancel.addActionListener(this);

	}
	
	
	
	/**Public Method actionPerformed(ActionEvent e) having one argument with return type as void. 
	This method is coming from ActionListener interface.
	It is used to providing the functionality to the System i.e. on click of some specific button some operation will be performed.
	All these details given by this method.
	getSource() method is used here to identify the buttons.*/
	public void actionPerformed(ActionEvent e)
	{
		if( btnLogin == e.getSource() )
		{
			if(tfUsername.getText().equals(""))
				JOptionPane.showMessageDialog(null,"Please Enter the username");
			else if(pfPassword.getText().equals(""))
				JOptionPane.showMessageDialog(null,"Please enter the password");
			else 
			{
				if(tfUsername.getText().equals("jainabhi") && pfPassword.getText().equals("9813320694") && cmbUserType.getSelectedItem().equals("Administrator"))
				{
					JOptionPane.showMessageDialog(null,"Login is successful");
					new PMSHomeScreen().DisplayScreen(); 
					frm.dispose();

				}

				else if(tfUsername.getText().equals("abhishek") && pfPassword.getText().equals("7357856040") && cmbUserType.getSelectedItem().equals("Warden"))
				{
					JOptionPane.showMessageDialog(null,"Login is successful");
					PMSHomeScreen hm=new PMSHomeScreen();
					hm.DisplayScreen();
					hm.mnWrdn.setVisible(false);
					frm.dispose();


				}

				else
					JOptionPane.showMessageDialog(null,"Incorrect Username Or Password");
			}
		}

		else if(btnCancel == e.getSource())
		{
			System.exit(0);
		}
	}


	public static void main(String[] args) 
	{
		
		Login p=new Login();
		p.DisplayLogin();
	}
}
