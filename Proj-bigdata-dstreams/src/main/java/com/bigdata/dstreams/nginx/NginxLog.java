package com.bigdata.dstreams.nginx;

import java.io.Serializable;

public class NginxLog implements Serializable {

	private static final long serialVersionUID = 6459007373966210043L;

	private String remoteAddr;
	private String timeLocal;
	private long timeSec;
	private int requestTime;
	private int bodyBytes;
	private String host;
	private String request;
	private int status;
	private String requestBody;
	private String httpReferer;
	private String httpUserAgent;
	private String httpForward;
	private String cookie;
	
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
	public long getTimeSec() {
		return timeSec;
	}
	public void setTimeSec(long timeSec) {
		this.timeSec = timeSec;
	}
	public int getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(int requestTime) {
		this.requestTime = requestTime;
	}
	public int getBodyBytes() {
		return bodyBytes;
	}
	public void setBodyBytes(int bodyBytes) {
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
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
