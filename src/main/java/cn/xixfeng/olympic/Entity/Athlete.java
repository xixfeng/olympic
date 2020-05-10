package cn.xixfeng.olympic.Entity;

import javax.persistence.*;

@Entity
public class Athlete {

  private long athleteId;
  private long regionId;
  private String name;

  @Id
  public long getAthleteId() {
    return athleteId;
  }

  public void setAthleteId(long athleteId) {
    this.athleteId = athleteId;
  }

  public long getRegionId() {
    return regionId;
  }

  public void setRegionId(long regionId) {
    this.regionId = regionId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
