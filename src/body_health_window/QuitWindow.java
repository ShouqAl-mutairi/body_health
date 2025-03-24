package body_health_window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;

public class QuitWindow extends JFrame {

    private JLabel byeMessage;

    private JButton showDataButton;
    private JButton stopButton;

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
    private ImageIcon modeImage;
    private ImageIcon exitIcon;
    private ImageIcon helpIcon;
    private ImageIcon feedbackIcon;

    public QuitWindow() {
        setTitle("Random Meal");
        setSize(420, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BuildComponents();
        buildMenu();

        showDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    readAndShowData();
                } catch (CustomException ex) {
                    System.out.println("Error printing user's data");
                }
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
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

        Font font = new Font("Metropolis", Font.BOLD, 30);
        Font font1 = new Font("Metropolis", Font.PLAIN, 20);
        Color backgroundColor = Color.decode("#7F5F6F9");
        Color buttonBackgroundColor = Color.decode("#8276F4");
        Color textColor = Color.DARK_GRAY;

        byeMessage = new JLabel("Good Bye " + CustomerInfoWindow.userName.getText(), SwingConstants.CENTER);
        byeMessage.setFont(font);
        byeMessage.setForeground(textColor);

        showDataButton = new JButton("show my data");
        showDataButton.setFont(font1);
        showDataButton.setForeground(textColor);
        showDataButton.setBackground(buttonBackgroundColor);

        stopButton = new JButton("Stop");
        stopButton.setFont(font1);
        stopButton.setForeground(textColor);
        stopButton.setBackground(buttonBackgroundColor);

        panel1.setLayout(new BorderLayout());
        panel1.setBackground(backgroundColor);
        panel1.add(byeMessage, BorderLayout.SOUTH);

        panel2.setLayout(new GridLayout(2, 1, 7, 10));
        panel2.setBackground(backgroundColor);
        panel2.add(showDataButton);
        panel2.add(stopButton);

        panel3.setBackground(backgroundColor);
        panel3.add(panel2);

        panel4.setLayout(new GridLayout(2, 1));
        panel4.setBackground(backgroundColor);
        panel4.setBorder(BorderFactory.createEmptyBorder(160, 10, 230, 10));
        panel4.add(panel1);
        panel4.add(panel3);
        add(panel4);

    }

    public void readAndShowData() throws CustomException {
        ArrayList<String> lines = new ArrayList<>();
        try ( DataInputStream dataInputStream = new DataInputStream(new FileInputStream("userInformation.dat"))) {
            while (dataInputStream.available() > 0) {
                lines.add(dataInputStream.readUTF());
            }
        } catch (FileNotFoundException ex) {
            throw new CustomException("Error opening file", ex);
        } catch (IOException ex) {
            throw new CustomException("Error reading data", ex);
        }

        String message = String.join("\n", lines);
        JOptionPane.showMessageDialog(null, message, "User data", JOptionPane.PLAIN_MESSAGE);
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

                    byeMessage.setForeground(textColor);

                    showDataButton.setForeground(textColor);
                    showDataButton.setBackground(buttonBackgroundColor);

                    stopButton.setForeground(textColor);
                    stopButton.setBackground(buttonBackgroundColor);

                    panel1.setBackground(backgroundColor);
                    panel2.setBackground(backgroundColor);
                    panel3.setBackground(backgroundColor);
                    panel4.setBackground(backgroundColor);

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

                    byeMessage.setForeground(textColor);

                    showDataButton.setForeground(textColor);
                    showDataButton.setBackground(buttonBackgroundColor);

                    stopButton.setForeground(textColor);
                    stopButton.setBackground(buttonBackgroundColor);

                    panel1.setBackground(backgroundColor);
                    panel2.setBackground(backgroundColor);
                    panel3.setBackground(backgroundColor);
                    panel4.setBackground(backgroundColor);

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
