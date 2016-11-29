$(function() {
    var cusId = $("#cusId").val();
    $("#dg").edatagrid({
        url:ctx + '/contact/list?cusId=' + cusId,
        saveUrl:ctx + '/contact/add_update?cusId='+ cusId,
        updateUrl:ctx + '/contact/add_update',
        destroyUrl:ctx + '/contact/delete',
        pagination: true,
        pageSize: 10

    });
});