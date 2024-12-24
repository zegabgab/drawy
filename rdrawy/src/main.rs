mod complex;
mod mandelbrot;

use crate::complex::*;

fn main() {
    println!("{:?}", Complex::new(0., 1.) * Complex::new(0., 2.));
    println!("Hello, world!");
}
