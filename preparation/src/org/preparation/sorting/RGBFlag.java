package org.preparation.sorting;

public class RGBFlag {

    public static void main(String[] args) {

        char[] balls = new char[] {'G','B','G','G', 'R', 'B', 'R', 'G'};
        dutch_flag_sort(balls);
        for(char c : balls){
            System.out.println(c);
        }
    }

    public static void dutch_flag_sort(char[] balls) {

        int swapRedHere = 0;
        int swapBlueHere = balls.length-1;
        int currIndex = 0;

        while(currIndex <= swapBlueHere){

            if(balls[currIndex] == 'R'){
                swap(currIndex,swapRedHere,balls);
                swapRedHere++;
                currIndex++;
            }

            else if(balls[currIndex] == 'G'){
                currIndex++;
            }

            else if(balls[currIndex] == 'B'){
                swap(currIndex, swapBlueHere,balls);
                swapBlueHere--;
            }
        }

    }

    private static void swap(int currIndex, int anythingGoesHere, char[] balls) {
        char temp = balls[currIndex];
        balls[currIndex] = balls[anythingGoesHere];
        balls[anythingGoesHere] = temp;
    }
}

