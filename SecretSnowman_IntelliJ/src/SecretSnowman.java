import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
public class SecretSnowman {
    static ArrayList<String> a = new ArrayList<String>();
    static ArrayList<String> b = new ArrayList<String>();

    public static void main(String[] args) {
        readNames();
        pair();
    }

    public static void readNames() {
        Scanner names;

        try {
            names = new Scanner(new File("names.txt"));
        } catch(java.io.FileNotFoundException e) {
            System.out.println("FileNotFoundException: " + e.getMessage());
            return;
        }

        while(names.hasNextLine()) {
            String name = names.nextLine();

            a.add(name);
            b.add(name);
        }
        names.close();
    }

    public static void pair() {
        int randIndexA = 0;
        int randIndexB = 0;

        while(a.size() > 1) {
            randIndexA = (int)((a.size()) * Math.random());
            randIndexB = (int)((b.size()) * Math.random());

            if (a.get(randIndexA).equals(b.get(randIndexB))) {
                continue;
            }

            System.out.println(a.get(randIndexA) + " has been paired with " + b.get(randIndexB));
            a.remove(randIndexA);
            b.remove(randIndexB);
        }

        if (a.get(0).equals(b.get(0))) pair();

        System.out.println(a.get(0) + " has been paired with " + b.get(0));
    }
}
