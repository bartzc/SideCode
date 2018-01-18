package chrisFunTime;

import java.awt.*;
import javax.swing.JFrame;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

public class GroupProject2 extends Canvas implements ActionListener, KeyListener
{
    Random rndm=new Random();
    boolean play = false;

    int snake= 50;
    javax.swing.Timer timer;
    int delay = 9;
    int snakeXdir = -1;
    int snakeYdir = 0;
    int snakeposX = 400;
    int snakeposY = 300;
    int snake2 = 20;

    int squareX=rndm.nextInt(800)-10;
    int squareY=rndm.nextInt(600)-10;

    public GroupProject2(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint( Graphics g ){
        //snake
        g.setColor(Color.black);
        g.fillRect(snakeposX, snakeposY, snake, snake2); 

        //boxes
        g.fillRect(squareX, squareY, 20, 20);
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if(play==true){
            //moves snake
            snakeposX += snakeXdir;
            snakeposY += snakeYdir;
            //keeps snake in bounds
            if(snakeposX<0){
                snakeXdir=-snakeXdir;
            }
            if(snakeposY<0){
                snakeYdir=-snakeYdir;
            }
            if(snakeposX>800){
                snakeXdir=-snakeXdir;
            }
            if(snakeposY>600){
                snakeYdir=-snakeYdir;
            }
            //shows location of the snake
            System.out.println("X pos is " +snakeposX+ " Y pos is " +snakeposY);
            System.out.println("Square is at " +squareX+","+squareY);
        }
        //recreates box and lengthens snake

        if((snakeposX==squareX)&&(snakeposY==squareY)){
            

            snake=snake+20;
            int squareX2=rndm.nextInt(800)-10;
            int squareY2=rndm.nextInt(600)-10;
            squareX=squareX2;
            squareY=squareY2;

        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){

            moveRight();

        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){

            moveLeft();

        }
        if(e.getKeyCode() == KeyEvent.VK_UP){

            moveUp();

        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){

            moveDown();

        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            if(!play){
                play = true;
                snakeposX = 400;
                snakeposY = 300;
                snakeXdir = -1;
                snakeYdir = 0;
                snake = 50;

                repaint();

            }
        }
        repaint();

    }

    public void moveUp(){
        play = true;
        snakeYdir-=2;
        snakeXdir=0;
        int snake3 = snake2;
        snake2=snake;
        snake=snake3;
    }

    public void moveDown(){
        play = true;
        snakeYdir+=2;
        snakeXdir=0;
        int snake3 = snake2;
        snake2=snake;
        snake=snake3;
    }

    public void moveLeft(){
        play = true;
        snakeXdir-=2;
        snakeYdir=0;
        int snake3 = snake2;
        snake2=snake;
        snake=snake3;
    }

    public void moveRight(){
        play = true;
        snakeXdir+=2;
        snakeYdir=0;
        int snake3 = snake2;
        snake2=snake;
        snake=snake3;
    }

    public static void main( String [] args){
        JFrame win = new JFrame();
        win.setSize(800, 600);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GroupProject2 canvas = new GroupProject2();
        win.add( canvas );
        win.setVisible(true);

    }
}


