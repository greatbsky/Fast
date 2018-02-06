package models

type KeyVal struct {
	Key  string `bson:"key" json:"key"`
	Val int `bson:"value" json:"value"`
}
