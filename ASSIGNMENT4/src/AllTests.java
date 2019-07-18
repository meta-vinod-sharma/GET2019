import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ TestFitXY.class, TestMaxMirror.class, TestNoOfClumps.class,
		TestSplitArray.class })
public class AllTests {

}
