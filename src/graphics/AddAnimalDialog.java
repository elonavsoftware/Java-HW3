package graphics;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import com.sun.prism.Graphics;
import com.sun.prism.Image;


public class AddAnimalDialog extends JDialog implements ActionListener 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ZooFrame zooFrm;
	private ZooPanel panel;
	private String[]Animals={"Bear","Girrafe","Lion","Turtle","Elephant"};
	private JLabel label;
	private JComboBox<String> c1,c2,c3,c4;
	private JButton OK,Cancel;
	public AddAnimalDialog(ZooFrame parent,ZooPanel pan)
	{
		super(parent,"Add Animal Dialog");
		zooFrm=parent;
		//////////////////////////////
		OK=new JButton("OK");
		Cancel=new JButton("Cancel");
		OK.addActionListener(this);
		Cancel.addActionListener(this);
		//////////////////////////////
		this.panel=pan;
		JPanel panel = new JPanel();
		parent.add(panel);
		panel.setLayout(new FlowLayout());
		CallMethods();
		this.add(panel);
		
		this.setVisible(true);
		this.setSize(1000, 800);  
	}
	private void  CallMethods(){
		AnimalKind();
		AddButtons();
	}

	private void AddButtons(){
		this.OK.setBounds(400,450,150,30);
		this.Cancel.setBounds(600,450,150,30);
		this.add(OK);
		this.add(Cancel);
	}
	private void AnimalKind()
	{		
		this.label=new JLabel("Select Animal:");
		this.setLayout(null);
		this.add(label);
		this.label.setBounds(10, 10, 100, 50);
		this.c1=new JComboBox<String>(Animals);		
		this.c1.setBounds(170, 20, 150, 30);		
		this.add(c1);	

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==OK)
		{
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


