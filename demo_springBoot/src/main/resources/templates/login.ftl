<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登陆</title>

</head>
<body>


<h1 class="text-center text-danger">登陆</h1><br>

<form id="login-form" role="form" class="form-horizontal">


    <div class="form-group">
        <label class="col-sm-2 control-label" for="username">用户名：</label>
        <div class="col-sm-5">
            <input class="form-control" id="username" name="username"/>
        </div>
    </div>


    <div class="form-group">
        <label class="col-sm-2 control-label" for="password" >密码：</label>
        <div class="col-sm-5">
            <input class="form-control" id="password" name="password" type="password"/>
        </div>
    </div>


    <div class="form-group">
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
    </div>
</form>

<div style="margin-top:20px">
    <button id="registerBtn" class="btn btn-lg btn-primary btn-block">注册</button>
</div>


</body>


<script src="${request.contextPath}/js/plugins/jquery-2.1.3.min.js"></script>
<script src="${request.contextPath}/js/plugins/jquery.form-4.2.2.min.js"></script>
<script src="${request.contextPath}/js/plugins/jquery.validate-1.8.1.min.js"></script>
<script src="${request.contextPath}/js/plugins/bootstrap-4.2.1.min.js"></script>
<script src="${request.contextPath}/js/plugins/jquery.bootstrap.min.js"></script>
<link href="${request.contextPath}/css/plugins/bootstrap-4.2.1.min.css" rel="stylesheet">

<!--css-->
<link href="${request.contextPath}/css/service/base.css" rel="stylesheet" type="text/css"/>


<!--js-->
<script type="text/javascript" src="${request.contextPath}/js/service/contextPath.js"></script>
<script type="text/javascript" src="${request.contextPath}/js/service/login.js"></script>


</html>