pub struct Post {
    state: Option<Box<dyn State>>,
    content: String,
}

impl Post {
    pub fn new() -> Post {
        Post {
            state: Some(Box::new(Draft {})),
            content: String::new(),
        }
    }

    pub fn add_text(&mut self, text: &str) {
        self.content.push_str(text);
    }
}

trait State {}

struct Draft {}

impl State for Draft {}

fn main() {
    let mut post = Post::new();

    post.add_text("나는 오늘 점심으로 샐러드를 먹었따.");
    assert_eq!("", post.content());

    post.request_review();
    assert_eq!("", post.content());

    post.approve();
    assert_eq!("나는 오늘 점심으로 샐러드를 먹었다.", post.content());
}