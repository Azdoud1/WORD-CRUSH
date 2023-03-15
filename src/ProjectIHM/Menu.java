package ProjectIHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.w3c.dom.css.CSSPrimitiveValue;
import org.w3c.dom.css.RGBColor;

public class Menu implements ActionListener{
    JFrame frame =new JFrame("Levels");
    JPanel topPanel=new JPanel();
    JPanel bassePanel=new JPanel();
    JPanel buttonPanel =new JPanel(new GridLayout(6,6));
    JLabel titleLabel=new JLabel("chose a level");
    JButton[] buttons =new JButton[36];
    JButton back=new JButton();
    public Menu() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("src\\Icons\\IconImg.png");
        frame.setIconImage(image.getImage());
        frame.setSize(600,650);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        titleLabel.setFont(new Font("Aclinica",Font.BOLD,55));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBackground(new Color(255,255,0));
        titleLabel.setForeground(new Color(0,0,255));
        titleLabel.setOpaque(true);

        back = new JButton("Back");
        back.setBounds(250, 500, 270, 30);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        bassePanel.add(back);
        bassePanel.setBackground(new Color(255,255,0));
        BorderLayout borderLayout=new BorderLayout();
        topPanel.setLayout(borderLayout);
        topPanel.add(titleLabel,borderLayout.CENTER);
        //l'ajout de botones
        for(int i=0;i<buttons.length;i++) {
            buttons[i]= new JButton(i+1+"") ;
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("Archive",Font.BOLD,40));
            buttons[i].addActionListener(this);
            buttons[i].setBackground(new Color(191,255,0));

        }

        frame.add(topPanel,BorderLayout.NORTH);
        frame.add(buttonPanel,BorderLayout.CENTER);
        frame.add(bassePanel,BorderLayout.SOUTH);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<buttons.length;i++) {
            if(e.getSource()==buttons[i]) {
                Play play=new Play(i+1);
                frame.dispose();
            }
        }
        if(e.getSource()==back) {
            frame.setVisible(false);
            new Login();
        }
    }
    public static void main(String args[]) {
        new Menu();
    }
}
