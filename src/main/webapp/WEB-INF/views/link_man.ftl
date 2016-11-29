<!doctype html>
<html>
<head>
    <#include "include/common.header.ftl" >
    <script type="text/javascript" src="${ctx}/js/link.man.js"></script>
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
<table id="dg" title="联系人信息管理" style="width:700px;height:350px"
       toolbar="#toolbar" idField="id" rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
    <tr>
        <th field="id" width="50">编号</th>
        <th field="linkName" width="100" editor="{type:'validatebox',options:{required:true}}">客户姓名</th>
        <th field="sex" width="50" editor="{type:'combobox',
   			options:{
   				valueField:'id',
   				textField:'name',
   				data:[{id:'男',name:'男'},{id:'女',name:'女'}],
   				required:true,
   				editable:false,
   				panelHeight:'auto'
   		    }}">性别</th>
        <th field="zhiwei" width="100" editor="{type:'validatebox',options:{required:true}}">职位</th>
        <th field="officePhone" width="100" editor="{type:'validatebox',options:{required:true}}">办公电话</th>
        <th field="phone" width="100" editor="{type:'validatebox',options:{required:true}}">手机</th>
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