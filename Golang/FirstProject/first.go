package main

import "fmt"

type calculator func(int, int) int

func first() {
	//fmt.Println(sum(1, 2, 3, 4))
	//fmt.Println(sum2(1, 2, 3, 4))
	//
	//sum3 := func(n ...int) int {
	//	s := 0
	//	for _, i := range n {
	//		s += i
	//	}
	//	return s
	//}
	//add := func(i int, j int) int {
	//	return i + j
	//}
	//
	//fmt.Println(sum3(1, 2, 3, 4))
	//fmt.Println(calc(add, 4, 5))
	//
	//next := nextValue()
	//
	//fmt.Println(next())
	//fmt.Println(next())
	//fmt.Println(next())
	//anotherNext := nextValue()
	//fmt.Println(anotherNext())
	//fmt.Println(anotherNext())
	var arr1 [3]int
	arr1[0] = 1
	arr1[1] = 2
	arr1[2] = 3

	fmt.Println(arr1)

	var arr2 = [3]int{1, 2, 3}
	var arr3 = [...]int{1, 2, 3}
	fmt.Println(arr2)
	fmt.Println(arr3)

	var arr4 = [2][3]int{
		{1, 2, 3},
		{4, 5, 6},
	}

	fmt.Println(arr4)
	fmt.Println(len(arr4), cap(arr4))

	arr5 := make([]int, 5, 10)
	fmt.Println(len(arr5), cap(arr5))

	var arr6 []int
	arr6 = []int{1, 2, 3}
	fmt.Println(arr6)

	var arr7 []int

	if arr7 == nil {
		fmt.Println("nil slice")
	}
	fmt.Println(len(arr7), cap(arr7))

	arr8 := []int{0, 1, 2, 3, 4, 5}
	subArr := arr8[2:5]
	fmt.Println(subArr)

	arr9 := make([]int, 0, 3)
	fmt.Println(len(arr9), cap(arr9))
	for i := 0; i < 15; i++ {
		arr9 = append(arr9, i)
		fmt.Println(len(arr9), cap(arr9))
	}
	fmt.Println(arr9)

	arr10 := []int{1, 2, 3}
	arr11 := []int{4, 5, 6}
	arr10 = append(arr10, arr11...)
	fmt.Println(arr10)

}

func sum(nums ...int) (int, int) {
	s := 0
	count := 0

	for _, n := range nums {
		s += n
		count++
	}

	return count, s
}

func sum2(nums ...int) (total int, count int) {
	for _, n := range nums {
		total += n
		count++
	}

	return
}

func calc(f calculator, a int, b int) (result int) {
	result += f(a, b)

	return result
}

func nextValue() func() int {
	i := 0
	return func() int {
		i++
		return i
	}
}
