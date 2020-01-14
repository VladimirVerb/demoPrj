package helper;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class JsonUtils {

    public static <T> List<T> generateListData(String filePath, Class<T> type) {
        List<T> list = new ArrayList<T>();
        List generatedList = generateDataFromFile(filePath, List.class);
        for (Object m : generatedList) {
            list.add(generateDataFromObject(m, type));
        }
        return list;
    }

    public static <T> T generateDataFromFile(String filePath, Class<T> type) {
        T t;
        t = new Gson().fromJson(readFile(filePath), type);
        return t;
    }

    public static <T> T generateDataFromObject(Object resource, Class<T> type) {
        T t;
        Gson gson = new Gson();
        String json = gson.toJson(resource);
        t = new Gson().fromJson(json, type);
        return t;
    }

    public static String readFile(String path) {
        try {

            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuffer fileContents = new StringBuffer();
            String line = br.readLine();
            while (line != null) {
                fileContents.append(line);
                line = br.readLine();
            }
            br.close();
            return fileContents.toString();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
