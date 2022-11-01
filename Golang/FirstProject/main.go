package main

import (
	"FirstProject/utils"
	"fmt"
)

func main() {
	source := []int{0, 1, 2}
	target := make([]int, len(source), cap(source)*2)
	copy(target, source)
	fmt.Println(len(source), cap(source))
	fmt.Println(target)
	fmt.Println(len(target), cap(target))

	tickers := map[string]string{
		"GG": "Google",
		"MS": "Microsoft",
		"FB": "Facebook",
	}

	fmt.Println(tickers["GG"])

	value, exists := tickers["MSS"]
	if exists {
		fmt.Println(value)
	} else {
		fmt.Println("Key Exception")
	}

	for key, val := range tickers {
		fmt.Println(key, val)
	}
	song := utils.GetMusic("John Legend")

	fmt.Println(song)
}
