$(document).ready(function() {
	var createMan = $.cookie("userName");
	$("#createPeople").val(createMan);
});

// 保存
function saveCustomerService () {
	$("#fm").form("submit",{
        url : ctx + "/customer_serve/add_update",
        onSubmit: function(){
            return $(this).form("validate");
        },
        success:function(result) {
            var result = JSON.parse(result);
            if(result.resultCode == 1) {
                $.messager.alert("系统提示","保存成功！");
                resetValue();
            } else {
                $.messager.alert("系统提示","保存失败！");
                return;
            }
        }
    });
}

function resetValue() {
	$("#serveType").combobox("setValue", "");
	$("#customer").val("");
	$("#overview").val("");
	$("#serviceRequest").val("");
}