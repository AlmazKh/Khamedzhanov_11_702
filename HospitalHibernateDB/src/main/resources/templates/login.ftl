<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />

    <title>Login</title>

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
<body class="text-center" background= "/img/wallpaper.jpg">

<div class="container" >

    <div class="row  justify-content-center ">

        <div class="card col-md-4" style="background: #FFF; margin-top: 7vw;">

            <div class="auth-form px-3" id="login" >
                <div class="navbar-header" >
                    <a class="navbar-brand" href="file:///C:/Users/Almaz/Desktop/HS/starterPage.html#">
                        <img src="/img/logo.png">
                    </a>
                </div>
                <form method="post">

                    <div class="auth-form-header p-0">
                        <h1>Sign in to Hospital Service</h1>
                    </div>

                    <div class="auth-form-body mt-3">

                        <label for="login_field" style="margin-right: 7vw;">
                            Phone number
                        </label>
                        <input type="text" name="phone" id="login_field" class="form-control input-field" tabindex="1">

                        <label for="password" style="margin-right: 7vw;">
                            Password <a class="label-link" href="/starterPage">Forgot password?</a>
                        </label>
                        <input type="password" name="password" id="password" class="form-control form-control input-block" tabindex="2">
                        <br>
                        <input type="submit" name="commit" value="Sign in" tabindex="3" class="btn btn-primary btn-block" >
                    </div>
                </form>

                <p class="create-account-callout mt-3">
                    New to Hospital Service?
                    <a data-ga-click="Sign in, switch to sign up" href="/signUp">Create an account</a>.
                </p>
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
