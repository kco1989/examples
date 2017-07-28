<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>upload page</title>
</head>
<body>
<div class="upload">
    <form action="/upload" enctype="multipart/form-data" method="post">
        <input type="file" name="file1"><br>
        <input type="file" name="file2"><br>
        <input type="submit" value="上传">
    </form>

    <hr>
    <form action="/uploads" enctype="multipart/form-data" method="post">
        <input type="file" name="file"><br>
        <input type="file" name="file"><br>
        <input type="file" name="file"><br>
        <input type="submit" value="上传">
    </form>
</div>
</body>
</html>