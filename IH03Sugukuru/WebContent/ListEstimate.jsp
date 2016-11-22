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
<title>Bootstrap Sample</title>
<!-- BootstrapのCSS読み込み -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery読み込み -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- BootstrapのJS読み込み -->
<script src="js/bootstrap.min.js"></script>

<!-- OriginalのCSS読み込み -->
<link href="css/listEstimate.css" rel="stylesheet">
<link href="css/common.css" rel="stylesheet">
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
							<li><a href="ListEstimateServlet">見積書一覧</a></li>
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

		<div id="search_area">
			<form method="post" action="">
				<ul class="ul_style">
					<li>見積書番号:<input type="text" maxlength="14"
						placeholder="半角数字14桁">
					</li>
					<li>見積日付:</li>
					<li>取引先企業名:<select><option>----</option>
							<option>取引先1</option></select>
					</li>
				</ul>
				<ul class="ul_style" id="sub_ul">
					<li>見積金額:<input type="text" placeholder="半角数字" size="8">円~<input
						type="text" placeholder="半角数字" size="8">円
					</li>
					<li>ステータス:<select><option>-----</option>
							<option>承認済み</option>
							<option>未承認</option>
							<option>保留</option>
							<option>受注済み</option>
							<option>不使用</option></select>
					</li>
				</ul>
				<button type="submit" class="btn btn-primary" id="search_btn">検索</button>
			</form>
		</div>


		<div id="table_area">
			<p id="num_case">〇〇件/△△件中</p>
			
			<p id="list_page"><< < 1 > >></p>
			<hr>

			<table class="table">
				<thead>
					<tr>
						<th class="col-sm-0.5"></th>
						<th class="col-sm-1.5" id="center">見積書番号</th>
						<th class="col-sm-1.5" id="center">見積日</th>
						<th class="col-sm-3" id="center">取引先企業名</th>
						<th class="col-sm-1.5" id="center">金額</th>
						<th class="col-sm-1" id="center">ステータス</th>
						<th class="col-sm-3" id="center">備考</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td></td>
						<td>00000000000000</td>
						<td>2016-11-11</td>
						<td>HAL大阪</td>
						<td>¥680,000</td>
						<td>未承認</td>
						<td>与信限度額がオーバーしています</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>