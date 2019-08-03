package Ques3;

import java.util.Scanner;

/**
 * It is a class with main method.
 * 
 * @author Vinod
 *
 */
public class MinimizeRunMain {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		System.out.print("\nËnter the total number of balls : ");
		int numberOfBalls = sc.nextInt();
		System.out.print("\nEnter the number of bowlers : ");
		int numberOfBowlers = sc.nextInt();
		ViratTheGreat vtg = new ViratTheGreat(numberOfBowlers);
		sc.nextLine();
		Bumrah bumrah;

		Bumrah ballsArray[] = new Bumrah[numberOfBowlers];
		for (int i = 0; i < numberOfBowlers; i++) {
			System.out.print("Enter balls of bowler " + (i + 1) + " : ");
			int balls = sc.nextInt();
			sc.nextLine();

			bumrah = new Bumrah(balls);
			ballsArray[i] = bumrah;
		}

		vtg.insert(ballsArray);
		int[] sequence = new int[numberOfBalls];
		sequence = vtg.extractMax(numberOfBalls);
		System.out.println("Sequence of bowlers : ");

		for (int i = 0; i < numberOfBalls; i++) {
			System.out.println((i + 1) + ". --> " + sequence[i]);
		}
		sc.close();
	}
}
