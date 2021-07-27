package Actions;

import Algorithm.snake;
import IO.sound;


public class Collision {

    public static boolean collideSelf() {
        for(int i = 0; i<snake.tails.size(); i++){
            if(snake.head.getX() == snake.tails.get(i).getX() && snake.head.getY() == snake.tails.get(i).getY()
                    && !snake.tails.get(i).isWait()){
                return true;
            }

        }

        return false;
    }

    public static boolean collideWall() {

        return (snake.head.getX() < 0 || snake.head.getX() > 15 || snake.head.getY() < 0 || snake.head.getY() > 15);
    }

    public static void collidePickUp() {
        if (snake.head.getX() == snake.pickup.getX() && snake.head.getY() == snake.pickup.getY()) {
            sound.playSound(gameClock.growSound);
            snake.pickup.reset();
            snake.addTail();
            snake.score +=1;
            if(snake.score > snake.bestscore) snake.bestscore = snake.score;
        }
    }
}
