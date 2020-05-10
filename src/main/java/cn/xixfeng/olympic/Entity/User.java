package cn.xixfeng.olympic.Entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

  private long wxUid;
  private String avatar;
  private String gender;
  private String description;
  private String name;

  public User(){}

  public User(long wxUid,String avatar,String name,String description,String gender){
    this.wxUid = wxUid;
    this.avatar = avatar;
    this.name = name;
    this.description = description;
    this.gender = gender;
  }

  @Id
  public long getWxUid() {
    return wxUid;
  }

  public void setWxUid(long wxUid) {
    this.wxUid = wxUid;
  }


  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
