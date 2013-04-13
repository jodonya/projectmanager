package com.asal.projectmanager.service.async;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.asal.projectmanager.domain.PostComment;
import com.asal.projectmanager.domain.ProjectUser;
import com.asal.projectmanager.service.NotifierService;

@Service
public class SlowWorker {
	
	//protected static Logger logger = Logger.getLogger(SlowWorker.class);
	//protected static Logger logger = Logger.getLogger(SlowWorker.class);
	protected static Logger logger = Logger.getLogger(SlowWorker.class);

	NotifierService notifierService;
	
    private int id;
    
    public SlowWorker() {
        this.id = 1;
    }
    public SlowWorker(int id) {
        this.id = id;
    }
    
    public void doWork(PostComment postComment, ProjectUser user) {
//        try {
//            System.out.println("==== working, working, working ====== (Worker Id = "
//                               + this.id+")");
        logger.info("********####### Notifications sending has just started ########************"+(new Date()));

            /***
             * Given a comment ID, get all the notifiable users and send notifications
             * 
             **/
            logger.info(" MMMMMMMMMMMMM comment id is XXXXXXXXX "+postComment);
            notifierService.sendNotification(postComment);
        
//        	for (int i = 0; i < 20; i++) {
//				logger.info("YYYYYYYYYYYYYYYYY written -- "+i);
//			}
            
          
           // System.out.println("==== ready! ======");
            
            logger.info("**************************************");
            logger.info("****************** Notifications for "+user+" have been sent ********************");
            logger.info("*********************Sending Ended at **************"+(new Date()));
//        } catch (InterruptedException e) {
//        }
    }
	public NotifierService getNotifierService() {
		return notifierService;
	}
	public void setNotifierService(NotifierService notifierService) {
		this.notifierService = notifierService;
	}
    
    

}