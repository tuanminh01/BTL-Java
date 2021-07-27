package Actions;

import Algorithm.snake;
import CSDL.Connect;
import IO.sound;

import javax.sound.sampled.Clip;
import java.lang.Thread;
import java.sql.SQLException;

public class gameClock extends Thread{
    public boolean running = true;
    public static int max;
    public static Clip growSound;
    public Clip crashSound;
    public void run(){
        crashSound = sound.getSound("crash.wav");
        growSound = sound.getSound("blop.wav");
        while(running){
            try {
                sleep(100);
                snake.move();
                snake.waitToMove = false;
                Collision.collidePickUp();
                if(Collision.collideSelf()){
                    snake.tails.clear();
                    snake.head.setX(-1);
                    snake.head.setY(-1);
                    snake.score = 0;
                }
                if(Collision.collideWall()){
                    snake.tails.clear();
                    snake.head.setX(-4);
                    snake.head.setY(-4);
                    snake.score = 0;
                }
                max=Connect.getFood();
                if (snake.bestscore > max)  max = snake.bestscore;
                if (Collision.collideWall() || Collision.collideSelf()) {
                    max=Connect.getFood();
                    if (snake.bestscore > max)  max = snake.bestscore;
                    Connect.setFood("Nguyễn Tuấn Minh", snake.bestscore);
                    join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
