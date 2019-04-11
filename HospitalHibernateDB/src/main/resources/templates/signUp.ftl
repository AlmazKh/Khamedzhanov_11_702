<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />

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
<body class="text-center" background= "static/img/wallpaper.jpg">

<div class="container" >

    <div class="row  justify-content-center ">

        <div class="card col-md-4" style="background: #FFF; margin-top: 7vw;">

            <div class="auth-form px-3" id="login" >
                <div class="navbar-header" >
                    <a class="navbar-brand" href="file:///C:/Users/Almaz/Desktop/HS/starterPage.html#">
                        <img src="static/img/logo.png">
                    </a>
                </div>
                <!-- '"` --><!-- </textarea></xmp> -->
                <form action="/signUp" method="post">
                    <div class="sign-up-form-header p-0">
                        <h1>Sign up to Hospital Service</h1>
                    </div>

                    <div class="sign-up-form-body mt-3">
                        <label for="first_name" style="margin-right: 7vw;" >First name</label>
                        <input type="text" name="firstName" id="first_name" placeholder="Ivan" required="required" class="form-control input-block" tabindex="1">

                        <label for="last_name" style="margin-right: 7vw;" >Last name</label>
                        <input type="text" name="lastName" id="last_name" placeholder="Ivanov" required="" class="form-control input-block" tabindex="2">

                        <div class="radio">
                            <span>Пол</span>
                            <label>
                                <input type="radio" name="gender" required="" value="man">man
                                <div class="radio-control male"></div>
                            </label>
                            <label>
                                <input type="radio" name="gender" required="" value="woman">woman
                                <div class="radio-control female"></div>
                            </label>
                        </div>

                        <label for="phone" style="margin-right: 3vw;" >Phone number</label>
                        <input type="text" name="phone" id="phone" required="" placeholder="89677704863" pattern="[0-9]{7,20}" class="form-control input-block" tabindex="3">

                        <label for="password" style="margin-right: 7vw;" >Password</label>
                        <input type="password" name="password" required="" id="password" class="form-control form-control input-block" tabindex="4">
                        <br>
                        <input type="submit" name="commit" value="Sign up" tabindex="5" class="btn btn-primary btn-block" >
                    </div>
                </form>

                <%--<p class="create-account-callout mt-3">--%>
                <%--New to Hospital Service?--%>
                <%--<a data-ga-click="Sign in, switch to sign up" href="/signUp">Create an account</a>.--%>
                <%--</p>--%>
            </div>
        </div>
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