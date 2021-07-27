package GUI;

import Actions.Collision;
import Actions.gameClock;
import Algorithm.snake;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Controller extends JLabel  {

    Point p;
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            draw(g);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics g) throws SQLException, ClassNotFoundException {
        //Draw Background
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, Board.width, Board.height);

        //Draw Snake Tails
        g.setColor(new Color(51, 204, 51));
        for (int i = 0; i < snake.tails.size(); i++) {
            p = snake.ptc(snake.tails.get(i).getX(), snake.tails.get(i).getY());
            g.fillRect(p.x, p.y, 32, 32);
        }

        //Draw Snake Head
        g.setColor(new Color(0, 153, 0));
        p = snake.ptc(snake.head.getX(), snake.head.getY());
        g.fillRect(p.x, p.y, 32, 32);

        //Draw PickUp
        g.setColor(new Color(204, 51, 0));
        p = snake.ptc(snake.pickup.getX(), snake.pickup.getY());
        g.fillRect(p.x, p.y, 32, 32);

        //Draw Grid
        g.setColor(Color.GRAY);
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                g.drawRect(i * 32 + Board.xoff, j * 32 + Board.yoff, 32, 32);
            }
        }

        //Draw Border
        g.setColor(Color.BLACK);
        g.drawRect(Board.xoff, Board.yoff, 512, 512);

        //Draw Score
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + snake.score, 5, 25);
        g.drawString("Best: " + gameClock.max, 655, 25);

        //Draw GameOver
        if (Collision.collideWall() || Collision.collideSelf()) {
            g.setColor(Color.red);
            g.setFont(new Font("Asia", Font.BOLD, 75));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Game Over", (Board.width - metrics.stringWidth("Game Over")) / 2 + 20, Board.height / 2 - 50);
        }
        //Draw BestScore
        if (Collision.collideWall() || Collision.collideSelf()) {
            g.setColor(Color.red);
            g.setFont(new Font("Asia", Font.BOLD, 75));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Best Score: " + gameClock.max, (Board.width - metrics.stringWidth("Game Over")) / 2 - 50, Board.height / 2 + 60);
        }

        repaint();
    }
}
