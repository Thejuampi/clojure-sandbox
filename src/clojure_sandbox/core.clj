(ns clojure-sandbox.core)

(defn is-palindrome [str]
  (cond
    (= 0 (count str)) true
    (= 1 (count str)) true
    :else
    (and
      (= (first str) (last str))
      (is-palindrome (subs str 1 (dec (count str)))))))



(defn _map [mapFn list]
  (if (empty? list)
    list
    (cons
      (mapFn (first list))
      (_map mapFn (rest list)))))



(defn reverse-list [list]
  (if (empty? list)
    list
    (cons
      (last list)
      (reverse-list (butlast list)))))



(defn fibonacci [n]
  (cond
    (neg? n) (throw (IllegalArgumentException. (str n)))
    (zero? n) [0]
    (= n 1) [0 1]
    :else
    (let [fibo-1 (fibonacci (dec n))]
      (conj
        fibo-1
        (+
          (last fibo-1)
          (last (butlast fibo-1)))))))



(defn factorial-recursive [n]
  (cond
    (neg? n) (throw (IllegalArgumentException. (str n)))
    (zero? n) 1
    (= 1 n) 1
    :else (* n (factorial-recursive (dec n)))))



(defn factorial-for [n]
  (cond
    (neg? n) (throw (IllegalArgumentException. (str n)))
    (zero? n) 1
    :else (let [result (atom 1)]
            (dorun
              (for [i (range 1 (inc n))]
                (swap! result #(* i %))))
            @result)))



(defn factorial-reduce [n]
  (if
    (neg? n) (throw (IllegalArgumentException. (str n)))
             (reduce * (range 1 (inc n)))))



(defn factorial [n] (factorial-reduce n))


(defn not-empty? [str]
  (pos? (count str)))

(def validations
  {:name {:fn not-empty? :err "value is empty"}})


(defn validate-form [form]
  {:name {
          :val (-> form :name :val)
          :err (if (empty? (-> form :name :val)) "name is empty" nil)}})


(defn validate [fn x err]
  (if (fn x)
    nil
    err))


(defn validate-form-2 [form validations]
  {:name (let [value (get-in form [:name :val])
               error (get-in validations [:name :err])
               validation-result (validate (get-in validations [:name :fn]) value error)]
           {:val value
            :err validation-result})})