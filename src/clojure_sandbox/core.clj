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

(defn _map [mapFn list]
  (if (empty? list)
    list
    (cons
      (mapFn (first list))
      (_map mapFn (rest list)))
    )
  )

(defn reverse-list [list]
  (if (empty? list)
    list
    (cons
      (last list)
      (reverse-list (butlast list))
      )
    )
  )