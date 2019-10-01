package jp.co.systena.tigerscave.battleishapplication.model;

public abstract class Job {
  //キャラの名前
  protected String name;
  //キャラの職業
  protected String job;

 public abstract String battle();
 public abstract String Heal();

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
}
