package utils;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.Plugin;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.Status;
import io.cucumber.plugin.event.TestCaseFinished;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FailedTestLogger implements ConcurrentEventListener, Plugin {
    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestCaseFinished.class, this::logFailure);
    }

    private void logFailure(TestCaseFinished event) {
        if (event.getResult().getStatus() != Status.PASSED) {
            try (FileWriter fw = new FileWriter("target/failed-tests.log", true);
                 PrintWriter pw = new PrintWriter(fw)) {
                pw.println("---------");
                pw.println("Scenario: " + event.getTestCase().getName());
                pw.println("Status: " + event.getResult().getStatus());
                Throwable error = event.getResult().getError();
                if (error != null) {
                    pw.println("Error Message: " + error.getMessage());
                    pw.println("Exception: " + error.getClass().getName());
                    pw.println("Stack Trace: ");
                    error.printStackTrace(pw);
                }
                pw.println("---------");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
