package fr.marseille.businessmanagement.runtime;

import java.util.Iterator;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;

public class GenerateClientCode {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Random rng = new Random();

        for (int i = 0; i < 15; i++) {
            sb.append(rng.ints(10, 100).findFirst().getAsInt());
            sb.append((char) rng.ints(65, 91).findFirst().getAsInt());
            sb.append((char) rng.ints(65, 91).findFirst().getAsInt());
            sb.append(rng.ints(10, 100).findFirst().getAsInt());
            System.out.println(sb.toString() + "\n");
            sb = new StringBuilder();
        }

    }

}
