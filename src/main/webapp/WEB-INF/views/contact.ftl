<!doctype html>
<html>
<head>
<#include "include/common.header.ftl" >
    <script type="text/javascript" src="${ctx}/js/contact.js"></script>
</head>
<body style="margin: 15px">
<input type="hidden" id="cusId" value="${customer.id?c}" />
<div id="p" class="easyui-panel" title="客户基本信息" style="width: 700px;height: 100px;padding: 10px">
    <table cellspacing="8px">
        <tr>
            <td>客户编号：</td>
            <td><input type="text" id="khno" name="khno" readonly="readonly"  value="${customer.customerNo?if_exists}" /></td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td>客户名称</td>
            <td><input type="text" id="name" name="name" readonly="readonly" value="${customer.name?if_exists}" /></td>
        </tr>
    </table>
</div>

<br/>
<table id="dg" title="交往记录信息管理" style="width:700px;height:350px"
       toolbar="#toolbar" idField="id" rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
    <tr>
        <th field="id" width="50">编号</th>
        <th field="contactTime" width="100" editor="{type:'datetimebox',options:{required:true}}">交往时间</th>
        <th field="address" width="200" editor="{type:'validatebox',options:{required:true}}">交往地址</th>
        <th field="overview" width="300" editor="{type:'validatebox',options:{required:true}}">概要</th>
    </tr>
    </thead>
</table>

<div id="toolbar">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="javascript:$('#dg').edatagrid('addRow')">添加</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="javascript:$('#dg').edatagrid('destroyRow')">删除</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="javascript:$('#dg').edatagrid('saveRow');$('#dg').edatagrid('reload')">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-undo" plain="true" onclick="javascript:$('#dg').edatagrid('cancelRow')">撤销行</a>
</div>
</body>
</html>