<%@page import="common.Common"%>
<%@page import="common.DetailEstimate"%>
<%@page import="dbhelper.DBHelper"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	Common common = new Common();
	int total = 0;

	/* sessionの取得 */
	String employee_code = "";
	employee_code = (String) session.getAttribute("code");

	//特定の見積番号を取得
	String est_code = request.getParameter("code");

	//見積番号から詳細内容を取得
	DetailEstimate de = new DetailEstimate();
	ArrayList<HashMap<String, String>> array = new ArrayList<HashMap<String, String>>();
	HashMap<String, String> hash = new HashMap<String, String>();
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
<link href="css/estimateDetail.css" rel="stylesheet">


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
		<h2 id="title">見積書一覧</h2>
		<div id="main_area">
			<script>
				function actionChange() {
					document.getElementById('form').action = 'estimateEdit.jsp';
				}
			</script>
			<form action="./compOrderServlet" method="post">
				<ul id="right_top">
					<%
						hash = de.getESTSummary(est_code);
					%>
					<li>見積日：<%=hash.get("est_date")%>
					</li>
					<li>見積番号：<%=hash.get("est_code")%><input type="hidden"
						name="est_code" value="<%=hash.get("est_code")%>"></li>
				</ul>
				<h3>見積書</h3>

				<ul id="client">
					<li><%=hash.get("client_name")%><%=hash.get("tail")%><input
						type="hidden" name="client_code"
						value="<%=hash.get("client_code")%>"></li>
					<li><%=hash.get("post")%> <%=hash.get("position")%> <%=hash.get("person")%></li>
					<li>件名 : <%=hash.get("subject")%></li>
				</ul>
				<table class="table">
					<thead>
						<tr>
							<th></th>
							<th>商品名</th>
							<th>数量</th>
							<th>単位</th>
							<th>単価</th>
							<th>金額</th>
						</tr>
					</thead>
					<tbody>
						<%
							array = de.getESTContent(est_code);
							for (int a = 0; a < array.size(); a++) {
								HashMap<String, String> hashmap = array.get(a);
						%>
						<tr>
							<td></td>
							<td><%=hashmap.get("products_name")%><input type="hidden"
								name="products_code" value="<%=hashmap.get("products_code")%>"></td>
							<td><%=hashmap.get("quantity")%><input type="hidden"
								name="quantity" value="<%=hashmap.get("quantity")%>"></td>
							<td><%=hashmap.get("unit")%></td>
							<td>¥<%=common.punctuate(hashmap.get("sell_price"))%></td>
							<td>¥<%=common.punctuate(hashmap.get("sub_total"))%> <%
 	int sub = common.parseIntegerforString(hashmap.get("sub_total"));
 		total = total + sub;
 %><input type="hidden" name="sub_total"
								value="<%=hashmap.get("sub_total")%>"></td>
						</tr>
						<%
							}
						%>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>小計</td>
							<td>¥<%=common.punctuate(total)%></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>消費税</td>
							<td>¥<%=common.punctuate(hash.get("tax"))%></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>合計</td>
							<td>¥<%=common.punctuate(hash.get("total"))%><input
								type="hidden" name="total" value="<%=hash.get("total")%>"></td>
						</tr>
					</tbody>
				</table>
				<p id="remark">
					備考:
					<%=hash.get("remark")%><input type="hidden" name="remark"
						value="<%=hash.get("remark")%>">
				</p>
				<div id="btns">
					<%
						if (common.parseIntegerforString(hash.get("status")) == 1) {
					%>
					<button type="submit" class="btn btn-primary" id="order">受注に回す</button>
					<%
						} else if (common.parseIntegerforString(hash.get("status")) == 2) {
					%>
					<button type="submit" class="btn btn-primary" id="order"
						onClick="actionChange">編集</button>
					<%
						}
					%>
				</div>
			</form>
		</div>
	</div>

</body>

</html>
