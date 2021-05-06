package Javafiles;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        String output = getString("src/resources/File2.txt");
        List<Person> list = new ArrayList<>();
        String[] str = output.split("\n");
        for (int i = 1; i < str.length; i++) {
            String[] rez = str[i].split(" ");
            list.add(new Person(rez[0],Integer.parseInt(rez[1].trim())));
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(list);
        try(FileOutputStream fileOutputStream = new FileOutputStream("src/resources/result.json"))
        {
            byte[] buffer = json.getBytes();
            fileOutputStream.write(buffer, 0, buffer.length);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
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
    static class Person {
        private final String name;
        private final int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}

