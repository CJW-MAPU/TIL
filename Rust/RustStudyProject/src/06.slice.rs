fn main() {
    let s = String::from("hello world");

    let word = first_word1(&s);

    //s.clear();

    println!("{}", word);


    let s1 = String::from("hello world");

    let hello = &s1[0..5];
    let world = &s1[6..11];

    println!("{}, {}!", hello, world);

    let word2 = first_word2(&s);

    println!("{}", word2);
/*
    let slice = &s1[0..2]; // &s1[..2]

    let len = s.len();

    let slice = &s1[3..len]; // &s1[3..]

    let slice = &s1[0..len]; // &s1[..]
*/

}

fn first_word1(s: &String) -> usize {
    let bytes = s.as_bytes();

    for (i, &item) in bytes.iter().enumerate() {
        if item == b' ' {
            return i;
        }
    }

    s.len()
}

fn first_word2(s: &String) -> &str {
    let bytes = s.as_bytes();

    for (i, &item) in bytes.iter().enumerate() {
        if item == b' '{
            return &s[0..i];
        }
    }

    &s[..]
}