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

<link href="css/createEstimate.css" rel="stylesheet">
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
		<h2 id="title">見積書作成</h2>

		<div id="search_area">
			<form method="post" action="">
				<ul id="ul_list">
					<li>見積書番号</li>
					<li><input type="text" class="em_size" value=""
						placeholder="半角数字14桁" maxlength="14"></li>

					<li>取引先 <a href="">新規取引先の登録</a></li>
					<li><select>
							<option>取引先1</option>
							<option>aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa</option>
					</select> <select>
							<option>御中</option>
							<option>様</option>
					</select></li>

					<li>取引部署</li>
					<li><input type="text" class="em_size" value=""></li>

					<li>役職</li>
					<li><input type="text" class="em_size" value=""></li>

					<li>担当者名</li>
					<li><input type="text" class="em_size" value=""></li>

					<li>件名</li>
					<li><input type="text" size="50" placeholder="例）〇〇会社様文房具お見積もり"></li>
					
				</ul>
				<hr>

				<table class="table" id="pro_table">
					<thead>
						<tr>
							<th class="col-xs-1"></th>
							<th class="col-xs-1">商品コード</th>
							<th class="col-xs-5">商品名</th>
							<th class="col-xs-1">数量</th>
							<th class="col-xs-1">単位</th>
							<th class="col-xs-1">単価</th>
							<th class="col-xs-2">金額</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="number">1</td>
							<td><input type="text" size="20" value=""></td>
							<td></td>
							<td><input type="text" size="10" class="input_right"
								value=""></td>
							<td><select>
									<option>個別</option>
									<option>ダース</option>
									<!-- 12*1 = 1ダース -->
									<option>グロス</option>
									<!-- 12ダース*1 = 1グロス -->
									<option>グレートグロス</option>
									<!-- 12グロス*1 = 1グレートグロス -->
									<option>スモールグロス</option>
									<!-- 12*10 = 120 -->
							</select></td>
							<td></td>
							<td class="amount input_right"></td>
						</tr>
					</tbody>
				</table>

				<div id="add">
					<button id="add_btn" onclick="#">列の追加</button>
				</div>

				<hr>

				<div>
					<ul class="sub_ul">
						<li>備考</li>
						<li><textarea placeholder="備考入力欄"></textarea></li>
					</ul>
				</div>

				<div>
					<table id="amount_table">
						<tr>
							<th class="col-xs-3">小計:</th>
							<td class="col-xs-2"></td>
						</tr>
						<tr>
							<th class="col-xs-3">消費税:</th>
							<td class="col-xs-2"></td>
						</tr>
						<tr>
							<th class="col-xs-3">見積金額:</th>
							<td class="col-xs-2"></td>
						</tr>
					</table>
				</div>




				<button type="submit" class="btn btn-primary" id="create">見積書の保存</button>
			</form>
		</div>
	</div>
</body>
</html>