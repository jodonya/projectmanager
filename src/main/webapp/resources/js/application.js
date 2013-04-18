/** $(); **/

function (){
	
	/**function () { **/
	    "use strict";

	    var header = $('#chatheader');
	    var content = $('#chatcontent');
	    var input = $('#chatinput');
	    var status = $('#chatstatus');
	    var myName = false;
	    var author = null;
	    var logged = false;
	    var socket = $.atmosphere;
	    var subSocket;
	    var transport = 'websocket';

	    
	    	
	    /***	window.ctx; ***/
	    console.log(' ### The Context Path is : ', contextPath);
	    /**  We are now ready to cut the request
	    //document.location.toString()
	    //var ctx = '${pageContext.request.contextPath}';
	    
	    ***/
	    var request = { url:  'http://localhost:8080/' + 'chat',
	        contentType : "application/json",
	        logLevel : 'debug',
	        transport : transport ,
	        trackMessageLength : true,
	        fallbackTransport: 'long-polling'};
	    
	   


	    request.onOpen = function(response) {
	        content.html($('<p class="chat">', { text: 'Atmosphere connected using ' + response.transport }));
	        input.removeAttr('disabled').focus();
	        status.text('Choose name:');
	        transport = response.transport;
	    };

	    <!-- For demonstration of how you can customize the fallbackTransport using the onTransportFailure function -->
	    request.onTransportFailure = function(errorMsg, request) {
	        jQuery.atmosphere.info(errorMsg);
	        if (window.EventSource) {
	            request.fallbackTransport = "sse";
	        }
	        header.html($('<h3>', { text: 'Atmosphere Chat. Default transport is WebSocket, fallback is ' + request.fallbackTransport }));
	    };

	    request.onMessage = function (response) {

	        var message = response.responseBody;
	        try {
	            var json = jQuery.parseJSON(message);
	        } catch (e) {
	            console.log('This doesn\'t look like a valid JSON: ', message);
	            return;
	        }

	        input.removeAttr('disabled').focus();
	        if (!logged && myName) {
	            logged = true;
	            status.text(myName + ': ').css('color', 'blue');
	        } else {
	            var me = json.author == author;
	            var date = typeof(json.time) == 'string' ? parseInt(json.time) : json.time;
	            addMessage(json.author, json.message, me ? 'blue' : 'black', new Date(date));
	        }
	    };

	    request.onClose = function(response) {
	        subSocket.push(jQuery.stringifyJSON({ author: author, message: 'disconnecting' }));
	        logged = false;
	    };

	    request.onError = function(response) {
	        content.html($('<p class="chat">', { text: 'Sorry, but there\'s some problem with your '
	            + 'socket or the server is down' }));
	    };

	    subSocket = socket.subscribe(request);

	    input.keydown(function(e) {
	        if (e.keyCode === 13) {
	            var msg = $(this).val();

	            // First message is always the author's name
	            if (author == null) {
	                author = msg;
	            }

	            subSocket.push(jQuery.stringifyJSON({ author: author, message: msg }));
	            $(this).val('');

	            input.attr('disabled', 'disabled');
	            if (myName === false) {
	                myName = msg;
	            }
	        }
	    });

	    function addMessage(author, message, color, datetime) {
	        content.append('<p class="chat"><span style="color:' + color + '">' + author + '</span> @ ' +
	            + (datetime.getHours() < 10 ? '0' + datetime.getHours() : datetime.getHours()) + ':'
	            + (datetime.getMinutes() < 10 ? '0' + datetime.getMinutes() : datetime.getMinutes())
	            + ': ' + message + '</p>');
	    }
}