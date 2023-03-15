package ProjectIHM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {
    int score;
    JButton menu;
    Score(int score){
        this.score=score;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon imageicon = new ImageIcon("src\\\\Icons\\\\IconImg.png");
        setIconImage(imageicon.getImage());

        setBounds(0,0,1200,750);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/score.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 900, 700);
        add(image);
        JLabel scoreLabel=new JLabel("your score is:"+score+"/6");
        scoreLabel.setFont(new Font("Arial",Font.BOLD,20));
        scoreLabel.setBounds(1000, 420, 220, 25);
        add(scoreLabel);

        menu = new JButton("Menu");
        menu.setBounds(1000, 470, 120, 25);
        menu.setBackground(new Color(30, 144, 254));
        menu.setForeground(Color.WHITE);
        menu.addActionListener(this);
        add(menu);

        setLocationRelativeTo(null);
        setVisible(true);

        if(score==6) {
            JLabel messagelabel=new JLabel("you achieved the best score,Congratulations");
            messagelabel.setFont(new Font("Arial",Font.BOLD,20));
            messagelabel.setHorizontalAlignment(SwingConstants.CENTER);
            JOptionPane.showMessageDialog(null,messagelabel,"best score,pass to another level!", JOptionPane.PLAIN_MESSAGE);
        }
        else {
            JLabel messagelabel=new JLabel("Well donne,play with time too!!");
            messagelabel.setFont(new Font("Arial",Font.BOLD,20));
            messagelabel.setHorizontalAlignment(SwingConstants.CENTER);
            JOptionPane.showMessageDialog(null,messagelabel,"pass to another level!", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == menu) {
            setVisible(false);
            new Menu();}
    }

    public static void main(String[] args) {
        new Score(0);
    }
}

