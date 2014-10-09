package Bayan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class t4 {

    public static void main(String[] args) throws Exception {
        start();
    }

    public static void start() {
        try (BufferedReader br = new BufferedReader(new FileReader("47.txt"))) {
            String tStr = br.readLine(); // number of tests
            int t = Integer.parseInt(tStr); // READ t
            for (int i = 0; i < t; i++) { // Each Tests
                String[] stateArray = new String[4];
                String line = br.readLine(); // READ States
                stateArray = line.split("\\s+");

                int n = Integer.parseInt(br.readLine()); // READ n

                for (int j = 0; j < n; j++) { // n is number of tests in each t
                    String lines = br.readLine(); // reads rotate type and m
                    String[] linesArray = lines.split("\\s+"); // convert to array to extract rotate type and m
                    String rotateType = linesArray[0];
                    int m = Integer.parseInt(linesArray[1]);

                    if (rotateType.equals("Z")) { // Do Z orbit
                        for (int c = 0; c < m; c++) { // m times
                            doZOrbit(stateArray);
                        }
                    } else if (rotateType.equals("Y")) {  //Do Y orbit
                        for (int c = 0; c < m; c++) { // m times
                            doYOrbit(stateArray);
                        }
                    } else if (rotateType.equals("X")) {  //Do Y orbit
                        for (int c = 0; c < m; c++) { // m times
                            doXOrbit(stateArray);
                        }
                    }
                }
                // write result (state array) to file
                String lineToWrite = "";
                for (int l = 0; l < stateArray.length; l++) {
                    lineToWrite = lineToWrite + stateArray[l] + " ";
                }
                writeToFile(lineToWrite.trim());
            }
        } catch (Exception e) {
        }
    }

    public static void doZOrbit(String[] array) {

        String[] array2 = new String[array.length];
        array2[1] = array[1];
        array2[2] = array[2];

        array2[0] = array[3];
        array2[3] = array[5];
        array2[4] = array[0];
        array2[5] = array[4];

        for (int i = 0; i < array.length; i++) {
            array[i] = array2[i];
        }
    }

    public static void doYOrbit(String[] array) {
        String[] array2 = new String[array.length];
        array2[0] = array[0]; // constant
        array2[5] = array[5]; // constant

        array2[1] = array[3]; // constant
        array2[2] = array[4]; // constant
        array2[3] = array[2]; // constant
        array2[4] = array[1]; // constant

        for (int i = 0; i < array.length; i++) {
            array[i] = array2[i];
        }
    }

    public static void doXOrbit(String[] array) {

        String[] array2 = new String[array.length];
        array2[3] = array[3]; // constant
        array2[4] = array[4]; // constant

        array2[0] = array[2]; // constant
        array2[1] = array[0]; // constant
        array2[2] = array[5]; // constant
        array2[5] = array[1]; // constant

        for (int i = 0; i < array.length; i++) {
            array[i] = array2[i];
        }
    }

    public static void writeToFile(String str) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("47O.txt", true))) {
            bw.write(str);
            bw.newLine();
        } catch (Exception e) {
        }
    }
}
