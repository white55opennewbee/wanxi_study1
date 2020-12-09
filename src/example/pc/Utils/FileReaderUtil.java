package example.pc.Utils;

import java.io.*;

public class FileReaderUtil {
    public static File getFile(String url){
        File file = new File(url);
        return file;
    }

    public static String[] readFile(String split, String start, String end, File file){
        String[] result = null;
        InputStreamReader reader = null;
        StringBuilder builder = new StringBuilder();
        BufferedReader bufferedReader = null;
        String tempString;
        try {
            reader = new InputStreamReader(new FileInputStream(file),"GBK");
            bufferedReader = new BufferedReader(reader);
            while ((tempString = bufferedReader.readLine())!=null){
                builder.append(tempString);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

                try {
                    if (bufferedReader!=null) {
                    bufferedReader.close();
                    }
                    if (reader!=null){
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }


        }

            return dealString(split, start, end,builder);
    }

    private static String[] dealString(String split,String start,String end,StringBuilder orin){
        String temp = orin.toString();
        String[] split1 = null;
        if (temp.contains(start)&&split!=null){
            int i = temp.indexOf(start);
            int j = temp.indexOf(end,i+1);
            split1 = temp.substring(i+start.length(), j).split(split);
        }else {
            int i = temp.indexOf(start);
            int j = temp.indexOf(end,i+1);
            split1 = new String[1];
            split1[0] = temp.substring(i+start.length(), j);
        }
        return split1;
    }
}
