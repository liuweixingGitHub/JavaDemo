$(function () {


    $('#login-form').validate({

        rules:{
            "username":{
                required:true,
                rangelength:[2,16],

            },
            "password":{
                required:true,
                rangelength:[2,16],
            },
        },
        messages:{
            "username":{
                required:"填写用户名",
                rangelength:"用户名的长度在{0}到{1}之间",
                remote:"用户已经存在",
            },
            "password":{
                required:"填写密码",
                rangelength:"密码的长度在{0}到{1}之间",
            },
        },

//                errorClass:"text-danger",

        /*
        显示√ ×
         */
        errorPlacement : function(error, element) {
            element.next().remove();
            element.after('<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>');
            element.closest('.form-group').append(error);
        },

        //给未通过验证的元素进行处理
        highlight : function(element) {
            $(element).closest('.form-group').addClass('has-error has-feedback');
        },
        //给通过验证的元素进行处理
        success : function(label) {
            var el=label.closest('.form-group').find("input");
            el.next().remove();
            el.after('<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>');
            label.closest('.form-group').removeClass('has-error').addClass("has-feedback has-success");
            label.remove();
        },

        /*
        提交表单
         */
        submitHandler:function(form) {

            //刷新页面,显示json数据
            // form.submit(); //没有这一句表单不会提交
            // $(form).ajaxForm(function() {
            //
            // });

            //不刷新页面,值提交form
            $(form).ajaxSubmit({

                dataType:"json",

                success:function (data){

                    if (data.success){

                        $.messager.confirm("提示","登陆成功,点击确定跳转到个人中心",function() {
                            window.location.href="/user/menu.do";
                        });

                    }else {
                        $.messager.alert("提示",data.mes);
                    }


                }
            });

        },





    });


});
