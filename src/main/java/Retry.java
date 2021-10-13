import org.testng.ITestResult;
import org.testng.util.RetryAnalyzerCount;

public class Retry extends RetryAnalyzerCount {

    private int count = 0;
    private static final int MAX_COUNT = 3;

    @Override
    public boolean retryMethod(ITestResult iTestResult) {
        if (count<MAX_COUNT){
            count++;
            return true;
        }else {
            return false;
        }

    }
}
