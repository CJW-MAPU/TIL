fn main() {
    let mut s = String::new();

    let data = "문자열 초깃값";

    let s = data.to_string();

    let mut s = String::from("foo");

    s.push_str("bar");

    println!("{}", s);

    let hello = "안녕하세요";

    let s2 = &hello[0..3];

    println!("{}", s2);

    for c in "안녕하세요".chars() {
        println!("{}", c);
    }

    for b in "안녕하세요".bytes() {
        println!("{}", b);
    }
}