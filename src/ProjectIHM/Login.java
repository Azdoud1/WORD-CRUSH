package ProjectIHM;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{

    JButton rules, back, start;
    JTextField tfname;

    Login() {
        ImageIcon imageIco = new ImageIcon("src\\Icons\\IconImg.png");
        setIconImage(imageIco.getImage());
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/IconImg.jpeg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 600, 700);
        add(image);

        JLabel heading = new JLabel("Word Crush");
        heading.setBounds(750, 60, 300, 45);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);

        JLabel name = new JLabel("Enter your name");
        name.setBounds(810, 150, 300, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        name.setForeground(new Color(30, 144, 254));
        add(name);

        tfname = new JTextField();
        tfname.setBounds(735, 200, 300, 25);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfname);
        start = new JButton("Start");
        start.setBounds(660, 270, 100, 25);
        start.setBackground(new Color(30, 144, 254));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);

        rules = new JButton("Rules");
        rules.setBounds(800, 270, 100, 25);
        rules.setBackground(new Color(30, 144, 254));
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);

        back = new JButton("Out");
        back.setBounds(940, 270, 100, 25);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(1100, 700);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == rules) {
            String name = tfname.getText();
            setVisible(false);
            new Rules(name);
        } else if (ae.getSource() == back) {
            setVisible(false);
        }
        else if (ae.getSource() == start) {
            setVisible(false);
            new Menu();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}

