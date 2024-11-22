<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StudentForm</title>
</head>
<body>
<div style="border:1px solid black;padding:20px;width:fit-content;border-radius:10px;background-color:#d9d9df;">
<h1>Student Form</h1>
	<form action="StudentController" method="post">
	
	        <input type="hidden" name="id" value="${studentKey.id }">
			<label for="name">Name</label>
            <input type="text" name="name" value="${studentKey.name}"><br><br>

            <label for="address">Address</label>
            <input type="text" name="address" value="${studentKey.address}"><br><br>

			<label for="contact">Contact Number</label>
           <%-- <input type="tel" name="contact" pattern="[0-9]{10}" placeholder="9841554532"><br><br>--%>
            <input type="number" name="contact" placeholder="9841554532" value="${studentKey.contact}"><br><br>


            <label for="gender">Gender</label>
            <select name="gender">
               <option value="male" ${studentKey.gender == 'male' ? 'selected' : ''}>Male</option>

                <option value="female" ${studentKey.gender == 'female' ? 'selected' : ''}>Female</option>

                <option value="others" ${studentKey.gender == 'others' ? 'selected' : ''}>Others</option>

            </select><br><br>

            
            <button type="submit">Submit</button>
	</form>
</div>
</body>
</html>



