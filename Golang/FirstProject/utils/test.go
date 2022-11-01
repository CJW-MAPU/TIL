package utils

import "fmt"

var pop map[string]string

func init() {
	pop = make(map[string]string)
	pop["Adele"] = "Hello"
	pop["Alicia keys"] = "Fallin'"
	pop["John Legend"] = "All of Me"
}

func GetMusic(singer string) string {
	return pop[singer]
}

func getKeys() {
	for _, kv := range pop {
		fmt.Println(kv)
	}
}
