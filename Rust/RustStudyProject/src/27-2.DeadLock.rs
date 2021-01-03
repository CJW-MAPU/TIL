use std::sync::{Mutex, Arc};
use std::thread;
use std::time;

fn main() {
    let mutexes = Arc::new((Mutex::new(1), Mutex::new(1)));
    let mut handles = vec![];
    {    
        let mutexes = Arc::clone(&mutexes);
        let handle = thread::spawn(move || {
            let mut num = mutexes.0.lock().unwrap();
            thread::sleep(time::Duration::from_secs(4));
            let mut num2 = mutexes.1.lock().unwrap();
        });
        handles.push(handle);
    }

    {
        let mutexes = Arc::clone(&mutexes);
        let handle = thread::spawn(move || {
            let mut num = mutexes.1.lock().unwrap();
            thread::sleep(time::Duration::from_secs(4));
            let mut num2 = mutexes.0.lock().unwrap();
        });
        handles.push(handle);
    }

    for handle in handles {
        handle.join().unwrap();
    }   

    println!("asd");
}