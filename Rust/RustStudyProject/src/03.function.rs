fn main() {
    let x = test1_function();
    println!("x: {}", x);
}

/*fn another_function(x: i32, y: i32) {
    println!("x: {}, y: {}", x, y);
}*/

fn test1_function() -> i32 {
    println!("hello");
    5
}