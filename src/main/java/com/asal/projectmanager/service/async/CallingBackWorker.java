package com.asal.projectmanager.service.async;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asal.projectmanager.domain.PostComment;
import com.asal.projectmanager.domain.ProjectUser;
import com.asal.projectmanager.service.NotifierService;


@Service
public class CallingBackWorker implements Callable<Object> {
    private CallbackInterface employer;
    private NotifierService notifierService;
    
    private PostComment postComment;
    private ProjectUser user;
    
    @Autowired
    SlowWorker slowWorker;
    
    public CallingBackWorker() {
    }

    public Object call() {
        //new SlowWorker().doWork();
    	slowWorker.setNotifierService(notifierService);
    	slowWorker.doWork(postComment, user);
    	
        employer.returnResult("Task Completed!");
        return null;
    }

    public void setEmployer(CallbackInterface employer) {
        this.employer = employer;
    }

    public CallbackInterface getEmployer() {
        return employer;
    }

	

	public PostComment getPostComment() {
		return postComment;
	}

	public void setPostComment(PostComment postComment) {
		this.postComment = postComment;
	}

	public ProjectUser getUser() {
		return user;
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