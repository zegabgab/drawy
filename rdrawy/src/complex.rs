use std::ops::{Add, Mul, Sub};

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

    pub fn abs(self) -> f64 {
        (self.real * self.real + self.imag * self.imag).sqrt()
    }
}

impl Add for Complex {
    type Output = Self;

    fn add(self, rhs: Self) -> Self::Output {
        Self::new(self.real + rhs.real, self.imag + rhs.imag)
    }
}

impl Sub for Complex {
    type Output = Self;

    fn sub(self, rhs: Self) -> Self::Output {
        Self::new(self.real - rhs.real, self.imag - rhs.imag)
    }

}

impl Mul for Complex {
    type Output = Self;

    fn mul(self, rhs: Complex) -> Self::Output {
        Complex::new(
            self.real * rhs.real - self.imag * rhs.imag,
            self.real * rhs.imag + self.imag * rhs.real,
        )
    }
}
