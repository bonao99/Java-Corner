<%-- 
    Document   : customerForm
    Created on : Aug 7, 2020, 11:12:47 PM
    Author     : alvindiaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WEB MVC APP</title>
    </head>
    <body>
        <h1>Customer Form</h1>
        <br/>
        <hr/>
        <form action="/MVCTest/Customer" method="POST">
            <label for="custIdInput">ID</label>
            <input id="custIdInput" name="custId"/>
            <label for="custNameInput">Name</label>
            <input id="custNameInput" name="custName"/>
            <label for="custLastNameInput">Last Name</label>
            <input id="custLastNameInput" name="custLastName"/>
            <label for="custAgeInput">Age</label>
            <input id="custAgeInput" name="custAge"/>
            <label for="custEnableInput">Enable</label>
            <input type="checkbox" id="custEnableInput" name="custEnable" value="true">
            <input type="submit" value="Submit">
        </form>
        <br/>
        <h3>${transactionResultMessage}</h3>
        <hr/>
    </body>
</html>
