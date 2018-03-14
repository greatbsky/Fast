package dao
import (
	m "../models"
	// "fmt"
	"time"
	// "encoding/json"
	mgo "github.com/globalsign/mgo"
	// "github.com/globalsign/mgo/bson"
)

func GetIPStats() []m.KeyVal {

	const MONGODB_URL = "192.168.1.167:27017"
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

	// var res []bson.M
	// collation := &mgo.Collation{Locale: "en", Strength: 1}
	// err = c.Find(nil).Collation(collation).All(&res)
	// if err != nil {
	// 	panic(err)
	// }
	// fmt.Println(res)

	return list
	// // json, _ := json.Marshal(list)
	// // return string(json)
	// result := `[ ['key', 'value'],`
	// for i := 0; i < len(list); i++ {
	// 	result += `['` + list[i].Key + `',` + strconv.Itoa(list[i].Val) + `]`
	// 	if (i+1) != len(list) {
	// 		result += `,`
	// 	} else {
	// 		result += `]`
	// 	}
	// }
	// // fmt.Println(result)
	// return result
}
