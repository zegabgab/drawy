use crate::complex::*;

pub fn mandelbrot_contains(number: Complex, max_iterations: u32) -> bool {
    std::iter::successors(Some(Complex::ZERO), |predecessor| {
        let predecessor = *predecessor;
        Some(predecessor * predecessor + number)
    })
    .take(max_iterations as usize)
    .all(|complex| complex.is_within(1000.))
}

#[test]
fn zero_contained() {
    assert!(mandelbrot_contains(Complex::ZERO, 10000))
}

#[test]
fn one_not_contained() {
    assert!(!mandelbrot_contains(Complex::new(1., 0.), 10000))
}

#[test]
fn negative_one_contained() {
    assert!(mandelbrot_contains(Complex::new(-1., 0.), 10000))
}
