use std::ops::{Add, Mul};

#[derive(Clone, Copy, Debug, PartialEq)]
pub struct Complex {
    real: f64,
    imag: f64,
}

impl Complex {
    pub const ZERO: Self = Self::new(0., 0.);

    pub const fn new(real: f64, imag: f64) -> Self {
        Complex { real, imag }
    }

    pub fn is_within(self, radius: f64) -> bool {
        self.real * self.real + self.imag * self.imag <= radius * radius
    }
}

impl Add for &Complex {
    type Output = Complex;

    fn add(self, rhs: Self) -> Self::Output {
        Complex::new(self.real + rhs.real, self.imag + rhs.imag)
    }
}

impl Add for Complex {
    type Output = Self;

    fn add(self, rhs: Self) -> Self::Output {
        &self + &rhs
    }
}

impl Mul for &Complex {
    type Output = Complex;

    fn mul(self, rhs: Self) -> Self::Output {
        Complex::new(
            self.real * rhs.real - self.imag * rhs.imag,
            self.real * rhs.imag + self.imag * rhs.real,
        )
    }
}

impl Mul for Complex {
    type Output = Self;

    fn mul(self, rhs: Complex) -> Self::Output {
        &self + &rhs
    }
}
