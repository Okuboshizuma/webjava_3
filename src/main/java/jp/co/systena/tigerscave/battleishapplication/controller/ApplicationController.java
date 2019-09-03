package jp.co.systena.tigerscave.battleishapplication.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller // Viewあり。Viewを返却するアノテーション
public class ApplicationController {

  @Autowired
  HttpSession session;

  @RequestMapping(value = "/battle", method = RequestMethod.GET) // URLとのマッピング
  public ModelAndView index(ModelAndView mav) {
    // Viewのテンプレート名を設定
    mav.setViewName("CharacterCreateView");
    return mav;
  }
  @RequestMapping(value = "battle2", method = RequestMethod.POST) // URLとのマッピング
  public ModelAndView battle2(
        @RequestParam(value="name") String name,
        @RequestParam(value="jobs") String jobs,
        ModelAndView mav) {

    mav.addObject("name", name);
    mav.addObject("jobs", jobs);

    mav.setViewName("CommandConfirmationView");
    return mav;
}

  @RequestMapping(value = "result", method = RequestMethod.POST) // URLとのマッピング
  public ModelAndView result(
        @RequestParam(value="name") String name,
        @RequestParam(value="jobs") String jobs,
        ModelAndView mav) {

    switch (jobs) {
      case "戦士":
        jobs = "剣";
          break;

      case "魔法使い":
        jobs = "魔法";
          break;
  }

    mav.addObject("name", name);
    mav.addObject("jobs", jobs);


    mav.setViewName("ResultBattleView");
    return mav;
}
}
