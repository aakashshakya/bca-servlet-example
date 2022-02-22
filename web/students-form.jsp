<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Form</title>
        <style>
            body {
                width: 50%;
                font-family: Arial, Helvetica, sans-serif;
                margin: auto;
            }

            form {
                border: 3px solid #f1f1f1;
            }

            input[type=text],
            input[type=password] {
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                box-sizing: border-box;
            }

            button {
                background-color: #2782e9;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 100%;
            }

            button:hover {
                opacity: 0.8;
            }

            .container {
                padding: 16px;
            }

            .error-message {
                color: red;
                display: none;
            }

            .login-success {
                border: 1px solid rgb(28, 82, 28);
                display: none;
                padding: 2px;
                background-color: rgb(158, 247, 158);
            }
        </style>
    </head>
    <body>
        <h1>Please fill the form below</h1>
        <form method="POST" action="http://localhost:8080/JAVA_SERVLET_BCA_2075/add-student">
            <div class="container">
                <label for="full-name"></label>
                <input type="text" name="full_name" id="full-name" required="" placeholder="Enter your full name" /><br>
                
                <label for="address"></label>
                <input type="text" name="address" id="address" required="" placeholder="Enter your address" /><br>
                
                <label for="contact-number"></label>
                <input type="text" name="contact_number" id="contact-number" required="" placeholder="Enter your contact number" /><br>
                
                <label for="college-name"></label>
                <input type="text" name="college_name" id="college-name" required="" placeholder="Enter your college name" /><br>
                
                <label for="percentage"></label>
                <input type="text" name="percentage" id="percentage" required="" placeholder="Enter your +2 Percentage" /><br>
                
                <label for="dob"></label>
                <input type="text" name="dob" id="dob" required="" placeholder="Enter your date of birth" /><br>
                
                <button type="submit">Submit</button>
            </div>
        </form>
    </body>
</html>
