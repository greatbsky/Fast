package main

import (
	"fmt"
	"time"

	mgo "github.com/globalsign/mgo"
	"github.com/globalsign/mgo/bson"
)

const (
	MONGODB_URL = "192.168.1.78:27017"
)

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

func main() {
	//创建连接
	session, err := mgo.DialWithTimeout(MONGODB_URL, time.Second)
	if err != nil {
		panic(err)
	}

	defer session.Close()

	session.SetMode(mgo.Monotonic, true)
	c := session.DB("bigdb").C("logs")

	//查询多条数据 Find().All()
	var list []Log
	err = c.Find(bson.M{"status": 404}).All(&list)
	if err != nil {
		panic(err)
	}
	for i := 0; i < len(list); i++ {
		fmt.Println("Request ", list[i].Request)
	}
	fmt.Println(c.Count())

}
