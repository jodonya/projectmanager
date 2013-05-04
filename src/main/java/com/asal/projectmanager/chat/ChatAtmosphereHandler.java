package com.asal.projectmanager.chat;

import java.io.IOException;
import java.util.Date;

import org.atmosphere.config.service.ManagedService;
import org.atmosphere.config.service.Message;
import org.atmosphere.cpr.AtmosphereRequest;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEvent;
import org.atmosphere.cpr.AtmosphereResponse;
import org.atmosphere.handler.OnMessage;
import org.codehaus.jackson.map.ObjectMapper;
//import org.atmosphere.config.service.AtmosphereHandlerService;


@ManagedService(path = "/chat")
//@AtmosphereHandlerService(path="/chat")
public class ChatAtmosphereHandler {//implements AtmosphereHandler {
	
	private final ObjectMapper mapper = new ObjectMapper();

//	public void onRequest(AtmosphereResource r) throws IOException {
//
//		AtmosphereRequest req = r.getRequest();
//		
//		// First, tell Atmosphere to allow bi-directional communication by
//		// suspending.
//		if (req.getMethod().equalsIgnoreCase("GET")) {
//			// We are using HTTP long-polling with an invite timeout
//			r.suspend();
//			// Second, broadcast message to all connected users.
//		} else if (req.getMethod().equalsIgnoreCase("POST")) {
//			r.getBroadcaster().broadcast(req.getReader().readLine().trim());
//		}
//	}
	
	  @Message
	  public String onMessage(String message) throws IOException {
		  
	        return mapper.writeValueAsString(mapper.readValue(message, Data.class));
	    }

//	public void onStateChange(AtmosphereResourceEvent event) throws IOException {
//		AtmosphereResource r = event.getResource();
//		AtmosphereResponse res = r.getResponse();
//
//		if (r.isSuspended()) {
//			String body = event.getMessage().toString();
//
//			// Simple JSON -- Use Jackson for more complex structure
//			// Message looks like { "author" : "foo", "message" : "bar" }
//			String author = body.substring(body.indexOf(":") + 2,
//					body.indexOf(",") - 1);
//			String message = body.substring(body.lastIndexOf(":") + 2,
//					body.length() - 2);
//
//			res.getWriter().write(new Data(author, message).toString());
//			switch (r.transport()) {
//			case JSONP:
//			case LONG_POLLING:
//				event.getResource().resume();
//				break;
//			case WEBSOCKET:
//			case STREAMING:
//				res.getWriter().flush();
//				break;
//			default:
//				break;
//			}
//		} else if (!event.isResuming()) {
//			event.broadcaster().broadcast(
//					new Data("Someone", "say bye bye!").toString());
//		}
//	}
//
//	public void destroy() {
//	}

	private final static class Data {

		private String message;
		private String author;
		private long time;

		public Data() {
			this("", "");
		}

		public Data(String author, String message) {
			this.author = author;
			this.message = message;
			this.time = new Date().getTime();
		}

		public String getMessage() {
			return message;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public long getTime() {
			return time;
		}

		public void setTime(long time) {
			this.time = time;
		}
	}

//	@Override
//	public void onMessage(String message)
//			throws IOException {
//		 return mapper.writeValueAsString(mapper.readValue(message, Data.class));
//		//response.getWriter().write(mapper.writeValueAsString(mapper.readValue(message, Data.class)));
//	}

	
}
