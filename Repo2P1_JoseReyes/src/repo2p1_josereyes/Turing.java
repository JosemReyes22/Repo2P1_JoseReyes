/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repo2p1_josereyes;

import java.util.Random;

/**
 *
 * @author josem
 */
public class Turing {
private int[] array;
    private int pointer;

    public Turing(int size) {
        array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(10); // Genera números aleatorios del 0 al 9
        }
        pointer = 0;
    }
    public int[] Instructiones(String instructions) {
        int[] result = new int[instructions.length()];
        int index = 0;
        for (int i = 0; i < instructions.length(); i++) {
            char instruction = instructions.charAt(i);
            if (instruction == 'R') {
                pointer = Math.min(pointer + 1, array.length - 1);
            } else if (instruction == 'L') {
                pointer = Math.max(pointer - 1, 0);
            } else if (instruction == 'X') {
                result[index++] = array[pointer];
            }
        }
        return result;
    }
    public int[]getarreglo(){
        return array;
    }
}
