(ns clojure-sandbox.core-test
  (:require [clojure.test :refer :all]
            [clojure-sandbox.core :refer :all]))

(deftest test-is-palindrome
  (testing "is-palindrome function"
    (is (is-palindrome ""))
    (is (is-palindrome "a"))
    (is (is-palindrome "aa"))
    (is (not (is-palindrome "ab")))))