package jp.co.systena.tigerscave.battleapplicationcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.battleishapplication.model.Magician;
import jp.co.systena.tigerscave.battleishapplication.model.Warrior;

@Controller // Viewあり。Viewを返却するアノテーション
public class ApplicationController {

  @Autowired
  HttpSession session; // セッション管理
  @RequestMapping(value = "/battle", method = RequestMethod.GET) // URLとのマッピング
  public ModelAndView index(ModelAndView mav) {

    Map<Integer, Warrior> itemListMap = getItemListMap();
    mav.addObject("itemList", itemListMap);


    // Viewのテンプレート名を設定
    mav.setViewName("CharacterCreateView");
    return mav;
  }
  private Map<Integer, Warrior> getItemListMap() {
    Magician service = new Magician();
    List<Warrior> itemList = service.getItemList();

    // 商品一覧をMapに入れ直し
    Map<Integer, Warrior> itemListMap = new HashMap<Integer, Warrior>();
    for (Warrior item : itemList) {
      itemListMap.put(item.getItemid(), item);
    }

    return itemListMap;
  }


}
