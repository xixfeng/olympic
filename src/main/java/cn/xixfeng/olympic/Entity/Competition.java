package cn.xixfeng.olympic.Entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Competition {

  private long competitionId;
  private long projectId;
  private java.sql.Timestamp time;
  private String location;

  @Id
  public long getCompetitionId() {
    return competitionId;
  }

  public void setCompetitionId(long competitionId) {
    this.competitionId = competitionId;
  }

  public long getProjectId() {
    return projectId;
  }

  public void setProjectId(long projectId) {
    this.projectId = projectId;
  }

  public Timestamp getTime() {
    return time;
  }

  public void setTime(Timestamp time) {
    this.time = time;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }
}
