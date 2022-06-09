<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="css/index.css">
        <script src="js/index.js"></script>
    </head>
    <body>

        <div class="wrapper">  
            
            <div class="nav">
                <a href="#" class="logo">Home</a>
                <div class="nav-right">
                    <a id="loginInfo">
                        loginInfo
                        <img id="chatIcon" alt="chat" src="img/chat.png"/>
                        <img id="notiIcon" alt="notification" src="img/notification.png"/>
                    </a>
                    <a class="active" href="#home">logout</a>
                </div>
            </div>
            <div id="mySidenav" class="sidenav">
                <a href="#" id="Document" onclick="openNav()">Document</a>
                <a href="#" id="Calendar" onclick="openNav()">Calendar</a>
                <a href="#" id="Member" onclick="openNav()">Member</a>
                <a href="#" id="Template" onclick="openNav()">Template</a>
            </div>
            <div class="content">
                <!--여기 넣으면 됨-->
                <div class="child1"></div>
            </div>
        </div>
    </body>
</html>