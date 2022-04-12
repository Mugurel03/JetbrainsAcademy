package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void machine(){
        int qwater = 400, qmilk = 540, qbeans = 120, ndcups = 9, money = 550;
        Scanner scan = new Scanner(System.in);
        String action = new String();
        while(!action.equals("exit")){
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action = scan.nextLine();
            if(action.equals("buy")){
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                String option = scan.nextLine();
                if(option.equals("back")) continue;
                else{
                    int opt = Integer.parseInt(option);
                    if(opt == 1){
                        if(qwater < 250){
                            System.out.println("Sorry not enough water!");
                            continue;
                        }else if(qbeans < 16){
                            System.out.println("Sorry not enough coffee beans!");
                            continue;
                        }
                        ndcups -= 1;
                        qwater -= 250;
                        qbeans -= 16;
                        money += 4;
                        System.out.println("I have enough resources, making you a coffee!");
                    }
                    else if(opt == 2){
                        if(qwater < 350){
                            System.out.println("Sorry not enough water!");
                            continue;
                        } else if(qmilk < 75) {
                            System.out.println("Sorry not enough coffee milk!");
                            continue;
                        }
                        else if(qbeans < 20) {
                            System.out.println("Sorry not enough coffee beans!");
                            continue;
                        }
                        ndcups -= 1;
                        qwater -= 350;
                        qmilk -= 75;
                        qbeans -= 20;
                        money += 7;
                        System.out.println("I have enough resources, making you a coffee!");
                    }
                    else if(opt == 3){
                        if(qwater < 200){
                            System.out.println("Sorry not enough water!");
                            continue;
                        } else if(qmilk < 100){
                            System.out.println("Sorry not enough milk!");
                            continue;
                        } else if(qbeans < 12){
                            System.out.println("Sorry not enough coffee beans!");
                            continue;
                        }
                        ndcups -= 1;
                        qwater -= 200;
                        qmilk -= 100;
                        qbeans -= 12;
                        money += 6;
                        System.out.println("I have enough resources, making you a coffee!");
                    }
                }
            }
            else if(action.equals("fill")){
                System.out.println("Write how many ml of water do you want to add:");
                qwater += scan.nextInt();
                System.out.println("Write how many ml of milk do you want to add:");
                qmilk += scan.nextInt();
                System.out.println("Write how many grams of coffee beans do you want to add:");
                qbeans += scan.nextInt();
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                ndcups += scan.nextInt();
            }
            else if(action.equals("take")){
                System.out.println(String.format("I gave you $%s", money));
                money = 0;
            }
            else if(action.equals("remaining")){
                System.out.println("The coffee machine has:");
                System.out.println(String.format("%s of water", qwater));
                System.out.println(String.format("%s of milk", qmilk));
                System.out.println(String.format("%s of coffee beans", qbeans));
                System.out.println(String.format("%s of disposable cups", ndcups));
                System.out.println(String.format("%s of money", money));
            }
        }
    }

    public static void main(String[] args) {
        machine();

    }
}