<%--
  Created by IntelliJ IDEA.
  User: Almaz
  Date: 06.11.2018
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>Login</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
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
<body class="text-center" background= "img/wallpaper.jpg">

<div class="container" >

    <div class="row  justify-content-center ">

        <!--   <div class="card text-center w-50">
          <div class="card-body">   -->

        <div class="card col-md-4" style="background: #FFF; margin-top: 7vw;">

            <div class="auth-form px-3" id="login" >
                <div class="navbar-header" >
                    <!--  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                         <span class="icon-bar b1"></span>
                         <span class="icon-bar b2"></span>
                         <span class="icon-bar b3"></span>
                     </button>  -->
                    <a class="navbar-brand" href="file:///C:/Users/Almaz/Desktop/HS/starterPage.html#">
                        <img src="img/logo.png">
                        <!-- <h1>HS</h1> --></a>
                </div>
                <!-- '"` --><!-- </textarea></xmp> -->
                <form action="/session" accept-charset="UTF-8" method="post">
                    <input name="utf8" type="hidden" value="✓">
                    <input type="hidden" name="authenticity_token" value="Bo002FwyKDw8X4AEBtNPa7FXZC+eit+PCOZVGfoXgLyne8Sn7UMF+DVdQrTvTZzyKgV6CUBpOj/rQUkxzchopQ==">
                    <div class="auth-form-header p-0">
                        <h1>Sign in to Hospital Service</h1>
                    </div>

                    <div id="js-flash-container">
                    </div>
                    <div class="auth-form-body mt-3">

                        <label for="login_field" style="margin-right: 7vw;">
                            Username or email address
                        </label>
                        <input type="text" name="login" id="login_field" class="form-control input-block" tabindex="1" autocapitalize="off" autocorrect="off" autofocus="autofocus">

                        <label for="password" style="margin-right: 7vw;">
                            Password <a class="label-link" href="/password_reset">Forgot password?</a>
                        </label>
                        <input type="password" name="password" id="password" class="form-control form-control input-block" tabindex="2">
                        <br>
                        <input type="submit" name="commit" value="Sign in" tabindex="3" class="btn btn-primary btn-block" data-disable-with="Signing in…">
                    </div>
                </form>

                <p class="create-account-callout mt-3">
                    New to Hospital Service?
                    <a data-ga-click="Sign in, switch to sign up" href="/join?return_to=%2FAlmazKh&amp;source=login">Create an account</a>.
                </p>
            </div>
        </div>
        <!--  </div>
         </div> -->
    </div>
</div>
<p class="mt-5 mb-3 text-muted">©2018</p>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>

</html>
