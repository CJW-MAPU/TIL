/*
use std::cell::RefCell;
use std::rc::Rc;
use List::{Cons, Nil};

#[derive(Debug)]
enum List {
    Cons(Rc<RefCell<i32>>, Rc<List>),
    Nil,
}

fn main() {
    
    let value = Rc::new(RefCell::new(5));

    let a = Rc::new(Cons(Rc::clone(&value), Rc::new(Nil)));

    let b = Cons(Rc::new(RefCell::new(6)), Rc::clone(&a));
    let c = Cons(Rc::new(RefCell::new(10)), Rc::clone(&a));

    *value.borrow_mut() += 10;

    println!("a 수정 후 = {:?}", a);
    println!("b 수정 후 = {:?}", b);
    println!("c 수정 후 = {:?}", c);
    
}
*/

use std::rc::Rc;
use std::cell::RefCell;
use List::{Cons, Nil};

#[derive(Debug)]
enum List {
    Cons(i32, RefCell<Rc<List>>),
    Nil,
}

impl List {
    fn tail(&self) -> Option<&RefCell<Rc<List>>> {
        match *self {
            Cons(_, ref item) => Some(item),
            Nil => None,
        }
    }
}

fn main() {
    let a = Rc::new(Cons(5, RefCell::new(Rc::new(Nil))));

    println!("a의 최초 rc 카운 = {}", Rc::strong_count(&a));
    println!("a의 다음 아이템 = {:?}", a.tail());

    let b = Rc::new(Cons(5, RefCell::new(Rc::clone(&a))));

    println!("b를 생성한 후 a의 rc 카운트 = {}", Rc::strong_count(&a));
    println!("b의 최초 rc 카운트 = {}", Rc::strong_count(&b));
    println!("b의 다음 아이템 = {:?}", b.tail());

    if let Some(link) = a.tail() {
        *link.borrow_mut() = Rc::clone(&b);
    }

    println!("a를 변경한 후 b의 rc 카운트 = {}", Rc::strong_count(&b));
    println!("a를 변경한 후 a의 rc 카운트 = {}", Rc::strong_count(&a));

    
}