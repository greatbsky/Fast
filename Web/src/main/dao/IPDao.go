package dao
import (
	m "../models"
	// "fmt"
	"strconv"
	"time"
	// "encoding/json"
	mgo "github.com/globalsign/mgo"
	// "github.com/globalsign/mgo/bson"
)

func GetIPStats() string {

	const MONGODB_URL = "192.168.1.78:27017"
	//创建连接
	session, err := mgo.DialWithTimeout(MONGODB_URL, time.Second)
	if err != nil {
		panic(err)
	}

	defer session.Close()

	session.SetMode(mgo.Monotonic, true)
	c := session.DB("bigdb").C("logsstats")

	//查询多条数据 Find().All()
	var list []m.KeyVal
	err = c.Find(nil).All(&list)
	if err != nil {
		panic(err)
	}
	// json, _ := json.Marshal(list)
	// return string(json)
	result := `[ ['key', 'value'],`
	for i := 0; i < len(list); i++ {
		result += `['` + list[i].Key + `',` + strconv.Itoa(list[i].Val) + `]`
		if (i+1) != len(list) {
			result += `,`
		} else {
			result += `]`
		}
	}
	// fmt.Println(result)
	return result
}
