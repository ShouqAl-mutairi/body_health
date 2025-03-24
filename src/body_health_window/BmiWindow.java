package body_health_window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class BmiWindow extends JFrame {

    private JLabel bmiMessage;
    private JLabel bmiLabel;
    private JLabel bmiStatus;
    private JLabel bmiImageLabel;

    private JButton backMenuButton;

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;

    private JMenuBar menuBar;
    private JMenu optionMenu;
    private JMenuItem exitItem;
    private JMenuItem helpItem;
    private JMenuItem feedbackItem;
    private JCheckBoxMenuItem modeItem;

    private ImageIcon menuImage;
    private ImageIcon bmiImage;
    private ImageIcon modeImage;
    private ImageIcon exitIcon;
    private ImageIcon helpIcon;
    private ImageIcon feedbackIcon;

    private double bmi;

    public BmiWindow() {
        setTitle("Bmi");
        setSize(420, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BuildComponents();
        buildMenu();

        backMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuWindow f3 = new MenuWindow();
                setVisible(false);
                f3.setVisible(true);
                try {
                    storeData();
                } catch (CustomException ex) {
                    System.out.println("An error occurred storing data : " + ex.getMessage());
                }
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

        Font font = new Font("Metropolis", Font.PLAIN, 20);
        Color backgroundColor = Color.decode("#7F5F6F9");
        Color buttonBackgroundColor = Color.decode("#8276F4");
        Color textColor = Color.DARK_GRAY;

        bmiMessage = new JLabel("Your BMI is ", SwingConstants.CENTER);
        bmiMessage.setFont(font);
        bmiMessage.setForeground(textColor);

        bmiLabel = new JLabel(String.format("%.2f", bmiCalc()), SwingConstants.CENTER);
        bmiLabel.setFont(font);
        bmiLabel.setForeground(textColor);

        bmiStatus = new JLabel(" ", SwingConstants.CENTER);
        bmiStatus.setFont(font);
        bmiStatus.setForeground(textColor);

        checkBmi();

        bmiImage = new ImageIcon("images/bmi.png");
        Image dabImage = bmiImage.getImage();
        Image modImage = dabImage.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        bmiImage = new ImageIcon(modImage);
        bmiImageLabel = new JLabel(bmiImage);

        backMenuButton = new JButton("back to menu");
        backMenuButton.setFont(font);
        backMenuButton.setBackground(buttonBackgroundColor);
        backMenuButton.setForeground(textColor);
        backMenuButton.setPreferredSize(new Dimension(190, 60));

        panel1.setLayout(new GridLayout(3, 1));
        panel1.setBackground(backgroundColor);
        panel1.add(bmiMessage);
        panel1.add(bmiLabel);
        panel1.add(bmiStatus);

        panel4.setLayout(new GridLayout(2, 1));
        panel4.setBackground(backgroundColor);
        panel4.add(panel1);
        panel4.add(bmiImageLabel);

        panel2.setBackground(backgroundColor);
        panel2.add(backMenuButton);

        panel3.setLayout(new BorderLayout());
        panel3.setBackground(backgroundColor);
        panel3.setBorder(BorderFactory.createEmptyBorder(100, 10, 100, 10));
        panel3.add(panel4, BorderLayout.CENTER);
        panel3.add(panel2, BorderLayout.SOUTH);
        add(panel3);

    }

    public double bmiCalc() {
        double heightMeter = Double.parseDouble(CustomerInfoWindow.userHeight.getText()) / 100;
        bmi = Double.parseDouble(CustomerInfoWindow.userWeight.getText()) / Math.pow(heightMeter, 2.0);
        return bmi;
    }

    public void checkBmi() {
        if (bmi < 18.5) {
            bmiStatus.setText("You are underweight");
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            bmiStatus.setText("You are in a healthy weight");
        } else if (bmi >= 25.0 && bmi <= 29.9) {
            bmiStatus.setText("You are overweight");
        } else {
            bmiStatus.setText("You are obese");
        }
    }

    public void storeData() throws CustomException {
        try {
            FileOutputStream file = new FileOutputStream("userInformation.dat", true);
            DataOutputStream data = new DataOutputStream(file);

            data.writeUTF("Bmi :" + bmiLabel.getText());

        } catch (FileNotFoundException ex) {
            throw new CustomException("Error storing BMI data: " + ex.getMessage());

        } catch (IOException ex) {
            throw new CustomException("Error storing BMI data: " + ex.getMessage());
        }
    }

    void buildMenu() {

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

                    bmiMessage.setForeground(textColor);
                    bmiLabel.setForeground(textColor);
                    bmiStatus.setForeground(textColor);

                    backMenuButton.setBackground(buttonBackgroundColor);
                    backMenuButton.setForeground(textColor);

                    panel1.setBackground(backgroundColor);
                    panel4.setBackground(backgroundColor);
                    panel2.setBackground(backgroundColor);
                    panel3.setBackground(backgroundColor);
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

                    bmiMessage.setForeground(textColor);
                    bmiLabel.setForeground(textColor);
                    bmiStatus.setForeground(textColor);

                    backMenuButton.setBackground(buttonBackgroundColor);
                    backMenuButton.setForeground(textColor);

                    panel1.setBackground(backgroundColor);
                    panel4.setBackground(backgroundColor);
                    panel2.setBackground(backgroundColor);
                    panel3.setBackground(backgroundColor);

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
