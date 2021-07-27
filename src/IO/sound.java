package IO;

import javax.sound.sampled.*;
import java.io.File;

public class sound {
    public static void playSound(Clip clip)
    {
        clip.stop();
        clip.setFramePosition(0);
        clip.start();
    }

    public static Clip getSound(String file)
    {
        try
        {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds" + System.getProperty("file.separator") + file).getAbsoluteFile());
            AudioFormat format = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip sound = (Clip)AudioSystem.getLine(info);
            sound.open(audioInputStream);
            return sound;
        }
        catch(Exception e)
        {
            return null;
        }
    }

}
