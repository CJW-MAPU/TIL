fn main() {

    /* 변수와 상수의 개념 */
    let mut x = 5; // let x = 5;
    println!("x의 값: {}", x);
    x = 6;
    println!("x의 값: {}", x);


    /* 변수 가리기 */
    let a = 5;

    let a = a + 1;

    let a = a * 2;

    println!("a의 값: {}", a);

    /* 정수 타입 */
    let b = 0xA;
    println!("b의 값: {}", b);

    /* 부동 소수점 타입 */
    let c = 2.0; // f64
    let d: f32 = 3.0; // f32
    println!("출력: {}, {}", c, d);

    /* 사칙 연산 */
    let sum = 5 + 10;
    let difference = 95.5 - 4.3;
    let product = 4 * 30;
    let quotient = 56.7 / 32.2;
    let remainder = 43 % 5;
    println!("사칙 연산 결과: {}, {}, {}, {}, {}", sum, difference, product, quotient, remainder);

    /* 불리언 타입 */
    let t = true;
    let f: bool = false;
    println!("불리언 결과: {}, {}", t, f);

    /* 문자 타입 */
    let e = 'z';
    println!("emoji도 출력 가능: {}", e);

    /* 튜플 타입 */
    let tup: (i32, f64, u8) = (500, 6.4, 1);
    let tup2 = (400, 5.4, 2);

    let (tupa, tupb, tupc) = tup;
    let (tupd, tupe, tupf) = tup2;
    
    println!("tup: {}, {}, {}", tupa, tupb, tupc);
    println!("tup2: {}, {}, {}", tupd, tupe, tupf);

    println!("tup: {}, {}, {}", tup.0, tup.1, tup.2); // . 연산자로 요소 직접 참조 가능

    /* 배열 타입 */
    let a = [1, 2, 3, 4, 5];
    println!("a: {}, {}, {}, {}, {}", a[0], a[1], a[2], a[3], a[4]);
    // let _tup3 = a; 이런거는 불가능 한건가..? 알아봐야겠다.


}