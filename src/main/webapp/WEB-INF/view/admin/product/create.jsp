<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8" />
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Dashboard - SB Admin</title>
                <link href="/css/styles.css" rel="stylesheet" />
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
                <script>
                    $(document).ready(() => {
                        const avatarFile = $("#avatarFile");
                        avatarFile.change(function (e) {
                            const imgURL = URL.createObjectURL(e.target.files[0]);
                            $("#avatarPreview").attr("src", imgURL);
                            $("#avatarPreview").css({ "display": "block" });
                        });
                    });
                </script>
            </head>

            <body class="sb-nav-fixed">
                <jsp:include page="../layout/header.jsp" />
                <div id="layoutSidenav">
                    <jsp:include page="../layout/sidebar.jsp" />
                    <div id="layoutSidenav_content">
                        <main>
                            <div class="container-fluid px-4">
                                <h1 class="mt-4">Manage Products</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                                    <li class="breadcrumb-item"><a href="/admin/product">Products</a></li>
                                    <li class="breadcrumb-item active">Create Product</li>
                                </ol>
                                <div class="mt-5">
                                    <div class="row">
                                        <div class="col-md-6 col-12 mx-auto">
                                            <h3>Create a product</h3>
                                            <hr>
                                            <form:form action="/admin/product/create" method="post"
                                                modelAttribute="product" enctype="multipart/form-data">
                                                <div class="row">
                                                    <div class="col-md-6 mb-3">
                                                        <label class="form-label">Name:</label>
                                                        <form:input type="text" class="form-control" path="name" />
                                                    </div>
                                                    <div class="col-md-6 mb-3">
                                                        <label class="form-label">Price:</label>
                                                        <form:input type="number" class="form-control" path="price" />
                                                    </div>
                                                </div>
                                                <div class="mb-3">
                                                    <label class="form-label">Description:</label>
                                                    <form:textarea class="form-control" path="detailDesc"
                                                        style="height: 80px;" />
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-6 mb-3">
                                                        <label class="form-label">Short description:</label>
                                                        <form:input type="text" class="form-control" path="shortDesc" />
                                                    </div>
                                                    <div class="col-md-6 mb-3">
                                                        <label class="form-label">Quantity:</label>
                                                        <form:input type="number" class="form-control"
                                                            path="quantity" />
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-6 mb-3">
                                                        <label class="form-label">Factory:</label>
                                                        <form:select class="form-select" path="factory">
                                                            <form:option value="Apple">Apple (MacBook)</form:option>
                                                            <form:option value="Asus">Asus</form:option>
                                                            <form:option value="Lenovo">Lenovo</form:option>
                                                            <form:option value="Dell">Dell</form:option>
                                                            <form:option value="LG">LG</form:option>
                                                            <form:option value="Acer">Acer</form:option>
                                                        </form:select>
                                                    </div>
                                                    <div class="col-md-6 mb-3">
                                                        <label class="form-label">Target:</label>
                                                        <form:select class="form-select" path="target">
                                                            <form:option value="">Gaming</form:option>
                                                            <form:option value="">Sinh viên - Văn phòng</form:option>
                                                            <form:option value="">Thiết kế đồ hoạ</form:option>
                                                            <form:option value="">Mỏng nhẹ</form:option>
                                                            <form:option value="">Doanh nhân</form:option>
                                                        </form:select>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-6 mb-3">
                                                        <label for="avatarFile" class="form-label">Image:</label>
                                                        <input class="form-control" type="file" id="avatarFile"
                                                            accept=".png, .jpg, .jpeg" name="hoidanitFile" />
                                                    </div>
                                                    <div class="mb-3">
                                                        <img src="" alt="avatar-preview" id="avatarPreview"
                                                            style="max-height: 250px; display: none;">
                                                    </div>
                                                </div>
                                                <div class="mb-3">
                                                    <button type="submit" class="btn btn-primary">Create</button>
                                                </div>
                                            </form:form>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </main>
                        <jsp:include page="../layout/footer.jsp" />
                    </div>
                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                    crossorigin="anonymous"></script>
                <script src="/js/scripts.js"></script>
            </body>

            </html>