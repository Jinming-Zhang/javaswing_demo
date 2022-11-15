package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import utils.AudioPlayer;

public class PlaySoundCommand implements ICommand, ActionListener {

  String audioPath;
  public boolean loop;

  public PlaySoundCommand(String audioPath) {
    this.audioPath = audioPath;
    loop = false;
  }

  @Override
  public void Execute() {
    AudioPlayer.playSFX(audioPath, loop);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Execute();
  }

}
