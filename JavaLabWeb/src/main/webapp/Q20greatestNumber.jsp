<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find the Greatest Number</title>
</head>
<body>
<h1>Find the Greatest Number</h1>
<form action="" method="post">
    <label for="firstNumber">First Number:</label>
    <input type="text" name="firstNumber"><br><br>

    <label for="secondNumber">Second Number:</label>
    <input type="text" name="secondNumber"><br><br>

    <label for="thirdNumber">Third Number:</label>
    <input type="text" name="thirdNumber"><br><br>

    <button type="submit">Submit</button>
</form>

<%
    String num1 = request.getParameter("firstNumber");
    String num2 = request.getParameter("secondNumber");
    String num3 = request.getParameter("thirdNumber");

    if (num1 != null && num2 != null && num3 != null) {
        try {
            int a = Integer.parseInt(num1);
            int b = Integer.parseInt(num2);
            int c = Integer.parseInt(num3);

            // Find the greatest number without Math.max
            int greatest;
            if (a >= b && a >= c) {
                greatest = a;
            } else if (b >= a && b >= c) {
                greatest = b;
            } else {
                greatest = c;
            }
%>
            <h2>The greatest number among <%= a %>, <%= b %>, and 
            <%= c %> is: <%= greatest %></h2>
<%
        } catch (Exception e) {
%>
            <h2 style="color: red;">Invalid input! Please enter valid numbers.</h2>
<%
        }
    }
%>
</body>
</html>
