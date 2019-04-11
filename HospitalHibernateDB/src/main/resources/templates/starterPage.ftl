<!DOCTYPE html>
<html>
<head>
    <title>Record</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="static/css/style.css">
    <#--<script src="../../assets/js/vendor/popper.min.js"></script>-->
    <#--<script src="../../dist/js/bootstrap.min.js"></script>-->
    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
    <#--<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
    <!-- Bootstrap core CSS -->
    <link href="../../dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="starter-template.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
</head>

<body background= "static/img/wallpaper.jpg">

<nav class="navbar navbar-expand-lg navbar-light bg-light d-none d-lg-flex">

    <a class="navbar-brand" href="/starterPage">
        <img src="static/img/logo_withHS.png" width="109" height="49" >
    </a>
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
                <#if user??>
                    <li class="nav-item">
                        <a class="nav-link" href="/history" role="button" aria-haspopup="true" aria-expanded="false" style="padding-right: auto">
                            History
                        </a>
                    </li>
                </#if>
        </ul>
    </div>
</nav>

<main role="main" class="container">
    <div class="container">
        <div class="row">
            <#if user?? >
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
            <#else>
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
            </#if>
        </div>
    </div>
    <div class="starter-template">
        <br>
        <h1>Hospital Service</h1>
        <p class="lead">The best service to choose hospitals and experienced doctors.<br>  </p>
        <br><br><br>
    </div>
</main>
<div class="contacts_block">
    <div class="container-fluid" style="background: #FFF;" >
        <br><br>
        <div class="contacts">
            <div class="col-md-11" style="background: #FFF; margin-right: auto; margin-left: auto; " >
                <h4 class="block_title">Contacts</h4>

                <div class="contacts_box">
                    <div class="contacts_info">
                        <p><span>address:</span>Kazan, Universiade village steet, 18 </p>
                        <p><span>phone:</span>8(843)256-21-67</p>
                        <p><span>e-mail:</span>hospital@gmail.com</p>

                        <div class="map">
                            <iframe src="https://yandex.ru/map-widget/v1/-/CBBGa-cJwD" width="560" height="400" frameborder="1" allowfullscreen="true"></iframe>
                        </div>

                    </div>
                    <div class="contact_form">
                        <h5>Give us feedback</h5>
                        <form method="post" action="/starterPage" id="user_feedback">
                            <label for="user_name">Your name:</label>
                            <input required="required" id="user_name" name="name" type="text">

                            <label for="user_phone">Your phone:</label>
                            <input type="text" required="" value="8" pattern="[0-9]{7,20}" id="user_phone" name="phone">

                            <label for="user_mail">Your e-mail:</label>
                            <input type="email" required="" id="user_mail" name="email">

                            <label for="user_text">Your message:</label>
                            <textarea name="text" id="user_text" cols="30" rows="10" placeholder="Your text" ></textarea>

                            <input type="submit" id="submit_button" class="btn blue" data-toggle="modal" data-target="#feedbackModal" value="SUBMIT">
                        </form>
                    </div>

                    <div class="modal fade" id="feedbackModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="modalLabel">Successfully</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <h5>Thanks for your feedback</h5>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $("#submit_button").on('click', function (e) {
        e.preventDefault(); //отмена стандартной отравки формы
        var formDataSer = $("#user_feedback").serializeArray();
        var formData = {};
        formDataSer.forEach(function (i) {
            formData[i.name] = i.value;
        });
        $.ajax({
            type: 'post',
            url: '/starterPage',
            data: formData
        }).done(function (data) {
            $("#feedbackModal").modal('show'); // bootstrap documentation
            // https://getbootstrap.com/docs/4.1/components/modal/#methods
            // $('#user_feedback input').each(function (e) {
            //     e.val('');
            // })
            document.querySelectorAll('#user_feedback input, #user_feedback textarea').forEach(function (e) {
                e.value = '';
            })
        });

    });
</script>
<script>
    function openPage(pageURL)
    {
        window.location.href = pageURL;
    }
</script>

</body>
</html>