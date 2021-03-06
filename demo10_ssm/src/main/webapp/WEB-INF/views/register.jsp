<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>


    <!--js head-->
    <!--jquery-->
    <script src=" js/jquery/jquery-2.1.3.min.js"></script>

     <!--jquery插件-->
       <script src="js/plugins/jquery.form.min.js"></script>
       <script src="js/plugins/jquery.validate.min.js"></script>
       <script type="text/javascript" src="js/plugins/jquery.bootstrap.min.js"></script>

       <!--bootstrap-->
       <link href="../../js/plugins/bootstrap-3.3.7.min.css" rel="stylesheet">
       <script src="../../js/plugins/jquery.bootstrap.min.js"></script>


    <!--css-->
    <link href="../../css/register.css" rel="stylesheet" type="text/css"/>

    <script type="text/javascript" src="../../js/service/register.js"></script>

</head>
<body>


<h1 class="text-center text-danger">注册2</h1><br>

<form id="register-form" role="form" class="form-horizontal">



    <div class="form-group">
        <label class="col-sm-2 control-label" for="username">用户名：</label>
        <div class="col-sm-5">
            <input class="form-control" id="username" name="username" />
        </div>
    </div>


    <div class="form-group">
        <label class="col-sm-2 control-label" for="password">密码：</label>
        <div class="col-sm-5">
            <input class="form-control" id="password" name="password" />
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label" for="confirm-password">确认密码：</label>
        <div class="col-sm-5">
            <input class="form-control" id="confirm-password" name="confirm-password" />
        </div>
    </div>

       <div class="form-group">
            <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
        </div>


</form>





</body>
</html>