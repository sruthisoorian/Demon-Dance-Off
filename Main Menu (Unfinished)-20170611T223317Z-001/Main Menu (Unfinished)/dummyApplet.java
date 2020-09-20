
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;

public class dummyApplet extends JApplet
{
	MainMenuPanel mainMenu;
	public void init()
	{
		setLayout(null);
		setBackground(Color.BLACK);
		mainMenu = new MainMenuPanel();
		add(mainMenu);
	}
}