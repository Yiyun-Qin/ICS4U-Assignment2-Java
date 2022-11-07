import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/**
 * This function converts the string
 * The numbers in the string are converted into letters next to them.
 *
 * @author  Yiyun Qin
 * @version 1.0
 * @since   2022-11-07
 */

class Blowup {
  /**
   * The function replaces the number in the string to letters on its right.
   *
   */
  static String blowup(String string) {
    List<String> list = new ArrayList<String>();
    String indexString;
    ArrayList<String> answer = new ArrayList<String>();
    String indexNextString;
    int index = -1;
    int indexNext = -1;
    final String answerString;
    list = Arrays.asList(string.split(""));
    for (int loopCounter = 0; loopCounter < list.size(); loopCounter++) {
      indexString = list.get(loopCounter);
      int flag1 = 1;
      int flag2 = 1;
      char indexChar = indexString.charAt(0);
      if (Character.isDigit(indexChar)) {
        flag1 = 1;
      } else {
        flag1 = 0;
      }
      // if the indexString is not the last character in the string
      if (loopCounter + 1 != list.size()) {
        indexNextString = list.get(loopCounter + 1);
        char indexNextChar = indexNextString.charAt(0);
        if (Character.isDigit(indexNextChar)) {
          flag2 = 1;
        } else {
          flag2 = 0;
        }
        // if the index is a number while a letter next to it
        if (flag1 == 1 && flag2 == 0) {
          index = Integer.parseInt(indexString);
          for (int i = 0; i < index; i++) {
            answer.add(indexNextString);
          }
          continue;
          // if two continue number
        } else if (flag1 == 1 && flag2 == 1) {
          continue;
          // if index is a letter
        } else {
          answer.add(indexString);
          continue;
        }
      // if the indexString is the last character in the string
      } else {
        if (flag1 == 1) {
          continue;
        } else {
          answer.add(indexString);
        }
      }
    }
    answerString = String.join("", answer);
    return answerString;
  }

  public static void main(String[] args) {
    String newString;
    Scanner myobj = new Scanner(System.in);
    System.out.print("Input a string: ");
    String input = myobj.next();
    if (input.equals(null)) {
      System.out.println("\nPlease input a string!");
    } else {
      newString = blowup(input);
      System.out.println("\nNew string is " + newString);
    }
    System.out.println("\nDone.");
  }
}
