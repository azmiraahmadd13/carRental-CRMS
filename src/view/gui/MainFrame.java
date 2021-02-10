package view.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame implements ActionListener 
{
	private static final long serialVersionUID = 1L;
	
	private JButton btnManageCars = new JButton("Manage Cars");
	private JButton btnManageCustomers = new JButton("Manage Customers");
	private JButton btnManagerRentals = new JButton("Manage Rentals");
	
	public MainFrame() 
	{
		super("Car Rental Management System");
		
		GridLayout layout = new GridLayout(3, 1);
		
		btnManageCars.addActionListener(this);
		btnManageCustomers.addActionListener(this);
		btnManagerRentals.addActionListener(this);
		
		this.add(btnManageCars);
		this.add(btnManageCustomers);
		this.add(btnManagerRentals);
		
		this.setSize(300, 200);
		this.setLayout(layout);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) 
	{
		Object source = event.getSource();
		
		if (source == btnManageCars)
			new ManageCarDialog(this);
	}
	
	public static void main(String[] args)
	{
		new MainFrame();
	}

}
