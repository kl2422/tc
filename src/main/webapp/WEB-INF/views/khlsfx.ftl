<!doctype html>
<html>
<head>
    <#include "include/common.header.ftl" >
    <script type="text/javascript" src="${ctx}/js/report.js"></script>
</head>
<body style="margin: 1px">
 <table id="dg" title="客户流失分析" class="easyui-datagrid"
   fitColumns="true" pagination="true" rownumbers="true"
   url="${ctx}/customer_loss/list?state=1" fit="true" toolbar="#tb">
   <thead>
   	<tr>
   		<th field="cb" checkbox="true" align="center"></th>
   		<th field="id" width="50" align="center">编号</th>
   		<th field="cusNo" width="50" align="center" hidden="true">客户编号</th>
   		<th field="cusName" width="100" align="center">客户名称</th>
   		<th field="cusManager" width="100" align="center">客户经理</th>
   		<th field="lastOrderTime" width="100" align="center">上次下单日期</th>
   		<th field="confirmLossTime" width="100" align="center">确认流失日期</th>
   		<th field="state" width="80" align="center" hidden="true">客户状态</th>
   		<th field="lossReason" width="200" align="center">流失原因</th>
   	</tr>
   </thead>
 </table>
 <div id="tb">
 	<div>
 		
 	</div>
 	<div>
 		&nbsp;客户名称：&nbsp;<input type="text" id="s_cusName" size="20" onkeydown="if(event.keyCode==13) searchCustomerLoss()"/>
 		&nbsp;客户经理：&nbsp;<input type="text" id="s_cusManager" size="20" onkeydown="if(event.keyCode==13) searchCustomerLoss()"/>
 		<a href="javascript:searchCustomerLoss()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
 	</div>
 </div>
 
</body>
</html>