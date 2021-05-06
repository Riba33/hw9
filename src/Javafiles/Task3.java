package Javafiles;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        String way= "src/resources/words.txt";
        Scanner scanner = new Scanner(getString(way));
        List<String> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.next());
        }
        scanner.close();
        Collections.sort(list);
        getMap(list)
                .entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(e ->System.out.println(e.getKey() + " " + e.getValue()));

    }
    public static Map<String,Integer> getMap(List<String> list) {
        Map<String,Integer> map = new HashMap<>();
        String stringCompare = list.get(0);
        int count = 0;
        for(int i = 0; i < list.size(); i ++){
            if (stringCompare.equals(list.get(i))) {
                count++; if(i == list.size()-1) {
                    map.put(stringCompare,count);
                }
            }
            else { map.put(stringCompare,count);
                stringCompare = list.get(i);
                count = 1;
            }
        }
        return map;
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
