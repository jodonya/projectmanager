package future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CalledBack implements CallbackInterface{
    Object result;
    
    int numberOfJobs = 5;
    
    public CalledBack() {
    }

    public void returnResult(Object result) {
      System.out.println("Result Received "+result);
      this.result = result;
    }
    
    public void andAction() {
        ExecutorService es = Executors.newFixedThreadPool(3);
        CallingBackWorker worker ;
        
        //Get the list of users
//        String message = "";
//        for(int i=0; i<numberOfJobs;i++){
//        	worker = new CallingBackWorker(message);
//        	 worker.setEmployer(this);
//            // final Future future =  I guess we dont need a Future since we are using a callable;
//               es.submit( worker);
//        }

        
      String message = "";
      	worker = new CallingBackWorker(message);
      	 worker.setEmployer(this);
          // final Future future =  I guess we dont need a Future since we are using a callable;
             es.submit( worker);
 
       
       
        System.out.println("... try to do something while the work is being done....");
        System.out.println("... and more ....");
        
//        try {
//            future.get();
//        } catch (InterruptedException e) {
//        } catch (ExecutionException e) {
//        }
      //  System.out.println("Result is "+result);
        System.out.println("End work" + new java.util.Date());
        //System.exit(0);

    }
    
    public static void main(String[] args) {
        new CalledBack().andAction();
    }

}
