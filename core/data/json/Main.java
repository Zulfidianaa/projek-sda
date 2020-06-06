package json;

import json.read.ReadFile;
import json.hash.*;

public class Main {
    public static void main(String q[]) {
        ReadFile file = new ReadFile("json/file/data.txt");
        HashTable hash = new HashTable(file.getLine().size());
        file.getLine().forEach((line) -> {
            String[] data = line.split("::");
            hash.add(data[0], data[1]);
        });

        String option = q[0];
        if (option.equals("1")) {
            System.out.print("[");
            hash.display();
            System.out.print("]");
        } else if (option.equals("2")) {
            hash.searchKey(q[1]);
        }
    }
}