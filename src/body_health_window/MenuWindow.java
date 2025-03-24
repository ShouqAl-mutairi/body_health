package body_health_window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuWindow extends JFrame {

    private JButton waterButton;
    private JButton bmiButton;
    private JButton calButton;
    private JButton countCalButton;
    private JButton randomMealButton;
    private JButton quitButton;

    private JLabel backgroundLabel;
    private JLabel welcomeLabel;

    private ImageIcon backgroundImage;
    private ImageIcon menuImage;
    private ImageIcon welcomeIcon;
    private ImageIcon modeImage;
    private ImageIcon exitIcon;
    private ImageIcon helpIcon;
    private ImageIcon feedbackIcon;

    private JMenuBar menuBar;
    private JMenu optionMenu;
    private JMenuItem exitItem;
    private JMenuItem helpItem;
    private JMenuItem feedbackItem;
    private JCheckBoxMenuItem modeItem;

    public MenuWindow() {
        setTitle("Menu");
        setSize(420, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backgroundImage = new ImageIcon("images/backgroundImage.jpg");
        Image dabImage = backgroundImage.getImage();
        Image modImage = dabImage.getScaledInstance(420, 650, Image.SCALE_SMOOTH);
        backgroundImage = new ImageIcon(modImage);

        backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setLayout(null);
        setContentPane(backgroundLabel);

        BuildComponents();
        buildMenu();

        waterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DailyWaterWindow f4 = new DailyWaterWindow();
                setVisible(false);
                f4.setVisible(true);
            }
        });
        bmiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BmiWindow f5 = new BmiWindow();
                setVisible(false);
                f5.setVisible(true);
            }
        });
        calButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CaloriesWindow f6 = new CaloriesWindow();
                setVisible(false);
                f6.setVisible(true);
            }
        });

        countCalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CountCalWindow f7 = new CountCalWindow();
                setVisible(false);
                f7.setVisible(true);
            }
        });

        randomMealButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RandomMealWindow f8 = new RandomMealWindow();
                setVisible(false);
                f8.setVisible(true);
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QuitWindow f9 = new QuitWindow();
                setVisible(false);
                f9.setVisible(true);
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void BuildComponents() {
 
        Font font = new Font("Metropolis", Font.BOLD, 18);
        Font font1 = new Font("Metropolis", Font.PLAIN, 18);
        Color textColor1 = Color.white;
        Color textColor2 = Color.decode("#8276F4");
        Color buttonBackgroundColor = Color.white;

        welcomeIcon = new ImageIcon("images/personIcon.png");
        Image dabImage = welcomeIcon.getImage();
        Image modImage = dabImage.getScaledInstance(30, 27, Image.SCALE_SMOOTH);
        welcomeIcon = new ImageIcon(modImage);

        welcomeLabel = new JLabel("Welcome " + CustomerInfoWindow.userName.getText(), welcomeIcon, SwingConstants.CENTER);
        welcomeLabel.setFont(font);
        welcomeLabel.setForeground(textColor1);
        welcomeLabel.setBounds(100, 90, 200, 40);

        waterButton = new JButton("Daily water");
        waterButton.setFont(font1);
        waterButton.setBackground(buttonBackgroundColor);
        waterButton.setForeground(textColor2);
        waterButton.setPreferredSize(new Dimension(190, 60));
        waterButton.setBounds(100, 200, 200, 40);

        bmiButton = new JButton("BMI");
        bmiButton.setFont(font1);
        bmiButton.setBackground(buttonBackgroundColor);
        bmiButton.setForeground(textColor2);
        bmiButton.setPreferredSize(new Dimension(190, 60));
        bmiButton.setBounds(100, 250, 200, 40);

        calButton = new JButton("Daily calories");
        calButton.setFont(font1);
        calButton.setBackground(buttonBackgroundColor);
        calButton.setForeground(textColor2);
        calButton.setPreferredSize(new Dimension(190, 60));
        calButton.setBounds(100, 300, 200, 40);

        countCalButton = new JButton("Count calories");
        countCalButton.setFont(font1);
        countCalButton.setBackground(buttonBackgroundColor);
        countCalButton.setForeground(textColor2);
        countCalButton.setPreferredSize(new Dimension(190, 60));
        countCalButton.setBounds(100, 350, 200, 40);

        randomMealButton = new JButton("Random meal");
        randomMealButton.setFont(font1);
        randomMealButton.setBackground(buttonBackgroundColor);
        randomMealButton.setForeground(textColor2);
        randomMealButton.setPreferredSize(new Dimension(190, 60));
        randomMealButton.setBounds(100, 400, 200, 40);

        quitButton = new JButton("Quit");
        quitButton.setFont(font1);
        quitButton.setBackground(buttonBackgroundColor);
        quitButton.setForeground(textColor2);
        quitButton.setPreferredSize(new Dimension(190, 60));
        quitButton.setBounds(100, 450, 200, 40);

        add(welcomeLabel);
        add(waterButton);
        add(bmiButton);
        add(calButton);
        add(countCalButton);
        add(randomMealButton);
        add(quitButton);
    }

    public void buildMenu() {

        menuBar = new JMenuBar();
        menuImage = new ImageIcon("images/optionMenu.png");
        Image dabImage = menuImage.getImage();
        Image modImage = dabImage.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        menuImage = new ImageIcon(modImage);

        optionMenu = new JMenu();
        optionMenu.setIcon(menuImage);
        optionMenu.setMnemonic(KeyEvent.VK_O);
        optionMenu.setForeground(Color.gray);

        exitIcon = new ImageIcon("images/exitIcon.png");
        Image dabImage1 = exitIcon.getImage();
        Image modImage1 = dabImage1.getScaledInstance(13, 13, Image.SCALE_SMOOTH);
        exitIcon = new ImageIcon(modImage1);

        exitItem = new JMenuItem(" Exit");
        exitItem.setIcon(exitIcon);
        exitItem.setMnemonic(KeyEvent.VK_X);
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        helpIcon = new ImageIcon("images/helpIcon.png");
        Image dabImage2 = helpIcon.getImage();
        Image modImage2 = dabImage2.getScaledInstance(13, 13, Image.SCALE_SMOOTH);
        helpIcon = new ImageIcon(modImage2);

        helpItem = new JMenuItem(" Help");
        helpItem.setIcon(helpIcon);
        helpItem.setMnemonic(KeyEvent.VK_H);
        helpItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Contact : bodyhealth@bh.com");
            }
        });

        feedbackIcon = new ImageIcon("images/feedbackIcon.png");
        Image dabImage3 = feedbackIcon.getImage();
        Image modImage3 = dabImage3.getScaledInstance(13, 13, Image.SCALE_SMOOTH);
        feedbackIcon = new ImageIcon(modImage3);

        feedbackItem = new JMenuItem(" Feedback");
        feedbackItem.setIcon(feedbackIcon);
        feedbackItem.setMnemonic(KeyEvent.VK_F);
        feedbackItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showInputDialog(null, "Write your feedback", "Feedback", JOptionPane.PLAIN_MESSAGE);

            }
        });

        modeImage = new ImageIcon("images/darkModeIcon.png");
        Image dabImage4 = modeImage.getImage();
        Image modImage4 = dabImage4.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        modeImage = new ImageIcon(modImage4);

        modeItem = new JCheckBoxMenuItem("Dark mode");
        modeItem.setIcon(modeImage);
        modeItem.setMnemonic(KeyEvent.VK_M);

        modeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (modeItem.isSelected()) {

                    Color textColor1 = Color.white;
                    Color textColor2 = Color.white;
                    Color buttonBackgroundColor = Color.decode("#230046");

                    welcomeLabel.setForeground(textColor1);
                    welcomeLabel.setBounds(100, 90, 200, 40);

                    waterButton.setBackground(buttonBackgroundColor);
                    waterButton.setForeground(textColor2);

                    bmiButton.setBackground(buttonBackgroundColor);
                    bmiButton.setForeground(textColor2);

                    calButton.setBackground(buttonBackgroundColor);
                    calButton.setForeground(textColor2);

                    countCalButton.setBackground(buttonBackgroundColor);
                    countCalButton.setForeground(textColor2);

                    randomMealButton.setBackground(buttonBackgroundColor);
                    randomMealButton.setForeground(textColor2);

                    quitButton.setBackground(buttonBackgroundColor);
                    quitButton.setForeground(textColor2);

                    modeItem.setText("Light mode");
                    modeImage = new ImageIcon("images/lightModeIcon.png");
                    Image dabImage4 = modeImage.getImage();
                    Image modImage4 = dabImage4.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
                    modeImage = new ImageIcon(modImage4);
                    modeItem.setIcon(modeImage);

                }
                if (!modeItem.isSelected()) {
                    Color textColor1 = Color.white;
                    Color textColor2 = Color.decode("#8276F4");
                    Color buttonBackgroundColor = Color.white;

                    welcomeLabel.setForeground(textColor1);
                    welcomeLabel.setBounds(100, 90, 200, 40);

                    waterButton.setBackground(buttonBackgroundColor);
                    waterButton.setForeground(textColor2);

                    bmiButton.setBackground(buttonBackgroundColor);
                    bmiButton.setForeground(textColor2);

                    calButton.setBackground(buttonBackgroundColor);
                    calButton.setForeground(textColor2);

                    countCalButton.setBackground(buttonBackgroundColor);
                    countCalButton.setForeground(textColor2);

                    randomMealButton.setBackground(buttonBackgroundColor);
                    randomMealButton.setForeground(textColor2);

                    quitButton.setBackground(buttonBackgroundColor);
                    quitButton.setForeground(textColor2);

                    modeItem.setText("Dark mode");
                    modeImage = new ImageIcon("images/darkModeIcon.png");
                    Image dabImage4 = modeImage.getImage();
                    Image modImage4 = dabImage4.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
                    modeImage = new ImageIcon(modImage4);
                    modeItem.setIcon(modeImage);

                }
            }
        });

        optionMenu.add(exitItem);
        optionMenu.add(helpItem);
        optionMenu.add(feedbackItem);
        optionMenu.add(modeItem);
        menuBar.add(optionMenu);
        setJMenuBar(menuBar);
    }
}
