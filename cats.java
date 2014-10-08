Test
====

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class cats {

    static char ch = 'a';

    static Integer cols = 0;
    static Integer rows = 0;

    public static void main(String[] args) throws Exception {
        start();
    }

    public static void start() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("cats.txt"));
        int arrayLength = Integer.parseInt(br.readLine());

        Integer rows = arrayLength - 1;

        char[] splitedLine = new char[3];
        char[][] map = new char[3][3]; // create map
        char[][] map2 = new char[3][3]; // output map
        boolean up = false;
        boolean right = false;

        // create map[][]
        for (int j = 0; j < 3; j++) {
            String line = br.readLine();
            for (int i = 0; i < 3; i++) { // for each char of rows

                splitedLine[i] = line.charAt(i); // up line
            }

            //set each line to map and show each line
            map[j] = Arrays.copyOf(splitedLine, 3);
            System.out.println("Map: " + Arrays.toString(map[j]));
        }

        System.out.println();

        //copy map array to map2
        map2 = Arrays.copyOf(map, map.length);

        // first place char is 'a'
        map2[map2.length - 1][0] = 'a';     //ok

        up = false;
        right = false;

        //check for UP
        while (checkForUpAndGo(rows, cols, map2) && rows >= 0) {
            up = true;
        }

        if (checkForRightAndGo(rows, cols, map2) && cols < arrayLength) {
            right = true;

            while (checkForUpAndGo(rows, cols, map2) && rows >= 0) {
                up = true;
            }
        }

        //show each lines of map2
        System.out.println("Final Map2:");
        for (int r = 0; r < map2.length; r++) {
            System.out.println(Arrays.toString(map2[r]));
        }
    }

    public static boolean checkForUpAndGo(Integer row, Integer col, char[][] array) {
        System.out.println("CheckForUP: currentRow: " + row + " currentCol: " + col);
        if (array[row - 1][col] == '-') {
            System.out.println("Go UP, I'm in row: " + (row - 1) + " cols: " + col);
            goUp(row, col, array);
            return true;
        }
        return false;
    }

    public static boolean checkForRightAndGo(Integer row, Integer col, char[][] array) {
        System.out.println("checkForRight, currentRow: " + row + " currentCol: " + col);
        if (array[row][col + 1] == '-') {
            System.out.println("Go Right to row: " + row + " col: " + (col + 1));
            goRight(row, col, array);
            return true;
        }
        return false;
    }

    public static void goUp(Integer row, Integer col, char[][] array) {
        array[row - 1][col] = ++ch;
        System.out.println("set: " + ch + " in row: " + (row - 1) + " col: " + col);
        rows--;
    }

    public static void goRight(Integer row, Integer col, char[][] array) {
        array[row][col + 1] = ++ch;
        System.out.println("set: " + ch + " in row: " + row + " col: " + (col + 1));
        cols++;
    }
}

// cats file:

3
---
*--
---

