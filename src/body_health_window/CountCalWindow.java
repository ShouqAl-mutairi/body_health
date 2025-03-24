package body_health_window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CountCalWindow extends JFrame {

    private JLabel message1;
    private JLabel message2;
    private JLabel calMessage;
    private JLabel userMealCal;

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    private JPanel panel7;

    private JButton countButton;
    private JButton backMenuButton;

    private JList foodList;
    private JScrollPane listScrollPane;

    private ImageIcon menuImage;
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

    private double total;

    public CountCalWindow() {
        setTitle("Count calories of meals");
        setSize(420, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BuildComponents();
        buildMenu();

        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countFood();
                calMessage.setVisible(true);
                userMealCal.setText("" + getTotal());
                total = 0;
            }
        });

        backMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuWindow f4 = new MenuWindow();
                setVisible(false);
                f4.setVisible(true);
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void BuildComponents() {
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();
        panel7 = new JPanel();

        Font font1 = new Font("Metropolis", Font.PLAIN, 20);
        Font font2 = new Font("Metropolis", Font.BOLD, 20);
        Font font3 = new Font("Metropolis", Font.PLAIN, 15);
        Color backgroundColor = Color.decode("#7F5F6F9");
        Color buttonBackgroundColor = Color.decode("#8276F4");
        Color textColor = Color.DARK_GRAY;

        message1 = new JLabel("Choose from the list", SwingConstants.CENTER);
        message1.setFont(font2);
        message1.setForeground(textColor);

        message2 = new JLabel("you can choose multiple items", SwingConstants.CENTER);
        message2.setToolTipText("Hold Ctrl Key while choosing many items");
        message2.setFont(font1);
        message2.setForeground(textColor);

        calMessage = new JLabel("The calories of your meal is ", SwingConstants.CENTER);
        calMessage.setFont(font1);
        calMessage.setForeground(textColor);
        calMessage.setVisible(false);

        userMealCal = new JLabel(" ", SwingConstants.CENTER);
        userMealCal.setFont(font1);
        userMealCal.setForeground(textColor);

        countButton = new JButton("Count");
        countButton.setFont(font3);
        countButton.setBackground(buttonBackgroundColor);
        countButton.setForeground(textColor);
        countButton.setPreferredSize(new Dimension(170, 50));

        backMenuButton = new JButton("go back to menu");
        backMenuButton.setFont(font3);
        backMenuButton.setBackground(buttonBackgroundColor);
        backMenuButton.setForeground(textColor);
        backMenuButton.setPreferredSize(new Dimension(170, 50));

        String[] food = {"Medium Apple", "Medium Banana", "Slice of Bread", "Chicken breast",
            "Cheddar cheese", "Rice", "Black Coffee", "Scrambled Egg", "Cola", "Vanilla Ice cream",
            "Milk", "Orange juice", "Slice of Pizza", "Baked Potato", "Ranch salad ", "Small Chocolate chip cookie",
            "Shrimp", "Spaghetti", "Tuna"};
        foodList = new JList(food);
        foodList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        listScrollPane = new JScrollPane(foodList);
        listScrollPane.setFont(font1);

        panel1.setBackground(backgroundColor);
        panel1.add(countButton);

        panel2.setBackground(backgroundColor);
        panel2.add(backMenuButton);

        panel3.setLayout(new GridLayout(2, 1));
        panel3.setBackground(backgroundColor);
        panel3.add(message1);
        panel3.add(message2);
        panel3.setBorder(BorderFactory.createEmptyBorder(50, 10, 50, 10));

        panel4.setLayout(new GridLayout(3, 1));
        panel4.setBackground(backgroundColor);
        panel4.add(calMessage);
        panel4.add(userMealCal);
        panel4.setBorder(BorderFactory.createEmptyBorder(10, 20, 0, 0));

        panel5.setLayout(new GridLayout(2, 1));
        panel5.setBackground(backgroundColor);
        panel5.add(panel1);
        panel5.add(panel4);

        panel6.setLayout(new GridLayout(3, 1));
        panel6.setBackground(backgroundColor);
        panel6.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        panel6.add(panel3);
        panel6.add(listScrollPane);
        panel6.add(panel5);

        panel7.setLayout(new BorderLayout());
        panel7.setBackground(backgroundColor);
        panel7.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        panel7.add(panel6, BorderLayout.CENTER);
        panel7.add(panel2, BorderLayout.SOUTH);

        setLayout(new BorderLayout());
        add(panel7);
    }

    public void countFood() {
        int[] selections = foodList.getSelectedIndices();
        for (int i = 0; i < selections.length; i++) {

            if (selections[i] == 0) {
                total += 72;
            }
            if (selections[i] == 1) {
                total += 105;
            }

            if (selections[i] == 2) {
                total += 66;
            }
            if (selections[i] == 3) {
                total += 142;
            }
            if (selections[i] == 4) {
                total += 113;
            }
            if (selections[i] == 5) {
                total += 205;
            }
            if (selections[i] == 6) {
                total += 2;
            }
            if (selections[i] == 7) {
                total += 102;
            }
            if (selections[i] == 8) {
                total += 136;
            }
            if (selections[i] == 9) {
                total += 145;
            }
            if (selections[i] == 10) {
                total += 122;
            }
            if (selections[i] == 11) {
                total += 112;
            }
            if (selections[i] == 12) {
                total += 298;
            }
            if (selections[i] == 13) {
                total += 161;
            }
            if (selections[i] == 14) {
                total += 146;
            }
            if (selections[i] == 15) {
                total += 59;
            }
            if (selections[i] == 16) {
                total += 84;
            }
            if (selections[i] == 17) {
                total += 221;
            }
            if (selections[i] == 18) {
                total += 100;
            }

        }
    }

    public double getTotal() {
        return total;
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

                    Color textColor = Color.white;
                    Color backgroundColor = Color.decode("#282828");
                    Color buttonBackgroundColor = Color.decode("#230046");

                    message1.setForeground(textColor);
                    message2.setForeground(textColor);
                    calMessage.setForeground(textColor);
                    userMealCal.setForeground(textColor);

                    countButton.setBackground(buttonBackgroundColor);
                    countButton.setForeground(textColor);

                    backMenuButton.setBackground(buttonBackgroundColor);
                    backMenuButton.setForeground(textColor);

                    panel1.setBackground(backgroundColor);
                    panel2.setBackground(backgroundColor);
                    panel3.setBackground(backgroundColor);
                    panel4.setBackground(backgroundColor);
                    panel5.setBackground(backgroundColor);
                    panel6.setBackground(backgroundColor);
                    panel7.setBackground(backgroundColor);

                    modeItem.setText("Light mode");
                    modeImage = new ImageIcon("images/lightModeIcon.png");
                    Image dabImage4 = modeImage.getImage();
                    Image modImage4 = dabImage4.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
                    modeImage = new ImageIcon(modImage4);
                    modeItem.setIcon(modeImage);

                }
                if (!modeItem.isSelected()) {

                    Color backgroundColor = Color.decode("#7F5F6F9");
                    Color buttonBackgroundColor = Color.decode("#8276F4");
                    Color textColor = Color.DARK_GRAY;

                    message1.setForeground(textColor);
                    message2.setForeground(textColor);
                    calMessage.setForeground(textColor);
                    userMealCal.setForeground(textColor);

                    countButton.setBackground(buttonBackgroundColor);
                    countButton.setForeground(textColor);

                    backMenuButton.setBackground(buttonBackgroundColor);
                    backMenuButton.setForeground(textColor);

                    panel1.setBackground(backgroundColor);
                    panel2.setBackground(backgroundColor);
                    panel3.setBackground(backgroundColor);
                    panel4.setBackground(backgroundColor);
                    panel5.setBackground(backgroundColor);
                    panel6.setBackground(backgroundColor);
                    panel7.setBackground(backgroundColor);

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
