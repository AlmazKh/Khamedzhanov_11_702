<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Almaz
  Date: 30.10.2018
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Bootstrap core CSS -->
    <link href="../../dist/css/bootstrap.min.css" rel="stylesheet">
    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
            crossorigin="anonymous"></script>


    <!-- Custom styles for this template -->
    <link href="starter-template.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <title>Products</title>
    <script>
        function selectProduct(btnId) {
            $.ajax({
                type: 'post',
                url: '/products',
                data: {
                    product_id: btnId
                    // user_id: 1
            }
            }).done(function (data) {
                // alert("ryjgrf");
                let tableHtml = "";
                tableHtml += '<table>';
                // tableHtml +=
                //     '<tr>' +
                //     '<th>' +
                //     'products' +
                //     '</th>' +
                //     // '<th>' +
                //     // 'count' +
                //     // '</th>' +
                //     '</tr>';
                for (let i = 0; i < data.length; i++) {
                    tableHtml += '<tr>' +
                        '<td>' + data[i].name + '</td>' +
                        '<td>' + data[i].count + '</td>' +
                        '</tr>';

                    tableHtml += '<table id="delete">';
                    tableHtml += "<tr>";
                    tableHtml += '<td><button onclick="deleteProduct(' + data[i].id + ')" ">Delete </button></td>'
                    tableHtml += "</tr>";
                    tableHtml += "</table>";
                }
                tableHtml += '</table>';
                $("#products_table").html(tableHtml);
            }).fail(function () {
                alert('ALL BAD')
            });
        }
    </script>
    <script>
        function deleteProduct(btnId) {
            $.ajax({
                type: 'post',
                url: '/delete',
                data: {
                    product_id: btnId
                }
            }).done(function (data) {
                let tableHtml = "";
                tableHtml += '<table>';
                // tableHtml +=
                //     '<tr>' +
                //     '<th>' +
                //     'products' +
                //     '</th>' +
                //     '</tr>';
                for (let i = 0; i < data.length; i++) {
                    tableHtml += '<tr>' +
                        '<td>' + data[i].name + '</td>' +
                        '<td>' + data[i].count + '</td>' +
                        '</tr>';

                    tableHtml += '<table id="delete">';
                    tableHtml += "<tr>";
                    tableHtml += '<td><button onclick="deleteProduct(' + data[i].id + ')" ">Delete </button></td>'
                    tableHtml += "</tr>";
                    tableHtml += "</table>";
                }
                tableHtml += '</table>';
                $("#products_table").html(tableHtml);
            }).fail(function () {
                alert("НЕ ОЧ(((")
            });
        }
    </script>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-inverse bg-light d-none d-lg-flex">

    <a class="navbar-brand" href="#">WebShop</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
        </ul>

        <%--<form class="form-inline my-2 my-lg-0">--%>
            <%--<input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">--%>
            <%--<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>--%>
        <%--</form>--%>
    </div>
</nav>
<br>
<h2 style="margin-right: auto">User name: ${UserName}</h2>
<br>
<br>
<div>
    <%--<button onclick="select('product_1')" id="product_1">Product #1</button>--%>
    <%--<button onclick="select('product_2')" id="product_2">Product #2</button>--%>
    <%--<button onclick="select('product_3')" id="product_3">Product #3</button>--%>
    <%--<button id="basket">Basket</button>--%>
    <%--<button onclick="sendUser(document.getElementById('product_id').value)" id="send">Send</button>--%>
</div>
<div class="container">
    <div class="row">
        <div class="card-desk col-md-4" >
                <h2>Leyka</h2>
                <img class="card-img-top" src="/img/leyka.jpg" alt="Card image cap">
                <%--<img src="/img/leyka.jpg" width="100" height="1 00">--%>
                <%--<input  type="hidden" name="product" value="1" tabindex="1">--%>
                <button onclick="selectProduct('1')" id="1" type="submit" class="btn btn-success btn-block btn-lg">Buy</button>
        </div>

        <div class="card-desk col-md-4">
            <h2>Molotok</h2>
            <img class="card-img-top" src="/img/molotok.jpg" alt="Card image cap">
            <%--<img src="/img/molotok.jpg" width="100" height="100">--%>
            <%--<input  type="hidden" name="product" value="3" tabindex="2">--%>
            <button onclick="selectProduct('2')" id="2" type="submit" class="btn btn-success btn-block btn-lg">Buy</button>

        </div>

        <div class="card-desk col-md-4">
                <h2>Boty</h2>
                <img class="card-img-top"src="/img/boty.jpg" alt="Card image cap">
                <%--<img src="/img/boty.jpg" width="100" height="100">--%>
                <input type="hidden" name="product" value="2" tabindex="3">
            <button onclick="selectProduct('3')" id="3" type="submit" class="btn btn-success btn-block btn-lg">Buy</button>
        </div>
    </div>
</div>
<br>
<h3 style="margin-right: auto">Your basket:</h3>
<br>
<div id="products_table">
    <table>
        <c:forEach items="${products}" var="product">
             <tr>
                <td>${product.name}</td>
             </tr>
        </c:forEach>
    </table>
</div>


</body>
</html>
