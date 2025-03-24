package body_health_window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class CustomerInfoWindow extends JFrame {

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    private JPanel panel7;
    private JPanel panel8;
    private JPanel panel9;
    private JPanel panel10;
    private JPanel panel11;

    private JLabel name;
    private JLabel age;
    private JLabel gender;
    private JLabel weight;
    private JLabel height;
    private JLabel dailyActivity;
    private JLabel errorMessage;

    public static JTextField userName;
    public static JTextField userAge;
    public static JTextField userWeight;
    public static JTextField userHeight;

    public static JRadioButton female;
    public static JRadioButton male;
    private ButtonGroup group;

    public static JComboBox userDailyActivity;
    private JButton continueButton;

    private ImageIcon menuIcon;
    private ImageIcon modeIcon;
    private ImageIcon exitIcon;
    private ImageIcon helpIcon;
    private ImageIcon feedbackIcon;
    private ImageIcon clearIcon;

    private JMenuBar menuBar;
    private JMenu optionMenu;
    private JMenuItem exitItem;
    private JMenuItem helpItem;
    private JMenuItem feedbackItem;
    private JMenuItem clearItem;
    private JCheckBoxMenuItem modeItem;

    public CustomerInfoWindow() {

        setTitle("Personal Information");
        setSize(420, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BuildComponents();
        BuildPanel();
        buildMenu();

        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkForData() && validateTextFields()) {
                    try {
                        MenuWindow f3 = new MenuWindow();
                        setVisible(false);
                        f3.setVisible(true);
                        storeData();
                    } catch (CustomException ex) {
                        errorMessage.setText("Error: " + ex.getMessage());
                    }
                }
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void BuildComponents() {
        Font font = new Font("Metropolis", Font.BOLD, 16);
        Color textColor = Color.DARK_GRAY;
        Color backgroundColor = Color.decode("#7F5F6F9");
        Color buttonBackgroundColor = Color.decode("#8276F4");

        name = new JLabel("Name");
        name.setForeground(textColor);
        name.setFont(font);

        age = new JLabel("Age");
        age.setForeground(textColor);
        age.setFont(font);

        gender = new JLabel("Gender");
        gender.setForeground(textColor);
        gender.setFont(font);

        weight = new JLabel("Weight in kg");
        weight.setForeground(textColor);
        weight.setFont(font);

        height = new JLabel("Height in cm");
        height.setForeground(textColor);
        height.setFont(font);

        dailyActivity = new JLabel("Exercise time/day ");
        dailyActivity.setForeground(textColor);
        dailyActivity.setFont(font);

        userName = new JTextField(15);
        userAge = new JTextField(15);
        userWeight = new JTextField(15);
        userHeight = new JTextField(15);

        female = new JRadioButton("Female ");
        female.setFont(font);
        female.setForeground(textColor);
        female.setBackground(backgroundColor);

        male = new JRadioButton("Male");
        male.setFont(font);
        male.setForeground(textColor);
        male.setBackground(backgroundColor);

        group = new ButtonGroup();
        group.add(female);
        group.add(male);

        String[] dailyAct = {"Little or no exercise",
            "Exercise 1-2 days/week",
            "Exercise 2-4 days/week",
            "Exercise 4-6 days/week",
            "Exercise 6-7 days/week"};
        userDailyActivity = new JComboBox(dailyAct);

        continueButton = new JButton("Continue");
        continueButton.setFont(font);
        continueButton.setForeground(textColor);
        continueButton.setBackground(buttonBackgroundColor);
        continueButton.setPreferredSize(new Dimension(170, 50));

        errorMessage = new JLabel("", SwingConstants.CENTER);
        errorMessage.setForeground(Color.RED);
        errorMessage.setFont(font);

    }

    public void BuildPanel() {
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();
        panel7 = new JPanel();
        panel8 = new JPanel();
        panel9 = new JPanel();
        panel10 = new JPanel();
        panel11 = new JPanel();

        Color backgroundColor = Color.decode("#7F5F6F9");

        panel1.setLayout(new GridLayout(7, 2));
        panel1.add(name);
        
        panel5.add(userName);
        userName.setPreferredSize(new Dimension(20, 30));
        panel1.add(panel5);

        panel2.setLayout(new FlowLayout());
        panel2.add(female);
        panel2.add(male);

        panel1.add(age);
        
        panel6.add(userAge);
        userAge.setPreferredSize(new Dimension(20, 30));
        panel1.add(panel6);

        panel1.add(gender);
        panel1.add(panel2);

        panel1.add(weight);
        
        panel7.add(userWeight);
        userWeight.setPreferredSize(new Dimension(20, 30));
        panel1.add(panel7);

        panel1.add(height);
        
        panel8.add(userHeight);
        userHeight.setPreferredSize(new Dimension(20, 30));
        panel1.add(panel8);

        panel1.add(dailyActivity);
        panel1.add(panel9);
        
        panel10.add(userDailyActivity);
        userDailyActivity.setPreferredSize(new Dimension(166, 30));
        panel1.add(panel10);
        
        panel1.setBorder(BorderFactory.createEmptyBorder(100, 40, 40, 40));

        panel3.add(continueButton);

        panel4.setLayout(new GridLayout(2, 1));
        panel4.add(errorMessage);
        panel4.add(panel3);
        panel4.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));

        setLayout(new BorderLayout());
        add(panel1);
        add(panel4, BorderLayout.SOUTH);

        panel1.setBackground(backgroundColor);
        panel2.setBackground(backgroundColor);
        panel3.setBackground(backgroundColor);
        panel4.setBackground(backgroundColor);
        panel5.setBackground(backgroundColor);
        panel6.setBackground(backgroundColor);
        panel7.setBackground(backgroundColor);
        panel8.setBackground(backgroundColor);
        panel9.setBackground(backgroundColor);
        panel10.setBackground(backgroundColor);
        panel11.setBackground(backgroundColor);

    }

    public void storeData() throws CustomException {
        try {
            FileOutputStream file = new FileOutputStream("userInformation.dat");
            DataOutputStream data = new DataOutputStream(file);

            data.writeUTF("Name :" + userName.getText());
            data.writeUTF("Age :" + userAge.getText());

            if (female.isSelected()) {
                data.writeUTF("Gender : Female ");
            } else if (male.isSelected()) {
                data.writeUTF("Gender : Male ");
            }
            data.writeUTF("Weight :" + userWeight.getText());
            data.writeUTF("Height :" + userHeight.getText());

            data.writeUTF("Daily activity :" + userDailyActivity.getSelectedItem());

        } catch (FileNotFoundException ex) {
            throw new CustomException("Error storing data: " + ex.getMessage());

        } catch (IOException ex) {
            throw new CustomException("Data type error: " + ex.getMessage());
        }
    }

    private boolean checkForData() {
        if (userName.getText().isEmpty() || userAge.getText().isEmpty() || userWeight.getText().isEmpty() || userHeight.getText().isEmpty() || !female.isSelected() && !male.isSelected() || userDailyActivity.getSelectedItem() == null) {
            errorMessage.setText("Please fill all the fields");
            return false;

        }
        return true;
    }

    public boolean validateTextFields() {
        if (!isNumeric(userAge.getText())) {
            errorMessage.setText("The age must be a number");
            return false;
        } else if (!isNumericDouble(userWeight.getText())) {
            errorMessage.setText("The weight must be a number ");
            return false;
        } else if (!isNumericDouble(userHeight.getText())) {
            errorMessage.setText("The height must be a number ");
            return false;
        }
        return true;
    }

    public boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isNumericDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void buildMenu() {

        menuBar = new JMenuBar();
        menuIcon = new ImageIcon("images/optionMenu.png");
        Image dabImage = menuIcon.getImage();
        Image modImage = dabImage.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        menuIcon = new ImageIcon(modImage);

        optionMenu = new JMenu();
        optionMenu.setIcon(menuIcon);
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

        modeIcon = new ImageIcon("images/darkModeIcon.png");
        Image dabImage4 = modeIcon.getImage();
        Image modImage4 = dabImage4.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        modeIcon = new ImageIcon(modImage4);

        modeItem = new JCheckBoxMenuItem("Dark mode");
        modeItem.setIcon(modeIcon);
        modeItem.setMnemonic(KeyEvent.VK_M);

        modeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (modeItem.isSelected()) {
                    Color textColor = Color.white;
                    Color backgroundColor = Color.decode("#282828");
                    Color buttonBackgroundColor = Color.decode("#230046");

                    name.setForeground(textColor);
                    age.setForeground(textColor);
                    gender.setForeground(textColor);
                    weight.setForeground(textColor);
                    height.setForeground(textColor);
                    dailyActivity.setForeground(textColor);

                    female.setForeground(textColor);
                    female.setBackground(backgroundColor);
                    male.setForeground(textColor);
                    male.setBackground(backgroundColor);

                    continueButton.setForeground(textColor);
                    continueButton.setBackground(buttonBackgroundColor);

                    panel1.setBackground(backgroundColor);
                    panel2.setBackground(backgroundColor);
                    panel3.setBackground(backgroundColor);
                    panel4.setBackground(backgroundColor);
                    panel5.setBackground(backgroundColor);
                    panel6.setBackground(backgroundColor);
                    panel7.setBackground(backgroundColor);
                    panel8.setBackground(backgroundColor);
                    panel9.setBackground(backgroundColor);
                    panel10.setBackground(backgroundColor);
                    panel11.setBackground(backgroundColor);

                    modeItem.setText("Light mode");

                    modeIcon = new ImageIcon("images/lightModeIcon.png");
                    Image dabImage4 = modeIcon.getImage();
                    Image modImage4 = dabImage4.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
                    modeIcon = new ImageIcon(modImage4);

                    modeItem.setIcon(modeIcon);

                }
                if (!modeItem.isSelected()) {

                    Color textColor = Color.DARK_GRAY;
                    Color backgroundColor = Color.decode("#7F5F6F9");
                    Color buttonBackgroundColor = Color.decode("#8276F4");

                    name.setForeground(textColor);
                    age.setForeground(textColor);
                    gender.setForeground(textColor);
                    weight.setForeground(textColor);
                    height.setForeground(textColor);
                    dailyActivity.setForeground(textColor);

                    female.setForeground(textColor);
                    female.setBackground(backgroundColor);
                    male.setForeground(textColor);
                    male.setBackground(backgroundColor);

                    continueButton.setForeground(textColor);
                    continueButton.setBackground(buttonBackgroundColor);

                    panel1.setBackground(backgroundColor);
                    panel2.setBackground(backgroundColor);
                    panel3.setBackground(backgroundColor);
                    panel4.setBackground(backgroundColor);
                    panel5.setBackground(backgroundColor);
                    panel6.setBackground(backgroundColor);
                    panel7.setBackground(backgroundColor);
                    panel8.setBackground(backgroundColor);
                    panel9.setBackground(backgroundColor);
                    panel10.setBackground(backgroundColor);
                    panel11.setBackground(backgroundColor);

                    modeItem.setText("Dark mode");

                    modeIcon = new ImageIcon("images/darkModeIcon.png");
                    Image dabImage4 = modeIcon.getImage();
                    Image modImage4 = dabImage4.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
                    modeIcon = new ImageIcon(modImage4);
                    modeItem.setIcon(modeIcon);

                }
            }
        });

        clearIcon = new ImageIcon("images/clearIcon.png");
        Image dabImage5 = clearIcon.getImage();
        Image modImage5 = dabImage5.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        clearIcon = new ImageIcon(modImage5);

        clearItem = new JMenuItem(" Clear");
        clearItem.setIcon(clearIcon);
        clearItem.setMnemonic(KeyEvent.VK_C);
        clearItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userName.setText("");
                userAge.setText("");
                userWeight.setText("");
                userHeight.setText("");
                group.clearSelection();
                userDailyActivity.setSelectedIndex(0);
            }
        });

        optionMenu.add(exitItem);
        optionMenu.add(helpItem);
        optionMenu.add(feedbackItem);
        optionMenu.add(modeItem);
        optionMenu.add(clearItem);
        menuBar.add(optionMenu);
        setJMenuBar(menuBar);
    }
}
