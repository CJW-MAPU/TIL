package main

import "fmt"

type person struct {
	name string
	age  int
}

type dict struct {
	data map[int]string
}

type Rect struct {
	width, height int
}

func third() {
	p := person{}
	p.name = "Lee"
	p.age = 18

	fmt.Println(p)

	var p1 person
	p1 = person{"Name", 10}
	p2 := person{"Name", 10}

	fmt.Println(p1, p2)

	p3 := new(person)
	fmt.Println(p3.name, p3.age)
	fmt.Println(*p3)

	fmt.Println(*updateStruct(&p))
	fmt.Println(p)

	dic := newDict()
	dic.data[1] = "A"

	fmt.Println(dic)

	rect := new(Rect)
	rect.width = 10
	rect.height = 20

	fmt.Println(rect.area())

}

func updateStruct(input *person) *person {
	fmt.Println(*input)
	input.name = "qwe"
	input.age = 20
	return input
}

func newDict() *dict {
	d := dict{}
	d.data = map[int]string{}
	return &d
}

func (r Rect) area() int {
	return r.width * r.height
}
