package util;

import java.io.File;
import java.nio.file.FileSystems;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import br.com.santander.utilities.ExtentReportUtil;
import core.Helper;
import core.PageMaker;
import cucumber.api.PickleStepTestStep;
import cucumber.api.Result;
import cucumber.api.event.EventHandler;
import cucumber.api.event.EventListener;
import cucumber.api.event.EventPublisher;
import cucumber.api.event.TestCaseFinished;
import cucumber.api.event.TestCaseStarted;
import cucumber.api.event.TestRunFinished;
import cucumber.api.event.TestRunStarted;
import cucumber.api.event.TestStepFinished;
import cucumber.api.event.TestStepStarted;

public class CustomPlugin implements EventListener, PageMaker {

	private ExtentTest _test;
	private ExtentTest _node;
	private Markup _mkGreen = MarkupHelper.createLabel("Aprovado", ExtentColor.GREEN);
	private Markup _mkRed = MarkupHelper.createLabel("Reprovado", ExtentColor.RED);
	private Markup _mkYellow = MarkupHelper.createLabel("Pulou", ExtentColor.YELLOW);
	private String projectFolder = FileSystems.getDefault().getPath("").toAbsolutePath().toString();

	public CustomPlugin() {

	}

	public CustomPlugin(File file) {
	}

	private EventHandler<TestRunStarted> runStartedHandler = new EventHandler<TestRunStarted>() {
		@Override
		public void receive(TestRunStarted event) {
			try {
				startRun(event);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};

	private EventHandler<TestRunFinished> runFinishedHandler = new EventHandler<TestRunFinished>() {
		@Override
		public void receive(TestRunFinished event) {
			try {
				finishRun(event);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};

	private EventHandler<TestCaseStarted> caseStartedHandler = new EventHandler<TestCaseStarted>() {
		@Override
		public void receive(TestCaseStarted event) {
			startCase(event);
		}
	};

	private EventHandler<TestCaseFinished> caseFinishedHandler = new EventHandler<TestCaseFinished>() {
		@Override
		public void receive(TestCaseFinished event) {
			finishCase(event);
		}
	};

	private EventHandler<TestStepStarted> stepStartedHandler = new EventHandler<TestStepStarted>() {
		@Override
		public void receive(TestStepStarted event) {
			startStep(event);
		}
	};

	private EventHandler<TestStepFinished> stepFinishedHandler = new EventHandler<TestStepFinished>() {
		@Override
		public void receive(TestStepFinished event) {
			finishStep(event);
		}
	};

	private void startRun(TestRunStarted event) throws Exception {
		ExtentReportUtil.getInstance().createHtmlReporter("target/extent.html", "Relatório Automação",
				AnalysisStrategy.BDD);
	}

	private void finishRun(TestRunFinished event) throws Exception {
		ExtentReportUtil.getInstance().flush();
	}

	private void startCase(TestCaseStarted event) {
		System.out.println(event.testCase.getName());
		_test = ExtentReportUtil.getInstance().createTest(event.testCase.getName());
	}

	private void finishCase(TestCaseFinished event) {

	}

	private void startStep(TestStepStarted event) {
		if (event.testStep instanceof PickleStepTestStep) {
			PickleStepTestStep ev = (PickleStepTestStep) event.testStep;
			System.out.println(ev.getStepText());
			_node = _test.createNode(ev.getStepText());
		}
	}

	private void finishStep(TestStepFinished event) {
		if (event.testStep instanceof PickleStepTestStep) {
			String filename = projectFolder + "\\target\\screenshots\\" + createRandomFileName(".png");
			String filepath =  ExtentReportUtil.getInstance().captureImage(Helper.getInstance().getDriver(), filename);
	
			if (event.result.getStatus().equals(Result.Type.PASSED)) {
				_node.pass(_mkGreen);
				 ExtentReportUtil.getInstance().attachFileToReport(_node, filepath);				
			}

			if (event.result.getStatus().equals(Result.Type.FAILED)) {
				_node.fail(_mkRed);
				ExtentReportUtil.getInstance().attachFileToReport(_node, filepath);
			}
			
			if (event.result.getStatus().equals(Result.Type.SKIPPED)) {
				_node.fail(_mkYellow);
				ExtentReportUtil.getInstance().attachFileToReport(_node, filepath);
			}	
		}
	}

	@Override
	public void setEventPublisher(EventPublisher publisher) {
		publisher.registerHandlerFor(TestRunStarted.class, runStartedHandler);
		publisher.registerHandlerFor(TestRunFinished.class, runFinishedHandler);
		publisher.registerHandlerFor(TestCaseStarted.class, caseStartedHandler);
		publisher.registerHandlerFor(TestCaseFinished.class, caseFinishedHandler);
		publisher.registerHandlerFor(TestStepStarted.class, stepStartedHandler);
		publisher.registerHandlerFor(TestStepFinished.class, stepFinishedHandler);
	}

	private String createRandomFileName(String extension) {
		String date = new SimpleDateFormat("ddMMyyy").format(new Date());
		int randNum = new Random().nextInt(9999);
		return "captura" + date + randNum + extension;
	}
}
