package puyo;

import javax.swing.*;
import java.io.File;

public class FileTest extends JFrame {

    JButton button = new JButton();

    public static void main(String[] args) {
        FileTest fileTest = new FileTest();

    }

    FileTest(){
        button.setText("Boton");
        button.setSize(50, 10);
        button.addActionListener(e -> System.out.println("Hola"));

        this.setSize(800, 600);
        this.setName("Test");
        this.add(button);
        this.setVisible(true);
    }
}
