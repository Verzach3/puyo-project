/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package puyo;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 *
 * @author Verzach3
 */
public class Main extends MiniEngine{



    Puyo testPuyo = new Puyo(50, 50);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //ConsoleTetris t = new ConsoleTetris();
        //t.demo();
        Main main = new Main();


    }

    Main(){
        this.init("Puyo Puyo", 600, 800);

    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setBackground(Color.WHITE);
        testPuyo.drawComponent(g2D);



    }

    @Override
    public void update(){

    }

    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

        if (e.getKeyCode() == KeyEvent.VK_V ){
            testPuyo.setDrawX(testPuyo.getDrawX() + 2);

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }
    
}
