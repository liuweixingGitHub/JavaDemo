$(function () {

    $('#registerBtn').click(function () {


        window.location.href = getContextPath("/registerPage.do");

    });


    $('#login-form').validate({

        rules: {
            "username": {
                required: true,
                rangelength: [2, 16],

            },
            "password": {
                required: true,
                rangelength: [2, 16],
            },
        },
        messages: {
            "username": {
                required: "填写用户名",
                rangelength: "用户名的长度在{0}到{1}之间",
            },
            "password": {
                required: "填写密码",
                rangelength: "密码的长度在{0}到{1}之间",
            },
        },

        /*
        显示√ ×
         */
        errorPlacement: function (error, element) {
            element.next().remove();
            element.after('<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>');
            element.closest('.form-group').append(error);
        },

        //给未通过验证的元素进行处理
        highlight: function (element) {
            $(element).closest('.form-group').addClass('has-error has-feedback');
        },
        //给通过验证的元素进行处理
        success: function (label) {
            var el = label.closest('.form-group').find("input");
            el.next().remove();
            el.after('<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>');
            label.closest('.form-group').removeClass('has-error').addClass("has-feedback has-success");
            label.remove();
        },

        /*
        提交表单
         */
        submitHandler: function (form) {

            //刷新页面,显示json数据
            // form.submit(); //没有这一句表单不会提交
            // $(form).ajaxForm(function() {
            //
            // });

            //不刷新页面,值提交form
            $(form).ajaxSubmit({

                url: getContextPath("/login.do"),
                type: "post",
                dataType: "json",
                success: function (data) {
                    alert(data);
                    alert(data.code);

                    if (data.code == 200) {

//                        $.messager.confirm("提示","登陆成功,点击确定跳转到个人中心",function() {
                        /**直接进去静态页面*/
// window.location.href="/home.html";
                        
                        // alert(JSON.stringify(data.data));

                        window.localStorage.setItem('user', JSON.stringify(data.body));

                        // var User = { "id":0 ,"userType":0 ,"username": "","password":"","token":""};


                        // var user = JSON.parse(localStorage.getItem('user'));


                        // alert(user.token);

                        window.location.href=getContextPath("/home.page");

//                        });

                    } else {
                        $.messager.alert("提示", data.msg);
                    }
                }
            });

//            $(form).ajaxSubmit({
//                url:"/home.page",
//                type:"get",
////                dataType:"json",
//            });
        },

    });


});
