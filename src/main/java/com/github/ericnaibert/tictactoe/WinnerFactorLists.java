package com.github.ericnaibert.tictactoe;

import java.util.Arrays;
import java.util.List;

public class WinnerFactorLists {

    public static final List<Integer> winFactorTop = Arrays.asList(1, 2, 3);
    public static final List<Integer> winFactorMiddle = Arrays.asList(4, 5, 6);
    public static final List<Integer> winFactorMiddle2 = Arrays.asList(2, 5, 8);
    public static final List<Integer> winFactorBottom = Arrays.asList(7, 8, 9);
    public static final List<Integer> winFactorLeft = Arrays.asList(1, 4, 7);
    public static final List<Integer> winFactorRight = Arrays.asList(3, 6, 9);
    public static final List<Integer> winFactorCross1 = Arrays.asList(1, 5, 9);
    public static final List<Integer> winFactorCross2 = Arrays.asList(3, 5, 7);
    public static final List<List<Integer>> allLists = List.of(winFactorTop, winFactorMiddle, winFactorMiddle2,
            winFactorBottom, winFactorLeft, winFactorRight, winFactorCross1, winFactorCross2);

    public static int typeToReturn;

    public static int returnMissingNumber(List<Integer> winList) {
        int num1 = HardGameImplementationEvent.playerInputs.get(0);
        int num2 = HardGameImplementationEvent.playerInputs.get(1);

        if(winList.get(0).equals(num1) && winList.get(1).equals(num2)) {
            return winList.get(2);
        } else if(winList.get(2).equals(num1) && winList.get(1).equals(num2)) {
            return winList.get(0);
        } else if(winList.get(0).equals(num1) && winList.get(2).equals(num2)) {
            return winList.get(1);
        } else if (winList.get(2).equals(num1) && winList.get(0).equals(num2)) {
            return winList.get(1);
        } else {
            return 0;
        }
    }

    public static int returnSecondMissingNumber() {
        int num1 = HardGameImplementationEvent.playerInputs.get(0);
        int num2 = HardGameImplementationEvent.playerInputs.get(1);
        int num3 = HardGameImplementationEvent.playerInputs.get(2);
        List<Integer> playerSpecialList = Arrays.asList(num1, num2, num3);
        List<Integer> specialListOne = Arrays.asList(1,5,3);
        List<Integer> specialListTwo = Arrays.asList(6,5,2);
        List<Integer> specialListThree = Arrays.asList(9, 8, 3);
        List<Integer> specialListFour = Arrays.asList(4, 3, 9);

        if(playerSpecialList.equals(specialListOne)) {
            return 7;
        } else if(playerSpecialList.equals(specialListTwo)) {
            return 8;
        } else if (playerSpecialList.equals(specialListThree)) {
            return 6;
        } else if (playerSpecialList.equals(specialListFour)) {
            return 6;
        } else {
            return 0;
        }
    }

    public static int cpuSeesPlayerList() {

        for(int i = 0; i<=7; i++) {
            if (returnMissingNumber(allLists.get(i)) != 0) {
                typeToReturn = returnMissingNumber(allLists.get(i));
            }
        }
        return typeToReturn;
    }

    public static void resetPlayerInputs() {
        EasyGameImplementationEvent.playerInputs.clear();
        HardGameImplementationEvent.playerInputs.clear();
    }

}
