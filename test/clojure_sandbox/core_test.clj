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