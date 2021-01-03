use std::collections::HashMap;

fn main() {
    let mut scores = HashMap::new();

    scores.insert(String::from("블루"), 10);
    scores.insert(String::from("옐로"), 50);

    let teams = vec![String::from("블루"), String::from("옐로")];
    let initial_scores = vec![10, 50];

    //let scores: HashMap<_, _> = teams.iter().zip(initial_scores.iter()).collect();

    for (key, value) in &scores {
        println!("{}, {}", key, value);
    }

    scores.insert(String::from("블루"), 25);

    println!("{:?}", scores);


    let text = "hello world wonderful world";

    let mut map = HashMap::new();

    for word in text.split_whitespace() {
        let count = map.entry(word).or_insert(0);
        *count += 1;
    }

    println!("{:?}", map);




 
}