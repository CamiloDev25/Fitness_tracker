package org.surotec.finalprojectfitnesstracker;
import org.surotec.finalprojectfitnesstracker.domain.service.impl.MainMenuServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        MainMenuServiceImpl mainMenuService = new MainMenuServiceImpl();
        mainMenuService.printMenu(input);

    }
}
