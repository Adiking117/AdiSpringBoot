<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Employees</title>
    <style>
        /* Reset and Global Styles */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Arial', sans-serif;
        }

        body {
            background-color: #f4f4f9;
            color: #333;
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 20px;
            font-size: 16px;
        }

        h1 {
            color: #4CAF50;
            font-size: 36px;
            margin-bottom: 20px;
            text-align: center;
            transition: color 0.3s ease;
        }

        h1:hover {
            color: #388E3C;
        }

        /* Employee Table Styling */
        .employee-table {
            width: 90%;
            max-width: 1200px;
            margin-top: 20px;
            border-collapse: collapse;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            overflow: hidden;
            background-color: #fff;
        }

        .employee-table thead {
            background-color: #4CAF50;
            color: white;
        }

        .employee-table th, .employee-table td {
            padding: 12px 15px;
            text-align: left;
            font-size: 16px;
        }

        .employee-table tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        .employee-table tr:hover {
            background-color: #f1f1f1;
            transition: background-color 0.3s ease;
        }

        .employee-table th {
            text-transform: uppercase;
        }

        .employee-table td {
            border-bottom: 1px solid #ddd;
        }

        /* Button Styling */
        .back-button {
            margin-top: 20px;
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .back-button:hover {
            background-color: #388E3C;
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            .employee-table th, .employee-table td {
                font-size: 14px;
                padding: 10px;
            }

            h1 {
                font-size: 28px;
            }
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
    <h1>All Employees</h1>

    <!-- Employee Table -->
    <table class="employee-table" id="employeeTable">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Designation</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
            <!-- Dynamic rows will be inserted here via JavaScript -->
        </tbody>
    </table>

    <!-- Back Button -->
    <button class="back-button" onclick="window.location.href='/employee'">Back to Employee Form</button>

    <script>
        $(document).ready(function () {
            fetchEmployees();

            function fetchEmployees() {
                $.ajax({
                    url: '/employee/getAllEmployees', // Correct endpoint returning JSON
                    method: 'GET',
                    success: function (response) {
                        console.log('Server Response:', response); // Debugging: Log the response
                        populateEmployeeTable(response); // Call function to populate the table
                    },
                    error: function (xhr, status, error) {
                        console.error('Error fetching employees:', error);
                        alert('Failed to fetch employees. Please try again later.');
                    }
                });
            }

            function populateEmployeeTable(employees) {
                const employeeTableBody = $('#employeeTable tbody');
                employeeTableBody.empty(); // Clear existing rows

                if (!Array.isArray(employees)) {
                    console.error('Unexpected data format:', employees);
                    alert('Invalid data format received.');
                    return;
                }

                employees.forEach((employee) => {
                    // Debugging: Log each employee object
                    console.log('Adding employee:', employee);

                    // Create a new table row for each employee
                    const row = `
                        <tr>
                            <td>${employee.id}</td>
                            <td>${employee.name}</td>
                            <td>${employee.designation}</td>
                            <td>${employee.email}</td>
                        </tr>
                    `;
                    console.log('Generated row:', row);
                    employeeTableBody.append(row); // Append row to the table body
                });

                if (employees.length === 0) {
                    employeeTableBody.append('<tr><td colspan="4">No employees found.</td></tr>');
                }
            }
        });

    </script>
</body>
</html>
