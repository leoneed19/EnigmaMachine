package enigma;

import java.util.ArrayList;
import java.util.List;

public class Machine {
    public static void main(String[] args) {
        // Create machine
        Enigma enigma;

        enigma = new Enigma(Enigma.I, Enigma.II, Enigma.III, Enigma.B);

        // Configure rotors
        enigma.getLeftRotor().setRotorHead('A');
        enigma.getCenterRotor().setRotorHead('B');
        enigma.getRightRotor().setRotorHead('C');

        // Configure rings
        enigma.getLeftRotor().setRingHead('D');
        enigma.getCenterRotor().setRingHead('E');
        enigma.getRightRotor().setRingHead('F');
        //Make arr
        List<String> arr = new ArrayList<>();
        List<String> new_arr = new ArrayList<String>();
        File file;
        file = new File();
        //arr = file.Read(args[0]);
        //String filename = "/home/leon/IdeaProjects/enigmamachine/src/main/java/enigma/input_file.txt";
        String filename = args[0];

        //System.out.println(args[1]);
        String output = "/home/leon/IdeaProjects/enigmamachine/src/main/java/enigma/output_file.txt";
        //String output = "/home/leon/IdeaProjects/enigmamachine/src/main/java/enigma/input_file.txt";
        arr = file.Read(filename);

        for (String s : arr) {
            new_arr.add(enigma.type(s));
        }
        for (String elem: new_arr)  {
            System.out.println(elem);
        }
        file.Write(new_arr, output);
        //System.out.println(new_arr);
        //System.out.println("wdef");
    }
}
