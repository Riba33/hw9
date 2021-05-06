package Javafiles;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class Task1 {
    public static void main(String[] args) {
        String str = getString("src/resources/File.txt");
        String[] words = str.split("\n");
        List<String> list = new ArrayList<>();

        for (String word: words) {
            if (isFormat(word.trim())) list.add(word.trim());
        }
        for(String s: list) {
            System.out.println(s);
        }

    }
    public static boolean isFormat(String str){
        String regex1 = "[(]\\d{3}[)][ ]\\d{3}[-]\\d{4}";
        String regex2 = "\\d{3}[-]\\d{3}[-]\\d{4}";
        return Pattern.matches(regex2,str) || Pattern.matches(regex1,str);
    }
    public static String getString(String way){
        String str = "";
        try (FileReader reader = new FileReader(way))
        {
            int c;

            while ((c = reader.read()) != -1)
            {
                str += (char) c;
            }
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        return str;
    }
}