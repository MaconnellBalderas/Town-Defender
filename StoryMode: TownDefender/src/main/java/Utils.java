import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class Utils {

    public static String loadFileAsString(String path){
        StringBuilder builder = new StringBuilder();
        try{
            URL resource = Utils.class.getClassLoader().getResource(path);
            String filename = resource.getFile();
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while((line = br.readLine()) != null){
                builder.append(line + "\n");
            }
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static int parseInt(String number){
        try{
            return Integer.parseInt(number);
        }catch(NumberFormatException e){
            e.printStackTrace();
            return 0;
        }
    }
}
