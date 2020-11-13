<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;
                                           charset=UTF-8">
    <title>JMS пример</title>
    <script src="js/jquery-3.2.1.min.js"
            type="text/javascript"></script>
    <script>
        function receiveMessages() {
            $.ajax({
                url : 'service',
                data : {
                    mode : 'receive' },
                success : function(response) {
                    $('#receiveJMS').html(response);
                }
            });
        }
    </script>
</head>
<body>
<p>Полученные сообщения:</p>
<input type="submit" width="80" value="Получить"
       onClick="receiveMessages()"><p />
<span id="receiveJMS" style="color: #7349a4;"> </span>
</body>
</html>