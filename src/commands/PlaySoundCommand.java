package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import utils.AudioPlayer;

public class PlaySoundCommand implements ICommand, ActionListener {

  String audioPath;

  public PlaySoundCommand(String audioPath) {
    this.audioPath = audioPath;
  }

  @Override
  public void Execute() {
    AudioPlayer.playSFX(audioPath);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Execute();
  }

}
