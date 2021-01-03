use std::fmt::Display;
use std::fmt::Debug;

pub trait Summary {
    /*
    fn summarize(&self) -> String {
        String::from("(계속 읽기)")
    }
    */

    fn summarize_author(&self) -> String;
    fn summarize(&self) -> String {
        format!("{}님의 기사 더 읽기", self.summarize_author())
    }
}

pub struct NewsArticle {
    pub headline: String,
    pub location: String,
    pub author: String,
    pub content: String,
}

/*
impl Summary for NewsArticle {
    /*
    fn summarize(&self) -> String {
        format!("{}, by {}, ({})", self.headline, self.author, self.location)
    }
    */
}
*/

pub struct Tweet {
    pub username: String,
    pub content: String,
    pub reply: bool,
    pub retweet: bool,
}

impl Summary for Tweet {

    /*
    fn summarize(&self) -> String {
        format!("{}: {}", self.username, self.content)
    }
    */

    fn summarize_author(&self) -> String {
        format!("@{}", self.username)
    }
}

/*
pub fn notify(item: impl Summary) {
    println!("속보! {}", item.summarize());
}

pub fn notify<T: Summary>(item: T) {
    println!("속보! {}", item.summarize());
}
*/

/*
pub fn notify(item1: impl Summary, item2: impl Summary) {

}
*/

/*
pub fn notify<T: Summary>(item1: T, item2: T) {

}
*/

/*
pub fn notify(item: impl Summary + Display) {

}

pub fn notify<T: Summary + Display>(item: T) {

}
*/

/*
fn some_function<T, U>(t: T, u: U) -> i32
    where T: Display + Clone,
          U: Clone + Debug
{

}
*/



fn main () {
    let tweet = Tweet {
        username: String::from("horse_ebooks"),
        content: String::from("러스트 언어 공부를 시작했습니다."),
        reply: false,
        retweet: false,
    };

    println!("새 트윗 1개: {}", tweet.summarize());

    //notify(tweet);
/*
    let article = NewsArticle {
        headline: String::from("대한민국, 러시아 월드컵 예선에서 독일을 이겼다."),
        location: String::from("카잔 아레나, 러시아"),
        author: String::from("위키백과"),
        content: String::from("2018년 6월 27일 러시아 카잔의 카잔 아레나에서 열린 2018 월드컵 F조 3차전 경기에서 대한민국이 독일에 2:0 승리를 거뒀다."),
    };
*/
    //println!("새로운 기사: {}", article.summarize());
}