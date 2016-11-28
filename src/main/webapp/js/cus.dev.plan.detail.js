$(function() {
    var saleChanceId = $("#saleChanceId").val();
    $("#dg").edatagrid({
        url: ctx + '/cus_dev_plan/list?saleChanceId=' + saleChanceId,
        saveUrl: ctx + '/cus_dev_plan/add_update?saleChanceId=' + saleChanceId,
        updateUrl: ctx + '/cus_dev_plan/add_update?saleChanceId=' + saleChanceId,
        destroyUrl: ctx + '/cus_dev_plan/delete'
    });
});

function formatPlanDate(val, row) {
    if (val == null) {
        return '';
    }
    return new Date(val).format('yyyy-MM-dd');

}

function updateSaleChanceDevResult(devResult) {
    var param = {};
    param.id = $("#saleChanceId").val();
    param.devResult = devResult;
    
    $.post("update_devresult", param, function(result) {
        if(result.resultCode == 1) {
           $.messager.alert("系统提示", "操作成功！");
           // 刷新客户开发计划选项卡
           window.parent.refreshTab('客户开发计划', ctx + '/sale_chance/index?state=1', 'icon-khkfjh');
           // 关闭当前的选项卡
           window.parent.closeTab("客户开发计划项管理");
        } else {
            $.messager.alert("系统提示","操作失败！");
        }
    });
}

// 保存
function saveData () {
	var saleChanceId = $("#saleChanceId").val();
	saveUrl: ctx + '/cus_dev_plan/add_update?saleChanceId=' + saleChanceId;
	var data = {};
	$.post(url, data, function() {
		$('#dg').datagrid('acceptChanges');
		$('#dg').edatagrid('reload');
	});
	
//	$('#dg').edatagrid('saveRow');
//	setTimeout(function() {
//		$('#dg').datagrid('acceptChanges');
//		$('#dg').edatagrid('reload');
//	}, 1000);
}
