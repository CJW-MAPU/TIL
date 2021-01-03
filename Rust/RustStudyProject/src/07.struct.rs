struct User {
    username: String,
    email: String,
    sign_in_count: u64,
    active: bool
}

struct Rectangle {
    width: u32,
    height: u32
}

fn main() {

    let user1 = User {
        email: String::from("someone@example.com"),
        username: String::from("someusername123"),
        active: true,
        sign_in_count: 1,
    };

    let user2 = User {
        email: String::from("another@example.com"),
        username: String::from("anotherusername789"),
        ..user1 //active: user1.active, sign_in_count: user1.sign_in_count,
    };

    //let user1 = build_user("anotheremail@exmaple.com".to_string(), "anotherusername123".to_string());

    println!("{}, {}, {}, {}", user1.username, user1.email, user1.sign_in_count, user1.active);

    //user1.email = String::from("anotheremail@example.com");

    //튜플 구조체 :: 필드에 이름을 부여하는 것이 불필요하고 여타 다른 튜플과 구별하고 싶을 때 튜플 구조체 사용.
    struct Color(i32, i32, i32);
    struct Point(i32, i32, i32);
    
    let black = Color(0, 0, 0);
    let origin = Point(0, 0, 0);

    /*
    let width = 30;
    let height = 50;
    */
    //let rect1 = (30, 50);
    let rect1 = Rectangle { width: 30, height: 50 };

    println!(
        "사각형의 면적: {} 제곱 픽셀",
        area(&rect1)
    );

}

fn build_user(email: String, username: String) -> User {
    User {
        email, //email: email,
        username, //username: username,
        active: true,
        sign_in_count: 1,
    }
}
/*
fn area(dimensions: (u32, u32)) -> u32 {
    dimensions.0 * dimensions.1
}
*/
fn area(rectangle: &Rectangle) -> u32 {
    rectangle.width * rectangle.height
}