package view.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

public class ManageCarDialog extends JDialog implements ActionListener 
{
	private static final long serialVersionUID = 1L;
	
	private JButton btnAddCar = new JButton("Add car");
	private JButton btnUpdateCar = new JButton("Update car");
	private JButton btnDeleteCar = new JButton("Delete car");
	private JButton btnViewAllCars = new JButton("View all car");
	private JButton btnViewCarsbyMaxPrice = new JButton("View cars by Maximum Price");
	private JButton btnViewCarsbyMinCapacity = new JButton("View cars by Minimum Capacity");
	private JButton btnViewCarsbyTransmission = new JButton("View Cars by Transmission");
	private JButton btnViewCarsbyModel = new JButton("View Cars by Model");
	
	public ManageCarDialog(MainFrame frame) 
	{
		super(frame, "Manage Cars", true);
		
		GridLayout layout = new GridLayout(4, 2);
		
		btnAddCar.addActionListener(this);
		btnUpdateCar.addActionListener(this);
		btnDeleteCar.addActionListener(this);
		btnViewAllCars.addActionListener(this);
		btnViewCarsbyMaxPrice.addActionListener(this);
		btnViewCarsbyMinCapacity.addActionListener(this);
		btnViewCarsbyTransmission.addActionListener(this);
		btnViewCarsbyModel.addActionListener(this);
		
		this.add(btnAddCar);
		this.add(btnUpdateCar);
		this.add(btnDeleteCar);
		this.add(btnViewAllCars);
		this.add(btnViewCarsbyMaxPrice);
		this.add(btnViewCarsbyMinCapacity);
		this.add(btnViewCarsbyTransmission);
		this.add(btnViewCarsbyModel);
		
		this.setLayout(layout);
		this.pack();
		//this.setSize(500, 200);
		this.setLocationRelativeTo(frame);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event)
	{
		Object source = event.getSource();
		
		if (source == btnAddCar)
			new AddCarDialog(this);
	}

}
