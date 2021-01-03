/*
use std::thread;
use std::time::Duration;

fn main() {
    let handle = thread::spawn(|| {
        for i in 1..10 {
            println!("새 스레드: {}", i);
            thread::sleep(Duration::from_millis(1000));
        }
    });

    for i in 1..5 {
        println!("주 스레드: {}", i);
        thread::sleep(Duration::from_millis(1000));
    }

    handle.join().unwrap();
}
*/

use std::thread;

fn main() {
    let v = vec![1, 2, 3];

    let handle = thread::spawn(move || { 
        println!("벡터: {:?}", v);
    });

    handle.join().unwrap();
} 