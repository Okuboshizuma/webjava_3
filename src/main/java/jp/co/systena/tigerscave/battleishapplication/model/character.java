package jp.co.systena.tigerscave.battleishapplication.model;

import javax.validation.constraints.Pattern;

public class character {
  //DBを用いた書き方挑戦
  @Pattern(regexp="^[0-9]*$")
  private String characterId;
  public String getCharacterId() {
    return characterId;
  }
  public void setCharacterId(String characterId) {
    this.characterId = characterId;
  }
  public String getCharacterName() {
    return characterName;
  }
  public void setCharacterName(String characterName) {
    this.characterName = characterName;
  }
  public String getCharacterJob() {
    return characterJob;
  }
  public void setCharacterJob(String characterJob) {
    this.characterJob = characterJob;
  }
  private String characterName;
  @Pattern(regexp="^[0-9]*$")
  private String characterJob;

}
