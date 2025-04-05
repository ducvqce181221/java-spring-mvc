<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <!-- Latest compiled and minified CSS -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
                <!-- Latest compiled JavaScript -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
                <title>Delete user</title>
            </head>

            <body>
                <div class="container mt-5">
                    <div class="row">
                        <div class="col">
                            <h3>Delete the user with id = ${id}</h3>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col">
                            <div class="alert alert-danger" role="alert">
                                Are you sure to delete this user?
                            </div>
                        </div>
                    </div>
                    <form:form action="/admin/user/delete" method="post" modelAttribute="deleteUser">
                        <div class="mb-3" style="display: none;">
                            <label class="form-label">ID:</label>
                            <form:input type="text" class="form-control" path="id" />
                        </div>
                        <button class="btn btn-danger">Confirm</button>
                    </form:form>
                </div>

            </body>

            </html>