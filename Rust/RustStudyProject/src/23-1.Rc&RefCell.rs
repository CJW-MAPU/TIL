/*
use List::{Cons, Nil};
use std::rc::Rc;

enum List {
    Cons(i32, Rc<List>),
    Nil,
}
*/

pub trait Messenger {
    fn send(&self, msg: &str);
}

pub struct LimitTracker<'a, T: 'a + Messenger> {
    messenger: &'a T,
    value: usize,
    max: usize, 
}

impl<'a, T> LimitTracker<'a, T>
    where T: Messenger {
        pub fn new( messenger: &T, max: usize) -> LimitTracker<T> {
            LimitTracker {
                messenger,
                value: 0,
                max,
            }
        }

        pub fn set_value(&mut self, value: usize) {
            self.value = value;

            let percentage_of_max = self.value as f64 / self.max as f64;

            if percentage_of_max >= 0.75 && percentage_of_max < 0.9 {
                self.messenger.send("경고: 최댓값의 75%를 사용했습니다.");
            } else if percentage_of_max >= 0.9 && percentage_of_max < 1.0 {
                self.messenger.send("긴급 경고: 최댓값의 90%를 사용했습니다.");
            } else if percentage_of_max >= 1.0  {
                self.messenger.send("에러: 최댓값을 초과했습니다.");
            }
            
        }
    }

fn main() {
    /*
    let a = Rc::new(Cons(5, Rc::new(Cons(10, Rc::new(Nil)))));
    println!("a를 생성한 후의 카운터 = {}", Rc::strong_count(&a));
    let b = Cons(3, Rc::clone(&a));
    println!("b를 생성한 후의 카운터 = {}", Rc::strong_count(&a));
    {
        let c = Cons(4, Rc::clone(&a));
        println!("c를 생성한 후의 카운터 = {}", Rc::strong_count(&a));
    }
    println!("c가 범위를 벗어난 후의 카운터 = {}", Rc::strong_count(&a));
    */


}

#[cfg(tes)]
mod tests {
    use super::*;
    use std::cell::RefCell;

    struct MockMessenger {
        //sent_messages: Vec<String>,
        sent_messages: RefCell<Vec<String>>,
    }

    impl MockMessenger {
        fn new() -> MockMessenger {
            //MockMessenger { sent_messages: vec![] }
            MockMessenger { sent_message: RefCell:new(vec![]) }
        }task 
    }

    impl Messenger for MockMessenger {
        fn send(&self, message: &str) {
            //self.sent_messages.push(String::from(message));
            self.sent_messages.borrow_mut().push(String::from(message));
        }
    }

    #[test]
    fn it_sends_an_over_75_percent_warning_message() {
        let mock_messenger = MockMessenger::new();
        let mut limit_tracker = LimitTracker::new(&mock_messenger, 100);
        limit_tracker.set_value(80);
        //assert_eq!(mock_messenger.sent_messages.len(), 1);
        assert_eq!(mock_messenger.sent_messages.borrow().len(), 1);
    }
}