<head>
<title>test.ftl</title>

<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

</head>

<body>
	<div style="font-size: 12px">
		<p>Time ${(date?string("yyyy-MM-dd HH:mm:ss"))!}</p>
		<br />case-Number:${casesize},FAIL-Number:${failcasesize} <br /> <br />
		<div>
			<table width="100%" border="1" cellspacing="0"
				style="font-size: 12px; font-family: 'MS Serif', 'New York', serif;">

				<!-- 失败case列表-->
				<tr height="40">
					<th colspan="4" align="left" nowrap bgcolor="#66CC33" scope="col"><div
							style="color: red;">The following case execution failed：</div></th>
				</tr>
				<tr bgcolor="#FFCC66" height="35">
					<th width="8%" nowrap scope="col">num</th>
					<th width="15%" scope="col">test method</th>
					<th width="45%" nowrap scope="col">case title</th>
					<th nowrap scope="col">Test conclusion</th>
				</tr>

				<#list failedList as case>
				<tr>
					<td align="center">${case_index+1}</td>
					<td>${case.getMethod()}</td>
					<td>${case.getAttribute("name")}</td>
					<td>
						<div style="color: red;">fail</div>
					</td>
				</tr>
				</#list>

				<!--成功case列表-->
				<tr height="40">
					<th colspan="4" align="left" nowrap bgcolor="#66CC33" scope="col">The
						following case execution passed</th>
				</tr>
				<tr bgcolor="#FFCC66" height="35">
					<th width="8%" nowrap scope="col">num</th>
					<th width="15%" scope="col">test method</th>
					<th width="45%" nowrap scope="col">case title</th>
					<th nowrap scope="col">Test conclusion</th>
				</tr>

				<#list passedList as case>
				<tr>
					<td align="center">${case_index+1}</td>
					<td>${case.getMethod()}</td>
					<td>${case.getAttribute("name")}</td>
					<td>PASS</td>
				</tr>
				</#list>

			</table>
		</div>
</body>