function searchSaleChance() {
    $("#dg").datagrid('load',{
        "customerName":$("#s_customerName").val(),
        "overview":$("#s_overview").val(),
        "devResult":$("#s_devResult").combobox("getValue")
    });
}

function formatDevResult(val,row) {
    if(val==0) {
        return "未开发";
    } else if (val == 1) {
        return "开发中";
    } else if (val == 2) {
        return "开发成功";
    }else if(val == 3) {
        return "开发失败";
    }
}

// 格式化操作
function formatAction(val, row) {
   var ahtml = "";
   var devResult = row.devResult; // 开发状态
   var id = row.id; // 营销机会的主键
   if (devResult == 0 || devResult == 1) { // 未开发或者开发中
	   ahtml = "<a href='javascript:openDevPlanTab("+ id +", 0)' >开发</a>"
   } else {
	   ahtml = "<a href='javascript:openDevPlanTab("+ id +", 1)' >查看详情</a>"
   }
   return ahtml;
}

// 打开详情
function openDevPlanTab(id, show) {
	var title = '';
	if (show == 0) { // 显示一排按钮即开发计划项
		title = '客户开发计划项管理';
	} else { // 查看这个详情
		title = '查看客户开发计划项';
	}
	var url = 'sale_chance/detail?saleChanceId=' + id + '&show=' + show;
	window.parent.refreshTab(title, url, 'icon-khkfjh');
}