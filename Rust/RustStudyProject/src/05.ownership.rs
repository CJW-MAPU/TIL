fn main() {
    // 문자열 리터럴을 이용한 스트링 인스턴스 생성 ::from을 활용하여
    /*let mut s = String::from("hello");

    s.push_str(", world!");

    println!("{}", s);

    let x = 5;
    let y = x;

    println!("{}, {}", x, y);

    let s1 = String::from("hello");
    let s2 = s1;

    //println!("{}, {}", s1, s2); 이거 오류남. hello라는 스트링 인스턴스의 소유권이 s1에서 s2로 양도되었기 때문

    let s1 = String::from("hello");
    let s2 = s1.clone();

    println!("{}, {}", s1 , s2);// 힙 영역에 저장하고 소유권을 넘겨서 s1을 사용 불가로 만드는 위 예제와 다르게 .clone()을 사용하여 문자열 자체를 복사해온 것이다. 그렇기에 오류가 나지 않는다. 
    */ 
    /*
    정수형 bool타입 문자 등을 포함하고 상황에 따라 튜플까지 복제가 아닌 복사가 가능하다. let x = 5; let y = x; 와 같은 식으로. 그러나 힙 영역에 저장되는 문자열 인스턴스는 clone을 사용하여 복제를 따로 해주어야 한다.
    */
/*
    let s = String::from("hello");
    let x = 5;

    takes_ownership(s); // 여기서 s가 takes_ownership으로 소유권이 양도되면서 변수 s는 유효하지 않게 되고, 함수 내부에서 some_string이 해제된다.
    makes_copy(x); // 정수형이기 복사를 진행하므로 함수 내부로 값이 복사 된다. 이후에도 변수 x는 유효하다.
*/

    let s1 = String::from("hello");
    let len = calculate_length(&s1); // & 연산자를 이용해 소유권을 양도하는 것이 아닌 참조 가능 .

    println!("'{}'의 길이는 {}입니다.", s1, len);


    let mut s = String::from("hello"); // 가변생성

    change(&mut s); //가변 참조를 하여야 소유권이 없는 변수를 수정 가능. 
    println!("{}", s);    

    /* 특정 범위 내에서 특정 데이터에 대한 가변 참조는 오직 한 개만 존재해야함. 그렇지 않으면 오류 발생 */
}


fn takes_ownership(some_string: String) {

    println!("{}", some_string);
}

fn makes_copy(some_integer: i32) {
    println!("{}", some_integer);
}

fn calculate_length(s: &String) -> usize {
    s.len()
}

fn change(some_string: &mut String) {
    some_string.push_str(", world!");
}