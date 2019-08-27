package jp.co.systena.tigerscave.battleishapplication.model;

import java.util.ArrayList;
import java.util.List;

public class Magician {
//ListService
  public List<Warrior> getItemList() {


    List<Warrior> itemList = new ArrayList<Warrior>();

    Warrior item = new Warrior();

    item = new Warrior(20);
    itemList.add(item);


    return itemList;
}
}