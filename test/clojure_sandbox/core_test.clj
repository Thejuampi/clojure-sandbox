(ns clojure-sandbox.core-test
  (:require [clojure.test :refer :all]
            [clojure-sandbox.core :refer :all]))

(deftest test-is-palindrome
  (testing "is-palindrome function"
    (is (is-palindrome ""))
    (is (is-palindrome "a"))
    (is (is-palindrome "aa"))
    (is (not (is-palindrome "ab")))))

(deftest test-_map
  (testing "Function application over a collection"
    (is (= (_map inc [1 2 3]) [2 3 4]))
    (is (= (_map #(* % %) [1 2 3]) [1 4 9]))
    (is (= (_map str ["Hello, " "World!"]) ["Hello, " "World!"]))
    (is (= (_map char []) []))))

(deftest test-reverse-list
  (testing "List reversal"
    (is (= (reverse-list [1 2 3]) [3 2 1]))
    (is (= (reverse-list ["a" "b" "c"]) ["c" "b" "a"]))
    (is (= (reverse-list []) []))
    (is (= (reverse-list [1]) [1]))
    (is (= (reverse-list [[1 2] [3 4] [5 6]]) [[5 6] [3 4] [1 2]]))))

(deftest test-fibonacci
  (testing "Fibonacci sequence generation"
    (is (= (fibonacci 0) [0]))
    (is (= (fibonacci 1) [0 1]))
    (is (= (fibonacci 2) [0 1 1]))
    (is (= (fibonacci 3) [0 1 1 2]))
    (is (= (fibonacci 6) [0 1 1 2 3 5 8]))
    (is (= (fibonacci 10) [0 1 1 2 3 5 8 13 21 34 55]))

    (testing "Negative input"
      (is (thrown? IllegalArgumentException (fibonacci -1)))
      (is (thrown? IllegalArgumentException (fibonacci -5))))))

(deftest test-factorial
  (testing "Factorial calculation"
    (is (= (factorial 0) 1))
    (is (= (factorial 1) 1))
    (is (= (factorial 5) 120))
    (is (= (factorial 10) 3628800))
    (is (= (factorial 12) 479001600)))

  (testing "Factorial-recursive calculation"
    (is (= (factorial-recursive 0) 1))
    (is (= (factorial-recursive 1) 1))
    (is (= (factorial-recursive 5) 120))
    (is (= (factorial-recursive 10) 3628800))
    (is (= (factorial-recursive 12) 479001600)))

  (testing "Equality of results"
    (is (= (factorial 7) (factorial-recursive 7)))
    (is (= (factorial 9) (factorial-recursive 9)))
    (is (= (factorial 11) (factorial-recursive 11)))))