use std::fmt::Display;

fn largest<T: PartialOrd + Copy>(list: &[T]) -> T {
    let mut largest = list[0];

    for &item in list.iter() {
        if item > largest {
            largest = item;
        }
    }

    largest
}
/* 이거는 잘 모르겠당
fn largest2<T: PartialOrd>(list: &[T]) -> &T {
    let mut largest = &list[0];

    for &item in list.iter() {
        if item > largest {
            largest = item;
        }
    }

    &largest
}
*/

struct Pair<T> {
    x: T,
    y: T,
}

impl<T> Pair<T> {
    fn new (x: T, y: T) -> Self {
        Self {
            x,
            y,
        }
    }
}

impl<T: Display + PartialOrd> Pair<T> {
    fn cmp_display(&self) {
        if self.x >= self.y {
            println!("가장 큰 멤버는 x: {}", self.x);
        } else {
            println!("가장 큰 멤버는 y: {}", self.y);
        }
    }
}

fn main() {
    let number_list = vec![34, 50, 25, 100, 65];

    let result = largest(&number_list);
    println!("가장 큰 숫자: {}", result);

    let char_list = vec!['y', 'm', 'a', 'q'];

    let result = largest(&char_list);
    println!("가장 큰 문자: {}", result);

    let s = 3.to_string();
}