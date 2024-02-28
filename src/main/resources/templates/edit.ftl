<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="/js/script.js"></script>
</head>
<body>
<!-- comments in html -->
<input type="text" value="${customer.name}" name="name" id="name"> <br>
<input type="text" value="${customer.email}" name="email" id="email"> <br>
<input type="date" value="${customer.registrationDate}" name="registrationDate" id="registrationDate"> <br>

<input type="hidden" value="${customer.id}" name="id" id="id"> <br>
<input type="button" value="edit Customer id=${customer.id}" onclick="updateCustomer()">


<div id="errorDiv"></div>
<div id="resultDiv"></div>
</body>
</html>