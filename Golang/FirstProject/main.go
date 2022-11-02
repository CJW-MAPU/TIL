package main

import (
	"fmt"
	"math"
)

type Shape interface {
	area() float64
	perimeter() float64
}

type Rects struct {
	width, height float64
}

func (r Rects) area() float64 {
	return r.width * r.height
}

func (r Rects) perimeter() float64 {
	return 2 * (r.width + r.height)
}

type Circles struct {
	radius float64
}

func (c Circles) area() float64 {
	return math.Pi * c.radius * c.radius
}

func (c Circles) perimeter() float64 {
	return 2 * math.Pi * c.radius
}

func main() {
	r := Rects{10., 20.}
	c := Circles{10}

	showArea(r, c)
}

func showArea(shapes ...Shape) {
	for _, s := range shapes {
		a := s.area()
		fmt.Println(a)
	}
}
