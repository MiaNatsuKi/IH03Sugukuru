<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	/* sessionの取得 */
	String employee_code = "";
	employee_code = (String) session.getAttribute("code");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sugukuru_CreateEstimate</title>
<!-- BootstrapのCSS読み込み -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery読み込み -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- BootstrapのJS読み込み -->
<script src="js/bootstrap.min.js"></script>
<!-- 自己スタイルのcss読込-->
<link href="css/style.css" rel="stylesheet">

</head>

<body>
	<!-- Navbar
  ================================================== -->
	<div class="bs-component">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="index.jsp">Sugukuru</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">見積管理
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="ListEstimate.jsp">見積書</a></li>
						</ul></li>
				</ul>

				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">受注管理
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">注文請求書作成</a></li>
							<li><a href="#">受注台帳管理</a></li>
							<li><a href="#">ピッキングリスト作成</a></li>
							<li class="divider"></li>
							<li><a href="#">メーカー直送</a></li>
							<li><a href="#">帳票出力</a></li>
							<li><a href="#">注文書作成</a></li>
						</ul></li>
				</ul>

				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">出荷管理
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">納品書作成</a></li>
							<li><a href="#">出荷報告書作成</a></li>
							<li><a href="#">帳票出力(納品書)</a></li>
							<li class="divider"></li>
							<li><a href="#">帳票出力(出荷報告書)</a></li>
							<li><a href="#">出荷指示書作成</a></li>
						</ul></li>
				</ul>

				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">請求管理
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">請求書作成</a></li>
							<li><a href="#">請求書一覧表示</a></li>
							<li><a href="#">請求書再発行</a></li>
						</ul></li>
				</ul>

				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">売上管理
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">売上伝票管理</a></li>
							<li><a href="#">製品有高帳管理</a></li>
							<li><a href="#">得意先元帳管理</a></li>
						</ul></li>
				</ul>

				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">回収管理
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">入金管理</a></li>
							<li><a href="#">当座預金出納簿管理</a></li>
							<li><a href="#">決算帳表管理</a></li>
						</ul></li>
				</ul>

				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">マスタ管理
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">商品管理</a></li>
							<li><a href="#">取引先管理</a></li>
							<li><a href="#">顧客管理</a></li>
						</ul></li>
				</ul>
				<div id="login">
					<!-- ログイン時はpタグのaaaと書かれている所にログイン時の従業員CDを入れる-->
					<p>
						従業員CD：<%
						out.print(employee_code);
					%>
					</p>
					<a href="LogoutServlet">ログアウト</a>
				</div>
			</div>
		</nav>
	</div>

	<!-- Navbar end
  ================================================== -->

</body>

</html>
