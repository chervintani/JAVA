/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositions;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author 2ndyrGroupC
 */
public class Validation {

    public boolean checkUsername(String username) {
        String rule = "^[a-zA-Z]*$";
        return username.matches(rule);
    }

    public boolean checkPassword(String password) {
        return password.length() >= 8;
    }

    public boolean matchPassword(String password, String newpassword) {
        return password.equals(newpassword);
    }

    public boolean checkInt(String age) {
        String rule = "\\d+";
        return age.matches(rule) && Integer.valueOf(age) > 0;
    }

    public int getId(String file) throws IOException {
        int id = 0;
        BufferedReader reader = Files.newBufferedReader(Paths.get(new File("").getAbsoluteFile() + "\\src\\account\\files\\" + file), Charset.forName("UTF-8"));
        String currentLine = null;
        while ((currentLine = reader.readLine()) != null) {
            ++id;
        }
        return id;
    }
}
