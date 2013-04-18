package com.asal.projectmanager.web.controller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.atmosphere.annotation.Broadcast;
import org.atmosphere.annotation.Suspend;
import org.springframework.stereotype.Controller;

import com.asal.projectmanager.domain.Message;
import com.asal.projectmanager.domain.Response;


@Path("/chat")
@Produces("application/json")
public class ResourceChat {
	
	@Suspend
	@GET
	public String suspend(){
		return "";
	}
	
	@Broadcast(writeEntity=false)
	@POST
	public Response broadcast(Message message){
		
		return new Response(message.author, message.message);
	}

}
