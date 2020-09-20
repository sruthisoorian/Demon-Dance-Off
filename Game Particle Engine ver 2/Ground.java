import java.applet.Applet;
import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.awt.event.*;

public class Ground extends JApplet implements ActionListener, MouseListener
{
	//create global variables here

	JButton clear;
	JLabel perimeter;
	int mx;
	int my;

	Particle p1;
	boolean made = false;


	public void init()
	{
		//initialize the User Interface and listeners
		Container c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.RIGHT));
		setContentPane(new drawing_Panel());
		addMouseListener(this);
	}

public class drawing_Panel extends JPanel //This is where you can draw
			{
				public void paintComponent(Graphics g)//Put your shapes in here
				{
					super.paintComponent(g);
					if(made == true)
					{

					}


				}
		}

public void actionPerformed(ActionEvent e)
	{
	}
public void mouseClicked (MouseEvent e)
	{
		mx = e.getX();
		my = e.getY();
	}
public void mousePressed (MouseEvent e)
	{
	}
public void mouseReleased (MouseEvent e)
	{
		repaint();
	}
public void mouseEntered (MouseEvent e)
	{
	}
public void mouseExited (MouseEvent e)
	{
	}
public void loop()
	{
		while(true)
		{
			update();
			render();
		}
	}
public void update()
{
	int x = mx;
	int y = my;

}
public void render()
{

}




}
