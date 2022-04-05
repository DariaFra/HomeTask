package Lesson4;
import java.util.*;
public class Words {
    public static void main(String[] args){
        List<String> words = Arrays.asList(
                "Cat", "Dog", "Bat", "Mouse", "Wolf",
                "Wolf", "Rat", "Cat", "Mouse", "Horse",
                "Cat", "Mouse", "Mouse", "Rat", "Tiger",
                "Tiger", "Dog", "Dog", "Rat", "Mouse"
        );

        Set<String> unique = new HashSet<String>(words);

        System.out.println("Уникальные слова:");
        System.out.println(unique.toString());
        System.out.println("Сколько раз встречается каждое слово:");
        for (String key : unique) {
            System.out.println(key + ": " + Collections.frequency(words, key));
        }
    }
}
