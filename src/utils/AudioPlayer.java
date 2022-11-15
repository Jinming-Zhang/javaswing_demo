package utils;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioPlayer {
  public static void playSFX(String clipPath) {
    var url = AudioPlayer.class.getResource(clipPath);
    try {
      AudioInputStream s = AudioSystem.getAudioInputStream(url);
      Clip clip = AudioSystem.getClip();
      clip.open(s);
      clip.start();
      clip.loop(0);
    } catch (Exception e) {
      // TODO: handle exception
    }
  }

  public static void playSFX(String clipPath, boolean loop) {
    var url = AudioPlayer.class.getResource(clipPath);
    try {
      AudioInputStream s = AudioSystem.getAudioInputStream(url);
      Clip clip = AudioSystem.getClip();
      clip.open(s);
      clip.start();
      if (!loop) {
        clip.loop(0);
      } else {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
      }
    } catch (Exception e) {
      // TODO: handle exception
    }
  }
}
