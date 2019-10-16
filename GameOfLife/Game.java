package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Game {

    public static int countOfRounds=0;
    public static ObjectOfGame[][]arr=new ObjectOfGame[8][8];
    public static ArrayList<ObjectOfGame[][]>listOfArrays=new ArrayList<>();

    public static void startTheGame() throws Exception{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("Введите \"start\" для того, чтобы начать игру и \"close\" для того, чтобы завершить");
            String start=reader.readLine();
            if(start.equalsIgnoreCase("close")){
                System.out.println("Заходите снова!Хорошего дня!");
                break;
            }
            else if(start.equalsIgnoreCase("start")){
                setInitial();
                break;
            }
        }
    }
    public static void setInitial(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                arr[i][j]=new ObjectOfGame(new Random().nextBoolean());
            }
        }
        drawTable();
    }


    public static void drawTable(){
        countOfRounds++;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        ObjectOfGame[][] tempArr=new ObjectOfGame[8][8];
        for(int i=0;i<tempArr.length;i++){
            for(int j=0;j<tempArr[i].length;j++){
                tempArr[i][j]=new ObjectOfGame(arr[i][j].getAlive());
            }
        }
        listOfArrays.add(tempArr);

        if(listOfArrays.size()>1){
             for(int i=0;i<listOfArrays.size()-1;i++){
                 if(Arrays.deepEquals(listOfArrays.get(i), listOfArrays.get(listOfArrays.size()-1))){
                     System.out.println("Игра завершена, количество раундов: "+countOfRounds);
                     return;
                 }
             }
        }


        logicOfGame();
    }


    public static void logicOfGame(){
        int countOfTrue=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j].getAlive()){
                    countOfTrue++;
                }
            }
        }
        if(countOfTrue==0){
            System.out.println("Игра закончена!");
            System.out.println("Количество раундов: "+countOfRounds);
            return;
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                int countOfNeighbors=0;
                /////////проверка для клетки, находящейся в верхнем левом углу
                if(i==0&&j==0){
                    if (arr[i][j + 1].getAlive()) {
                        countOfNeighbors++;
                    }
                    if (arr[i + 1][j].getAlive()) {
                        countOfNeighbors++;
                    }
                    if (arr[i + 1][j + 1].getAlive()) {
                        countOfNeighbors++;
                    }

                    if (arr[i][j].getAlive()) {
                        if (countOfNeighbors > 3 || countOfNeighbors < 2) {
                            arr[i][j].setAlive(false);
                        }
                    } else {
                        if (countOfNeighbors == 3) {
                            arr[i][j].setAlive(true);
                        }
                    }
                }
                /////////проверка для клетки, находящейся в верхнем ряду, но не располагающейся в  углу
                else if(i==0&&(j>0&&j<arr[i].length-1)){
                    if (arr[i][j - 1].getAlive()) {
                        countOfNeighbors++;
                    }
                    if (arr[i][j + 1].getAlive()) {
                        countOfNeighbors++;
                    }
                    if (arr[i + 1][j - 1].getAlive()) {
                        countOfNeighbors++;
                    }
                    if (arr[i + 1][j].getAlive()) {
                        countOfNeighbors++;
                    }
                    if (arr[i + 1][j + 1].getAlive()) {
                        countOfNeighbors++;
                    }

                    if (arr[i][j].getAlive()) {
                        if (countOfNeighbors > 3 || countOfNeighbors < 2) {
                            arr[i][j].setAlive(false);
                        }
                    } else {
                        if (countOfNeighbors == 3) {
                            arr[i][j].setAlive(true);
                        }
                    }
                }
                /////////проверка для клетки, находящейся в верхнем правом углу
                else if(i==0&&j==arr[i].length-1){
                    if (arr[i][j -1].getAlive()) {
                        countOfNeighbors++;
                    }
                    if (arr[i+1][j-1].getAlive()) {
                        countOfNeighbors++;
                    }
                    if (arr[i + 1][j].getAlive()) {
                        countOfNeighbors++;
                    }

                    if (arr[i][j].getAlive()) {
                        if (countOfNeighbors > 3 || countOfNeighbors < 2) {
                            arr[i][j].setAlive(false);
                        }
                    } else {
                        if (countOfNeighbors == 3) {
                            arr[i][j].setAlive(true);
                        }
                    }
                }
                /////////проверка для клетки, находящейся в левом столбце, но не располагающейся верхнем или нижнем ряду
                else if((i>0&&i<arr[i].length-1)&&j==0){
                    if (arr[i-1][j].getAlive()) {
                        countOfNeighbors++;
                    }
                    if (arr[i-1][j + 1].getAlive()) {
                        countOfNeighbors++;
                    }
                    if (arr[i][j + 1].getAlive()) {
                        countOfNeighbors++;
                    }
                    if (arr[i + 1][j].getAlive()) {
                        countOfNeighbors++;
                    }
                    if (arr[i + 1][j + 1].getAlive()) {
                        countOfNeighbors++;
                    }

                    if (arr[i][j].getAlive()) {
                        if (countOfNeighbors > 3 || countOfNeighbors < 2) {
                            arr[i][j].setAlive(false);
                        }
                    } else {
                        if (countOfNeighbors == 3) {
                            arr[i][j].setAlive(true);
                        }
                    }
                }
                /////////проверка для клетки, находящейся в правом столбце, но не располагающейся верхнем или нижнем ряду
                else if((i>0&&i<arr[i].length-1)&&j==arr[i].length-1){
                    if (arr[i - 1][j - 1].getAlive()) {
                        countOfNeighbors++;
                    }
                    if (arr[i - 1][j].getAlive()) {
                        countOfNeighbors++;
                    }
                    if (arr[i][j - 1].getAlive()) {
                        countOfNeighbors++;
                    }
                    if (arr[i + 1][j - 1].getAlive()) {
                        countOfNeighbors++;
                    }
                    if (arr[i + 1][j].getAlive()) {
                        countOfNeighbors++;
                    }

                    if (arr[i][j].getAlive()) {
                        if (countOfNeighbors > 3 || countOfNeighbors < 2) {
                            arr[i][j].setAlive(false);
                        }
                    } else {
                        if (countOfNeighbors == 3) {
                            arr[i][j].setAlive(true);
                        }
                    }
                }
                /////////проверка для клетки, находящейся в нижнем левом углу
                if(i==arr[i].length&&j==0){
                    if (arr[i + 1][j].getAlive()) {
                        countOfNeighbors++;
                    }
                    if (arr[i + 1][j + 1].getAlive()) {
                        countOfNeighbors++;
                    }
                    if (arr[i][j + 1].getAlive()) {
                        countOfNeighbors++;
                    }

                    if (arr[i][j].getAlive()) {
                        if (countOfNeighbors > 3 || countOfNeighbors < 2) {
                            arr[i][j].setAlive(false);
                        }
                    } else {
                        if (countOfNeighbors == 3) {
                            arr[i][j].setAlive(true);
                        }
                    }
                }
                /////////проверка для клетки, находящейся в нижнем ряду, но не располагающейся в  углу
                else if(i==arr[i].length-1&&(j>0&&j<arr[i].length-1)){
                    if (arr[i][j - 1].getAlive()) {
                        countOfNeighbors++;
                    }
                    if (arr[i][j + 1].getAlive()) {
                        countOfNeighbors++;
                    }
                    if (arr[i - 1][j - 1].getAlive()) {
                        countOfNeighbors++;
                    }
                    if (arr[i - 1][j].getAlive()) {
                        countOfNeighbors++;
                    }
                    if (arr[i - 1][j + 1].getAlive()) {
                        countOfNeighbors++;
                    }

                    if (arr[i][j].getAlive()) {
                        if (countOfNeighbors > 3 || countOfNeighbors < 2) {
                            arr[i][j].setAlive(false);
                        }
                    } else {
                        if (countOfNeighbors == 3) {
                            arr[i][j].setAlive(true);
                        }
                    }
                }
                /////////проверка для клетки, находящейся в нижнем правом углу
                else if(i==arr[i].length-1&&j==arr[i].length-1){
                    if (arr[i][j - 1].getAlive()) {
                        countOfNeighbors++;
                    }
                    if (arr[i - 1][j-1].getAlive()) {
                        countOfNeighbors++;
                    }
                    if (arr[i - 1][j].getAlive()) {
                        countOfNeighbors++;
                    }

                    if (arr[i][j].getAlive()) {
                        if (countOfNeighbors > 3 || countOfNeighbors < 2) {
                            arr[i][j].setAlive(false);
                        }
                    } else {
                        if (countOfNeighbors == 3) {
                            arr[i][j].setAlive(true);
                        }
                    }
                }
                //проверка для не крайних клеток
                else if((i>0&&i<arr[i].length-1)&&(j>0&&j<arr[i].length-1)) {
                    if (arr[i - 1][j - 1].getAlive()) {
                        countOfNeighbors++;
                    }
                    if (arr[i - 1][j].getAlive()) {
                        countOfNeighbors++;
                    }
                    if (arr[i - 1][j + 1].getAlive()) {
                        countOfNeighbors++;
                    }
                    if (arr[i][j - 1].getAlive()) {
                        countOfNeighbors++;
                    }
                    if (arr[i][j + 1].getAlive()) {
                        countOfNeighbors++;
                    }
                    if (arr[i + 1][j - 1].getAlive()) {
                        countOfNeighbors++;
                    }
                    if (arr[i + 1][j].getAlive()) {
                        countOfNeighbors++;
                    }
                    if (arr[i + 1][j + 1].getAlive()) {
                        countOfNeighbors++;
                    }

                    if (arr[i][j].getAlive()) {
                        if (countOfNeighbors > 3 || countOfNeighbors < 2) {
                            arr[i][j].setAlive(false);
                        }
                    } else {
                        if (countOfNeighbors == 3) {
                            arr[i][j].setAlive(true);
                        }
                    }
                }
            }
        }

        System.out.println("Сделать очередной шаг в игре?YES/NO");
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        try {
            String select = reader.readLine();
            if(select.equalsIgnoreCase("yes")){
                System.out.println();
                System.out.println("===============================================================");
                drawTable();
            }
            else{
                System.out.println("До свидания!");
                System.out.println("Количество раундов: "+countOfRounds);
                return;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
