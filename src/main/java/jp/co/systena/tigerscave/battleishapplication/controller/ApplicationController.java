package jp.co.systena.tigerscave.battleishapplication.controller;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.battleishapplication.model.CharacterListForm;
import jp.co.systena.tigerscave.battleishapplication.model.Fighter;
import jp.co.systena.tigerscave.battleishapplication.model.Job;


@Controller // Viewあり。Viewを返却するアノテーション
public class ApplicationController {

  @Autowired
  HttpSession session;
  //リストの作成
  ArrayList<Job> character = new ArrayList<Job>();
  //クラス名 インスタンス名= new クラス名();
  Fighter fighter = new Fighter();

  //キャラ作成画面
  @RequestMapping(value = "/battle", method = RequestMethod.GET) // URLとのマッピング
  public ModelAndView index(ModelAndView mav) {
    // Viewのテンプレート名を設定
    mav.setViewName("CharacterCreateView");
    return mav;
  }

  //キャラリスト画面
  @RequestMapping(value = "/characters", method = RequestMethod.POST) // URLとのマッピング
  public ModelAndView characters(
      @RequestParam(value="name") String name,
      @RequestParam(value="job") String job,
      ModelAndView mav) {

    //<クラス名>.<メソッド名>();
    fighter.setName(name);
    fighter.setJob(job);
    //↑こいつをリストに入れてあげる
    character.add(fighter);
    //System.out.println(character);
    session.setAttribute("character",character);
    mav.addObject("character", character);
    //character.forEach(s -> System.out.println(s));
    mav.setViewName("CharacterListView");
    return mav;

  }

  //キャラコマンド画面
  @RequestMapping(value = "battle2", method = RequestMethod.POST) // URLとのマッピング
  public ModelAndView battle2(
        @RequestParam(value="character") ArrayList<CharacterListForm> character,
        ModelAndView mav) {
    //コマンドによって行動を変える
    Job job = null;
/*
    //キャラクターごとに設定
    character.forEach(characterData -> {
      if (characterData.job == "戦士") {
        job = new Warrior();
        break;
      } else if (characterData.job == "魔法使い") {
        job = new Magician();
        break;
      } else if (characterData.job == "武闘家") {
        job = new Fighter();
        break;
      }
    //jobをセッション保存
    session.setAttribute("job",job);
    //コマンドをリストに入れる
    fighter.setJob(job);
    character.add(fighter);
    });
*/
    mav.addObject("character", character);

    mav.setViewName("CommandConfirmationView");
    return mav;
}

  //結果画面
  @RequestMapping(value = "result", method = RequestMethod.POST) // URLとのマッピング
  public ModelAndView result(
        @RequestParam(value="character") ArrayList<String> character,
        @RequestParam(value="command") String command,

        ModelAndView mav) {
    Job job = null;
    Object item = null;
    Object action = null;
    Object damage = null;
    if (command.equals("たたかう")) {
    //戦う場合
      job = (Job) session.getAttribute("job");
      item = job.battle();
      action = "攻撃";
      damage = "敵に10ダメージ";
    } else if (command.equals("かいふく")) {
      //回復する場合
       job = (Job) session.getAttribute("job");
       item = job.Heal();
       action = "回復";
    }

    Object villan = 100;
    if (action =="攻撃") {
      villan =90;
    }

    mav.addObject("character", character);
    mav.addObject("item", item);
    mav.addObject("action", action);
    mav.addObject("damage", damage);
    mav.addObject("villan", villan);

    mav.setViewName("ResultBattleView");
    return mav;
}
}
