import Data.List

needleInStack :: (Eq a) => [a] -> [a] -> Bool
needleInStack xs1 [] = False
needleInStack xs1 xs2
  | xs1 `isPrefixOf` xs2 = True
  | otherwise = needleInStack xs1 (tail xs2)
