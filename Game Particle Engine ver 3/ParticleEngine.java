//Particle Engine
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.ArrayList;
import java.util.Random;

public class ParticleEngine extends JApplet implements ActionListener
{
	//Global Variables
	JButton startstopwatch;
	JButton stopstopwatch;
	JButton resetstopwatch;
	JLabel stopwatchcounts;
	Timer time;
	Timer balltime;
	JLabel balllabel;
	JButton ballstart;
	JButton ballstop;
	JButton ballspeed;
	int delay = 1000;
	int delayball = 16;
	int countup = 0;
	int locx = 20;
	int locy = 20;
	int velx = -2;
	int vely = 2;
	boolean swig = true;
	ArrayList <Particle> particleList;
	Color[] hue = new Color[6];

	Random r;


	public void init()//initalize
	{
		Container c = getContentPane();
		setContentPane(new drawing_Panel());


		balltime = new Timer (delayball, this);
		balllabel = new JLabel ("Ball Options");
		ballstart = new JButton ("Start");
		ballstop = new JButton ("Stop");
		ballspeed = new JButton ("Speed");
		add(balllabel);
		add(ballstart);
		add(ballstop);
		add(ballspeed);
		ballstart.addActionListener(this);
		ballstop.addActionListener(this);
		ballspeed.addActionListener(this);
		balltime.start();
		swig = true;
		particleList = new ArrayList<Particle>();
		hue[0] = new Color(131,245,44, 100); //Green
		hue[1] = new Color(243,243,21, 100); //Yellow
		hue[2] = new Color(13,213,252, 100); //Blue
		hue[3] = new Color(255,0,153, 100); //Magenta
		hue[4] = new Color(255,103,0, 100); //Orange
		hue[5] = new Color(189, 63, 251, 100); //Purple

		r = new Random();




	}
	public class drawing_Panel extends JPanel //this is where you can draw
		{
			public void paintComponent(Graphics g)//Put your shapes in here
				{
					super.paintComponent(g);
					setBackground(Color.BLACK);
					for(int a = 0; a < particleList.size(); a++)
					{
						particleList.get(a).draw(g);
					}

				}
		}
		//Events
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == ballstart)
		{
			particleList.add(new Particle(r.nextInt(200)+ 15, r.nextInt(200)+ 10, r.nextInt(25)+1, r.nextInt(25)+1, 75, 75, hue[r.nextInt(6)]));
		}

		if(balltime.isRunning())
		{
			for(int a = 0; a < particleList.size(); a++)
			{
				particleList.get(a).movement();
			}
			repaint();
		}
		if (e.getSource() == ballstop)
		{
			particleList.add(new Particle(r.nextInt(200)+ 15, r.nextInt(200)+ 10, r.nextInt(25)+1, r.nextInt(25)+1, 75, 65, hue[r.nextInt(6)]));
		}

	}
	public class Particle
	{
		int x;
		int y;
		int dx;
		int dy;
		int w;
		int h;
		Color c;

		public Particle(int x, int y, int dx, int dy, int w, int h, Color c)
		{
			this.x = x;
			this.y = y;
			this.dx = dx;
			this.dy = dy;
			this.w = w;
			this.h = h;
			this.c = c;
			c =	c.brighter(); //makes color 10% brighter
			c =	c.brighter();
			c =	c.brighter();
			c =	c.brighter();

		}
		public void movement()
		{
			if (x <= -200 && swig == true)
			{
				dx = dx * -1;
			}
			if(x >= 2000 && swig == true)
			{
				dx = dx * -1;
			}
			if (y <= -200 && swig == true)
			{
				dy = dy * -1;
			}
			if (y >= 1000 && swig == true)
			{
				dy = dy * -1;
			}
			x = x + dx;
			y = y + dy;
		}
		public void draw(Graphics g)
		{
			g.setColor(c);
			g.fillOval(x, y, w, h);

		}
	}

	//end of program
}