use std::sync::{Mutex, Arc};
use std::thread;
//use std::rc::Rc;

fn main() {
    /*
    let m = Mutex::new(5);

    {
        let mut num = m.lock().unwrap();
        *num = 6;   
    }

    println!("m = {:?}", m);
    */
    
    let counter = Arc::new(Mutex::new(0));
    let mut handles = vec![];
    /*
    for _ in 0..10 {
        let handle = thread::spawn(move || {
            let mut num = counter.lock().unwrap();

            *num += 1;
        });
        handles.push(handle);
    }

    for handle in handles {
        handle.join().unwrap();
    }

    println!("결과: {}", *counter.lock().unwrap());
    */

    /*
    let handle = thread::spawn(move || {
        let mut num = counter.lock().unwrap();

        *num += 1;
    });

    handles.push(handle);

    let handle2 = thread::spawn(move || { // 소유권이 자식 스레드로 넘어가서 오류가 발생.
        let mut num = counter.lock().unwrap();

        *num += 1;
    });

    handles.push(handle2);
    */

    /*
    for _ in 0..10 {
        let counter = Rc::clone(&counter);
        let handle = thread::spawn(move || {
            let mut num = counter.lock().unwrap();

            *num += 1;
        });
        handles.push(handle);
    }

    for handle in handles {
        handle.join().unwrap();
    }

    println!("결과: {}", *counter.lock().unwrap());
    */

    for _ in 0..10 {
        let counter = Arc::clone(&counter);
        let handle = thread::spawn(move || {
            let mut num = counter.lock().unwrap();

            *num += 1;
        });

        handles.push(handle);
    }

    for handle in handles {
        handle.join().unwrap();
    }

    println!("결과: {}", *counter.lock().unwrap());

}