package vtiger.GenericLibrary;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class will provide implementation for all the abstract method in ITestListener interface
 * @author haris
 *
 */
public class ListenerImplementationLibrary implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	
	public void onTestStart(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		//Reporter.log("test execution started--> "+methodName, true);
		
		test = report.createTest(methodName);
		test.log(Status.INFO, "test execution started--> " + methodName);
	}

	public void onTestSuccess(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		//System.out.println("test is successful--> "+methodName);
		test.log(Status.PASS, "test is successful--> " + methodName);
		
	}

	public void onTestFailure(ITestResult result) {
		
		JavaLibrary jLib = new JavaLibrary();
		WebDriverLibrary wLib = new WebDriverLibrary();
		
		String methodName = result.getMethod().getMethodName() + jLib.getSystemDateInFormat();
//		System.out.println("test is failed--> " + methodName);
		test.log(Status.FAIL, "test is failed--> " + methodName);
		test.log(Status.FAIL, result.getThrowable());
		
		try {
			String path = wLib.getScreenShot(BaseClass.sDriver, methodName);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
//		System.out.println("test is skipped--> " + methodName);
		test.log(Status.SKIP, "test is skipped --> " + methodName);
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		Reporter.log("Execution of suite started", true);
		
		//Execution of suite starts here, configure the extent reports here Report-11-11-2022-10-55.html
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".//ExtentReports//Report-"+new JavaLibrary().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("Execution reports for vtiger");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("vtiger execution reports");
		
		//attach the reports to extent report
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base Environment", "Test Environment");
		report.setSystemInfo("Base URL", "localhost://8888");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Reporter Name", "Harish");
		
	}

	public void onFinish(ITestContext context) {
		Reporter.log("Execution of suite finished", true);
		
		//Flush the report. - Here execution is finished
		report.flush();
		
	}

}
