import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Task1 {
    public static void main(String[] args) {
        String str = getString("C:\\Users\\riba3\\Documents\\hw9\\src\\File.txt");
        String[] words = str.split("\n");
        List<String> list = new ArrayList<>();

        for (String word: words) {
            if (isFormat(word)) list.add(word);
        }
        for(String s: list) {
            System.out.println(s);
        }

    }
    public static boolean isFormat(String str){
        char[] chars= str.toCharArray();
        if ((chars[3] == '-' & chars[7] == '-') | (chars[0] =='(' & chars[4] == ')' & chars[5]==' '& chars[9] =='-')){
            return true;
            }
        else return false;
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
