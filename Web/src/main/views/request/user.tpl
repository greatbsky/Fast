<html>
{{template "basetpl/head.tpl" .}}
 <body data-feedly-mini="yes">
       <script src="/js/libs3/echarts-4.0.2.js"></script>
       {{template "basetpl/nav.tpl" .}}
  <div id="explore-container" style="margin:10px">
   <div class="chart-list-panel">
    <h3 class="chart-type-head" id="chart-type-line">查询用户操作详情</h3>
    <div class="row" id="chart-row-line">
        <img src="https://raw.githubusercontent.com/greatbsky/Fast/fast/fast.jpg" style="height:60%" />
    </div>
   </div>
  </div>
  <script type="text/javascript">
    document.getElementById('nav-request').className = 'active';
  </script>
  {{template "basetpl/foot.tpl" .}}
 </body>
</html>
