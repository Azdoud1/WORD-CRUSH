package ProjectIHM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener{

    String name;
    JButton back;

    Rules(String name) {
        this.name = name;
        ImageIcon imageIco = new ImageIcon("src\\Icons\\IconImg.png");
        setIconImage(imageIco.getImage());

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Welcome " + name + " to Word Crush Game");
        heading.setBounds(50, 20, 700, 30);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(20, 90, 700, 350);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setText(
                "<html>"+
                        "1. you must choose the letters that form the correct answer" + "<br><br>" +
                        "2. You can confirm the answer by clicking on button 'check answer'" + "<br><br>" +
                        "3. If your answer is correct click 'Next' for pass to another question," + "<br><br>" +
                        "   the box of letters that you have chosen will turn green,otherwise" + "<br><br>" +
                        "   it will turn red if it is wrong (Be wise, not otherwise)" + "<br><br>" +
                        "6. If you finished a level press 'Menu' to chose another level " + "<br><br>" +
                        "7. Brace yourself, this paper is not for the faint hearted" + "<br><br>" +
                        "8. May you know more than what John Snow knows, Good Luck" + "<br><br>" +
                        "<html>"
        );
        add(rules);

        back = new JButton("Back");
        back.setBounds(250, 500, 100, 30);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(800, 650);
        setLocation(350, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Rules("User");
    }
}
