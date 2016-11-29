$(function() {
	var cusId = $("#cusId").val();
	// 动态表格的数据展示
    $("#dg").edatagrid({
        url: ctx + '/link_man/list?cusId=' + cusId,
        saveUrl: ctx + '/link_man/add_update?cusId='+ cusId,
        updateUrl: ctx + '/link_man/add_update',
        destroyUrl: ctx + '/link_man/delete',
        pagination: true,
        pageSize: 10

    });
});