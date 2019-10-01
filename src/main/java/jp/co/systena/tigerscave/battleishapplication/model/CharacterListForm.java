package jp.co.systena.tigerscave.battleishapplication.model;

public class CharacterListForm {
  //キャラの名前
  public String name;
  //キャラの職業
  public String job;
  public String getName() {
    return name;
  }

 public void setName(String name) {
    this.name = name;
  }

public String getJob() {
    return job;
 }

public void setJob(String job) {
    this.job = job;
 }
/*
  @Valid
  private List<Character> characterList;

  public List<Character> getCharacterList() {
    return characterList;
  }

  public void setCharacterList(List<Character> characterList) {
    this.characterList = characterList;
  }
*/
}
