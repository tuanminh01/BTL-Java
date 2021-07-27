package Actions;

import Algorithm.Dir;
import Algorithm.snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKey implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (!(snake.head.getDir() == Dir.DOWN) && !snake.waitToMove) {
                    snake.head.setDir(Dir.UP);
                    snake.waitToMove = true;
                }
                break;
            case KeyEvent.VK_LEFT:
                if (!(snake.head.getDir() == Dir.RIGHT) && !snake.waitToMove) {
                    snake.head.setDir(Dir.LEFT);
                    snake.waitToMove = true;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (!(snake.head.getDir() == Dir.UP) && !snake.waitToMove) {
                    snake.head.setDir(Dir.DOWN);
                    snake.waitToMove = true;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (!(snake.head.getDir() == Dir.LEFT) && !snake.waitToMove) {
                    snake.head.setDir(Dir.RIGHT);
                    snake.waitToMove = true;
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
