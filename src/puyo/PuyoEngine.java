package puyo;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventListener;

import javax.swing.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;


public class PuyoEngine extends JPanel implements KeyListener, MouseListener {

    JFrame mainFrame = new JFrame();
    public static int FPS;

    boolean canMove = false;

    public void init(String name, int width, int height){

        initFrame(name, width, height);
        initCanvas();
        mainFrame.add(this);
        mainFrame.setVisible(true);


        loop();
    }

    public void initCanvas(){
        this.setSize(600, 800);
        this.setLayout(null);


    }

    public void initFrame(String name, int width, int height){
        mainFrame.setTitle(name);
        mainFrame.setSize(width, height);
        mainFrame.setResizable(false);
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.addKeyListener(this);
        mainFrame.addMouseListener(this);
        mainFrame.setUndecorated(true);
    }




    public void loop(){

        int fps = 0;

        long timer = System.currentTimeMillis();
        long lastTime = System.nanoTime();

        final double ns = 1000000000.0 / 60;
        double delta = 0;

        //noinspection InfiniteLoopStatement
        while(true){

            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while(delta >= 1) {
                if (fps <= 60) {
                    fps++;

                    update();
                    canMove = true;
                    mainFrame.repaint();

                    delta--;

                }
            }

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;

                FPS = fps;
                canMove = false;
                fps = 0;

            }

        }

    }

    public Image loadImage(String route){
        return new ImageIcon(Objects.requireNonNull(getClass().getResource(route))).getImage();
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
      // TODO document why this method is empty
    }

    public void update(){


    }


    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

