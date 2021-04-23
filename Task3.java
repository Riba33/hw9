import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        String way= "C:\\Users\\riba3\\Documents\\hw9\\src\\words.txt";
        Scanner scanner = new Scanner(getString(way));
        List<String> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.next());
        }
        scanner.close();
        Collections.sort(list);
        Map<String,Integer> map = new HashMap<>();
        getMap(list).forEach((k,v) ->map.put(v,k));
        map.forEach((k,v) -> System.out.println(k + " " + v));

    }
    public static Map<Integer,String> getMap(List<String> list) {
        Map<Integer,String> map = new TreeMap<>();
        String stringCompare = list.get(0);
        int count = 0;
        for(int i = 0; i < list.size(); i ++){
            if (stringCompare.equals(list.get(i))) {
                count++; if(i == list.size()-1) {
                    map.put(count,stringCompare);
                }
            }
            else { map.put(count,stringCompare);
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
