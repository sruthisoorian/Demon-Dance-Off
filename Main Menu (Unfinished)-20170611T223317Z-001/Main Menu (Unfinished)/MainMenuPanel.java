//Nayef Kiame
//Java Final

import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.util.ArrayList;
import java.util.Random;

public class MainMenuPanel extends JPanel implements ActionListener
{
	private JPanel p1; //main screen
	private JPanel p1a; //main screen top half
	private JPanel p1b; //main screen bottom half
	private JPanel p1a1;//main screen top half button panel
	private JPanel p1b1; //main screen bottom half buttom panel
	private JPanel p2; //instructions
	private JPanel p3; //credits
	private JPanel p3a; //credits buttom panel

	private JButton play;
	private JButton help;
	private JButton cred;
	private JButton exit;
	private JButton exit2;

	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	private JLabel l4;
	private JLabel logo;
	private JLabel complogo;

	private ImageIcon i1;
	private ImageIcon i2;
	private ImageIcon i3;
	private ImageIcon i4;
	private ImageIcon i5;
	private ImageIcon i6;
	private ImageIcon i7;
	private ImageIcon i8;

	private ImageIcon TLogo;
	private ImageIcon FFJL;

	AudioClip TitleTheme;

	public MainMenuPanel()//public MainMenuPanel(){}
	{
		//Initilize
		i1 = new ImageIcon("playbutton.png");
		i2 = new ImageIcon("helpbutton.png");
		i3 = new ImageIcon("credbutton.png");
		i4 = new ImageIcon("tristannew.png");
		i5 = new ImageIcon("sooriannew.png");
		i6 = new ImageIcon("nkiamenew.png");
		i7 = new ImageIcon("afanellinew.png");
		i8 = new ImageIcon("exitbutton.png");

		TLogo = new ImageIcon("TitleLogo.png");
		FFJL = new ImageIcon("FFLogoCreds.png");


 		l1 = new JLabel(i4);
 		l2 = new JLabel(i5);
 		l3 = new JLabel(i6);
 		l4 = new JLabel(i7);
 		logo = new JLabel(TLogo);
 		complogo = new JLabel(FFJL);

		//Buttons
 		play = new JButton(i1);
 		help = new JButton(i2);
 		cred = new JButton(i3);
 		exit = new JButton(i8);
 		exit2 = new JButton(i8);

		//Panel 1
 		p1 = new JPanel(new GridLayout(2, 1));
 		p1a = new JPanel(new FlowLayout());
 		p1a1 = new JPanel(new GridLayout(1,1));
 		p1b = new JPanel(new FlowLayout());
 		p1b1 = new JPanel(new GridLayout(3, 1));


		add(p1);
		p1.add(p1a);
		p1.add(p1b);
		p1b.add(p1b1);
		p1a.add(p1a1);
		p1a1.add(logo);
 		p1b1.add(play);
 		p1b1.add(help);
 		p1b1.add(cred);

		//Panel 2
 		p2 = new JPanel(new FlowLayout());
		p2.add(exit2);

		//Panel 3
 		p3 = new JPanel(new FlowLayout());
 		p3a = new JPanel(new GridLayout(6, 1));
		p3.add(p3a);
		p3a.add(l1);
		p3a.add(l2);
		p3a.add(l3);
		p3a.add(l4);
		p3a.add(exit);
		p3.add(complogo);

		//Color
		setBackground(Color.BLACK);
 		p1a.setBackground(Color.BLACK);//Top Panel
		p1b.setBackground(Color.BLACK);//Bottom Panel
		p2.setBackground(Color.BLACK);
		p3.setBackground(Color.GRAY);
		p3a.setBackground(Color.GRAY);
		play.setBackground(Color.BLACK);
		help.setBackground(Color.BLACK);
		cred.setBackground(Color.BLACK);
		exit.setBackground(Color.BLACK);
		exit2.setBackground(Color.BLACK);

		//Visiblity
		p1.setVisible(true);
		p2.setVisible(false);
		p3.setVisible(false);

 		//Action Listener
 		play.addActionListener(this);
 		help.addActionListener(this);
 		cred.addActionListener(this);
 		exit.addActionListener(this);
 		exit2.addActionListener(this);

 		//Audio
// 		TitleTheme = getAudioClip(getDocumentBase(), "MainMusicLoop3.wav");
// 		TitleTheme.loop();


		//Size
		setSize(1270, 900);
	}

	public void actionPerformed(ActionEvent e)
	{
		//===========================================================
		if (e.getSource() == play)
		{
			//TitleTheme.stop();
			p1.setVisible(false);
			p2.setVisible(false);
			p3.setVisible(false);
			repaint();
		}
		//===========================================================
		if (e.getSource() == help)
		{
			add(p2);
			p1.setVisible(false);
			p2.setVisible(true);
			p3.setVisible(false);
			repaint();
		}
		//===========================================================
		if (e.getSource() == cred)
		{
			add(p3);
			p1.setVisible(false);
			p2.setVisible(false);
			p3.setVisible(true);
			repaint();
		}
		//===========================================================
		if (e.getSource() == exit)
		{
			add(p1);
			p1.setVisible(true);
			p2.setVisible(false);
			p3.setVisible(false);
			repaint();
		}
		if (e.getSource() == exit2)
		{
			add(p1);
			p1.setVisible(true);
			p2.setVisible(false);
			p3.setVisible(false);
			repaint();
		}
		//===========================================================
	}


}//end of program