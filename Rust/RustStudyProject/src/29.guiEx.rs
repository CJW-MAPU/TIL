pub trait Draw {
    fn draw(&self);
}

pub struct Screen {
    pub components: Vec<Box<dyn Draw>>,
}

impl Screen {
    pub fn run(&self) {
        for component in self.components.iter() {
            component.draw();
        }
    }
}

pub struct Button {
    pub width: u32,
    pub height: u32,
    pub label: String,
}

impl Draw for Button {
    fn draw(&self) {
        // 실제로 버튼을 그리는 코드
    }
}

struct SelectBox {
    width: u32,
    height: u32,
    options: Vec<String>,
}

impl Draw for SelectBox {
    fn draw(&self) {
        // SelectBox를 그리는 코드
    }
}

fn main() {
    let screen = Screen {
        components: vec![
            Box::new(SelectBox {
                width:75,
                height: 10,
                options: vec![
                    String::from("예"),
                    String::from("아니요"),
                    String::from("모름")
                ],
            }),
            Box::new(Button {
                width: 50,
                height: 10,
                label: String::from("확인"),
            }),
        ],
    };

    screen.run();
}