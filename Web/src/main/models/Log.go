package models

type Log struct {
	RemoteAddr  string `bson:"remoteAddr"`
	TimeLocal string `bson:"timeLocal"`
	TimeSec string `bson:"timeSec"`
	RequestTime string `bson:"requestTime"`
	BodyBytes string `bson:"bodyBytes"`
	Host string `bson:"host"`
	Request string `bson:"request"`
	Status string `bson:"status"`
	requestBody string `bson:"requestBody"`
	HttpReferer string `bson:"httpReferer"`
	HttpUserAgent string `bson:"httpUserAgent"`
	HttpForward string `bson:"httpForward"`
	Cookie string `bson:"cookie"`
}
