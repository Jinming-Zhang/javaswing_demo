package components;

import javax.swing.JButton;

import commands.ICommand;

public class CommandJB extends JButton {
  ICommand onBtnClicked;

  public CommandJB(ICommand onBtnClicked) {
    this.onBtnClicked = onBtnClicked;
    addActionListener(l -> onBtnClicked.Execute());
  }
}
