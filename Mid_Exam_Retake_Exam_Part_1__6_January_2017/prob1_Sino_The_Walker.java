package Mid_Exam_Retake_Exam_Part_1__6_January_2017;

import java.util.Scanner;

public class prob1_Sino_The_Walker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] timeLeaves = input.split(":");
        int hours = Integer.parseInt(timeLeaves[0]);
        int minutes = Integer.parseInt(timeLeaves[1]);
        int seconds = Integer.parseInt(timeLeaves[2]);
        int numberOfSteps = Integer.parseInt(scanner.nextLine());
        int timeForEachStep = Integer.parseInt(scanner.nextLine());
        int timeInSecondsLeaves = hours * 3600 + minutes * 60 + seconds;
        int timeForMove = numberOfSteps * timeForEachStep;
        int timeToGoHome = timeInSecondsLeaves + timeForMove;
        seconds = timeToGoHome % 60;
        minutes = (timeToGoHome % 3600) / 60;
        hours = timeToGoHome / 3600;
        if (hours >= 24) {
            hours = hours % 24;
        }
        System.out.printf("Time Arrival: %02d:%02d:%02d", hours, minutes, seconds);
    }
}
