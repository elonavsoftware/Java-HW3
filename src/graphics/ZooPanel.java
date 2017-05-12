package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sun.prism.Graphics;
import com.sun.prism.Image;


public class ZooPanel extends JPanel implements ActionListener, Runnable
{
	private BufferedImage Limg;

	//BufferedImage Limg,Rimg;
	//animal path:
    final static String BearImg = "C:\\Users\\User\\Desktop\\animals\\bear\\0.gif";
    final static String ElephantImg = "D:\\MihlalaSCE\\TihnutMitkadem\\labs\\lab06\\GUIExamples\\phases\\";
    final static String LionImg = "D:\\MihlalaSCE\\TihnutMitkadem\\labs\\lab06\\GUIExamples\\phases\\";
    final static String GirrafeImg = "D:\\MihlalaSCE\\TihnutMitkadem\\labs\\lab06\\GUIExamples\\phases\\";
    final static String TurtleImg = "D:\\MihlalaSCE\\TihnutMitkadem\\labs\\lab06\\GUIExamples\\phases\\";


	static int Counter=0;
	private Boolean flag=false;
	private String[]buttonNames={"Add Animal","Sleep","Wake Up","Clear","Food","Info","Exit"};
	private JButton[] bi;
	ZooFrame ZooFrm;
	JDialog jdialog;
	//Constructor
	public ZooPanel(ZooFrame zooframe)
	{
		bi=new JButton[buttonNames.length];// array of JButton
		
		createbtn();
		this.ZooFrm=zooframe;
		
	}
	public void createbtn(){
		int i,x=0;
		BorderLayout myBorderLayout = new BorderLayout(); 
	
		for(i=0;i<buttonNames.length;i++)
		{
			bi[i]=new JButton(buttonNames[i]);// the Button name
			bi[i].setPreferredSize(new Dimension(110,23));// size of button
			bi[i].setBounds(x, 515, 110, 23);// size of button
			bi[i].addActionListener(this);// to set the button in Acttion lisetener
			
			x+=100;// this is about crodinat x in the panel (the palce of button)
			this.add(bi[i],BorderLayout.SOUTH);

		}
		this.setLayout(myBorderLayout);

	}

	public void setBackgr(int num){
		if(num==1)// if we select the blue
		{
			setLayout(null);
			flag=false;
			setBackground(null);// we clean the background
			this.paintComponent(this.getGraphics());
			setBackground(Color.GREEN);
			
		}
		else if(num==2)//if we select the image
		{
			
			setLayout(null);
			flag=true;
			setBackground(null);// clean the Background
			this.paintComponent(this.getGraphics());
		}
		else{// if we select the None
			flag=false;
			setBackground(null);// set background none
		}
	}


	public void setAnimal(String animal){
		if(animal=="Bear")
		{
			JOptionPane.showMessageDialog(this, "trying to paint animal:"+animal);
	    	try {
	    		Limg = ImageIO.read(new File(BearImg));
				repaint();
				
			} 
	    	catch (IOException e) {
				e.printStackTrace();				
			}		}
		else if(animal=="Girrafe")
		{			
		}
		else if(animal=="Lion")
		{

		}
		else if(animal=="Elephant")
		{

		}
		else if(animal=="Turtle")
		{

		}
	}

	@Override
	public void run()
	{
		//needs to be done!
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
			if(e.getSource()==bi[0]) //add animal button.
			{
				if(Counter<2)
				{
				Counter++;
				jdialog=new AddAnimalDialog(this.ZooFrm,this);
				jdialog.setSize(800, 550);
				}
				else{
					//ERROR
					JOptionPane.showMessageDialog(this, "ERROR:You have used the max number of animals!!");

				}
			}
		
		else if(e.getSource()==bi[1]) //Sleep
		{

		}
		else if(e.getSource()==bi[2]) //Wake up
		{
			
		}
		else if(e.getSource()==bi[3]) //clear
		{
			
		}
		else if(e.getSource()==bi[4]) //food
		{
			
		}
		else if(e.getSource()==bi[5]) //info
		{
			
		}
		else if(e.getSource()==bi[6])//exit button
		{
			System.exit(0);
		}
	}	
	public void paintComponent(Graphics g) {
		
	    super.paintComponent((java.awt.Graphics) g);
	    Dimension dm = getSize();
		
		if(Limg != null)
		    ((java.awt.Graphics) g).drawImage(Limg, 20, 35, dm.width-40, dm.height-55, this);
   }

} 
//class ZooPanel extends JPanel implements Runnable