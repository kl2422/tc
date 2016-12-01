<!doctype html>
<html>
<head>
<#include "include/common.header.ftl" >
    <script type="text/javascript" src="${ctx}/js/report.js"></script>
<body style="margin: 1px">
<table id="dg" title="客户贡献分析" class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="true"
       url="${ctx}/report/fhgxfx" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="name" width="300" align="center">客户名称</th>
        <th field="gx" width="100" align="center">订单总金额(元)</th>
    </tr>
    </thead>
</table>
<div id="tb">
    <div>
        &nbsp;客户名称：&nbsp;<input type="text" id="s_name" size="20" onkeydown="if(event.keyCode==13) searchFhgxfx()"/>
        <a href="javascript:searchFhgxfx()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
    </div>
</div>

</body>
</html>