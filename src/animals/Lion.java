package animals;
import food.EFoodType;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import food.IEdible;
import graphics.ZooPanel;
import mobility.Point;
import utilities.MessageUtility;
import java.util.Random;

import javax.imageio.ImageIO;

import diet.Carnivore;
/**
 * Lion class related to animal and AnimalThatRoars.
 * @author Mahdi
 *
 */
public class Lion extends AnimalThatRoars
{
	/**
 *
	*/
	
	
	private int scarCount;
	
	public Lion(int Size,int HSpeed, int VSpeed, String color ,ZooPanel panel,Point location)
	{
		 super(Size, HSpeed,VSpeed,color,panel,location); 
		 this.loadImages("lio_");  
	}
	
	
	/**
	 * 
	 * @param name
	 */
	/*public Lion(String name, Color clr,ZooPanel pan)
	{
		super(name, new Point(20, 0),clr,pan);
		scarCount = 0;
		MessageUtility.logConstractor(this.getClass().getSimpleName(),name);
		setWeight(408.2);
		this.setDiet(new Carnivore());
	}*/
	

	
	
	
	/**
	 * eat function to check if the animal can eat specific food which is reiceved as argument 'type'.
	 */
	/*public boolean eat(IEdible type)
	{		
		boolean res=false;
		res=super.eat(type);
		if(res)
		{
			this.setScars();
		}
		MessageUtility.logBooleanFunction(name, "eat", type, res); //added by me
		return res;
	}*/
	/**
	 * setScars of lion function , counter is inccremented by 1 if rand equals 1. 
	 * @return res - result true/false.
	 */
	public boolean setScars()
	{
		int x = (Math.random() < 0.5) ? 0:1;
		boolean res = false;
		int tempscar = this.scarCount+1;
		if(x == 1)
		{
			this.scarCount++;
			res = true;
		}
		MessageUtility.logSetter(name, "setScars", tempscar, res);
		return res;
	}
	@Override
	/**
	 * getFoodtype-returns the animal food type.
	 */
	public EFoodType getFoodtype()
	{
		MessageUtility.logGetter(name, "getFoodType", EFoodType.NOTFOOD);
		return EFoodType.NOTFOOD;
	}
	/**
	 * roar function.
	 */
	public void roar() {MessageUtility.logSound(name, "Roars, then stretches and shakes its mane");}
} //public class Lion extends AnimalThatRoars