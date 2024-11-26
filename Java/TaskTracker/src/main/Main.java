package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
  private static final HashMap<Integer, Task> tracker = new HashMap<>();

  public static void main(String[] args) {
    boolean inUse = true;
    greeting();
    var scan = new Scanner(System.in);
    while (inUse) {
      var arg = scan.nextLine().split(" ");
      var cmd = arg[0];

      switch (cmd) {
        case "add" -> {
          addTaskToTracker(
              new TaskBuilder().setDescription(toString(arg, 1)).setID(tracker.size() + 1).build());
          list();
        }
        case "ls", "list" -> list();
        case "update" -> {
          tracker.replace(
              isNumber(arg[1]) ? Integer.parseInt(arg[1]) : tracker.size(),
              new TaskBuilder().setDescription(toString(arg, 2)).setID(tracker.size() + 1).build());
          list();
        }
        case "delete", "remove", "rm" -> {
          tracker.remove(isNumber(arg[1]) ? Integer.parseInt(arg[1]) : tracker.size());
          list();
        }
        case "quit", "q" -> inUse = false;
        default -> System.err.println("Invalid Input, Try Again.");
      }
    }
  }

  private static void greeting() {
    System.out.println("Hello and welcome to the TaskTracker 1.0vTM");
  }

  static void list() {
    if (tracker.isEmpty()) {
      System.out.println("There are no Task in your Tracker");
      return;
    }
    for (int i = 1; i < tracker.size() + 1; i++) {
      System.out.println(i + ". " + tracker.get(i));
    }
  }

  static void addTaskToTracker(Task task) {
    tracker.put(task.getUniqueID(), task);
  }

  public static boolean isNumber(String str) {
    return str.matches("-?\\d+(\\.\\d+)?");
  }

  static String toString(String[] arg, int startIndex) {
    return String.join(" ", Arrays.copyOfRange(arg, startIndex, arg.length));
  }
}
