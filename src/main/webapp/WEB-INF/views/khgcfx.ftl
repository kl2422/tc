<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>客户构成分析</title>

		<script type="text/javascript" src="http://cdn.hcharts.cn/jquery/jquery-1.8.3.min.js"></script>

		<script type="text/javascript">
	$(function () {
		$.post("${ctx}/report/khgcfx", {}, function(data) {
			var categories = [];
			var datas = [];
			/*for(var i=0; i < data.length; i++) {
				var category = data[i].customerLevel;
				categories.push(category);
				var count = data[i].customerNum;
				datas.push(count);
			}*/
			
			for(var i in data) {
				var category = data[i].customerLevel;
				categories.push(category);
				var count = data[i].customerNum;
				datas.push(count);
			}
			
			console.log(categories);
			console.log(datas);
			drawColumn(categories, datas);
		});
	
		// var categories = ['大客户', '普通客户'];
		// var data = [40, 50];
	    // drawColumn(categories, data);
	});
	
	// 画图
	function drawColumn(categories, data) {
		 Highcharts.chart('container', {
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: '客户构成分析'
	        },
	        xAxis: {
	            categories: categories,
	            crosshair: true
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: '客户数量 (个)'
	            }
	        },
	        tooltip: {
	            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
	            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
	                '<td style="padding:0"><b>{point.y} 个</b></td></tr>',
	            footerFormat: '</table>',
	            shared: true,
	            useHTML: true
	        },
	        plotOptions: {
	            column: {
	                pointPadding: 0.2,
	                borderWidth: 0
	            }
	        },
	        series: [{
	            name: '客户',
	            data: data
	
	        }]
	    });
	}
		</script>
	</head>
	<body>
<script src="http://cdn.hcharts.cn/highcharts/highcharts.js"></script>
<script src="http://cdn.hcharts.cn/highcharts/modules/exporting.js"></script>

<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>

	</body>
</html>
