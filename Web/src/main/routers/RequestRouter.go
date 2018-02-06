package routers

import (
	"../base"
	"../dao"
	"github.com/astaxie/beego"
)

type RequestRouter struct {
	base.Router
}

func (this *RequestRouter) IpStats() {
	this.Data["data"] = dao.GetIPStats()
	this.Show("request/ip.tpl")
}

func (this *RequestRouter) TimeStats() {
	this.Show("request/time.tpl")
}

func (this *RequestRouter) HotRank() {
	this.Show("request/hot.tpl")
}


func init() {
	beego.Router("/request/ip", &RequestRouter{}, "*:IpStats")
	beego.Router("/request/time", &RequestRouter{}, "*:TimeStats")
	beego.Router("/request/hot", &RequestRouter{}, "*:HotRank")
}
