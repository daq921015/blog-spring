package top.smartpos.blog.utils;

import top.smartpos.blog.constants.Constants;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOUtils {
    public static String inputStreamToString(InputStream inputStream) throws IOException {
        return inputStreamToString(inputStream, Constants.CHARSET_NAME_UTF_8);
    }

    public static String inputStreamToString(InputStream inputStream, String charsetName) throws IOException {
        StringBuffer result = new StringBuffer();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charsetName);
        int length = 0;
        char[] buffer = new char[1024];
        while ((length = inputStreamReader.read(buffer, 0, 1024)) != -1) {
            result.append(buffer, 0, length);
        }
        inputStreamReader.close();
        return result.toString();
    }
}
