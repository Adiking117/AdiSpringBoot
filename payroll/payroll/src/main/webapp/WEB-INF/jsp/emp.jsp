<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Form</title>
    <style>
        /* Reset and Global Styles */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Arial', sans-serif;
        }

        body {
            background-color: #f9f9f9;
            color: #333;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            flex-direction: column;
            font-size: 16px;
        }

        h1 {
            color: #4CAF50;
            text-align: center;
            font-size: 36px;
            margin-bottom: 20px;
            transition: color 0.3s ease;
        }

        h1:hover {
            color: #388E3C;
        }

        /* Form Container Styling */
        .form-container {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
            padding: 40px;
            max-width: 500px;
            width: 100%;
            margin-top: 20px;
            transform: translateY(-20px);
            opacity: 0;
            animation: formFadeIn 0.6s forwards ease-out;
        }

        @keyframes formFadeIn {
            to {
                transform: translateY(0);
                opacity: 1;
            }
        }

        .form-container label {
            font-size: 14px;
            color: #555;
            margin-bottom: 8px;
            display: block;
            font-weight: bold;
            transition: color 0.3s ease;
        }

        .form-container label:hover {
            color: #4CAF50;
        }

        .form-container input {
            width: 100%;
            padding: 14px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 16px;
            transition: border-color 0.3s ease, box-shadow 0.3s ease;
        }

        .form-container input:focus {
            border-color: #4CAF50;
            box-shadow: 0 0 8px rgba(76, 175, 80, 0.3);
            outline: none;
        }

        .form-container button {
            background-color: #4CAF50;
            color: #fff;
            border: none;
            padding: 14px;
            font-size: 16px;
            width: 100%;
            border-radius: 6px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .form-container button:hover {
            background-color: #388E3C;
        }
    </style>
</head>
<body>
    <h1>Employee Form</h1>

    <!-- Employee form using Spring form tags -->
    <div class="form-container">
        <form:form id="employeeForm" modelAttribute="employee" method="POST">
            <div>
                <label for="id">ID:</label>
                <form:input path="id" id="id" type="number" required="true" />
            </div>
            <div>
                <label for="name">Name:</label>
                <form:input path="name" id="name" type="text" required="true" />
            </div>
            <div>
                <label for="designation">Designation:</label>
                <form:input path="designation" id="designation" type="text" required="true" />
            </div>
            <div>
                <label for="email">Email:</label>
                <form:input path="email" id="email" type="email" required="true" />
            </div>
            <div>
                <button type="submit">Save Employee</button>
            </div>
        </form:form>
    </div>
</body>
</html>
