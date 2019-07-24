import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
@RunWith(Suite.class)
@SuiteClasses({
	TestAddMatrix.class,
	TestEvaluateTranspose.class,
	TestIfSymmetric.class, 
	TestMultiplyMatrix.class 
})
public class TestSparseMatrix {
}
