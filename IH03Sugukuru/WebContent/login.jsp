<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sugukuru</title>

<link rel="stylesheet" type="text/css" href="css/login.css">
<link rel="stylesheet" type="text/css" href="css/a_original.css">

<script type="text/javascript">
<!--
	function check() {

		var flag = 0;
		var error="";
		
		// 設定開始（必須にする項目を設定してください）
		if(document.login.code.value == "" && document.login.pass.value == ""){
			flag = 1;
			error = "従業員コード・パスワードが未入力です";
		}else if (document.login.code.value == "") { // 「お名前」の入力をチェック
			flag = 1;
			error = "従業員コードが未入力です";
		} else if (document.login.pass.value == "") { // 「パスワード」の入力をチェック
			flag = 1;
			error = "パスワードが未入力です";
		}

		// 設定終了
		if (flag) {
			window.alert(error); // 入力漏れがあれば警告ダイアログを表示
			return false; // 送信を中止
		} else {
			return true; // 送信を実行
		}
	}
// -->
</script>

</head>
<body>
	<div class="form-wrapper">
		<h1>Sign In</h1>
		<form method="post" action="./LoginServlet" onSubmit="return check()" name="login">
			<div class="form-item">
				<label for="code"></label> <input type="text" name="code"
					required="required" placeholder="Employee Code"></input>
			</div>
			<div class="form-item">
				<label for="password"></label> <input type="password" name="pass"
					required="required" placeholder="Password"></input>
			</div>
			<div class="button-panel">
				<input type="submit" class="button" title="Sign In" value="Sign In"></input>
			</div>
		</form>
		<div class="form-footer"></div>
	</div>
</body>
</html>