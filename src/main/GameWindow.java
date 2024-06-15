package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static utilz.Constants.GameWindowConstants.*;

public class GameWindow extends JFrame {
    //1920x1080
    private GamePanel gamePanel;
    private Instructions instructions;
    private MainMenu menu;

    public GameWindow(){
       this.setTitle("Dangerous Fishing");

      this.setLayout(new BorderLayout());
      menu = new MainMenu(this);
      add(menu,BorderLayout.CENTER);
      this.setSize(GAME_WINDOW_WIDTH,GAME_WINDOW_HEIGHT);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.setLocationRelativeTo(null);
      this.setVisible(true);
    }


    public void showGamePanel() {
        getContentPane().remove(menu);
        gamePanel = new GamePanel();
        add(gamePanel, BorderLayout.CENTER);
        gamePanel.requestFocusInWindow();
        update();
    }

    public void showInstructions(){
        getContentPane().remove(menu);
        instructions = new main.Instructions(this);
        add(instructions,BorderLayout.CENTER);
        update();
    }

    public void showMainMenu(){
        getContentPane().remove(instructions);
        menu = new MainMenu(this);
        add(menu,BorderLayout.CENTER);
        update();

    }

    public void update(){
        revalidate();
        repaint();
    }
}



