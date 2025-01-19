<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8d7da;
            color: #721c24;
            text-align: center;
            padding: 50px;
        }
        .error-container {
            background-color: #f5c6cb;
            border: 1px solid #f5c2c7;
            border-radius: 5px;
            display: inline-block;
            padding: 20px;
            max-width: 600px;
        }
        .error-title {
            font-size: 24px;
            margin-bottom: 10px;
        }
        .error-message {
            font-size: 18px;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <h1 class="error-title">Oops! Something went wrong.</h1>
        <p class="error-message">
            We encountered an error while processing your request.<br>
            Please try again later.
        </p>
        <p>
            <strong>Error Details:</strong><br>
            <%= exception != null ? exception.getMessage() : "No additional details available." %>
        </p>
        <a href="index.jsp">Go Back to Home</a>
    </div>
</body>
</html>
