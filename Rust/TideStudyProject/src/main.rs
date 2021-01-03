// #[async_std::main]
// async fn main() -> Result<(), std::io::Error> {
//     let mut app = tide::new();
//     app.at("/test").get(|_| async move { " Hello, World! " });
//     app.listen("127.0.0.1:8080").await?;

//     Ok(())
// }

// #[derive(Serialize, Deserialize)]
// struct Message {
//     contents: String,
//     author: Option<String>,
//     // etc...
// }

// /// A handle to an in-memory list of messages
// #[derive(Clone)]
// struct Database { /* ... */ }

// impl Database {
//     /// Create a handle to an empty database
//     fn new() -> Database;

//     /// Add a new message, returning its ID
//     fn insert(&mut self, msg: Message) -> u64;

//     /// Attempt to look up a message by ID
//     fn get(&mut self, id: u64) -> Option<Message>;

//     /// Attempt to edit a message; returns `false`
//     /// if `id` is not found.
//     fn set(&mut self, id: u64, msg: Message) -> bool;
// }

// async fn new_message(mut db: AppState<Database>, msg: Json<Message>) -> Display<uszie> {
//     db.insert(msg.0)
// }

// fn main() {
//     let mut app = App::new(Database::new());

//     app.at("/message").post(new_message);
//     app.at("/message/{}").get(get_message);
//     app.at("/message/{}").put(set_message);

//     app.serve();
// }

// use async_std::task;

// async fn say_hello() {
//     println!("Hello, World");
// }

// fn main() {
//     task::block_on(say_hello());
// }



use serde::{ Serialize, Deserialize };
use std::fs::File;
use std::io::Read;
use std::io;

#[derive(Debug, Deserialize, Serialize)]
struct Counter {
    count: usize
}

#[async_std::main]
async fn main() -> Result<(), std::io::Error>  {
    let mut app = tide::new();
    
    // let html_body = "<b> Hello, World! </b>";


    app.at("/test").post(|mut req: tide::Request<()>| async move {
        let mut counter: Counter = req.body_json().await.unwrap();
        println!("count is {}", counter.count);
        counter.count += 1;
        tide::Response::new(200).body_json(&counter).unwrap()
    });

    app.at("/index.html").get(move |_| async move { 
        // tide::Response::new(200)
        //     .body_string(read_html("index.html"))
        //     .set_header("Content-Type", "text/html") //content-type = text/html
        match read_html("index.html".to_string()) {
            Ok(contents) => {
                tide::Response::new(200)
                    .body_string(contents)
                    .set_header("Content_Type", "text/html")
            },
            Err(_) => {
                tide::Response::new(500)
                    .body_string("404 Error Page!".to_string())
                    .set_header("Content_Type", "text/html")
            },
        }
    });

    app.at("/test").get(|_| async move { " Hello, World! " });

    app.listen("127.0.0.1:8080").await?;

    Ok(())
}

fn read_html(fname: String) -> std::io::Result<String> {
    // let file = File::open(fname)?;
    // let mut buf_reader = BufReader::new(file);
    // let mut contents = String::new();

    // buf_reader.read_to_string(&mut contents)?;

    let file = File::open(fname)?;
    let mut contents = String::new();

    file.read_to_string(&mut contents);

    Ok(contents)
}

// use serde::{ Serialize, Deserialize };

// #[derive(Serialize, Deserialize, Debug)]
// struct Point {
//     x: i32,
//     y: i32,
// }

// fn main() {
//     let point = Point { x: 1, y: 2 };

//     let serialized = serde_json::to_string(&point).unwrap();

//     println!("serialized = {}", serialized);

//     let deserialized: Point = serde_json::from_str(&serialized).unwrap();

//     println!("deserialized = {:?}", deserialized);
// }