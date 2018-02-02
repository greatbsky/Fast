package com.bigdata.dstreams.nginx;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import com.bigdata.base.utils.GlobalUtil;

/**
 * 
测试数据格式举例：
{"remoteAddr": "123.125.71.14", "timeLocal": "01/Feb/2018:11:07:58 +0000", "timeSec: 1517483278.974,requestTime: 0.017,bodyBytes: 124,host": "finance.supergenius.cn", "request": "GET /geniusfocus/1533 HTTP/1.1", "status: 404,requestBody": "-", "httpReferer": "-", "httpUserAgent": "Mozilla/5.0 (Linux;u;Android 4.2.2;zh-cn;) AppleWebKit/534.46 (KHTML,like Gecko) Version/5.1 Mobile Safari/10600.6.3 (compatible; Baiduspider/2.0; +http://www.baidu.com/search/spider.html)", "httpForward": "-", "cookie": "-"}
{"remoteAddr": "218.247.144.122", "timeLocal": "01/Feb/2018:11:08:41 +0000", "timeSec: 1517483321.931,requestTime: 0.040,bodyBytes: 8033,host": "user.supergenius.cn", "request": "GET /userrule HTTP/1.1", "status: 200,requestBody": "-", "httpReferer": "http://192.168.1.5:99/home2017/%E7%BC%B4%E8%B4%B9%E7%A1%AE%E5%AE%9A.html", "httpUserAgent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36", "httpForward": "-", "cookie": "visitors=bb42b2a5185b4811bcf47cc3eede7516; bc0a50bf027e4605ab592f4b7a87be80=finance; 9aa819fd989941c48cff8d90ebe3a920=finance; 06be1aa1adbe4d87a612ac86d36fffbb=finance; d52a108dbc0a46e99f32a022b1f3d601=finance; 2b543729eda642219c2be8a59228a714=finance; 5f855f6c83e24ce28f0d3c0b6d4b18ea=finance; e217a12c7aaa4bb1b33ce153ebd95a1d=finance; 5863cb085a174e9e877f0dbf3a0db9ec=finance; dd10245266394d698b2b795fa1336290=finance; 369c2a70dadb4f41b870d3fdfee81026=finance; 0b268e02f1984c3084b1c6a11df1839e=finance; 3bfbbd27663d4d6a9e0402917aca3f59=finance; 3ba4ad2e22184c8d808eeb2c2fabbd58=finance; edf7abe4d2624600a9c3cbc53cb8f8b9=finance; sid=baf59b3ee78030702cea832b0569b1dc; 2bf23f04eacd46c3aaca213009f65681=finance; 59ffeaacd08c41409781e5f0e2d7dcf7=finance; a12b5e95625740f4a6a895a08b2bd0bd=finance; redirect=http://startup.supergenius.cn/my/center; 9bc50d91fc224e7fbddbdad7bdcdafa1=finance; 47278cede4914d4790369c7956359cf7=finance; Hm_lvt_5e9becfb1e4b1571842ead2b38e3ab11=1517448376,1517458964,1517459002,1517477667; e0315c4740ff40319b8abff0cfd5e167=finance; Hm_lpvt_5e9becfb1e4b1571842ead2b38e3ab11=1517481958; cc59e9593cb74c0db3218d5c52bbe242=finance; 77a36eb1a2f449e0b2aa869ff25c8416=finance; JSESSIONID=1BE362425B70A343DE09C4E2F62A4606"}
{"remoteAddr": "218.247.144.122", "timeLocal": "01/Feb/2018:11:08:57 +0000", "timeSec: 1517483337.938,requestTime: 0.024,bodyBytes: 12,host": "account.supergenius.cn", "request": "GET /api/7fb943a08b2b45e9911966fcf7d228bd/recharge/query/372822c02bbd11e7bae9c73a7851e558?site=0 HTTP/1.1", "status: 200,requestBody": "-", "httpReferer": "-", "httpUserAgent": "-", "httpForward": "-", "cookie": "-"}
{"remoteAddr": "106.11.156.138", "timeLocal": "01/Feb/2018:11:09:23 +0000", "timeSec: 1517483363.173,requestTime: 0.157,bodyBytes: 9642,host": "moral.supergenius.cn", "request": "GET /forum/view/5c2ac1c48ccb4a268bda2fe839994be7 HTTP/1.1", "status: 200,requestBody": "-", "httpReferer": "-", "httpUserAgent": "YisouSpider", "httpForward": "-", "cookie": "-"}
{"remoteAddr": "207.46.13.111", "timeLocal": "01/Feb/2018:11:09:34 +0000", "timeSec: 1517483374.338,requestTime: 0.058,bodyBytes: 7700,host": "moral.supergenius.cn", "request": "GET / HTTP/1.1", "status: 200,requestBody": "-", "httpReferer": "-", "httpUserAgent": "Mozilla/5.0 (compatible; bingbot/2.0; +http://www.bing.com/bingbot.htm)", "httpForward": "-", "cookie": "-"}
{"remoteAddr": "222.209.251.137", "timeLocal": "01/Feb/2018:11:09:50 +0000", "timeSec: 1517483390.781,requestTime: 0.000,bodyBytes: 12250,host": "sv2data.supergenius.cn", "request": "GET /imgs/webdata/aicontribute/180104143719139.jpg HTTP/1.1", "status: 200,requestBody": "-", "httpReferer": "-", "httpUserAgent": "Mozilla/5.0 (Linux; Android 7.0; STF-TL10 Build/HUAWEISTF-TL10; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/043808 Mobile Safari/537.36 V1_AND_SQ_7.3.5_776_YYB_D QQ/7.3.5.3385 NetType/WIFI WebP/0.3.0 Pixel/1080", "httpForward": "-", "cookie": "sid=15173883877983f6lin; 84788d484291429fae63118779c30261=finance"}
{"remoteAddr": "123.125.71.107", "timeLocal": "01/Feb/2018:11:10:06 +0000", "timeSec: 1517483406.169,requestTime: 0.015,bodyBytes: 124,host": "finance.supergenius.cn", "request": "GET /corporations/254 HTTP/1.1", "status: 404,requestBody": "-", "httpReferer": "-", "httpUserAgent": "Mozilla/5.0 (Linux;u;Android 4.2.2;zh-cn;) AppleWebKit/534.46 (KHTML,like Gecko) Version/5.1 Mobile Safari/10600.6.3 (compatible; Baiduspider/2.0; +http://www.baidu.com/search/spider.html)", "httpForward": "-", "cookie": "-"}
{"remoteAddr": "101.200.213.192", "timeLocal": "01/Feb/2018:11:11:22 +0000", "timeSec: 1517483482.236,requestTime: 0.065,bodyBytes: 45115,host": "finance.supergenius.cn", "request": "GET /article/4/1922 HTTP/1.1", "status: 200,requestBody": "-", "httpReferer": "-", "httpUserAgent": "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)", "httpForward": "-", "cookie": "-"}
{"remoteAddr": "101.200.206.163", "timeLocal": "01/Feb/2018:11:11:23 +0000", "timeSec: 1517483483.514,requestTime: 0.059,bodyBytes: 45115,host": "finance.supergenius.cn", "request": "GET /article/4/1922 HTTP/1.1", "status: 200,requestBody": "-", "httpReferer": "-", "httpUserAgent": "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)", "httpForward": "-", "cookie": "-"}
{"remoteAddr": "220.181.108.145", "timeLocal": "01/Feb/2018:11:11:39 +0000", "timeSec: 1517483499.631,requestTime: 0.013,bodyBytes: 124,host": "finance.supergenius.cn", "request": "GET /debate/article/06ce352711164eac89fc08fb4d8a7bdf?doid=4&dperioid HTTP/1.1", "status: 404,requestBody": "-", "httpReferer": "-", "httpUserAgent": "Mozilla/5.0 (compatible; Baiduspider/2.0; +http://www.baidu.com/search/spider.html)", "httpForward": "-", "cookie": "-"}

 *
 */
public class NginxLog implements Serializable {

	private String uid;
	private String remoteAddr;
	private String timeLocal;
	private Double timeSec;
	private Double requestTime;
	private Integer bodyBytes;
	private String host;
	private String request;
	private Integer status;
	private String requestBody;
	private String httpReferer;
	private String httpUserAgent;
	private String httpForward;
	private String cookie;
	
	public String getUid() {
		if (StringUtils.isEmpty(this.uid)) {
			this.uid = GlobalUtil.getUUID();
			return this.uid;
		}
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getRemoteAddr() {
		return remoteAddr;
	}
	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}
	public String getTimeLocal() {
		return timeLocal;
	}
	public void setTimeLocal(String timeLocal) {
		this.timeLocal = timeLocal;
	}
	public Double getTimeSec() {
		return timeSec;
	}
	public void setTimeSec(Double timeSec) {
		this.timeSec = timeSec;
	}
	public Double getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(Double requestTime) {
		this.requestTime = requestTime;
	}
	public Integer getBodyBytes() {
		return bodyBytes;
	}
	public void setBodyBytes(Integer bodyBytes) {
		this.bodyBytes = bodyBytes;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getRequestBody() {
		return requestBody;
	}
	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}
	public String getHttpReferer() {
		return httpReferer;
	}
	public void setHttpReferer(String httpReferer) {
		this.httpReferer = httpReferer;
	}
	public String getHttpUserAgent() {
		return httpUserAgent;
	}
	public void setHttpUserAgent(String httpUserAgent) {
		this.httpUserAgent = httpUserAgent;
	}
	public String getHttpForward() {
		return httpForward;
	}
	public void setHttpForward(String httpForward) {
		this.httpForward = httpForward;
	}
	public String getCookie() {
		return cookie;
	}
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

}
