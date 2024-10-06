package main.java.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
 //This utility class is created to retry the failed tests
    int count=0;
    //retryCount variable is to declare the number of times the test will re-run if failed
    int retryCount=1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        while (count<retryCount){
            count++;
            return true;
        }
        return false;
    }
}
