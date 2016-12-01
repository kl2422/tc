<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Highcharts Example</title>

		<script type="text/javascript" src="http://cdn.hcharts.cn/jquery/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
			$(function () {
				$.post("${ctx}/report/khfwfx", {}, function(result) {
					var datas = [];
			        for(var i in result) {
			        	var serveType = result[i].serveType;
			        	var num = result[i].num;
			        	var data = null;
			        	if ('咨询' === serveType) {
			        		data = { name: serveType, y: num, sliced: true, selected: true};
			        	} else {
			        		data = [serveType, num];
			        	}
			        	datas.push(data);
			        }
			        console.log(datas);
			    	draw3D(datas);
				});
				/*
			    var data = [
			                ['投诉', 45.0],
			                ['建议', 26.8],
			                {
			                    name: '咨询',
			                    y: 12.8,
			                    sliced: true,
			                    selected: true
			                }
			            ];
			    draw3D(data);*/
			    
			});
			
			function draw3D(data) {
				Highcharts.chart('container', {
			        chart: {
			            type: 'pie',
			            options3d: {
			                enabled: true,
			                alpha: 45,
			                beta: 0
			            }
			        },
			        title: {
			            text: '客户服务分析'
			        },
			        tooltip: {
						headerFormat: '<span style="font-size: 10px"></span>',
			            pointFormat: '{point.name}: <b>{point.percentage:.1f}%</b>'
			        },
			        plotOptions: {
			            pie: {
			                allowPointSelect: true,
			                cursor: 'pointer',
			                depth: 35,
			                dataLabels: {
			                    enabled: true,
			                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
			                }
			            }
			        },
			        series: [{
			            type: 'pie',
			            name: '服务类型',
			            data: data
			        }]
			    });
			}
			
		</script>
	</head>
	<body>

<script src="http://cdn.hcharts.cn/highcharts/highcharts.js"></script>
<script src="http://cdn.hcharts.cn/highcharts/highcharts-3d.js"></script>
<script src="http://cdn.hcharts.cn/highcharts/modules/exporting.js"></script>

<div id="container" style="height: 400px"></div>
	</body>
</html>
