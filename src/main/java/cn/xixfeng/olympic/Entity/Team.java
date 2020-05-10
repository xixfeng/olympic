package cn.xixfeng.olympic.Entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Team {

  private long teamId;
  private long regionId;
  private long athleteId;
  private String desc;

  @Id
  public long getTeamId() {
    return teamId;
  }

  public void setTeamId(long teamId) {
    this.teamId = teamId;
  }

  public long getRegionId() {
    return regionId;
  }

  public void setRegionId(long regionId) {
    this.regionId = regionId;
  }

  public long getAthleteId() {
    return athleteId;
  }

  public void setAthleteId(long athleteId) {
    this.athleteId = athleteId;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
}
