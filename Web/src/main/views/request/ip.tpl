<html>
{{template "basetpl/head.tpl" .}}
 <body data-feedly-mini="yes">
       <script src="/js/libs3/echarts-4.0.2.js"></script>
       {{template "basetpl/nav.tpl" .}}
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
  <script type="text/javascript">
    document.getElementById('nav-request').className = 'active';
  </script>
  {{template "basetpl/foot.tpl" .}}
 </body>
</html>
