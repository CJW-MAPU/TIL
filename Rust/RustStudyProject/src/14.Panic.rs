use std::io;
use std::io::Read;
use std::fs::File;
use std::io::ErrorKind;

fn main() {
    //panic!("crash and burn");

    //let v = vec![1, 2, 3];

    //v[99];
    /*
    let f = File::open("src/hello.txt");

    
    let f = match f {
        Ok(file) => file,
        Err(error) => {
            panic!("파일 열기 실패: {:?}", error);
        }
    };
    */
    /*
    let f = match f {
        Ok(file) => file,
        Err(ref error) => match error.kind() {
            ErrorKind::NotFound => match File::create("src/hello.txt") {
                Ok(fc) => fc,
                Err(e) => panic!("파일을 생성하지 못했습니다: {:?}", e),
            },
            other_error => panic!("파일을 열지 못했습니다: {:?}", other_error),
        },
    };
    */

    //let f = File::open("hello.txt").unwrap();
    //let f = File::open("hello.txt").expect("파일을 열 수 없습니다.");

    match read_username_from_file() {
        Ok(s) => println!("{}", s),
        Err(e) => panic!("{:?}", e),
    };

}

fn read_username_from_file() -> Result<String, io::Error> {
    let f = File::open("hello.txt");

    let mut f = match f {
        Ok(file) => file,
        Err(e) => return Err(e),
    };

    let mut s = String::new();

    match f.read_to_string(&mut s) {
        Ok(_) => Ok(s),
        Err(e) => Err(e),
    }
}