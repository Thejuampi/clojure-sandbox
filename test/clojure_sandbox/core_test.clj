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