	
import static org.junit.Assert.*;

import org.junit.Test;

	
public class TestGetComplement{
	
	@Test
	public void testGetComplement1() {
		InSet inSetObj = new InSet(new int[] { 1, 2, 3 ,4 ,5 ,6});
		int[] expected = new int[ 1000 - 6 ];
		for ( int i = 0; i < 1000 - 6; i++){
			expected[i]= i + 7;
		}
		InSet actual = inSetObj.getComplement();
		assertArrayEquals( expected, actual.getSet());
	}
	
	@Test
	public void testGetComplement2() {
		InSet inSetObj = new InSet(new int[] {});
		int[] expected = new int[1000 ];
		int k = 0;
		for ( int i = 1; i <= 1000 ; i++){
			expected[k]= i ;
			k++;
		}
		InSet actual = inSetObj.getComplement();
		assertArrayEquals( expected, actual.getSet());
	}

}
