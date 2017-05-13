package graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import animals.Animal;
import animals.Bear;


public class AddAnimalDialog extends JDialog implements ActionListener 
{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ZooFrame zooFrm;
	private ZooPanel panel;
	private String[]Animals={"Bear","Girrafe","Lion","Turtle","Elephant"};
	private String[]Colors={"Red","Blue","Natural"};
	private JLabel label;
	private JComboBox<String> c1,c2,HspeedCombo,VspeedCombo;
	private String[] HorizontalSpeed ={"1","2","3","4","5","6","7","8","9","10"};
	private String[]VerticalSpeed={"1","2","3","4","5","6","7","8","9","10"};
	private JButton OK,Cancel;
	private JTextField AnimalSizeTextBox;

	private Animal Bear;
	public AddAnimalDialog(ZooFrame parent,ZooPanel pan)
	{
		super(parent,"Add Animal Dialog");
		zooFrm=parent;
		////////////////////////////////////////////////////////
		OK=new JButton("OK");
		Cancel=new JButton("Cancel");
		OK.addActionListener(this);
		Cancel.addActionListener(this);
		////////////////////////////////////////////////////////
		this.panel=pan;			
		///////////////////////////////////////////////////////
		
		this.setLayout(new GridLayout(6,2));
		JPanel TypeAndComboPanel= new JPanel();
		JPanel AnimalSizePanel = new JPanel();
		JPanel HSpeedPanel= new JPanel();
		JPanel VSpeedPanel= new JPanel();
		JPanel ColorPanel= new JPanel();
		JPanel ButtonPanel = new JPanel();

		
		//Labels
		JLabel AnimalTypeLbl = new JLabel("Choose Animal Type:");		
		JLabel AnimalSizeLbl = new JLabel("Enter Animal Size (Between 50-300):");		
		JLabel HorizontalspeedLbl= new JLabel("Enter Horizontal Speed (Between 1-10):");		
		JLabel VerticalspeedLbl= new JLabel("Enter Vertical Speed (Between 1-10):");		
		JLabel Colorlbl=new JLabel("Choose Color:");
        AnimalSizeTextBox = new JTextField("Value");

        
		this.c1=new JComboBox<String>(Animals);		
		this.c2=new JComboBox<String>(Colors);		
		this.HspeedCombo=new JComboBox<String>(HorizontalSpeed);		
		this.VspeedCombo=new JComboBox<String>(VerticalSpeed);		

		TypeAndComboPanel.add(AnimalTypeLbl); //adding the lbl 
		TypeAndComboPanel.add(c1); //adding the Combobox 
		
		AnimalSizePanel.add(AnimalSizeLbl);
		AnimalSizePanel.add(AnimalSizeTextBox);
		
		HSpeedPanel.add(HorizontalspeedLbl);
		HSpeedPanel.add(HspeedCombo);
		
		VSpeedPanel.add(VerticalspeedLbl);
		VSpeedPanel.add(VspeedCombo);

		ColorPanel.add(Colorlbl);
		ColorPanel.add(c2);
		
		ButtonPanel.add(OK);
		ButtonPanel.add(Cancel);
		
		
		/////////////////////////////////////////////////////
		this.add(TypeAndComboPanel);	
		this.add(AnimalSizePanel);
		this.add(HSpeedPanel);
		this.add(VSpeedPanel);
		this.add(ColorPanel);
		this.add(ButtonPanel);
		////////////////////////////////////////////////////
		this.setVisible(true);
		this.setSize(250, 180);  
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==OK)
		{
			
			//checking input validity
			try
			{
			if(Integer.parseInt(AnimalSizeTextBox.getText())<50 || Integer.parseInt(AnimalSizeTextBox.getText())>300)
			{
				JOptionPane.showMessageDialog(this, "The Size that you'v entered is not valid!");
				return;
			}

		    }catch (NumberFormatException ee) {
				    JOptionPane.showMessageDialog(this, "Invalid Input, enter numbers only!");
				    return;
			}
			
			//choose the animal then add it to the main frame.
			String animal=(String)c1.getSelectedItem();
			if(animal=="Bear")
			{
		    	panel.setAnimal("Bear");
			}
			else if(animal=="Girrafe")
			{			
			    panel.setAnimal("Girrafe");
			}
			else if(animal=="Lion")
			{
				panel.setAnimal("Lion");
			}
			else if(animal=="Elephant")
			{
				panel.setAnimal("Elephant");
			}
			else if(animal=="Turtle")
			{
				panel.setAnimal("Turtle");
			}
			this.dispose();
		}
		else if(e.getSource()==Cancel)
		{
			panel.Counter=panel.Counter-1; 
			//do nothing.
			this.dispose();
		}
	}
} //class AddAnimalDialog extends JDialog


