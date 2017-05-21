package graphics;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import animals.Animal;
import animals.Bear;
import animals.Elephant;
import animals.Giraffe;
import animals.Lion;
import animals.Turtle;
import mobility.Point;

public class AddAnimalDialog extends JDialog implements ActionListener 
{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ZooFrame zooFrame;
	private ZooPanel dialogPanel;
	private String[] Animals = {"Bear", "Girrafe", "Lion", "Turtle", "Elephant"};
	private String[] Colors = {"Red", "Blue", "Natural"};
	private JLabel label;
	private JComboBox<String> c1, c2, HspeedCombo, VspeedCombo;
	private String[] HorizontalSpeed = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
	private String[] VerticalSpeed = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
	private JButton OK, Cancel;
	private JTextField AnimalSizeTextBox;
	public AddAnimalDialog(ZooFrame parent,ZooPanel pan)
	{
		super(parent,"Add Animal Dialog");
		zooFrame = parent;
		////////////////////////////////////////////////////////
		OK = new JButton("OK");
		Cancel = new JButton("Cancel");
		OK.addActionListener(this);
		Cancel.addActionListener(this);
		////////////////////////////////////////////////////////
		this.dialogPanel = pan;			
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
		JLabel colorLabel = new JLabel("Choose Color:");
        AnimalSizeTextBox = new JTextField("50");

        
		this.c1 = new JComboBox<String>(Animals);		
		this.c2 = new JComboBox<String>(Colors);		
		this.HspeedCombo = new JComboBox<String>(HorizontalSpeed);		
		this.VspeedCombo = new JComboBox<String>(VerticalSpeed);		

		TypeAndComboPanel.add(AnimalTypeLbl); //adding the label 
		TypeAndComboPanel.add(c1); //adding the Combo box 
		
		AnimalSizePanel.add(AnimalSizeLbl);
		AnimalSizePanel.add(AnimalSizeTextBox);
		
		HSpeedPanel.add(HorizontalspeedLbl);
		HSpeedPanel.add(HspeedCombo);
		
		VSpeedPanel.add(VerticalspeedLbl);
		VSpeedPanel.add(VspeedCombo);

		ColorPanel.add(colorLabel);
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
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == OK)
		{
			//checking input validity
			try
			{
				if(Integer.parseInt(AnimalSizeTextBox.getText()) < 50 || Integer.parseInt(AnimalSizeTextBox.getText()) > 300)
				{
					JOptionPane.showMessageDialog(this, "The Size that you'v entered is not valid!");
					return;
				}	
		    }
			catch (NumberFormatException ee)
			{
				    JOptionPane.showMessageDialog(this, "Invalid Input, enter numbers only!");
				    return;
			}
			
			//choose the animal then add it to the main frame.
			String animal = (String)c1.getSelectedItem();		
			int hSpeed, vSpeed, size;
			String clr;			
			hSpeed = Integer.parseInt((String) VspeedCombo.getSelectedItem());
			vSpeed = Integer.parseInt((String) VspeedCombo.getSelectedItem());
			clr = c2.getSelectedItem().toString();
			size = Integer.parseInt(AnimalSizeTextBox.getText());
			if(animal == "Bear")
			{
				dialogPanel.addanimal(new Bear(size, hSpeed, vSpeed, clr, this.dialogPanel, new Point(0, 0)));
			}
			else if(animal == "Girrafe")
			{		
				dialogPanel.addanimal(new Giraffe(size, hSpeed, vSpeed, clr, this.dialogPanel, new Point(0, 0)));

			}
			else if(animal == "Lion")
			{
				dialogPanel.addanimal(new Lion(size, hSpeed, vSpeed, clr, this.dialogPanel, new Point(0, 0)));
			}
			else if(animal == "Elephant")
			{
				dialogPanel.addanimal(new Elephant(size, hSpeed, vSpeed, clr, this.dialogPanel, new Point(0, 0)));

			}
			else if(animal == "Turtle")
			{
				dialogPanel.addanimal(new Turtle(size, hSpeed, vSpeed, clr, this.dialogPanel, new Point(0, 0)));

			}
			this.dispose();
		}
		else if(e.getSource() == Cancel)
		{
			dialogPanel.Counter = dialogPanel.Counter - 1; 
			//do nothing.
			this.dispose();
		}
	}
} //class AddAnimalDialog extends JDialog implements ActionListener 


