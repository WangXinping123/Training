<html>
<head>
  <title>TestResult</title>
</head>
<body>
  <h1>Result:</h1>
  <p>Time ${(date?string("yyyy-MM-dd HH:mm:ss"))!} </p>
  	<table style="text-align:center" width="400" border="1" cellspacing="0" cellpadding="0"> 
		<tr>
			<td>Method</td>
			<td>case title</td>
			<td>pass/fail</td>
		</tr>
		<#list failname as f>
		<tr style="background-color:orange;">
			<td>
				${f} 
			</td>
			<td></td>
			<td>fail</td>
		</tr>
		</#list>
		<#list passname as p>
		<tr style="background-color:#63cf62;">
			<td>
				${p}
			</td>
			<td></td>
			<td>pass</td>
		</tr>
		</#list>
		
		<tr>
			<td>failedList</td>
			<td>passedList</td>
			<td>casesize</td>
		</tr>
		<tr>
			<td>${failedList}</td>
			<td>${passedList}</td>
			<td>${casesize}</td> 
		</tr>

	</table>
	
 
	
</body>
</html>