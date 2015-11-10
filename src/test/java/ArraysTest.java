import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;
import org.junit.Assume;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.*;

import com.pholser.junit.quickcheck.ForAll;

@RunWith(Theories.class)
public class ArraysTest
{
	//The output array should be the same size as the input array after sorting.
	@Theory public void sortTest_1
	(	@ForAll int[] to_sort	)
	{
		Assume.assumeThat(new Integer(to_sort.length), greaterThan(1));
		
		int[] original = Arrays.copyOf(to_sort, to_sort.length);
		Arrays.sort(to_sort);
		
		assertEquals(original.length, to_sort.length);
	}
	
	//The output array should contain the same values as the input array after sorting.
	@Theory public void sortTest_2
	(	@ForAll int[] to_sort	)
	{
		Assume.assumeThat(new Integer(to_sort.length), greaterThan(1));
		
		Arrays.sort(to_sort);
		int[] copy = Arrays.copyOf(to_sort, to_sort.length);
		
		Arrays.sort(to_sort);
		
		assertTrue(Arrays.equals(to_sort, copy));
	}
	
	//The output array's values should always increase or stay the same.
	@Theory public void sortTest_3
	(	@ForAll int[] to_sort	)
	{
		Assume.assumeThat(new Integer(to_sort.length), greaterThan(1));
		
		Arrays.sort(to_sort);
		
		for(int n = 1; n<to_sort.length; n++)
		{
			assertTrue(to_sort[n-1] <= to_sort[n]);
		}
	}
	
	
}