$(function () {

    //A:单独使用JQuery  Ajax功能(随意返回各种类型数值)
    $.validator.addMethod("checkUsername",function (value,element) {
        var ret = false;
        $.ajax({
            dataType:"json",
            type:"get",
            url:"/checkUserName.do",
            data:{username:value},
            async:false,
            success:function(data){
                //返回值
                ret = data.success;
            },
        });

        return  ret;

    },"用户名已经存在");


    $('#register-form').validate({

        rules:{
            "username":{
                required:true,
                rangelength:[2,16],

                //B:在JQuery的validate功能中使用remote实现Ajax功能后台验证(只可返回String类型"true"或"false"值)
//                checkUsername:false,

            },
            "password":{
                required:true,
                rangelength:[2,16],
            },
            "confirm-password":{
                equalTo:"#password",
            },
        },

        messages:{
            "username":{
                required:"填写用户名",
                rangelength:"用户名的长度在{0}到{1}之间",
//                remote:"请",
            },
            "password":{
                required:"填写密码",
                rangelength:"密码的长度在{0}到{1}之间",
            },
            "confirm-password":{
                equalTo:"两次密码不一致",
            },
        },


        /*
        显示√ ×
         */
        // errorPlacement : function(error, element) {
        //     element.next().remove();
        //     element.after('<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>');
        //     element.closest('.form-group').append(error);
        // },

        errorClass:"text-danger",

        //给未通过验证的元素进行处理
        highlight : function(element) {
            $(element).closest('.form-group').addClass('has-error has-feedback');
        },
        //给通过验证的元素进行处理
        success : function(label) {
            // var el=label.closest('.form-group').find("input");
            // el.next().remove();
            // el.after('<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>');
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
            //不刷新页面,值提交form
            $(form).ajaxSubmit({
                url:"/registerUser.do",
                type:"post",
                dataType:"json",

                success:function (data){

                    if (data.state){


                        $.messager.confirm("提示","注册成功",function() {

                        });

                    }else {
                    alert(1);
                        $.messager.alert("提示",data.mes);
                    }
                }
            });
        },





    });


});
