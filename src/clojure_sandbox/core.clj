(ns clojure-sandbox.core)

(defn is-palindrome [str]
  (cond
    (= 0 (count str)) true
    (= 1 (count str)) true
    :else
    (and
      (= (first str) (last str))
      (is-palindrome (subs str 1 (dec (count str)))))
    )
  )