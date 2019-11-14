<head>
    <title>test.ftl</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3,keyword4,keyword5">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

  </head>
  
  <body>
  <h1>
  <table width="400" border="1" cellspacing="0" cellpadding="0"> 
		<tr>
			<th>Test Group/Test case</th>
			<th>Count</th>
			<th>Pass</th>
			<th>Fail</th>
			<th>Error</th>
		</tr>
		<!-- <tr>
			<td></td>
			<td>${casesize}</td>
			<td>${passedList}</td>
			<td>${failedList}</td>
			<td>${failcasesize}</td>
		</tr> -->
		<#list passed as pass>
        <tr>
            <td>${pass_index}</td>
            <td>${pass.getName()}</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        </#list>			
	</table>
	
	
  </body>