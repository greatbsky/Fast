package routers

import (
	"../base"
	"github.com/astaxie/beego"
)

type ExceptionRouter struct {
	base.Router
}

func (this *ExceptionRouter) Latest() {
	this.Show("exception/latest.tpl")
}

func (this *ExceptionRouter) Stats() {
	this.Show("exception/stats.tpl")
}


func init() {
	beego.Router("/exception/latest", &ExceptionRouter{}, "*:Latest")
	beego.Router("/exception/stats", &ExceptionRouter{}, "*:Stats")
}
