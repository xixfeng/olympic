package cn.xixfeng.olympic.Entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Project {

  private long projectId;
  private String name;
  private String desc;
  private String rule;
  private String technicalTerm;
  private String imageUrl;

  @Id
  public long getProjectId() {
    return projectId;
  }

  public void setProjectId(long projectId) {
    this.projectId = projectId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public String getRule() {
    return rule;
  }

  public void setRule(String rule) {
    this.rule = rule;
  }

  public String getTechnicalTerm() {
    return technicalTerm;
  }

  public void setTechnicalTerm(String technicalTerm) {
    this.technicalTerm = technicalTerm;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
}
