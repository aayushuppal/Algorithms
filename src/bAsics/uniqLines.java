package bAsics;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by hellsapphire on 10/11/2015.
 */
public class uniqLines {

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        String fileIn = in.nextLine();
        String fileOut = in.nextLine();
        in.close();

        BufferedReader br = new BufferedReader( new FileReader(fileIn));
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileOut));
        Set<String> set = new HashSet<>();
        String line = null;

        while ((line = br.readLine()) != null){
            set.add(line);
        }

        for(String s: set){
            bw.write(s);
            bw.newLine();
        }

        bw.close();
        br.close();

    }
}
