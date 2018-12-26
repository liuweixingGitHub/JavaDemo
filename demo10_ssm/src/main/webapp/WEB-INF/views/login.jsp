<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登陆</title>


    <!--js head-->
    <!--jquery-->
    <script src=" js/jquery/jquery-2.1.3.min.js"></script>

    <!--jquery插件-->
    <script src="https://cdn.bootcss.com/jquery.form/4.2.2/jquery.form.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery-validate/1.17.0/jquery.validate.min.js"></script>
    <script type="text/javascript" src="js/plugins/jquery.bootstrap.min.js"></script>

    <!--bootstrap-->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


    <!--css-->
    <link href="css/index.css" rel="stylesheet" type="text/css"/>

    <!--js-->
    <script type="text/javascript" src="js/service/login.js"></script>

</head>
<body>


<h1 class="text-center text-danger">登陆login.jsp</h1><br>

<form id="login-form" role="form" class="form-horizontal">


    <div class="form-group">
        <label class="col-sm-2 control-label" for="username">用户名：</label>
        <div class="col-sm-5">
            <input class="form-control" id="username" name="username"/>
        </div>
    </div>


    <div class="form-group">
        <label class="col-sm-2 control-label" for="password">密码：</label>
        <div class="col-sm-5">
            <input class="form-control" id="password" name="password"/>
        </div>
    </div>


    <div class="form-group">
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
    </div>


</form>




</body>
</html>