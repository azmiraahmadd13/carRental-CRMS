package view.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.manager.CarManager;
import controller.validator.InvalidNumberException;
import controller.validator.MaximumLengthException;
import controller.validator.MaximumNumberException;
import controller.validator.MinimumNumberException;
import controller.validator.RequiredFieldException;
import controller.validator.Validator;
import model.Car;

public class AddCarDialog extends JDialog implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private JTextField txtPlateNo = new JTextField();
	private JTextField txtModel = new JTextField(15);
	private JTextField txtPrice = new JTextField();
	private JTextField txtCapacity = new JTextField();
	private JCheckBox chkAuto = new JCheckBox("Auto");
	private JCheckBox chkUsable = new JCheckBox("Yes", true);
	private JButton btnSubmit = new JButton("Submit");
	private JButton btnReset = new JButton("Reset");
	
	public AddCarDialog(ManageCarDialog dialog)
	{
		super(dialog, "Add Car", true);
		
		JPanel pnlCenter = new JPanel(new GridLayout(6, 2, 10, 10));
		JPanel pnlSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
		
		pnlCenter.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		pnlSouth.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
		
		pnlCenter.add(new JLabel("Plate Number : ", JLabel.RIGHT));
		pnlCenter.add(txtPlateNo);
		pnlCenter.add(new JLabel("Model : ", JLabel.RIGHT));
		pnlCenter.add(txtModel);
		pnlCenter.add(new JLabel("Price (RM) : ", JLabel.RIGHT));
		pnlCenter.add(txtPrice);
		pnlCenter.add(new JLabel("Capacity : ", JLabel.RIGHT));
		pnlCenter.add(txtCapacity);
		pnlCenter.add(new JLabel("Transmission : ", JLabel.RIGHT));
		pnlCenter.add(chkAuto);
		pnlCenter.add(new JLabel("Usable : ", JLabel.RIGHT));
		pnlCenter.add(chkUsable);
		
		pnlSouth.add(btnSubmit);
		pnlSouth.add(btnReset);
		
		this.add(pnlCenter);
		this.add(pnlSouth, BorderLayout.SOUTH);
		
		btnSubmit.addActionListener(this);
		btnReset.addActionListener(this);
		
		this.getRootPane().setDefaultButton(btnSubmit);
		this.setResizable(false);
		this.pack();
		//this.setSize(500, 300);
		this.setLocationRelativeTo(dialog);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) 
	{
		Object source = event.getSource();
		
		if (source == btnSubmit)
		{
			Vector<Exception> exceptions = new Vector<>();
			String plateNo = null, model = null;
			double price = 0; //Double.parseDouble(txtPrice.getText());
			int capacity = 0; // Integer.parseInt(txtCapacity.getText());
			boolean auto = chkAuto.isSelected(), Usable = chkUsable.isSelected();
			
			try 
			{
				plateNo = Validator.validate("Plate Number", txtPlateNo.getText(), true, 15);
			} 
			catch (RequiredFieldException | MaximumLengthException  e) 
			{
				exceptions.add(e);
			}
			
			try 
			{
				model = Validator.validate("Model", txtModel.getText(), true, 50);
			} 
			catch (RequiredFieldException | MaximumLengthException e) 
			{
				exceptions.add(e);
			}
			
			try 
			{
				price = Validator.validate("Price", txtPrice.getText(), true, true, true, 5,20);
			} 
			catch (RequiredFieldException | InvalidNumberException | MinimumNumberException | MaximumNumberException e) 
			{
				exceptions.add(e);
			}
			
			int size = exceptions.size();
			
			if (size == 0)
			{
			Car car = new Car();
			
			car.setPlateNo(plateNo);
			car.setModel(model);
			car.setPrice(price);
			car.setCapacity(capacity);
			car.setAuto(auto);
			car.setUsable(Usable);
			
			if (CarManager.addCar(car))
				JOptionPane.showMessageDialog(this, "Car with ID " + car.getUniqueID() + " has been successfully added.", "Success", JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(this, "Unable to add new car.", "Unsuccessful", JOptionPane.WARNING_MESSAGE);
		
			}
			else
			{
				String message = null;
				
				if ( size == 1)
					message = exceptions.firstElement().getMessage();
				else
				{
					message = " Please fix the following errors : ";
					
					for (int i = 0; i < size ; i++)
						message += "\n" + exceptions.get(i).getMessage();
				}
				
				JOptionPane.showMessageDialog(this, message, "Validation Error", JOptionPane.WARNING_MESSAGE);
			}
		}
		else if (source == btnReset)
		{
			txtPlateNo.setText("");
			txtModel.setText("");
			txtPrice.setText("");
			txtCapacity.setText("");
			chkAuto.setSelected(false);
			chkUsable.setSelected(true);
			txtPlateNo.grabFocus();
		}
	}

}
