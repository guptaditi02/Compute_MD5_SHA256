<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Hash Calculator</title>
</head>
<body>
<h1>Hash Calculator</h1>
<form action="ComputeHashes" method="GET">
  <label for="text">Enter Text:</label>
  <input type="text" id="text" name="text" required><br><br>

  <label>Select Hash Function:</label><br>
  <input type="radio" id="md5" name="hashType" value="MD5" checked>
  <label for="md5">MD5</label><br>
  <input type="radio" id="sha256" name="hashType" value="SHA-256">
  <label for="sha256">SHA-256</label><br><br>

  <input type="submit" value="Compute Hash">
</form>
</body>
</html>
