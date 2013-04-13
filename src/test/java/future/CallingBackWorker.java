package future;

import java.util.concurrent.Callable;

public class CallingBackWorker implements Callable<Object> {
    private CallbackInterface employer;
    
    public CallingBackWorker(String message) {
    }

    public Object call() {
        new SlowWorker().doWork();
        employer.returnResult("Task Completed!");
        return null;
    }

    public void setEmployer(CallbackInterface employer) {
        this.employer = employer;
    }

    public CallbackInterface getEmployer() {
        return employer;
    }
}
