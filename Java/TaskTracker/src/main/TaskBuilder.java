package main;

public class TaskBuilder {

  private Task task;

  public TaskBuilder() {
    this.reset();
  }

  private void reset() {
    this.task = new Task();
  }

  public TaskBuilder setDescription(String description) {
    task.setDescription(description);
    return this;
  }

  public TaskBuilder setID(int uniqueID) {
    task.setUniqueID(uniqueID);
    return this;
  }

  public Task build() {
    return task;
  }
}
