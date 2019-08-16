module Main where
import System.Environment

main =
  do
    print(factorial 3)

factorial 0 = 1
factorial n = n * factorial(n-1)


whatisn n
  | n == 0 = "zero"
  | even n = "even"
  | otherwise = "odd"


factorial1 n = loop n 1
  where loop n a
          | n == 0 = a
          | otherwise = loop (n - 1) (a * n)

factorial2 n = loop n 1
  where loop n a
          | n == 0 = a
          | otherwise = loop (n-1) (n * jna)
