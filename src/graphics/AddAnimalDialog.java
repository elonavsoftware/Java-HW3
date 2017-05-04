package graphics;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
public class AddAnimalDialog extends JDialog
{
	public AddAnimalDialog(JFrame parent,String title,String message)
	{
		super(parent, title);
		JPanel panel = new JPanel();
		parent.add(panel);
		JRadioButton Turtle=new JRadioButton("Turtle");    
		JRadioButton Elephant=new JRadioButton("Elephant");    
		JRadioButton Lion=new JRadioButton("Lion");    
		JRadioButton Girrafe=new JRadioButton("Girrafe");  
		JRadioButton Bear=new JRadioButton("Bear");
		ButtonGroup group = new ButtonGroup();			
		
        //adding these buttons to our frame.
		group.add(Turtle);
		group.add(Bear);
		group.add(Lion);
		group.add(Elephant);
		group.add(Girrafe);
		panel.setLayout(new FlowLayout());
		
		panel.add(Turtle);
		panel.add(Bear);
		panel.add(Lion);
		panel.add(Elephant);
		panel.add(Girrafe);
		
		this.add(panel);
		this.setVisible(true);
		this.setSize(500, 400);  
	}
	
} //class AddAnimalDialog extends JDialog