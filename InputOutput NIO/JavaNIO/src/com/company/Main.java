package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
//            FileInputStream file = new FileInputStream("data.txt");
//            FileChannel channel = file.getChannel();

            Path filePath = FileSystems.getDefault().getPath("data.txt");

            Files.write(filePath,"\nLine 5".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);

            List<String> lines = Files.readAllLines(filePath);
            for(String line : lines){
                System.out.println(line);
            }

        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
