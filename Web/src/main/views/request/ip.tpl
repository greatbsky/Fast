<html>
 <head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <link rel="stylesheet" type="text/css" href="/files/vendors/bootstrap/css/bootstrap.css" />
  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries-->
  <!--[if lt IE 9]><script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script><script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
  <link rel="stylesheet" type="text/css" href="/files/stylesheets/main.css" />
  <title>千里眼Fast！—— Five-hundred-meter Aperture Spherical radio Telescope！</title>
  <script src="/js/libs3/echarts-4.0.2.js"></script>
 </head>
 <body data-feedly-mini="yes">
  <nav class="navbar navbar-default navbar-fixed-top">
   <div class="container-fluid">
    <div class="navbar-header">
     <button type="button" data-toggle="collapse" data-target="#navbar-collapse" aria-expanded="false" class="navbar-toggle collapsed"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
     <a href="#" class="navbar-brand"><img src="/files/images/logo.png" alt="echarts logo" class="navbar-logo" /></a>
    </div>
    <div id="navbar-collapse" class="collapse navbar-collapse">
     <ul class="nav navbar-nav navbar-left">
      <li id="nav-index"><a href="/">首页</a></li>
      <li id="nav-request" class="dropdown"><a href="#" data-toggle="dropdown" class="dropdown-toggle" aria-expanded="false">请求分析<b class="caret"></b></a>
       <ul class="dropdown-menu">
        <li><a href="/request/ip">IP来源</a></li>
        <li><a href="/request/time">请求时间</a></li>
        <li><a href="/request/hot">请求热度</a></li>
       </ul></li>
      <li id="nav-exception" class="dropdown"><a href="#" data-toggle="dropdown" class="dropdown-toggle">异常监控<b class="caret"></b></a>
       <ul class="dropdown-menu">
        <li><a href="/exception/latest">最新异常</a></li>
        <li><a href="/exception/stats">异常统计</a></li>
       </ul></li>
      <li id="nav-about"><a href="#" data-toggle="dropdown" class="dropdown-toggle">关于<b class="caret"></b></a>
       <ul class="dropdown-menu">
        <li><a href="#">关于我们</a></li>
        <li><a href="#LICENSE">版权声明</a></li>
       </ul></li>
     </ul>
     <ul class="nav navbar-nav navbar-right">
      <li id="nav-2" class="0"><a href="#">v1.0</a></li>
      <li id="nav-homeen"><a href="#">LogOff</a></li>
     </ul>
    </div>
   </div>
  </nav>
  <div id="explore-container" style="margin:10px">
   <div class="chart-list-panel">
    <h3 class="chart-type-head" id="chart-type-line">IP来源</h3>
    <div class="row" id="chart-row-line">
        <div id="main" style="width: 600px;height:400px;"></div>

        <script type="text/javascript">
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('main'));

            // 指定图表的配置项和数据
            // var option = {
            //     title: {
            //         text: 'ECharts 入门示例'
            //     },
            //     tooltip: {},
            //     legend: {
            //         data:['销量']
            //     },
            //     xAxis: {
            //         data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
            //     },
            //     yAxis: {},
            //     series: [{
            //         name: '销量',
            //         type: 'bar',
            //         data: [5, 20, 36, 10, 10, 20]
            //     }]
            // };


            var option = {

                dataset: {source: []},
                // dataset: {
                //     source: [
                //         ['score', 'amount', 'product'],
                //         [89.3, 58212, 'Matcha Latte'],
                //         [57.1, 78254, 'Milk Tea'],
                //         [74.4, 41032, 'Cheese Cocoa'],
                //         [50.1, 12755, 'Cheese Brownie'],
                //         [89.7, 20145, 'Matcha Cocoa'],
                //         [68.1, 79146, 'Tea'],
                //         [19.6, 91852, 'Orange Juice'],
                //         [10.6, 101852, 'Lemon Juice'],
                //         [32.7, 20112, 'Walnut Brownie']
                //     ]
                // },
                grid: {containLabel: true},
                xAxis: {type: 'category'},
                yAxis: {},
                series: [
                    {
                        type: 'bar',
                        encode: {
                            x: 'key',
                            y: 'value'
                        }
                    }
                ]
            };
            option.dataset.source = eval({{.data}})

            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        </script>
    </div>
   </div>
  </div>
  <script type="text/javascript" src="/files/vendors/jquery/jquery.js"></script>
  <script type="text/javascript" src="/files/vendors/bootstrap/js/bootstrap.js"></script>
  <script type="text/javascript" src="/files/vendors/lodash.js"></script>
  <script type="text/javascript" src="/files/vendors/waypoint.js"></script>
  <script type="text/javascript" src="/files/vendors/jquery.lazyload.min.js"></script>
  <script type="text/javascript">
    document.getElementById('nav-request').className = 'active';
  </script>
 </body>
</html>
