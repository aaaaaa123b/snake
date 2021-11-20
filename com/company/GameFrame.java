package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class GameFrame extends JPanel implements ActionListener {

    public static JFrame jFrame;
    public static final int SCALE = 31;
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;

    public static int speed = 10;
    int score =0;


    ssnake s = new ssnake(5, 6, 5, 5);
    apple ap = new apple(Math.abs((int) (Math.random() * GameFrame.WIDTH - 1)), Math.abs((int) (Math.random() * GameFrame.HEIGHT - 1)));
    Timer timer = new Timer(1000 / speed, this);

    Image img = new ImageIcon ("src/apple7.png").getImage();
    Image fon = new ImageIcon ("src/pole2.png").getImage();
    Image head = new ImageIcon ("src/head.png").getImage();
    Image left = new ImageIcon ("src/left.png").getImage();
    Image niz = new ImageIcon ("src/head22.png").getImage();
    Image right = new ImageIcon ("src/head33.png").getImage();
    Image telo = new ImageIcon ("src/telo1.png").getImage();


    public GameFrame() {
        timer.start();
        //вызов клавиатуры
        addKeyListener(new KeyBoard());
        setFocusable(true);
    }


    // создание клеточек на поле
    public void paint(Graphics g) {

       // g.setColor(Color.CYAN);
        g.fillRect((int)0, (int)0, WIDTH * SCALE, HEIGHT * SCALE);
        for (int x = 0; x < WIDTH * SCALE; x += SCALE) {
           // g.setColor(Color.CYAN);
           // g.drawLine(x, 0, x, HEIGHT * SCALE);

        }
        for (int y = 0; y < HEIGHT * SCALE; y += SCALE) {
           // g.setColor(Color.CYAN);
          //  g.drawLine(0, y, WIDTH * SCALE, y);
        }
        g.drawImage(fon,(int)0 , (int)0,null);

        //яблоко создание

        g.drawImage(img,ap.posX * SCALE + 4, ap.posY * SCALE + 4,null);




        for (int l = 1; l < s.lenght; l++) {
            //создание самой змеи

            g.drawImage(telo,s.sX[l] * SCALE + 1, s.sY[l] * SCALE + 1, null);

            if (s.direction==2)g.drawImage(niz,s.sX[0] * SCALE + 1, s.sY[0] * SCALE + 1,null);
            if (s.direction==1)g.drawImage(left,s.sX[0] * SCALE + 1, s.sY[0] * SCALE + 1,null);
            if (s.direction==3)g.drawImage(right,s.sX[0] * SCALE + 1, s.sY[0] * SCALE + 1,null);
            if (s.direction==0)g.drawImage(head,s.sX[0] * SCALE + 1, s.sY[0] * SCALE + 1,null);



        }
        g.setColor(Color.WHITE);
        g.setFont(new Font("arial",Font.PLAIN,14));
        g.drawString("Score:"+score, 550,30);
    }

    public static void main(String[] args) {
        jFrame = new JFrame("Title");
        //размер окна
        jFrame.setSize(WIDTH * SCALE + 6, HEIGHT * SCALE + 28);
// закрывает окно
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //расположение окна по центру
        jFrame.setLocationRelativeTo(null);
        jFrame.add(new GameFrame());
        // пофвление окна
        jFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // движение
        s.move();


        if ((s.sX[0] == ap.posX) && (s.sY[0] == ap.posY)) {
            ap.setRandomPosition();
            s.lenght++;
            score ++;
        }

        for (int l = 1; l < s.lenght; l++) {
            if ((s.sX[l] == ap.posX) && (s.sY[l] == ap.posY)) {
                ap.setRandomPosition();
            }
            if ((s.sX[0] == s.sX[l]) && (s.sY[0] == s.sY[l]))  {
                timer.stop();
               JOptionPane.showMessageDialog(null,"Вы проиграли");
                jFrame.setVisible(false);
                s.lenght =2;
                s.direction=0;
                ap.setRandomPosition();
                jFrame.setVisible(true);
                timer.start();


            }


        }
        repaint();
    }
        //движение по клавишам
        public class KeyBoard extends KeyAdapter {
            public void keyPressed(KeyEvent event) {

                int key = event.getKeyCode();

                if ((key == KeyEvent.VK_UP) && (s.direction != 2)) s.direction = 0;//в обратную сторону нельзя
                if ((key == KeyEvent.VK_DOWN) && (s.direction != 0)) s.direction = 2;
                if ((key == KeyEvent.VK_RIGHT) && (s.direction != 3)) s.direction = 1;
                if ((key == KeyEvent.VK_LEFT) && (s.direction != 1)) s.direction = 3;

            }
        }

    }



