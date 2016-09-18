def partial1[A, B, C](a: A, f: (A, B) => C): B => C =
  b => f(a,b)


def curry[A, B, C](f: (A, B) => C): A => (B => C) =
  (a: A) => (b: B) => f(a,b)


def uncurry[A, B, C](f: A => B => C): (A, B) => C =
  (a: A, b: B) => f(a)(b) // This is equivalent to write (a,b) => f.apply(a).apply(b)


def compose[A, B, C](f: A => B, g: B => C): A => C =
  (a: A) => g(f(a))
