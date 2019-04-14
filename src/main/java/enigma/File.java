package enigma;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


class File {


    List<String> Read(String file) {

        List<String> arr = new ArrayList<String>();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file), StandardCharsets.UTF_8))){
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);

                //System.out.println(line);
                arr.add(line.toUpperCase());
            }
            System.out.println("\n");
        } catch (IOException e) {
            System.out.println(e);
            // log error
        }
        return arr;

    }

    public void Write(List<String> new_arr, String filename) {

        try(FileWriter writer = new FileWriter(filename, false))
                {
                    // запись всей строки
                    for (String elem: new_arr) {
                        writer.write(elem);
                        writer.append('\n');
                        writer.flush();
                    }

                }
                catch(IOException ex){

                    System.out.println(ex.getMessage());
                }

        }

}


