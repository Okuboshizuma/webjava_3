package jp.co.systena.tigerscave.battleishapplication.model;

public class Warrior {
  //Item
  private int itemid;
  public int getItemid() {
    return itemid;
  }

  public void setItemid(int itemid) {
    this.itemid = itemid;
  }
  public Warrior() {

  }

  public Warrior(int itemid) {
    this.itemid = itemid;
  }
}
