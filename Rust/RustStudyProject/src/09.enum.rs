/*
enum IpAddrKind {
    V4,
    V6,
}

#[derive(Debug)]
enum IpAddrKindStr {
    V4(String),
    V6(String),
}

#[derive(Debug)]
enum IpAddrKind1 {
    V4(u8, u8, u8, u8),
    V6(String),
}
*/

#[derive(Debug)]
enum Message {
    Quit,
    Move { x: i32, y: i32 },
    Write(String),
    ChangeColor(i32, i32, i32),
}

impl Message {
    fn call(&self) {
        println!("{:?}", self);
    }
}

fn main() {
    /*
    let four = IpAddrKind::V4;
    let six = IpAddrKind::V6;

    route(IpAddrKind::V4);
    route(IpAddrKind::V6);
    /*
    let home = IpAddr {
        kind: IpAddrKind::V4,
        address: String::from("127.0.0.1"),
    };
    */
    //let home = IpAddrKindStr::V4(String::from("127.0.0.1"));

    let home = IpAddrKind1::V4(127, 0, 0, 1);
    /*
    let loopback = IpAddr {
        kind: IpAddrKind::V6,
        address: String::from("::1"),
    };
    */
    //let loopback = IpAddrKindStr::V6(String::from("::1"));
    let loopback = IpAddrKind1::V6(String::from("::1"));

    println!("{:?}, {:?}", home, loopback);
    */

    let m = Message::Write(String::from("hello"));

    m.call();

    
}

// fn route(ip_type: IpAddrKind) { }
