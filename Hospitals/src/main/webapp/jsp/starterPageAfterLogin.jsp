<%--
  Created by IntelliJ IDEA.
  User: Almaz
  Date: 07.11.2018
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">
    <link rel="stylesheet" href="css/style.css">

    <title>Title</title>

    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
    <!-- Bootstrap core CSS -->
    <link href="../../dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="starter-template.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
</head>
<body background= "img/wallpaper.jpg">

<nav class="navbar navbar-expand-lg navbar-light bg-light d-none d-lg-flex">

    <a class="navbar-brand" href="file://C:\Users\Almaz\Desktop\Khamedzhanov_11_702\Hospitals\src\main\webapp\jsp\starterPageAfterLogin.jsp#">
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
                <p></p>
                <h2 class="text-center"> Record on the procedure</h2>
                <p class="lead">Here you can choose the procedures<br> and doctors what you need</p>
                <input type="button" class="btn btn-primary btn-lg" value="Record" onclick="openPage('/record')" />
                <p></p>
                <p></p>
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


</main><!-- /.container -->
<!--
    <div class="container-fluid" style="background: #FFF;" >
        <div class="card">
          <div class="col-md-12" style="background: #FF9; ">
          <p>sdfsdf
            <br><br><br>
          </p>
          </div>

        </div>

    </div> -->

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
                        <form action="">
                            <label for="user_name">Ваше имя:</label>
                            <input required="required" id="user_name" type="text">

                            <label for="user_phone">Ваш телефон:</label>
                            <input type="text" required="" value="8" pattern="[0-9]{7,20}" id="user_phone">

                            <label for="user_mail">Ваш e-mail:</label>
                            <input type="email" required="" id="user_mail">

                            <label for="user_text">Ваше сообщение:</label>
                            <textarea name="" id="user_text" cols="30" rows="10" placeholder="Ваш текст" ></textarea>

                            <input type="submit" class="btn blue" value="Отправить">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    function openPage(pageURL)
    {
        window.location.href = pageURL;
    }
</script>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
<script src="../../assets/js/vendor/popper.min.js"></script>
<script src="../../dist/js/bootstrap.min.js"></script>


</body>
</html>
