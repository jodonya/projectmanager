<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8">
    <title>Atmosphere Chat</title>
    
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.9.0.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.atmosphere.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/application.js"></script>

    <style>
        .chatcontainer {
            font-family: tahoma;
            font-size: 12px;
            padding: 0px;
            margin: 0px;
        }

        p .chat {
            line-height: 18px;
        }

        .chatbox {
            width: 500px;
            margin-left: auto;
            margin-right: auto;
        }

        .chatcontent {
            padding: 5px;
            background: #ddd;
            border-radius: 5px;
            border: 1px solid #CCC;
            margin-top: 10px;
        }

         .chatheader {
            padding: 5px;
            background: #f5deb3;
            border-radius: 5px;
            border: 1px solid #CCC;
            margin-top: 10px;
        }

        .chatinput {
            border-radius: 2px;
            border: 1px solid #ccc;
            margin-top: 10px;
            padding: 5px;
            width: 400px;
        }

        .chatstatus {
            width: 88px;
            display: block;
            float: left;
            margin-top: 15px;
        }
    </style>
</head>
<body>
<div class="chatcontainer">
<div class="chatheader"><h3>Atmosphere Chat. Default transport is WebSocket, fallback is long-polling</h3></div>
<div class="chatcontent"></div>
<div class="chatbox">
    <span class="chatstatus">Connecting...</span>
    <input type="text" class="chatinput" disabled="disabled"/>
</div>

</div>

</body>
</html>