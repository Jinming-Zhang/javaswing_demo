package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import utils.AudioPlayer;

public class EasterneggBtCmd implements ICommand, ActionListener {
  private String[] path;
  private int count;
  private int limit = 0;
  private boolean functional;
  private Random r;

  public EasterneggBtCmd(String[] path, int limit) {
    this.path = path;
    count = 0;
    this.limit = limit;
    functional = true;
    r = new Random();
  }

  @Override
  public void Execute() {
    if (functional) {
      ++count;
      if (count >= limit && r.nextInt(100) < 20) {
        AudioPlayer.playSFX("/audio/Never Gonna Give You Up Original.wav");
        functional = false;
      } else {
        int index = r.nextInt(path.length);
        AudioPlayer.playSFX(path[index]);
      }
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Execute();
  }

}
