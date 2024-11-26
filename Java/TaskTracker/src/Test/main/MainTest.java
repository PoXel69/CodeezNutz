package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainTest {

  @Test
  void testToString_ToStartFromSecondIndex() {
    var result = Main.toString(new String[] {"this", "should", "start", "from", "here"}, 2);
    assertEquals("start from here", result);
  }

  @Test
  void testToString_ToStartFromFirstIndex() {
    var result = Main.toString(new String[] {"this", "should", "start", "from", "here"}, 1);
    assertEquals("should start from here", result);
  }

  @Test
  void testStringIsNotNumber() {
    var result = Main.isNumber("hello world");
    assertFalse(result, "Should return false");
  }

  @Test
  void testNumberIsNumber() {
    var result = Main.isNumber("234");
    assertTrue(result, "Should return true");
  }

  @Test
  void testNegativeNumberIsNumber() {
    var result = Main.isNumber("-23423");
    assertTrue(result, "Should return true");
  }
}
