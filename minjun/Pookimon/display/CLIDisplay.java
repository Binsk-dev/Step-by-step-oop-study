package Pookimon.display;

import java.io.IOException;
import java.util.Scanner;

public class CLIDisplay implements Display{
    @Override
    public void show(String content){
        System.out.println(content);
        System.out.println("----------------");
        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
