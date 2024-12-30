package ArrayAndString;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * <p>Symbol Value I 1 V 5 X 10 L 50 C 100 D 500 M 1000 For example, 2 is written as II in Roman
 * numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number
 * 27 is written as XXVII, which is XX + V + II.
 *
 * <p>Roman numerals are usually written largest to smallest from left to right. However, the
 * numeral for four is not IIII. Instead, the number four is written as IV. Because the one is
 * before the five we subtract it making four. The same principle applies to the number nine, which
 * is written as IX. There are six instances where subtraction is used:
 *
 * <p>I can be placed before V (5) and X (10) to make 4 and 9. X can be placed before L (50) and C
 * (100) to make 40 and 90. C can be placed before D (500) and M (1000) to make 400 and 900. Given a
 * roman numeral, convert it to an integer.
 *
 * <p>Example 1:
 *
 * <p>Input: s = "III" Output: 3 Explanation: III = 3. Example 2:
 *
 * <p>Input: s = "LVIII" Output: 58 Explanation: L = 50, V= 5, III = 3. Example 3:
 *
 * <p>Input: s = "MCMXCIV" Output: 1994 Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 * <p>Constraints:
 *
 * <p>1 <= s.length <= 15 s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M'). It is
 * guaranteed that s is a valid roman numeral in the range [1, 3999].
 */
public class RomanToInteger {
  public static void main(String[] args) {
    System.out.println(romanToString("MCMXCIV"));
    System.out.println(romanToString("III"));
    System.out.println(romanToString("IIV"));
  }

  public static int romanToString(String s) {
    Map<String, Integer> romanMap = new HashMap<>();
    romanMap.put("I", 1);
    romanMap.put("V", 5);
    romanMap.put("X", 10);
    romanMap.put("L", 50);
    romanMap.put("C", 100);
    romanMap.put("D", 500);
    romanMap.put("M", 1000);
    romanMap.put("IV", 4);
    romanMap.put("IX", 9);
    romanMap.put("XL", 40);
    romanMap.put("XC", 90);
    romanMap .put("CD", 400);
    romanMap.put("CM", 900);
    int result = 0;
    int i = 0;
    while (i < s.length()) {
      String currChar = String.valueOf(s.charAt(i));
      String nextChar = i > s.length() - 2 ? "NOT FOUND" : String.valueOf(s.charAt(i+1));
      if(romanMap.containsKey(currChar + nextChar)){
        i++;
        result += romanMap.get(currChar + nextChar);
      } else {
        result += romanMap.get(currChar);
      }
      i++;
    }
    return result;
  }
}
