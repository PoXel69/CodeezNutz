package main;

public class Task {
  private String description;
  private int uniqueID;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getUniqueID() {
    return uniqueID;
  }

  public void setUniqueID(int uniqueID) {
    this.uniqueID = uniqueID;
  }

  @Override
  public String toString() {
    return description;
  }
}
