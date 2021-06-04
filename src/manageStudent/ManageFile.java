package manageStudent;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManageFile {
    public List<String> readFile(String pathFile) throws IOException {
        List<String> list = new ArrayList<>();
        FileReader fileReader = new FileReader(pathFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        while ((line = bufferedReader.readLine()) != null){
            list.add(line);
        }
        fileReader.close();
        return list;
    }
    public void writeFile(String pathFile, String content) throws IOException {
        FileWriter fileWriter = new FileWriter(pathFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(content);
        bufferedWriter.close();
        fileWriter.close();
    }
}

