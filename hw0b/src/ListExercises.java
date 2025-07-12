import org.checkerframework.checker.units.qual.A;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListExercises {

    /** Returns the total sum in a list of integers */
    public static int sum(List<Integer> L) {
        int sumOfList = 0;
        for (Integer integer : L) {
            sumOfList = sumOfList + integer;
        }
        return sumOfList;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        List<Integer> evenOfL = new ArrayList<>();
        for (int i = 1; i < L.size(); i = i + 2){
            evenOfL.add(L.get(i));
        }
        return evenOfL;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        List<Integer> commonItem = new ArrayList<>();
        // 哈希函数法
        Set<Integer> elementsInL1 = new HashSet<>(L1);

        for (Integer itemFromL2 : L2){
            if (elementsInL1.contains(itemFromL2)){
                commonItem.add(itemFromL2);
            }
        }
        return commonItem;

///  普通遍历方法
///  for (Integer integerL1 : L1){
///          for (Integer integerL2 : L2) {
///              if (integerL1 == integerL2) {
///                  commonItem.add(integerL1);
///              }
///          }
///      }
///      return commonItem;
}


    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        // TODO: Fill in this function.
        int numOfOccur = 0;
        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == c) {
                    numOfOccur++;
                }
            }
        }
        return numOfOccur;
    }
}
