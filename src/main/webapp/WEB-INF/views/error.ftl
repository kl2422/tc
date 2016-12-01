<html>
<head>

    <#include "include/common.header.ftl" >
    
    <script>
        $(document).ready(function() {
            alert("请登录。。。");
            setInterval(function() {
            	if ("${uri}" == "/main") {
	        		window.location.href = "${ctx}/index";
	        	} else {
	        		window.parent.location.href = "${ctx}/index";
	        	}             
            }, 1000);
        });
    </script>
</head>
<body>
</body>
</html>