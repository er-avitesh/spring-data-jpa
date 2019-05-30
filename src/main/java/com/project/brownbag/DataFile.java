package com.project.brownbag;

//This class using entitymanager instead of filehistoryrepository

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@EntityListeners(FileEntityListener.class)
class DataFile extends Auditable<String> {
  @Id
  @GeneratedValue
  private Integer id;
  private String name;
  private String content;

  public DataFile() {
      super();
  }

  public DataFile(String name, String content) {
      this.name = name;
      this.content = content;
  }

  public Integer getId() {
      return id;
  }

  public void setId(Integer id) {
      this.id = id;
  }

  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public String getContent() {
      return content;
  }

  public void setContent(String content) {
      this.content = content;
  }

  @Override
  public String toString() {
      return "File{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", content='" + content + '\'' +
              '}';
  }
}

