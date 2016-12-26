<html>
<head>
    <meta name="layout" content="main"/>
</head>

<body>
<div class="container">
    <div class="row">
        <div class="page-header">
            <h1 class="centered">Register an Account Here:</h1>
        </div>
        <div class="col-md-6 col-xs-12">
            <form name="register" class="form-horizontal">
                <div class="form-group">
                    <g:if test="${flash.error}">
                        <div class="alert alert-error" style="display: block">${flash.error}</div>
                    </g:if>
                    <g:if test="${flash.message}">
                        <div class="message" style="display: block">${flash.message}</div>
                    </g:if>
                </div>

                <div class="form-group">
                    <label for="username">Username:</label>
                    <g:textField class="form-control" name="username" id="username"/>
                </div>

                <div class="form-group">
                    <label for="password">Password:</label>
                    <g:passwordField class="form-control" name="password" id="password" />
                </div>

                <div class="form-group">
                    <label for="confirmPass">ConfirmPassword:</label>
                    <g:passwordField class="form-control" name="confirmPass" id="confirmPass" />
                </div>

                <div class="form-group">
                    <label for="email">Email:</label>
                    <g:textField type="email" class="form-control" placeholder="example@examp.com" name="email" id="email" />
                </div>

                <g:actionSubmit value="Submit" class="btn btn-primary" action="doRegister" />
                <g:actionSubmit value="Login" action="index" class="btn btn-danger" />


            </form>
        </div>
        <div class="col-md-6 col-xs-12">
            <g:img dir="images" file="cover2.jpeg" class="img-responsive centered"   />
        </div>

    </div>
</div>
</body>
</html>