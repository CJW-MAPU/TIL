use add_one;

fn main() {
    let num = 10;
    println!("안녕하세요! {} 더하기 1은 {}입니다!", num, add_one::add_one(num));
}