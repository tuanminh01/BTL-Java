package CSDL;

import Algorithm.food;
import Algorithm.snake;

import java.sql.*;
import java.util.Properties;

public class Connect {
    static String DRIVER_CLASS;
    static String DB_URL;
    static String USER;
    static String PASS;
    static int last_id=0;


    public static void setConnectionDetails(Properties p) {
        DRIVER_CLASS = p.getProperty("DRIVER_CLASS");
        DB_URL = p.getProperty("DB_URL");
        USER = p.getProperty("USER");
        PASS = p.getProperty("PASS");
    }

    public static int getFood() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement stmt = null; //cung cấp các phương thức để thực thi câu lệnh truy vấn
        int max=0;
        try {
            Class.forName(DRIVER_CLASS);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, name, score FROM topscore");
            while (rs.next()) {
                String name = rs.getString("name");
                int score = rs.getInt("score");
                int id = rs.getInt("id");
                if (score > max)    max = score;
                last_id=id;
            }
            rs.close();
        }catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();
        }
//        System.out.println("Done!");
        return max;
    }
    public static void setFood(String name, int score) {
        try {
            String sql = "INSERT INTO topscore (name, score, id)"
                    + "VALUES (?, ?, ?)";
            Connection conn = null;
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement pstms = conn.prepareStatement(sql);//thực thi câu lệnh sql với tham số truyền vào
            pstms.setString(1, name);
            pstms.setInt(2, score);
            pstms.setInt(3, last_id+1);
            pstms.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}