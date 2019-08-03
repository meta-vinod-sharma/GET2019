package Ques3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestViratTheGreat {
	@Test
	public void testMinRun() {
		
		int bowlers = 4;
		ViratTheGreat vtgObj = new ViratTheGreat(bowlers);
		int numbersOfBalls = 20;
		int[] ballsArray = { 3, 7, 8, 2};
		Bumrah[] bowlersArray = new Bumrah[bowlers];
		Bumrah bumrah;

		for(int i = 0; i < bowlers ; i++) {
			bumrah = new Bumrah(ballsArray[i]);
			bowlersArray[i] = bumrah;
		}
		
		vtgObj.insert(bowlersArray);
		int[] expectedData = {3,3,2,2,3,3,2,2,3,3,1,2,2,3,1,1,4,4,2,3};
		int[] sequence = new int[numbersOfBalls];
		
		sequence = vtgObj.extractMax(numbersOfBalls);
		
		assertArrayEquals(expectedData,  sequence);
	}
	
	
}
