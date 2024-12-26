import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) {
    int possible = 0;
    try (BufferedReader fr = new BufferedReader(new FileReader("src/input.txt"))) {
      String line;
      while ((line = fr.readLine()) != null) {
        var subSets = line.split(";");
        for (int i = 0; i < subSets.length; i++) {
          int red = 0;
          int green = 0;
          int blue = 0;
          var s = subSets[i].split(" ");
          for (int j = 0; j < s.length; j++) {
            if (red > 12 && green > 13 && blue > 14) {
              break;
            }
            switch (s[j]) {
              case "red," -> red += Integer.parseInt(s[j - 1]);
              case "green," -> green += Integer.parseInt(s[j - 1]);
              case "blue," -> blue += Integer.parseInt(s[j - 1]);
            }
          }
          if (red <= 12 && green <= 13 && blue <= 14) {
            System.out.println("Blue: " + blue);
            possible++;
          }
        }
      }
    } catch (IOException e) {
      e.getStackTrace();
    }
    System.out.println(possible);
  }
}
