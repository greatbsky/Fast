package so
import (
	"../dao"
	// "fmt"
	"strconv"
)

func GetIPStats() string {

	//查询多条数据 Find().All()
	var list = dao.GetIPStats()
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
