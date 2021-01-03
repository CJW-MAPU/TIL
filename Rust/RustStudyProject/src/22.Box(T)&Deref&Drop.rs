use crate::List::{Cons, Nil};
use std::ops::Deref;

enum List {
    Cons(i32, Box<List>),
    Nil,
}

struct MyBox<T>(T);

impl<T> MyBox<T> {
    fn new(x: T) -> MyBox<T> {
        MyBox(x)
    }
}

impl<T> Deref for MyBox<T> {
    type Target = T;

    fn deref(&self) -> &T {
        &self.0
    }
}

struct CustomSmartPointer {
    data: String,
}

impl Drop for CustomSmartPointer {
    fn drop(&mut self) {
        println!("CustomSmartPointer의 데이터 '{}'를 해제합니다!", self.data);
    }
}

fn main() {
    /*
    let b = Box::new(5);
    println!("b = {}", b);

    let list = Cons(1,
        Box::new(Cons(2,
            Box::new(Cons(3,
                Box::new(Nil))))));
    */

    let x = 5;
    let y = MyBox::new(x);

    assert_eq!(5, x);
    assert_eq!(5, *y);

    let c = CustomSmartPointer { data: String::from("내 데이터") };
    let d = CustomSmartPointer { data: String::from("다른 데이터") };
    println!("CustomSmartPointer를 생성했습니다.");
    drop(c);
    println!("CustomSmartPointer를 main 함수의 끝에 도달하기 전에 해제합니다.");
}