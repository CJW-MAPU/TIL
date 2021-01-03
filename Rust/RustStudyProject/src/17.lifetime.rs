struct ImportantExcerpt<'a> {
    part: &'a str,
}

fn main() {

    /* lifetime
    {
        let r;                      //                  ┼── 'a
        {                           //                  │
            let x = 5;              //─┼── 'b           │
            r = &x;                 // │                │
        }                           //─┼                │
        println!("r: {}", r);       //──────────────────┼
    }
    */

    {
        let x = 5;

        let r = &x;

        println!("r: {}", r);
    }

    let string1 = String::from("abcd");
    let string2 = "xyz";

    let result = longest(string1.as_str(), string2);
    println!("더 긴 문자열: {}", result);

    let string3 = String::from("아주 아주 긴 문자열");

    {
        let string4 = String::from("xyz");
        let result = longest(string3.as_str(), string4.as_str());
        println!("더 긴 문자열: {}", result);
    }

    let novel = String::from("스타워즈. 오래 전 멀고 먼 은하계에 ...");
    let first_sentence = novel.split('.')
        .next()
        .expect("문장에서 마침표 '.'을 찾을 수 없습니다.");

    let i = ImportantExcerpt { part: first_sentence };

    println!("{}", i.part);


}

fn longest<'a>(x: &'a str, y: &'a str) -> &'a str {
    if x.len() > y.len() {
        x
    } else {
        y
    }
}