mod complex;
mod mandelbrot;
mod convergence_set;

use crate::complex::*;

fn main() {
    println!("{:?}", Complex::new(0., 1.) * Complex::new(0., 2.));
    println!("Hello, world!");
}
