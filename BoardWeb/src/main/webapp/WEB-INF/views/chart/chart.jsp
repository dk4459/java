<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
   	  let charJson = '${list}';
   	  let chartInfo = JSON.parse(charJson)
   	  console.log(chartInfo)
      let infoAry = [];
      infoAry.push(['부서명','인원'])
      for(info of chartInfo){
    	  infoAry.push([info.DEPARTMENT_NAME,info.CNT])
      }
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      console.log(infoAry);
      function drawChart() {
        var data = google.visualization.arrayToDataTable(infoAry);
        var options = {
          title: '부서별 인원현황',
          pieHole: 0.4,
        };

        var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
        chart.draw(data,options);
      }
    </script>
  </head>
  <body>
    <div id="donutchart" style="width: 900px; height: 500px;"></div>
  </body>
</html>