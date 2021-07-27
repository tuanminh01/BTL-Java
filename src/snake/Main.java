package snake;

import CSDL.Connect;
import GUI.Board;
import Actions.gameClock;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Main{
    public static void main(String[] args) throws IOException {
        File f = new File("resources/config.properties");
        FileReader fr = new FileReader(f);
        BufferedReader br = null;
        Properties p = new Properties();
        try {
            br = new BufferedReader(fr);
            p.load(br);
        } finally {
            br.close();
        }
        Connect.setConnectionDetails(p);
        Board snake = new Board();
        gameClock g = new gameClock();
        g.start();
    }
}