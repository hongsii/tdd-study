package dev.hongsii.io;

import java.util.Scanner;

public class BaseballGameInput {

    private static Scanner scanner = new Scanner(System.in);

    public static int inputNumberCount() {
        System.out.print("숫자 자릿수 설정 : ");
        return scanner.nextInt();
    }

    public static String inputGuessNumber() {
        System.out.print("숫자 추측 : ");
        return scanner.next();
    }
}
