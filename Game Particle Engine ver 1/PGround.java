import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.*;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import javax.swing.JFrame;

public class PGround extends JApplet {

private ArrayList<Particle> particles = new ArrayList<Particle>(500);

private int x = 0;
private int y = 0;
private BufferStrategy bufferstrat = null;
private Canvas render;

JPanel ground;

	public void init()
	{
		ground = new JPanel(new GridLayout(1,1)); //y, x, pixel space

		Container c = getContentPane();
		c.add(ground);

		      super();
		      setIgnoreRepaint(true);
		      setResizable(false);

		      render = new Canvas();
		      render.setIgnoreRepaint(true);
		      int nHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		        int nWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		        nHeight /= 2;
		        nWidth /= 2;

		        setBounds(nWidth-(width/2), nHeight-(height/2), width, height);
		      render.setBounds(nWidth-(width/2), nHeight-(height/2), width, height);

		      add(render);
		      pack();
		      setVisible(true);

		      render.createBufferStrategy(2);
      bufferstrat = render.getBufferStrategy();

	}

   public static void main(String[] args)
   {
      ground.pollInput();
      ground.loop();
   }

   public void pollInput()
   {
      render.addMouseListener(new MouseListener(){

         public void mouseClicked(MouseEvent e) {
			 addParticle(true);addParticle(false);addParticle(true);
			             addParticle(false);addParticle(true);addParticle(false);
			          }

			          public void addParticle(boolean bool){
			             int dx,dy;
			             if(bool){
			                dx = (int) (Math.random()*5);
			                dy = (int) (Math.random()*5);
			             }
			             else{
			                dx = (int) (Math.random()*-5);
			                dy = (int) (Math.random()*-5);
			             }
			             int size = (int) (Math.random()*12);
			             int life = (int) Math.random()*(120)+380;
            particles.add(new Particle(x,y,dx,dy,size,life,Color.BLUE));

         }

         public void mouseEntered(MouseEvent e) {

         }

         public void mouseExited(MouseEvent e) {

         }

         public void mousePressed(MouseEvent e) {

         }

         public void mouseReleased(MouseEvent e) {

         }

      });
   }

   //This is a bad game loop example but it is quick to write and easy to understand
   //If you want to know how to do a good one use the all knowing google.
   public void loop(){
      while(true){

         update();
         render();

         try {
            Thread.sleep(1000/60);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }

   public void update(){
      Point p = render.getMousePosition();
      if(p !=null ){
         x = p.x;
         y = p.y;
      }
      for(int i = 0; i <= particles.size() - 1;i++){
         if(particles.get(i).update())
            particles.remove(i);
      }
   }

   public void render(){
      do{
         do{
            Graphics2D g2d = (Graphics2D) bufferstrat.getDrawGraphics();
               g2d.fillRect(0, 0, render.getWidth(), render.getHeight());

               renderParticles(g2d);

            g2d.dispose();
            }while(bufferstrat.contentsRestored());
             bufferstrat.show();
      }while(bufferstrat.contentsLost());
   }

   public void renderParticles(Graphics2D g2d){
      for(int i = 0; i <= particles.size() - 1;i++){
         particles.get(i).render(g2d);
      }
   }
}