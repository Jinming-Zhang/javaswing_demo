package components;

import javax.swing.JButton;

import commands.ICommand;

public class CommandJBtn extends JButton {
  ICommand onBtnClicked;

  public CommandJBtn() {
    super();
    onBtnClicked = null;
  }

  public CommandJBtn(String text) {
    super(text);
    onBtnClicked = null;
  }

  public CommandJBtn(String text, ICommand onBtnClicked) {
    super(text);
    this.onBtnClicked = onBtnClicked;
    addActionListener(l -> onBtnClicked.Execute());
  }

  public CommandJBtn(ICommand onBtnClicked) {
    this.onBtnClicked = onBtnClicked;
    addActionListener(l -> onBtnClicked.Execute());
  }
}
