/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package puyo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 *
 * @author Verzach3
 */
public class Main extends PuyoEngine {



    Image background = loadImage("/resources/background-placeholder.gif");
    Puyo testPuyo = new Puyo(50, 50);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        PuyoUtil t = new PuyoUtil();
        t.demo();
        //Main main = new Main();


    }

    Main() throws IOException {
        this.init("Puyo Puyo", 600, 800);

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setBackground(Color.WHITE);
        g2D.drawImage(background, 0, 0, this.getParent());
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

        if (e.getKeyCode() == KeyEvent.VK_V ){
            testPuyo.setDrawX(testPuyo.getDrawX() + 2);

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //
    }
    
}
