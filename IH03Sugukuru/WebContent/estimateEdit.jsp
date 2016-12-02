<%@page import="common.getJspData"%>
<%@page import="common.Common"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="common.DetailEstimate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	/* sessionの取得 */
	String employee_code = "";
	employee_code = (String) session.getAttribute("code");

	Common common = new Common();

	//特定の見積番号を取得
	String est_code = request.getParameter("code");

	//見積番号から詳細内容を取得
	getJspData gj = new getJspData();
	HashMap<String, String> hash = new HashMap<String, String>();
	hash = gj.getEstStatus(est_code);
	System.out.println(hash);
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<%
	if (session.getAttribute("post") == null) {
%>
<meta http-equiv="refresh" content="0.1;URL=login.jsp">
<%
	}
%>
<%
	if (session.getAttribute("code") == null) {
%>
<meta http-equiv="refresh" content="0.1;URL=login.jsp">
<%
	}
%>
<title>Sugukuru_top</title>
<!-- BootstrapのCSS読み込み -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery読み込み -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- BootstrapのJS読み込み -->
<script src="js/bootstrap.min.js"></script>

<!-- OriginalのCSS読み込み -->
<link href="css/common.css" rel="stylesheet">
<link href="css/approval_credit.css" rel="stylesheet">
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
							<li><a href="ListEstimate.jsp">見積書一覧</a></li>
							<li><a href="createEstimate.jsp">見積書作成</a></li>
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
				<!-- ログイン情報表示エリア -->
				<div id="login">
					<p id="login_code">
						従業員CD：<%
						out.print(employee_code);
					%>
						<a href="LogoutServlet">ログアウト</a>
					</p>
				</div>
			</div>
		</nav>
	</div>

	<!-- Navbar end
  ================================================== -->
	<div class="container">
		<%
			if (common.parseIntegerforString(hash.get("status")) == 0) {
		%>
		<form method="post" action="./ApprovalServlet">
			<input type="hidden" name="est_code" value="<%=est_code%>">
			<button type="submit" class="btn btn-primary" id="approval"
				onClick="actionChange2">承認</button>
			<%
				} else if (common.parseIntegerforString(hash.get("status")) != 4
						&& common.parseIntegerforString(hash.get("status")) != 5) {
			%>
			<form method="post" action="./CreditChangeServlet">
				<input type="hidden" name="est_code" value="<%=est_code%>">
				<input type="hidden" name="client_code"
					value="<%=hash.get("client_code")%>"> <input type="hidden"
					name="total" value="<%=hash.get("total")%>"> <input
					type="hidden" name="status" value="<%=hash.get("status")%>">
				<p>与信オーバー時の対応選択</p>
				<p>
					<select name="credit_over_status">
						<option value="0">----</option>
						<option value="1">先払い</option>
						<option value="2">現金払い</option>
						<option value="3">一時的に与信限度の上昇（見積金額分）</option>
					</select>
				</p>

				<button type="submit" class="btn btn-primary" id="change">変更</button>
				<%
					}
				%>
			</form>
	</div>

</body>

</html>
