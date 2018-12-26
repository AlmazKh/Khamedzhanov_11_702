<%--
  Created by IntelliJ IDEA.
  User: Almaz
  Date: 07.11.2018
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <%--<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">--%>
    <%--<meta name="description" content="">--%>
    <%--<meta name="author" content="">--%>
    <%--<link rel="icon" href="../../../../favicon.ico">--%>
    <link rel="stylesheet" href="css/style.css">

    <title>Starter page</title>

    <%--<script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>--%>
    <!-- Bootstrap core CSS -->
    <%--<link href="../../dist/css/bootstrap.min.css" rel="stylesheet">--%>

    <!-- Custom styles for this template -->
<%--
    <link href="starter-template.css" rel="stylesheet">
--%>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>

<script>
    function openPage(pageURL)
    {
        window.location.href = pageURL;
    }
</script>

<body background= "img/wallpaper.jpg">

<nav class="navbar navbar-expand-lg navbar-light bg-light d-none d-lg-flex">

    <a class="navbar-brand" href="file:///C:/Users/Almaz/Desktop/HS/starterPage.html#">
        <img src="img/logo_withHS.png" width="109" height="49" >
        <!--  <img src="logo_withHS.png">  -->
        <!-- <h1>HS</h1> --></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/starterPage">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#" role="button">
                    Hospitals
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/doctors" role="button">
                    Doctors
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/procedures" role="button">
                    Procedures
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="padding-right: auto">
                    Hello ${UserName}
                </a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>

<main role="main" class="container">

    <div class="container">
        <div class="row">
            <div class="card col-md-4 " style="background: #FFF; margin-top: 8vw; margin-left: 60vw"   >
                <form>
                    <p></p>
                    <h2 class="text-center"> Sign in to Hospital Service</h2>
                    <p class="lead">Login or register to get full access <br> to electronic Hospital Services</p>
                    <input type="button" class="btn btn-primary btn-block btn-lg" value="Sign in" onclick="openPage('/login')"/>
                     <p></p>
                    <input type="button" class="btn btn-success btn-block btn-lg" value="Sign up" onclick="openPage('/signUp')"/>
                    <p></p>
                </form>
            </div>
        </div>
    </div>

    <div class="starter-template">
        <br>
        <h1><font>Hospital Service</font></h1>
        <p class="lead">The best service to choose hospitals and experienced doctors.<br>  </p>
    </div>
    <br>
    <br>
    <br>


</main>

<!-- Button trigger modal -->
<form>
    <input type="submit" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
    Launch demo modal
    </input>

</form>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                ...
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>


<div class="contacts_block">
    <div class="container-fluid" style="background: #FFF;" >
        <br><br>
        <div class="contacts">
            <div class="col-md-11" style="background: #FFF; margin-right: auto; margin-left: auto; " >
                <h4 class="block_title">Контакты</h4>

                <div class="contacts_box">
                    <div class="contacts_info">
                        <p><span>адрес:</span>г. Казань, ул. Деревня универсиады, д.18 </p>
                        <p><span>телефон:</span>8(843)256-21-67</p>
                        <p><span>e-mail:</span>hospital@gmail.com</p>

                        <div class="map">
                            <iframe src="https://yandex.ru/map-widget/v1/-/CBBGa-cJwD" width="560" height="400" frameborder="1" allowfullscreen="true"></iframe>
                        </div>

                    </div>
                    <div class="contact_form">
                        <h5>Свяжитесь с нами</h5>
                        <form action="post" id="user_feedback">
                            <label for="user_name">Ваше имя:</label>
                            <input required="required" id="user_name" name="name" type="text">

                            <label for="user_phone">Ваш телефон:</label>
                            <input type="text" required="" value="8" pattern="[0-9]{7,20}" id="user_phone" name="phone">

                            <label for="user_mail">Ваш e-mail:</label>
                            <input type="email" required="" id="user_mail" name="email">

                            <label for="user_text">Ваше сообщение:</label>
                            <textarea name="text" id="user_text" cols="30" rows="10" placeholder="Ваш текст" ></textarea>

                            <input type="submit" class="btn blue"  value="Отправить">
                        </form>
                    </div>

                    <%--<div class="modal fade" id="feedbackModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">--%>
                        <%--<div class="modal-dialog" role="document">--%>
                            <%--<div class="modal-content">--%>
                                <%--<div class="modal-header">--%>
                                    <%--<h5 class="modal-title" id="modalLabel">Successful! Thanks for your feedback</h5>--%>
                                    <%--<button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
                                        <%--<span aria-hidden="true">&times;</span>--%>
                                    <%--</button>--%>
                                <%--</div>--%>
                                <%--<div class="modal-body">--%>
                                    <%--<h3>Successful! Thanks for your feedback</h3>--%>
                                <%--</div>--%>
                                <%--<div class="modal-footer">--%>
                                    <%--<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
                                    <%--<button type="button" class="btn btn-primary">Save changes</button>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <!-- Button trigger modal -->

                </div>
            </div>
        </div>
    </div>
</div>




<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<%--<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
<script src="../../assets/js/vendor/popper.min.js"></script>
<script src="../../dist/js/bootstrap.min.js"></script>--%>
<script>
    $('#submit_button').onclick(function(){
        $.ajax({
            url: '/starterPage',
            type: 'POST',
            dataType: 'html',
            data: $('#user_feedback').serialize(),
            success: function(){
                alert('Successful! Thanks for your feedback'); // отправлено удачно
            },
            error: function() {
                alert('Please, try again'); // ошибка
            }
        });

    });
</script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>

