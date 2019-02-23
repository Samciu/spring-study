<html lang="en-US">

<head>
    <meta charset="UTF-8">
    <title>用户信息</title>
</head>

<body>
    <table>
        <thead>
            <tr>
                <td>userId</td>
                <td>userName</td>
            </tr>
        </thead>
        <tbody>
            <#list userList as user>
                <tr>
                    <td>${user.userId}</td>
                    <td>${user.userName}</td>
                </tr>
            </#list>
        </tbody>
    </table>
</body>

</html>