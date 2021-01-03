/*
fn main() {
    
    //let number_list = vec![34, 50, 25, 100, 65];
    //let char_list = vec!['a', 'b', 'c', 'd'];

    let mut largest = number_list[0];

    for number in number_list {
        if number > largest {
            largest = number;
        }
    }

    println!("{}", largest);

    //let result = largest_i32(&number_list);
    let result = largest(&number_list);
    println!("{}", result);    

    //let result = largest_char(&char_list);
    let result = largest(&char_list);
    println!("{}", result);

}
*/
/*
fn largest_i32(list: &[i32]) -> i32 {
    let mut largest = list[0];

    for &item in list.iter() {
        if item > largest {
            largest = item;
        }
    }

    largest
}

fn largest_char(list: &[char]) -> char {
    let mut largest = list[0];

    for &item in list.iter() {
        if item > largest {
            largest = item;
        }
    }

    largest
}
*/
/*
fn largest<T>(list: &[T]) -> T {
    let mut largest = list[0];

    for &item in list.iter() { // 이거 에러남
        if item > largest {
            largest = item;
        }
    }

    largest
}
*/

struct Point<T> {
    x: T,
    y: T,
}

impl<T> Point<T> {
    fn x(&self) -> &T {
        &self.x
    }
    
    fn y(&self) -> &T {
        &self.y
    }
    fn get(&self) -> (&T, &T) {
        (&self.x, &self.y)
    }
}

fn main() {
    //let integer = Point { x: 5, y: 10 };
    //let float = Point { x: 1.0, y: 2.0 };

    let p = Point { x: 5, y: 10 };

    println!("{}, {}", p.x(), p.y());

    println!("{}, {}", p.get().0, p.get().1);
    
}