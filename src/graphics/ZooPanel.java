package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.color.ColorSpace;
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

import animals.Animal;
import animals.Bear;
import utilities.Point;


public class ZooPanel extends JPanel implements ActionListener, Runnable
{
	private BufferedImage background;
	 Animal bear;

	//BufferedImage Limg,Rimg;
	//animal path:
    static String BearImg = "C:\\Users\\User\\Desktop\\animals\\bear\\bear_r.gif";
    final static String ElephantImg = "D:\\MihlalaSCE\\TihnutMitkadem\\labs\\lab06\\GUIExamples\\phases\\";
    final static String LionImg = "D:\\MihlalaSCE\\TihnutMitkadem\\labs\\lab06\\GUIExamples\\phases\\";
    final static String GirrafeImg = "D:\\MihlalaSCE\\TihnutMitkadem\\labs\\lab06\\GUIExamples\\phases\\";
    final static String TurtleImg = "D:\\MihlalaSCE\\TihnutMitkadem\\labs\\lab06\\GUIExamples\\phases\\";
    final static String SafariImg = "C:\\Users\\User\\Desktop\\animals\\safari\\safari.gif";

    

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
		JPanel subpanel=new JPanel(); //adding to this subpanel the buttons to make it in SOUTH position.
		this.setLayout( new BorderLayout() );
		GridLayout GridL=new GridLayout(1,7);
		subpanel.setLayout(GridL);
		for(i=0;i<buttonNames.length;i++)
		{			
			bi[i]=new JButton(buttonNames[i]);// the Button name
			bi[i].setPreferredSize(new Dimension(110,23));
			bi[i].setBounds(x, 610, 110, 23);
			bi[i].addActionListener(this);// to set the button in Acttion lisetener			
			x+=100;// this is about crodinat x in the panel (the palce of button)
			subpanel.add(bi[i]);  
		}		
		this.add(subpanel, BorderLayout.SOUTH);
	}
	public void setBackgr(int num){
		if(num==0)// if we select the blue
		{
	    	try {

	    		background = ImageIO.read(new File(SafariImg));
	    		repaint();
			} 
	    	catch (IOException e) {
				e.printStackTrace();
			}
			setLayout(null);
			flag=false;
			setBackground(null);// we clean the background
			this.paintComponent(this.getGraphics());
			setBackground(Color.GREEN);			
		}
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
	public void setAnimal(String animal)
	{
		if(animal=="Bear")
		{

	    }
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
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
			if(e.getSource()==bi[0]) //add animal button.
			{
				if(Counter<10)
				{
				Counter++;
				jdialog=new AddAnimalDialog(this.ZooFrm,this);
				jdialog.setSize(800, 550);
				}
				else{
					//ERROR
					JOptionPane.showMessageDialog(this, "You cannot add more than 10 animals");
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
	public void paintComponent(java.awt.Graphics g)
	{
	    super.paintComponent(g);
		if(background != null)
		    g.drawImage(background, 20, 35, getWidth(),getHeight(), this);
    }


} 
//class ZooPanel extends JPanel implements Runnable