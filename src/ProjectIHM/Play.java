package ProjectIHM;
//********************************************************
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextComponent;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Play implements MouseListener{
    int level;
    private int ligne;

    JFrame frame =new JFrame();

    JPanel buttonPanel= new JPanel(new FlowLayout());
    JPanel questionPanel=new JPanel();
    JPanel botonPanel= new JPanel(new GridLayout(6,6));
    JPanel timerPanel= new JPanel(new FlowLayout());
    JPanel questionsPanel=new JPanel();
    JPanel afficheWord =new JPanel();


    JButton[] buttons= new JButton[36];

    JButton startOverButton =new JButton("Start Over");
    JButton doneButton =new JButton("Check answer");
    JButton menuButton =new JButton("Menu");
    JButton nextButton =new JButton("NEXT");

    JTextArea textField=new JTextArea();

    JTextField tf1=new JTextField("",2);
    JTextField tf2=new JTextField("",2);
    JTextField tf3=new JTextField("",2);
    JTextField tf4=new JTextField("",2);
    JTextField tf5=new JTextField("",2);
    JTextField tf6=new JTextField("",2);


    JLabel muniteLabel= new JLabel();
    JLabel secondLabel= new JLabel();

    JLabel textLabel= new JLabel("questions");

    String[] arrayLevels=new String[36];

    String currentLevelData="";
    String currentwordData="";
    String currentquestionData="";
    String currentlevelScore="";

    String answer="";

    String stringMinutes,stringSeconds;
    String[] arrayquestionLevels =new String[8];
    String[] arraywordLevels =new String[10];
    String[] arrayScore=new String[64];
    Timer t;
    int elapseTime,minutes,seconds;
    int scor,bestscore;
    public Play(int level) {
        this.level= level;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("src\\Icons\\IconImg.png");
        frame.setIconImage(image.getImage());
        frame.setSize(900,550);
        frame.setBackground(new Color(0, 255, 255));
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("level"+level);

        for(int i=0;i<buttons.length;i++) {
            buttons[i] =new JButton();
            botonPanel.add(buttons[i]);
            botonPanel.setBackground(new Color(0, 255, 255));

            buttons[i].setFont(new Font("Arial",Font.BOLD,20));
            buttons[i].setFocusable(true);
            buttons[i].addMouseListener(this);
        }
        nextButton.setFont(new Font("Arial",Font.BOLD,20));
        nextButton.setForeground(Color.GREEN);
        nextButton.setFocusable(false);
        nextButton.setBackground(new Color(30, 144, 254));
        nextButton.setForeground(Color.WHITE);

        startOverButton.setFont(new Font("Arial",Font.BOLD,20));
        startOverButton.setForeground(Color.GREEN);
        startOverButton.setFocusable(false);
        startOverButton.setBackground(new Color(30, 144, 254));
        startOverButton.setForeground(Color.WHITE);

        doneButton.setFont(new Font("Arial",Font.BOLD,20));
        doneButton.setForeground(Color.GREEN);
        doneButton.setFocusable(false);
        doneButton.setBackground(new Color(30, 144, 254));
        doneButton.setForeground(Color.WHITE);

        menuButton.setFont(new Font("Arial",Font.BOLD,20));
        menuButton.setForeground(Color.GREEN);
        menuButton.setFocusable(false);
        menuButton.setBackground(new Color(30, 144, 254));
        menuButton.setForeground(Color.WHITE);

        startOverButton.addMouseListener(this);
        nextButton.addMouseListener(this);
        doneButton.addMouseListener(this);
        menuButton.addMouseListener(this);

        buttonPanel.add(nextButton);
        buttonPanel.add(startOverButton);
        buttonPanel.add(doneButton);
        buttonPanel.add(menuButton);
        buttonPanel.setBackground(new Color(0, 255, 255));

        muniteLabel.setFont(new Font("Arial",Font.BOLD,20));
        secondLabel.setFont(new Font("Arial",Font.BOLD,20));
        muniteLabel.setForeground(Color.RED);
        secondLabel.setForeground(Color.RED);

        textLabel.setForeground(Color.RED);
        textLabel.setFont(new Font("Arial",Font.BOLD,20));

        timerPanel.setBackground(new Color(0, 255, 255));

        timerPanel.add(muniteLabel);
        timerPanel.add(secondLabel);
        buttonPanel.add(timerPanel);

        tf1.setBounds(50,50,50,20);
        tf2.setBounds(50,50,50,20);
        tf3.setBounds(50,50,50,20);
        tf4.setBounds(50,50,50,20);
        tf5.setBounds(50,50,50,20);
        tf6.setBounds(50,50,50,20);
        tf1.setEditable(false);
        tf2.setEditable(false);
        tf3.setEditable(false);
        tf4.setEditable(false);
        tf5.setEditable(false);
        tf6.setEditable(false);
        textField.setEditable(false);
        textField.setFont(new Font("Arial",Font.BOLD,20));
        tf1.setBackground(Color.black);
        tf2.setBackground(Color.black);
        tf3.setBackground(Color.black);
        tf4.setBackground(Color.black);
        tf5.setBackground(Color.black);
        tf6.setBackground(Color.black);

        afficheWord.add(tf1);
        afficheWord.add(tf2);
        afficheWord.add(tf3);
        afficheWord.add(tf4);
        afficheWord.add(tf5);
        afficheWord.add(tf6);
        afficheWord.setBackground(new Color(0,255, 255));

        questionsPanel.add(textField);
        questionsPanel.add(afficheWord);
        questionsPanel.setBackground(new Color(0, 255, 255));

        BoxLayout boxLayout=new BoxLayout(questionsPanel,BoxLayout.Y_AXIS);
        questionsPanel.setLayout(boxLayout);

        frame.add(botonPanel,BorderLayout.CENTER);
        frame.add(buttonPanel,BorderLayout.SOUTH);
        frame.add(questionsPanel,BorderLayout.NORTH);
        loadData(level);
        loadDataqustions(level);

        starTimer();
    }
    //la methode qui permet de lire la contenue d'un fichier
    private String[] readFile(String fileName) {
        List<String> listOfString=new ArrayList();
        try {
            BufferedReader bf=new BufferedReader(new FileReader(fileName));
            String line=bf.readLine();
            while(line!=null) {
                listOfString.add(line);
                line=bf.readLine();
            }
            bf.close();
        }
        catch(Exception exp) {	}

        return listOfString.toArray(new String[0]);
    }
    private void loadData(int level) {
        arrayLevels = readFile("src\\Fiels\\levels");
        currentLevelData= arrayLevels[level-1];
        showCharacterinButtons();
    }


    private void showCharacterinButtons() {
        String[] character=currentLevelData.split("\\s+");
        for(int i=0;i<buttons.length;i++) {
            buttons[i].setText(character[i].substring(0));

        }}

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    int compteur=0;
    int click=0;
    int nextcompteur=0;
    int colorchange=0;
    @Override
    public void mouseReleased(MouseEvent e) {
        for(int i=0;i<buttons.length;i++) {
            if(e.getSource()==buttons[i]) {
                buttons[i].setBackground(Color.orange);

//pour afficher les lettres que le joeur a été choisé
                if(compteur==0) {
                    tf1.setText(buttons[i].getText());
                    tf1.setBackground(Color.yellow);
                    tf1.setFont(new Font("Arial",Font.BOLD,20));
                }
                else if(compteur==1) {
                    tf2.setText(buttons[i].getText());
                    tf2.setBackground(Color.yellow);
                    tf2.setFont(new Font("Arial",Font.BOLD,20));
                }
                else if(compteur==2) {
                    tf3.setText(buttons[i].getText());
                    tf3.setBackground(Color.yellow);
                    tf3.setFont(new Font("Arial",Font.BOLD,20));
                }
                else if(compteur==3) {
                    tf4.setText(buttons[i].getText());
                    tf4.setBackground(Color.yellow);
                    tf4.setFont(new Font("Arial",Font.BOLD,20));
                }
                else if(compteur==4) {
                    tf5.setText(buttons[i].getText());
                    tf5.setBackground(Color.yellow);
                    tf5.setFont(new Font("Arial",Font.BOLD,20));
                }
                else  {
                    tf6.setText(buttons[i].getText());
                    tf6.setBackground(Color.yellow);
                    tf6.setFont(new Font("Arial",Font.BOLD,20));
                }
                compteur++;
                colorchange++;
                if(compteur==6) {
                    compteur=0;
                }
            }
        }
        if(e.getSource()==nextButton) {

            NextQuestion();
            click++;
            nextcompteur++;
            loadDataqustions(level);
            if(click==6) {
                RateScore();
                new Score(resultscore);
                frame.dispose();
            }
        }

        if(e.getSource()==menuButton) {
            new Menu();
            frame.dispose();
        }
        if(e.getSource()==doneButton) {
            checkSolution();
            NextQuestion();
            for(int i=0;i<buttons.length;i++) {
                buttons[i].setBackground(new JButton().getBackground());
            }
        }
        if(e.getSource()==startOverButton) {
            t.stop();
            starTimer();
            // tf1.setText("");

            NextQuestion();
            click=0;
            loadDataqustions(level);
            for(int i=0;i<buttons.length;i++) {
                buttons[i].setBackground(new JButton().getBackground());
            }
        }
    }
    private void NextQuestion() {
        compteur=0;
        tf1.setText("");
        tf1.setBackground(Color.black);
        tf2.setText("");
        tf2.setBackground(Color.black);
        tf3.setText("");
        tf3.setBackground(Color.black);
        tf4.setText("");
        tf4.setBackground(Color.black);
        tf5.setText("");
        tf5.setBackground(Color.black);
        tf6.setText("");
        tf6.setBackground(Color.black);
    }

    private void loadDataqustions(int level) {
        System.out.println(click);

        String question;
        //une boucle pour load les question
        for(int i=0;i<buttons.length;i++) {
            if(click==0) {
                arrayquestionLevels = readFile("src\\Fiels\\quetions1");
                arraywordLevels = readFile("src\\Fiels\\correctwords1");
                currentquestionData= arrayquestionLevels[level-1];
                question=currentquestionData;
                currentwordData= arraywordLevels[level-1];
                textField.setText(question);
            }
            else if(click==1) {
                arrayquestionLevels = readFile("src\\Fiels\\quetions2");
                arraywordLevels = readFile("src\\Fiels\\correctwords2");
                currentquestionData= arrayquestionLevels[level-1];
                currentwordData= arraywordLevels[level-1];
                question=currentquestionData;
                textField.setText(question);
            }
            else if(click==2) {
                arrayquestionLevels = readFile("src\\Fiels\\quetions3");
                arraywordLevels = readFile("src\\Fiels\\correctwords3");
                currentquestionData= arrayquestionLevels[level-1];
                currentwordData= arraywordLevels[level-1];
                question=currentquestionData;
                textField.setText(question);
            }
            else if(click==3) {
                arrayquestionLevels = readFile("src\\Fiels\\quetions4");
                arraywordLevels = readFile("src\\Fiels\\correctwords4");
                currentquestionData= arrayquestionLevels[level-1];
                currentwordData= arraywordLevels[level-1];
                question=currentquestionData;
                textField.setText(question);

            }
            else if(click==4) {
                arrayquestionLevels = readFile("src\\Fiels\\quetions5");
                arraywordLevels = readFile("src\\Fiels\\correctwords5");
                currentquestionData= arrayquestionLevels[level-1];
                currentwordData= arraywordLevels[level-1];
                question=currentquestionData;
                textField.setText(question);
            }
            else  {
                arrayquestionLevels = readFile("src\\Fiels\\quetions6");
                arraywordLevels = readFile("src\\Fiels\\correctwords6");
                currentquestionData= arrayquestionLevels[level-1];
                currentwordData= arraywordLevels[level-1];
                question=currentquestionData;
                textField.setText(question);

            }
        }
    }
    int resultscore=0;
    int checkcompteur=0;
    // for check the answer
    private void checkSolution() {
        answer="";
        for(int i=0;i<buttons.length;i++) {
            if(buttons[i].getBackground()!=new JButton().getBackground()) {
                answer=answer+"1";
            }
            if(buttons[i].getBackground().equals(new JButton().getBackground())) {
                answer=answer+"0";
            }
            if(i!=(buttons.length-1)) {
                answer=answer+" ";}
            //answer="";
        }
        //on a fait appel à cette methode là pour lire les fichiers qu'ils contient les solutions
        loadDataqustions(level);
        if(answer.equals(currentwordData)) {
            tf1.setBackground(Color.green);
            tf2.setBackground(Color.green);
            tf3.setBackground(Color.green);
            tf4.setBackground(Color.green);
            tf5.setBackground(Color.green);
            tf6.setBackground(Color.green);
            JLabel messageLabel=new JLabel("correct!");
            messageLabel.setFont(new Font("Arial",Font.BOLD,20));
            messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            JOptionPane.showMessageDialog(null,messageLabel,"Congratulations,", JOptionPane.PLAIN_MESSAGE);
            resultscore++;
        }
        else {
            tf1.setBackground(Color.red);
            tf2.setBackground(Color.red);
            tf3.setBackground(Color.red);
            tf4.setBackground(Color.red);
            tf5.setBackground(Color.red);
            tf6.setBackground(Color.red);
            JLabel messageLabel=new JLabel("Incorrect");
            messageLabel.setFont(new Font("Arial",Font.BOLD,20));
            messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            JOptionPane.showMessageDialog(null,messageLabel,"Try Again", JOptionPane.PLAIN_MESSAGE);



            System.out.println("checkcompteur"+checkcompteur);
            System.out.println(currentwordData+"incorrect"+answer);
            answer="";
        }
    }

    //Methode for rate the player
    private void RateScore() {
        t.stop();
        for(int i=0;i<buttons.length;i++) {
            arrayScore=readFile("src\\Fiels\\score");
            try{
                bestscore = Integer.parseInt(arrayScore[level-1]);
            } catch(NumberFormatException ex){

            }
        }
        scor=minutes+seconds;
        if(scor<bestscore||bestscore==0) {
            Path path=Paths.get("src\\Fiels\\score");
            try {
                ArrayList<String> lines=(ArrayList) Files.readAllLines(path);
                lines.set(level-1, String.valueOf(scor));
                Files.write(path,lines);

            } catch (IOException e) {

            }
        }
        else {
            Path path=Paths.get("src\\Fiels\\score");
            try {
                ArrayList<String> lines=(ArrayList) Files.readAllLines(path);
                //lines.set(level-1, String.valueOf(scor));
                Files.write(path,lines);

            } catch (IOException e) {

            }
        }
    }
    private void starTimer() {
        elapseTime=0;
        t=new Timer(1000, new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                elapseTime+=1000;
                minutes=elapseTime/60000;
                seconds=(elapseTime%60000)/1000;
                stringMinutes=String.format("%02d", minutes);
                stringSeconds=String.format("%02d",seconds);
                muniteLabel.setText(stringMinutes+":");
                secondLabel.setText(stringSeconds);

            }
        });
        t.start();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}
//********************************************************
