fn main() {
    //let v: Vec<i32> = Vec::new();

    //let vv = vec![1, 2, 3];
    /*
    let mut v = Vec::new();

    v.push(5);
    v.push(6);
    v.push(7);
    v.push(8);
    */

    let v = vec![1, 2, 3, 4, 5];

    let third: &i32 = &v[2];

    println!("세 번째 원소: {}", third);

    match v.get(2) {
        Some(third) => println!("세 번째 원소: {}", third),
        None => println!("None"),
    }
    
}