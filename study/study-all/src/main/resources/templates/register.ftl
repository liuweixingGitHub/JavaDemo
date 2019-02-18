<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
</head>
<body>


<h1 class="text-center text-danger">注册</h1><br>


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
        <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
    </div>

</form>


</body>

<script src="/js/plugins/jquery-2.1.3.min.js"></script>
<script src="/js/plugins/jquery.form-4.2.2.min.js"></script>
<script src="/js/plugins/jquery.validate-1.8.1.min.js"></script>
<script src="/js/plugins/bootstrap-4.2.1.min.js"></script>
<script src="/js/plugins/jquery.bootstrap.min.js"></script>
<link href="/css/plugins/bootstrap-4.2.1.min.css" rel="stylesheet">

<!--css-->
<link href="css/service/base.css" rel="stylesheet" type="text/css"/>

<!--js-->
<script type="text/javascript" src="js/service/register.js"></script>

</html>