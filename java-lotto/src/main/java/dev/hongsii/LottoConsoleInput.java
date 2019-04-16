package dev.hongsii;

import java.util.Scanner;

public class LottoConsoleInput {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputLottoCount() {
        System.out.print("구매할 복권 개수 : ");
        return scanner.nextInt();
    }
}
