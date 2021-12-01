(ns advent-of-code-2021.day-1-sonar-sweep.sonar-sweep
  (:use advent-of-code-2021.utils)
  (:require [clojure.java.io :as io]))

(def input (read-file (io/resource "day-1-sonar-sweep.txt")))
(def input-extended (read-file (io/resource "day-1-sonar-sweep-extended.txt")))

(defn count-increasing [seq-of-pairs]
  (reduce
    (fn [count pair]
      (if (< (first pair) (second pair))
        (inc count)
        count))
    0
    seq-of-pairs))


(defn sonar-sweep [input]
  (->> (map #(Integer/parseInt %) input)
       (concat [nil])
       (partition 2 1)
       (rest)                                               ; Ignore the first element as it can't be compared anyway
       (count-increasing)))

(defn sonar-sweep-extended [input]
  (->> (map #(Integer/parseInt %) input)
       (concat [nil])
       (partition 3 1)
       (rest)                                               ; Ignore the first element as it can't be compared anyway
       (map #(reduce + %))
       (partition 2 1)
       (count-increasing)))