<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style type="text/css">
    * {
        margin: 0 auto;
        padding: 0 auto;
        text-align: center;
    }
</style>
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
    <script type="text/javascript" src="js/jquery-1.12.2.js"></script>
    <script type="text/javascript">
        function checkUser(){
          var name=$("#name").val();
            console.log("===============" + name);
            $.ajax({
                url: 'checkuser',
                type:'GET',
                data:{
                    name: name
                },
                dataType: 'json',
                success: function(data){
                    console.log("********success***********");
                    console.log(data);
                    $("#msg").text(data.msg);
                    if(data.code == 1){
                        $("#msg").css("color","red");
                    }else{
                        $("#msg").css("color","green");
                    }
                },
                error: function(error){
                    console.log("********error***********");
                    console.log(error);
                }
            })

        }
    </script>
</head>
<body>
<h1>注册页面</h1>
<form action="${pageContext.request.contextPath}/register" method="post">
    <label>用户</label><input type="text" id="name" name="name" onblur="checkUser();" /><br/>
    <label>密码</label><input type="password" name="password" /><br/>
    <label><span id="msg"></span></label>
    <input type="submit" value="注册"/>
</form>
</body>
</html>
