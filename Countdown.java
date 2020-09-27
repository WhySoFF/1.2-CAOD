package countdown;

import java.util.Scanner;

public class Countdown {

    public static void main(String[] args) {

        writeQuestion();
        int K = scan();
        while(isInputIncorrect(K)){
            printError();
            K = scan();
        }
        createCap();
        for(int N = 1; N < 65; N++) {
            List.createCircle(N);
            int lastIndex = List.deleteEveryK(K);
            createLine(N, K, lastIndex);
        }
    }

    static boolean isInputIncorrect(int K) {

        if (K < 1 || K > 100){
            return true;
        }
        return false;
    }

    static int scan(){

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int K;

        try{
            K = Integer.parseInt(input);
        }catch(Exception e){
            printError();
            K = scan();
        }
        return K;
    }

    static void createCap(){
        System.out.println("___________________");
        System.out.println("|  N  |  K  |last |");
        System.out.println("|_____|_____|_____|");
    }

    static void printError(){
        System.out.println("Incorrect input, try again");
    }

    static void createLine(int N, int K, int lastIndex){
        System.out.printf("| %2d  | %2d  | %2d  |\n", N, K, lastIndex);
        System.out.println("|_____|_____|_____|");
    }

    static void writeQuestion(){
        System.out.println("Enter k");
    }
}
