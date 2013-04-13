package com.asal.projectmanager.service.async;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asal.projectmanager.domain.PostComment;
import com.asal.projectmanager.domain.ProjectUser;
import com.asal.projectmanager.service.NotifierService;

@Service
public class CalledBack implements CallbackInterface{
    Object result;
    
    @Autowired
    CallingBackWorker callingBackWorker ;
    NotifierService notifierService;
    
    private PostComment postComment;
    private ProjectUser user;
    
    int numberOfJobs = 5;
    
    public CalledBack() {
    }

    public void returnResult(Object result) {
      System.out.println("Result Received "+result);
      this.result = result;
    }
    
    public void andAction() {
        ExecutorService es = Executors.newFixedThreadPool(3);
        
        
        //Get the list of users
//        String message = "";
//        for(int i=0; i<numberOfJobs;i++){
//        	worker = new CallingBackWorker(message);
//        	 worker.setEmployer(this);
//            // final Future future =  I guess we dont need a Future since we are using a callable;
//               es.submit( worker);
//        }

        
//      	worker = new CallingBackWorker();
      	 callingBackWorker.setEmployer(this);
      	 callingBackWorker.setPostComment(postComment);
      	 callingBackWorker.setUser(user);
      	 callingBackWorker.setNotifierService(notifierService);
      	 
          // final Future future =  I guess we dont need a Future since we are using a callable;
         es.submit( callingBackWorker);
 
       
       
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
    
//    public static void main(String[] args) {
//        new CalledBack().andAction();
//    }



	public ProjectUser getUser() {
		return user;
	}

	public PostComment getPostComment() {
		return postComment;
	}

	public void setPostComment(PostComment postComment) {
		this.postComment = postComment;
	}

	public void setUser(ProjectUser user) {
		this.user = user;
	}

	public NotifierService getNotifierService() {
		return notifierService;
	}

	public void setNotifierService(NotifierService notifierService) {
		this.notifierService = notifierService;
	}
	
	
    
    

}