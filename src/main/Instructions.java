package main;
import javax.swing.*;
import java.awt.*;
import static utilz.Constants.Images.*;
import static utilz.Constants.InstructionsConstants.*;
import static utilz.Constants.Text.*;

public class Instructions extends JPanel {
    private Image instructionsBackGround;
    private Image yellowFish;
    private Image bonusFish;
    private Image sharkImage;
    private Image pufferFishImage;
    private GameWindow window;

    public Instructions(GameWindow window) {
        this.window = window;

        this.instructionsBackGround = new ImageIcon(INSTRUCTIONS_BACK_GROUND).getImage();
        this.setSize(WIDTH, HEIGHT);

        JLabel title = new JLabel(TITLE_TEXT);
        title.setSize(TITLE_WIDTH, TITLE_HEIGHT);
        title.setBounds(400, 10, (TITLE_WIDTH * 3), TITLE_HEIGHT);
        Font fontTitle = new Font("Arial", Font.BOLD, 35);
        title.setFont(fontTitle);

        JTextArea instructions = new JTextArea(10, 20);
        instructions.setText(INSTRUCTIONS_TEXT);
        Font font = new Font("Arial", Font.BOLD, 18);
        instructions.setFont(font);
        instructions.setForeground(Color.WHITE);
        instructions.setBounds(165, 250, 985, 412);
        instructions.setBackground(new Color(50, 75, 150, 190));

        JButton backToMainMenu = new JButton();
        backToMainMenu.setText("Back to Main Menu");
        backToMainMenu.setFont(font);
        backToMainMenu.setForeground(Color.BLACK);
        backToMainMenu.setBounds((int) (INSTRUCTIONS_WIDTH/ POS) - 400, (int) (INSTRUCTIONS_HEIGHT/ POS) + 50, 300, 100);
        backToMainMenu.setContentAreaFilled(false);
        backToMainMenu.addActionListener(e -> {
            window.showMainMenu();
        });

        this.add(backToMainMenu);

        JLabel sharkLabel = new JLabel("Shark");
        setJLabelFish(sharkLabel,800);

        JLabel pufferFishLabel = new JLabel("Puffer Fish");
        setJLabelFish(pufferFishLabel,1015);

        JLabel yellowFishLabel = new JLabel("Regular Fish");
        setJLabelFish(yellowFishLabel,230);

        JLabel bonusFishLabel = new JLabel("Bonus Fish");
        setJLabelFish(bonusFishLabel,490);

        this.yellowFish = new ImageIcon(YELLOW_FISH).getImage();
        this.bonusFish = new ImageIcon(BONUS_FISH).getImage();
        this.sharkImage = new ImageIcon(SHARK_IMAGE).getImage();
        this.pufferFishImage = new ImageIcon(PUFFER_FISH_IMAGE).getImage();

        this.add(instructions);
        this.add(title);
        this.setLayout(null);
        this.setVisible(true);
    }

    public void setJLabelFish(JLabel type, int x){
        type.setSize(SUB_TITLES_SIZE, SUB_TITLES_SIZE);
        type.setBounds(x, IMAGE_LABEL_HEIGHT, SUB_TITLES_SIZE, SUB_TITLES_SIZE);
        this.add(type);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(instructionsBackGround, 0, 0, INSTRUCTIONS_WIDTH, INSTRUCTIONS_HEIGHT, null);
        g.drawImage(yellowFish, FISH_X, FISH_Y + 30, FISH_WIDTH + 20, FISH_HEIGHT + 40, null);
        g.drawImage(bonusFish, (FISH_X * 2) + 50, FISH_Y + 60, FISH_WIDTH + 20, FISH_HEIGHT - 18 , null);
        g.drawImage(sharkImage, (FISH_X * 3)+ 100, FISH_Y + 45, FISH_WIDTH + 100, FISH_HEIGHT, null);
        g.drawImage(pufferFishImage, (FISH_X * 5), FISH_Y + 45, FISH_WIDTH - 4, FISH_HEIGHT, null);
    }

}
