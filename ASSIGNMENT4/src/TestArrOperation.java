import static org.junit.Assert.*;

import org.junit.Test;

public class TestArrOperation {

	@Test
	public void test() {
		ArrOperation arrOperationObj = new ArrOperation();
		int actual = arrOperationObj.findMaxMirror(new int[] { 1, 4, 5, 3, 5, 4, 1 });
		assertEquals(7, actual);
	}

	@Test
	public void test2() {
		ArrOperation arrOperationObj = new ArrOperation();
		int actual = arrOperationObj.findMaxMirror(new int[] { 7, 1, 4, 9, 7, 4, 1 });
		assertEquals(2, actual);
	}

	@Test
	public void test3() {
		ArrOperation arrOperationObj = new ArrOperation();
		int actual = arrOperationObj.findMaxMirror(new int[] { 1, 2, 3, 8, 9, 3, 2, 1 });
		assertEquals(3, actual);
	}

	@Test
	public void test4() {
		ArrOperation arrOperationObj = new ArrOperation();
		int actual = arrOperationObj.findMaxMirror(new int[] { 1, 4, 5, 3, 5, 4, 1 });
		assertEquals(7, actual);
	}

	@Test
	public void test5() {
		ArrOperation arrOperationObj = new ArrOperation();
		int actual = arrOperationObj.findMaxMirror(new int[] { 1, 2, 1, 2, 3, 3, 4, 3, 3, 2, 1 });
		assertEquals(9, actual);
	}

	// CLUMPS

	@Test
	public void test6() {
		ArrOperation arrOperationObj = new ArrOperation();
		int actual = arrOperationObj.noOfClumps(new int[] { 1, 2, 2, 3, 4, 4 });
		assertEquals(2, actual);
	}

	@Test
	public void test7() {
		ArrOperation arrOperationObj = new ArrOperation();
		int actual = arrOperationObj.noOfClumps(new int[] { 1, 1, 2, 1, 1 });
		assertEquals(2, actual);
	}

	@Test
	public void test8() {
		ArrOperation arrOperationObj = new ArrOperation();
		int actual = arrOperationObj.noOfClumps(new int[] { 1, 1, 1, 1, 1, 1});
		assertEquals(1, actual);

	}
	
	
	// FIXXX
	
	@Test
	public void test9() {
		ArrOperation arrOperationObj = new ArrOperation();
		int arr[] = new int[] {9, 4, 5, 4, 5, 9};
		int actual[] = arrOperationObj.fixXY(new int[] 
//		{ 1, 4, 1, 5, 5, 4, 1 } );
//		{1, 4, 1, 5} );    
		{ 5, 4, 9, 4, 9, 5}, 4, 5);
		assertArrayEquals(arr, actual);

	}

}
